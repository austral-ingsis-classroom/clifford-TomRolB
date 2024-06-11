package edu.austral.ingsis.clifford;

import java.util.List;

public class Cli {
    private final FileSystem fs;

    public Cli(FileSystem fs) {
        this.fs = fs;
    }

    public List<String> executeCommands(List<String> commands) {
        return commands
                .stream()
                .map(this::executeCommand)
                .toList();
    }

    public String executeCommand(String command) {
        String[] arguments = command.split(" ");

        switch (arguments[0]) {
            case "ls":
                return new ListChildren(fs).execute();
            case "mkdir":
                return new MakeDirectory(fs, arguments[1]).execute();
            case "cd":
                return new ChangeDirectory(arguments[1], fs).execute();
            case "touch":
                return new Touch(fs, arguments[1]).execute();
            case "pwd":
                return new PrintWorkingDirectory(fs).execute();
            case "remove":
                return new Remove().execute();
        }
    }
}
