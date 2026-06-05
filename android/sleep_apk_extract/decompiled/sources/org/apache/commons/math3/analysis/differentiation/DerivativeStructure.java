package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DerivativeStructure implements Serializable {
    private static final long serialVersionUID = 20120730;
    private transient DSCompiler compiler;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private final double[] f117data;

    public static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120730;

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        private final double[] f118data;
        private final int order;
        private final int variables;

        public DataTransferObject(int i, int i2, double[] dArr) {
            this.variables = i;
            this.order = i2;
            this.f118data = dArr;
        }

        private Object readResolve() {
            return new DerivativeStructure(this.variables, this.order, this.f118data);
        }
    }

    public DerivativeStructure(int i, int i2, int i3, double d) {
        this(i, i2, d);
        if (i3 >= i) {
            throw new NumberIsTooLargeException(Integer.valueOf(i3), Integer.valueOf(i), false);
        }
        if (i2 > 0) {
            this.f117data[DSCompiler.getCompiler(i3, i2).getSize()] = 1.0d;
        }
    }

    private Object writeReplace() {
        return new DataTransferObject(this.compiler.getFreeParameters(), this.compiler.getOrder(), this.f117data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DerivativeStructure) {
            DerivativeStructure derivativeStructure = (DerivativeStructure) obj;
            if (getFreeParameters() == derivativeStructure.getFreeParameters() && getOrder() == derivativeStructure.getOrder() && MathArrays.equals(this.f117data, derivativeStructure.f117data)) {
                return true;
            }
        }
        return false;
    }

    public int getFreeParameters() {
        return this.compiler.getFreeParameters();
    }

    public int getOrder() {
        return this.compiler.getOrder();
    }

    public double getPartialDerivative(int... iArr) {
        return this.f117data[this.compiler.getPartialDerivativeIndex(iArr)];
    }

    public double getValue() {
        return this.f117data[0];
    }

    public int hashCode() {
        return (MathUtils.hash(this.f117data) * 239) + (getOrder() * 233) + (getFreeParameters() * 229) + 227;
    }

    public DerivativeStructure(int i, int i2) {
        this(DSCompiler.getCompiler(i, i2));
    }

    public DerivativeStructure(int i, int i2, double d) {
        this(i, i2);
        this.f117data[0] = d;
    }

    private DerivativeStructure(DSCompiler dSCompiler) {
        this.compiler = dSCompiler;
        this.f117data = new double[dSCompiler.getSize()];
    }

    public DerivativeStructure(int i, int i2, double... dArr) {
        this(i, i2);
        int length = dArr.length;
        double[] dArr2 = this.f117data;
        if (length == dArr2.length) {
            System.arraycopy(dArr, 0, dArr2, 0, dArr2.length);
            return;
        }
        throw new DimensionMismatchException(dArr.length, this.f117data.length);
    }
}
