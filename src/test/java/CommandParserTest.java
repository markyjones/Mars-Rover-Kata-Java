import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rover.CommandParser;
import rover.commands.ICommand;
import rover.commands.MoveCommand;
import rover.commands.TurnLeftCommand;
import rover.commands.TurnRightCommand;

import java.util.List;

public class CommandParserTest {
    @Test
    public void TestCanParseCommand(){
        final String testCommand = "LRM";
        CommandParser sut = new CommandParser();

        List<ICommand> results = sut.ParseCommands(testCommand);

        assertEquals(3, results.size());
        assertEquals(TurnLeftCommand.class, results.get(0).getClass());
        assertEquals(TurnRightCommand.class, results.get(1).getClass());
        assertEquals(MoveCommand.class, results.get(2).getClass());
    }

}
