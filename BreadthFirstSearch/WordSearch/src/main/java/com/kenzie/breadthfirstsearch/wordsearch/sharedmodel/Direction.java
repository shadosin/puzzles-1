package com.kenzie.breadthfirstsearch.wordsearch.sharedmodel;

import java.util.Arrays;
import java.util.List;

/**
 * A representation of the 8 horizontal, vertical, and diagonal directions.
 */
public class Direction {
    public static final Direction UP = new Direction(-1, 0);
    public static final Direction DOWN = new Direction(1, 0);
    public static final Direction LEFT = new Direction(0, -1);
    public static final Direction RIGHT = new Direction(0, 1);
    public static final Direction UP_LEFT = new Direction(-1, -1);
    public static final Direction UP_RIGHT = new Direction(-1, 1);
    public static final Direction DOWN_LEFT = new Direction(1, -1);
    public static final Direction DOWN_RIGHT = new Direction(1, 1);

    public static final List<Direction> ALL_DIRECTIONS = Arrays.asList(
        UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT);

    private final int rowDirection;
    private final int columnDirection;

    private Direction(int rowDirection, int columnDirection) {
        this.rowDirection = rowDirection;
        this.columnDirection = columnDirection;
    }

    /**
     * Get the number of vertical steps for the direction.
     *
     * @return the number of rows to traverse in a "step".
     *         Positive is downwards, negative is upwards. 0 means no change.
     */
    public int getRowDirection() {
        return rowDirection;
    }

    /**
     * Get the number of horizontal steps for the direction.
     *
     * @return the number of columns to traverse in a "step".
     *         Positive is rightwards, negative is leftwards. 0 means no change.
     */
    public int getColumnDirection() {
        return columnDirection;
    }

    /**
     * Adds one "step" from the starting coordinates in the given direction.
     * @param startingCoordinates - the starting coordinates.
     * @return a coordinate one "step" from the starting coordinates in the given direction.
     */
    public Coordinate addToCoordinate(Coordinate startingCoordinates) {
        int row = startingCoordinates.getRow() + rowDirection;
        int column = startingCoordinates.getColumn() + columnDirection;
        return new Coordinate(row, column);
    }
}
