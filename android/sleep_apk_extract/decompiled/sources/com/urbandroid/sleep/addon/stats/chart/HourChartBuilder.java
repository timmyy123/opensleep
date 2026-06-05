package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.text.format.DateFormat;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/HourChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/ExtractorChartBuilder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "extractor", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;)V", "getTitles", "", "", "()[Ljava/lang/String;", "adjustRenderer", "", "renderer", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "finder", "Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "TimeNumberFormat", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HourChartBuilder extends ExtractorChartBuilder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HourChartBuilder(Context context, IValueExtractor iValueExtractor) {
        super(context, iValueExtractor);
        context.getClass();
        iValueExtractor.getClass();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.ExtractorChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer renderer, MinMaxFinder finder) {
        super.adjustRenderer(renderer, finder);
        if (renderer != null) {
            Context context = this.context;
            context.getClass();
            renderer.setYLabelFormat(new TimeNumberFormat(context), 0);
            renderer.setLabelsTextSize(ActivityUtils.getDip(this.context, 12));
            renderer.setYAxisMax(35.999999d);
            renderer.setShowGridX(true);
            renderer.setShowGridY(true);
            renderer.setPanEnabled(true, true);
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

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/HourChartBuilder$TimeNumberFormat;", "Ljava/text/NumberFormat;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "format", "Ljava/lang/StringBuffer;", "number", "", "toAppendTo", "pos", "Ljava/text/FieldPosition;", "", "parse", "", ShareConstants.FEED_SOURCE_PARAM, "", "parsePosition", "Ljava/text/ParsePosition;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class TimeNumberFormat extends NumberFormat {
        private final Context context;

        public TimeNumberFormat(Context context) {
            context.getClass();
            this.context = context;
        }

        @Override // java.text.NumberFormat
        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
            toAppendTo.getClass();
            pos.getClass();
            int i = (int) (number * 60.0d);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i / 60);
            calendar.set(12, i % 60);
            toAppendTo.append(new SimpleDateFormat(DateFormat.is24HourFormat(this.context) ? "H:mm" : "h:mm a", Locale.getDefault()).format(calendar.getTime()));
            return toAppendTo;
        }

        @Override // java.text.NumberFormat
        public Number parse(String source, ParsePosition parsePosition) {
            source.getClass();
            parsePosition.getClass();
            return null;
        }

        @Override // java.text.NumberFormat
        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
            toAppendTo.getClass();
            pos.getClass();
            return format(number, toAppendTo, pos);
        }
    }
}
