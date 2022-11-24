package bridge;

import static bridge.Retry.Q;
import static bridge.Retry.R;

import java.util.List;

public class GameController implements Runnable {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        outputView.start();
        outputView.requestBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> spaces = bridgeMaker.makeBridge(inputView.readBridgeSize());
        play(spaces);
    }

    private void play(List<String> spaces) {
        BridgeGame pastTurn = new BridgeGame(spaces);
        outputView.requestMovingSpace();
        BridgeGame bridgeGame = pastTurn.move(inputView.readMoving());
        while (!bridgeGame.isFailedMoving(pastTurn)) {
            pastTurn = bridgeGame;
            outputView.requestMovingSpace();
            bridgeGame = pastTurn.move(inputView.readMoving());
            if (bridgeGame.isFinished()) {
                outputView.printResult(bridgeGame.showTryingSpaces(), true);
                outputView.printInformation(true, 1);
                return;
            }
        }
        Retry retry = inputView.readGameCommand();
        if (Q.equals(retry)) {
            outputView.printResult(bridgeGame.showTryingSpaces(), false);
            outputView.printInformation(false, 1);
        }
        if (R.equals(retry)) {
            play(spaces);
        }
    }
}
