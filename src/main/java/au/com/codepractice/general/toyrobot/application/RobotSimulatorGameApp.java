package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.Command;
import au.com.codepractice.general.toyrobot.core.commands.ExitCommand;
import au.com.codepractice.general.toyrobot.core.domain.*;
import au.com.codepractice.general.toyrobot.io.ConsoleInputReader;
import au.com.codepractice.general.toyrobot.utils.BoardObjectPlacementUtil;
import com.google.common.primitives.UnsignedInteger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Optional;

@SpringBootApplication
public class RobotSimulatorGameApp implements CommandLineRunner {

    private RobotSimulatorGame robotSimulatorGame;
    private CommandInputReader commandInputReader;
    private boolean isGameActive;

    public RobotSimulatorGameApp(){
        robotSimulatorGame = new RobotSimulatorGame(
                new GameBoard(new Dimension(UnsignedInteger.valueOf(5), UnsignedInteger.valueOf(5))),
                new GameState(),
                new ToyRobot(),
                BoardObjectPlacementUtil.getInstance());

        commandInputReader = new CommandInputReader(
                new ConsoleInputReader(), new InputProcessor());

        isGameActive = true;
    }


    public static void main(String[] args){
        new SpringApplicationBuilder(RobotSimulatorGameApp.class).web(false).run(args);
    }


    @Override
    public void run(String... args) {
        while (isGameActive){
            Optional<Command> commandOpt = commandInputReader.readCommand();

            commandOpt.ifPresent(command -> {
                if (command instanceof ExitCommand){
                    isGameActive = false;
                } else {
                    robotSimulatorGame.processCommand(command);
                }
            });
        }
    }
}