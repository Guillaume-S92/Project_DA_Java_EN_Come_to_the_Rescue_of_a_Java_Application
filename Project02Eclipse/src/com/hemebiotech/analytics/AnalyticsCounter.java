package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}

	public void process() {
		// Récupérer la liste des symptômes
		List<String> symptoms = getSymptoms();

		// Compter les symptômes
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);

		// Trier les symptômes
		Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);

		// Écrire les symptômes dans le fichier de sortie
		writeSymptoms(sortedSymptoms);
	}

	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Ici, nous pourrions implémenter un tri par ordre alphabétique si nécessaire
		return symptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

	public static void main(String[] args) {
		String inputFile = "Project02Eclipse/symptoms.txt";
		String outputFile = "result.out";

		// Créer une instance de AnalyticsCounter
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(inputFile);
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile(outputFile);
		AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);

		// Appeler la méthode process pour exécuter toutes les actions
		counter.process();
	}
}
