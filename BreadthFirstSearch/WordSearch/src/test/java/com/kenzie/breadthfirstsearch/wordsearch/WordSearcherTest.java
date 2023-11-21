package com.kenzie.breadthfirstsearch.wordsearch;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;


import static com.kenzie.breadthfirstsearch.wordsearch.SampleWordSearches.ABRACADABRA_SEARCH;
import static com.kenzie.breadthfirstsearch.wordsearch.SampleWordSearches.FROZEN_VILLAGE_SEARCH;
import static com.kenzie.breadthfirstsearch.wordsearch.SampleWordSearches.SORE_SEARCH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WordSearcherTest {

    private static final char[][] EMPTY_SEARCH_PATTERN = {};

    private static final WordSearch EMPTY_SEARCH = new WordSearch(0,0,
        EMPTY_SEARCH_PATTERN, Collections.singletonList("word"));

    private static final char[][] NO_MATCH_WORDS_PATTERN = {
        {'a', 'b', 'b', 'a'}
    };

    private static final WordSearch NO_MATCH_SEARCH = new WordSearch(4,1,
        NO_MATCH_WORDS_PATTERN, Collections.singletonList("word"));

    @Test
    public void calculateWordCounts_emptySearch__returns0Count() {
        // GIVEN
        WordSearcher wordSearcher = new WordSearcher(EMPTY_SEARCH);

        // WHEN
        Map<String, Long> results = wordSearcher.calculateWordCounts();

        // THEN
        expectCount(EMPTY_SEARCH, "word", results, 0L);
    }

    @Test
    public void calculateWordCounts_noMatches_returns0Count() {
        // GIVEN
        WordSearcher wordSearcher = new WordSearcher(NO_MATCH_SEARCH);

        // WHEN
        Map<String,Long> results = wordSearcher.calculateWordCounts();

        // THEN
        assertFalse(wordSearcher.calculateWordCounts().isEmpty(),
            "Expected a non-empty Map to be returned when the word search is not empty.");

        expectCount(NO_MATCH_SEARCH, "word", results, 0L);
    }

    @Test
    public void calculateWordCounts_soreSearch_returnsCount() {
        // GIVEN
        WordSearcher wordSearcher = new WordSearcher(SORE_SEARCH);

        // WHEN & THEN
        Map<String,Long> results = wordSearcher.calculateWordCounts();

        assertFalse(results.isEmpty(),
            "Expected a non-empty Map to be returned when the word search is not empty.");

        expectCount(SORE_SEARCH, "sore", results, 5L);
    }

    @Test
    public void calculateWordCounts_abracadabraSearch_returnsCount() {
        // GIVEN
        WordSearcher wordSearcher = new WordSearcher(ABRACADABRA_SEARCH);

        // WHEN & THEN
        Map<String,Long> results = wordSearcher.calculateWordCounts();

        assertFalse(results.isEmpty(),
            "Expected a non-empty Map to be returned when the word search is not empty.");

        expectCount(ABRACADABRA_SEARCH, "abracadabra", results, 1008L);
    }

    @Test
    public void calculateWordCounts_frozenVillageSearch_returnsCount() {
        // GIVEN
        WordSearcher wordSearcher = new WordSearcher(FROZEN_VILLAGE_SEARCH);

        // WHEN & THEN
        Map<String,Long> results = wordSearcher.calculateWordCounts();

        assertFalse(results.isEmpty(),
            "Expected a non-empty Map to be returned when the word search is not empty.");

        expectCount(FROZEN_VILLAGE_SEARCH, "blaze", results, 46L);
        expectCount(FROZEN_VILLAGE_SEARCH, "ember", results, 29L);
        expectCount(FROZEN_VILLAGE_SEARCH, "fire", results, 21L);
        expectCount(FROZEN_VILLAGE_SEARCH, "ignite", results, 7L);
        expectCount(FROZEN_VILLAGE_SEARCH, "kindle", results, 33L);
    }

    private void expectCount(WordSearch wordSearch, String word, Map<String,Long> results, long expectedCout) {
        assertEquals(expectedCout, results.get(word),
            String.format("Expected to find %s of %s in the word search:\n%s",
                expectedCout, word, wordSearch));
    }
}
