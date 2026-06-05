package biz.source_code.dsp.math;

/* JADX INFO: loaded from: classes.dex */
public final class Complex {
    private final double im;
    private final double re;
    public static final Complex I = new Complex(0.0d, 1.0d);
    public static final Complex ZERO = new Complex(0.0d);
    public static final Complex ONE = new Complex(1.0d);
    public static final Complex TWO = new Complex(2.0d);
    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);
    public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

    public Complex(double d, double d2) {
        this.re = d;
        this.im = d2;
    }

    public static Complex expj(double d) {
        return new Complex(Math.cos(d), Math.sin(d));
    }

    public static Complex fromPolar(double d, double d2) {
        return new Complex(Math.cos(d2) * d, Math.sin(d2) * d);
    }

    public static Complex sub(double d, Complex complex) {
        return new Complex(d - complex.re, -complex.im);
    }

    public double abs() {
        return Math.hypot(this.re, this.im);
    }

    public Complex add(Complex complex) {
        return new Complex(this.re + complex.re, this.im + complex.im);
    }

    public Complex conj() {
        return new Complex(this.re, -this.im);
    }

    public Complex div(Complex complex) {
        double d = complex.re;
        double d2 = complex.im;
        double d3 = (d2 * d2) + (d * d);
        double d4 = this.re;
        double d5 = this.im;
        return new Complex(((d5 * d2) + (d4 * d)) / d3, ((d5 * d) - (d4 * d2)) / d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) obj;
        return this.re == complex.re && this.im == complex.im;
    }

    public Complex exp() {
        return fromPolar(Math.exp(this.re), this.im);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.re);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.im);
        return (int) (((jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)) ^ jDoubleToLongBits2) ^ (jDoubleToLongBits2 >>> 32));
    }

    public double im() {
        return this.im;
    }

    public Complex mul(Complex complex) {
        double d = this.re;
        double d2 = complex.re;
        double d3 = this.im;
        double d4 = complex.im;
        return new Complex((d * d2) - (d3 * d4), (d3 * d2) + (d * d4));
    }

    public Complex neg() {
        return new Complex(-this.re, -this.im);
    }

    public double re() {
        return this.re;
    }

    public Complex sqr() {
        double d = this.re;
        double d2 = this.im;
        return new Complex((d * d) - (d2 * d2), d * 2.0d * d2);
    }

    public Complex sqrt() {
        if (this.re == 0.0d && this.im == 0.0d) {
            return new Complex(0.0d, 0.0d);
        }
        double dAbs = abs();
        return new Complex(Math.sqrt((this.re + dAbs) / 2.0d), Math.sqrt((dAbs - this.re) / 2.0d) * Math.copySign(1.0d, this.im));
    }

    public double toDouble(double d) {
        double dAbs = Math.abs(this.im);
        if (dAbs <= d || dAbs <= Math.abs(this.re) * d) {
            return this.re;
        }
        throw new RuntimeException("The imaginary part of the complex number is not neglectable small for the conversion to a real number. re=" + this.re + " im=" + this.im + " eps=" + d + ".");
    }

    public String toString() {
        return "(" + this.re + ", " + this.im + ")";
    }

    public Complex(double d) {
        this(d, 0.0d);
    }

    public Complex add(double d) {
        return new Complex(this.re + d, this.im);
    }

    public Complex mul(double d) {
        return new Complex(this.re * d, this.im * d);
    }

    public Complex div(double d) {
        return new Complex(this.re / d, this.im / d);
    }

    public static Complex div(double d, Complex complex) {
        double d2 = complex.re;
        double d3 = complex.im;
        double d4 = (d3 * d3) + (d2 * d2);
        return new Complex((d2 * d) / d4, ((-d) * d3) / d4);
    }
}
