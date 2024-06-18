package edu.austral.ingsis.clifford;

import java.util.List;

public class Utils {
  public static Directory getLastElement(List<Directory> dirPath) {
    return dirPath.get(dirPath.size() - 1);
  }

  public static void removeLastElement(List<Directory> dirPath) {
    dirPath.remove(dirPath.size() - 1);
  }
}
