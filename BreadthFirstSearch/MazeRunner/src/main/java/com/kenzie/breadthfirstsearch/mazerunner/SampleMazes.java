package com.kenzie.breadthfirstsearch.mazerunner;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazePattern;

/**
 * Sample `MazePatterns` used for testing.
 */
public class SampleMazes {
    private static final int[][] MAZE_ONE_EXIT_PATTERN = {
        {0, 0, 0, 2, 0},
        {1, 1, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {3, 1, 1, 1, 1}};

    public static final MazePattern MAZE_ONE_EXIT = new MazePattern(5, 4, MAZE_ONE_EXIT_PATTERN);

    private static final int[][] MAZE_UNREACHABLE_EXIT_PATTERN = {
            {0, 0, 0, 2, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {3, 1, 0, 1, 1}};

    public static final MazePattern MAZE_UNREACHABLE_EXIT = new MazePattern(5, 4,
        MAZE_UNREACHABLE_EXIT_PATTERN);


    private static final int[][] MAZE_TWO_EXITS_PATTERN = {
            {0, 0, 0, 2, 0},
            {3, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {3, 1, 1, 1, 1}};

    public static final MazePattern MAZE_TWO_EXITS = new MazePattern(5, 4,
        MAZE_TWO_EXITS_PATTERN);

    private static final int[][] MAZE_NO_ENTRANCE_PATTERN = {
        {0, 0, 0, 0, 0},
        {3, 1, 1, 1, 1},
        {0, 0, 0, 0, 1},
        {3, 1, 1, 1, 1}};

    public static final MazePattern MAZE_NO_ENTRANCE = new MazePattern(5,  4,
        MAZE_NO_ENTRANCE_PATTERN);

    private SampleMazes(){}
}
