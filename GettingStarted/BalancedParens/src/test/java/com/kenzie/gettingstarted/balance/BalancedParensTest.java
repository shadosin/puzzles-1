package com.kenzie.gettingstarted.balance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedParensTest {

    BalancedParens solutions = new BalancedParens();

    @ParameterizedTest
    @MethodSource("iDoTestCases")
    public void iDoBalancedParensTest(String input, boolean expected) {
        boolean result = solutions.areParensBalanced(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("weDoTestCases")
    public void weDoBalancedParensTest(String input, boolean expected) {
        boolean result = solutions.areEnclosuresBalanced(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("youDoTestCases")
    public void youDoBalancedParensTest(String input, boolean expected) {
        boolean result = solutions.theSmileyMethod(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> iDoTestCases() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of("()", true),
            Arguments.of("(())", true),
            Arguments.of("(()())", true),
            Arguments.of("()()", true),
            Arguments.of("())", false),
            Arguments.of("(()", false)
        );
    }

    public static Stream<Arguments> weDoTestCases() {
        return Stream.concat(iDoTestCases(), Stream.of(
            Arguments.of("{}", true),
            Arguments.of("[]", true),
            Arguments.of("({})", true),
            Arguments.of("([])", true),
            Arguments.of("({}[])", true),
            Arguments.of("({[]})", true),
            Arguments.of("({})", true),
            Arguments.of("(){}", true),
            Arguments.of("(){}", true),
            Arguments.of("({)}", false),
            Arguments.of("({})[", false)
        ));
    }

    public static Stream<Arguments> youDoTestCases() {
        return Stream.concat(weDoTestCases(), Stream.of(
            Arguments.of("(:))", true),
            Arguments.of("({:]})", true),
            Arguments.of("({}):[", true),
            Arguments.of("(:)", false),
            Arguments.of("(:-)", true)
        ));
    }
}
