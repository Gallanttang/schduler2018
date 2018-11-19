package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainFrame extends JFrame {

    private PlannerPanel plannerPanel;
    private JLabel dateAndTime;

    public MainFrame(String title) {
        super(title);
        //Set layout manager (how to arrange components on the frame
        setLayout(new BorderLayout());


        //Create Swing Component

        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Acknowledge");
        JTabbedPane tabbedPane = new JTabbedPane();
        SchedulePanel schedulePanel = new SchedulePanel();
        plannerPanel = new PlannerPanel();
        dateAndTime = new JLabel();
        clock();




        //Add Swing Components to content pane
        Container c = getContentPane();

        tabbedPane.addTab("Current Plan", plannerPanel);
        tabbedPane.addTab("Schedule", schedulePanel);
        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
        c.add(dateAndTime, BorderLayout.NORTH);//Add tabs
        add(tabbedPane,BorderLayout.WEST);



        //Add behaviour
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello World\n");
            }
        });
    }

    public void clock() {
        Thread threadClock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar calendar = new GregorianCalendar(); // creates a new calendar instance
                        int day = calendar.get(Calendar.DAY_OF_WEEK);
                        String dayOfWeek = getDayOfWeek(day);
                        int date = calendar.get(Calendar.DATE);
                        int month = calendar.get(Calendar.MONTH);
                        int year = calendar.get(Calendar.YEAR);

                        int second = calendar.get(Calendar.SECOND);
                        int minute = calendar.get(Calendar.MINUTE);
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);


                        dateAndTime.setText("Date: " + dayOfWeek + " - " + date + "/" + month + "/" + year +
                                "\nTime: " + hour + ":" + minute + ":" + second);

                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }


    private String getDayOfWeek(int value) {
        String day = null;
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }
}
