package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ArrayRealVector extends RealVector implements Serializable {
    private static final RealVectorFormat DEFAULT_FORMAT = RealVectorFormat.getInstance();
    private static final long serialVersionUID = -1097961340710804027L;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private double[] f120data;

    public ArrayRealVector(double[] dArr, boolean z) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        this.f120data = z ? (double[]) dArr.clone() : dArr;
    }

    public void checkVectorDimensions(int i) {
        if (this.f120data.length != i) {
            throw new DimensionMismatchException(this.f120data.length, i);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double dotProduct(RealVector realVector) {
        if (!(realVector instanceof ArrayRealVector)) {
            return super.dotProduct(realVector);
        }
        double[] dArr = ((ArrayRealVector) realVector).f120data;
        checkVectorDimensions(dArr.length);
        double d = 0.0d;
        int i = 0;
        while (true) {
            double[] dArr2 = this.f120data;
            if (i >= dArr2.length) {
                return d;
            }
            d += dArr2[i] * dArr[i];
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealVector)) {
            return false;
        }
        RealVector realVector = (RealVector) obj;
        if (this.f120data.length != realVector.getDimension()) {
            return false;
        }
        if (realVector.isNaN()) {
            return isNaN();
        }
        int i = 0;
        while (true) {
            double[] dArr = this.f120data;
            if (i >= dArr.length) {
                return true;
            }
            if (dArr[i] != realVector.getEntry(i)) {
                return false;
            }
            i++;
        }
    }

    public double[] getDataRef() {
        return this.f120data;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int getDimension() {
        return this.f120data.length;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getEntry(int i) {
        try {
            return this.f120data[i];
        } catch (IndexOutOfBoundsException unused) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i), 0, Integer.valueOf(this.getDimension() - 1));
        }
    }

    public int hashCode() {
        if (isNaN()) {
            return 9;
        }
        return MathUtils.hash(this.f120data);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isNaN() {
        for (double d : this.f120data) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void checkVectorDimensions(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
    }

    public ArrayRealVector(double[] dArr) {
        this.f120data = (double[]) dArr.clone();
    }
}
