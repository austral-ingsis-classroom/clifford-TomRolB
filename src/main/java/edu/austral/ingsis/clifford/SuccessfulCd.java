package edu.austral.ingsis.clifford;

import java.util.List;
import java.util.Objects;

public final class SuccessfulCd implements CdResult {
    private final List<Directory> dirPath;

    public SuccessfulCd(List<Directory> dirPath) {
        this.dirPath = dirPath;
    }

    public List<Directory> dirPath() {
        return dirPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SuccessfulCd) obj;
        return Objects.equals(this.dirPath, that.dirPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dirPath);
    }

    @Override
    public String toString() {
        return "SuccessfulCd[" +
                "dirPath=" + dirPath + ']';
    }
}
