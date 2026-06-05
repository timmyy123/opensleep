package org.apache.commons.math3.complex;

import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Complex implements Serializable {
    private static final long serialVersionUID = -6195664516687396620L;
    private final double imaginary;
    private final transient boolean isInfinite;
    private final transient boolean isNaN;
    private final double real;
    public static final Complex I = new Complex(0.0d, 1.0d);
    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);
    public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Complex ONE = new Complex(1.0d, 0.0d);
    public static final Complex ZERO = new Complex(0.0d, 0.0d);

    public Complex(double d, double d2) {
        this.real = d;
        this.imaginary = d2;
        boolean z = true;
        boolean z2 = Double.isNaN(d) || Double.isNaN(d2);
        this.isNaN = z2;
        if (z2 || (!Double.isInfinite(d) && !Double.isInfinite(d2))) {
            z = false;
        }
        this.isInfinite = z;
    }

    public Complex createComplex(double d, double d2) {
        return new Complex(d, d2);
    }

    public Complex divide(Complex complex) {
        MathUtils.checkNotNull(complex);
        if (this.isNaN || complex.isNaN) {
            return NaN;
        }
        double real = complex.getReal();
        double imaginary = complex.getImaginary();
        if (real == 0.0d && imaginary == 0.0d) {
            return NaN;
        }
        if (complex.isInfinite() && !isInfinite()) {
            return ZERO;
        }
        if (FastMath.abs(real) < FastMath.abs(imaginary)) {
            double d = real / imaginary;
            double d2 = (real * d) + imaginary;
            double d3 = this.real;
            double d4 = this.imaginary;
            return createComplex(((d3 * d) + d4) / d2, ((d4 * d) - d3) / d2);
        }
        double d5 = imaginary / real;
        double d6 = (imaginary * d5) + real;
        double d7 = this.imaginary;
        double d8 = this.real;
        return createComplex(((d7 * d5) + d8) / d6, (d7 - (d8 * d5)) / d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Complex) {
            Complex complex = (Complex) obj;
            if (complex.isNaN) {
                return this.isNaN;
            }
            if (MathUtils.equals(this.real, complex.real) && MathUtils.equals(this.imaginary, complex.imaginary)) {
                return true;
            }
        }
        return false;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public int hashCode() {
        if (this.isNaN) {
            return 7;
        }
        return (MathUtils.hash(this.real) + (MathUtils.hash(this.imaginary) * 17)) * 37;
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }

    public final Object readResolve() {
        return createComplex(this.real, this.imaginary);
    }

    public String toString() {
        return "(" + this.real + ", " + this.imaginary + ")";
    }
}
