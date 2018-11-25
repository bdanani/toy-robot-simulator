package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.*;
import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.exceptions.InvalidPlacementException;
import au.com.codepractice.general.toyrobot.utils.BoardObjectPlacementUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RobotSimulatorGame {
    private static final Logger logger = LoggerFactory.getLogger(RobotSimulatorGame.class);

    private final GameBoard gameBoard;
    private final GameState gameState;
    private final ToyRobot toyRobot;
    private final BoardObjectPlacementUtil placementUtil;


    public RobotSimulatorGame(GameBoard gameBoard, GameState gameState, ToyRobot toyRobot, BoardObjectPlacementUtil placementUtil) {
        this.gameBoard = gameBoard;
        this.gameState = gameState;
        this.toyRobot = toyRobot;
        this.placementUtil = placementUtil;
    }

    public void processCommand(Command command) {
        CommandResult commandResult = command.apply(gameState);
        if (commandResult.getPlacement() != null){
            processCommandWithPlacement(command, commandResult.getPlacement());
        } else if (StringUtils.isNotEmpty(commandResult.getResultMessage())){
            logger.info(commandResult.getResultMessage());
        }
    }

    private void processCommandWithPlacement(Command command, Placement placement){
        try {
            if (command instanceof PlaceObjectCommand) {
                placementUtil.placeAt(new Obstacle(), gameBoard, gameState, placement);
            } else {
                placementUtil.placeAt(toyRobot, gameBoard, gameState, placement);
            }
        } catch (InvalidPlacementException e){
            logger.error(e.getMessage());
        }
    }
}