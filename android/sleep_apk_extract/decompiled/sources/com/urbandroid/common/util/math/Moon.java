package com.urbandroid.common.util.math;

/* JADX INFO: loaded from: classes4.dex */
public class Moon {
    private double i;
    private double t;

    public Moon(JulianDay julianDay) {
        double dJulianDay = (julianDay.julianDay() - 2451545.0d) / 36525.0d;
        this.t = dJulianDay;
        this.i = i(dJulianDay);
    }

    private static double cos(double d) {
        return Math.cos(Math.toRadians(d));
    }

    public static double d(double d) {
        return ((((((1.8319447192361523E-6d - (d / 1.13065E8d)) * d) - 0.0018819d) * d) + 445267.1114034d) * d) + 297.8501921d;
    }

    public static double i(double d) {
        double d2 = d(d);
        double dM = m(d);
        double dMPrime = mPrime(d);
        double d3 = d2 * 2.0d;
        return (((((sin(dM) * 2.1d) + ((180.0d - d2) - (sin(dMPrime) * 6.289d))) - (sin(d3 - dMPrime) * 1.274d)) - (sin(d3) * 0.658d)) - (sin(dMPrime * 2.0d) * 0.214d)) - (sin(d2) * 0.11d);
    }

    public static double illuminatedFraction(double d) {
        return (cos(d) + 1.0d) * 0.5d;
    }

    public static int illuminatedPercentage(double d) {
        return (int) Math.round(illuminatedFraction(d) * 100.0d);
    }

    public static double m(double d) {
        return (((((d / 2.449E7d) - 1.536E-4d) * d) + 35999.0502909d) * d) + 357.5291092d;
    }

    public static double mPrime(double d) {
        return ((((((1.4347408140719379E-5d - (d / 1.4712E7d)) * d) + 0.0087414d) * d) + 477198.8675055d) * d) + 134.9633964d;
    }

    private static double sin(double d) {
        return Math.sin(Math.toRadians(d));
    }

    public int illuminatedPercentage() {
        return illuminatedPercentage(this.i);
    }
}
