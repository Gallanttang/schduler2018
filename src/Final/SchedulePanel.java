package Final;

import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel{
    public SchedulePanel(){
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Hello, what is your name?"));

        JLabel name = new JLabel("Name: ");

        JTextField nameField = new JTextField(10);


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

    }

}
