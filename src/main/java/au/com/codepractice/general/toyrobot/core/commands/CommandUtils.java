package au.com.codepractice.general.toyrobot.core.commands;

public class CommandUtils {
    public static CommandResult robotHasNotBeenPlaced(){
        return new CommandResult("Robot has not been placed on the board. A valid PLACE command is required before other commands can be applied");
    }
}
