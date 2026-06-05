package biz.source_code.dsp.math;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class PolynomialUtils {

    public static class RationalFraction {
        public double[] bottom;
        public double[] top;
    }

    public static Complex evaluate(double[] dArr, Complex complex) {
        if (dArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return null;
        }
        Complex complex2 = new Complex(dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            complex2 = complex2.mul(complex).add(dArr[i]);
        }
        return complex2;
    }

    public static Complex[] expand(Complex[] complexArr) {
        int length = complexArr.length;
        if (length == 0) {
            return new Complex[]{Complex.ONE};
        }
        Complex[] complexArrMultiply = {Complex.ONE, complexArr[0].neg()};
        for (int i = 1; i < length; i++) {
            complexArrMultiply = multiply(complexArrMultiply, new Complex[]{Complex.ONE, complexArr[i].neg()});
        }
        return complexArrMultiply;
    }

    public static Complex[] multiply(Complex[] complexArr, Complex[] complexArr2) {
        int length = complexArr.length - 1;
        int length2 = complexArr2.length - 1;
        int i = length + length2;
        Complex[] complexArr3 = new Complex[i + 1];
        for (int i2 = 0; i2 <= i; i2++) {
            Complex complexAdd = Complex.ZERO;
            int iMin = Math.min(length, i2);
            for (int iMax = Math.max(0, i2 - length2); iMax <= iMin; iMax++) {
                complexAdd = complexAdd.add(complexArr[length - iMax].mul(complexArr2[(length2 - i2) + iMax]));
            }
            complexArr3[i - i2] = complexAdd;
        }
        return complexArr3;
    }

    public static Complex evaluate(RationalFraction rationalFraction, Complex complex) {
        return evaluate(rationalFraction.top, complex).div(evaluate(rationalFraction.bottom, complex));
    }
}
