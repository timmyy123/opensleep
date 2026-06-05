package org.apache.commons.math3.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Precision {
    private static final long POSITIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(0.0d);
    private static final long NEGATIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(-0.0d);
    private static final int POSITIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(0.0f);
    private static final int NEGATIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(-0.0f);
    public static final double EPSILON = Double.longBitsToDouble(4368491638549381120L);
    public static final double SAFE_MIN = Double.longBitsToDouble(4503599627370496L);

    public static int compareTo(double d, double d2, double d3) {
        if (equals(d, d2, d3)) {
            return 0;
        }
        return d < d2 ? -1 : 1;
    }

    public static boolean equals(double d, double d2, int i) {
        long j;
        long j2;
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d2);
        if (((jDoubleToRawLongBits ^ jDoubleToRawLongBits2) & Long.MIN_VALUE) != 0) {
            if (jDoubleToRawLongBits < jDoubleToRawLongBits2) {
                j = jDoubleToRawLongBits2 - POSITIVE_ZERO_DOUBLE_BITS;
                j2 = jDoubleToRawLongBits - NEGATIVE_ZERO_DOUBLE_BITS;
            } else {
                long j3 = jDoubleToRawLongBits - POSITIVE_ZERO_DOUBLE_BITS;
                long j4 = jDoubleToRawLongBits2 - NEGATIVE_ZERO_DOUBLE_BITS;
                j = j3;
                j2 = j4;
            }
            long j5 = i;
            if (j > j5 || j2 > j5 - j) {
                return false;
            }
        } else if (FastMath.abs(jDoubleToRawLongBits - jDoubleToRawLongBits2) > i) {
            return false;
        }
        return (Double.isNaN(d) || Double.isNaN(d2)) ? false : true;
    }

    public static boolean equalsIncludingNaN(float f, float f2) {
        if (f == f && f2 == f2) {
            return equals(f, f2, 1);
        }
        return !(((f2 > f2 ? 1 : (f2 == f2 ? 0 : -1)) != 0) ^ ((f > f ? 1 : (f == f ? 0 : -1)) != 0));
    }

    public static boolean equalsIncludingNaN(double d, double d2) {
        if (d == d && d2 == d2) {
            return equals(d, d2, 1);
        }
        return !(((d > d ? 1 : (d == d ? 0 : -1)) != 0) ^ ((d2 > d2 ? 1 : (d2 == d2 ? 0 : -1)) != 0));
    }

    public static boolean equals(double d, double d2) {
        return equals(d, d2, 1);
    }

    public static boolean equals(double d, double d2, double d3) {
        return equals(d, d2, 1) || FastMath.abs(d2 - d) <= d3;
    }

    public static boolean equals(float f, float f2, int i) {
        int i2;
        int i3;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int iFloatToRawIntBits2 = Float.floatToRawIntBits(f2);
        if (((iFloatToRawIntBits ^ iFloatToRawIntBits2) & Integer.MIN_VALUE) != 0) {
            if (iFloatToRawIntBits < iFloatToRawIntBits2) {
                i2 = iFloatToRawIntBits2 - POSITIVE_ZERO_FLOAT_BITS;
                i3 = iFloatToRawIntBits - NEGATIVE_ZERO_FLOAT_BITS;
            } else {
                int i4 = iFloatToRawIntBits - POSITIVE_ZERO_FLOAT_BITS;
                int i5 = iFloatToRawIntBits2 - NEGATIVE_ZERO_FLOAT_BITS;
                i2 = i4;
                i3 = i5;
            }
            if (i2 > i || i3 > i - i2) {
                return false;
            }
        } else if (FastMath.abs(iFloatToRawIntBits - iFloatToRawIntBits2) > i) {
            return false;
        }
        return (Float.isNaN(f) || Float.isNaN(f2)) ? false : true;
    }
}
