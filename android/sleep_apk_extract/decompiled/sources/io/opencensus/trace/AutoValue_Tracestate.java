package io.opencensus.trace;

import java.util.List;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_Tracestate extends Tracestate {
    private final List<Object> entries;

    public AutoValue_Tracestate(List<Object> list) {
        if (list != null) {
            this.entries = list;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Null entries");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Tracestate) {
            return this.entries.equals(((Tracestate) obj).getEntries());
        }
        return false;
    }

    @Override // io.opencensus.trace.Tracestate
    public List<Object> getEntries() {
        return this.entries;
    }

    public int hashCode() {
        return this.entries.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Tracestate{entries=" + this.entries + "}";
    }
}
