package com.kenzie.gettingstarted.coins;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class KenzieCoinsFindPairsValidationTest {

    KenzieCoinsTest baseTest = new KenzieCoinsTest();

    @ParameterizedTest
    @MethodSource("findPairsValidationCases")
    void AnyPairValidationTest(int input, List<Integer> values, List<Pair> expected) {
        baseTest.findPairsThatSumToBalance(input, values, expected);
    }

    static Stream<Arguments> findPairsValidationCases() {
        return Stream.concat(KenzieCoinsTest.pairSumTestCases(), Stream.of(
                Arguments.of(12, Arrays.asList(6, 6), Collections.singletonList(Pair.of(6, 6))),
                Arguments.of(12, Arrays.asList(6, 4), Collections.emptyList()),
                Arguments.of(10, Arrays.asList(10, 8, 2, 3, 7, 1), Arrays.asList(Pair.of(8, 2), Pair.of(3, 7)))
        ));
    }
}
