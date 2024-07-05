package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) {
		String inputFile = "symptoms.txt";
		String outputFile = "result.out";

		// Lecture des symptômes depuis le fichier
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(inputFile);
		List<String> symptoms = symptomReader.GetSymptoms();

		// Comptage des symptômes
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);

		// Écriture des symptômes dans le fichier de sortie
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile(outputFile);
		symptomWriter.writeSymptoms(symptomCounts);
	}

	private static Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			if (symptomCounts.containsKey(symptom)) {
				symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
			} else {
				symptomCounts.put(symptom, 1);
			}
		}

		return symptomCounts;
	}
}
