package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

import static edu.austral.ingsis.clifford.Utils.getLastElement;

// TODO: May rename
public class CursorFileSystem implements FileSystem {
  private final Directory rootDirectory = new Directory("/");
  private List<Directory> dirPath = new ArrayList<>(List.of(rootDirectory));
  private final PathResolver pathResolver = new PathResolver(rootDirectory);

  @Override
  public Directory getWorkingDirectory() {
    return getLastElement(dirPath);
  }

  @Override
  public String getCurrentPath() {
    return dirPath.stream()
        .skip(1)
        .map(FileObject::getName)
        .reduce("", (String acc, String current) -> acc + "/" + current);
  }

  @Override
  public String changeWorkingDirectory(String path) {
    CdResult result = pathResolver.getDirectory(dirPath, path);

    if (result instanceof SuccessfulCd) {
      dirPath = ((SuccessfulCd) result).dirPath();
      return "moved to directory '" + getLastElement(dirPath).getName() + "'";
    } else return ((CdFailure) result).reason();
  }
}
