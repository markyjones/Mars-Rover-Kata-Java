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
    public Point applyModifier(Point point) {
        return new Point(point.x + 1, point.y);
    }

    @Override
    public String toString() {
        return "E";
    }
}
