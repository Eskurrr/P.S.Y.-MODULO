package com.telemedicina.rcps.main.Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionClient extends Thread {
    protected List<Integer> Data = new ArrayList<Integer>();
    public List<Integer> getData() {
        return Data;
    }
    public void setData(List<Integer> data) {
        Data = data;
    }
    protected boolean Stop = false;
    public boolean isStop() {
        return Stop;
    }
    public void setStop(boolean stop) {
        Stop = stop;
    }
    protected String adress;
    protected int port;
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
                    int recieved = In.readInt();
                    getData().add(recieved);
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
}
