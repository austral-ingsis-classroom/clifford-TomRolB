package edu.austral.ingsis.clifford;

public class PrintWorkingDirectory implements Action {
  private final FileSystem fs;
  private final boolean isInitialized;

  public PrintWorkingDirectory(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.isInitialized = true;
  }

  public PrintWorkingDirectory() {
    this.fs = null;
    this.isInitialized = false;
  }

  @Override
  public String execute() {
    if (!isInitialized)
      throw new IllegalStateException("This object's variables were not initialized yet");
    return fs.getCurrentPath();
  }

  @Override
  public PrintWorkingDirectory withParameters(FileSystem fs, String[] arguments) {
    return new PrintWorkingDirectory(fs, arguments);
  }
}
