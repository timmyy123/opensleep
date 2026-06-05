package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.alarmclock.Alarms;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class BedtimeHourExtractor extends AbstractValueExtractor {
    private Context context;

    public BedtimeHourExtractor(Context context) {
        this.context = context;
    }

    public static double adjustHour(double d) {
        return d < 12.0d ? d + 24.0d : d;
    }

    public static double adjustHourBack(double d) {
        return d >= 24.0d ? d - 24.0d : d;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#fall-asleep-hour";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.duration;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context != null ? context.getString(R.string.time_to_bed_title) : "Bedtime";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        if (iMeasureRecord instanceof IStatRecord) {
            return adjustHour(((IStatRecord) iMeasureRecord).getFromHour());
        }
        return 0.0d;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        double dAdjustHourBack = adjustHourBack(d) * 60.0d;
        Calendar calendar = Calendar.getInstance();
        int i = (int) dAdjustHourBack;
        calendar.set(11, i / 60);
        calendar.set(12, i % 60);
        return DateUtil.formatTimeShort(this.context, calendar.getTimeInMillis());
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        boolean z = Alarms.get24HourMode(this.context);
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                Logger.logSevere("Format ".concat(str), e);
                return 20.0d;
            }
        }
        double d = (((double) Integer.parseInt(strArrSplit[1])) / 60.0d) + ((double) Integer.parseInt(strArrSplit[0]));
        if (!z && (d > 4.0d || d < 12.0d)) {
            d += 12.0d;
        }
        return adjustHour(d);
    }
}
