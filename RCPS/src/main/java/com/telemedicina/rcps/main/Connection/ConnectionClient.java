package com.telemedicina.rcps.main.Connection;

import com.telemedicina.rcps.main.data.Devices;

import java.util.ArrayList;
import java.util.List;

public class ConnectionClient extends Devices {
    protected List<Float> Data = new ArrayList<Float>();
    protected boolean Stop = false;
    protected List<Integer> bpms;
    protected int times;

    public void run() {
        Connect();
    }
    public void Connect() {
            setBpms(new ArrayList<>());
            for(int j = 0; j < getDispositivos().size(); j++) {
                    List<Float> receivedList = new ArrayList<>();
                    List<Float> sendList = getDispositivos().get(j).getMedida();
                    receivedList.addAll(sendList);
                    getData().addAll(receivedList);
                        int samplingRate = 40; // Your sampling rate
                        getBpms().add(calculateBPM(getData(), samplingRate));
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
        return Math.round(60 / averageIBI) - 100; // BPM as an integer
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
