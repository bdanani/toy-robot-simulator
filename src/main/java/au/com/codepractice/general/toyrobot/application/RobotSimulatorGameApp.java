package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.Command;
import au.com.codepractice.general.toyrobot.core.domain.*;
import com.google.common.primitives.UnsignedInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.Console;
import java.util.Optional;

@SpringBootApplication
public class RobotSimulatorGameApp implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(RobotSimulatorGameApp.class);
    private RobotSimulatorGame robotSimulatorGame;

    public static void main(String[] args){
        new SpringApplicationBuilder(RobotSimulatorGameApp.class).web(false).run(args);
    }

    @Override
    public void run(String... args) {
        robotSimulatorGame = new RobotSimulatorGame(
                new GameBoard(new Dimension(UnsignedInteger.valueOf(5), UnsignedInteger.valueOf(5))));

        processInputFromConsole();
    }

    private void processInputFromConsole(){
        Console console = getConsole();
        InputProcessor inputProcessor = new InputProcessor();

        logger.info("Enter Commands Input, or 'EXIT' to quit the application");

        // Keep running until it receives an EXIT input.
        while (true) {
            String inputLine = console.readLine("> ");
            if ("EXIT".equalsIgnoreCase(inputLine)) {
                break;
            } else {
                Optional<Command> commandOpt = inputProcessor.translateInputToCommand(inputLine);
                commandOpt.ifPresent(command -> robotSimulatorGame.addCommand(command));
            }
        }
    }


    private Console getConsole() {
        Console console = System.console();

        if (console == null) {
            throw new RuntimeException("System Console is not available");
        }
        return console;
    }
}