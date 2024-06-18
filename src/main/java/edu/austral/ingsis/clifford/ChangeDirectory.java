package edu.austral.ingsis.clifford;

public class ChangeDirectory implements Action {
  private final FileSystem fs;
  private final String route;
  private final boolean isInitialized;

  public ChangeDirectory(FileSystem fs, String[] arguments) {
    this.route = arguments[0];
    this.fs = fs;
    this.isInitialized = true;
  }

  public ChangeDirectory() {
    this.route = null;
    this.fs = null;
    this.isInitialized = false;
  }

  @Override
  public String execute() {
    if (!isInitialized) throw new IllegalStateException("This object's variables were not initialized yet");
    return fs.changeWorkingDirectory(route);
  }

  @Override
  public ChangeDirectory withParameters(FileSystem fs, String[] arguments) {
    return new ChangeDirectory(fs, arguments);
  }
}
