package rover.directions;

import java.awt.*;

public class North implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new West();
    }

    @Override
    public IDirection TurnRight() {
        return new East();
    }

    @Override
    public Point applyModifier(Point point) {
        point.y++;
        return point;
    }

    @Override
    public String toString() {
        return "N";
    }
}
