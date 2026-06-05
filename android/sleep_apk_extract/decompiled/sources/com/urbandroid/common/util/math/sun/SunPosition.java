package com.urbandroid.common.util.math.sun;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public abstract class SunPosition {
    public static double ORBIT_RADS_PER_DAY = 0.017202792111235436d;

    public static double adjustWithin2PI(double d) {
        if (d < 0.0d) {
            do {
                d += 6.2831854820251465d;
            } while (d < 0.0d);
            return d;
        }
        if (d > 6.2831854820251465d) {
            do {
                d -= 6.2831854820251465d;
            } while (d > 6.2831854820251465d);
        }
        return d;
    }

    public static double calculateJulianDate(GregorianCalendar gregorianCalendar) {
        int i = gregorianCalendar.get(1);
        int i2 = gregorianCalendar.get(2);
        int i3 = gregorianCalendar.get(5);
        int i4 = i2 + 1;
        if (i4 == 1 || i4 == 2) {
            i--;
            i4 = i2 + 13;
        }
        int i5 = i / 100;
        return ((double) FileInsert$$ExternalSyntheticOutline0.m((i5 / 4) + (2 - i5), (int) (((double) i) * 365.25d), (int) (((double) (i4 + 1)) * 30.6001d), i3)) + 1720994.5d;
    }

    public static double eccentricAnomaly(double d) {
        double dCos = d;
        while (true) {
            double dSin = (dCos - (Math.sin(dCos) * 0.016713d)) - d;
            if (Math.abs(dSin) <= 1.0E-10d) {
                return dCos;
            }
            dCos -= dSin / (1.0d - (Math.cos(dCos) * 0.016713d));
        }
    }

    public static double eclipticToEquatorialAscension(double d, double d2) {
        double dSin = Math.sin(0.4091155d);
        return Math.atan2((Math.sin(d) * Math.cos(0.4091155d)) - (Math.tan(d2) * dSin), Math.cos(d));
    }

    public static double eclipticToEquatorialDeclination(double d, double d2) {
        double dSin = Math.sin(0.4091155d);
        return Math.asin((Math.sin(d) * Math.cos(d2) * dSin) + (Math.sin(d2) * Math.cos(0.4091155d)));
    }

    public static double greenwichSiderealTime(double d, GregorianCalendar gregorianCalendar) {
        double d2 = (d - 2451545.0d) / 36525.0d;
        double d3 = ((((2.5862E-5d + d2) + 2400.051336d) * d2) + 6.697374558d) % 24.0d;
        if (d3 < 0.0d) {
            d3 += 24.0d;
        }
        double d4 = ((((((((double) gregorianCalendar.get(13)) / 60.0d) + ((double) gregorianCalendar.get(12))) / 60.0d) + ((double) gregorianCalendar.get(11))) * 1.002737909d) + d3) % 24.0d;
        return d4 < 0.0d ? d4 + 24.0d : d4;
    }

    public static double sunEclipticLongitude(double d) {
        double dEccentricAnomaly = eccentricAnomaly(d);
        return adjustWithin2PI((Math.atan(Math.tan(dEccentricAnomaly / 2.0d) * Math.sqrt(1.033994144130859d)) * 2.0d) + 4.935239985213178d);
    }

    public static double sunMeanAnomaly(double d) {
        double d2 = (ORBIT_RADS_PER_DAY * d) % 6.2831854820251465d;
        if (d2 < 0.0d) {
            d2 += 6.2831854820251465d;
        }
        double d3 = (d2 + 4.87650757893409d) - 4.935239985213178d;
        return d3 < 0.0d ? d3 + 6.2831854820251465d : d3;
    }

    public static LatLonPoint sunPosition(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(j));
        double dCalculateJulianDate = calculateJulianDate(gregorianCalendar);
        gregorianCalendar.setTime(new Date(j - (((long) gregorianCalendar.get(15)) + ((long) gregorianCalendar.get(16)))));
        double dSunEclipticLongitude = sunEclipticLongitude(sunMeanAnomaly(((j / 1000) - 6.310656E8d) / 86400.0d));
        return new LatLonPoint(eclipticToEquatorialDeclination(dSunEclipticLongitude, 0.0d), eclipticToEquatorialAscension(dSunEclipticLongitude, 0.0d) - (greenwichSiderealTime(dCalculateJulianDate, gregorianCalendar) * 0.2617993950843811d));
    }
}
