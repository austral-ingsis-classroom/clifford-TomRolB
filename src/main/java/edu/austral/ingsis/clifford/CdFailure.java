package edu.austral.ingsis.clifford;

import java.util.Objects;

public final class CdFailure implements CdResult {
    private final String reason;

    public CdFailure(String reason) {
        this.reason = reason;
    }

    public String reason() {
        return reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CdFailure) obj;
        return Objects.equals(this.reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public String toString() {
        return "CdFailure[" +
                "reason=" + reason + ']';
    }
}
