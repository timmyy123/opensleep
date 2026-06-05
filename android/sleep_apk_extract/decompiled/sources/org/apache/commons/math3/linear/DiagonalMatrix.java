package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
public class DiagonalMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 20121229;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private final double[] f121data;

    public DiagonalMatrix(double[] dArr, boolean z) {
        MathUtils.checkNotNull(dArr);
        this.f121data = z ? (double[]) dArr.clone() : dArr;
    }

    private void ensureZero(double d) {
        if (!Precision.equals(0.0d, d, 1)) {
            throw new NumberIsTooLargeException(Double.valueOf(FastMath.abs(d)), 0, true);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix copy() {
        return new DiagonalMatrix(this.f121data);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix createMatrix(int i, int i2) {
        if (i == i2) {
            return new DiagonalMatrix(i);
        }
        throw new DimensionMismatchException(i, i2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.f121data.length;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        int rowDimension = getRowDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, rowDimension);
        for (int i = 0; i < rowDimension; i++) {
            dArr[i][i] = this.f121data[i];
        }
        return dArr;
    }

    public double[] getDataRef() {
        return this.f121data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i, int i2) {
        MatrixUtils.checkMatrixIndex(this, i, i2);
        if (i == i2) {
            return this.f121data[i];
        }
        return 0.0d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.f121data.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix realMatrix) {
        if (realMatrix instanceof DiagonalMatrix) {
            return multiply((DiagonalMatrix) realMatrix);
        }
        MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, columnDimension);
        for (int i = 0; i < rowDimension; i++) {
            for (int i2 = 0; i2 < columnDimension; i2++) {
                dArr[i][i2] = realMatrix.getEntry(i, i2) * this.f121data[i];
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        return multiply(new DiagonalMatrix(dArr, false)).getDataRef();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i, int i2, double d) {
        if (i != i2) {
            ensureZero(d);
        } else {
            MatrixUtils.checkRowIndex(this, i);
            this.f121data[i] = d;
        }
    }

    public DiagonalMatrix(double[] dArr) {
        this(dArr, true);
    }

    public DiagonalMatrix(int i) {
        super(i, i);
        this.f121data = new double[i];
    }

    public DiagonalMatrix multiply(DiagonalMatrix diagonalMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, diagonalMatrix);
        int rowDimension = getRowDimension();
        double[] dArr = new double[rowDimension];
        for (int i = 0; i < rowDimension; i++) {
            dArr[i] = this.f121data[i] * diagonalMatrix.f121data[i];
        }
        return new DiagonalMatrix(dArr, false);
    }
}
