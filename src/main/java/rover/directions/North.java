package rover.directions;

public class North implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new West();
    }

    @Override
    public IDirection TurnRight() {
        return new East();
    }
}
