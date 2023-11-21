package com.kenzie.breadthfirstsearch.mazerunner;

import com.kenzie.breadthfirstsearch.mazerunner.model.MazeSpace;
import com.kenzie.breadthfirstsearch.mazerunner.sharedmodel.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_NO_ENTRANCE;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_ONE_EXIT;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_TWO_EXITS;
import static com.kenzie.breadthfirstsearch.mazerunner.SampleMazes.MAZE_UNREACHABLE_EXIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindShortestPathToExitTest {
    @Test
    public void findShortestPathToExit_noEntrance_returnsEmptyPath() {
        // WHEN & THEN
        assertTrue(MazeRunner.findShortestPathToExit(MAZE_NO_ENTRANCE).isEmpty(),
            String.format("Expected to find no entrance for maze:\n%s", MAZE_NO_ENTRANCE));
    }
    @Test
    public void findShortestPathToExit_singleReachableExit_returnsShortestPathToExit() {
        // GIVEN
        List<MazeSpace> expectedPath = Arrays.asList(
            new MazeSpace(false, new Coordinate(0,3)),
            new MazeSpace(false, new Coordinate(1,3)),
            new MazeSpace(false, new Coordinate(1,2)),
            new MazeSpace(false, new Coordinate(1,1)),
            new MazeSpace(false, new Coordinate(2,1)),
            new MazeSpace(false, new Coordinate(3,1)),
            new MazeSpace(true, new Coordinate(3,0))
        );

        // WHEN
        List<MazeSpace> result = MazeRunner.findShortestPathToExit(MAZE_ONE_EXIT);

        // THEN
        assertFalse(result.isEmpty(), String.format("Expected to find a reachable exit for maze:\n%s",
            MAZE_ONE_EXIT));

        assertEquals(expectedPath, result,
            String.format("Expected the shortest path to the exist of maze:\n%s\n to be %s, instead returned %s",
                MAZE_ONE_EXIT, expectedPath, result));
    }

    @Test
    public void findShortestPathToExit_unReachableExit_returnsEmptyPath() {
        // WHEN
        List<MazeSpace> result = MazeRunner.findShortestPathToExit(MAZE_UNREACHABLE_EXIT);

        // THEN
        assertTrue(result.isEmpty(), String.format("Expected to find no reachable exits for maze:\n%s",
            MAZE_UNREACHABLE_EXIT));
    }

    @Test
    public void findShortestPathToExit_twoReachableExits_returnsPathToClosestExit() {
        // GIVEN
        List<MazeSpace> expectedPath = Arrays.asList(
            new MazeSpace(false, new Coordinate(0,3)),
            new MazeSpace(false, new Coordinate(1,3)),
            new MazeSpace(false, new Coordinate(1,2)),
            new MazeSpace(false, new Coordinate(1,1)),
            new MazeSpace(true, new Coordinate(1,0))
        );

        // WHEN
        List<MazeSpace> result = MazeRunner.findShortestPathToExit(MAZE_TWO_EXITS);

        // THEN
        assertFalse(result.isEmpty(), String.format("Expected to find a reachable exit for maze:\n%s",
            MAZE_TWO_EXITS));

        assertEquals(expectedPath, result,
            String.format("Expected the shortest path to the exist of maze:\n%s\n to be %s, instead returned %s",
                MAZE_TWO_EXITS, expectedPath, result));
    }

}
