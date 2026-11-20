package maze.algorithm;

import maze.model.Cell;
import maze.model.MazeGrid;
import maze.model.PathResult;
import java.util.*;

public class BfsPathfindingStrategy implements PathfindingStrategy {
    @Override
    public PathResult findPath(MazeGrid grid, Cell start, Cell end) {
        long startTime = System.currentTimeMillis();
        grid.clearPathState();
        Queue<Cell> queue = new ArrayDeque<>();
        start.setVisited(true);
        queue.add(start);
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            visitedCount++;
            if (current == end) break;

            for (Cell neighbor : grid.getNeighbors(current, 1)) {
                if (!neighbor.isWall() && !neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    neighbor.setParent(current);
                    queue.add(neighbor);
                }
            }
        }

        List<Cell> path = new ArrayList<>();
        for (Cell at = end; at != null; at = at.getParent()) {
            path.add(at);
        }
        if (path.size() == 1 && end != start) path.clear();
        Collections.reverse(path);

        long time = System.currentTimeMillis() - startTime;
        return new PathResult.Builder()
                .path(path)
                .visitedCellsCount(visitedCount)
                .executionTimeMs(time)
                .build();
    }
}