package subway.domain;

import java.util.Arrays;

public enum StationCommand {
    UPLOAD_STATION("1"),
    DELETE_STATION("2"),
    SHOW_STATION("3"),
    BACK("B");

    private String command;

    StationCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static StationCommand getStationCommand(String command) {
        return Arrays.stream(values())
                .filter(i -> i.command.equals(command))
                .findAny()
                .orElseGet(null);
    }
}
