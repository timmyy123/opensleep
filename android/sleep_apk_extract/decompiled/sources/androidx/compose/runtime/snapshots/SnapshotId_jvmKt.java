package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\t\u001a\u00020\u0000*\u00060\u0002j\u0002`\u00032\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\f\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00002\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f*\n\u0010\u0010\"\u00020\u00062\u00020\u0006*\n\u0010\u0011\"\u00020\u00022\u00020\u0002¨\u0006\u0012"}, d2 = {"", "capacity", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "snapshotIdArrayWithCapacity", "(I)[J", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "id", "binarySearch", "([JJ)I", "index", "withIdInsertedAt", "([JIJ)[J", "toSnapshotId", "(I)J", "SnapshotId", "SnapshotIdArray", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class SnapshotId_jvmKt {
    public static final int binarySearch(long[] jArr, long j) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            long j2 = jArr[i2];
            if (j > j2) {
                i = i2 + 1;
            } else {
                if (j >= j2) {
                    return i2;
                }
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final long[] snapshotIdArrayWithCapacity(int i) {
        return new long[i];
    }

    public static final long toSnapshotId(int i) {
        return i;
    }

    public static final long[] withIdInsertedAt(long[] jArr, int i, long j) {
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        ArraysKt___ArraysJvmKt.copyInto(jArr, jArr2, 0, 0, i);
        ArraysKt___ArraysJvmKt.copyInto(jArr, jArr2, i + 1, i, length);
        jArr2[i] = j;
        return jArr2;
    }
}
