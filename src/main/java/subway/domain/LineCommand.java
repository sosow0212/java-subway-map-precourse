package subway.domain;

import java.util.Arrays;

public enum LineCommand {
    UPLOAD_LIEN("1"),
    DELETE_LINE("2"),
    SHOW_LINE("3"),
    BACK("B");

    private String command;

    LineCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static LineCommand getLineCommand(String command) {
        return Arrays.stream(values())
                .filter(i -> i.command.equals(command))
                .findAny()
                .orElseGet(null);
    }
}
