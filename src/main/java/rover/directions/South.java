package rover.directions;

public class South implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new East();
    }

    @Override
    public IDirection TurnRight() {
        return new West();
    }

    @Override
    public String toString() {
        return "S";
    }
}
