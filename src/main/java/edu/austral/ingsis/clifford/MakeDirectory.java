package edu.austral.ingsis.clifford;

public class MakeDirectory implements Action {
  private final FileSystem fs;
  private final String dirName;
  private final boolean isInitialized;

  public MakeDirectory(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.dirName = arguments[0];
    this.isInitialized = true;
  }

  public MakeDirectory() {
    this.fs = null;
    this.dirName = null;
    this.isInitialized = false;
  }

  @Override
  public String execute() {
    if (!isInitialized) throw new IllegalStateException("This object's variables were not initialized yet");
    fs.getWorkingDirectory().addChild(dirName, new Directory(dirName));
    return "'" + dirName + "' directory created";
  }

  @Override
  public MakeDirectory withParameters(FileSystem fs, String[] arguments) {
    return new MakeDirectory(fs, arguments);
  }
}
