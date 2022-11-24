package bridge;

import java.util.Objects;

public class Position {

    private static final int INITIAL_POSITION = 0;
    private static final int NEXT_POSITION_DISTANCE = 1;

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public static Position from() {
        return new Position(INITIAL_POSITION);
    }

    public Position nextPosition() {
        return new Position(value + NEXT_POSITION_DISTANCE);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
