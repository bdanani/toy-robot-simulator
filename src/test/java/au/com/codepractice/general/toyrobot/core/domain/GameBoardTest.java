package au.com.codepractice.general.toyrobot.core.domain;

import com.google.common.primitives.UnsignedInteger;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.core.IsEqual.equalTo;


public class GameBoardTest {

    private Dimension fiveByFiveDimension = new Dimension(UnsignedInteger.valueOf(5), UnsignedInteger.valueOf(5));

    @Test
    public void testValidPosition() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Assert.assertTrue(gameBoard.isPositionWithinBounds(new Position(0,0)));
        Assert.assertTrue(gameBoard.isPositionWithinBounds(new Position(4,4)));
    }

    @Test
    public void testInvalidPositionAtBoundary() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Assert.assertFalse(gameBoard.isPositionWithinBounds(new Position(5,0)));
        Assert.assertFalse(gameBoard.isPositionWithinBounds(new Position(0,5)));
    }

    @Test
    public void testInvalidNegativePosition() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Assert.assertFalse(gameBoard.isPositionWithinBounds(new Position(-1,4)));
        Assert.assertFalse(gameBoard.isPositionWithinBounds(new Position(4,-1)));
    }

    @Test
    public void testNullPosition() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Assert.assertFalse(gameBoard.isPositionWithinBounds(null));
    }

    @Test
    public void testInsertAndClearBoard() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Position position = new Position(1,1);
        BoardObject boardObject = Mockito.mock(BoardObject.class);

        gameBoard.placeBoardObjectAtPosition(position, boardObject);
        Assert.assertThat(gameBoard.boardObjectAtPosition(position), equalTo(boardObject));

        gameBoard.clearBoardObjectAtPosition(position);
        Assert.assertThat(gameBoard.boardObjectAtPosition(position), equalTo(null));
    }

    @Test
    public void testInsertAndClearBoardWithInvalidPosition() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Position position = new Position(1,1);
        BoardObject boardObject = Mockito.mock(BoardObject.class);

        gameBoard.placeBoardObjectAtPosition(position, null);
        Assert.assertFalse(gameBoard.isPositionAlreadyOccupied(position));

        gameBoard.placeBoardObjectAtPosition(position, boardObject);
        Assert.assertTrue(gameBoard.isPositionAlreadyOccupied(position));

        gameBoard.clearBoardObjectAtPosition(null);
        Assert.assertTrue(gameBoard.isPositionAlreadyOccupied(position));
    }

    @Test
    public void testPositionOccupied() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Position position = new Position(1,1);
        BoardObject boardObject = Mockito.mock(BoardObject.class);

        gameBoard.placeBoardObjectAtPosition(position, boardObject);
        Assert.assertTrue(gameBoard.isPositionAlreadyOccupied(position));
    }
}
