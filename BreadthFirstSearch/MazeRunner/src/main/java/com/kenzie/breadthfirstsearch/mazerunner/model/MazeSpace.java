package com.kenzie.breadthfirstsearch.mazerunner.model;

import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Coordinate;

import java.util.Objects;

/**
 * Class representing a given space in a maze.
 */
public class MazeSpace {
    private final boolean isExit;
    private final Coordinate coordinates;

    public MazeSpace(boolean isExit, Coordinate coordinates) {
        this.isExit = isExit;
        this.coordinates = coordinates;
    }

    public boolean isExit() {
        return isExit;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MazeSpace mazeSpace = (MazeSpace) o;
        return isExit == mazeSpace.isExit &&
            coordinates.equals(mazeSpace.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExit, coordinates);
    }

    @Override
    public String toString() {
        return String.format("MazeSpace:{isExit: %s, coordinates: %s}",
            isExit,
            coordinates);
    }
}
