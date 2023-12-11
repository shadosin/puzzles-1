package com.kenzie.breadthfirstsearch.wordsearch;

import com.kenzie.breadthfirstsearch.wordsearch.sharedmodel.Coordinate;
import com.kenzie.breadthfirstsearch.wordsearch.sharedmodel.Direction;

import java.util.*;

import static com.kenzie.breadthfirstsearch.wordsearch.SampleWordSearches.SORE_SEARCH;

/**
 * Class for completing word search puzzles.
 */
public class WordSearcher {
    private final WordSearch wordSearch;

    /**
     * Create a word search instance for the provided problem.
     * @param wordSearch - the word search puzzle to solve
     */
    public WordSearcher(WordSearch wordSearch) {
        this.wordSearch = wordSearch;
    }

    /**
     * Main method for manual testing.
     *
     * @param args - unused
     */
    public static void main(String[] args) {
        WordSearcher wordSearcher = new WordSearcher(SORE_SEARCH);

        System.out.println(wordSearcher.calculateWordCounts());
    }

    /**
     * Calculate how many ways (permutations) you can use the letters in the puzzle to spell
     * each word provided as part of the puzzle.
     *
     * @return a Map of the desired words, and how many ways (permutations) you can use the letters in the puzzle to
     * spell each word provided as part of the puzzle.
     */
    public Map<String, Long> calculateWordCounts() {
        Map<String, Long> finalWords = new HashMap<>();
        for(String word : wordSearch.getWordsToFind()){
            finalWords.put(word, 0L);
        }
        for(String word : wordSearch.getWordsToFind()) {
            for (int row = 0; row < wordSearch.getHeight(); row++) {
                for (int col = 0; col < wordSearch.getWidth(); col++) {
                    if(wordSearch.getCharacterAt(new Coordinate(row,col)) == word.charAt(0)){
                        Coordinate start = new Coordinate(row, col);
                        searchForWords(word, start, finalWords);
                    }
                }
            }
        }

        return finalWords;
    }

    private void searchForWords(String word, Coordinate start, Map<String, Long> finalWords){
        Queue<SearchState> queue = new LinkedList<>();
        queue.add(new SearchState(start, String.valueOf(wordSearch.getCharacterAt(start))));

        while(!queue.isEmpty()){
            SearchState searchState = queue.poll();
            Coordinate current = searchState.coordinate;
            String stringState = searchState.stringState;

            if(stringState.equals(word)){
                finalWords.put(word, finalWords.getOrDefault(word, 0L)+1);
                continue;
            }
            if(word.startsWith(stringState)){
                for(Direction direction : Direction.ALL_DIRECTIONS){
                    Coordinate update = direction.addToCoordinate(current);
                    int row = update.getRow();
                    int col = update.getColumn();

                    if(row >= 0 && row < wordSearch.getHeight() && col >= 0 && col < wordSearch.getWidth()){
                        char nextChar = wordSearch.getCharacterAt(update);
                        if(stringState.length() < word.length() && nextChar == word.charAt(stringState.length())){
                            queue.add(new SearchState(update, stringState + nextChar));
                        }
                    }
                }
            }
        }
    }


    private static class SearchState{
        Coordinate coordinate;
        String stringState;
        public SearchState(Coordinate coordinate, String stringState){
            this.coordinate = coordinate;
            this.stringState = stringState;
        }
    }
}
