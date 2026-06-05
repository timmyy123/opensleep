package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDateChartBuilder<T extends StatRecord> extends AbstractChartBuilder<T> {
    int showingValues;
    Date since;

    public AbstractDateChartBuilder(Context context) {
        super(context);
        this.since = null;
        this.showingValues = -1;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<T> list, MinMaxFinder minMaxFinder) {
        int size = list.size();
        Date[] dateArr = new Date[size];
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, -getDays(list));
        this.since = calendar.getTime();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            t.getToDate();
            Date time = getCalendar(t).getTime();
            dateArr[i] = time;
            if (time.after(this.since)) {
                minMaxFinder.addDate(dateArr[i]);
                this.showingValues++;
            }
        }
        return dateArr;
    }
}
