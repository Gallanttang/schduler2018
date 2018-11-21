package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class PlannerPanel extends JPanel {
    private JLabel dateAndTime;
    private JLabel weather;
    private DateAndTime dt;
    private WeatherPanel wp;

    public PlannerPanel() {
        Dimension size = getPreferredSize();
        size.width = 960;
        size.height = 450;
        setPreferredSize(size);
        dateAndTime = new JLabel();
        dateAndTime.setFont(new Font("Arial", 0, 24));
        clock();

        weather = new JLabel();
        weather.setFont(new Font("Arial", 0, 24));
        weather();


        JButton add_event = new JButton("Add Event");
        JButton find_event = new JButton("Find Event");
        JButton save_plan = new JButton("Save Plan");
        JButton load_plan = new JButton("Load Plan");
        JPanel buttonPane = new JPanel(new GridLayout(1,4));
        buttonPane.add(add_event);
        buttonPane.add(find_event);
        buttonPane.add(save_plan);
        buttonPane.add(load_plan);

        setBorder(BorderFactory.createTitledBorder("Hello, what is your name?"));

        JPanel namePane = new JPanel();
        JLabel name = new JLabel("Name: ");
        JTextField nameField = new JTextField(10);

        JButton confirmBtn = new JButton("Confirm");

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().isEmpty()) {
                    setBorder(BorderFactory.createTitledBorder("Welcome, " + nameField.getText()));
                    remove(namePane);
                    add(buttonPane, BorderLayout.NORTH);

                }
            }
        });

        namePane.add(name,BorderLayout.LINE_START);
        namePane.add(nameField,BorderLayout.LINE_END);
        namePane.add(confirmBtn,BorderLayout.SOUTH);

        setLayout(new BorderLayout());



        //// First Column

        add(namePane, BorderLayout.NORTH);

        add(dateAndTime, BorderLayout.CENTER);

        add(weather, BorderLayout.SOUTH);
    }

    public void clock() {
        Thread threadClock = new Thread() {
            public void run() {
                dt = new DateAndTime();
                try {
                    while (true) {
                        dateAndTime.setText(dt.clock());
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }

    public void weather() {
        Thread threadClock = new Thread() {
            public void run() {
                wp = new WeatherPanel();
                try {
                    while (true) {
                        weather.setText(wp.weather());
                        sleep(10000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }
}

