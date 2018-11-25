package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.*;
import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.exceptions.InvalidPlacementException;
import au.com.codepractice.general.toyrobot.utils.BoardObjectPlacementUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class CommandProcessorTest {

    private GameBoard gameBoard;
    private GameState gameState;
    private ToyRobot toyRobot;
    private Placement placement;
    private BoardObjectPlacementUtil placementUtil;

    @Before
    public void setupTestFixture() throws InvalidPlacementException {
        gameBoard = Mockito.mock(GameBoard.class);
        gameState = Mockito.mock(GameState.class);
        toyRobot = Mockito.mock(ToyRobot.class);
        placement = Mockito.mock(Placement.class);
        placementUtil = Mockito.mock(BoardObjectPlacementUtil.class);
        when(gameState.isToyRobotPlaced()).thenReturn(true);
        doNothing().when(placementUtil).placeAt(toyRobot, gameBoard, gameState, placement);
    }

    @Test
    public void testProcessPlaceCommand() throws InvalidPlacementException {
        setupTestFixture();
        CommandProcessor commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, placementUtil);
        PlaceCommand placeCommand = new PlaceCommand(placement);
        commandProcessor.processCommand(placeCommand);
        verify(placementUtil, times(1)).placeAt(toyRobot, gameBoard, gameState, placement);
    }

    @Test
    public void testProcessMoveCommand() throws InvalidPlacementException {
        setupTestFixture();
        MoveCommand moveCommand = Mockito.mock(MoveCommand.class);
        when(moveCommand.apply(gameState)).thenReturn(new CommandResult(placement));

        CommandProcessor commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, placementUtil);

        commandProcessor.processCommand(moveCommand);
        verify(placementUtil, times(1)).placeAt(toyRobot, gameBoard, gameState, placement);
    }

    @Test
    public void testProcessTurnDirectionCommand() throws InvalidPlacementException {
        setupTestFixture();
        TurnDirectionCommand turnDirectionCommand = Mockito.mock(TurnDirectionCommand.class);
        when(turnDirectionCommand.apply(gameState)).thenReturn(new CommandResult(placement));

        CommandProcessor commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, placementUtil);

        commandProcessor.processCommand(turnDirectionCommand);
        verify(placementUtil, times(1)).placeAt(toyRobot, gameBoard, gameState, placement);
    }


    @Test
    public void testProcessReportCommand() throws InvalidPlacementException {
        setupTestFixture();
        ReportCommand reportCommand = Mockito.mock(ReportCommand.class);
        CommandResult commandResult = Mockito.mock(CommandResult.class);

        when(commandResult.getPlacement()).thenReturn(null);
        when(commandResult.getResultMessage()).thenReturn("ROBOT POSITION");
        when(reportCommand.apply(gameState)).thenReturn(commandResult);

        CommandProcessor commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, placementUtil);

        commandProcessor.processCommand(reportCommand);

        verify(commandResult, times(2)).getResultMessage();
    }


    @Test
    public void testProcessPlaceObjectCommand() throws InvalidPlacementException {
        setupTestFixture();
        ArgumentCaptor<BoardObject> obstacleArgumentCaptor = ArgumentCaptor.forClass(BoardObject.class);
        ArgumentCaptor<GameBoard> gameboardCaptor = ArgumentCaptor.forClass(GameBoard.class);
        ArgumentCaptor<GameState> gameStateCaptor = ArgumentCaptor.forClass(GameState.class);
        ArgumentCaptor<Placement> placementCaptor = ArgumentCaptor.forClass(Placement.class);

        CommandProcessor commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, placementUtil);
        PlaceObjectCommand placeObjectCommand = new PlaceObjectCommand(placement);

        commandProcessor.processCommand(placeObjectCommand);
        verify(placementUtil, times(1)).placeAt(obstacleArgumentCaptor.capture(), gameboardCaptor.capture(), gameStateCaptor.capture(), placementCaptor.capture());
        Assert.assertTrue(obstacleArgumentCaptor.getValue() instanceof Obstacle);
    }
}