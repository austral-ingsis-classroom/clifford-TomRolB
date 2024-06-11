package edu.austral.ingsis.clifford;

public class ChangeDirectory implements Action {
  private final FileSystem fs;
  private final String route;

  public ChangeDirectory(String route, FileSystem fs) {
    this.route = route;
    this.fs = fs;
  }

  @Override
  public String execute() {
    return fs.changeWorkingDirectory(route);
  }
}
