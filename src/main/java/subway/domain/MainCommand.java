package subway.domain;

import java.util.Arrays;

public enum MainCommand {
    STATION_MANAGER("1"),
    LINE_MANAGER("2"),
    SECTION_MANAGER("3"),
    PRINT_MAP("4"),
    QUIT("Q");

    private String command;

    MainCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static MainCommand getMainCommand(String command) {
        return Arrays.stream(values())
                .filter(i -> i.command.equals(command))
                .findAny()
                .orElseGet(null);
    }
}
