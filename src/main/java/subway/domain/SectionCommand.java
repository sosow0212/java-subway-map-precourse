package subway.domain;

import java.util.Arrays;

public enum SectionCommand {
    UPLOAD_SECTION("1"),
    DELETE_SECTION("2"),
    BACK("B");

    private String command;

    SectionCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static SectionCommand getSectionCommand(String command) {
        return Arrays.stream(values())
                .filter(i -> i.command.equals(command))
                .findAny()
                .orElseGet(null);
    }
}
