package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import au.com.codepractice.general.toyrobot.core.domain.Position;
import lombok.Generated;

public class MoveCommand implements Command {

    @Override
    public CommandResult apply(GameState gameState) {
        if (! gameState.isToyRobotPlaced()){
            return CommandUtils.robotHasNotBeenPlaced();
        }
        Placement newPlacementToMove = calculatePlacementToMoveTo(gameState.getToyRobotPlacement());
        return new CommandResult(newPlacementToMove);
    }

    private Placement calculatePlacementToMoveTo(Placement placement){
        Position position = null;
        switch (placement.getOrientation()) {
            case NORTH:
                position = placement.getPosition().incrementY(); break;
            case EAST:
                position = placement.getPosition().incrementX(); break;
            case SOUTH:
                position = placement.getPosition().decrementY(); break;
            case WEST:
                position = placement.getPosition().decrementX(); break;
        }

        return new Placement(position, placement.getOrientation());
    }

    @Generated
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Generated
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
