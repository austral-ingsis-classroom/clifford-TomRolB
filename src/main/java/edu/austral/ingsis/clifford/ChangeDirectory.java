package edu.austral.ingsis.clifford;

public class ChangeDirectory implements Action {
  private final FileSystem fs;
  private final String route;

  public ChangeDirectory(FileSystem fs, String route) {
    this.route = route;
    this.fs = fs;
  }

  @Override
  public String execute() {
    return fs.changeWorkingDirectory(route);
  }
}
