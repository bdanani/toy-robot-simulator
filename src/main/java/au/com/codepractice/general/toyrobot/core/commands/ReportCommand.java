package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Placement;

public class ReportCommand implements Command {

    @Override
    public CommandResult apply(GameState gameState) {
        if(gameState.getToyRobotPlacement() == null){
            return CommandUtils.robotHasNotBeenPlaced();
        }
        return new CommandResult(buildStatusMessage(gameState.getToyRobotPlacement()));
    }

    private String buildStatusMessage(Placement placement) {
        return "Robot is at Location (" + placement.getPosition().getXPos() + "," + placement.getPosition().getYPos() +
                "," + placement.getOrientation().name() + ")";
    }
}
