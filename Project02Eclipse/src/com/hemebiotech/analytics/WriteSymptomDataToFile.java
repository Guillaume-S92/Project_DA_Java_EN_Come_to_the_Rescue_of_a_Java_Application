package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String outputFile;

    public WriteSymptomDataToFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(outputFile);

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            System.out.println("File '" + outputFile + "' created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
