package Final;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private PlannerPanel plannerPanel;
    private SchedulePanel schedulePanel;
    private HandleSchedule hs;
    private DateAndTime dt;

    public MainFrame(String title) {
        super(title);
        dt = new DateAndTime();
        //Set layout manager (how to arrange components on the frame
        setLayout(new BorderLayout());


        //Create Swing Component
        Dimension d = new Dimension();


        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", 0, 24));
        textArea.setColumns(1);
        textArea.setVisible(true);
        textArea.setAutoscrolls(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(960,100));

        JTabbedPane tabbedPane = new JTabbedPane();
        d.setSize(960,200);
        tabbedPane.setPreferredSize(d);

        hs = new HandleSchedule();
        hs.generateSchedule();
        schedulePanel = new SchedulePanel(hs,dt);
        plannerPanel = new PlannerPanel(hs,dt);

        //Add tabs
        tabbedPane.addTab("Current Plan", plannerPanel);
        tabbedPane.addTab("Schedule", schedulePanel);

        //Add Swing Components to content pane
        //Container c = getContentPane();
        add(scrollPane, BorderLayout.CENTER);
        add(tabbedPane,BorderLayout.NORTH);
        pack();

        consoleWriter(textArea);
    }


    private void consoleWriter(JTextArea jta) {
        Thread threadClock = new Thread() {
            public void run() {

                try {
                    while (true) {
                        dt.clock();
                        String day = dt.dayOfWeek();
                        int hour = dt.getHour();
                        jta.setText(hs.isItTime(day,hour));
                        sleep(100000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }

}
