package rover.directions;

public class East implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new North();
    }

    @Override
    public IDirection TurnRight() {
        return new South();
    }

    @Override
    public String toString() {
        return "E";
    }
}
