package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlannerPanel extends JPanel{
    public PlannerPanel(){
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Hello, what is your name?"));

        JLabel name = new JLabel("Name: ");

        JTextField nameField = new JTextField(10);

        JButton confirmBtn = new JButton("Confirm");

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nameField.getText().isEmpty()){
                setBorder(BorderFactory.createTitledBorder("Welcome, " + nameField.getText()));
                remove(name);
                remove(nameField);
                remove(confirmBtn);
            }}
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First Column

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;

        add(name, gc);

        //// Second Column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField);


        //// Final row
        gc.weighty = 10;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(confirmBtn, gc);
    }
}
