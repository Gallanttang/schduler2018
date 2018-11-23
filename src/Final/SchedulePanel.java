package Final;

import model.DaySchedule;
import model.Event;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SchedulePanel extends JPanel{
    private JTable table;
    private HandleSchedule hs;
    private DateAndTime dt;

    public SchedulePanel(HandleSchedule handleSchedule, DateAndTime dt){
        hs = handleSchedule;
        this.dt = dt;

        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        //setLayout(new BoxLayout(new Container(), 0));
        setBorder(BorderFactory.createTitledBorder("Health schedule for today"));

        table = new JTable(4,12);
        table.setName(dt.dayOfWeek());
        table.setBounds(0,0,200,700);
        scheduler();

        add(table);
    }

    private void scheduler() {
        Thread threadClock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        fillTable();
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadClock.start();
    }

    private void fillTable() {
        for (Map.Entry<String, DaySchedule> entry: hs.getWs().getWeekSchedule().entrySet()) {
            if (dt.dayOfWeek().equalsIgnoreCase(entry.getKey())) {
                for (Map.Entry<Integer, Event> e : entry.getValue().getDaySchedule().entrySet()) {
                    String name;
                    if(null!=e.getValue()){
                        name = e.getValue().getName();
                    } else name = "";
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
