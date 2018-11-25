package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;
import au.com.codepractice.general.toyrobot.core.domain.Orientation;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import au.com.codepractice.general.toyrobot.core.domain.Position;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.IsEqual.equalTo;

public class ReportCommandTest {

    @Test
    public void testReportStatus(){
        ReportCommand reportCommand = new ReportCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(true);
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(
                new Placement(new Position(1, 1), Orientation.NORTH));

        CommandResult  commandResult = reportCommand.apply(gameState);
        Assert.assertThat(commandResult.getResultMessage(), equalTo("Robot is at Location (1,1,NORTH)"));
    }
    @Test
    public void testReportStatusBeforePlaceCommandIsApplied() {
        ReportCommand reportCommand = new ReportCommand();
        GameState gameState = Mockito.mock(GameState.class);

        Mockito.when(gameState.isToyRobotPlaced()).thenReturn(false);

        CommandResult  commandResult = reportCommand.apply(gameState);
        Assert.assertThat(commandResult.getResultMessage(), equalTo(
                "Robot has not been placed on the board. A valid PLACE command is required before other commands can be applied"));
    }
}
