package au.com.codepractice.general.toyrobot.core.domain;

import java.util.HashMap;
import java.util.Map;


public class GameBoard {
    private final Dimension dimension;
    private Map<Position, BoardObject> boardObjects = new HashMap<>();

    public GameBoard(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Check that a given position is within the boundary of the GameBoard.
     * @param position: A given position with X and Y coordinate position
     * @return true if the position is within the boundary of the board. False otherwise.
     */
    public boolean isPositionWithinBounds(Position position) {
        if (position == null)
            return false;

        return (position.getXPos() >= 0
                && position.getXPos() < dimension.getWidth().intValue()
                && position.getYPos() >=0
                && position.getYPos() < dimension.getHeight().intValue());
    }

    public void clearBoardObjectAtPosition(Position position) {
        if (position != null)
            boardObjects.put(position, null);
    }

    public void placeBoardObjectAtPosition(Position position, BoardObject boardObject) {
        if (position != null && boardObject != null)
            boardObjects.put(position, boardObject);
    }

    public BoardObject boardObjectAtPosition(Position position) {
        return boardObjects.get(position);
    }

    public boolean isPositionAlreadyOccupied(Position position){
        return boardObjectAtPosition(position) != null;
    }
}
