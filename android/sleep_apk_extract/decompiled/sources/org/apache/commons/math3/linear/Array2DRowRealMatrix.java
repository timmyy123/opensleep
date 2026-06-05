package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Array2DRowRealMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private double[][] f119data;

    public Array2DRowRealMatrix(double[][] dArr, boolean z) {
        if (z) {
            copyIn(dArr);
            return;
        }
        if (dArr == null) {
            throw new NullArgumentException();
        }
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length2 = dArr[0].length;
        if (length2 == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        for (int i = 1; i < length; i++) {
            if (dArr[i].length != length2) {
                throw new DimensionMismatchException(dArr[i].length, length2);
            }
        }
        this.f119data = dArr;
    }

    private void copyIn(double[][] dArr) {
        setSubMatrix(dArr, 0, 0);
    }

    private double[][] copyOut() {
        int rowDimension = getRowDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, getColumnDimension());
        for (int i = 0; i < rowDimension; i++) {
            double[] dArr2 = this.f119data[i];
            System.arraycopy(dArr2, 0, dArr[i], 0, dArr2.length);
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix copy() {
        return new Array2DRowRealMatrix(copyOut(), false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix createMatrix(int i, int i2) {
        return new Array2DRowRealMatrix(i, i2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        double[] dArr;
        double[][] dArr2 = this.f119data;
        if (dArr2 == null || (dArr = dArr2[0]) == null) {
            return 0;
        }
        return dArr.length;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        return copyOut();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i, int i2) {
        MatrixUtils.checkMatrixIndex(this, i, i2);
        return this.f119data[i][i2];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        double[][] dArr = this.f119data;
        if (dArr == null) {
            return 0;
        }
        return dArr.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new DimensionMismatchException(dArr.length, columnDimension);
        }
        double[] dArr2 = new double[rowDimension];
        for (int i = 0; i < rowDimension; i++) {
            double[] dArr3 = this.f119data[i];
            double d = 0.0d;
            for (int i2 = 0; i2 < columnDimension; i2++) {
                d += dArr3[i2] * dArr[i2];
            }
            dArr2[i] = d;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i, int i2, double d) {
        MatrixUtils.checkMatrixIndex(this, i, i2);
        this.f119data[i][i2] = d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void setSubMatrix(double[][] dArr, int i, int i2) {
        if (this.f119data != null) {
            super.setSubMatrix(dArr, i, i2);
            return;
        }
        if (i > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, Integer.valueOf(i));
        }
        if (i2 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, Integer.valueOf(i2));
        }
        MathUtils.checkNotNull(dArr);
        if (dArr.length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length = dArr[0].length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        this.f119data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, length);
        int i3 = 0;
        while (true) {
            double[][] dArr2 = this.f119data;
            if (i3 >= dArr2.length) {
                return;
            }
            double[] dArr3 = dArr[i3];
            if (dArr3.length != length) {
                throw new DimensionMismatchException(dArr[i3].length, length);
            }
            System.arraycopy(dArr3, 0, dArr2[i3 + i], i2, length);
            i3++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i = 0; i < rowDimension; i++) {
            double[] dArr = this.f119data[i];
            for (int i2 = 0; i2 < columnDimension; i2++) {
                realMatrixPreservingVisitor.visit(i, i2, dArr[i2]);
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    public Array2DRowRealMatrix(double[][] dArr) {
        copyIn(dArr);
    }

    public Array2DRowRealMatrix(int i, int i2) {
        super(i, i2);
        this.f119data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, i2);
    }
}
