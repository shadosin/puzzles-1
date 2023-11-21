package com.kenzie.gettingstarted.coins;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KenzieCoinsAnyPairValidationTest {

    KenzieCoinsTest baseTest = new KenzieCoinsTest();

    @ParameterizedTest
    @MethodSource("anyPairValidationCases")
    void AnyPairValidationTest(int input, List<Integer> values, boolean expected) {
        baseTest.anyPairSumsToBalance(input, values, expected);
    }

    static Stream<Arguments> anyPairValidationCases() {
        return Stream.concat(KenzieCoinsTest.whetherPairSumTestCases(), Stream.of(
                Arguments.of(12, Arrays.asList(6, 6), true),
                Arguments.of(12, Arrays.asList(6, 4), false),
                Arguments.of(10, Arrays.asList(10, 8, 2, 3, 7, 1), true)
        ));
    }
}

