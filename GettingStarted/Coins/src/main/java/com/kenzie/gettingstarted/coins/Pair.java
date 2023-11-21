package com.kenzie.gettingstarted.coins;

import java.util.Objects;

/**
 * Represents a pair of values, for storing and testing sums more easily.
 *
 * 
 */
public class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public static Pair of(int first, int second) {
        return new Pair(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        // order shouldn't matter, but don't change the order so toString() gives expected results
        return (first == pair.first && second == pair.second) || (first == pair.second && second == pair.first);
    }

    @Override
    public int hashCode() {
        // To handle opposite order, always hash the smaller value first
        if (first < second) {
            return Objects.hash(first, second);
        } else {
            return Objects.hash(second, first);
        }
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", first, second);
    }
}
