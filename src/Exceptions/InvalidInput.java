package Exceptions;

public class InvalidInput extends Exception{
    public InvalidInput(double i){
        super("Input value must be 1, 2, 3, or 4 not " + i);
    }
}
