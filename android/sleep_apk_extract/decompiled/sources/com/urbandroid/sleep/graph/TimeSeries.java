package com.urbandroid.sleep.graph;

import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/graph/TimeSeries;", "Lcom/urbandroid/sleep/graph/ToggleableGraphElement;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "series", "", "", "", "getSeries", "()Ljava/util/Map;", "color", "", "cornerPath", "", "doBreaks", "drawValues", "yRangeMin", "Ljava/lang/Float;", "yRangeMax", "breakThreshold", "yScale", "Lcom/urbandroid/sleep/graph/TimeSeries$AxisScale;", "scaleYValue", "y", "visible", "getVisible", "()Z", "setVisible", "(Z)V", "AxisScale", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TimeSeries implements ToggleableGraphElement {
    public long breakThreshold;
    public int color;
    public boolean cornerPath;
    public boolean doBreaks;
    public boolean drawValues;
    private final String id;
    private final Map<Long, Float> series;
    private boolean visible;
    public Float yRangeMax;
    public Float yRangeMin;
    public AxisScale yScale;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/graph/TimeSeries$AxisScale;", "", "<init>", "(Ljava/lang/String;I)V", "LINEAR", "LOGARITHMIC", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AxisScale {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AxisScale[] $VALUES;
        public static final AxisScale LINEAR = new AxisScale("LINEAR", 0);
        public static final AxisScale LOGARITHMIC = new AxisScale("LOGARITHMIC", 1);

        private static final /* synthetic */ AxisScale[] $values() {
            return new AxisScale[]{LINEAR, LOGARITHMIC};
        }

        static {
            AxisScale[] axisScaleArr$values = $values();
            $VALUES = axisScaleArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(axisScaleArr$values);
        }

        private AxisScale(String str, int i) {
        }

        public static AxisScale valueOf(String str) {
            return (AxisScale) Enum.valueOf(AxisScale.class, str);
        }

        public static AxisScale[] values() {
            return (AxisScale[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AxisScale.values().length];
            try {
                iArr[AxisScale.LOGARITHMIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TimeSeries(String str) {
        str.getClass();
        this.id = str;
        this.series = new TreeMap();
        this.cornerPath = true;
        this.drawValues = true;
        this.breakThreshold = 900000L;
        this.yScale = AxisScale.LINEAR;
        this.visible = true;
    }

    @Override // com.urbandroid.sleep.graph.ToggleableGraphElement
    public String getId() {
        return this.id;
    }

    public final Map<Long, Float> getSeries() {
        return this.series;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public final float scaleYValue(float y) {
        if (WhenMappings.$EnumSwitchMapping$0[this.yScale.ordinal()] != 1) {
            return y;
        }
        if (y <= 0.0f) {
            return 0.0f;
        }
        return (float) Math.log(y);
    }

    @Override // com.urbandroid.sleep.graph.ToggleableGraphElement
    public void setVisible(boolean z) {
        this.visible = z;
    }
}
