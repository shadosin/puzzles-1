package com.kenzie.breadthfirstsearch.countingislands;

import com.kenzie.breadthfirstsearch.countingislands.sharedmodel.Coordinate;
import com.kenzie.breadthfirstsearch.countingislands.sharedmodel.Direction;
import com.kenzie.breadthfirstsearch.countingislands.sharedmodel.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int islandCount = 0;
        Queue<Coordinate> coordinates = new LinkedList<>();
        List<Coordinate> checked = new ArrayList<>();

        for(int row = 0; row < height ; row ++){
            for(int col = 0; col < width; col ++){
                if(map[row][col] == 1 && !checked.contains(new Coordinate(row, col))){
                    coordinates.add(new Coordinate(row, col));
                    checked.add(new Coordinate(row, col));
                    islandCount ++;
                    while (!coordinates.isEmpty()){
                        Coordinate current = coordinates.poll();
                        checked.add(current);
                        for(Coordinate neighbor : findNeighbors(current)){
                            if (map[neighbor.getRow()][neighbor.getColumn()] == 1
                                    && !checked.contains(neighbor)) {
                                coordinates.add(neighbor);
                            }
                        }

                    }

                }
            }
        }

        return islandCount;
    }

    private List<Coordinate> findNeighbors(Coordinate coordinate){
        List<Coordinate> stateFarm = new ArrayList<>();
        for(Direction direction: Direction.ALL_DIRECTIONS){
            Coordinate goodNeighbor = direction.addToCoordinate(coordinate);
            if(goodNeighbor.getColumn() >= 0 && goodNeighbor.getColumn() < height
                    && goodNeighbor.getRow() >= 0 && goodNeighbor.getRow() < width)
            stateFarm.add(goodNeighbor);
        }
        return stateFarm;
    }



}
