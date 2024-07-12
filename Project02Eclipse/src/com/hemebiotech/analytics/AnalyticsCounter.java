package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class processes symptom data by reading symptoms, counting their occurrences,
 * sorting them (if necessary), and writing them to an output file.
 */
public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	/**
	 * Constructs an AnalyticsCounter object with a given ISymptomReader and ISymptomWriter.
	 *
	 * @param reader The symptom reader to use.
	 * @param writer The symptom writer to use.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}

	/**
	 * Processes the symptoms: reads them, counts occurrences, sorts them (if necessary), and writes them to output.
	 */
	public void process() {
		// Retrieve the list of symptoms
		List<String> symptoms = getSymptoms();

		// Count the symptoms
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);

		// Sort the symptoms (if necessary)
		Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);

		// Write the symptoms to the output file
		writeSymptoms(sortedSymptoms);
	}

	/**
	 * Retrieves the list of symptoms using the symptom reader.
	 *
	 * @return A list of symptoms read from the data source.
	 */
	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in the given list.
	 *
	 * @param symptoms The list of symptoms to count.
	 * @return A map containing each symptom and its count.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	/**
	 * Sorts the symptoms map alphabetically by symptom name.
	 *
	 * @param symptoms The map of symptoms to sort.
	 * @return The sorted map of symptoms.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Writes the symptoms and their counts to the output using the symptom writer.
	 *
	 * @param symptoms The map of symptoms to write.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
