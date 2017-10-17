package rover.directions;

public class West implements IDirection {
    @Override
    public IDirection TurnLeft() {
        return new South();
    }

    @Override
    public IDirection TurnRight() {
        return new North();
    }

    @Override
    public String toString() {
        return "W";
    }
}
