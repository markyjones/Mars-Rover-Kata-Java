package rover.directions;

import java.awt.*;

public class West implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new South();
    }

    @Override
    public IDirection TurnRight() {
        return new North();
    }

    @Override
    public Point applyModifier(Point point) {
        return new Point(point.x - 1, point.y);
    }

    @Override
    public String toString() {
        return "W";
    }
}
