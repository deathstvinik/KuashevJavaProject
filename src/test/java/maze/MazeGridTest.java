package maze;

import org.junit.jupiter.api.Test;
import maze.model.MazeGrid;
import static org.junit.jupiter.api.Assertions.*;

class MazeGridTest {
    @Test
    void testGridCreation() {
        MazeGrid grid = new MazeGrid(15, 21);
        assertEquals(15, grid.getRows());
        assertEquals(21, grid.getCols());
        assertTrue(grid.getCell(0, 0).isWall());
    }
}