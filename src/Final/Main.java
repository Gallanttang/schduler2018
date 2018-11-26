package Final;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        initializer();
    }

    public static void initializer(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("Health Planner");
                Dimension d = new Dimension(960,350);
                frame.setSize(d);
                frame.setMaximumSize(d);
                frame.setMinimumSize(d);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
