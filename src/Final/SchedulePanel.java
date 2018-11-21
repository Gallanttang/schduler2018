package Final;

import model.DaySchedule;
import model.Event;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class SchedulePanel extends JPanel{
    DateAndTime dt;
    HandleSchedule hs;
    JTable table;

    public SchedulePanel(){
        dt = new DateAndTime();
        hs = new HandleSchedule();
        hs.generateSchedule();

        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        //setLayout(new BoxLayout(new Container(), 0));
        setBorder(BorderFactory.createTitledBorder("Health schedule for today"));

        ArrayList<ArrayList<String>> data = hs.printOutSchedule(dt.dayOfWeek());

        String[] columnNames = {"Event", "Time"};

        table = new JTable(4,12);
        table.setName(dt.dayOfWeek());
        table.setBounds(0,0,200,700);
        fillTable();

        GridBagConstraints gc = new GridBagConstraints();

        //// First Column
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 10;
        gc.weighty = 10;
        gc.gridx = 0;
        gc.gridy = 0;
        add(table,gc);

    }

    private void fillTable() {
        for (Map.Entry<String, DaySchedule> entry: hs.getWs().getWeekSchedule().entrySet()) {
            if (dt.dayOfWeek().equalsIgnoreCase(entry.getKey())) {
                for (Map.Entry<Integer, Event> e : entry.getValue().getDaySchedule().entrySet()) {
                    String name;
                    if(null!=e.getValue()){
                        name = e.getValue().getName();
                    } else name = "Free";
                    int time = e.getKey();
                    if(time < 12){
                        if(time!=0){
                        table.setValueAt(time+ "AM",0,time);
                        table.setValueAt(name, 1,time);
                        } else {
                            table.setValueAt( 12+ "AM",0,time);
                            table.setValueAt(name, 1,time);
                        }
                    } else {
                        if(time == 12){
                            table.setValueAt(time + "PM",2,time-12);
                            table.setValueAt(name, 3,time-12);
                        } else {
                        table.setValueAt(time - 12 + "PM",2,time-12);
                        table.setValueAt(name, 3,time-12);}
                    }

                }
            }
        }
    }
}
