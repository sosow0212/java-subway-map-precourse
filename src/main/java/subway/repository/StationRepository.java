package subway.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String stationName) {
        stations.add(new Station(stationName));
    }

    public static boolean hasBeenStationNameAlready(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String name) {
        return stations().stream()
                .filter(i -> i.getName().equals(name))
                .findAny()
                .orElseGet(null);
    }
}
