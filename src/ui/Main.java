package ui;


import java.util.Scanner;

public class Main {

    private static void hello(){
        System.out.println("Hello, what is your name?");
    }
    private static void whatTime(){
        System.out.println("What time is it? (only enter a whole number that's less than 24)");
    }

    public static void main(String[] args) {
        String name;
        int time;

        Scanner reader = new Scanner(System.in);
        hello();
        name = reader.nextLine();
        whatTime();
        time = reader.nextInt();

        MealPlan mp = new MealPlan(time,name);
        mp.greeting();
        mp.notTime();
    }

}
