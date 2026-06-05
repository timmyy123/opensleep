package com.urbandroid.sleep.jetlag;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.domain.timezone.ZoneInfoMapper;
import com.urbandroid.sleep.location.Location;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SunTimeUtil {
    public static Date getRemoteSunriseInLocalTime(TimeZone timeZone) {
        Location location = new ZoneInfoMapper().getLocation(timeZone.getID());
        if (location == null) {
            Logger.logInfo("JetLag: null location for " + timeZone);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), calendar.getTimeZone()).getOfficialSunriseCalendarForDate(calendar);
        if (officialSunriseCalendarForDate != null) {
            return officialSunriseCalendarForDate.getTime();
        }
        return null;
    }

    public static Date getRemoteSunsetInLocalTime(TimeZone timeZone) {
        Location location = new ZoneInfoMapper().getLocation(timeZone.getID());
        if (location == null) {
            Logger.logInfo("JetLag: null location for " + timeZone);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar officialSunsetCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), calendar.getTimeZone()).getOfficialSunsetCalendarForDate(calendar);
        if (officialSunsetCalendarForDate != null) {
            return officialSunsetCalendarForDate.getTime();
        }
        return null;
    }

    public static boolean isRemoteSunTime(TimeZone timeZone, Location location) {
        if (location == null) {
            Logger.logInfo("JetLag: null location for " + timeZone);
            return false;
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), timeZone).getOfficialSunriseCalendarForDate(calendar);
        Calendar officialSunsetCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), timeZone).getOfficialSunsetCalendarForDate(calendar);
        if (officialSunsetCalendarForDate != null && officialSunriseCalendarForDate != null) {
            Logger.logInfo("JetLag: local sunrise " + officialSunriseCalendarForDate.getTime() + " sunset " + officialSunsetCalendarForDate.getTime() + " now " + calendar.getTime());
            if (calendar.after(officialSunriseCalendarForDate) && calendar.before(officialSunsetCalendarForDate)) {
                Logger.logInfo("JetLag: is sun ");
                return true;
            }
        }
        Logger.logInfo("JetLag: is sun ");
        return false;
    }
}
