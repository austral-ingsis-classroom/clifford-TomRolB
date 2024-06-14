package edu.austral.ingsis.clifford;

import java.util.List;
import java.util.Map;

public class Cli {
  private final FileSystem fs;
//  private final Map<String, Action> commandMap;

// TODO: replace current constructor by the one below

//  public Cli(FileSystem fs, Map<String, Action> commandMap) {
//    this.fs = fs;
//    this.commandMap = commandMap;
//  }

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

    switch (commandName) {
      case "ls":
        return new ListChildren(fs, getCommandArgument(splitCommand)).execute();
      case "mkdir":
        return new MakeDirectory(fs, getCommandArgument(splitCommand)).execute();
      case "cd":
        return new ChangeDirectory(fs, getCommandArgument(splitCommand)).execute();
      case "touch":
        return new Touch(fs, getCommandArgument(splitCommand)).execute();
      case "pwd":
        return new PrintWorkingDirectory(fs).execute();
      case "rm":
        //TODO: Remove should receive arguments in the same way the rest
        // of commands do. Fix it.
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
