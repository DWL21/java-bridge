package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeRandomNumberGeneratorTest {

    @Test
    @DisplayName("generate 메서드는 0 또는 1을 랜덤으로 반환한다.")
    void success() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

        int actual = generator.generate();

        assertThat(actual).isIn(0, 1);
    }
}
