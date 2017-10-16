import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlateauTest {

    @Test
    public void CanCreatePlateauWithDefaultDimension() {
        Point upperRightBoundary = new CommandParser().ParseUpperRight("5 5");
        Plateau plateau = new Plateau(upperRightBoundary);
        assertEquals(5, plateau.getUpperRight().x);
        assertEquals(5, plateau.getUpperRight().y);
    }

    @Test
    public void CanAddRoverWithDefaultPosition() {
        Plateau plateau = new Plateau(new Point(5,5 ));
        Position startingPosition = new CommandParser().ParseStartingPosition("1 2 N");
        plateau.addRover(startingPosition);
        Position currentPosition =  plateau.getCurrentRoverPostion();
        assertEquals(1, currentPosition.Coordinates.x);
        assertEquals(2, currentPosition.Coordinates.y);
        assertEquals(Orientation.NORTH, currentPosition.Orientation);
    }
}

