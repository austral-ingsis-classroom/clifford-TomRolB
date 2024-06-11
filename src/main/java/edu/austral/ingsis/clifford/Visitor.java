package edu.austral.ingsis.clifford;

public interface Visitor {
    void visit(File file);
    void visit(Directory dir);
}
