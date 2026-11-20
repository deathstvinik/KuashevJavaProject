package maze.model;

import java.util.Collections;
import java.util.List;

public final class PathResult {
    private final List<Cell> path;
    private final long executionTimeMs;
    private final int visitedCellsCount;

    private PathResult(Builder builder) {
        this.path = builder.path != null ? List.copyOf(builder.path) : Collections.emptyList();
        this.executionTimeMs = builder.executionTimeMs;
        this.visitedCellsCount = builder.visitedCellsCount;
    }

    public List<Cell> getPath() { return path; }
    public long getExecutionTimeMs() { return executionTimeMs; }
    public int getVisitedCellsCount() { return visitedCellsCount; }

    public static class Builder {
        private List<Cell> path;
        private long executionTimeMs;
        private int visitedCellsCount;

        public Builder path(List<Cell> path) { this.path = path; return this; }
        public Builder executionTimeMs(long ms) { this.executionTimeMs = ms; return this; }
        public Builder visitedCellsCount(int count) { this.visitedCellsCount = count; return this; }
        public PathResult build() { return new PathResult(this); }
    }
}