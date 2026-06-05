package org.apache.commons.math3.linear;

import java.util.Locale;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractRealMatrix extends RealLinearOperator implements RealMatrix {
    private static final RealMatrixFormat DEFAULT_FORMAT;

    static {
        RealMatrixFormat realMatrixFormat = RealMatrixFormat.getInstance(Locale.US);
        DEFAULT_FORMAT = realMatrixFormat;
        realMatrixFormat.getFormat().setMinimumFractionDigits(1);
    }

    public AbstractRealMatrix(int i, int i2) {
        if (i < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i));
        }
        if (i2 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i2));
        }
    }

    public abstract RealMatrix createMatrix(int i, int i2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealMatrix)) {
            return false;
        }
        RealMatrix realMatrix = (RealMatrix) obj;
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (realMatrix.getColumnDimension() != columnDimension || realMatrix.getRowDimension() != rowDimension) {
            return false;
        }
        for (int i = 0; i < rowDimension; i++) {
            for (int i2 = 0; i2 < columnDimension; i2++) {
                if (getEntry(i, i2) != realMatrix.getEntry(i, i2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract double getEntry(int i, int i2);

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    public int hashCode() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        int iHash = ((217 + rowDimension) * 31) + columnDimension;
        for (int i = 0; i < rowDimension; i++) {
            int i2 = 0;
            while (i2 < columnDimension) {
                int i3 = i2 + 1;
                iHash = (iHash * 31) + (MathUtils.hash(getEntry(i, i2)) * ((i3 * 17) + ((i + 1) * 11)));
                i2 = i3;
            }
        }
        return iHash;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public boolean isSquare() {
        return getColumnDimension() == getRowDimension();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix realMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        int columnDimension2 = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i = 0; i < rowDimension; i++) {
            for (int i2 = 0; i2 < columnDimension; i2++) {
                double entry = 0.0d;
                for (int i3 = 0; i3 < columnDimension2; i3++) {
                    entry += realMatrix.getEntry(i3, i2) * getEntry(i, i3);
                }
                realMatrixCreateMatrix.setEntry(i, i2, entry);
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealVector operate(RealVector realVector) {
        try {
            return new ArrayRealVector(operate(((ArrayRealVector) realVector).getDataRef()), false);
        } catch (ClassCastException unused) {
            int rowDimension = getRowDimension();
            int columnDimension = getColumnDimension();
            if (realVector.getDimension() != columnDimension) {
                throw new DimensionMismatchException(realVector.getDimension(), columnDimension);
            }
            double[] dArr = new double[rowDimension];
            for (int i = 0; i < rowDimension; i++) {
                double entry = 0.0d;
                for (int i2 = 0; i2 < columnDimension; i2++) {
                    entry += realVector.getEntry(i2) * getEntry(i, i2);
                }
                dArr[i] = entry;
            }
            return new ArrayRealVector(dArr, false);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract double[] operate(double[] dArr);

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i = 0; i < rowDimension; i++) {
            for (int i2 = 0; i2 < columnDimension; i2++) {
                realMatrixCreateMatrix.setEntry(i, i2, getEntry(i, i2) * d);
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setColumnVector(int i, RealVector realVector) {
        MatrixUtils.checkColumnIndex(this, i);
        int rowDimension = getRowDimension();
        if (realVector.getDimension() != rowDimension) {
            throw new MatrixDimensionMismatchException(realVector.getDimension(), 1, rowDimension, 1);
        }
        for (int i2 = 0; i2 < rowDimension; i2++) {
            setEntry(i2, i, realVector.getEntry(i2));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract void setEntry(int i, int i2, double d);

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setRowVector(int i, RealVector realVector) {
        MatrixUtils.checkRowIndex(this, i);
        int columnDimension = getColumnDimension();
        if (realVector.getDimension() != columnDimension) {
            throw new MatrixDimensionMismatchException(1, realVector.getDimension(), 1, columnDimension);
        }
        for (int i2 = 0; i2 < columnDimension; i2++) {
            setEntry(i, i2, realVector.getEntry(i2));
        }
    }

    public void setSubMatrix(double[][] dArr, int i, int i2) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length2 = dArr[0].length;
        if (length2 == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        for (int i3 = 1; i3 < length; i3++) {
            double[] dArr2 = dArr[i3];
            if (dArr2.length != length2) {
                throw new DimensionMismatchException(length2, dArr2.length);
            }
        }
        MatrixUtils.checkRowIndex(this, i);
        MatrixUtils.checkColumnIndex(this, i2);
        MatrixUtils.checkRowIndex(this, (length + i) - 1);
        MatrixUtils.checkColumnIndex(this, (length2 + i2) - 1);
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length2; i5++) {
                setEntry(i + i4, i2 + i5, dArr[i4][i5]);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String name = getClass().getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(DEFAULT_FORMAT.format(this));
        return sb.toString();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix transpose() {
        final RealMatrix realMatrixCreateMatrix = createMatrix(getColumnDimension(), getRowDimension());
        walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.5
            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i, int i2, double d) {
                realMatrixCreateMatrix.setEntry(i2, i, d);
            }
        });
        return realMatrixCreateMatrix;
    }

    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        return walkInRowOrder(realMatrixPreservingVisitor);
    }

    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i = 0; i < rowDimension; i++) {
            for (int i2 = 0; i2 < columnDimension; i2++) {
                realMatrixPreservingVisitor.visit(i, i2, getEntry(i, i2));
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    public AbstractRealMatrix() {
    }
}
