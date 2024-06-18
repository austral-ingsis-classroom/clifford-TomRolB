package edu.austral.ingsis.clifford;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ListChildren implements Action {
  private final FileSystem fs;
  private final String order;
  private final boolean isInitialized;

  public ListChildren(FileSystem fs, String[] arguments) {
    this.fs = fs;
    this.order = arguments.length > 0? arguments[0] : "";
    this.isInitialized = true;
  }

  public ListChildren() {
    this.fs = null;
    this.order = null;
    this.isInitialized = false;
  }

  @Override
  public String execute() {
    if (!isInitialized) throw new IllegalStateException("This object's variables were not initialized yet");
    return sortIfNecessary(getFileObjectNames()).reduce("", concatWithPrevious()).stripTrailing();
  }

  @Override
  public ListChildren withParameters(FileSystem fs, String[] arguments) {
    return new ListChildren(fs, arguments);
  }

  private Stream<String> sortIfNecessary(Stream<String> fileObjectNames) {
    switch (order) {
      case "--ord=asc":
        return fileObjectNames.sorted(Comparator.naturalOrder());
      case "--ord=desc":
        return fileObjectNames.sorted(Comparator.reverseOrder());
      default:
        return fileObjectNames;
    }
  }

  private Stream<String> getFileObjectNames() {
    return fs.getWorkingDirectory().getChildren().stream().map(FileObject::getName);
  }

  private static BinaryOperator<String> concatWithPrevious() {
    return (acc, current) -> acc + current + " ";
  }
}
