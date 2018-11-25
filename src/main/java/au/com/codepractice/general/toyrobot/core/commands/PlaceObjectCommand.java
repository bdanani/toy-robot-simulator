package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.*;

public class PlaceObjectCommand implements Command {

    private Placement placement;

    public PlaceObjectCommand(Placement placement){
        this.placement = placement;
    }

    @Override
    public CommandResult apply(final GameState gameState) {
        if (! gameState.isToyRobotPlaced()){
            return CommandUtils.robotHasNotBeenPlaced();
        }
        return new CommandResult(placement);
    }

    public Placement getPlacement() {
        return placement;
    }
}