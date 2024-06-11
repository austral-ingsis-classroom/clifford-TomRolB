package edu.austral.ingsis.clifford;

import java.util.List;

public class Cli {
  private final FileSystem fs;

  public Cli(FileSystem fs) {
    this.fs = fs;
  }

  public List<String> executeCommands(List<String> commands) {
    return commands.stream().map(this::executeCommand).toList();
  }

  // TODO: may replace by compound
  public String executeCommand(String command) {
    String[] splitCommand = command.split(" ");

    String commandName = splitCommand[0];
    ;
    switch (commandName) {
      case "ls":
        return new ListChildren(fs, getCommandArgument(splitCommand)).execute();
      case "mkdir":
        return new MakeDirectory(fs, getCommandArgument(splitCommand)).execute();
      case "cd":
        return new ChangeDirectory(getCommandArgument(splitCommand), fs).execute();
      case "touch":
        return new Touch(fs, getCommandArgument(splitCommand)).execute();
      case "pwd":
        return new PrintWorkingDirectory(fs).execute();
      case "rm":
        return new Remove(fs, splitCommand).execute();
      default:
        throw new IllegalStateException("Unexpected command: " + commandName);
    }
  }

  private static String getCommandArgument(String[] splitCommand) {
    if (splitCommand.length >= 2) return splitCommand[1];
    else return "";
  }
}
