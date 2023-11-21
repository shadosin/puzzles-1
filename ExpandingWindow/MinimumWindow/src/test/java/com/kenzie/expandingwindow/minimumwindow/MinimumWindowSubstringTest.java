package com.kenzie.expandingwindow.minimumwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSubstringTest {
    @ParameterizedTest
    @MethodSource("testCases")
    public void findMinimumWindowSubstring(String s, String t, String expected) {
        String result = MinimumWindowSubstring.minimumWindowSubstring(s, t);
        assertEquals(expected, result);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", ""),
                Arguments.of("testing", "gnt", "ting"),
                Arguments.of("bananas", "bs", "bananas"),
                Arguments.of("CaSiNg", "c", ""),
                Arguments.of("community", "mom", "omm")
        );
    }
}
