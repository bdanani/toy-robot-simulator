package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Orientation;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import au.com.codepractice.general.toyrobot.core.domain.Position;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;

public class MoveCommandTest {

    @Test
    public void testMoveNorth() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.NORTH));

        CommandResult  commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(1, 2), Orientation.NORTH)));
    }

    @Test
    public void testMoveSouth() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.SOUTH));

        CommandResult  commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(1, 0), Orientation.SOUTH)));
    }

    @Test
    public void testMoveWest() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.WEST));

        CommandResult  commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(0, 1), Orientation.WEST)));
    }

    @Test
    public void testMoveEast() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.EAST));

        CommandResult  commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getPlacement(), equalTo(
                new Placement(new Position(2, 1), Orientation.EAST)));
    }

    @Test
    public void testMoveBeforePlaceCommandIsApplied() {
        MoveCommand moveCommand = new MoveCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(false);

        CommandResult  commandResult = moveCommand.apply(gameState);
        Assert.assertThat(commandResult.getResultMessage(), equalTo(
                "Robot has not been placed on the board. A valid PLACE command is required before other commands can be applied"));
    }
}
