package edu.austral.ingsis.clifford;

import java.util.Collection;
import java.util.Map;

public class Directory implements FileObject {
    private String name;
    private Map<String, FileObject> children;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

    public void addChild(String name, FileObject child) {
        children.put(name, child);
    }

    public void removeChild(String name) {
        children.remove(name);
    }

    public Collection<FileObject> getChildren() {
        return children.values();
    }
}
