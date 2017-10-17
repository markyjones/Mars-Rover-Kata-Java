package rover;

import rover.directions.IDirection;
import rover.universe.Position;

public class Rover {
    private Position position;
    private IDirection direction;

    public Rover(Position position, IDirection direction) {
        this.position = position;
        this.direction = direction;
    }

    public String getLocation() {
        return String.format("%s %s %s", position.Coordinates.x, position.Coordinates.y, direction.toString());
    }

    public void move() {
        position.Coordinates = direction.updateLocation(position.Coordinates);
    }

    public void rotateLeft() {
        direction = direction.TurnLeft();
    }

    public void rotateRight() {
        direction = direction.TurnRight();
    }
}

