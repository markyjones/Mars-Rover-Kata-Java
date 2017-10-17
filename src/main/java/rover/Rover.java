package rover;

import rover.commands.CommandEnum;
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
        switch (this.position.Orientation){
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

    public void rotate(CommandEnum command) {
        switch (command){
            case L:
                switch (this.position.Orientation){
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
                break;
            case R:
                switch (this.position.Orientation){
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
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown rotation command {0}", command.toString()));
        }
    }
}
