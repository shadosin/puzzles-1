package com.kenzie.gettingstarted.coins;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KenzieCoinsTest {

    KenzieCoins coins = new KenzieCoins();

    @ParameterizedTest
    @MethodSource("whetherPairSumTestCases")
    public void anyPairSumsToBalance(int balance, List<Integer> values, boolean expected) {
        boolean result = coins.anyPairSumsToBalance(balance, values);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("pairSumTestCases")
    public void findPairsThatSumToBalance(int balance, List<Integer> values, List<Pair> expected) {
        List<Pair> result = coins.findPairsThatSumToBalance(balance, values);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @SuppressWarnings("unchecked")
    public static Stream<Arguments> whetherPairSumTestCases() {
        return pairSumTestCases()
            .map(arguments -> {
                Object[] args = arguments.get();
                return Arguments.of(args[0], args[1], !((List<Pair>)args[2]).isEmpty());
            });
    }

    public static Stream<Arguments> pairSumTestCases() {
        return Stream.of(
            Arguments.of(10, Arrays.asList(1, 2, 3, 7, 8, 10), Arrays.asList(Pair.of(2, 8), Pair.of(3, 7))),
            Arguments.of(10, Arrays.asList(1, 3, 3, 7, 8, 10), Arrays.asList(Pair.of(3, 7), Pair.of(3, 7))),
            Arguments.of(10, Arrays.asList(1, 3, 3, 8, 10), Collections.emptyList()),
            Arguments.of(10, Arrays.asList(1, 9), Collections.singletonList(Pair.of(1, 9))),
            Arguments.of(10, Collections.singletonList(10), Collections.emptyList())
        );
    }
}
