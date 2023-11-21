package com.kenzie.gettingstarted.balance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BalancedParensWeDoValidationTest {

    BalancedParensTest baseTest = new BalancedParensTest();

    @ParameterizedTest
    @MethodSource("weDoValidationCases")
    void weDoBalancedParensTest(String input, boolean expected) {
        baseTest.weDoBalancedParensTest(input, expected);
    }

    static Stream<Arguments> weDoValidationCases() {
        String longBalancedString = "(((){[([()])]}))[[[]({[{[]}]})]]";
        List<String> longUnbalancedStrings = new ArrayList<>();
        longUnbalancedStrings.add(longBalancedString.substring(1));
        int last = longBalancedString.length() - 1;
        for (int i = 1; i < last; i++) {
            longUnbalancedStrings.add(longBalancedString.substring(0, i) + longBalancedString.substring(i + 1));
        }
        longUnbalancedStrings.add(longBalancedString.substring(0, last));
        Stream<Arguments> longCases = longUnbalancedStrings.stream()
            .map(s -> Arguments.of(s, false));
        return Stream.concat(Stream.concat(BalancedParensTest.weDoTestCases(), Stream.of(
            Arguments.of("}", false),
            Arguments.of("{", false),
            Arguments.of("]", false),
            Arguments.of("[", false),
            Arguments.of("(}", false),
            Arguments.of("()[]{}", true),
            Arguments.of("[{}[]]", true),
            Arguments.of("[{}]()", true),
            Arguments.of("()[{]}", false),
            Arguments.of(longBalancedString, true)
        )), longCases);
    }
}
