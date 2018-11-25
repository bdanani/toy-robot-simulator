package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.Command;
import au.com.codepractice.general.toyrobot.io.InputReader;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class CommandInputReader {
    private final InputReader inputReader;
    private final InputProcessor inputProcessor;

    public CommandInputReader(InputReader inputReader, InputProcessor inputProcessor){
        this.inputReader = inputReader;
        this.inputProcessor = inputProcessor;
    }

    public Optional<Command> readCommand(){
        String inputLine = inputReader.readInputLine();

        if (! StringUtils.isEmpty(inputLine)) {
            return inputProcessor.translateInputToCommand(inputLine);
        }
        return Optional.empty();
    }
}
