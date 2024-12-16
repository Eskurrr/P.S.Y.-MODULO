package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.Connection.ConnectionClient;

import java.util.List;

public class MAAINCONTROLLER {
    protected ConnectionClient client;

    public void StartClicked(){
        client = new ConnectionClient("192.168.1.100" , 12345);
        client.start();
    }
    public void Draw(){
        List<Float> measures = client.getData();
    }
}
