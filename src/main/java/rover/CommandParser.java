package rover;

import rover.commands.*;

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

    public Point ParseStartingPosition(String command) {
        CheckFullNullOrEmpty(command);

        String[] splitCommand = command.split(" ");
        if (splitCommand.length != 3) {
            throw new IllegalArgumentException("Expected format space delimited format e.g. 'x y D' ");
        }
        ///TODO do some parsing for the direction perhaps
        return parseCoordinates(command);
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
