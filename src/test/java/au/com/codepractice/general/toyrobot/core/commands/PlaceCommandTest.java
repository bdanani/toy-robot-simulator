package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Orientation;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import au.com.codepractice.general.toyrobot.core.domain.Position;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;

public class PlaceCommandTest {
    @Test
    public void testPlaceCommandPlacement() {
        GameState gameState = Mockito.mock(GameState.class);
        Placement placement = new Placement(new Position(1,1), Orientation.NORTH);
        PlaceCommand placeCommand = new PlaceCommand(placement);
        Assert.assertThat(placeCommand.apply(gameState).getPlacement(), equalTo(placement));
    }
}
