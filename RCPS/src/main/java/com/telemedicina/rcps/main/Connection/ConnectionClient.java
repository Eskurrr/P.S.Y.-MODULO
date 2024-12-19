package com.telemedicina.rcps.main.Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class ConnectionClient extends Thread {
    protected List<Float> Data = new ArrayList<Float>();
    protected boolean Stop = false;
    protected String adress;
    protected int port;
    protected List<Integer> bpms;
    protected int times;
    public ConnectionClient(String adress, int port) {
        this.adress = adress;
        this.port = port;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public void run() {
        Connect(adress, port);
    }
    public void Connect(String address, int port) {
        try {
            // Establish a connection to the server
            Socket socket = new Socket(address, port);
            System.out.println("Connected to server at " + address + ":" + port);
            DataOutputStream Out = new DataOutputStream(socket.getOutputStream());
            DataInputStream In = new DataInputStream(socket.getInputStream());
            socket.setSoTimeout(5000);
            while (true) {
                try {
                    // Read the byte array
                    int arrayLength = 125; // We know the array size in advance
                    byte[] byteArray = new byte[arrayLength * Float.BYTES]; // Each float is 4 bytes
                    In.readFully(byteArray); // Read the entire byte array

                    // Create a ByteBuffer to unpack the bytes
                    ByteBuffer buffer = ByteBuffer.wrap(byteArray);
                    buffer.order(ByteOrder.BIG_ENDIAN); // Ensure the byte order is correct

                    // Unpack the byte array into a List<Float>
                    List<Float> receivedList = new ArrayList<>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        float value = buffer.getFloat(); // Read each float
                        receivedList.add(value);
                    }
                    getData().addAll(receivedList);
                    times++;
                    if(times == 4){
                        int samplingRate = 250; // Your sampling rate
                        getBpms().add(calculateBPM(getData(), samplingRate));
                        System.out.println("Calculated BPM: " + getBpms().getLast());
                        times = 0;
                    }
                    Out.writeBoolean(isStop());
                } catch (SocketTimeoutException e) {
                    System.out.println("Connection lost or server is not responding.");
                    break; // Exit the loop if a timeout occurs
                } catch (IOException e) {
                    e.printStackTrace();
                    break; // Exit the loop on other I/O exceptions
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Integer> detectPeaks(List<Float> signal) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < signal.size() - 1; i++) {
            if (signal.get(i) > signal.get(i - 1) && signal.get(i) > signal.get(i + 1)) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static int calculateBPM(List<Float> signal, int samplingRate) {
        List<Integer> peaks = detectPeaks(signal);
        List<Float> IBIs = new ArrayList<>();
        for (int i = 1; i < peaks.size(); i++) {
            float ibi = (peaks.get(i) - peaks.get(i - 1)) / (float)samplingRate; // IBI in seconds
            IBIs.add(ibi);
        }
        // Calculate BPM
        float averageIBI = IBIs.stream().reduce(0.0f, Float::sum) / IBIs.size();
        return Math.round(60 / averageIBI); // BPM as an integer
    }

    public boolean isStop() {
        return Stop;
    }
    public void setStop(boolean stop) {
        Stop = stop;
    }
    public List<Float> getData() {
        return Data;
    }
    public void setData(List<Float> data) {
        Data = data;
    }

    public List<Integer> getBpms() {
        return bpms;
    }

    public void setBpms(List<Integer> bpms) {
        this.bpms = bpms;
    }
}
