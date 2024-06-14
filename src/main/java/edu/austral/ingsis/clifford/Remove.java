package edu.austral.ingsis.clifford;

public class Remove implements Action {
  private final FileSystem fs;
  private final String[] arguments;

  public Remove(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.arguments = arguments;
  }

  // TODO: should probably turn it into a Visitor, to avoid type checking
  // TODO: modularize
  @Override
  public String execute() {
    if (arguments.length == 1) return "Invalid command: no arguments were passed";

    if (arguments[1].equals("--recursive")) {
      if (arguments.length != 3) {
        return "Invalid number of arguments: must pass the directory to be deleted";
      }

      fs.getWorkingDirectory().removeChild(arguments[2]);
      return "'" + arguments[2] + "' removed";
    } else {
      if (tryingToRemoveDirectory()) return "cannot remove '" + arguments[1] + "', is a directory";

      fs.getWorkingDirectory().removeChild(arguments[1]);
      return "'" + arguments[1] + "' removed";
    }
  }

  private boolean tryingToRemoveDirectory() {
    return fs.getWorkingDirectory().getChild(arguments[1]) instanceof Directory;
  }
}
