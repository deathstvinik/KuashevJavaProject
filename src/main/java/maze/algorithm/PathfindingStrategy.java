package maze.algorithm;

import maze.model.Cell;
import maze.model.MazeGrid;
import maze.model.PathResult;

public interface PathfindingStrategy {
    PathResult findPath(MazeGrid grid, Cell start, Cell end);
}