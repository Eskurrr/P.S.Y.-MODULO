package com.telemedicina.rcps.main.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Json{

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // EXE or JAR directory detection
    private static final Path APP_DIRECTORY = getAppDirectory();

    private static Path getAppDirectory() {
        try {
            File jarFile = new File(Json.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI());
            return jarFile.getParentFile().toPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Paths.get("."); // Default to current directory
    }

    private Path getFilePath(String fileName) {
        return APP_DIRECTORY.resolve(fileName);
    }

    // Copy files from resources to writable location
    private void copyFileFromJarToWritableLocation(String fileName) {
        // Define a writable location (e.g., user's home directory or app data directory)
        String userHome = System.getProperty("user.home");
        Path writableFolder = Paths.get(userHome, "YourAppData"); // Change "YourAppData" to your preferred directory
        if (!Files.exists(writableFolder)) {
            try {
                Files.createDirectories(writableFolder); // Create the folder if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Define the writable file path
        Path writableFile = writableFolder.resolve(fileName);

        // If the file doesn't already exist in the writable location, copy it from the JAR
        if (!Files.exists(writableFile)) {
            try (InputStream inputStream = getClass().getResourceAsStream("/com/telemedicina/rcps/json/" + fileName)) {
                if (inputStream == null) {
                    throw new FileNotFoundException("File " + fileName + " not found in resources.");
                }
                Files.copy(inputStream, writableFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to get the writable file path for each JSON
    private Path getWritableFilePath(String fileName) {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome, "YourAppData", fileName); // Change the "YourAppData" to your preferred folder
    }

    // Write method
    public void Serializar(List<Dispositivo> devices) {
        String fileName = "measures.json";
        copyFileFromJarToWritableLocation(fileName); // Ensure file exists in writable location

        try (FileWriter writer = new FileWriter(getWritableFilePath(fileName).toFile())) {
            gson.toJson(devices, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Read method
    public List<Dispositivo> Desserializar() {
        List<Dispositivo> devices = new ArrayList<>();
        String fileName = "measures.json";
        copyFileFromJarToWritableLocation(fileName);

        try (Reader reader = new FileReader(getWritableFilePath(fileName).toFile())) {
            Type tipo = new TypeToken<List<Dispositivo>>(){}.getType();
            devices = gson.fromJson(reader, tipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devices;
    }
}
