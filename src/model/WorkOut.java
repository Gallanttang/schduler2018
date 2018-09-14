package model;

public class WorkOut {
    private int timew;
    private String day;
    private String work;

    public WorkOut (int timew, String day, String work){
        this.timew = timew;
        this.day = day;
        this.work = work;
    }



    public int getTimew() {
        return timew;
    }

    public String getDay() {
        return day;
    }

    public String getWork() {
        return work;
    }

    public void printWorkOut(){
        System.out.println("If today is" + day + " and it is " + timew + " then you should" + work);
    }
}
