package com.urbandroid.sleep.addon.stats.model.regression;

import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class PointSeriesImpl implements PointSeries {
    private final Collection<Point> corePoints;
    private final String xName;
    private final String yName;
    private final Collection<Point> outlierPoints = Collections.EMPTY_LIST;
    private final MinMaxFinder minMaxFinder = new MinMaxFinder();

    public PointSeriesImpl(String str, String str2, Collection<Point> collection) {
        this.xName = str;
        this.yName = str2;
        this.corePoints = collection;
        for (Point point : collection) {
            this.minMaxFinder.addValueX(point.getX());
            this.minMaxFinder.addValue(point.getY());
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public Collection<Point> getCorePoints() {
        return this.corePoints;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public MinMaxFinder getMinMaxFinder() {
        return this.minMaxFinder;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public String getXName() {
        return this.xName;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.regression.PointSeries
    public String getYName() {
        return this.yName;
    }
}
