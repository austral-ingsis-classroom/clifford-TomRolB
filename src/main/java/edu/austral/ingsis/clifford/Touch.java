package edu.austral.ingsis.clifford;

public class Touch implements Action {
    private final FileSystem fs;
    private final String name;
    private final String content;

    public Touch(FileSystem fs, String name, String content) {
        this.fs = fs;
        this.name = name;
        this.content = content;
    }

    public Touch(FileSystem fs, String name) {
        this.fs = fs;
        this.name = name;
        this.content = "";
    }

    @Override
    public String execute() {
        fs.getWorkingDirectory().addChild(name, new File(name, content));
        return "'" + name + "' file created";
    }
}
