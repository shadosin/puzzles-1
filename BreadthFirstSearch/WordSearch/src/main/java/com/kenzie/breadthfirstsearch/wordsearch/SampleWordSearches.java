package com.kenzie.breadthfirstsearch.wordsearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Sample word search puzzles for testing.
 */
public class SampleWordSearches {
    private static final char[][] SORE_PATTERN = {
        {'s', 'o', 'r', 'e'},
        {'o', 'o', 'x', 'x'},
        {'r', 'x', 'r', 'x'},
        {'e', 'x', 'x', 'e'}
    };

    public static final WordSearch SORE_SEARCH = new WordSearch(4, 4,
        SORE_PATTERN, Collections.singletonList("sore"));


    private static final char[][] ABRACADABRA_PATTERN = {
        {'a', 'b', 'r', 'a', 'c', 'a'},
        {'b', 'r', 'a', 'c', 'a', 'd'},
        {'r', 'a', 'c', 'a', 'd', 'a'},
        {'a', 'c', 'a', 'd', 'a', 'b'},
        {'c', 'a', 'd', 'a', 'b', 'r'},
        {'a', 'd', 'a', 'b', 'r', 'a'},
    };

    public static final WordSearch ABRACADABRA_SEARCH = new WordSearch(6, 6,
        ABRACADABRA_PATTERN, Collections.singletonList("abracadabra"));

    /**
     * This puzzle was original part of the 2021 Puzzle Quest.
     * https://tiny.amazon.com/84o90no7/puzzleQuest
     */
    private static final char[][] FROZEN_VILLAGE_SEARCH_PATTERN = {
        {'f', 's', 'e', 'm', 'b', 'e', 'r', 'f', 'r', 'o', 'r'},
        {'i', 'e', 't', 'i', 'n', 'g', 'i', 'e', 'e', 't', 'f'},
        {'r', 'a', 'i', 'n', 'd', 'r', 'c', 'r', 'b', 'o', 'i'},
        {'e', 'u', 'n', 'k', 'e', 'n', 't', 'i', 'm', 'm', 'r'},
        {'k', 't', 'g', 'r', 'i', 'k', 'b', 'f', 'e', 'd', 'e'},
        {'i', 'u', 'i', 'k', 'i', 'n', 'd', 'l', 'e', 'z', 'b'},
        {'n', 'f', 'p', 'n', 'l', 'i', 'd', 'c', 'a', 'l', 'm'},
        {'d', 'a', 'd', 'f', 'g', 'n', 'b', 'l', 'a', 'z', 'e'},
        {'l', 'l', 'i', 't', 'i', 'i', 'b', 'z', 'e', 'e', 'e'},
        {'e', 'r', 'w', 'k', 'o', 'r', 'e', 'm', 'b', 'e', 'r'},
        {'e', 'r', 'i', 'f', 'r', 'd', 'e', 'r', 'i', 'f', 's'}
    };

    private static final List<String> FROZEN_VILLAGE_SEARCH_WORDS_TO_FIND = Arrays.asList(
        "blaze", "ember", "fire", "ignite", "kindle");

    /**
     * This puzzle was original part of the 2021 Puzzle Quest.
     * https://tiny.amazon.com/84o90no7/puzzleQuest
     *
     * Please note that we are using different rules, so word counts  will differ from the puzzle's original solution
     */
    public static final WordSearch FROZEN_VILLAGE_SEARCH = new WordSearch(11, 11,
        FROZEN_VILLAGE_SEARCH_PATTERN, FROZEN_VILLAGE_SEARCH_WORDS_TO_FIND);

    private SampleWordSearches(){}
}
