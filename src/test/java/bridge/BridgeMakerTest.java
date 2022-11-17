package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Nested
    @DisplayName("makeBridge 메서드는")
    class MakeBridge {

        private BridgeMaker bridgeMaker;

        @BeforeEach
        void setUp() {
            bridgeMaker = new BridgeMaker(() -> 0);
        }

        @Test
        @DisplayName("랜덤 값이 0이면 위 칸을 건널 수 있는 다리 모양을 만든다.")
        void success_up() {
            BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

            List<String> actual = bridgeMaker.makeBridge(3);

            List<String> expected = List.of("U", "U", "U");
            assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        }

        @Test
        @DisplayName("랜덤 값이 1이면 아래 칸을 건널 수 있는 다리 모양을 만든다.")
        void success_down() {
            BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);

            List<String> actual = bridgeMaker.makeBridge(3);

            List<String> expected = List.of("D", "D", "D");
            assertThat(actual).usingRecursiveComparison()
                .isEqualTo(expected);
        }

        @Test
        @DisplayName("다리 길이가 3이하 또는 20이상이 아니면 예외를 발생시킨다.")
        void exception_invalid_size() {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
