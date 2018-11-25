package au.com.codepractice.general.toyrobot.application;

import au.com.codepractice.general.toyrobot.core.commands.*;
import au.com.codepractice.general.toyrobot.core.domain.Direction;
import au.com.codepractice.general.toyrobot.core.domain.Orientation;
import au.com.codepractice.general.toyrobot.core.domain.Placement;
import au.com.codepractice.general.toyrobot.core.domain.Position;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {
    private static final String LEFT   = "LEFT";
    private static final String RIGHT  = "RIGHT";
    private static final String MOVE   = "MOVE";
    private static final String REPORT = "REPORT";
    private static final String NORTH  = "NORTH";
    private static final String EAST   = "EAST";
    private static final String SOUTH  = "SOUTH";
    private static final String WEST   = "WEST";
    private static final String PLACE_OBJECT = "PLACE_OBJECT";

    private static final String  PLACE = "PLACE";
    private static final Pattern PLACE_INPUT_FORMAT = Pattern.compile(PLACE + "(\\s+)(\\d+),(\\d+),(\\w+)");

    private static Logger logger = LoggerFactory.getLogger(InputProcessor.class);

    public Optional<Command> translateInputToCommand(String inputLine) {
        if (StringUtils.isEmpty(inputLine)) {
            logger.warn("Ignoring Empty Commands");
            return Optional.empty();
        }

        inputLine = inputLine.trim();
        return processInputLine(inputLine);
    }

    private Optional<Command> processInputLine(String inputLine){
        switch (inputLine) {
            case LEFT:
                return Optional.of(new TurnDirectionCommand(Direction.LEFT));
            case RIGHT:
                return Optional.of(new TurnDirectionCommand(Direction.RIGHT));
            case MOVE:
                return Optional.of(new MoveCommand());
            case REPORT:
                return Optional.of(new ReportCommand());
            default:
                String inputFirstWord = inputLine.split(" ")[0];
                if (PLACE_OBJECT.equals(inputFirstWord)){
                    return processPlaceObjectCommand(inputLine);
                } else if (PLACE.equals(inputFirstWord)){
                    return processPlaceCommand(inputLine);
                } else {
                    logger.warn("Ignoring Invalid Command : " + inputLine);
                    return Optional.empty();
                }
        }
    }

    private static Optional<Command> processPlaceObjectCommand(String placeObjectCommandString){
        Placement placement = parsePlaceObjectCommand(placeObjectCommandString);
        if (placement != null) {
            return Optional.of(new PlaceObjectCommand(placement));
        } else {
            return Optional.empty();
        }
    }


    private static Placement parsePlaceObjectCommand(String placeObjectCommandString) {
        Matcher matcher = Pattern.compile(PLACE_OBJECT + "(\\s+)(\\d+),(\\d+)").matcher(placeObjectCommandString);
        if (matcher.matches()) {
            Position position = new Position(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            return new Placement(position, Orientation.defaultOrientation());
        }
        logger.warn("Ignoring Invalid Command : " + placeObjectCommandString);
        return null;
    }

    private static Optional<Command> processPlaceCommand(String placeCommandString){
        Placement placement = parsePlaceCommand(placeCommandString);
        if (placement != null) {
            return Optional.of(new PlaceCommand(placement));
        } else {
            return Optional.empty();
        }
    }

    private static Placement parsePlaceCommand(String placeCommandString) {
        Matcher matcher = PLACE_INPUT_FORMAT.matcher(placeCommandString);
        try {
            if (matcher.matches()) {
                Position position = new Position(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                Orientation orientation = parseOrientation(matcher.group(4));
                return new Placement(position, orientation);
            }
            logger.info("Ignoring Invalid Command : " + placeCommandString);
        } catch (IllegalArgumentException e) {
            logger.warn(e.getMessage());
        }

        return null;
    }


    private static Orientation parseOrientation(String orientationString) {
        String trimmedOrientationInput = orientationString.trim();
        if (StringUtils.isEmpty(trimmedOrientationInput)){
            throw new IllegalArgumentException("Empty Orientation");
        } else if (orientationString.equals(NORTH)) {
            return Orientation.NORTH;
        } else if (orientationString.equals(EAST)) {
            return Orientation.EAST;
        } else if (orientationString.equals(SOUTH)) {
            return Orientation.SOUTH;
        } else if (orientationString.equals(WEST)) {
            return Orientation.WEST;
        } else {
            throw new IllegalArgumentException("Unknown Orientation: " + orientationString);
        }
    }
}
