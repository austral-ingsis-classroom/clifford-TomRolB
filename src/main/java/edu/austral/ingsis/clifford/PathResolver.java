package edu.austral.ingsis.clifford;

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
    public void visit(File file) {

    }

    @Override
    public void visit(Directory dir) {
        if (level == splitPath.length) {
            result = new SuccessfulCd(pathBeingBuilt);
        }

        FileObject child = dir.getChild(splitPath[level]);
        if (child == null) {
            result = new CdFailure("Invalid path: " + dir.getName() + "does not have a child " + splitPath[level]);
        }
        // TODO: should not actually cast
        else if (!(child instanceof Directory)) {
            result = new CdFailure("Invalid path: " + splitPath[level] + "is not a directory");
        }
        else {
            pathBeingBuilt.add(dir);
            level++;
            visit((Directory) child);
        }
    }

    public CdResult getDirectory(List<Directory> dirPath, String path) {
        switch (path) {
            case "":  return new CdFailure("You must pass a non-empty route");
            case ".":
                return new SuccessfulCd(dirPath);
            case "..":
                //TODO: corner case - reaching root
                ArrayList<Directory> newDirPath = new ArrayList<>(dirPath);
                newDirPath.removeLast();
                return new SuccessfulCd(newDirPath);
        }

        level = 0;
        result = null;
        splitPath = path.split("/");
        pathBeingBuilt = new ArrayList<>();

        if (pathStartsAtRoot(path)) visit(root);
        else visit(dirPath.getLast());

        return result;
    }

    private static boolean pathStartsAtRoot(String path) {
        return path.charAt(0) == '/';
    }
}
