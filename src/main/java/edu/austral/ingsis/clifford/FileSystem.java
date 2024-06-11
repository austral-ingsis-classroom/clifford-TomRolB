package edu.austral.ingsis.clifford;

public interface FileSystem {
    Directory getWorkingDirectory();
    void changeToParentDirectory();
    String changeWorkingDirectory(String directory);
}
