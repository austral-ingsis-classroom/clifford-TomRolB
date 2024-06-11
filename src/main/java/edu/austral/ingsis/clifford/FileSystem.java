package edu.austral.ingsis.clifford;

public interface FileSystem {
  Directory getWorkingDirectory();

  String getCurrentPath();

  String changeWorkingDirectory(String directory);
}
