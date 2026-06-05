package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IChartBuilder<T> {
    IChartBuilder<T> buildChart(Context context, List<T> list);

    View createView(Context context);

    String getGraphTitle();

    String getHelpUrl();
}
