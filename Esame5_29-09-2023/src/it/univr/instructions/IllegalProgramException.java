package it.univr.instructions;

public class IllegalProgramException extends RuntimeException {
    public IllegalProgramException(String message) {
        super(message);
    }
}
