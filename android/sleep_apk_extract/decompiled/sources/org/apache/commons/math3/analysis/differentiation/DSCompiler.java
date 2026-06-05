package org.apache.commons.math3.analysis.differentiation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes5.dex */
public class DSCompiler {
    private static AtomicReference<DSCompiler[][]> compilers = new AtomicReference<>(null);
    private final int[][][] compIndirection;
    private final int[][] derivativesIndirection;
    private final int[] lowerIndirection;
    private final int[][][] multIndirection;
    private final int order;
    private final int parameters;
    private final int[][] sizes;

    private DSCompiler(int i, int i2, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        this.parameters = i;
        this.order = i2;
        int[][] iArrCompileSizes = compileSizes(i, i2, dSCompiler);
        this.sizes = iArrCompileSizes;
        int[][] iArrCompileDerivativesIndirection = compileDerivativesIndirection(i, i2, dSCompiler, dSCompiler2);
        this.derivativesIndirection = iArrCompileDerivativesIndirection;
        int[] iArrCompileLowerIndirection = compileLowerIndirection(i, i2, dSCompiler, dSCompiler2);
        this.lowerIndirection = iArrCompileLowerIndirection;
        this.multIndirection = compileMultiplicationIndirection(i, i2, dSCompiler, dSCompiler2, iArrCompileLowerIndirection);
        this.compIndirection = compileCompositionIndirection(i, i2, dSCompiler, dSCompiler2, iArrCompileSizes, iArrCompileDerivativesIndirection);
    }

    private static int[][][] compileCompositionIndirection(int i, int i2, DSCompiler dSCompiler, DSCompiler dSCompiler2, int[][] iArr, int[][] iArr2) {
        int i3 = i;
        int i4 = i2;
        DSCompiler dSCompiler3 = dSCompiler2;
        int[][] iArr3 = iArr;
        int i5 = 0;
        int i6 = 1;
        if (i3 == 0 || i4 == 0) {
            return new int[][][]{new int[][]{new int[]{1, 0}}};
        }
        int[][][] iArr4 = dSCompiler.compIndirection;
        int length = iArr4.length;
        int length2 = dSCompiler3.compIndirection.length;
        int[][][] iArr5 = new int[length + length2][][];
        System.arraycopy(iArr4, 0, iArr5, 0, length);
        int i7 = 0;
        while (i7 < length2) {
            ArrayList arrayList = new ArrayList();
            int[][] iArr6 = dSCompiler3.compIndirection[i7];
            int length3 = iArr6.length;
            int i8 = i5;
            while (i8 < length3) {
                int[] iArr7 = iArr6[i8];
                int length4 = iArr7.length + i6;
                int i9 = i6;
                int[] iArr8 = new int[length4];
                iArr8[i5] = iArr7[i5];
                iArr8[i9] = iArr7[i9] + 1;
                int i10 = i5;
                int[] iArr9 = new int[i3];
                int i11 = i3 - 1;
                iArr9[i11] = i9;
                int i12 = i8;
                iArr8[iArr7.length] = getPartialDerivativeIndex(i3, i4, iArr3, iArr9);
                int i13 = length;
                int i14 = 2;
                while (i14 < iArr7.length) {
                    int i15 = i14;
                    iArr8[i15] = convertIndex(iArr7[i14], i3, dSCompiler3.derivativesIndirection, i, i4, iArr3);
                    i3 = i;
                    i4 = i2;
                    iArr3 = iArr;
                    i14 = i15 + 1;
                    length4 = length4;
                    length2 = length2;
                    iArr7 = iArr7;
                }
                int i16 = length2;
                int i17 = 2;
                Arrays.sort(iArr8, 2, length4);
                arrayList.add(iArr8);
                int i18 = 2;
                int[] iArr10 = iArr7;
                while (i18 < iArr10.length) {
                    int length5 = iArr10.length;
                    int[] iArr11 = new int[length5];
                    iArr11[i10] = iArr10[i10];
                    iArr11[i9] = iArr10[i9];
                    int i19 = i17;
                    while (i19 < iArr10.length) {
                        int i20 = length5;
                        int i21 = i19;
                        int[] iArr12 = iArr11;
                        int[] iArr13 = iArr10;
                        int iConvertIndex = convertIndex(iArr10[i19], i, dSCompiler3.derivativesIndirection, i, i2, iArr);
                        iArr12[i21] = iConvertIndex;
                        if (i21 == i18) {
                            int i22 = i10;
                            System.arraycopy(iArr2[iConvertIndex], i22, iArr9, i22, i);
                            iArr9[i11] = iArr9[i11] + 1;
                            iArr12[i21] = getPartialDerivativeIndex(i, i2, iArr, iArr9);
                        }
                        i19 = i21 + 1;
                        length5 = i20;
                        iArr11 = iArr12;
                        iArr10 = iArr13;
                        i17 = 2;
                        i10 = 0;
                        dSCompiler3 = dSCompiler2;
                    }
                    int i23 = length5;
                    int i24 = i17;
                    int[] iArr14 = iArr11;
                    Arrays.sort(iArr14, i24, i23);
                    arrayList.add(iArr14);
                    i18++;
                    dSCompiler3 = dSCompiler2;
                    i17 = i24;
                    i10 = 0;
                }
                i3 = i;
                i4 = i2;
                iArr3 = iArr;
                i8 = i12 + 1;
                dSCompiler3 = dSCompiler2;
                i6 = i9;
                length = i13;
                length2 = i16;
                i5 = 0;
            }
            int i25 = i6;
            int i26 = length;
            int i27 = length2;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (int i28 = 0; i28 < arrayList.size(); i28++) {
                int[] iArr15 = (int[]) arrayList.get(i28);
                if (iArr15[0] > 0) {
                    for (int i29 = i28 + 1; i29 < arrayList.size(); i29++) {
                        int[] iArr16 = (int[]) arrayList.get(i29);
                        int i30 = iArr15.length == iArr16.length ? i25 : 0;
                        for (int i31 = i25; i30 != 0 && i31 < iArr15.length; i31++) {
                            i30 &= iArr15[i31] == iArr16[i31] ? i25 : 0;
                        }
                        if (i30 != 0) {
                            iArr15[0] = iArr15[0] + iArr16[0];
                            iArr16[0] = 0;
                        }
                    }
                    arrayList2.add(iArr15);
                }
            }
            iArr5[i26 + i7] = (int[][]) arrayList2.toArray(new int[arrayList2.size()][]);
            i7++;
            dSCompiler3 = dSCompiler2;
            i6 = i25;
            length = i26;
            length2 = i27;
            i5 = 0;
        }
        return iArr5;
    }

