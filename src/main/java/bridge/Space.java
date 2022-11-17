package bridge;

import java.util.Arrays;

public enum Space {

    U(0),
    D(1),
    ;

    private final int value;

    Space(final int value) {
        this.value = value;
    }

    public static Space from(final int value) {
        return Arrays.stream(values())
            .filter(it -> it.value == value)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("[ERROR] 올바른 랜덤 숫자가 아닙니다."));
    }
}
