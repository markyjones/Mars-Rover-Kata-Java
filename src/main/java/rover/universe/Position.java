package rover.universe;

import java.awt.*;

public class Position {
    public Point Coordinates;
    public rover.universe.Orientation Orientation;

    public Position(Point coordinates, Orientation orientation) {
        this.Coordinates = coordinates;
        this.Orientation = orientation;
    }
}
