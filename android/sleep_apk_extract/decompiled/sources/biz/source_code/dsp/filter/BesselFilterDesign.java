package biz.source_code.dsp.filter;

import biz.source_code.dsp.math.Complex;
import biz.source_code.dsp.math.PolynomialRootFinderJenkinsTraub;
import biz.source_code.dsp.math.PolynomialUtils;
import biz.source_code.dsp.util.ArrayUtils;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class BesselFilterDesign {
    public static double computeGain(double[] dArr, double d) {
        return transferFunction(dArr, new Complex(0.0d, d)).abs();
    }

    public static Complex[] computePoles(int i) {
        double[] dArrReverse = ArrayUtils.reverse(computePolynomialCoefficients(i));
        return ArrayUtils.divide(PolynomialRootFinderJenkinsTraub.findRoots(dArrReverse), findFrequencyScalingFactor(dArrReverse));
    }

    public static double[] computePolynomialCoefficients(int i) {
        double d = 1.0d;
        for (int i2 = 1; i2 <= i; i2++) {
            d = (d * ((double) (i + i2))) / 2.0d;
        }
        double[] dArr = new double[i + 1];
        dArr[0] = d;
        dArr[i] = 1.0d;
        for (int i3 = 1; i3 < i; i3++) {
            dArr[i3] = (((dArr[i3 - 1] * 2.0d) * ((double) ((i - i3) + 1))) / ((double) (((i * 2) - i3) + 1))) / ((double) i3);
        }
        return dArr;
    }

    public static double findFrequencyForGain(double[] dArr, double d) {
        if (d > 0.999999d || d < 1.0E-6d) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return 0.0d;
        }
        double d2 = 1.0d;
        int i = 0;
        double d3 = 1.0d;
        int i2 = 0;
        while (computeGain(dArr, d3) < d) {
            d3 /= 2.0d;
            int i3 = i2 + 1;
            if (i2 > 100) {
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0.0d;
            }
            i2 = i3;
        }
        int i4 = 0;
        while (computeGain(dArr, d2) > d) {
            d2 *= 2.0d;
            int i5 = i4 + 1;
            if (i4 > 100) {
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0.0d;
            }
            i4 = i5;
        }
        while (d2 - d3 >= 1.0E-15d) {
            double d4 = (d2 + d3) / 2.0d;
            if (computeGain(dArr, d4) > d) {
                d3 = d4;
            } else {
                d2 = d4;
            }
            int i6 = i + 1;
            if (i > 1000) {
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "No convergence.");
                return 0.0d;
            }
            i = i6;
        }
        return d3;
    }

    public static double findFrequencyScalingFactor(double[] dArr) {
        return findFrequencyForGain(dArr, 1.0d / Math.sqrt(2.0d));
    }

    public static Complex transferFunction(double[] dArr, Complex complex) {
        PolynomialUtils.RationalFraction rationalFraction = new PolynomialUtils.RationalFraction();
        rationalFraction.top = new double[]{dArr[dArr.length - 1]};
        rationalFraction.bottom = dArr;
        return PolynomialUtils.evaluate(rationalFraction, complex);
    }
}
