package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Action;
import edu.austral.ingsis.clifford.Cli;
import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;
import java.util.Map;

public class CliRunner implements FileSystemRunner {
  private final Cli cli;

  public CliRunner(FileSystem fs, Map<String, Action> commandMap) {
    this.cli = new Cli(fs, commandMap);
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    return cli.executeCommands(commands);
  }
}
