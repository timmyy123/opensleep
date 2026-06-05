package com.urbandroid.sleep.addon.stats.model.collector;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class WeekdayCollector extends AbstractStatCollector {
    private int[] weekdays;

    public WeekdayCollector(IValueExtractor iValueExtractor, String str) {
        super(iValueExtractor, str);
        this.weekdays = new int[8];
        int firstDayOfWeek = SharedApplicationContext.getSettings().getFirstDayOfWeek();
        int i = 0;
        while (i < 7) {
            int i2 = firstDayOfWeek + i;
            if (i2 >= 8) {
                i2 -= 7;
            }
            int i3 = i + 1;
            getIntervals().add(new Interval(i, i3, DateUtil.getShortWeekdayNames()[i2]));
            this.weekdays[i2] = i;
            i = i3;
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.AbstractStatCollector
    public double getRecordValue(IStatRecord iStatRecord) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(iStatRecord.getToDate());
        return ((double) this.weekdays[calendar.get(7)]) + 0.5d;
    }
}
