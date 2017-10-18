package rover;

import rover.commands.ICommand;
import rover.directions.IDirection;
import rover.universe.Plateau;

import java.awt.*;
import java.util.List;

public class Rover {
    private Point coordinates;
    private IDirection direction;
    private Plateau plateau;

    public Rover(Point coordinates, IDirection direction, Plateau plateau) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.plateau = plateau;
    }

    public String reportLocation() {
        return String.format("%s %s %s", coordinates.x, coordinates.y, direction.toString());
    }

    public void move() {
        Point proposedMove = direction.applyModifier(coordinates);
        if(plateau.isLocationWithinPlateau(proposedMove)) {
            coordinates = proposedMove;
        }else {
            System.out.println("Hit boundary");
        }
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

