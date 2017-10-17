package rover.commands;
import rover.Rover;

public interface ICommand {
    void Execute(Rover rover);
}
