package maze.algorithm;

import maze.model.Cell;
import maze.model.MazeGrid;
import java.util.*;

public class DfsGenerationStrategy implements GenerationStrategy {
    @Override
    public void generate(MazeGrid grid) {
        grid.resetGrid();
        Deque<Cell> stack = new ArrayDeque<>();
        Cell start = grid.getCell(1, 1);
        start.setWall(false);
        stack.push(start);

        while (!stack.isEmpty()) {
            Cell current = stack.peek();
            List<Cell> unvisited = new ArrayList<>();
            for (Cell n : grid.getNeighbors(current, 2)) {
                if (n.isWall()) unvisited.add(n);
            }
            if (!unvisited.isEmpty()) {
                Collections.shuffle(unvisited);
                Cell next = unvisited.get(0);
                int wallRow = (current.getRow() + next.getRow()) / 2;
                int wallCol = (current.getCol() + next.getCol()) / 2;
                grid.getCell(wallRow, wallCol).setWall(false);
                next.setWall(false);
                stack.push(next);
            } else {
                stack.pop();
            }
        }
    }
}