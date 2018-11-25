package au.com.codepractice.general.toyrobot.core.domain;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;


public class GameStateTest {

    @Test
    public void testInitialState() {
        GameState gameState = new GameState();
        Assert.assertFalse(gameState.isToyRobotPlaced());
        Assert.assertNull(gameState.getToyRobotPlacement());
    }

    @Test
    public void testToyRobotPlacement() {
        GameState gameState = new GameState();
        Placement placement = new Placement(new Position(1,1), Orientation.NORTH);
        gameState.setToyRobotPlacement(placement);
        Assert.assertTrue(gameState.isToyRobotPlaced());
        Assert.assertThat(gameState.getToyRobotPlacement(), IsEqual.equalTo(placement));
    }

    @Test
    public void testToyRobotNotPlaced() {
        GameState gameState = new GameState();
        gameState.setToyRobotPlacement(null);
        Assert.assertFalse(gameState.isToyRobotPlaced());
    }
}
