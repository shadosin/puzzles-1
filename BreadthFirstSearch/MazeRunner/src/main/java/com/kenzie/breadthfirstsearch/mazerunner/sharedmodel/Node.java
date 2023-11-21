package com.kenzie.breadthfirstsearch.mazerunner.sharedmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic class for a node/vertex in a graph.
 * @param <T> the type of value stored in the `TreeNode`.
 */
public class Node<T> {
    private final T value;
    private final List<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        neighbors = new ArrayList<>();
    }

    public void addNeighbors(List<Node<T>> newNeighbors) {
        neighbors.addAll(newNeighbors);
    }

    public List<Node<T>> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    public T getValue() {
        return value;
    }
}
