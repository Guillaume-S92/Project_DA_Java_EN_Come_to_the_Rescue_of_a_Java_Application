package com.hemebiotech.analytics;

public class Main {

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
