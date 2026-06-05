package io.opencensus.trace;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SpanId implements Comparable<SpanId> {
    public static final SpanId INVALID = new SpanId(0);
    private final long id;

    private SpanId(long j) {
        this.id = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(SpanId spanId) {
        long j = this.id;
        long j2 = spanId.id;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public void copyLowerBase16To(char[] cArr, int i) {
        BigendianEncoding.longToBase16String(this.id, cArr, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SpanId) && this.id == ((SpanId) obj).id;
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[8];
        BigendianEncoding.longToByteArray(this.id, bArr, 0);
        return bArr;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toLowerBase16() {
        char[] cArr = new char[16];
        copyLowerBase16To(cArr, 0);
        return new String(cArr);
    }

    public String toString() {
        return "SpanId{spanId=" + toLowerBase16() + "}";
    }
}
