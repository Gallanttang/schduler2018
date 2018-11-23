package Final;

import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        initializer();
    }

    public static void initializer(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("Health Planner");
                frame.setSize(960,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
