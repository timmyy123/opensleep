package com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.calculator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.Zenith;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class SolarEventCalculator {
    public final Location location;
    public final TimeZone timeZone;

    public SolarEventCalculator(Location location, TimeZone timeZone) {
        this.location = location;
        this.timeZone = timeZone;
    }

    public BigDecimal adjustForDST(BigDecimal bigDecimal, Calendar calendar) {
        if (this.timeZone.inDaylightTime(calendar.getTime())) {
            bigDecimal = bigDecimal.add(BigDecimal.ONE);
        }
        return bigDecimal.doubleValue() > 24.0d ? bigDecimal.subtract(BigDecimal.valueOf(24L)) : bigDecimal;
    }

    public BigDecimal computeSolarEventTime(Zenith zenith, Calendar calendar, boolean z) {
        calendar.setTimeZone(this.timeZone);
        BigDecimal longitudeHour = getLongitudeHour(calendar, Boolean.valueOf(z));
        BigDecimal sunTrueLongitude = getSunTrueLongitude(getMeanAnomaly(longitudeHour));
        BigDecimal cosineSunLocalHour = getCosineSunLocalHour(sunTrueLongitude, zenith);
        if (cosineSunLocalHour.doubleValue() < -1.0d || cosineSunLocalHour.doubleValue() > 1.0d) {
            return null;
        }
        return getLocalTime(getLocalMeanTime(sunTrueLongitude, longitudeHour, getSunLocalHour(cosineSunLocalHour, Boolean.valueOf(z))), calendar);
    }

    public Calendar computeSunriseCalendar(Zenith zenith, Calendar calendar) {
        return getLocalTimeAsCalendar(computeSolarEventTime(zenith, calendar, true), calendar);
    }

    public Calendar computeSunsetCalendar(Zenith zenith, Calendar calendar) {
        return getLocalTimeAsCalendar(computeSolarEventTime(zenith, calendar, false), calendar);
    }

    public String computeSunsetTime(Zenith zenith, Calendar calendar) {
        return getLocalTimeAsString(computeSolarEventTime(zenith, calendar, false));
    }

    public BigDecimal convertDegreesToRadians(BigDecimal bigDecimal) {
        return multiplyBy(bigDecimal, BigDecimal.valueOf(0.017453292519943295d));
    }

    public BigDecimal convertRadiansToDegrees(BigDecimal bigDecimal) {
        return multiplyBy(bigDecimal, new BigDecimal(57.29577951308232d));
    }

    public BigDecimal divideBy(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.divide(bigDecimal2, 4, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getArcCosineFor(BigDecimal bigDecimal) {
        return setScale(BigDecimal.valueOf(Math.acos(bigDecimal.doubleValue())));
    }

    public BigDecimal getBaseLongitudeHour() {
        return divideBy(this.location.getLongitude(), BigDecimal.valueOf(15L));
    }

    public BigDecimal getCosineOfSunDeclination(BigDecimal bigDecimal) {
        return setScale(BigDecimal.valueOf(Math.cos(BigDecimal.valueOf(Math.asin(bigDecimal.doubleValue())).doubleValue())));
    }

    public BigDecimal getCosineSunLocalHour(BigDecimal bigDecimal, Zenith zenith) {
        BigDecimal sinOfSunDeclination = getSinOfSunDeclination(bigDecimal);
        BigDecimal cosineOfSunDeclination = getCosineOfSunDeclination(sinOfSunDeclination);
        return setScale(divideBy(BigDecimal.valueOf(Math.cos(convertDegreesToRadians(zenith.degrees()).doubleValue())).subtract(sinOfSunDeclination.multiply(BigDecimal.valueOf(Math.sin(convertDegreesToRadians(this.location.getLatitude()).doubleValue())))), cosineOfSunDeclination.multiply(BigDecimal.valueOf(Math.cos(convertDegreesToRadians(this.location.getLatitude()).doubleValue())))));
    }

    public BigDecimal getDayOfYear(Calendar calendar) {
        return new BigDecimal(calendar.get(6));
    }

    public BigDecimal getLocalMeanTime(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal rightAscension = getRightAscension(bigDecimal);
        BigDecimal bigDecimalSubtract = bigDecimal3.add(rightAscension).subtract(bigDecimal2.multiply(new BigDecimal("0.06571"))).subtract(new BigDecimal("6.622"));
        if (bigDecimalSubtract.doubleValue() < 0.0d) {
            bigDecimalSubtract = bigDecimalSubtract.add(BigDecimal.valueOf(24L));
        } else if (bigDecimalSubtract.doubleValue() > 24.0d) {
            bigDecimalSubtract = bigDecimalSubtract.subtract(BigDecimal.valueOf(24L));
        }
        return setScale(bigDecimalSubtract);
    }

    public BigDecimal getLocalTime(BigDecimal bigDecimal, Calendar calendar) {
        return adjustForDST(bigDecimal.subtract(getBaseLongitudeHour()).add(getUTCOffSet(calendar)), calendar);
    }

    public Calendar getLocalTimeAsCalendar(BigDecimal bigDecimal, Calendar calendar) {
        if (bigDecimal == null) {
            return null;
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        if (bigDecimal.compareTo(bigDecimal2) == -1) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(24.0d));
            calendar2.add(11, -24);
        }
        String[] strArrSplit = bigDecimal.toPlainString().split("\\.");
        int i = Integer.parseInt(strArrSplit[0]);
        BigDecimal scale = new BigDecimal("0." + strArrSplit[1]).multiply(BigDecimal.valueOf(60L)).setScale(0, RoundingMode.HALF_EVEN);
        if (scale.intValue() == 60) {
            i++;
        } else {
            bigDecimal2 = scale;
        }
        if (i == 24) {
            i = 0;
        }
        calendar2.set(11, i);
        calendar2.set(12, bigDecimal2.intValue());
        calendar2.set(13, 0);
        calendar2.setTimeZone(calendar.getTimeZone());
        return calendar2;
    }

    public String getLocalTimeAsString(BigDecimal bigDecimal) {
        String plainString;
        String strValueOf;
        if (bigDecimal == null) {
            return "99:99";
        }
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        if (bigDecimal.compareTo(bigDecimal2) == -1) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(24.0d));
        }
        String[] strArrSplit = bigDecimal.toPlainString().split("\\.");
        int i = Integer.parseInt(strArrSplit[0]);
        BigDecimal scale = new BigDecimal("0." + strArrSplit[1]).multiply(BigDecimal.valueOf(60L)).setScale(0, RoundingMode.HALF_EVEN);
        if (scale.intValue() == 60) {
            i++;
        } else {
            bigDecimal2 = scale;
        }
        int i2 = i != 24 ? i : 0;
        if (bigDecimal2.intValue() < 10) {
            plainString = AppEventsConstants.EVENT_PARAM_VALUE_NO + bigDecimal2.toPlainString();
        } else {
            plainString = bigDecimal2.toPlainString();
        }
        if (i2 < 10) {
            strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + String.valueOf(i2);
        } else {
            strValueOf = String.valueOf(i2);
        }
        return FileInsert$$ExternalSyntheticOutline0.m$1(strValueOf, ":", plainString);
    }

    public BigDecimal getLongitudeHour(Calendar calendar, Boolean bool) {
        return setScale(getDayOfYear(calendar).add(divideBy(BigDecimal.valueOf(bool.booleanValue() ? 6 : 18).subtract(getBaseLongitudeHour()), BigDecimal.valueOf(24L))));
    }

    public BigDecimal getMeanAnomaly(BigDecimal bigDecimal) {
        return setScale(multiplyBy(new BigDecimal("0.9856"), bigDecimal).subtract(new BigDecimal("3.289")));
    }

    public BigDecimal getRightAscension(BigDecimal bigDecimal) {
        BigDecimal scale = setScale(convertRadiansToDegrees(new BigDecimal(Math.atan(convertDegreesToRadians(multiplyBy(convertRadiansToDegrees(new BigDecimal(Math.tan(convertDegreesToRadians(bigDecimal).doubleValue()))), new BigDecimal("0.91764"))).doubleValue()))));
        if (scale.doubleValue() < 0.0d) {
            scale = scale.add(BigDecimal.valueOf(360L));
        } else if (scale.doubleValue() > 360.0d) {
            scale = scale.subtract(BigDecimal.valueOf(360L));
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(90L);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        return divideBy(scale.add(bigDecimal.divide(bigDecimalValueOf, 0, roundingMode).multiply(bigDecimalValueOf).subtract(scale.divide(bigDecimalValueOf, 0, roundingMode).multiply(bigDecimalValueOf))), BigDecimal.valueOf(15L));
    }

    public BigDecimal getSinOfSunDeclination(BigDecimal bigDecimal) {
        return setScale(BigDecimal.valueOf(Math.sin(convertDegreesToRadians(bigDecimal).doubleValue())).multiply(new BigDecimal("0.39782")));
    }

    public BigDecimal getSunLocalHour(BigDecimal bigDecimal, Boolean bool) {
        BigDecimal bigDecimalConvertRadiansToDegrees = convertRadiansToDegrees(getArcCosineFor(bigDecimal));
        if (bool.booleanValue()) {
            bigDecimalConvertRadiansToDegrees = BigDecimal.valueOf(360L).subtract(bigDecimalConvertRadiansToDegrees);
        }
        return divideBy(bigDecimalConvertRadiansToDegrees, BigDecimal.valueOf(15L));
    }

    public BigDecimal getSunTrueLongitude(BigDecimal bigDecimal) {
        BigDecimal bigDecimalAdd = bigDecimal.add(multiplyBy(new BigDecimal(Math.sin(convertDegreesToRadians(bigDecimal).doubleValue())), new BigDecimal("1.916"))).add(multiplyBy(new BigDecimal(Math.sin(multiplyBy(convertDegreesToRadians(bigDecimal), BigDecimal.valueOf(2L)).doubleValue())), new BigDecimal("0.020")).add(new BigDecimal("282.634")));
        if (bigDecimalAdd.doubleValue() > 360.0d) {
            bigDecimalAdd = bigDecimalAdd.subtract(BigDecimal.valueOf(360L));
        }
        return setScale(bigDecimalAdd);
    }

    public BigDecimal getUTCOffSet(Calendar calendar) {
        return new BigDecimal(calendar.get(15) / 3600000).setScale(0, RoundingMode.HALF_EVEN);
    }

    public BigDecimal multiplyBy(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return setScale(bigDecimal.multiply(bigDecimal2));
    }

    public BigDecimal setScale(BigDecimal bigDecimal) {
        return bigDecimal.setScale(4, RoundingMode.HALF_EVEN);
    }
}
