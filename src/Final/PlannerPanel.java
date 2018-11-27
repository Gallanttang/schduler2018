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
    private WeatherAPI wp;
    private UserInput ui;
    private HandleSchedule hs;

    public PlannerPanel(HandleSchedule handleSchedule, DateAndTime dnt) {
        this.hs = handleSchedule;
        this.dt = dnt;

        Dimension size = getPreferredSize();
        size.width = 960;
        size.height = 250;
        setPreferredSize(size);

        // set up
        setBorder(BorderFactory.createTitledBorder("Hello, what is your name?"));

        dateAndTime= new JLabel();
        dateAndTime.setFont(new Font("Arial", 0, 24));
        clock();

        weather = new JLabel();
        weather.setFont(new Font("Arial", 0, 24));
        weather();

        JPanel userInput = new JPanel();
        JLabel name = new JLabel("Name: ");
        JTextField nameField = new JTextField(10);

        JButton confirmBtn = new JButton("Confirm");

        ui= new UserInput(hs);

        userInput.add(name,BorderLayout.LINE_START);
        userInput.add(nameField,BorderLayout.LINE_END);
        userInput.add(confirmBtn,BorderLayout.SOUTH);


        setLayout(new BorderLayout());

        // Button Functions
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().isEmpty()) {
                    setBorder(BorderFactory.createTitledBorder("Welcome, " + nameField.getText()));
                    userInput.removeAll();
                    ui.toggleChange();
                    userInput.add(ui.buttonPane);
                }
            }
        });

        //// First Column

        add(userInput, BorderLayout.NORTH);

        add(dateAndTime, BorderLayout.CENTER);

        add(weather, BorderLayout.SOUTH);
    }

    private void clock() {
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

    private void weather() {
        Thread threadClock = new Thread() {
            public void run() {
                wp = new WeatherAPI();
                try {
                    while (true) {
                        weather.setText(wp.weather());
                        sleep(1000000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }
}

