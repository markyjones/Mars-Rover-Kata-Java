package rover.commands;

import rover.Rover;

public class MoveCommand implements ICommand {
    @Override
    public void Execute(Rover rover) {
        rover.move();
    }
}
