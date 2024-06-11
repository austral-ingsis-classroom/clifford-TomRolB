package edu.austral.ingsis.clifford;

//TODO: may refactor so that it takes a ChangeDirectoryStrategy, to make it extensible
public class ChangeDirectory implements Action {
    private final FileSystem fs;
    private final String route;
    private final PathResolver resolver = new PathResolver(fs, route);

    public ChangeDirectory (String route, FileSystem fs) {
        this.route = route;
        this.fs = fs;
    }

    @Override
    public String execute() {
        Directory directoryInPath = resolver.getDirectory();
        return "";
    }
}
