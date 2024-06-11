package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

//TODO: May rename
public class CursorFileSystem implements FileSystem {
    private final Directory rootDirectory = new Directory("root");
    private final Directory workingDirectory = rootDirectory;
    private List<Directory> dirPath = new ArrayList<>(List.of(rootDirectory));
    private final PathResolver pathResolver = new PathResolver(rootDirectory);

    @Override
    public Directory getWorkingDirectory() {
        return dirPath.getLast();
    }

    @Override
    public void changeToParentDirectory() {
        dirPath.removeLast();
    }

    @Override
    public String changeWorkingDirectory(String path) {
        CdResult result = pathResolver.getDirectory(dirPath, path);

        if (result instanceof SuccessfulCd) {
            dirPath = ((SuccessfulCd) result).dirPath();
            return "Successfully changed to directory";
        }
        else return ((CdFailure) result).reason();
    }

    private Directory getRootDirectory() {
        return dirPath.getFirst();
    }
}
