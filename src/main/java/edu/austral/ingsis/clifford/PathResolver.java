package edu.austral.ingsis.clifford;

import static edu.austral.ingsis.clifford.Utils.getLastElement;
import static edu.austral.ingsis.clifford.Utils.removeLastElement;

import java.util.ArrayList;
import java.util.List;

public class PathResolver implements Visitor {
  private final Directory root;
  private CdResult result;
  private List<Directory> pathBeingBuilt;
  private int level;
  private String[] splitPath;

  public PathResolver(Directory root) {
    this.root = root;
  }

  @Override
  public void visit(File file) {}

  @Override
  public void visit(Directory dir) {
    if (level == splitPath.length) {
      result = new SuccessfulCd(pathBeingBuilt);
      return;
    }

    FileObject child = dir.getChild(splitPath[level]);
    if (child == null) {
      result = new CdFailure("'" + splitPath[level] + "' directory does not exist");
    }
    // TODO: should not actually cast
    else if (!(child instanceof Directory)) {
      result = new CdFailure("Invalid path: " + splitPath[level] + "is not a directory");
    } else {
      Directory childDir = (Directory) child;
      pathBeingBuilt.add(childDir);
      level++;
      visit(childDir);
    }
  }

  public CdResult getDirectory(List<Directory> dirPath, String path) {
    switch (path) {
      case "":
        return new CdFailure("You must pass a non-empty route");

      case ".":
        return new SuccessfulCd(dirPath);
      case "..":
        ArrayList<Directory> newDirPath = new ArrayList<>(dirPath);
        if (newDirPath.size() > 1) removeLastElement(newDirPath);
        return new SuccessfulCd(newDirPath);
      default:
        setInitialVisitorVariables(path);

        if (pathStartsAtRoot(path)) visit(root);
        else visit(getLastElement(dirPath));

        return result;
    }
  }

  private void setInitialVisitorVariables(String path) {
    level = 0;
    result = null;
    splitPath = path.split("/");
    pathBeingBuilt = new ArrayList<>(List.of(root));
  }

  private static boolean pathStartsAtRoot(String path) {
    return path.charAt(0) == '/';
  }
}
