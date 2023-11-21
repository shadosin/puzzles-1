package com.kenzie.gettingstarted.balance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BalancedParensIDoValidationTest {

    BalancedParensTest baseTest = new BalancedParensTest();

    @ParameterizedTest
    @MethodSource("iDoValidationCases")
    void iDoBalancedParensValidationTest(String input, boolean expected) {
        baseTest.iDoBalancedParensTest(input, expected);
    }

    static Stream<Arguments> iDoValidationCases() {
        return Stream.concat(BalancedParensTest.iDoTestCases(), Stream.of(
            Arguments.of(")", false),
            Arguments.of("(", false),
            Arguments.of("(((()))()", false),
            Arguments.of("((())))", false),
            Arguments.of("(((()))", false),
            Arguments.of("()()()()()()", true)
        ));
    }
}
