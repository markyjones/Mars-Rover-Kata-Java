import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Point upperRight;
    private List<Rover> rovers = new ArrayList<>();

    public Plateau(Point upperRight) {
        this.upperRight = upperRight;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public Position getCurrentRoverPosition() {
        return this.rovers.get(0).getPosition();
    }

    public void addRover(Position position) {
        rovers.add(new Rover(position));
    }

    public void moveCurrentRover(Command[] commands) {
        for (Command command : commands) {
            switch (command) {
                case M:
                    System.out.println(String.format("Moving"));
                    this.rovers.get(0).move();
                    break;
                default:
                    System.out.println(String.format("Rotating " + command));
                    this.rovers.get(0).rotate(command);
                    break;
            }
        }
    }
}
