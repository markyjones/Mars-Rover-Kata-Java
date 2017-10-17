package rover.universe;

import rover.Rover;
import rover.commands.ICommand;
import rover.directions.IDirection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Point upperRight;
    private List<Rover> rovers = new ArrayList<>();

    public Plateau(Point upperRight) {
        this.upperRight = upperRight;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public String getCurrentRoverPosition() {
        return this.rovers.get(0).getLocation();
    }

    public void addRover(Point coordinates, IDirection direction) {
        rovers.add(new Rover(coordinates, direction));
    }

    public void executeCommandsOnCurrentRover(List<ICommand> commands) {
        commands.forEach(command -> command.Execute(rovers.get(0)));
    }
}
