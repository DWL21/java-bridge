package bridge;

import java.util.Arrays;

public enum Space {

    UP(0, "U"),
    DOWN(1, "D"),
    ;

    private final int key;
    private final String value;

    Space(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Space of(int key) {
        return Arrays.stream(values())
            .filter(it -> it.key == key)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("[ERROR] 올바른 랜덤 숫자가 아닙니다."));
    }

    public String getValue() {
        return value;
    }
}
