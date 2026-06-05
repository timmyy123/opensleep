package biz.source_code.dsp.util;

import biz.source_code.dsp.math.Complex;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArrayUtils {
    public static Complex[] divide(Complex[] complexArr, double d) {
        Complex[] complexArr2 = new Complex[complexArr.length];
        for (int i = 0; i < complexArr.length; i++) {
            complexArr2[i] = complexArr[i].div(d);
        }
        return complexArr2;
    }

    public static Complex[] multiply(Complex[] complexArr, double d) {
        Complex[] complexArr2 = new Complex[complexArr.length];
        for (int i = 0; i < complexArr.length; i++) {
            complexArr2[i] = complexArr[i].mul(d);
        }
        return complexArr2;
    }

    public static double[] reverse(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[(dArr.length - 1) - i];
        }
        return dArr2;
    }

    public static double[] toDouble(Complex[] complexArr, double d) {
        double[] dArr = new double[complexArr.length];
        for (int i = 0; i < complexArr.length; i++) {
            dArr[i] = complexArr[i].toDouble(d);
        }
        return dArr;
    }

    public static Complex[] zeros(int i) {
        Complex[] complexArr = new Complex[i];
        for (int i2 = 0; i2 < i; i2++) {
            complexArr[i2] = Complex.ZERO;
        }
        return complexArr;
    }

    public static double[] divide(double[] dArr, double d) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i] / d;
        }
        return dArr2;
    }
}
