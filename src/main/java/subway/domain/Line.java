package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.stations = stations;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return this.stations;
    }

    // 추가 기능 구현
}
