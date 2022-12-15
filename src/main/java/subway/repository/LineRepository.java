package subway.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Line;
import subway.domain.Station;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String lineName, Station upStation, Station downStation) {
        lines.add(new Line(lineName, Arrays.asList(upStation, downStation)));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasBeenLineNameAlready(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }
        return false;
    }
}
