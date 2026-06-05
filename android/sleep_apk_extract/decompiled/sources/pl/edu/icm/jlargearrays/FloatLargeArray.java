package pl.edu.icm.jlargearrays;

import pl.edu.icm.jlargearrays.LargeArray;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import sun.misc.Cleaner;

/* JADX INFO: loaded from: classes5.dex */
public class FloatLargeArray extends LargeArray {
    private static final long serialVersionUID = -8342458159338079576L;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private float[] f136data;

    public FloatLargeArray(long j, boolean z) {
        this.type = LargeArrayType.FLOAT;
        this.sizeof = 4L;
        if (j <= 0) {
            Types$$ExternalSyntheticBUOutline0.m(j);
            throw null;
        }
        this.length = j;
        if (j <= LargeArray.getMaxSizeOf32bitArray()) {
            this.f136data = new float[(int) j];
            return;
        }
        this.ptr = LargeArrayUtils.UNSAFE.allocateMemory(this.length * this.sizeof);
        if (z) {
            zeroNativeMemory(j);
        }
        Cleaner.create(this, new LargeArray.Deallocator(this.ptr, this.length, this.sizeof));
        MemoryCounter.increaseCounter(this.length * this.sizeof);
    }

    public FloatLargeArray clone() {
        boolean z = this.isConstant;
        long j = this.length;
        if (z) {
            return new FloatLargeArray(j, getFloat(0L));
        }
        FloatLargeArray floatLargeArray = new FloatLargeArray(j, false);
        LargeArrayUtils.arraycopy(this, 0L, floatLargeArray, 0L, this.length);
        return floatLargeArray;
    }

    @Override // pl.edu.icm.jlargearrays.LargeArray
    public boolean equals(Object obj) {
        return super.equals(obj) && this.f136data == ((FloatLargeArray) obj).f136data;
    }

    public final float[] getData() {
        return this.f136data;
    }

    public final float getFloat(long j) {
        long j2 = this.ptr;
        if (j2 != 0) {
            return LargeArrayUtils.UNSAFE.getFloat((this.sizeof * j) + j2);
        }
        boolean z = this.isConstant;
        float[] fArr = this.f136data;
        return z ? fArr[0] : fArr[(int) j];
    }

    @Override // pl.edu.icm.jlargearrays.LargeArray
    public int hashCode() {
        int iHashCode = super.hashCode() * 29;
        float[] fArr = this.f136data;
        return iHashCode + (fArr != null ? fArr.hashCode() : 0);
    }

    public final void setFloat(long j, float f) {
        long j2 = this.ptr;
        if (j2 != 0) {
            LargeArrayUtils.UNSAFE.putFloat((this.sizeof * j) + j2, f);
        } else {
            if (this.isConstant) {
                throw new IllegalAccessError("Constant arrays cannot be modified.");
            }
            this.f136data[(int) j] = f;
        }
    }

    public FloatLargeArray(long j) {
        this(j, true);
    }

    public FloatLargeArray(long j, float f) {
        this.type = LargeArrayType.FLOAT;
        this.sizeof = 4L;
        if (j > 0) {
            this.length = j;
            this.isConstant = true;
            this.f136data = new float[]{f};
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m(j);
        throw null;
    }

    public FloatLargeArray(float[] fArr) {
        this.type = LargeArrayType.FLOAT;
        this.sizeof = 4L;
        this.length = fArr.length;
        this.f136data = fArr;
    }
}
