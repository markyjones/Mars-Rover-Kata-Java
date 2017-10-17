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

    public Position getPosition() {
        return position;
    }

    public void move() {
        switch (this.direction.getClass().getName()) {
            case "rover.directions.North":
                this.position.Coordinates.y++;
                break;
            case "rover.directions.East":
                this.position.Coordinates.x++;
                break;
            case "rover.directions.South":
                this.position.Coordinates.y--;
                break;
            case "rover.directions.West":
                this.position.Coordinates.x--;
                break;
            default:
                System.out.println(this.direction.getClass().getName());
        }
    }

    public void rotateLeft() {
        direction = direction.TurnLeft();
    }

    public void rotateRight() {
        direction = direction.TurnRight();
    }

    public IDirection getDirection() {
        return direction;
    }
}

