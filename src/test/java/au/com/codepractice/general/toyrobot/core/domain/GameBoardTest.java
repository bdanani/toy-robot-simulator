package au.com.codepractice.general.toyrobot.core.domain;

import com.google.common.primitives.UnsignedInteger;
import org.junit.Assert;
import org.junit.Test;


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
    }

    @Test
    public void testInvalidNegativePosition() {
        GameBoard gameBoard = new GameBoard(fiveByFiveDimension);
        Assert.assertFalse(gameBoard.isPositionWithinBounds(new Position(-1,4)));
    }
}
