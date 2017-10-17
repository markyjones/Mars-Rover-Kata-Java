package rover.commands;

import rover.Rover;

public class TurnRightCommand implements ICommand {
    @Override
    public void Execute(Rover rover) {
        rover.rotate(CommandEnum.R);
    }
}
