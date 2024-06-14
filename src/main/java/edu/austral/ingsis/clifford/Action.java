package edu.austral.ingsis.clifford;

public interface Action {
  String execute();
  String withParameters(FileSystem fs, String[] arguments);
}
