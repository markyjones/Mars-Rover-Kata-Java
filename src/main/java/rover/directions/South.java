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
    public Point applyModifier(Point point) {
        return new Point(point.x, point.y - 1);
    }

    @Override
    public String toString() {
        return "S";
    }
}
