package edu.austral.ingsis.clifford;

import java.util.List;
import java.util.Map;

public class Cli {
  private final FileSystem fs;
  private final Map<String, Action> commandMap;

  public Cli(FileSystem fs, Map<String, Action> commandMap) {
    this.fs = fs;
    this.commandMap = commandMap;
  }

  public List<String> executeCommands(List<String> commands) {
    return commands.stream().map(this::executeCommand).toList();
  }

  public String executeCommand(String command) {
    String[] splitCommand = command.split(" ", 2);

    String commandName = splitCommand[0];
    String[] arguments = getArgumentsOrEmptyArray(splitCommand);

    return commandMap
            .get(commandName)
            .withParameters(fs, arguments)
            .execute();
  }

    private static String[] getArgumentsOrEmptyArray(String[] splitCommand) {
        return splitCommand.length > 1 ? splitCommand[1].split(" ") : new String[]{};
    }
}
