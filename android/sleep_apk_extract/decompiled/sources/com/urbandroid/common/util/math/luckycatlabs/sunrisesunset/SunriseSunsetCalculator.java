package com.urbandroid.common.util.math.luckycatlabs.sunrisesunset;

import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.calculator.SolarEventCalculator;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class SunriseSunsetCalculator {
    private SolarEventCalculator calculator;

    public SunriseSunsetCalculator(Location location, TimeZone timeZone) {
        this.calculator = new SolarEventCalculator(location, timeZone);
    }

    public Calendar getCivilSunriseCalendarForDate(Calendar calendar) {
        return this.calculator.computeSunriseCalendar(Zenith.CIVIL, calendar);
    }

    public String getCivilSunsetForDate(Calendar calendar) {
        return this.calculator.computeSunsetTime(Zenith.CIVIL, calendar);
    }

    public Calendar getOfficialSunriseCalendarForDate(Calendar calendar) {
        return this.calculator.computeSunriseCalendar(Zenith.OFFICIAL, calendar);
    }

    public Calendar getOfficialSunsetCalendarForDate(Calendar calendar) {
        return this.calculator.computeSunsetCalendar(Zenith.OFFICIAL, calendar);
    }
}
