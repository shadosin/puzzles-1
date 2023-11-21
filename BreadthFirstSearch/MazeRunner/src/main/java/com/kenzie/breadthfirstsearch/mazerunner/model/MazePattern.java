package com.kenzie.breadthfirstsearch.mazerunner.model;

import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Coordinate;

import java.util.Arrays;

/**
 * The pattern for a maze, built from a 2D array of ints.
 */
public class MazePattern {
    private final int width;
    private final int height;
    private final int[][] pattern;

    public MazePattern(int width, int height, int[][] pattern) {
        this.width = width;
        this.height = height;
        this.pattern = pattern;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Get the type of the space at a given coordinate in the maze.
     *
     * @param coordinates - the coordinates within the maze
     * @return the `MazeSpaceType` of the space, as represented in the 2D array pattern
     * @throws IllegalArgumentException if accessing coordinates outside of the bounds of the pattern.
     */
    public MazeSpaceType getSpaceType(Coordinate coordinates) {
        int row = coordinates.getRow();
        int column = coordinates.getColumn();
        if (row < 0 || row >= height) {
            throw new IllegalArgumentException("Can't access a row outside the given height of the maze.");
        }

        if (column < 0 || column >= width) {
            throw new IllegalArgumentException("Can't access a column outside the given width of the maze.");
        }

        return MazeSpaceType.fromInteger(pattern[row][column]);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(pattern)
            .replace("], ", "]\n");
    }

}
