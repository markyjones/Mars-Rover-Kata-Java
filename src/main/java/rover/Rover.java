package rover;

import rover.directions.IDirection;

import java.awt.*;

public class Rover {
    private Point coordinates;
    private IDirection direction;

    public Rover(Point coordinates, IDirection direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public String getLocation() {
        return String.format("%s %s %s", coordinates.x, coordinates.y, direction.toString());
    }

    public void move() {
        coordinates = direction.updateLocation(coordinates);
    }

    public void rotateLeft() {
        direction = direction.TurnLeft();
    }

    public void rotateRight() {
        direction = direction.TurnRight();
    }
}

