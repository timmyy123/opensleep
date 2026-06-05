package com.urbandroid.sleep.addon.stats.model.regression;

import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public interface PointSeries {
    Collection<Point> getCorePoints();

    MinMaxFinder getMinMaxFinder();

    String getXName();

    String getYName();
}
