package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.IsEqual.equalTo;

public class TurnDirectionCommandTest {

    @Test
    public void testMoveNorth() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.NORTH));

        CommandResult commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(1, 2), Orientation.NORTH)));
    }

    @Test
    public void testTurnRightDirection() {
        TurnDirectionCommand turnRightDirectionCommand = new TurnDirectionCommand(Direction.RIGHT);
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.NORTH));

        CommandResult commandResult = turnRightDirectionCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(1, 1), Orientation.EAST)));
    }

    @Test
    public void testTurnLeftDirection() {
        TurnDirectionCommand turnRightDirectionCommand = new TurnDirectionCommand(Direction.LEFT);
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.NORTH));

        CommandResult commandResult = turnRightDirectionCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(1, 1), Orientation.WEST)));
    }

    @Test
    public void testTurnDirectionBeforePlaceCommandIsApplied() {
        TurnDirectionCommand turnDirectionCommand = new TurnDirectionCommand(Direction.LEFT);
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(false);

        CommandResult  commandResult = turnDirectionCommand.apply(gameState);
        Assert.assertThat(commandResult.getResultMessage(), equalTo(
                "Robot has not been placed on the board. A valid PLACE command is required before other commands can be applied"));
    }
}