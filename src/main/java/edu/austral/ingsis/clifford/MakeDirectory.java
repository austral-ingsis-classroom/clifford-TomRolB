package edu.austral.ingsis.clifford;

public class MakeDirectory implements Action {
    private final FileSystem fs;
    private final String dirName;

    public MakeDirectory(FileSystem fs, String dirName) {
        this.fs = fs;
        this.dirName = dirName;
    }

    @Override
    public String execute() {
        fs.getWorkingDirectory().addChild(dirName, new Directory(dirName));
        return "'" + dirName + "' directory created";
    }
}
