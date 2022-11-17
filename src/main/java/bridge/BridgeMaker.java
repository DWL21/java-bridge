package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final String INVALID_BRIDGE_SIZE_EXCEPTION_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        validateBridgeSize(size);
        List<Space> spaces = pickSpaces(size);
        return spaces.stream()
            .map(Space::name)
            .collect(Collectors.toUnmodifiableList());
    }

    private void validateBridgeSize(final int size) {
        if (isNotAvailableBridgeSize(size)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotAvailableBridgeSize(final int size) {
        return size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE;
    }

    private List<Space> pickSpaces(final int size) {
        List<Space> spaces = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            spaces.add(Space.from(number));
        }
        return spaces;
    }
}
