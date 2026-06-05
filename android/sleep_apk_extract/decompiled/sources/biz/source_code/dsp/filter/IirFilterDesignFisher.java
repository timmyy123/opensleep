package biz.source_code.dsp.filter;

import biz.source_code.dsp.math.Complex;
import biz.source_code.dsp.math.PolynomialUtils;
import biz.source_code.dsp.util.ArrayUtils;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class IirFilterDesignFisher {

    /* JADX INFO: renamed from: biz.source_code.dsp.filter.IirFilterDesignFisher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$biz$source_code$dsp$filter$FilterCharacteristicsType;
        static final /* synthetic */ int[] $SwitchMap$biz$source_code$dsp$filter$FilterPassType;

        static {
            int[] iArr = new int[FilterPassType.values().length];
            $SwitchMap$biz$source_code$dsp$filter$FilterPassType = iArr;
            try {
                iArr[FilterPassType.lowpass.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$biz$source_code$dsp$filter$FilterPassType[FilterPassType.highpass.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$biz$source_code$dsp$filter$FilterPassType[FilterPassType.bandpass.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$biz$source_code$dsp$filter$FilterPassType[FilterPassType.bandstop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[FilterCharacteristicsType.values().length];
            $SwitchMap$biz$source_code$dsp$filter$FilterCharacteristicsType = iArr2;
            try {
                iArr2[FilterCharacteristicsType.bessel.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$biz$source_code$dsp$filter$FilterCharacteristicsType[FilterCharacteristicsType.butterworth.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$biz$source_code$dsp$filter$FilterCharacteristicsType[FilterCharacteristicsType.chebyshev.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class PolesAndZeros {
        public Complex[] poles;
        public Complex[] zeros;

        public /* synthetic */ PolesAndZeros(int i) {
            this();
        }

        private PolesAndZeros() {
        }
    }

    public enum SToZMappingMethod {
        bilinearTransform,
        matchedZTransform
    }

    private static PolesAndZeros MapSPlaneToZPlane(PolesAndZeros polesAndZeros, SToZMappingMethod sToZMappingMethod) {
        int iOrdinal = sToZMappingMethod.ordinal();
        int i = 0;
        if (iOrdinal == 0) {
            PolesAndZeros polesAndZeros2 = new PolesAndZeros(i);
            polesAndZeros2.poles = doBilinearTransform(polesAndZeros.poles);
            polesAndZeros2.zeros = extend(doBilinearTransform(polesAndZeros.zeros), polesAndZeros.poles.length, new Complex(-1.0d));
            return polesAndZeros2;
        }
        if (iOrdinal == 1) {
            PolesAndZeros polesAndZeros3 = new PolesAndZeros(i);
            polesAndZeros3.poles = doMatchedZTransform(polesAndZeros.poles);
            polesAndZeros3.zeros = doMatchedZTransform(polesAndZeros.zeros);
            return polesAndZeros3;
        }
        throw new UnsupportedOperationException("Mapping method " + sToZMappingMethod + " not yet implemented.");
    }

    private static double asinh(double d) {
        return Math.log(Math.sqrt((d * d) + 1.0d) + d);
    }

    private static double computeGain(PolynomialUtils.RationalFraction rationalFraction, FilterPassType filterPassType, double d, double d2) {
        int i = AnonymousClass1.$SwitchMap$biz$source_code$dsp$filter$FilterPassType[filterPassType.ordinal()];
        if (i == 1) {
            return computeGainAt(rationalFraction, Complex.ONE);
        }
        if (i == 2) {
            return computeGainAt(rationalFraction, new Complex(-1.0d));
        }
        if (i == 3) {
            return computeGainAt(rationalFraction, Complex.expj(((d + d2) / 2.0d) * 6.283185307179586d));
        }
        if (i == 4) {
            return Math.sqrt(computeGainAt(rationalFraction, Complex.ONE) * computeGainAt(rationalFraction, new Complex(-1.0d)));
        }
        Types$$ExternalSyntheticBUOutline0.m$2("Unsupported filter pass type.");
        return 0.0d;
    }

    private static double computeGainAt(PolynomialUtils.RationalFraction rationalFraction, Complex complex) {
        return PolynomialUtils.evaluate(rationalFraction, complex).abs();
    }

    private static IirFilterCoefficients computeIirFilterCoefficients(PolynomialUtils.RationalFraction rationalFraction) {
        double d = rationalFraction.bottom[0];
        IirFilterCoefficients iirFilterCoefficients = new IirFilterCoefficients();
        double[] dArrDivide = ArrayUtils.divide(rationalFraction.bottom, d);
        iirFilterCoefficients.a = dArrDivide;
        dArrDivide[0] = 1.0d;
        iirFilterCoefficients.b = ArrayUtils.divide(rationalFraction.top, d);
        return iirFilterCoefficients;
    }

    private static PolynomialUtils.RationalFraction computeTransferFunction(PolesAndZeros polesAndZeros) {
        Complex[] complexArrExpand = PolynomialUtils.expand(polesAndZeros.zeros);
        Complex[] complexArrExpand2 = PolynomialUtils.expand(polesAndZeros.poles);
        PolynomialUtils.RationalFraction rationalFraction = new PolynomialUtils.RationalFraction();
        rationalFraction.top = ArrayUtils.toDouble(complexArrExpand, 1.0E-10d);
        rationalFraction.bottom = ArrayUtils.toDouble(complexArrExpand2, 1.0E-10d);
        return rationalFraction;
    }

    public static IirFilterCoefficients design(FilterPassType filterPassType, FilterCharacteristicsType filterCharacteristicsType, int i, double d, double d2, double d3) {
        Complex[] poles = getPoles(filterCharacteristicsType, i, d);
        SToZMappingMethod sToZMappingMethod = filterCharacteristicsType == FilterCharacteristicsType.bessel ? SToZMappingMethod.matchedZTransform : SToZMappingMethod.bilinearTransform;
        PolynomialUtils.RationalFraction rationalFractionComputeTransferFunction = computeTransferFunction(MapSPlaneToZPlane(normalize(poles, filterPassType, d2, d3, sToZMappingMethod == SToZMappingMethod.bilinearTransform), sToZMappingMethod));
        double dComputeGain = computeGain(rationalFractionComputeTransferFunction, filterPassType, d2, d3);
        IirFilterCoefficients iirFilterCoefficientsComputeIirFilterCoefficients = computeIirFilterCoefficients(rationalFractionComputeTransferFunction);
        iirFilterCoefficientsComputeIirFilterCoefficients.b = ArrayUtils.divide(iirFilterCoefficientsComputeIirFilterCoefficients.b, dComputeGain);
        return iirFilterCoefficientsComputeIirFilterCoefficients;
    }

    private static Complex[] doBilinearTransform(Complex[] complexArr) {
        Complex[] complexArr2 = new Complex[complexArr.length];
        for (int i = 0; i < complexArr.length; i++) {
            complexArr2[i] = doBilinearTransform(complexArr[i]);
        }
        return complexArr2;
    }

    private static Complex[] doMatchedZTransform(Complex[] complexArr) {
        Complex[] complexArr2 = new Complex[complexArr.length];
        for (int i = 0; i < complexArr.length; i++) {
            complexArr2[i] = complexArr[i].exp();
        }
        return complexArr2;
    }

    private static Complex[] extend(Complex[] complexArr, int i, Complex complex) {
        if (complexArr.length >= i) {
            return complexArr;
        }
        Complex[] complexArr2 = new Complex[i];
        for (int i2 = 0; i2 < complexArr.length; i2++) {
            complexArr2[i2] = complexArr[i2];
        }
        for (int length = complexArr.length; length < i; length++) {
            complexArr2[length] = complex;
        }
        return complexArr2;
    }

    private static Complex[] getPoles(FilterCharacteristicsType filterCharacteristicsType, int i, double d) {
        int i2 = AnonymousClass1.$SwitchMap$biz$source_code$dsp$filter$FilterCharacteristicsType[filterCharacteristicsType.ordinal()];
        if (i2 == 1) {
            return BesselFilterDesign.computePoles(i);
        }
        int i3 = 0;
        if (i2 == 2) {
            Complex[] complexArr = new Complex[i];
            while (i3 < i) {
                double d2 = i;
                complexArr[i3] = Complex.expj(((((d2 / 2.0d) + 0.5d) + ((double) i3)) * 3.141592653589793d) / d2);
                i3++;
            }
            return complexArr;
        }
        if (i2 != 3) {
            throw new UnsupportedOperationException("Filter characteristics type " + filterCharacteristicsType + " not yet implemented.");
        }
        if (d >= 0.0d) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Chebyshev ripple must be negative.");
            return null;
        }
        Complex[] poles = getPoles(FilterCharacteristicsType.butterworth, i, 0.0d);
        double dAsinh = asinh(1.0d / Math.sqrt(Math.pow(10.0d, (-d) / 10.0d) - 1.0d)) / ((double) i);
        if (dAsinh <= 0.0d) {
            Utf8$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        double dSinh = Math.sinh(dAsinh);
        double dCosh = Math.cosh(dAsinh);
        while (i3 < i) {
            poles[i3] = new Complex(poles[i3].re() * dSinh, poles[i3].im() * dCosh);
            i3++;
        }
        return poles;
    }

    private static PolesAndZeros normalize(Complex[] complexArr, FilterPassType filterPassType, double d, double d2, boolean z) {
        int length = complexArr.length;
        int i = 0;
        boolean z2 = filterPassType == FilterPassType.bandpass || filterPassType == FilterPassType.bandstop;
        if (d <= 0.0d || d >= 0.5d) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid fcf1.");
            return null;
        }
        if (z2 && (d2 <= 0.0d || d2 >= 0.5d)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid fcf2.");
            return null;
        }
        double dTan = Math.tan(d * 3.141592653589793d) / 3.141592653589793d;
        double dTan2 = z2 ? Math.tan(d2 * 3.141592653589793d) / 3.141592653589793d : 0.0d;
        if (!z) {
            dTan = d;
        }
        double d3 = dTan * 6.283185307179586d;
        if (!z) {
            dTan2 = d2;
        }
        double d4 = dTan2 * 6.283185307179586d;
        int i2 = AnonymousClass1.$SwitchMap$biz$source_code$dsp$filter$FilterPassType[filterPassType.ordinal()];
        if (i2 == 1) {
            PolesAndZeros polesAndZeros = new PolesAndZeros(0);
            polesAndZeros.poles = ArrayUtils.multiply(complexArr, d3);
            polesAndZeros.zeros = new Complex[0];
            return polesAndZeros;
        }
        if (i2 == 2) {
            PolesAndZeros polesAndZeros2 = new PolesAndZeros(0);
            polesAndZeros2.poles = new Complex[length];
            for (int i3 = 0; i3 < length; i3++) {
                polesAndZeros2.poles[i3] = Complex.div(d3, complexArr[i3]);
            }
            polesAndZeros2.zeros = ArrayUtils.zeros(length);
            return polesAndZeros2;
        }
        if (i2 == 3) {
            double dSqrt = Math.sqrt(d3 * d4);
            double d5 = d4 - d3;
            PolesAndZeros polesAndZeros3 = new PolesAndZeros(0);
            polesAndZeros3.poles = new Complex[length * 2];
            for (int i4 = 0; i4 < length; i4++) {
                Complex complexMul = complexArr[i4].mul(d5 / 2.0d);
                Complex complexSqrt = Complex.sub(1.0d, Complex.div(dSqrt, complexMul).sqr()).sqrt();
                polesAndZeros3.poles[i4] = complexMul.mul(complexSqrt.add(1.0d));
                polesAndZeros3.poles[length + i4] = complexMul.mul(Complex.sub(1.0d, complexSqrt));
            }
            polesAndZeros3.zeros = ArrayUtils.zeros(length);
            return polesAndZeros3;
        }
        if (i2 != 4) {
            throw new UnsupportedOperationException("Filter pass type " + filterPassType + " not yet implemented.");
        }
        double dSqrt2 = Math.sqrt(d3 * d4);
        double d6 = d4 - d3;
        PolesAndZeros polesAndZeros4 = new PolesAndZeros(i);
        int i5 = length * 2;
        polesAndZeros4.poles = new Complex[i5];
        for (int i6 = 0; i6 < length; i6++) {
            Complex complexDiv = Complex.div(d6 / 2.0d, complexArr[i6]);
            Complex complexSqrt2 = Complex.sub(1.0d, Complex.div(dSqrt2, complexDiv).sqr()).sqrt();
            polesAndZeros4.poles[i6] = complexDiv.mul(complexSqrt2.add(1.0d));
            polesAndZeros4.poles[length + i6] = complexDiv.mul(Complex.sub(1.0d, complexSqrt2));
        }
        polesAndZeros4.zeros = new Complex[i5];
        for (int i7 = 0; i7 < length; i7++) {
            polesAndZeros4.zeros[i7] = new Complex(0.0d, dSqrt2);
            polesAndZeros4.zeros[length + i7] = new Complex(0.0d, -dSqrt2);
        }
        return polesAndZeros4;
    }

    private static Complex doBilinearTransform(Complex complex) {
        return complex.add(2.0d).div(Complex.sub(2.0d, complex));
    }
}
