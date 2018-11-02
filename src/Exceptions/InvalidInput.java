package Exceptions;

public class InvalidInput extends Exception{
    public InvalidInput(double i){
        super("Input value must be what was asked not " + i);
    }
}
