package com.kenzie.breadthfirstsearch.countingislands;

/**
 * Contains sample maps.
 */
public class SamplesMaps {
    public static final int[][] EMPTY_MAP = {};

    public static final int[][] OOPS_ALL_WATER = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    public static final int[][] OOPS_ALL_LAND = {
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}
    };

    public static final int[][] ONE_ISLAND_MAP = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };

    public static final int[][] THREE_ISLAND_MAP = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1}
    };

    public static final int[][] FIVE_ISLAND_MAP = {
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };
}
