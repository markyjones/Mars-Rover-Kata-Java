package rover;

import rover.commands.*;
import rover.universe.Orientation;
import rover.universe.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandParser {

    private final Map<Character, ICommand> availableCommands = new HashMap<>();

    public CommandParser(){
        availableCommands.put('L', new TurnLeftCommand());
        availableCommands.put('R', new TurnRightCommand());
        availableCommands.put('M', new MoveCommand());

    }

    public Point ParseUpperRight(String command) {
        CheckFullNullOrEmpty(command);
        return parseCoordinates(command);
    }

    public Position ParseStartingPosition(String command) {
        CheckFullNullOrEmpty(command);

        String[] splitCommand = command.split(" ");
        if (splitCommand.length != 3) {
            throw new IllegalArgumentException("Expected format space delimited format e.g. 'x y D' ");
        }

        String direction = splitCommand[2];
        if(direction.equalsIgnoreCase("N")) return new Position(parseCoordinates(command), Orientation.NORTH);
        if(direction.equalsIgnoreCase("S")) return new Position(parseCoordinates(command), Orientation.SOUTH);
        if(direction.equalsIgnoreCase("E")) return new Position(parseCoordinates(command), Orientation.EAST);
        if(direction.equalsIgnoreCase("W")) return new Position(parseCoordinates(command), Orientation.WEST);

        throw new IllegalArgumentException(String.format("Expected N S E W as possible orientations but got {0}", direction));
    }

    public List<ICommand> ParseCommands(String commands) {
        CheckFullNullOrEmpty(commands);

        List<ICommand> commandsToProcess = new ArrayList<>();
        commands.chars().forEach(
                command -> commandsToProcess.add(availableCommands.get((char)command)));

        return commandsToProcess;
    }

    private void CheckFullNullOrEmpty(String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException("No command provided");
        }
    }

    private Point parseCoordinates(String command) {
        String[] splitCommand = command.split(" ");
        if (splitCommand.length < 2) {
            throw new IllegalArgumentException("Expected format space delimited format e.g. 'x y' ");
        }

        int x = Integer.parseInt(splitCommand[0]);
        int y = Integer.parseInt(splitCommand[1]);
        return new Point(x, y);
    }
}
