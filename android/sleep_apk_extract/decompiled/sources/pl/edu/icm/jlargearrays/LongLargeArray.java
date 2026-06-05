package pl.edu.icm.jlargearrays;

import pl.edu.icm.jlargearrays.LargeArray;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import sun.misc.Cleaner;

/* JADX INFO: loaded from: classes5.dex */
public class LongLargeArray extends LargeArray {
    private static final long serialVersionUID = -2579271120060523901L;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private long[] f137data;

    public LongLargeArray(long j, boolean z) {
        this.type = LargeArrayType.LONG;
        this.sizeof = 8L;
        if (j <= 0) {
            Types$$ExternalSyntheticBUOutline0.m(j);
            throw null;
        }
        this.length = j;
        if (j <= LargeArray.getMaxSizeOf32bitArray()) {
            this.f137data = new long[(int) j];
            return;
        }
        this.ptr = LargeArrayUtils.UNSAFE.allocateMemory(this.length * this.sizeof);
        if (z) {
            zeroNativeMemory(j);
        }
        Cleaner.create(this, new LargeArray.Deallocator(this.ptr, this.length, this.sizeof));
        MemoryCounter.increaseCounter(this.length * this.sizeof);
    }

    public LongLargeArray clone() {
        boolean z = this.isConstant;
        long j = this.length;
        if (z) {
            return new LongLargeArray(j, getLong(0L));
        }
        LongLargeArray longLargeArray = new LongLargeArray(j, false);
        LargeArrayUtils.arraycopy(this, 0L, longLargeArray, 0L, this.length);
        return longLargeArray;
    }

    @Override // pl.edu.icm.jlargearrays.LargeArray
    public boolean equals(Object obj) {
        return super.equals(obj) && this.f137data == ((LongLargeArray) obj).f137data;
    }

    public final long getLong(long j) {
        long j2 = this.ptr;
        if (j2 != 0) {
            return LargeArrayUtils.UNSAFE.getLong((this.sizeof * j) + j2);
        }
        boolean z = this.isConstant;
        long[] jArr = this.f137data;
        return z ? jArr[0] : jArr[(int) j];
    }

    @Override // pl.edu.icm.jlargearrays.LargeArray
    public int hashCode() {
        int iHashCode = super.hashCode() * 29;
        long[] jArr = this.f137data;
        return iHashCode + (jArr != null ? jArr.hashCode() : 0);
    }

    public final void setLong(long j, long j2) {
        long j3 = this.ptr;
        if (j3 != 0) {
            LargeArrayUtils.UNSAFE.putLong((this.sizeof * j) + j3, j2);
        } else {
            if (this.isConstant) {
                throw new IllegalAccessError("Constant arrays cannot be modified.");
            }
            this.f137data[(int) j] = j2;
        }
    }

    public LongLargeArray(long j) {
        this(j, true);
    }

    public LongLargeArray(long j, long j2) {
        this.type = LargeArrayType.DOUBLE;
        this.sizeof = 8L;
        if (j > 0) {
            this.length = j;
            this.isConstant = true;
            this.f137data = new long[]{j2};
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m(j);
        throw null;
    }
}
