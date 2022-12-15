package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean canPutStationInOrderToOrder(int order) {
        order--;
        return order >= 0 && order < stations.size();
    }

    public void addStation(Station station, int order) {
        order--;
        stations.add(order, station);
    }

    public void removeStation(String stationName) {
        stations.stream()
                .filter(i -> i.getName().equals(stationName))
                .map(i -> stations.remove(i))
                .collect(Collectors.toList());
    }

    // 추가 기능 구현
}
