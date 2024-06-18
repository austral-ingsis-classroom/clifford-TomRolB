package edu.austral.ingsis.clifford;

public class Touch implements Action {
  private final FileSystem fs;
  private final String name;
  private final String content;
  private final boolean isInitialized;

  public Touch(FileSystem fs, String name, String content) {
    this.fs = fs;
    this.name = name;
    this.content = content;
    this.isInitialized = true;
  }

  public Touch(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.name = arguments[0];
    this.content = "";
    this.isInitialized = true;
  }

  public Touch() {
    this.fs = null;
    this.name = null;
    this.content = null;
    this.isInitialized = false;
  }

  @Override
  public String execute() {
    fs.getWorkingDirectory().addChild(name, new File(name, content));
    return "'" + name + "' file created";
  }

  @Override
  public Touch withParameters(FileSystem fs, String[] arguments) {
    return new Touch(fs, arguments);
  }
}
