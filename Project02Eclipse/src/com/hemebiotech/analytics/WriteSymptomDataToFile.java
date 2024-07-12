package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data and their occurrences to a specified output file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String outputFile;

    /**
     * Constructor for WriteSymptomDataToFile.
     *
     * @param outputFile The path to the output file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Writes symptom data and their occurrences to the specified output file.
     *
     * @param symptoms The map of symptoms and their counts to write.
     */
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
