package Final;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateAndTime{
    private int hour;

    public int getHour() {
        return hour;
    }

    public String dayOfWeek(){
       Calendar calendar = new GregorianCalendar(); // creates a new calendar instance
       int day = calendar.get(Calendar.DAY_OF_WEEK);
       return getDayOfWeek(day);
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

    public String clock() {
        Calendar calendar = new GregorianCalendar(); // creates a new calendar instance
        String dayOfWeek = dayOfWeek();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        int second = calendar.get(Calendar.SECOND);

        int minute = calendar.get(Calendar.MINUTE);

        hour = calendar.get(Calendar.HOUR_OF_DAY);

        String dt = "Date: " + dayOfWeek + " - " + date + "/" + month + "/" + year +
                "\nTime: ";

        if(hour < 10){
            dt = dt + "0" + hour;
        } else {
            dt = dt + hour;
        }
        if(minute < 10){
            dt = dt + ":" + "0" + minute;
        } else {
            dt = dt + ":" + minute;
        }
        if(second < 10){
            dt = dt + ":" + "0" + second;
        } else {
            dt = dt + ":" + second;
        }

        return dt;
   }
}
