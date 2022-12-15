package subway.view;

import static subway.view.OutputView.printError;

import java.util.Scanner;
import subway.domain.LineCommand;
import subway.domain.MainCommand;
import subway.domain.SectionCommand;
import subway.domain.StationCommand;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand requestMainSelect() {
        try {
            String input = scanner.next();
            // 예외
            return MainCommand.getMainCommand(input);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return requestMainSelect();
        }
    }

    public StationCommand requestStationSelect() {
        try {
            String input = scanner.next();
            // 예외
            return StationCommand.getStationCommand(input);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return requestStationSelect();
        }
    }

    public LineCommand requestLineSelect() {
        try {
            String input = scanner.next();
            // 예외
            return LineCommand.getLineCommand(input);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return requestLineSelect();
        }
    }

    public SectionCommand requestSectionSelect() {
        try {
            String input = scanner.next();
            // 예외
            return SectionCommand.getSectionCommand(input);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return requestSectionSelect();
        }
    }
}
