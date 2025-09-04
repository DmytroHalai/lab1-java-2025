package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SymbolDetectorTest {
    private final SymbolDetector symbolDetector = new SymbolDetector();
    @Test
    void testNullInput() {
        String result = symbolDetector.calculateMinUniqueSymbols(null);
        assertNull(result);
    }

    @Test
    void testOnlySpacesInput() {
        String result = symbolDetector.calculateMinUniqueSymbols("   ");
        assertEquals("", result, "Expected empty string for input with only spaces");
    }

    @Test
    void testEmptyInput() {
        String result = symbolDetector.calculateMinUniqueSymbols("");
        assertEquals("", result, "Expected empty string for empty input");
    }

    @Test
    void testSingleWordInput() {
        String result = symbolDetector.calculateMinUniqueSymbols("hello");
        assertEquals("hello", result, "Expected 'hello' for single word input");
    }

    @Test
    void testMultipleWordsInput() {
        String result = symbolDetector.calculateMinUniqueSymbols("apple banana kiwi");
        assertEquals("banana", result, "Expected 'banana' for input with multiple words");
    }

    @Test
    void testWordsWithSameUniqueSymbols() {
        String result = symbolDetector.calculateMinUniqueSymbols("abc ab ac");
        assertEquals("ab", result, "Expected 'ab' for input with words having same unique symbols");
    }

    @Test
    void testInputWithPunctuation() {
        String result = symbolDetector.calculateMinUniqueSymbols("hello, world! hi.");
        assertEquals("hi.", result, "Expected 'hi.' for input with punctuation");
    }

    @Test
    void testInputWithMixedCase() {
        String result = symbolDetector.calculateMinUniqueSymbols("Apple apple APPLE");
        assertEquals("Apple", result, "Expected 'Apple' for input with mixed case");
    }

    @Test
    void testInputWithSpecialCharacters() {
        String result = symbolDetector.calculateMinUniqueSymbols("!@# $%^ &*()");
        assertEquals("!@#", result, "Expected '!@#' for input with special characters");
    }

    @Test
    void testInputWithNumbers() {
        String result = symbolDetector.calculateMinUniqueSymbols("123 4567 89");
        assertEquals("89", result, "Expected '89' for input with numbers");
    }

    @Test
    void testInputWithUnicodeCharacters() {
        String result = symbolDetector.calculateMinUniqueSymbols("hello \uD83D\uDE04");
        assertEquals("\uD83D\uDE04", result, "Expected '\uD83D\uDE04' for input with Unicode characters");
    }
}
