package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.Command;
import au.com.codepractice.general.toyrobot.core.commands.PlaceCommand;
import au.com.codepractice.general.toyrobot.io.ConsoleInputReader;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Optional;

public class CommandInputReaderTest {
    @Test
    public void testReadCommand(){
        InputProcessor inputProcessor = Mockito.mock(InputProcessor.class);
        ConsoleInputReader inputReader = Mockito.mock(ConsoleInputReader.class);

        CommandInputReader commandInputReader = new CommandInputReader(inputReader, inputProcessor);

        Optional<Command> command = Optional.of(mock(PlaceCommand.class));
        when(inputReader.readInputLine()).thenReturn("PLACE 1,1,NORTH");
        when(inputProcessor.translateInputToCommand("PLACE 1,1,NORTH")).thenReturn(command);

        Optional<Command> inputCommand = commandInputReader.readCommand();
        Assert.assertTrue(inputCommand.isPresent());
        Assert.assertThat(inputCommand, equalTo(command));
    }
}
