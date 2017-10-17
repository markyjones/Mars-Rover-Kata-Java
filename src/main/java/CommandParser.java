import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommandParser {
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

    public Command[] ParseCommands(String commands) {
        CheckFullNullOrEmpty(commands);

        List<Command> commandsToProcess = new ArrayList<>();
        commands.chars().forEach(
                command -> commandsToProcess
                        .add(Command.valueOf(String.valueOf(Character.toChars(command)))) );

        return commandsToProcess.toArray(new Command[0]);
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
