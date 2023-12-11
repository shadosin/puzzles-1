package com.kenzie.breadthfirstsearch.mazerunner;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazePattern;
import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpace;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Node;
import com.kenzie.breadthfirstsearch.mazerunner.utils.MazeGenerator;

import java.util.*;

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
        if(entrance.isPresent()){
            Queue<Node<MazeSpace>> queue = new LinkedList<>();
            List<Node<MazeSpace>> visited = new ArrayList<>();

            Node<MazeSpace> entranceNode = entrance.get();
            queue.add(entranceNode);
            visited.add(entranceNode);

            while(!queue.isEmpty()){
                Node<MazeSpace> current = queue.poll();
                if(current.getValue().isExit()){
                    return Optional.of(current.getValue());
                }else{
                    visited.add(current);
                    for(Node<MazeSpace> neighbor : current.getNeighbors()){
                        if(!visited.contains(neighbor)){
                            queue.add(neighbor);
                        }
                    }
                }

            }
        }
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


        if (entrance.isPresent()) {
            Node<MazeSpace> entranceNode = entrance.get();


            List<MazeSpace> shortestPath = new ArrayList<>();

            Map<Node<MazeSpace>, Node<MazeSpace>> parentMap = new HashMap<>();

            Queue<Node<MazeSpace>> queue = new LinkedList<>();
            Set<Node<MazeSpace>> visited = new HashSet<>();

            queue.add(entranceNode);
            visited.add(entranceNode);

            while (!queue.isEmpty()) {
                Node<MazeSpace> currentNode = queue.poll();

                if (currentNode.getValue().isExit()) {

                    Node<MazeSpace> tempNode = currentNode;

                    while (tempNode != entranceNode) {
                        shortestPath.add(tempNode.getValue());
                        tempNode = parentMap.get(tempNode);
                    }

                    shortestPath.add(entranceNode.getValue());
                    Collections.reverse(shortestPath);

                    return shortestPath;
                }

                for (Node<MazeSpace> neighbor : currentNode.getNeighbors()) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        parentMap.put(neighbor, currentNode);
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
