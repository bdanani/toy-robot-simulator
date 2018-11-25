package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.*;
import au.com.codepractice.general.toyrobot.core.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.IsEqual.equalTo;

public class InputProcessorTest {
    @Test
    public void testEmptyInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand(null);
        Assert.assertFalse(commandOpt.isPresent());

        commandOpt = inputProcessor.translateInputToCommand("");
        Assert.assertFalse(commandOpt.isPresent());

        commandOpt = inputProcessor.translateInputToCommand("   ");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testLeftCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("LEFT");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertThat(commandOpt.get(), equalTo(new TurnDirectionCommand(Direction.LEFT)));
    }

    @Test
    public void testRightCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("RIGHT");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertThat(commandOpt.get(), equalTo(new TurnDirectionCommand(Direction.RIGHT)));
    }

    @Test
    public void testMoveCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("MOVE");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertTrue(commandOpt.get() instanceof MoveCommand);
    }

    @Test
    public void testReportCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("REPORT");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertTrue(commandOpt.get() instanceof ReportCommand);
    }

    @Test
    public void testPlaceCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1,NORTH");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertTrue(commandOpt.get() instanceof PlaceCommand);
        PlaceCommand placeCommand = (PlaceCommand) commandOpt.get();
        Assert.assertThat(placeCommand.getPlacement(), equalTo(new Placement(new Position(1,1), Orientation.NORTH)));

        commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1,EAST");
        Assert.assertTrue(commandOpt.isPresent());
        placeCommand = (PlaceCommand) commandOpt.get();
        Assert.assertThat(placeCommand.getPlacement(), equalTo(new Placement(new Position(1,1), Orientation.EAST)));

        commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1,WEST");
        Assert.assertTrue(commandOpt.isPresent());
        placeCommand = (PlaceCommand) commandOpt.get();
        Assert.assertThat(placeCommand.getPlacement(), equalTo(new Placement(new Position(1,1), Orientation.WEST)));

        commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1,SOUTH");
        Assert.assertTrue(commandOpt.isPresent());
        placeCommand = (PlaceCommand) commandOpt.get();
        Assert.assertThat(placeCommand.getPlacement(), equalTo(new Placement(new Position(1,1), Orientation.SOUTH)));
    }

    @Test
    public void testPlaceObjectCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("PLACE_OBJECT 1,1");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertTrue(commandOpt.get() instanceof PlaceObjectCommand);
        PlaceObjectCommand placeObjectCommand = (PlaceObjectCommand) commandOpt.get();
        Assert.assertThat(placeObjectCommand.getPlacement(), equalTo(new Placement(new Position(1,1), Orientation.defaultOrientation())));
    }

    @Test
    public void testInvalidMultiWordCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("LEFT TURN");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testInvalidCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("INVALID");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testEmptyCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("");
        Assert.assertFalse(commandOpt.isPresent());
    }


    @Test
    public void testInvalidPlaceCommandInputWithInvalidOrientation() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1,INVALID");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testInvalidPlaceCommandInputWithEmptyOrientation() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("PLACE 1,1, ");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testInvalidPlaceObjectCommandInput() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("PLACE_OBJECT 1,,,1");
        Assert.assertFalse(commandOpt.isPresent());
    }

    @Test
    public void testExitCommand() {
        InputProcessor inputProcessor = new InputProcessor();
        Optional<Command> commandOpt = inputProcessor.translateInputToCommand("EXIT");
        Assert.assertTrue(commandOpt.isPresent());
        Assert.assertTrue(commandOpt.get() instanceof ExitCommand);
    }

    
}