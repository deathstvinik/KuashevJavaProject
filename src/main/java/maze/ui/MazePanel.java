package maze.ui;

import maze.algorithm.*;
import maze.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class MazePanel extends JPanel {
    private final MazeGrid grid = new MazeGrid(21, 21);
    private final GenerationStrategy generator = new DfsGenerationStrategy();
    private final PathfindingStrategy pathfinder = new BfsPathfindingStrategy();
    private List<Cell> currentPath = Collections.emptyList();
    private final JLabel metricsLabel = new JLabel("Нажмите «Сгенерировать»");

    public MazePanel() {
        setLayout(new BorderLayout());
        JPanel controls = new JPanel();
        JButton genBtn = new JButton("Сгенерировать (DFS)");
        JButton solveBtn = new JButton("Найти путь (BFS)");

        genBtn.addActionListener(e -> {
            currentPath = Collections.emptyList();
            generator.generate(grid);
            metricsLabel.setText("Лабиринт создан");
            repaint();
        });

        solveBtn.addActionListener(e -> {
            Cell start = grid.getCell(1, 1);
            Cell end = grid.getCell(grid.getRows() - 2, grid.getCols() - 2);
            PathResult result = pathfinder.findPath(grid, start, end);
            currentPath = result.getPath();
            metricsLabel.setText("Проверено ячеек: " + result.getVisitedCellsCount()
                    + " | Время: " + result.getExecutionTimeMs() + " мс");
            repaint();
        });

        controls.add(genBtn);
        controls.add(solveBtn);
        controls.add(metricsLabel);
        add(controls, BorderLayout.NORTH);
        generator.generate(grid);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offsetY = 45;
        int cellSize = Math.min(getWidth() / grid.getCols(), (getHeight() - offsetY) / grid.getRows());

        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                Cell cell = grid.getCell(r, c);
                if (cell.isWall()) g.setColor(Color.DARK_GRAY);
                else if (currentPath.contains(cell)) g.setColor(Color.GREEN);
                else if (cell.isVisited()) g.setColor(new Color(180, 220, 255));
                else g.setColor(Color.WHITE);

                g.fillRect(c * cellSize, offsetY + r * cellSize, cellSize, cellSize);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(c * cellSize, offsetY + r * cellSize, cellSize, cellSize);
            }
        }
    }
}