package edu.austral.ingsis.clifford;

public class Remove implements Action {
    private final FileSystem fs;
    private final String[] arguments;

    public Remove(FileSystem fs, String[] arguments) {
        this.fs = fs;
        this.arguments = arguments;
    }

    @Override
    public String execute() {
        if (arguments[1].equals("--recursive")) {
            fs.getWorkingDirectory().removeChild(arguments[2]);
            return "'" + arguments[2] + "' removed";
        }
        else {
            fs.getWorkingDirectory().removeChild(arguments[1]);
            return "'" + arguments[1] + "' removed";
        }
    }
}
