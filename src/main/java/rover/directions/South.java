package rover.directions;

import java.awt.*;

public class South implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new East();
    }

    @Override
    public IDirection TurnRight() {
        return new West();
    }

    @Override
    public Point updateLocation(Point point) {
        point.y--;
        return point;
    }

    @Override
    public String toString() {
        return "S";
    }
}
