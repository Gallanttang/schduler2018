package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private PlannerPanel plannerPanel;


    public MainFrame(String title) {
        super(title);
        //Set layout manager (how to arrange components on the frame
        setLayout(new BorderLayout());


        //Create Swing Component
        Dimension d = new Dimension();


        JTextArea textArea = new JTextArea();
        textArea.setVisible(true);
        textArea.setAutoscrolls(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setMaximumSize(new Dimension(960,200));
        scrollPane.setPreferredSize(new Dimension(960,200));


        JButton button = new JButton("Acknowledge");


        JTabbedPane tabbedPane = new JTabbedPane();
        d.setSize(960,450);
        //tabbedPane.setPreferredSize(d);

        SchedulePanel schedulePanel = new SchedulePanel();
        plannerPanel = new PlannerPanel();


        //Add tabs
        tabbedPane.addTab("Current Plan", plannerPanel);
        tabbedPane.addTab("Schedule", schedulePanel);

        //Add Swing Components to content pane
        //Container c = getContentPane();
        add(button, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.SOUTH);
        add(tabbedPane,BorderLayout.CENTER);
        pack();



        //Add behaviour
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello World\n");
            }
        });
    }





}
