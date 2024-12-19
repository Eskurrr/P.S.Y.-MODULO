package com.telemedicina.rcps.main.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

public class Save {
        public void Serialize(List<Float> floatList) {
            floatList = new ArrayList<>();
            floatList.add(1.23f);
            floatList.add(4.56f);
            floatList.add(7.89f);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(floatList);
            System.out.println("Serialized JSON:");
            System.out.println(json);
        }
        public List<Float> Deserialize() {
            Gson gson = new Gson();
            String json = gson.toJson(Float.parseFloat("1.23"));
            System.out.println("Deserialized JSON:");
            System.out.println(json);
            return gson.fromJson(json, List.class);
        }
}
