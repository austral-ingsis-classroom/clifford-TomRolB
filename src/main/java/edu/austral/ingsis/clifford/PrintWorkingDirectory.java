package edu.austral.ingsis.clifford;

public class PrintWorkingDirectory implements Action {
  private final FileSystem fs;

  public PrintWorkingDirectory(FileSystem fs) {
    this.fs = fs;
  }

  @Override
  public String execute() {
    return fs.getCurrentPath();
  }
}
