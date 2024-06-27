package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {

	public static void main(String[] args) {
		// Path to the file containing symptoms
		String filepath = "Project02Eclipse/symptoms.txt";

		// Read symptoms from file
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		List<String> symptoms = reader.GetSymptoms();

		// Count occurrences of each symptom
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);

		// Write results to file
		writeResults(symptomCounts, "result.out");
	}

	private static Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	private static void writeResults(Map<String, Integer> symptomCounts, String outputPath) {
		try (FileWriter writer = new FileWriter(outputPath)) {
			for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
