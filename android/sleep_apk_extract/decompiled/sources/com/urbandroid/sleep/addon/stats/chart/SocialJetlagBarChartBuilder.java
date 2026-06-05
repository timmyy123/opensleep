package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class SocialJetlagBarChartBuilder extends AbstractBarChartBuilder {
    public SocialJetlagBarChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        xYMultipleSeriesRenderer.setBarWidth(ActivityUtils.getDip(getContext(), 36));
        xYMultipleSeriesRenderer.setBarSpacing(ActivityUtils.getDip(getContext(), 8));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setShowAxes(false);
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(getContext(), R.font.product));
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setXLabelsPadding(ActivityUtils.getDip(getContext(), 2));
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(getContext(), R.color.score_deep_sleep), ColorUtil.i(getContext(), R.color.duration), ColorUtil.i(getContext(), R.color.negative)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String[] getSeriesTitles() {
        return new String[]{getContext().getResources().getString(R.string.working_days), getContext().getResources().getString(R.string.free_days), getContext().getResources().getString(R.string.social_jatlag)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String getTitle() {
        return getContext().getResources().getString(R.string.social_jatlag);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String[] getXAxisTitles() {
        return new String[]{"", "", ""};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public List<double[]> getYAxisValues(SocialJetlagStats socialJetlagStats) {
        ArrayList arrayList = new ArrayList();
        float midSleepFreeDays = socialJetlagStats.getMidSleepFreeDays();
        float midSleepBusyDays = socialJetlagStats.getMidSleepBusyDays();
        if (Float.isNaN(midSleepBusyDays)) {
            arrayList.add(new double[]{0.0d, 0.0d, 0.0d});
        } else {
            arrayList.add(new double[]{midSleepBusyDays, 0.0d, 0.0d});
        }
        if (Float.isNaN(midSleepFreeDays)) {
            arrayList.add(new double[]{0.0d, 0.0d, 0.0d});
        } else {
            arrayList.add(new double[]{0.0d, midSleepFreeDays, 0.0d});
        }
        if (Float.isNaN(midSleepFreeDays) || Float.isNaN(midSleepBusyDays)) {
            arrayList.add(new double[]{0.0d, 0.0d, 0.0d});
            return arrayList;
        }
        arrayList.add(new double[]{0.0d, 0.0d, Math.abs(midSleepFreeDays - midSleepBusyDays)});
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String getYLabel() {
        return getContext().getResources().getString(R.string.midsleep);
    }
}
