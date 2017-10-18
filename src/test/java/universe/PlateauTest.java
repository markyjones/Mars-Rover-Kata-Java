package universe;

import org.junit.jupiter.api.Test;
import rover.CommandParser;
import rover.universe.Plateau;

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
    public void TestBoundariesForPlateau(){
        Point upperRightBoundary = new CommandParser().ParseUpperRight("5 5");

        Plateau plateau = new Plateau(upperRightBoundary);
        boolean isLegalMoveOne = plateau.isLocationWithinPlateau(new Point(2,2));
        boolean isLegalMoveTwo = plateau.isLocationWithinPlateau(new Point(2,2));

        boolean isIllegalMoveOne = plateau.isLocationWithinPlateau(new Point(6,2));
        boolean isIllegalMoveTwo = plateau.isLocationWithinPlateau(new Point(2,8));

        assertEquals(true, isLegalMoveOne);
        assertEquals(true, isLegalMoveTwo);

        assertEquals(false, isIllegalMoveOne);
        assertEquals(false, isIllegalMoveTwo);
    }

}
