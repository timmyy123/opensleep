package org.apache.commons.math3.analysis;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FunctionUtils {
    @Deprecated
    public static DifferentiableMultivariateVectorFunction toDifferentiableMultivariateVectorFunction(final MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction) {
        return new DifferentiableMultivariateVectorFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.18
            @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction
            public MultivariateMatrixFunction jacobian() {
                return new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.18.1
                    @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                    public double[][] value(double[] dArr) {
                        int length = dArr.length;
                        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
                        for (int i = 0; i < length; i++) {
                            derivativeStructureArr[i] = new DerivativeStructure(length, 1, i, dArr[i]);
                        }
                        DerivativeStructure[] derivativeStructureArrValue = multivariateDifferentiableVectorFunction.value(derivativeStructureArr);
                        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, derivativeStructureArrValue.length, length);
                        int[] iArr = new int[length];
                        for (int i2 = 0; i2 < derivativeStructureArrValue.length; i2++) {
                            for (int i3 = 0; i3 < length; i3++) {
                                iArr[i3] = 1;
                                dArr2[i2][i3] = derivativeStructureArrValue[i2].getPartialDerivative(iArr);
                                iArr[i3] = 0;
                            }
                        }
                        return dArr2;
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
            public double[] value(double[] dArr) {
                return multivariateDifferentiableVectorFunction.value(dArr);
            }
        };
    }

    @Deprecated
    public static MultivariateDifferentiableVectorFunction toMultivariateDifferentiableVectorFunction(final DifferentiableMultivariateVectorFunction differentiableMultivariateVectorFunction) {
        return new MultivariateDifferentiableVectorFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.19
            @Override // org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction
            public DerivativeStructure[] value(DerivativeStructure[] derivativeStructureArr) {
                int i = 0;
                int freeParameters = derivativeStructureArr[0].getFreeParameters();
                int order = derivativeStructureArr[0].getOrder();
                int length = derivativeStructureArr.length;
                if (order > 1) {
                    throw new NumberIsTooLargeException(Integer.valueOf(order), 1, true);
                }
                for (int i2 = 0; i2 < length; i2++) {
                    if (derivativeStructureArr[i2].getFreeParameters() != freeParameters) {
                        throw new DimensionMismatchException(derivativeStructureArr[i2].getFreeParameters(), freeParameters);
                    }
                    if (derivativeStructureArr[i2].getOrder() != order) {
                        throw new DimensionMismatchException(derivativeStructureArr[i2].getOrder(), order);
                    }
                }
                double[] dArr = new double[length];
                for (int i3 = 0; i3 < length; i3++) {
                    dArr[i3] = derivativeStructureArr[i3].getValue();
                }
                double[] dArrValue = differentiableMultivariateVectorFunction.value(dArr);
                double[][] dArrValue2 = differentiableMultivariateVectorFunction.jacobian().value(dArr);
                int length2 = dArrValue.length;
                DerivativeStructure[] derivativeStructureArr2 = new DerivativeStructure[length2];
                int i4 = 0;
                while (i4 < length2) {
                    double[] dArr2 = new double[freeParameters + 1];
                    dArr2[i] = dArrValue[i4];
                    int[] iArr = new int[freeParameters];
                    for (int i5 = i; i5 < freeParameters; i5++) {
                        iArr[i5] = 1;
                        int i6 = i;
                        while (i6 < length) {
                            int i7 = i5 + 1;
                            dArr2[i7] = (derivativeStructureArr[i6].getPartialDerivative(iArr) * dArrValue2[i4][i6]) + dArr2[i7];
                            i6++;
                            i = i;
                        }
                        iArr[i5] = i;
                    }
                    derivativeStructureArr2[i4] = new DerivativeStructure(freeParameters, order, dArr2);
                    i4++;
                    i = i;
                }
                return derivativeStructureArr2;
            }

            @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
            public double[] value(double[] dArr) {
                return differentiableMultivariateVectorFunction.value(dArr);
            }
        };
    }
}
