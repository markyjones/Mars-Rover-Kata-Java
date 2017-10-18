import rover.CommandParser;
import org.junit.jupiter.api.Test;
import rover.Rover;
import rover.commands.ICommand;
import rover.directions.East;
import rover.directions.North;
import rover.universe.Plateau;

import java.awt.*;
import java.util.List;

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
        Point startingPosition = new CommandParser().ParseStartingPosition("1 2 N");
        Rover rover = new Rover(startingPosition, new North());

        assertEquals("1 2 N", rover.reportLocation());
    }

    @Test
    public void TestCanMoveRoverWithCommandExampleOne(){
        Point startingPosition = new Point(1, 2);
        Rover rover = new Rover(startingPosition, new North());

        List<ICommand> commands = new CommandParser().ParseCommands("LMLMLMLMM");
        rover.executeCommands(commands);

        assertEquals("1 3 N", rover.reportLocation());
    }

    @Test
    public void TestCanMoveRoverWithCommandExampleTwo(){
        Point startingPosition = new Point(3, 3);
        Rover rover = new Rover(startingPosition, new East());

        List<ICommand> commands = new CommandParser().ParseCommands("MMRMMRMRRM");
        rover.executeCommands(commands);

        assertEquals("5 1 E", rover.reportLocation());
    }

}

