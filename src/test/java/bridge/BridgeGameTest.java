package bridge;

import static bridge.Space.D;
import static bridge.Space.U;
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
            List<String> spaces = Stream.of(U, D, U)
                .map(Space::name)
                .collect(Collectors.toUnmodifiableList());
            bridgeGame = new BridgeGame(spaces);
        }

        @Test
        @DisplayName("이동할 수 있는 입력이면 다음 칸으로 이동한다.")
        void success() {
            BridgeGame actual = bridgeGame.move(U);

            assertThat(actual.getPosition()).isEqualTo(new Position(1));
        }

        @Test
        @DisplayName("이동할 수 없는 입력이면 다음 칸으로 이동하지 않는다.")
        void fail() {
            BridgeGame actual = bridgeGame.move(D);

            assertThat(actual.getPosition()).isEqualTo(new Position(0));
        }
    }

    @Nested
    @DisplayName("retry 메서드는")
    class Retry {

        private BridgeGame bridgeGame;

        @BeforeEach
        void setUp() {
            List<String> spaces = Stream.of(U, D, U)
                .map(Space::name)
                .collect(Collectors.toUnmodifiableList());
            bridgeGame = new BridgeGame(spaces).move(U);
        }

        @Test
        @DisplayName("초기위치인 다리 건너기 게임을 반환한다.")
        void success() {
            BridgeGame actual = bridgeGame.retry();

            assertThat(actual.getPosition()).isEqualTo(new Position(0));
        }
    }
}
