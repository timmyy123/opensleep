package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.PopulationChronoStats;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class ChronotypeBarChartBuilder extends AbstractBarChartBuilder {
    private int color;
    private double myX;

    public ChronotypeBarChartBuilder(Context context, int i) {
        super(context);
        this.myX = 20.0d;
        this.color = i;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        xYMultipleSeriesRenderer.setXLabelsAngle(0.0f);
        xYMultipleSeriesRenderer.setXLabels(0);
        xYMultipleSeriesRenderer.setShowGrid(false);
        xYMultipleSeriesRenderer.setShowGridX(false);
        xYMultipleSeriesRenderer.setShowGridY(false);
        xYMultipleSeriesRenderer.setClickEnabled(false);
        xYMultipleSeriesRenderer.setZoomEnabled(false);
        xYMultipleSeriesRenderer.setPanEnabled(true, false);
        xYMultipleSeriesRenderer.setPanLimits(new double[]{minMaxFinder.getMinValueX(), minMaxFinder.getMaxValueX(), 0.0d, 0.0d});
        double maxValueX = minMaxFinder.getMaxValueX() / 4.0d;
        xYMultipleSeriesRenderer.setXAxisMax(Math.min(minMaxFinder.getMaxValueX(), this.myX + maxValueX));
        xYMultipleSeriesRenderer.setXAxisMin(Math.max(minMaxFinder.getMinValueX(), this.myX - maxValueX));
        xYMultipleSeriesRenderer.setShowAxes(false);
        xYMultipleSeriesRenderer.setBarWidth(ActivityUtils.getDip(getContext(), 6));
        xYMultipleSeriesRenderer.setBarSpacing(ActivityUtils.getDip(getContext(), 2));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(getContext(), R.font.product));
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setXLabelsPadding(ActivityUtils.getDip(getContext(), 4));
        xYMultipleSeriesRenderer.setShowLegend(true);
        xYMultipleSeriesRenderer.setFitLegend(true);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public XYMultipleSeriesRenderer buildRenderer(int[] iArr) {
        return super.buildRenderer(iArr);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(getContext(), R.color.shade), ColorUtil.i(getContext(), this.color)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String[] getSeriesTitles() {
        return new String[]{getContext().getResources().getString(R.string.stats_caption_others), getContext().getResources().getString(R.string.me)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String getTitle() {
        return getContext().getResources().getString(R.string.chronotype);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String[] getXAxisTitles() {
        ArrayList arrayList = new ArrayList();
        for (Float f : new ArrayList(PopulationChronoStats.getMidSleepOnFreeDaysHistogram().keySet())) {
            if (Math.round(f.floatValue() * 100.0f) % 20 == 0) {
                arrayList.add("" + Math.round(f.floatValue()));
            } else {
                arrayList.add("");
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String getXLabel() {
        StringBuilder sb = new StringBuilder("\n\n\n");
        sb.append(getContext().getResources().getString(R.string.midsleep));
        sb.append(", ");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, getContext().getResources().getStringArray(R.array.period_array)[SleepStats.PERIOD_INDEX], "");
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public List<double[]> getYAxisValues(SocialJetlagStats socialJetlagStats) {
        ArrayList arrayList = new ArrayList();
        float midSleepFreeDays = socialJetlagStats.getMidSleepFreeDays();
        SortedMap<Float, Float> midSleepOnFreeDaysHistogram = PopulationChronoStats.getMidSleepOnFreeDaysHistogram();
        boolean z = false;
        double dSum = ScienceUtil.sum((Float[]) midSleepOnFreeDaysHistogram.values().toArray(new Float[0]));
        ArrayList arrayList2 = new ArrayList(midSleepOnFreeDaysHistogram.keySet());
        double[] dArr = new double[arrayList2.size()];
        double[] dArr2 = new double[arrayList2.size()];
        for (int i = 1; i < arrayList2.size(); i++) {
            dArr[i] = (((double) midSleepOnFreeDaysHistogram.get(arrayList2.get(i)).floatValue()) / dSum) * 100.0d;
            if (midSleepFreeDays >= ((Float) arrayList2.get(i)).floatValue() || z) {
                dArr2[i] = 0.0d;
            } else {
                dArr2[i] = dArr[i];
                this.myX = i;
                z = true;
            }
        }
        arrayList.add(dArr);
        arrayList.add(dArr2);
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractBarChartBuilder
    public String getYLabel() {
        return getContext().getResources().getString(R.string.stats_caption_others) + "%";
    }
}
