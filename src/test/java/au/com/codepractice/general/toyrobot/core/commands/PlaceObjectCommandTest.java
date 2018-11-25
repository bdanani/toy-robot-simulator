package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;

public class PlaceObjectCommandTest {
    @Test
    public void testPlaceObjectCommandPlacement() {
        GameState gameState = Mockito.mock(GameState.class);
        Placement placement = Mockito.mock(Placement.class);
        PlaceObjectCommand placeObjectCommand = new PlaceObjectCommand(placement);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Assert.assertThat(placeObjectCommand.apply(gameState).getPlacement(), equalTo(placement));
    }

    @Test
    public void testPlaceObjectCommandBeforeRobotIsPlaced() {
        GameState gameState = Mockito.mock(GameState.class);
        Placement placement = Mockito.mock(Placement.class);
        PlaceObjectCommand placeObjectCommand = new PlaceObjectCommand(placement);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(false);

        CommandResult  commandResult = placeObjectCommand.apply(gameState);
        Assert.assertThat(commandResult.getResultMessage(), equalTo(
                "Robot has not been placed on the board. A valid PLACE command is required before other commands can be applied"));
    }
}
