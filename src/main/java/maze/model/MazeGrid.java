package maze.model;

import java.util.ArrayList;
import java.util.List;

public class MazeGrid {
    private final int rows;
    private final int cols;
    private final Cell[][] grid;

    public MazeGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell(r, c);
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public Cell getCell(int r, int c) { return grid[r][c]; }

    public void resetGrid() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].reset();
            }
        }
    }

    public void clearPathState() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].setVisited(false);
                grid[r][c].setParent(null);
            }
        }
    }

    public List<Cell> getNeighbors(Cell cell, int step) {
        List<Cell> list = new ArrayList<>();
        int[][] dirs = {{-step, 0}, {step, 0}, {0, -step}, {0, step}};
        for (int[] d : dirs) {
            int nr = cell.getRow() + d[0];
            int nc = cell.getCol() + d[1];
            if (nr > 0 && nr < rows - 1 && nc > 0 && nc < cols - 1) {
                list.add(grid[nr][nc]);
            }
        }
        return list;
    }
}