package com.kenzie.breadthfirstsearch.countingislands;

/**
 * Counts the number of islands for a map.
 */
public class IslandCounter {
    private final int width;
    private final int height;
    private final int[][]map;

    public IslandCounter(int width, int height, int[][] map) {
        this.width = width;
        this.height = height;
        this.map = map;
    }

    /**
     * Main method for manual testing.
     * @param args - unused
     */
    public static void main(String[] args) {
        IslandCounter islandCounter = new IslandCounter(5, 5, SamplesMaps.FIVE_ISLAND_MAP);
        int islandCount = islandCounter.countIslands();
        System.out.println(String.format("Found %s islands.", islandCount));
    }

    /**
     * Counts the number of islands for the map.
     * @return the number of islands for the map.
     */
    public int countIslands() {
        return 0;
    }

}
