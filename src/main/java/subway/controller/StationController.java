package subway.controller;

import static subway.view.OutputView.printError;

import subway.domain.Station;
import subway.domain.StationCommand;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private final OutputView outputView;
    private final InputView inputView;
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public StationController(OutputView outputView, InputView inputView, StationRepository stationRepository,
                             LineRepository lineRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void run() {
        StationCommand stationCommand = getCommand();
        if (stationCommand.getCommand().equals("1")) {
            uploadStation();
        }
        if (stationCommand.getCommand().equals("2")) {
            deleteStation();
        }
        if (stationCommand.getCommand().equals("3")) {
            showStation();
        }
    }

    private void showStation() {
        outputView.printAllStations(stationRepository.stations());
    }

    private void deleteStation() {
        String stationName = getRemovingStationName();
        stationRepository.deleteStation(stationName);
        outputView.printRemovingStationSuccessfully();
    }

    private String getRemovingStationName() {
        while (true) {
            outputView.printRequestOfRemovingStation();
            String stationName = inputView.requestStationName();
            if (stationRepository.hasBeenStationNameAlready(stationName)) {
                return stationName;
            }
            printError("존재하지 않는 역입니다.");
        }
    }


    private void uploadStation() {
        String stationName = getUploadingStationName();
        stationRepository.addStation(stationName);
    }

    private String getUploadingStationName() {
        while (true) {
            outputView.printRequestOfUploadingStation();
            String stationName = inputView.requestStationName();
            if (!stationRepository.hasBeenStationNameAlready(stationName)) {
                return stationName;
            }
            printError("[ERROR] 이미 존재하는 역입니다.");
        }
    }

    private StationCommand getCommand() {
        outputView.printStationSelect();
        outputView.printRequestOfSelect();
        return inputView.requestStationSelect();
    }
}
