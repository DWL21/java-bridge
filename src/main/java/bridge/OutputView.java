package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR]: %s";

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void start() {
        output.print("다리 건너기 게임을 시작합니다.\n");
    }

    public void requestBridgeSize() {
        output.print("다리의 길이를 입력해주세요.");
    }

    public void requestMovingSpace() {
        output.print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final List<String> spaces, final boolean isFinished) {
        System.out.println(spaces.toString());
        System.out.println(isFinished);
    }

    public void requestRetry() {
        output.print("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final List<String> spaces, final boolean isFinished) {
        output.print("최종 게임 결과");
        printMap(spaces, isFinished);
    }

    public void printInformation(final boolean isFinished, final int count) {
        output.print("게임 성공 여부: " + getFinishedMessage(isFinished));
        output.print("총 시도한 횟수: " + count);
    }

    private String getFinishedMessage(final boolean isFinished) {
        if (isFinished) {
            return "성공";
        }
        return "실패";
    }

    public void printExceptionMessage(final String message) {
        System.out.println(String.join(ERROR_MESSAGE_FORMAT, message));
    }
}
