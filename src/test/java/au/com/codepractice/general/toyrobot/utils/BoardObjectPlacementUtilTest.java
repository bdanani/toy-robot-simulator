package au.com.codepractice.general.toyrobot.utils;

import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.exceptions.InvalidPlacementException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class BoardObjectPlacementUtilTest {

    @Test
    public void testPlaceToyRobotAtAValidPosition() throws InvalidPlacementException {
        // GIVEN
        BoardObject toyRobot = new ToyRobot();
        GameState gameState = Mockito.mock(GameState.class);
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        Placement currentPlacement = new Placement(new Position(1,0), Orientation.NORTH);
        Placement newPlacement = new Placement(new Position(1,1), Orientation.NORTH);

        // WHEN
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(currentPlacement);
        Mockito.when(gameBoard.isPositionAlreadyOccupied(newPlacement.getPosition())).thenReturn(false);
        Mockito.when(gameBoard.isPositionWithinBounds(newPlacement.getPosition())).thenReturn(true);

        BoardObjectPlacementUtil.getInstance().placeAt(toyRobot, gameBoard, gameState, newPlacement);

        // THEN
        Mockito.verify(gameBoard, times(1)).clearBoardObjectAtPosition(currentPlacement.getPosition());
        Mockito.verify(gameBoard, times(1)).placeBoardObjectAtPosition(newPlacement.getPosition(), toyRobot);
        Mockito.verify(gameState, times(1)).setToyRobotPlacement(newPlacement);

        Assert.assertThat(toyRobot.getPlacement(), equalTo(newPlacement));
    }


    @Test(expected = InvalidPlacementException.class)
    public void testPlaceToyRobotAtOutsideBoundaryPosition() throws InvalidPlacementException {
        // GIVEN
        BoardObject toyRobot = new ToyRobot();
        GameState gameState = Mockito.mock(GameState.class);
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        Placement currentPlacement = new Placement(new Position(1,0), Orientation.NORTH);
        Placement newPlacement = new Placement(new Position(1,1), Orientation.NORTH);

        // WHEN
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(currentPlacement);
        Mockito.when(gameBoard.isPositionAlreadyOccupied(newPlacement.getPosition())).thenReturn(false);
        Mockito.when(gameBoard.isPositionWithinBounds(newPlacement.getPosition())).thenReturn(false);

        BoardObjectPlacementUtil.getInstance().placeAt(toyRobot, gameBoard, gameState, newPlacement);
    }

    @Test(expected = InvalidPlacementException.class)
    public void testPlaceToyRobotAtAnOccupiedPosition() throws InvalidPlacementException {
        // GIVEN
        BoardObject toyRobot = new ToyRobot();
        GameState gameState = Mockito.mock(GameState.class);
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        Placement currentPlacement = new Placement(new Position(1,0), Orientation.NORTH);
        Placement newPlacement = new Placement(new Position(1,1), Orientation.NORTH);

        // WHEN
        Mockito.when(gameState.getToyRobotPlacement()).thenReturn(currentPlacement);
        Mockito.when(gameBoard.isPositionAlreadyOccupied(newPlacement.getPosition())).thenReturn(true);
        Mockito.when(gameBoard.boardObjectAtPosition(newPlacement.getPosition())).thenReturn(new Obstacle());

        BoardObjectPlacementUtil.getInstance().placeAt(toyRobot, gameBoard, gameState, newPlacement);
    }

    @Test
    public void testPlaceObstacle() throws InvalidPlacementException {
        // GIVEN
        BoardObject obstacle = new Obstacle();
        GameState gameState = Mockito.mock(GameState.class);
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        Placement newPlacement = new Placement(new Position(1,1), Orientation.NORTH);

        // WHEN
        Mockito.when(gameBoard.isPositionAlreadyOccupied(newPlacement.getPosition())).thenReturn(false);
        Mockito.when(gameBoard.isPositionWithinBounds(newPlacement.getPosition())).thenReturn(true);

        BoardObjectPlacementUtil.getInstance().placeAt(obstacle, gameBoard, gameState, newPlacement);

        // THEN
        Mockito.verify(gameBoard, times(1)).placeBoardObjectAtPosition(newPlacement.getPosition(), obstacle);

        Assert.assertThat(obstacle.getPlacement(), equalTo(newPlacement));
    }
}
