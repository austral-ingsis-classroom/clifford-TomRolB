package edu.austral.ingsis.clifford;

public class Remove implements Action {
  private final FileSystem fs;
  private final String[] arguments;
  private final boolean isInitialized;

  public Remove(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.arguments = arguments;
    this.isInitialized = true;
  }

  public Remove() {
    this.fs = null;
    this.arguments = null;
    this.isInitialized = false;
  }

  // TODO: should probably turn it into a Visitor, to avoid type checking
  // TODO: modularize
  @Override
  public String execute() {
    if (!isInitialized)
      throw new IllegalStateException("This object's variables were not initialized yet");
    if (arguments.length == 0) return "Invalid command: no arguments were passed";

    if (arguments[0].equals("--recursive")) {
      if (arguments.length != 2) {
        return "Invalid number of arguments: must pass the directory to be deleted";
      }

      fs.getWorkingDirectory().removeChild(arguments[1]);
      return "'" + arguments[1] + "' removed";
    } else {
      if (tryingToRemoveDirectory()) return "cannot remove '" + arguments[0] + "', is a directory";

      fs.getWorkingDirectory().removeChild(arguments[0]);
      return "'" + arguments[0] + "' removed";
    }
  }

  @Override
  public Remove withParameters(FileSystem fs, String[] arguments) {
    return new Remove(fs, arguments);
  }

  private boolean tryingToRemoveDirectory() {
    return fs.getWorkingDirectory().getChild(arguments[0]) instanceof Directory;
  }
}
