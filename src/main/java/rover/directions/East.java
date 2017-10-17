package rover.directions;

import java.awt.*;

public class East implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new North();
    }

    @Override
    public IDirection TurnRight() {
        return new South();
    }

    @Override
    public Point updateLocation(Point point) {
        point.x++;
        return point;
    }

    @Override
    public String toString() {
        return "E";
    }
}
