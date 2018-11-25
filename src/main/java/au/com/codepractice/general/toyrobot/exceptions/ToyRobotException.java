package au.com.codepractice.general.toyrobot.exceptions;

public class ToyRobotException extends Exception {
    public ToyRobotException(String message) {
        super(message);
    }

    public ToyRobotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}