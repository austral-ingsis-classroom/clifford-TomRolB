package edu.austral.ingsis.clifford;

public interface Action {
  String execute();
  Action withParameters(FileSystem fs, String[] arguments);
}
