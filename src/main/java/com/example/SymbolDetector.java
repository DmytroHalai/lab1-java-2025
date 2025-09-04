package com.example;

public class SymbolDetector {
    public String calculateMinUniqueSymbols(String input) {
        if (isStringNull(input)) {return null;}
        if (isStringEmpty(input)) {return "";}
        final String SPACE = "\\s+";
        String[] words = input.split(SPACE);
        String bestWord = null;
        int minUniqueSymbols = Integer.MAX_VALUE;

        for (String word : words) {
            if (word.isEmpty()) continue;
            int uniqueSymbolsNumber = countUniqueSymbols(word);
            if (uniqueSymbolsNumber < minUniqueSymbols) {
                minUniqueSymbols = uniqueSymbolsNumber;
                bestWord = word;
            }
        }
        return bestWord == null ? "No words found in the input string" : bestWord;
    }

    private boolean isStringEmpty(String input) {
        return input.trim().isEmpty();
    }

    private boolean isStringNull(String input) {
        return input == null;
    }

    private int countUniqueSymbols(String word) {
        return (int) word.codePoints().distinct().count();
    }
}
