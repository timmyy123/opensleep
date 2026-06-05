package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MatrixUtils {
    public static final RealMatrixFormat DEFAULT_FORMAT = RealMatrixFormat.getInstance();
    public static final RealMatrixFormat OCTAVE_FORMAT = new RealMatrixFormat("[", "]", "", "", "; ", ", ");

    public static void checkColumnIndex(AnyMatrix anyMatrix, int i) {
        if (i < 0 || i >= anyMatrix.getColumnDimension()) {
            throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(i), 0, Integer.valueOf(anyMatrix.getColumnDimension() - 1));
        }
    }

    public static void checkMatrixIndex(AnyMatrix anyMatrix, int i, int i2) {
        checkRowIndex(anyMatrix, i);
        checkColumnIndex(anyMatrix, i2);
    }

    public static void checkMultiplicationCompatible(AnyMatrix anyMatrix, AnyMatrix anyMatrix2) {
        if (anyMatrix.getColumnDimension() != anyMatrix2.getRowDimension()) {
            throw new DimensionMismatchException(anyMatrix.getColumnDimension(), anyMatrix2.getRowDimension());
        }
    }

    public static void checkRowIndex(AnyMatrix anyMatrix, int i) {
        if (i < 0 || i >= anyMatrix.getRowDimension()) {
            throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(i), 0, Integer.valueOf(anyMatrix.getRowDimension() - 1));
        }
    }

    public static RealMatrix createRealDiagonalMatrix(double[] dArr) {
        RealMatrix realMatrixCreateRealMatrix = createRealMatrix(dArr.length, dArr.length);
        for (int i = 0; i < dArr.length; i++) {
            realMatrixCreateRealMatrix.setEntry(i, i, dArr[i]);
        }
        return realMatrixCreateRealMatrix;
    }

    public static RealMatrix createRealMatrix(double[][] dArr) {
        double[] dArr2;
        if (dArr == null || (dArr2 = dArr[0]) == null) {
            throw new NullArgumentException();
        }
        return dArr.length * dArr2.length <= 4096 ? new Array2DRowRealMatrix(dArr) : new BlockRealMatrix(dArr);
    }

    public static boolean isSymmetric(RealMatrix realMatrix, double d) {
        return isSymmetricInternal(realMatrix, d, false);
    }

    private static boolean isSymmetricInternal(RealMatrix realMatrix, double d, boolean z) {
        int rowDimension = realMatrix.getRowDimension();
        if (rowDimension != realMatrix.getColumnDimension()) {
            if (z) {
                throw new NonSquareMatrixException(rowDimension, realMatrix.getColumnDimension());
            }
            return false;
        }
        int i = 0;
        while (i < rowDimension) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < rowDimension; i3++) {
                double entry = realMatrix.getEntry(i, i3);
                double entry2 = realMatrix.getEntry(i3, i);
                if (FastMath.abs(entry - entry2) > FastMath.max(FastMath.abs(entry), FastMath.abs(entry2)) * d) {
                    if (z) {
                        throw new NonSymmetricMatrixException(i, i3, d);
                    }
                    return false;
                }
            }
            i = i2;
        }
        return true;
    }

    public static RealMatrix createRealMatrix(int i, int i2) {
        return i * i2 <= 4096 ? new Array2DRowRealMatrix(i, i2) : new BlockRealMatrix(i, i2);
    }
}
