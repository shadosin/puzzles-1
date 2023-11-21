package com.kenzie.breadthfirstsearch.mazerunner;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazePattern;
import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpace;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Node;
import com.kenzie.breadthfirstsearch.mazerunner.utils.MazeGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_ONE_EXIT;

/**
 * Class for running through mazes.
 */
public class MazeRunner {

    /**
     * Private constructor, as all methods are static.
     */
    private MazeRunner() {}

    /**
     * Utility main method, to run MazeRunner methods without adding tests.
     *
     * @param args - Method arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println(MazeRunner.findClosestExit(MAZE_ONE_EXIT));
    }

    /**
     * Finds the exit out of the maze closest to its entrance.
     *
     * @param pattern - the pattern of maze being run through
     * @return the closest reachable exit to the maze, or empty if there are no reachable exits
     */
    public static Optional<MazeSpace> findClosestExit(MazePattern pattern) {
        Optional<Node<MazeSpace>> entrance = MazeGenerator.generateMaze(pattern);
        return Optional.empty();
    }

    /**
     * Finds the path to the exit out of the maze closest to its entrance.
     *
     * @param pattern - the pattern of maze being run through
     * @return the path closest reachable exit to the maze, or an empty list if there are no reachable exits
     */
    public static List<MazeSpace> findShortestPathToExit(MazePattern pattern) {
        Optional<Node<MazeSpace>> entrance = MazeGenerator.generateMaze(pattern);
        return Collections.emptyList();
    }
}
