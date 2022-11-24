package bridge;

public class Application {

    public static void main(String[] args) {
        Runnable runnable = new GameController(new InputView(), new OutputView(System.out::println));
        runnable.run();
    }
}
