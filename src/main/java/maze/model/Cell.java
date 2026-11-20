package maze.model;

public class Cell {
    private final int row;
    private final int col;
    private boolean wall = true;
    private boolean visited = false;
    private Cell parent;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isWall() { return wall; }
    public void setWall(boolean wall) { this.wall = wall; }
    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
    public Cell getParent() { return parent; }
    public void setParent(Cell parent) { this.parent = parent; }

    public void reset() {
        this.wall = true;
        this.visited = false;
        this.parent = null;
    }
}