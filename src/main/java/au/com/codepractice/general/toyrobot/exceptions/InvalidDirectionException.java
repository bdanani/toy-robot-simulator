package au.com.codepractice.general.toyrobot.exceptions;

public class InvalidDirectionException extends Exception {
    public InvalidDirectionException(String message) {
        super(message);
    }

    public InvalidDirectionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}