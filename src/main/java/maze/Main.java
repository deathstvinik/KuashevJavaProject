package maze;

import com.formdev.flatlaf.FlatLightLaf;
import maze.ui.MazePanel;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Генератор лабиринтов и поиск пути");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new MazePanel());
            frame.setSize(800, 650);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}