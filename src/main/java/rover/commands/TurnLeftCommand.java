package rover.commands;

import rover.Rover;

public class TurnLeftCommand implements ICommand {
    @Override
    public void Execute(Rover rover) {
        rover.rotateLeft();
    }
}
