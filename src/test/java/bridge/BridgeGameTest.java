package bridge;

import static bridge.Space.DOWN;
import static bridge.Space.UP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Nested
    @DisplayName("Move 메서드는")
    class Move {

        private BridgeGame bridgeGame;

        @BeforeEach
        void setUp() {
            List<String> spaces = Stream.of(UP, DOWN, UP)
                .map(Space::getValue)
                .collect(Collectors.toUnmodifiableList());
            bridgeGame = new BridgeGame(spaces);
        }

        @Test
        @DisplayName("이동할 수 있는 입력이면 다음 칸으로 이동한다.")
        void success() {
            bridgeGame.move(UP);

            Position actual = bridgeGame.getPosition();
            assertThat(actual).isEqualTo(new Position(1));
        }

        @Test
        @DisplayName("이동할 수 없는 입력이면 다음 칸으로 이동하지 않는다.")
        void fail() {
            bridgeGame.move(DOWN);

            Position actual = bridgeGame.getPosition();
            assertThat(actual).isEqualTo(new Position(0));
        }
    }

}
