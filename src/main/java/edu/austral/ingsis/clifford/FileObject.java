package edu.austral.ingsis.clifford;

public interface FileObject extends Visitable {
    void accept(Visitor visitor);
    String getName();
    void rename(String name);
}
