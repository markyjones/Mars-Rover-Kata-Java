import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Point upperRight;
    private List<Position> rovers = new ArrayList<Position>();

    public Plateau(Point upperRight) {
        this.upperRight = upperRight;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public Position getCurrentRoverPostion() {
        return this.rovers.get(0);
    }

    public void addRover(Position position) {
        rovers.add(position);
    }
}
