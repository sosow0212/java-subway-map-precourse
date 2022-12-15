package subway.controller;

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
}
