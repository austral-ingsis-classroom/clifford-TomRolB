package edu.austral.ingsis.clifford;

public class Remove implements Action {
    private final FileSystem fs;
    private final String name;

    public Remove(FileSystem fs, String name) {
        this.fs = fs;
        this.name = name;
    }

    @Override
    public String execute() {
        fs.getWorkingDirectory().removeChild(name);
        return "Removed " + name;
    }
}
