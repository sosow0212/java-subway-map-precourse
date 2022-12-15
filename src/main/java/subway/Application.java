package subway;

import java.util.Scanner;
import subway.controller.MainSystemController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        MainSystemController mainSystemController = new MainSystemController(inputView);
        mainSystemController.run();
    }
}
