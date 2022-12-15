package subway.controller;

import static subway.view.OutputView.printError;

import subway.domain.LineCommand;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineController(OutputView outputView, InputView inputView, StationRepository stationRepository,
                          LineRepository lineRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void run() {
        LineCommand lineCommand = getCommand();
        if (lineCommand.getCommand().equals("B")) {
            return;
        }
        processLine(lineCommand);
    }

    private void processLine(LineCommand lineCommand) {
        if (lineCommand.getCommand().equals("1")) {
            uploadLine();
        }
        if (lineCommand.getCommand().equals("2")) {
            removeLine();
        }
        if (lineCommand.getCommand().equals("3")) {
            showLine();
        }
    }

    private void removeLine() {
        while (true) {
            outputView.printRequestOfRemovingLine();
            String removeLineName = inputView.requestOfRemovingLineName();
            if (lineRepository.deleteLineByName(removeLineName)) {
                outputView.printRemovingLineSuccessfully();
                return;
            }
            printError("존재하지 않는 라인입니다.");
        }
    }

    private void showLine() {
        outputView.printShowAllLines(lineRepository.lines());
    }

    private void uploadLine() {
        String lineName = getLineName();
        Station upEndStationName = getUpEndStationName();
        Station downEndStationName = getDownEndStationName();
        lineRepository.addLine(lineName, upEndStationName, downEndStationName);

    }

    private Station getDownEndStationName() {
        while (true) {
            outputView.printRequestOfFirstLine();
            String downEndStationName = inputView.requestStationName();
            if (stationRepository.hasBeenStationNameAlready(downEndStationName)) {
                return stationRepository.findByName(downEndStationName);
            }
            printError("하행 종점역이 존재하지 않습니다.");
        }
    }

    private Station getUpEndStationName() {
        while (true) {
            outputView.printRequestOfFirstLine();
            String upEndStationName = inputView.requestStationName();
            if (stationRepository.hasBeenStationNameAlready(upEndStationName)) {
                return stationRepository.findByName(upEndStationName);
            }
            printError("상행 종점역이 존재하지 않습니다.");
        }
    }

    private String getLineName() {
        while (true) {
            outputView.printRequestOfUploadingLine();
            String lineName = inputView.requestOfUploadingLineName();
            if (!lineRepository.hasBeenLineNameAlready(lineName)) {
                return lineName;
            }
            printError("이미 존재하는 노선입니다.");
        }
    }


    public LineCommand getCommand() {
        outputView.printLineSelect();
        outputView.printRequestOfSelect();
        return inputView.requestLineSelect();

    }
}
