package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.text.DecimalFormat;
import kotlin.Metadata;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/WakeupHourChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/ExtractorChartBuilder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "extractor", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;)V", "getTitles", "", "", "()[Ljava/lang/String;", "adjustRenderer", "", "renderer", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "finder", "Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WakeupHourChartBuilder extends ExtractorChartBuilder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeupHourChartBuilder(Context context, IValueExtractor iValueExtractor) {
        super(context, iValueExtractor);
        context.getClass();
        iValueExtractor.getClass();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.ExtractorChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer renderer, MinMaxFinder finder) {
        super.adjustRenderer(renderer, finder);
        if (renderer != null) {
            Number numberValueOf = finder != null ? Double.valueOf(finder.getMaxValue()) : 16;
            renderer.setLabelsTextSize(ActivityUtils.getDip(this.context, 12));
            int iIntValue = numberValueOf.intValue() + 1;
            if (iIntValue >= 0) {
                int i = 0;
                while (true) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    renderer.addYTextLabel(i, sb.toString());
                    if (i == iIntValue) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            renderer.setShowGridX(true);
            renderer.setShowGridY(false);
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.ExtractorChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        double dDoubleValue;
        if (!isShowAvg().booleanValue()) {
            String measureName = getExtractor().getMeasureName();
            measureName.getClass();
            return new String[]{measureName};
        }
        Double avg = getAvg();
        if (avg != null) {
            dDoubleValue = avg.doubleValue();
            if (dDoubleValue > 24.0d) {
                dDoubleValue -= 24.0d;
            }
        } else {
            dDoubleValue = 0.0d;
        }
        if (isShowBars().booleanValue()) {
            String measureName2 = getExtractor().getMeasureName();
            measureName2.getClass();
            return new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(getContext().getResources().getString(R.string.axis_average), FileInsert$$ExternalSyntheticOutline0.m(" (", new DecimalFormat("#.#").format(dDoubleValue), ")")), measureName2};
        }
        String measureName3 = getExtractor().getMeasureName();
        measureName3.getClass();
        return new String[]{measureName3, FileInsert$$ExternalSyntheticOutline0.m$1(getContext().getResources().getString(R.string.axis_average), FileInsert$$ExternalSyntheticOutline0.m(" (", new DecimalFormat("#.#").format(dDoubleValue), ")"))};
    }
}
