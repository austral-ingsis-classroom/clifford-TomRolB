package edu.austral.ingsis.clifford;

public class ListChildren implements Action {
    private final FileSystem fs;

    public ListChildren(FileSystem fs) {
        this.fs = fs;
    }

    @Override
    public String execute() {
        return fs
                .getWorkingDirectory()
                .getChildren()
                .stream()
                .map(Object::toString)
                .reduce("", (acc, current) -> acc + " " + current);
    }
}
