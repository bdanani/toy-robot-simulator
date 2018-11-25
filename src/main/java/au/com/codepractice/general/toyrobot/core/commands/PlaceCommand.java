package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.*;

public class PlaceCommand implements Command {

    private Placement placement;

    public PlaceCommand(Placement placement){
        this.placement = placement;
    }

    @Override
    public CommandResult apply(GameState gameState) {
        return new CommandResult(placement);
    }

    public Placement getPlacement() {
        return placement;
    }
}