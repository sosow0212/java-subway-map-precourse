package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Line 생성자 테스트")
    public void lineConstructorTest() {
        // given, when
        String lineName = "1호선";
        List<Station> stations = Arrays.asList(new Station("잠실"), new Station("상봉"));
        Line line = new Line(lineName, stations);

        // then
        assertThat(line.getStations()).isEqualTo(stations);
        assertThat(line.getName()).isEqualTo(lineName);
    }
}
