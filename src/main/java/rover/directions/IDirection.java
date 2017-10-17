package rover.directions;

import java.awt.*;

public interface IDirection {
    IDirection TurnLeft();
    IDirection TurnRight();
    Point updateLocation(Point point);
}
