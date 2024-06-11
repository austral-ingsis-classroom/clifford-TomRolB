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
        String[] splitCommand = command.split(" ");

        String commandName = splitCommand[0];
        String commandArgument = splitCommand[1];
        switch (commandName) {
            case "ls":
                return new ListChildren(fs).execute();
            case "mkdir":
                return new MakeDirectory(fs, commandArgument).execute();
            case "cd":
                return new ChangeDirectory(commandArgument, fs).execute();
            case "touch":
                return new Touch(fs, commandArgument).execute();
            case "pwd":
                return new PrintWorkingDirectory(fs).execute();
            case "remove":
                return new Remove(fs, commandArgument).execute();
            default:
                throw new IllegalStateException("Unexpected command: " + commandName);
        }
    }
}
