package maze.algorithm;

import maze.model.MazeGrid;

public interface GenerationStrategy {
    void generate(MazeGrid grid);
}