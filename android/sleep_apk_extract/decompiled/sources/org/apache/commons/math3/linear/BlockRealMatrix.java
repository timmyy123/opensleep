package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes5.dex */
public class BlockRealMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 4991895511313664478L;
    private final int blockColumns;
    private final int blockRows;
    private final double[][] blocks;
    private final int columns;
    private final int rows;

    public BlockRealMatrix(int i, int i2, double[][] dArr, boolean z) {
        super(i, i2);
        this.rows = i;
        this.columns = i2;
        int i3 = (i + 51) / 52;
        this.blockRows = i3;
        int i4 = (i2 + 51) / 52;
        this.blockColumns = i4;
        if (z) {
            this.blocks = new double[i3 * i4][];
        } else {
            this.blocks = dArr;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.blockRows; i6++) {
            int iBlockHeight = blockHeight(i6);
            int i7 = 0;
            while (i7 < this.blockColumns) {
                if (dArr[i5].length != blockWidth(i7) * iBlockHeight) {
                    throw new DimensionMismatchException(dArr[i5].length, iBlockHeight * blockWidth(i7));
                }
                if (z) {
                    this.blocks[i5] = (double[]) dArr[i5].clone();
                }
                i7++;
                i5++;
            }
        }
    }

    private int blockHeight(int i) {
        if (i == this.blockRows - 1) {
            return this.rows - (i * 52);
        }
        return 52;
    }

    private int blockWidth(int i) {
        if (i == this.blockColumns - 1) {
            return this.columns - (i * 52);
        }
        return 52;
    }

    public static double[][] createBlocksLayout(int i, int i2) {
        int i3 = (i + 51) / 52;
        int i4 = (i2 + 51) / 52;
        double[][] dArr = new double[i3 * i4][];
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 * 52;
            int iMin = FastMath.min(i7 + 52, i) - i7;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = i8 * 52;
                dArr[i5] = new double[(FastMath.min(i9 + 52, i2) - i9) * iMin];
                i5++;
            }
        }
        return dArr;
    }

    public static double[][] toBlocksLayout(double[][] dArr) {
        int length = dArr.length;
        int i = 0;
        int length2 = dArr[0].length;
        int i2 = (length + 51) / 52;
        int i3 = (length2 + 51) / 52;
        for (double[] dArr2 : dArr) {
            int length3 = dArr2.length;
            if (length3 != length2) {
                throw new DimensionMismatchException(length2, length3);
            }
        }
        double[][] dArr3 = new double[i2 * i3][];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i4 * 52;
            int iMin = FastMath.min(i6 + 52, length);
            int i7 = iMin - i6;
            int i8 = i;
            while (i8 < i3) {
                int i9 = i8 * 52;
                int iMin2 = FastMath.min(i9 + 52, length2) - i9;
                double[] dArr4 = new double[i7 * iMin2];
                dArr3[i5] = dArr4;
                int i10 = i;
                int i11 = i6;
                while (i11 < iMin) {
                    System.arraycopy(dArr[i11], i9, dArr4, i10, iMin2);
                    i10 += iMin2;
                    i11++;
                    length = length;
                }
                i5++;
                i8++;
                i = 0;
            }
            i4++;
            i = 0;
        }
        return dArr3;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix copy() {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
        int i = 0;
        while (true) {
            double[][] dArr = this.blocks;
            if (i >= dArr.length) {
                return blockRealMatrix;
            }
            double[] dArr2 = dArr[i];
            System.arraycopy(dArr2, 0, blockRealMatrix.blocks[i], 0, dArr2.length);
            i++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public BlockRealMatrix createMatrix(int i, int i2) {
        return new BlockRealMatrix(i, i2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        double[][] dArr;
        int i = 0;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, getRowDimension(), getColumnDimension());
        int i2 = this.columns - ((this.blockColumns - 1) * 52);
        int i3 = 0;
        while (i3 < this.blockRows) {
            int i4 = i3 * 52;
            int iMin = FastMath.min(i4 + 52, this.rows);
            int i5 = i;
            int i6 = i5;
            while (i4 < iMin) {
                double[] dArr3 = dArr2[i4];
                int i7 = this.blockColumns * i3;
                int i8 = i;
                int i9 = i8;
                while (true) {
                    int i10 = this.blockColumns - 1;
                    dArr = this.blocks;
                    if (i8 < i10) {
                        System.arraycopy(dArr[i7], i5, dArr3, i9, 52);
                        i9 += 52;
                        i8++;
                        i7++;
                    }
                }
                System.arraycopy(dArr[i7], i6, dArr3, i9, i2);
                i5 += 52;
                i6 += i2;
                i4++;
                i = 0;
            }
            i3++;
            i = 0;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i, int i2) {
        MatrixUtils.checkMatrixIndex(this, i, i2);
        int i3 = i / 52;
        int i4 = i2 / 52;
        return this.blocks[(i3 * this.blockColumns) + i4][(i2 - (i4 * 52)) + ((i - (i3 * 52)) * blockWidth(i4))];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    public BlockRealMatrix multiply(BlockRealMatrix blockRealMatrix) {
        double[] dArr;
        BlockRealMatrix blockRealMatrix2 = this;
        BlockRealMatrix blockRealMatrix3 = blockRealMatrix;
        MatrixUtils.checkMultiplicationCompatible(this, blockRealMatrix);
        BlockRealMatrix blockRealMatrix4 = new BlockRealMatrix(blockRealMatrix2.rows, blockRealMatrix3.columns);
        int i = 0;
        int i2 = 0;
        while (i < blockRealMatrix4.blockRows) {
            int i3 = i * 52;
            int iMin = FastMath.min(i3 + 52, blockRealMatrix2.rows);
            int i4 = 0;
            while (i4 < blockRealMatrix4.blockColumns) {
                int iBlockWidth = blockRealMatrix4.blockWidth(i4);
                int i5 = iBlockWidth + iBlockWidth;
                int i6 = i5 + iBlockWidth;
                int i7 = i6 + iBlockWidth;
                double[] dArr2 = blockRealMatrix4.blocks[i2];
                int i8 = 0;
                while (i8 < blockRealMatrix2.blockColumns) {
                    int iBlockWidth2 = blockRealMatrix2.blockWidth(i8);
                    BlockRealMatrix blockRealMatrix5 = blockRealMatrix4;
                    double[] dArr3 = blockRealMatrix2.blocks[(blockRealMatrix2.blockColumns * i) + i8];
                    double[] dArr4 = blockRealMatrix3.blocks[(blockRealMatrix3.blockColumns * i8) + i4];
                    int i9 = i3;
                    int i10 = 0;
                    while (i9 < iMin) {
                        int i11 = (i9 - i3) * iBlockWidth2;
                        double[] dArr5 = dArr4;
                        int i12 = i11 + iBlockWidth2;
                        int i13 = 0;
                        while (i13 < iBlockWidth) {
                            double d = 0.0d;
                            int i14 = i13;
                            int i15 = i14;
                            int i16 = i11;
                            while (true) {
                                dArr = dArr3;
                                if (i16 >= i12 - 3) {
                                    break;
                                }
                                d = (dArr[i16 + 3] * dArr5[i15 + i6]) + (dArr[i16 + 2] * dArr5[i15 + i5]) + (dArr[i16 + 1] * dArr5[i15 + iBlockWidth]) + (dArr[i16] * dArr5[i15]) + d;
                                i16 += 4;
                                i15 += i7;
                                dArr3 = dArr;
                            }
                            while (i16 < i12) {
                                d = (dArr[i16] * dArr5[i15]) + d;
                                i15 += iBlockWidth;
                                i16++;
                            }
                            dArr2[i10] = dArr2[i10] + d;
                            i10++;
                            i13 = i14 + 1;
                            dArr3 = dArr;
                        }
                        i9++;
                        dArr4 = dArr5;
                    }
                    i8++;
                    blockRealMatrix2 = this;
                    blockRealMatrix3 = blockRealMatrix;
                    blockRealMatrix4 = blockRealMatrix5;
                }
                i2++;
                i4++;
                blockRealMatrix2 = this;
                blockRealMatrix3 = blockRealMatrix;
            }
            i++;
            blockRealMatrix2 = this;
            blockRealMatrix3 = blockRealMatrix;
        }
        return blockRealMatrix4;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        int length = dArr.length;
        int i = this.columns;
        if (length != i) {
            throw new DimensionMismatchException(dArr.length, i);
        }
        double[] dArr2 = new double[this.rows];
        for (int i2 = 0; i2 < this.blockRows; i2++) {
            int i3 = i2 * 52;
            int iMin = FastMath.min(i3 + 52, this.rows);
            int i4 = 0;
            while (true) {
                int i5 = this.blockColumns;
                if (i4 < i5) {
                    double[] dArr3 = this.blocks[(i5 * i2) + i4];
                    int i6 = i4 * 52;
                    int iMin2 = FastMath.min(i6 + 52, this.columns);
                    int i7 = 0;
                    for (int i8 = i3; i8 < iMin; i8++) {
                        double d = 0.0d;
                        int i9 = i6;
                        while (i9 < iMin2 - 3) {
                            d = (dArr3[i7 + 3] * dArr[i9 + 3]) + (dArr3[i7 + 2] * dArr[i9 + 2]) + (dArr3[i7 + 1] * dArr[i9 + 1]) + (dArr3[i7] * dArr[i9]) + d;
                            i7 += 4;
                            i9 += 4;
                        }
                        while (i9 < iMin2) {
                            d = (dArr3[i7] * dArr[i9]) + d;
                            i9++;
                            i7++;
                        }
                        dArr2[i8] = dArr2[i8] + d;
                    }
                    i4++;
                }
            }
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
        int i = 0;
        while (true) {
            double[][] dArr = blockRealMatrix.blocks;
            if (i >= dArr.length) {
                return blockRealMatrix;
            }
            double[] dArr2 = dArr[i];
            double[] dArr3 = this.blocks[i];
            for (int i2 = 0; i2 < dArr2.length; i2++) {
                dArr2[i2] = dArr3[i2] * d;
            }
            i++;
        }
    }

    public void setColumn(int i, double[] dArr) {
        MatrixUtils.checkColumnIndex(this, i);
        int rowDimension = getRowDimension();
        if (dArr.length != rowDimension) {
            throw new MatrixDimensionMismatchException(dArr.length, 1, rowDimension, 1);
        }
        int i2 = i / 52;
        int i3 = i - (i2 * 52);
        int iBlockWidth = blockWidth(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < this.blockRows; i5++) {
            int iBlockHeight = blockHeight(i5);
            double[] dArr2 = this.blocks[(this.blockColumns * i5) + i2];
            int i6 = 0;
            while (i6 < iBlockHeight) {
                dArr2[(i6 * iBlockWidth) + i3] = dArr[i4];
                i6++;
                i4++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumnVector(int i, RealVector realVector) {
        try {
            setColumn(i, ((ArrayRealVector) realVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setColumnVector(i, realVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i, int i2, double d) {
        MatrixUtils.checkMatrixIndex(this, i, i2);
        int i3 = i / 52;
        int i4 = i2 / 52;
        this.blocks[(i3 * this.blockColumns) + i4][(i2 - (i4 * 52)) + ((i - (i3 * 52)) * blockWidth(i4))] = d;
    }

    public void setRow(int i, double[] dArr) {
        MatrixUtils.checkRowIndex(this, i);
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new MatrixDimensionMismatchException(1, dArr.length, 1, columnDimension);
        }
        int i2 = i / 52;
        int i3 = i - (i2 * 52);
        int i4 = 0;
        for (int i5 = 0; i5 < this.blockColumns; i5++) {
            int iBlockWidth = blockWidth(i5);
            System.arraycopy(dArr, i4, this.blocks[(this.blockColumns * i2) + i5], i3 * iBlockWidth, iBlockWidth);
            i4 += iBlockWidth;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRowVector(int i, RealVector realVector) {
        try {
            setRow(i, ((ArrayRealVector) realVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setRowVector(i, realVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix transpose() {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(getColumnDimension(), getRowDimension());
        int i = 0;
        for (int i2 = 0; i2 < this.blockColumns; i2++) {
            for (int i3 = 0; i3 < this.blockRows; i3++) {
                double[] dArr = blockRealMatrix.blocks[i];
                double[] dArr2 = this.blocks[(this.blockColumns * i3) + i2];
                int i4 = i2 * 52;
                int iMin = FastMath.min(i4 + 52, this.columns);
                int i5 = i3 * 52;
                int iMin2 = FastMath.min(i5 + 52, this.rows);
                int i6 = 0;
                for (int i7 = i4; i7 < iMin; i7++) {
                    int i8 = iMin - i4;
                    int i9 = i7 - i4;
                    for (int i10 = i5; i10 < iMin2; i10++) {
                        dArr[i6] = dArr2[i9];
                        i6++;
                        i9 += i8;
                    }
                }
                i++;
            }
        }
        return blockRealMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int i = this.rows;
        int i2 = this.columns;
        realMatrixPreservingVisitor.start(i, i2, 0, i - 1, 0, i2 - 1);
        int i3 = 0;
        for (int i4 = 0; i4 < this.blockRows; i4++) {
            int i5 = i4 * 52;
            int iMin = FastMath.min(i5 + 52, this.rows);
            for (int i6 = 0; i6 < this.blockColumns; i6++) {
                int i7 = i6 * 52;
                int iMin2 = FastMath.min(i7 + 52, this.columns);
                double[] dArr = this.blocks[i3];
                int i8 = 0;
                for (int i9 = i5; i9 < iMin; i9++) {
                    for (int i10 = i7; i10 < iMin2; i10++) {
                        realMatrixPreservingVisitor.visit(i9, i10, dArr[i8]);
                        i8++;
                    }
                }
                i3++;
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int i = this.rows;
        int i2 = this.columns;
        realMatrixPreservingVisitor.start(i, i2, 0, i - 1, 0, i2 - 1);
        for (int i3 = 0; i3 < this.blockRows; i3++) {
            int i4 = i3 * 52;
            int iMin = FastMath.min(i4 + 52, this.rows);
            for (int i5 = i4; i5 < iMin; i5++) {
                for (int i6 = 0; i6 < this.blockColumns; i6++) {
                    int iBlockWidth = blockWidth(i6);
                    int i7 = i6 * 52;
                    int iMin2 = FastMath.min(i7 + 52, this.columns);
                    double[] dArr = this.blocks[(this.blockColumns * i3) + i6];
                    int i8 = (i5 - i4) * iBlockWidth;
                    while (i7 < iMin2) {
                        realMatrixPreservingVisitor.visit(i5, i7, dArr[i8]);
                        i8++;
                        i7++;
                    }
                }
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    public BlockRealMatrix(double[][] dArr) {
        this(dArr.length, dArr[0].length, toBlocksLayout(dArr), false);
    }

    public BlockRealMatrix(int i, int i2) {
        super(i, i2);
        this.rows = i;
        this.columns = i2;
        this.blockRows = (i + 51) / 52;
        this.blockColumns = (i2 + 51) / 52;
        this.blocks = createBlocksLayout(i, i2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix multiply(RealMatrix realMatrix) {
        BlockRealMatrix blockRealMatrix = this;
        try {
            return blockRealMatrix.multiply((BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
            BlockRealMatrix blockRealMatrix2 = new BlockRealMatrix(blockRealMatrix.rows, realMatrix.getColumnDimension());
            int i = 0;
            int i2 = 0;
            while (i < blockRealMatrix2.blockRows) {
                int i3 = i * 52;
                int iMin = FastMath.min(i3 + 52, blockRealMatrix.rows);
                int i4 = 0;
                while (i4 < blockRealMatrix2.blockColumns) {
                    int i5 = i4 * 52;
                    int iMin2 = FastMath.min(i5 + 52, realMatrix.getColumnDimension());
                    double[] dArr = blockRealMatrix2.blocks[i2];
                    int i6 = 0;
                    while (i6 < blockRealMatrix.blockColumns) {
                        int iBlockWidth = blockRealMatrix.blockWidth(i6);
                        double[] dArr2 = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i) + i6];
                        int i7 = i6 * 52;
                        int i8 = i3;
                        int i9 = 0;
                        while (i8 < iMin) {
                            int i10 = (i8 - i3) * iBlockWidth;
                            int i11 = i10 + iBlockWidth;
                            BlockRealMatrix blockRealMatrix3 = blockRealMatrix2;
                            int i12 = i5;
                            while (i12 < iMin2) {
                                double entry = 0.0d;
                                int i13 = i8;
                                int i14 = i;
                                int i15 = i7;
                                for (int i16 = i10; i16 < i11; i16++) {
                                    entry = (realMatrix.getEntry(i15, i12) * dArr2[i16]) + entry;
                                    i15++;
                                }
                                dArr[i9] = dArr[i9] + entry;
                                i9++;
                                i12++;
                                i8 = i13;
                                i = i14;
                            }
                            i8++;
                            blockRealMatrix2 = blockRealMatrix3;
                        }
                        i6++;
                        blockRealMatrix = this;
                    }
                    i2++;
                    i4++;
                    blockRealMatrix = this;
                }
                i++;
                blockRealMatrix = this;
            }
            return blockRealMatrix2;
        }
    }
}
