package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Cli;
import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class CliRunner implements FileSystemRunner {
  private final Cli cli;

  public CliRunner(FileSystem fs) {
    this.cli = new Cli(fs);
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    return cli.executeCommands(commands);
  }
}
