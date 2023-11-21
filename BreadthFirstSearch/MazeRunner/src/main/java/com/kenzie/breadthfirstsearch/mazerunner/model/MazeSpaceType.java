package com.kenzie.breadthfirstsearch.mazerunner.model;

/**
 * A human-readable representation of the different types of spaces within a maze.
 */
public enum MazeSpaceType {
    // A non-traversable space in a maze
    WALL,
    // A traversable space in a maze.
    SPACE,
    // The entrance to a maze
    ENTRANCE,
    // An exit from the maze
    EXIT;

    /**
     * Provides the `MazeSpaceType` represented by an integer from a maze pattern.
     *
     * @param space - the integer representation of the space
     * @return the type of space the integer represents.
     * @throws IllegalArgumentException if the integer matches no space type.
     */
    public static MazeSpaceType fromInteger(int space) {
        switch (space) {
            case 0:
                return WALL;
            case 1:
                return SPACE;
            case 2:
                return ENTRANCE;
            case 3:
                return EXIT;
            default:
                throw new IllegalArgumentException(
                    String.format("Invalid space detected: %s", space));
        }
    }
}
