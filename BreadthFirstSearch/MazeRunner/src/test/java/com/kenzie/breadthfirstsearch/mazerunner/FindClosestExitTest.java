package com.kenzie.breadthfirstsearch.mazerunner;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpace;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Coordinate;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_NO_ENTRANCE;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_ONE_EXIT;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_TWO_EXITS;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_UNREACHABLE_EXIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindClosestExitTest {
    @Test
    public void findClosestExit_noEntrance_returnsEmpty() {
        // WHEN & THEN
        assertFalse(MazeRunner.findClosestExit(MAZE_NO_ENTRANCE).isPresent(),
            String.format("Expected to find no entrance for maze:\n%s", MAZE_NO_ENTRANCE));
    }

    @Test
    public void findClosestExit_singleReachableExit_returnsExit() {
        // GIVEN
        MazeSpace expectedSpace = new MazeSpace(true, new Coordinate(3,0));

        // WHEN
        Optional<MazeSpace> result = MazeRunner.findClosestExit(MAZE_ONE_EXIT);

        // THEN
        assertTrue(result.isPresent(), String.format("Expected to find a reachable exit for maze:\n%s",
            MAZE_ONE_EXIT.toString()));

        assertEquals(expectedSpace, result.get(), String.format("Expected to find exit %s for maze:\n%s",
            expectedSpace,MAZE_ONE_EXIT));

    }

    @Test
    public void findClosestExit_unReachableExit_returnsEmpty() {
        // WHEN
        Optional<MazeSpace> result = MazeRunner.findClosestExit(MAZE_UNREACHABLE_EXIT);

        // THEN
        assertFalse(result.isPresent(), String.format("Expected to find no reachable exits for maze:\n%s",
            MAZE_UNREACHABLE_EXIT));
    }

    @Test
    public void findClosestExit_twoReachableExits_returnsClosestExit() {
        // GIVEN
        MazeSpace expectedSpace = new MazeSpace(true, new Coordinate(1,0));

        // WHEN
        Optional<MazeSpace> result = MazeRunner.findClosestExit(MAZE_TWO_EXITS);

        // THEN
        assertTrue(result.isPresent(), String.format("Expected to find a reachable exit for maze:\n%s",
            MAZE_TWO_EXITS));

        assertEquals(expectedSpace, result.get(), String.format("Expected to find exit %s for maze:\n%s",
            expectedSpace,MAZE_TWO_EXITS));
    }
}
