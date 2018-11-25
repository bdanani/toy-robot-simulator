package au.com.codepractice.general.toyrobot.exceptions;

public class InvalidPlacementException extends Exception {
    public InvalidPlacementException(String message) {
        super(message);
    }

    public InvalidPlacementException(String message, Throwable throwable) {
        super(message, throwable);
    }
}