    private static int[][] compileDerivativesIndirection(int i, int i2, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        Class cls = Integer.TYPE;
        if (i == 0 || i2 == 0) {
            return (int[][]) Array.newInstance((Class<?>) cls, 1, i);
        }
        int length = dSCompiler.derivativesIndirection.length;
        int length2 = dSCompiler2.derivativesIndirection.length;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, length + length2, i);
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(dSCompiler.derivativesIndirection[i3], 0, iArr[i3], 0, i - 1);
        }
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = length + i4;
            System.arraycopy(dSCompiler2.derivativesIndirection[i4], 0, iArr[i5], 0, i);
            int[] iArr2 = iArr[i5];
            int i6 = i - 1;
            iArr2[i6] = iArr2[i6] + 1;
        }
        return iArr;
    }

    private static int[] compileLowerIndirection(int i, int i2, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        if (i == 0 || i2 <= 1) {
            return new int[]{0};
        }
        int[] iArr = dSCompiler.lowerIndirection;
        int length = iArr.length;
        int length2 = dSCompiler2.lowerIndirection.length;
        int[] iArr2 = new int[length + length2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        for (int i3 = 0; i3 < length2; i3++) {
            iArr2[length + i3] = dSCompiler.getSize() + dSCompiler2.lowerIndirection[i3];
        }
        return iArr2;
    }

    private static int[][][] compileMultiplicationIndirection(int i, int i2, DSCompiler dSCompiler, DSCompiler dSCompiler2, int[] iArr) {
        if (i == 0 || i2 == 0) {
            return new int[][][]{new int[][]{new int[]{1, 0, 0}}};
        }
        int[][][] iArr2 = dSCompiler.multIndirection;
        int length = iArr2.length;
        int length2 = dSCompiler2.multIndirection.length;
        int[][][] iArr3 = new int[length + length2][][];
        System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i3 = 0; i3 < length2; i3++) {
            int[][] iArr4 = dSCompiler2.multIndirection[i3];
            ArrayList arrayList = new ArrayList(iArr4.length * 2);
            for (int i4 = 0; i4 < iArr4.length; i4++) {
                int[] iArr5 = iArr4[i4];
                arrayList.add(new int[]{iArr5[0], iArr[iArr5[1]], iArr5[2] + length});
                int[] iArr6 = iArr4[i4];
                arrayList.add(new int[]{iArr6[0], iArr6[1] + length, iArr[iArr6[2]]});
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                int[] iArr7 = (int[]) arrayList.get(i5);
                if (iArr7[0] > 0) {
                    for (int i6 = i5 + 1; i6 < arrayList.size(); i6++) {
                        int[] iArr8 = (int[]) arrayList.get(i6);
                        if (iArr7[1] == iArr8[1] && iArr7[2] == iArr8[2]) {
                            iArr7[0] = iArr7[0] + iArr8[0];
                            iArr8[0] = 0;
                        }
                    }
                    arrayList2.add(iArr7);
                }
            }
            iArr3[length + i3] = (int[][]) arrayList2.toArray(new int[arrayList2.size()][]);
        }
        return iArr3;
    }

    private static int[][] compileSizes(int i, int i2, DSCompiler dSCompiler) {
        int i3 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i + 1, i2 + 1);
        if (i == 0) {
            Arrays.fill(iArr[0], 1);
            return iArr;
        }
        System.arraycopy(dSCompiler.sizes, 0, iArr, 0, i);
        iArr[i][0] = 1;
        while (i3 < i2) {
            int[] iArr2 = iArr[i];
            int i4 = i3 + 1;
            iArr2[i4] = iArr2[i3] + iArr[i - 1][i4];
            i3 = i4;
        }
        return iArr;
    }

    private static int convertIndex(int i, int i2, int[][] iArr, int i3, int i4, int[][] iArr2) {
        int[] iArr3 = new int[i3];
        System.arraycopy(iArr[i], 0, iArr3, 0, FastMath.min(i2, i3));
        return getPartialDerivativeIndex(i3, i4, iArr2, iArr3);
    }

    public static DSCompiler getCompiler(int i, int i2) {
        DSCompiler dSCompiler;
        DSCompiler[][] dSCompilerArr = compilers.get();
        if (dSCompilerArr != null && dSCompilerArr.length > i) {
            DSCompiler[] dSCompilerArr2 = dSCompilerArr[i];
            if (dSCompilerArr2.length > i2 && (dSCompiler = dSCompilerArr2[i2]) != null) {
                return dSCompiler;
            }
        }
        DSCompiler[][] dSCompilerArr3 = (DSCompiler[][]) Array.newInstance((Class<?>) DSCompiler.class, FastMath.max(i, dSCompilerArr == null ? 0 : dSCompilerArr.length) + 1, FastMath.max(i2, dSCompilerArr == null ? 0 : dSCompilerArr[0].length) + 1);
        if (dSCompilerArr != null) {
            for (int i3 = 0; i3 < dSCompilerArr.length; i3++) {
                DSCompiler[] dSCompilerArr4 = dSCompilerArr[i3];
                System.arraycopy(dSCompilerArr4, 0, dSCompilerArr3[i3], 0, dSCompilerArr4.length);
            }
        }
        for (int i4 = 0; i4 <= i + i2; i4++) {
            int iMax = FastMath.max(0, i4 - i);
            while (iMax <= FastMath.min(i2, i4)) {
                int i5 = i4 - iMax;
                DSCompiler[] dSCompilerArr5 = dSCompilerArr3[i5];
                if (dSCompilerArr5[iMax] == null) {
                    dSCompilerArr5[iMax] = new DSCompiler(i5, iMax, i5 == 0 ? null : dSCompilerArr3[i5 - 1][iMax], iMax != 0 ? dSCompilerArr5[iMax - 1] : null);
                }
                iMax++;
            }
        }
        AtomicReference<DSCompiler[][]> atomicReference = compilers;
        while (!atomicReference.compareAndSet(dSCompilerArr, dSCompilerArr3) && atomicReference.get() == dSCompilerArr) {
        }
        return dSCompilerArr3[i][i2];
    }

    private static int getPartialDerivativeIndex(int i, int i2, int[][] iArr, int... iArr2) {
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        for (int i6 = i - 1; i6 >= 0; i6--) {
            int i7 = iArr2[i6];
            i5 += i7;
            if (i5 > i2) {
                throw new NumberIsTooLargeException(Integer.valueOf(i5), Integer.valueOf(i2), true);
            }
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    i3 += iArr[i6][i4];
                    i7 = i8;
                    i4--;
                }
            }
        }
        return i3;
    }

    public int getFreeParameters() {
        return this.parameters;
    }

    public int getOrder() {
        return this.order;
    }

    public int getSize() {
        return this.sizes[this.parameters][this.order];
    }

    public int getPartialDerivativeIndex(int... iArr) {
        if (iArr.length == getFreeParameters()) {
            return getPartialDerivativeIndex(this.parameters, this.order, this.sizes, iArr);
        }
        throw new DimensionMismatchException(iArr.length, getFreeParameters());
    }
}
