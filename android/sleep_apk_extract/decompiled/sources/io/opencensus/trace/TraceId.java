package io.opencensus.trace;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class TraceId implements Comparable<TraceId> {
    public static final TraceId INVALID = new TraceId(0, 0);
    private final long idHi;
    private final long idLo;

    private TraceId(long j, long j2) {
        this.idHi = j;
        this.idLo = j2;
    }

    @Override // java.lang.Comparable
    public int compareTo(TraceId traceId) {
        long j = this.idHi;
        long j2 = traceId.idHi;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        long j3 = this.idLo;
        long j4 = traceId.idLo;
        if (j3 == j4) {
            return 0;
        }
        return j3 < j4 ? -1 : 1;
    }

    public void copyLowerBase16To(char[] cArr, int i) {
        BigendianEncoding.longToBase16String(this.idHi, cArr, i);
        BigendianEncoding.longToBase16String(this.idLo, cArr, i + 16);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceId)) {
            return false;
        }
        TraceId traceId = (TraceId) obj;
        return this.idHi == traceId.idHi && this.idLo == traceId.idLo;
    }

    public int hashCode() {
        long j = this.idHi;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        long j2 = this.idLo;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toLowerBase16() {
        char[] cArr = new char[32];
        copyLowerBase16To(cArr, 0);
        return new String(cArr);
    }

    public String toString() {
        return "TraceId{traceId=" + toLowerBase16() + "}";
    }
}
