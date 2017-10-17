import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlateauTest {

    final private Point DefaultPlateauUpperRightBoundary = new Point(5,5);

    @Test
    public void CanCreatePlateauWithDefaultDimension() {
        Point upperRightBoundary = new CommandParser().ParseUpperRight("5 5");

        Plateau plateau = new Plateau(upperRightBoundary);

        assertEquals(5, plateau.getUpperRight().x);
        assertEquals(5, plateau.getUpperRight().y);
    }

    @Test
    public void CanAddRoverWithDefaultPosition() {
        Plateau plateau = new Plateau(DefaultPlateauUpperRightBoundary);
        Position startingPosition = new CommandParser().ParseStartingPosition("1 2 N");
        plateau.addRover(startingPosition);

        Position currentPosition =  plateau.getCurrentRoverPosition();

        assertEquals(1, currentPosition.Coordinates.x);
        assertEquals(2, currentPosition.Coordinates.y);
        assertEquals(Orientation.NORTH, currentPosition.Orientation);
    }

    @Test
    public void TestCanMoveRoverWithCommandExampleOne(){
        Plateau plateau = new Plateau(DefaultPlateauUpperRightBoundary);
        Position startingPosition = new Position(new Point(1, 2), Orientation.NORTH);
        plateau.addRover(startingPosition);

        Command[] commands = new CommandParser().ParseCommands("LMLMLMLMM");
        plateau.moveCurrentRover(commands);

        Position currentPosition =  plateau.getCurrentRoverPosition();
        assertEquals(1, currentPosition.Coordinates.x);
        assertEquals(3, currentPosition.Coordinates.y);
        assertEquals(Orientation.NORTH, currentPosition.Orientation);
    }

    @Test
    public void TestCanMoveRoverWithCommandExampleTwo(){
        Plateau plateau = new Plateau(DefaultPlateauUpperRightBoundary);
        Position startingPosition = new Position(new Point(3, 3), Orientation.EAST);
        plateau.addRover(startingPosition);

        Command[] commands = new CommandParser().ParseCommands("MMRMMRMRRM");
        plateau.moveCurrentRover(commands);

        Position currentPosition =  plateau.getCurrentRoverPosition();
        assertEquals(5, currentPosition.Coordinates.x);
        assertEquals(1, currentPosition.Coordinates.y);
        assertEquals(Orientation.EAST, currentPosition.Orientation);
    }

}

