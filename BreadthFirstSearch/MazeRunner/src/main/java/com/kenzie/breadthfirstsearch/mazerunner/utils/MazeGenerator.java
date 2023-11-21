package com.kenzie.breadthfirstsearch.mazerunner.utils;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazePattern;
import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpace;
import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpaceType;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Coordinate;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A class that generates maze graphs from maze patterns.
 */
public class MazeGenerator {
    private Node<MazeSpace> entrance;
    private final MazePattern pattern;

    private MazeGenerator(MazePattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Create a new graph of `MazeSpace` from a `MazePattern`.
     *
     * @param pattern - the pattern for the maze to create
     * @return the `TreeNode` representing the entrance to the maze, if one is present. Empty otherwise.
     *
     * @throws IllegalArgumentException if a maze pattern contains more than one entrance.
     */
    public static Optional<Node<MazeSpace>> generateMaze(MazePattern pattern) {
        MazeGenerator generator = new MazeGenerator(pattern);

        return generator.generateMaze();
    }

    private Optional<Node<MazeSpace>> generateMaze() {
        List<List<Optional<Node<MazeSpace>>>> spaces = new ArrayList<>();

        for (int row = 0; row < pattern.getHeight(); row++) {
            spaces.add(new ArrayList<>());
            for (int column = 0; column < pattern.getWidth(); column++) {
                spaces.get(row).add(generateMazeSpace(row, column));
            }
        }

        addAllNeighbors(spaces);

        return Optional.ofNullable(entrance);
    }

    private Optional<Node<MazeSpace>> generateMazeSpace(int row, int column) {
        Coordinate coordinates = new Coordinate(row, column);
        MazeSpaceType spaceType = pattern.getSpaceType(coordinates);

        if (MazeSpaceType.WALL.equals(spaceType)) {
            return Optional.empty();
        }

        Node<MazeSpace> spaceNode = new Node<>(
            new MazeSpace(MazeSpaceType.EXIT.equals(spaceType), coordinates));

        if (MazeSpaceType.ENTRANCE.equals(spaceType)) {
            if (Objects.nonNull(entrance)) {
                throw new IllegalArgumentException("A maze can only have one entrance!");
            }
            entrance = spaceNode;
        }

        return Optional.of(spaceNode);
    }

    private void addAllNeighbors(List<List<Optional<Node<MazeSpace>>>> spaces) {
        spaces.stream()
            .flatMap(List::stream)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .forEach(space -> space.addNeighbors(getNeighbors(space, spaces)));
    }

    private List<Node<MazeSpace>> getNeighbors(Node<MazeSpace> space, List<List<Optional<Node<MazeSpace>>>> spaces) {
        return getNeighbors(space)
            .stream()
            .map(coordinates -> spaces.get(coordinates.getRow()).get(coordinates.getColumn()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }


    private List<Coordinate> getNeighbors(Node<MazeSpace> space) {
        List<Coordinate> neighbors = new ArrayList<>();

        Coordinate currentCoordinates = space.getValue().getCoordinates();
        int row = currentCoordinates.getRow();
        int column = currentCoordinates.getColumn();

        if (row > 0) {
            neighbors.add(new Coordinate(row - 1, column));
        }

        if (row + 1 < pattern.getHeight()) {
            neighbors.add(new Coordinate(row + 1, column));
        }

        if (column > 0) {
            neighbors.add(new Coordinate(row, column - 1));
        }

        if (column + 1 < pattern.getWidth()) {
            neighbors.add(new Coordinate(row, column + 1));
        }

        return neighbors;
    }

}
