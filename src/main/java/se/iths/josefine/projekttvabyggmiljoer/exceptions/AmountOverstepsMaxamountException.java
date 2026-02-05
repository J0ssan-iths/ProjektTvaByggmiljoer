package se.iths.josefine.projekttvabyggmiljoer.exceptions;

public class AmountOverstepsMaxamountException extends RuntimeException {
    public AmountOverstepsMaxamountException(String message) {
        super(message);
    }
}
