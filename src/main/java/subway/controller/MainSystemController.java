package subway.controller;

import subway.domain.MainCommand;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MainSystemController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView;
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;
    private LineRepository lineRepository = new LineRepository();
    private StationRepository stationRepository = new StationRepository();

    public MainSystemController(InputView inputView) {
        this.inputView = inputView;
        stationController = new StationController(outputView, inputView, stationRepository, lineRepository);
        lineController = new LineController(outputView, inputView, stationRepository, lineRepository);
        sectionController = new SectionController(outputView, inputView, stationRepository, lineRepository);
    }

    public void run() {
        while (true) {
            MainCommand mainCommand = getCommand();
            if (mainCommand.getCommand().equals("Q")) {
                return;
            }
            process(mainCommand);
        }
    }

    private void process(MainCommand mainCommand) {
        if (mainCommand.getCommand().equals("1")) {
            stationController.run();
        }
        if (mainCommand.getCommand().equals("2")) {
            lineController.run();
        }
        if (mainCommand.getCommand().equals("3")) {
            sectionController.run();
        }
        if(mainCommand.getCommand().equals("4")) {
            showAllInfo();
        }
        if(mainCommand.getCommand().equals("Q")) {
            return;
        }
    }

    public void showAllInfo() {
        outputView.printShowAllInfo(lineRepository.lines());
    }

    private MainCommand getCommand() {
        outputView.printRequestOfMainSelect();
        outputView.printRequestOfSelect();
        return inputView.requestMainSelect();
    }
}
