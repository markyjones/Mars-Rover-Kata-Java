package rover;

import rover.commands.ICommand;
import rover.directions.IDirection;

import java.awt.*;
import java.util.List;

public class Rover {
    private Point coordinates;
    private IDirection direction;

    public Rover(Point coordinates, IDirection direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public String reportLocation() {
        return String.format("%s %s %s", coordinates.x, coordinates.y, direction.toString());
    }

    public void move() {
        coordinates = direction.applyModifier(coordinates);
    }

    public void rotateLeft() {
        direction = direction.TurnLeft();
    }

    public void rotateRight() {
        direction = direction.TurnRight();
    }

    public void executeCommands(List<ICommand> commands) {
        commands.forEach(command -> command.Execute(this));
    }
}

