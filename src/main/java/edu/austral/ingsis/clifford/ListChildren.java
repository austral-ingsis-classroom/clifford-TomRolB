package edu.austral.ingsis.clifford;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ListChildren implements Action {
    private final FileSystem fs;
    private final String order;

    public ListChildren(FileSystem fs, String order) {
        this.fs = fs;
        this.order = order;
    }

    @Override
    public String execute() {
        return sortIfNecessary(getFileObjectNames())
                .reduce("", concatWithPrevious())
                .stripTrailing();
    }

    private Stream<String> sortIfNecessary(Stream<String> fileObjectNames) {
        switch (order) {
            case "--ord=asc": return fileObjectNames.sorted(Comparator.naturalOrder());
            case "--ord=desc": return fileObjectNames.sorted(Comparator.reverseOrder());
            default: return fileObjectNames;
        }
    }

    private Stream<String> getFileObjectNames() {
        return fs
                .getWorkingDirectory()
                .getChildren()
                .stream()
                .map(FileObject::getName);
    }

    private static BinaryOperator<String> concatWithPrevious() {
        return (acc, current) -> acc + current + " ";
    }
}
