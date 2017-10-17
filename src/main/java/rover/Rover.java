package rover;

import rover.universe.Orientation;
import rover.universe.Position;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void move() {
        switch (this.position.Orientation) {
            case NORTH:
                this.position.Coordinates.y++;
                break;
            case EAST:
                this.position.Coordinates.x++;
                break;
            case SOUTH:
                this.position.Coordinates.y--;
                break;
            case WEST:
                this.position.Coordinates.x--;
                break;
        }
    }

    public void rotateLeft() {

        switch (this.position.Orientation) {
            case NORTH:
                this.position.Orientation = Orientation.WEST;
                break;
            case EAST:
                this.position.Orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.position.Orientation = Orientation.EAST;
                break;
            case WEST:
                this.position.Orientation = Orientation.SOUTH;
                break;
        }
    }

    public void rotateRight() {

        switch (this.position.Orientation) {
            case NORTH:
                this.position.Orientation = Orientation.EAST;
                break;
            case EAST:
                this.position.Orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.position.Orientation = Orientation.WEST;
                break;
            case WEST:
                this.position.Orientation = Orientation.NORTH;
                break;
        }

    }
}

