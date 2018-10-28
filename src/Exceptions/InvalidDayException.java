package Exceptions;

public class InvalidDayException extends Exception{
    public InvalidDayException(String day){
        super(day + " is not a valid day of the week.");
    }
}
