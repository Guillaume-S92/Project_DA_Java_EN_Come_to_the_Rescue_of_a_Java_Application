package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms and their occurrences to a specific destination.
     *
     * @param symptoms The map of symptoms to write.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
