package rover.universe;

import java.awt.*;

public class Plateau {

    private Point upperRight;
    final private Point lowerRight = new Point(0,0);

    public Plateau(Point upperRight) {
        this.upperRight = upperRight;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public boolean isLocationWithinPlateau(Point point) {
        return  point.x >= lowerRight.x && point.x <= upperRight.x &&
                point.y >= lowerRight.y && point.y <= upperRight.y;
    }
}
