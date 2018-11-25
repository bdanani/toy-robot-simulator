package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.*;
import lombok.Generated;

import java.util.Objects;

public class TurnDirectionCommand implements Command  {

    private final Direction direction;

    public TurnDirectionCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public CommandResult apply(GameState gameState) {
        if (! gameState.isToyRobotPlaced()){
            return CommandUtils.robotHasNotBeenPlaced();
        }
        Placement newPlacementToMove = changeDirectionToMove(gameState.getToyRobotPlacement());
        return new CommandResult((newPlacementToMove));
    }

    private Placement changeDirectionToMove(Placement placement){
        Position position = placement.getPosition();
        Orientation newOrientation = (direction == Direction.LEFT)?
                placement.getOrientation().left() :
                placement.getOrientation().right();

        return new Placement(position, newOrientation);
    }

    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnDirectionCommand that = (TurnDirectionCommand) o;
        return direction == that.direction;
    }

    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}