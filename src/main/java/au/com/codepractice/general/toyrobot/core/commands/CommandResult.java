package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.Placement;

public class CommandResult {
    private String resultMessage;
    private Placement placement;

    public CommandResult(Placement placement){
        this.placement = placement;
    }

    public CommandResult(String messageFormat, Object... arguments){
        this.resultMessage = String.format(messageFormat, arguments);
    }
    public String getResultMessage() {
        return resultMessage;
    }

    public Placement getPlacement() {
        return placement;
    }
}