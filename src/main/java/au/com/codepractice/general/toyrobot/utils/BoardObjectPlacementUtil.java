package au.com.codepractice.general.toyrobot.utils;

import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.exceptions.InvalidPlacementException;

public class BoardObjectPlacementUtil {
    private static BoardObjectPlacementUtil INSTANCE;

    private BoardObjectPlacementUtil(){
        // Private constructor
    }

    public static BoardObjectPlacementUtil getInstance(){
        if (INSTANCE == null){
            INSTANCE = new BoardObjectPlacementUtil();
        }
        return INSTANCE;
    }

    public void placeAt(BoardObject boardObject, GameBoard gameBoard, GameState gameState, Placement placement) throws InvalidPlacementException{
        if (gameBoard.isPositionAlreadyOccupied(placement.getPosition())) {

            throw new InvalidPlacementException(String.format("Failed to place %s on position %s. The position has been used",
                    boardObject.getClass().getName(), placement.getPosition().toString()));

        } else if (! gameBoard.isPositionWithinBounds(placement.getPosition())) {

            throw new InvalidPlacementException(String.format("Oops... Cannot move to %s as it is outside the boundary.", placement.getPosition().toString()));

        } else {
            placeBasedOnObjectType(boardObject, gameBoard, gameState, placement);
        }
    }

    private void placeBasedOnObjectType(BoardObject boardObject, GameBoard gameBoard, GameState gameState, Placement placement){
        if (boardObject instanceof ToyRobot) {
            if (gameState.getToyRobotPlacement() != null) {
                gameBoard.clearBoardObjectAtPosition(gameState.getToyRobotPlacement().getPosition());
            }
            gameState.setToyRobotPlacement(placement);
        }

        boardObject.setPlacement(placement);
        gameBoard.placeBoardObjectAtPosition(placement.getPosition(), boardObject);
    }
}
