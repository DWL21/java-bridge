package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Position position;
    private final List<String> spaces;

    public BridgeGame(final Position position, final List<String> spaces) {
        this.position = position;
        this.spaces = spaces;
    }

    public BridgeGame(final List<String> spaces) {
        this(Position.from(), spaces);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame move(final Space space) {
        if (canMove(space)) {
            return new BridgeGame(position.nextPosition(), this.spaces);
        }
        return this;
    }

    private boolean canMove(final Space space) {
        Space now = Space.valueOf(spaces.get(position.getValue()));
        return now.equals(space);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Position getPosition() {
        return position;
    }
}
