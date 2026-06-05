package twitter4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
abstract class EntityIndex implements Comparable<EntityIndex>, Serializable {
    private static final long serialVersionUID = 3757474748266170719L;
    private int start = -1;
    private int end = -1;

    @Override // java.lang.Comparable
    public int compareTo(EntityIndex entityIndex) {
        long j = this.start - entityIndex.start;
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public void setEnd(int i) {
        this.end = i;
    }

    public void setStart(int i) {
        this.start = i;
    }
}
