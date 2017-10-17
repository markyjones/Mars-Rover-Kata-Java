import rover.CommandParser;
import org.junit.jupiter.api.Test;
import rover.commands.ICommand;
import rover.directions.East;
import rover.directions.North;
import rover.universe.Plateau;
import rover.universe.Position;

import java.awt.*;
import java.util.List;

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
        plateau.addRover(startingPosition, new North());

        assertEquals("1 2 N", plateau.getCurrentRoverPosition());
    }

    @Test
    public void TestCanMoveRoverWithCommandExampleOne(){
        Plateau plateau = new Plateau(DefaultPlateauUpperRightBoundary);
        Position startingPosition = new Position(new Point(1, 2));
        plateau.addRover(startingPosition, new North());

        List<ICommand> commands = new CommandParser().ParseCommands("LMLMLMLMM");
        plateau.executeCommandsOnCurrentRover(commands);

        assertEquals("1 3 N", plateau.getCurrentRoverPosition());

    }

    @Test
    public void TestCanMoveRoverWithCommandExampleTwo(){
        Plateau plateau = new Plateau(DefaultPlateauUpperRightBoundary);
        Position startingPosition = new Position(new Point(3, 3));
        plateau.addRover(startingPosition, new East());

        List<ICommand> commands = new CommandParser().ParseCommands("MMRMMRMRRM");
        plateau.executeCommandsOnCurrentRover(commands);

        assertEquals("5 1 E", plateau.getCurrentRoverPosition());

    }

}

