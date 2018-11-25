package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.*;
import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.utils.BoardObjectPlacementUtil;

public class RobotSimulatorGame {
    private final CommandProcessor commandProcessor;

    public RobotSimulatorGame(GameBoard gameBoard) {
        ToyRobot toyRobot = new ToyRobot();
        GameState gameState = new GameState();
        this.commandProcessor = new CommandProcessor(gameBoard, gameState, toyRobot, BoardObjectPlacementUtil.getInstance());
    }

    public void addCommand(Command command) {
        commandProcessor.processCommand(command);
    }
}