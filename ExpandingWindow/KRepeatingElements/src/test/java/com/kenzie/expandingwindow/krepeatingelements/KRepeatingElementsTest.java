package com.kenzie.expandingwindow.krepeatingelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KRepeatingElementsTest {
    @ParameterizedTest
    @MethodSource("testCases")
    public void findLongestSubstringWithKRepeatingElements(String s, int k, int expected) {
        int result = KRepeatingElements.kRepeatingElements(s, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aaabb", 3, 3),
                Arguments.of("baacb", 2, 2),
                Arguments.of("ababbc", 2, 5),
                Arguments.of("abcdefg", 1, 7),
                Arguments.of("abcdefg", 3, 0),
                Arguments.of("balloon", 2, 4),
                Arguments.of("abababababababababab", 10, 20),
                Arguments.of("bbbaaabb", 3, 8),
                Arguments.of("bbbaaabbcdef", 3, 8),
                Arguments.of("cdefbbbaaabb", 3, 8)
        );
    }
}
