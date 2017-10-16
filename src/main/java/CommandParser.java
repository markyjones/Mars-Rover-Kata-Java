import java.awt.*;

public class CommandParser {
    public Point ParseUpperRight(String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException("No command provided");
        }

        return parseCoordinates(command);
    }

    public Position ParseStartingPosition(String command) {
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
