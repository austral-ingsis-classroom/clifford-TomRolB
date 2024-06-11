package edu.austral.ingsis.clifford;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory implements FileObject {
    private String name;
    private final Map<String, FileObject> children = new HashMap<String, FileObject>();

    public Directory(String name) {
        this.name = name;
    }

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

    public FileObject getChild(String name) {
        return children.get(name);
    }
}
