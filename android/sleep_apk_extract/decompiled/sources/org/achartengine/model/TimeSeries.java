package org.achartengine.model;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class TimeSeries extends XYSeries {
    public TimeSeries(String str) {
        super(str);
    }

    public synchronized void add(Date date, double d) {
        super.add(date.getTime(), d);
    }

    @Override // org.achartengine.model.XYSeries
    public double getPadding(double d) {
        return 1.0d;
    }
}
