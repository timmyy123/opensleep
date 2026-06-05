package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.service.Settings$$ExternalSyntheticLambda0;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J!\u0010 \u001a\u00020\u001f2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"H\u0016¢\u0006\u0004\b \u0010$J1\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\"2\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b(\u0010)J1\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u000f2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"H\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010\fR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00102R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/DiffExtractorRangeChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/AbstractRangeChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "titleString", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "extractor", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;)V", "getYTitle", "()Ljava/lang/String;", "getXTitle", "getGraphTitle", "", "Lorg/achartengine/chart/PointStyle;", "getPointStyles", "()[Lorg/achartengine/chart/PointStyle;", "", "getColors", "()[I", "getTitles", "()[Ljava/lang/String;", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "renderer", "Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "finder", "", "adjustRenderer", "(Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)V", "", "getDays", "()I", "", "records", "(Ljava/util/List;)I", "r", "minMaxFinder", "", "prepareYAxis", "(Ljava/util/List;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)Ljava/util/List;", "Ljava/util/Date;", "prepareXAxis", "(Ljava/util/List;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)[Ljava/util/Date;", "filterRecords", "(Ljava/util/List;)Ljava/util/List;", "getHelpUrl", "Ljava/lang/String;", "getTitleString", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "xAxisDates", "[Ljava/util/Date;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DiffExtractorRangeChartBuilder extends AbstractRangeChartBuilder<StatRecord> {
    private final IValueExtractor extractor;
    private final String titleString;
    private Date[] xAxisDates;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffExtractorRangeChartBuilder(Context context, String str, IValueExtractor iValueExtractor) {
        super(context);
        context.getClass();
        iValueExtractor.getClass();
        this.titleString = str;
        this.extractor = iValueExtractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int prepareYAxis$lambda$0$0(StatRecord statRecord, StatRecord statRecord2) {
        return statRecord.getToDate().compareTo(statRecord2.getToDate());
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer renderer, MinMaxFinder finder) {
        renderer.getClass();
        finder.getClass();
        super.adjustRenderer(renderer, finder);
        renderer.setZoomEnabled(false, false);
        renderer.setPanEnabled(true, false);
        renderer.setClickEnabled(false);
        renderer.setDisplayValues(false);
        renderer.addYTextLabel(5.0d, "5");
        renderer.addYTextLabel(10.0d, "10");
        renderer.addYTextLabel(15.0d, "15");
        renderer.addYTextLabel(20.0d, "20");
        renderer.addYTextLabel(25.0d, "25");
        renderer.addYTextLabel(30.0d, "30");
        renderer.addYTextLabel(35.0d, "35");
        renderer.addYTextLabel(40.0d, "40");
        renderer.addYTextLabel(45.0d, "45");
        renderer.addYTextLabel(50.0d, "50");
        renderer.addYTextLabel(55.0d, "55");
        renderer.addYTextLabel(60.0d, "60");
        renderer.addYTextLabel(0.0d, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        renderer.addYTextLabel(-5.0d, "-5");
        renderer.addYTextLabel(-10.0d, "-10");
        renderer.addYTextLabel(-15.0d, "-15");
        renderer.addYTextLabel(-20.0d, "-20");
        renderer.addYTextLabel(-25.0d, "-25");
        renderer.addYTextLabel(-30.0d, "-30");
        renderer.addYTextLabel(-35.0d, "-35");
        renderer.addYTextLabel(-40.0d, "-40");
        renderer.addYTextLabel(-45.0d, "-45");
        renderer.addYTextLabel(-50.0d, "-50");
        renderer.addYTextLabel(-55.0d, "-55");
        renderer.addYTextLabel(-60.0d, "-60");
        renderer.setYLabels(0);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<StatRecord> filterRecords(List<StatRecord> records) {
        return records == null ? new ArrayList() : records;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.irregularity), ColorUtil.i(this.context, R.color.negative)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int getDays() {
        return Math.min(super.getDays(), SleepStats.PERIODS[3]);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        String str = this.titleString;
        return str != null ? str : FileInsert$$ExternalSyntheticOutline0.m$1(this.extractor.getMeasureName(), " (+/-)");
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        String helpUrl = this.extractor.getHelpUrl();
        helpUrl.getClass();
        return helpUrl;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{FileInsert$$ExternalSyntheticOutline0.m(" (+) ", this.extractor.getMeasureName(), "  "), FileInsert$$ExternalSyntheticOutline0.m(" (-) ", this.extractor.getMeasureName(), "  ")};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return FileInsert$$ExternalSyntheticOutline0.m$1(this.extractor.getMeasureName(), " (+/-)");
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractDateChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<StatRecord> records, MinMaxFinder minMaxFinder) {
        if (this.xAxisDates == null) {
            prepareYAxis(records, new MinMaxFinder());
        }
        Date[] dateArr = this.xAxisDates;
        if (dateArr == null) {
            return new Date[0];
        }
        for (Date date : dateArr) {
            if (minMaxFinder != null) {
                minMaxFinder.addDate(date);
            }
        }
        return dateArr;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> r, MinMaxFinder minMaxFinder) {
        if (r == null) {
            return new ArrayList();
        }
        List listAsMutableList = TypeIntrinsics.asMutableList(r);
        if (r.size() == 0) {
            return new ArrayList();
        }
        CollectionsKt.sortWith(listAsMutableList, new Settings$$ExternalSyntheticLambda0(5));
        double[] dArr = new double[listAsMutableList.size() * 4];
        double[] dArr2 = new double[listAsMutableList.size() * 2];
        List list = listAsMutableList;
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            double value = this.extractor.getValue((StatRecord) obj);
            double value2 = i < r.size() + (-1) ? this.extractor.getValue(r.get(i2)) : 0.0d;
            if (value <= 0.0d || value2 <= 0.0d) {
                int i3 = i * 2;
                dArr[i3] = 0.0d;
                int i4 = i3 + 1;
                dArr[i4] = 0.0d;
                dArr2[i3] = 0.0d;
                dArr2[i4] = 0.0d;
            } else {
                int i5 = i;
                if (minMaxFinder != null) {
                    minMaxFinder.addValue(value2 - value);
                }
                if (value < value2) {
                    int i6 = i5 * 2;
                    dArr[i6] = 0.0d;
                    int i7 = i6 + 1;
                    dArr[i7] = value2 - value;
                    dArr2[i6] = 0.0d;
                    dArr2[i7] = 0.0d;
                } else {
                    int i8 = i5 * 2;
                    dArr[i8] = 0.0d;
                    int i9 = i8 + 1;
                    dArr[i9] = 0.0d;
                    dArr2[i8] = 0.0d;
                    dArr2[i9] = value2 - value;
                }
            }
            i = i2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr);
        arrayList.add(dArr2);
        int size = r.size() * 2;
        Date[] dateArr = new Date[size];
        for (int i10 = 0; i10 < size; i10++) {
            dateArr[i10] = new Date();
        }
        this.xAxisDates = dateArr;
        int i11 = 0;
        for (Object obj2 : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            StatRecord statRecord = (StatRecord) obj2;
            int i13 = i11 * 2;
            Date toDate = statRecord.getToDate();
            toDate.getClass();
            dateArr[i13] = toDate;
            Date toDate2 = statRecord.getToDate();
            toDate2.getClass();
            dateArr[i13 + 1] = toDate2;
            i11 = i12;
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int getDays(List<StatRecord> records) {
        return Math.min(super.getDays(records), SleepStats.PERIODS[3]);
    }
}
