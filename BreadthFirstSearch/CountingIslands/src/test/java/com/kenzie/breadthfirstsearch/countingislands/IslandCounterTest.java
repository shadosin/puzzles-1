package com.kenzie.breadthfirstsearch.countingislands;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandCounterTest {

    @Test
    public void countIslands_emptyMap_returnsZero() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(0, 0, SamplesMaps.EMPTY_MAP);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(0, result, SamplesMaps.EMPTY_MAP);
    }

    @Test
    public void countIslands_allWater_returnsZero() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(4, 4, SamplesMaps.OOPS_ALL_WATER);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(0, result, SamplesMaps.OOPS_ALL_WATER);
    }

    @Test
    public void countIslands_allIsland_returnsOne() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(4, 4, SamplesMaps.OOPS_ALL_LAND);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(1, result, SamplesMaps.OOPS_ALL_LAND);
    }

    @Test
    public void countIslands_oneIsland_returnsOne() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(5, 5, SamplesMaps.ONE_ISLAND_MAP);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(1, result, SamplesMaps.ONE_ISLAND_MAP);
    }

    @Test
    public void countIslands_threeIslandMap_returnsThree() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(5, 5, SamplesMaps.THREE_ISLAND_MAP);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(3, result, SamplesMaps.THREE_ISLAND_MAP);
    }

    @Test
    public void countIslands_fiveIslandMap_returnsFive() {
        // GIVEN
        IslandCounter islandCounter = new IslandCounter(5, 5, SamplesMaps.FIVE_ISLAND_MAP);

        // WHEN
        int result = islandCounter.countIslands();

        // THEN
        assertMapCount(5, result, SamplesMaps.FIVE_ISLAND_MAP);
    }

    private void assertMapCount(int expectedCount, int actualCount, int[][]map) {
        assertEquals(expectedCount, actualCount,
            String.format("Expected to count %s islands, but found %s for map:\n%s",
                expectedCount, actualCount, mapString(map)));

    }

    private String mapString(int[][] map) {
        return Arrays.deepToString(map)
            .replace("], ", "]\n");
    }
}
