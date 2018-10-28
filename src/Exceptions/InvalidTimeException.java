package Exceptions;

public class InvalidTimeException extends Exception{
    public InvalidTimeException(int time){
        super("Time value " + time + " is not accepted");
    }

}
