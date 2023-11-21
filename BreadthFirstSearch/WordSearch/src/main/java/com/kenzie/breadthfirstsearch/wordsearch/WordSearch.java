package com.kenzie.breadthfirstsearch.wordsearch;

import com.kenzie.breadthfirstsearch.wordsearch.sharedmodel.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A representation of a Word Search puzzle, containing both the puzzle and which words to find.
 */
public class WordSearch {
    private final int width;
    private final int height;
    private final char[][] pattern;
    private final List<String> wordsToFind;

    /**
     * Create a new Word Search.
     *
     * @param width - width of the puzzle
     * @param height - height of the puzzle
     * @param pattern - the puzzle itself
     * @param wordsToFind - what words to find as part of the puzzle
     */
    public WordSearch(int width, int height, char[][] pattern, List<String> wordsToFind) {
        this.width = width;
        this.height = height;
        this.pattern = pattern;
        this.wordsToFind = wordsToFind;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getWordsToFind() {
        return new ArrayList<>(wordsToFind);
    }

    /**
     * Get the character at the given coordinates in the puzzle.
     *
     * @param coordinates - the coordinates within the puzzle
     * @return the character value at the provided coordinates within the puzzle
     * @throws IllegalArgumentException if trying to access values beyond the boundaries of the puzzle
     */
    public char getCharacterAt(Coordinate coordinates) {
        int row = coordinates.getRow();
        int column = coordinates.getColumn();
        if (row < 0 || row >= height) {
            throw new IllegalArgumentException("Can't access a row outside the given height.");
        }

        if (column < 0 || column >= width) {
            throw new IllegalArgumentException("Can't access a column outside the given width.");
        }

        return pattern[row][column];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(pattern)
            .replace("], ", "]\n");
    }
}
