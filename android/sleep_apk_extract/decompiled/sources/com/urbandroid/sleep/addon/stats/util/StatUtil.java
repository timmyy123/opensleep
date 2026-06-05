package com.urbandroid.sleep.addon.stats.util;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StatUtil {
    public static List<StatRecord> filterRecords(List<StatRecord> list, Date date, Date date2) {
        ArrayList arrayList = new ArrayList();
        for (StatRecord statRecord : list) {
            if (date.before(statRecord.getFromDate()) && date2.after(statRecord.getToDate())) {
                arrayList.add(statRecord);
            }
        }
        return arrayList;
    }

    public static List<StatRecord> filterSelectedRecords(List<StatRecord> list) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -Math.max(SleepStats.DAYS * 4, 30));
        return filterRecords(list, calendar.getTime(), new Date());
    }

    public static Date getSinceDate(List<StatRecord> list) {
        if (list.size() == 0) {
            return new Date();
        }
        Date fromDate = list.get(0).getFromDate();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -SleepStats.DAYS);
        Date time = calendar.getTime();
        return fromDate.after(time) ? fromDate : time;
    }

    public static boolean hasSleepIrregularityHistory(Context context, List<StatRecord> list, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -(i + 30));
        List<StatRecord> listFilterRecords = filterRecords(list, calendar.getTime(), new Date());
        return !listFilterRecords.isEmpty() && SocialJetlagStats.create(listFilterRecords, context).getSleepIrregularityHistory(30, 1).size() > 1;
    }
}
