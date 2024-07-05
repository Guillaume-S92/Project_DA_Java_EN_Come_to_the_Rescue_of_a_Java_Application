package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) {
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			// Lecture du fichier symptoms.txt
			reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();

			while (line != null) {
				System.out.println("Symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("Number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine(); // Lire la ligne suivante
			}

			// Écriture dans le fichier result.out
			writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");

			System.out.println("File 'result.out' created successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Fermeture des ressources
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
