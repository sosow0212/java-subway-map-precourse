package subway.controller;

import static subway.view.OutputView.printError;

import subway.domain.Line;
import subway.domain.SectionCommand;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public SectionController(OutputView outputView, InputView inputView, StationRepository stationRepository,
                             LineRepository lineRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void run() {
        SectionCommand sectionCommand = getSectionCommand();
        processSectionCommand(sectionCommand);
    }

    private void processSectionCommand(SectionCommand sectionCommand) {
        if (sectionCommand.getCommand().equals("1")) {
            uploadSection();
        }
        if (sectionCommand.getCommand().equals("2")) {
            deleteSection();
        }
        if (sectionCommand.getCommand().equals("B")) {
            return;
        }
    }

    private void deleteSection() {
        String lineName = getRemoveLineName();
        String stationName = getRemoveStationName();
        Line line = lineRepository.findByName(lineName);
        line.removeStation(stationName);
    }

    private String getRemoveLineName() {
        while (true) {
            outputView.printRequestOfRemovingLine();
            String stationName = inputView.requestOfStationName();
            if (stationRepository.hasBeenStationNameAlready(stationName)) {
                return stationName;
            }
            printError("존재하지 않은 역입니다.");
        }
    }

    private String getRemoveStationName() {
        while (true) {
            outputView.printRequestOfRemovingStation();
            String lineName = inputView.requestOfLineName();
            if (lineRepository.hasBeenLineNameAlready(lineName)) {
                return lineName;
            }
            printError("존재하지 않는 노선입니다.");
        }
    }

    private void uploadSection() {
        String lineName = getLineName();
        String stationName = getStationName();
        int order = getOrder(lineName);
        Line line = lineRepository.findByName(lineName);
        line.addStation(stationRepository.findByName(stationName), order);
    }

    private int getOrder(String lineName) {
        while (true) {
            outputView.printRequestOfOrder();
            int order = inputView.requestOfInputOrder();
            Line line = lineRepository.findByName(lineName);
            if (line.canPutStationInOrderToOrder(order)) {
                return order;
            }
            printError("잘못된 순서입니다.");
        }
    }

    private String getStationName() {
        while (true) {
            outputView.printRequestOfStationName();
            String stationName = inputView.requestOfStationName();
            if (stationRepository.hasBeenStationNameAlready(stationName)) {
                return stationName;
            }
            printError("존재하지 않은 역입니다.");
        }
    }

    private String getLineName() {
        while (true) {
            outputView.printRequestOfLineName();
            String lineName = inputView.requestOfLineName();
            if (lineRepository.hasBeenLineNameAlready(lineName)) {
                return lineName;
            }
            printError("존재하지 않는 노선입니다.");
        }
    }

    private SectionCommand getSectionCommand() {
        outputView.printSectionSelect();
        outputView.printRequestOfSelect();
        return inputView.requestSectionSelect();
    }
}
