package com.urbandroid.sleep.graph;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.material.chip.Chip;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b2\b\u0086\u0081\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001+BS\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b\r\u0010*j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bH¨\u0006I"}, d2 = {"Lcom/urbandroid/sleep/graph/GraphLegend;", "", "Lcom/urbandroid/sleep/graph/GraphLegendType;", "type", "Lcom/urbandroid/sleep/domain/EventLabel;", "correspondingEventLabel", "", "encapsulatingGraphViewResource", "correspondingGraphViewResource", "iconDrawableOrColorResource", "titleResource", "", "toggleable", "isDashedLine", "<init>", "(Ljava/lang/String;ILcom/urbandroid/sleep/graph/GraphLegendType;Lcom/urbandroid/sleep/domain/EventLabel;Ljava/lang/Integer;Ljava/lang/Integer;IIZZ)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "isResourceColor", "(Landroid/content/Context;)Z", "Lcom/google/android/material/chip/Chip;", "toMaterialChip", "(Landroid/content/Context;)Lcom/google/android/material/chip/Chip;", "", "eventLabelName", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/graph/GraphLegendType;", "getType", "()Lcom/urbandroid/sleep/graph/GraphLegendType;", "Lcom/urbandroid/sleep/domain/EventLabel;", "getCorrespondingEventLabel", "()Lcom/urbandroid/sleep/domain/EventLabel;", "Ljava/lang/Integer;", "getEncapsulatingGraphViewResource", "()Ljava/lang/Integer;", "getCorrespondingGraphViewResource", "I", "getIconDrawableOrColorResource", "()I", "getTitleResource", "Z", "getToggleable", "()Z", "Companion", "ACTIGRAPH", "HYPNOGRAM", "SENSOR_GRAPH", "NOISE_GRAPH", "AWAKE", "REM", "LIGHT_SLEEP", "DEEP_SLEEP", "NO_SLEEP_DATA", "HR", "HRV", "SPO2", "RESPIRATORY_RATE", "SMART_WAKE_UP", "LIGHT", "PAUSED", "ALARM", "SUNRISE", "WALK", "LUCID_DREAMING", "STANDBY", "SNORING", "SLEEP_TALK", "COUGH", "BABY_CRY", "LAUGHTER", "NOISE_RECORDING", "RESPIRATORY_DISTURBANCE", "ANTI_SNORING", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GraphLegend {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GraphLegend[] $VALUES;
    public static final GraphLegend ACTIGRAPH;
    public static final GraphLegend ALARM;
    public static final GraphLegend ANTI_SNORING;
    public static final GraphLegend AWAKE;
    public static final GraphLegend BABY_CRY;
    public static final GraphLegend COUGH;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final GraphLegend DEEP_SLEEP;
    public static final GraphLegend HR;
    public static final GraphLegend HRV;
    public static final GraphLegend HYPNOGRAM;
    public static final GraphLegend LAUGHTER;
    public static final GraphLegend LIGHT;
    public static final GraphLegend LIGHT_SLEEP;
    public static final GraphLegend LUCID_DREAMING;
    public static final GraphLegend NOISE_GRAPH;
    public static final GraphLegend NOISE_RECORDING;
    public static final GraphLegend NO_SLEEP_DATA;
    public static final GraphLegend PAUSED;
    public static final GraphLegend REM;
    public static final GraphLegend RESPIRATORY_DISTURBANCE;
    public static final GraphLegend RESPIRATORY_RATE;
    public static final GraphLegend SENSOR_GRAPH;
    public static final GraphLegend SLEEP_TALK;
    public static final GraphLegend SMART_WAKE_UP;
    public static final GraphLegend SNORING;
    public static final GraphLegend SPO2;
    public static final GraphLegend STANDBY;
    public static final GraphLegend SUNRISE;
    public static final GraphLegend WALK;
    private final EventLabel correspondingEventLabel;
    private final Integer correspondingGraphViewResource;
    private final Integer encapsulatingGraphViewResource;
    private final int iconDrawableOrColorResource;
    private final boolean isDashedLine;
    private final int titleResource;
    private final boolean toggleable;
    private final GraphLegendType type;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/graph/GraphLegend$Companion;", "", "<init>", "()V", "findByEventLabel", "Lcom/urbandroid/sleep/graph/GraphLegend;", "eventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "getTopLevelCharts", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GraphLegend findByEventLabel(EventLabel eventLabel) {
            eventLabel.getClass();
            for (GraphLegend graphLegend : GraphLegend.values()) {
                if (graphLegend.getCorrespondingEventLabel() == eventLabel) {
                    return graphLegend;
                }
            }
            return null;
        }

        public final List<GraphLegend> getTopLevelCharts() {
            GraphLegend[] graphLegendArrValues = GraphLegend.values();
            ArrayList arrayList = new ArrayList();
            for (GraphLegend graphLegend : graphLegendArrValues) {
                if (graphLegend.getType() == GraphLegendType.TOP_LEVEL_CHART) {
                    arrayList.add(graphLegend);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ GraphLegend[] $values() {
        return new GraphLegend[]{ACTIGRAPH, HYPNOGRAM, SENSOR_GRAPH, NOISE_GRAPH, AWAKE, REM, LIGHT_SLEEP, DEEP_SLEEP, NO_SLEEP_DATA, HR, HRV, SPO2, RESPIRATORY_RATE, SMART_WAKE_UP, LIGHT, PAUSED, ALARM, SUNRISE, WALK, LUCID_DREAMING, STANDBY, SNORING, SLEEP_TALK, COUGH, BABY_CRY, LAUGHTER, NOISE_RECORDING, RESPIRATORY_DISTURBANCE, ANTI_SNORING};
    }

    static {
        GraphLegendType graphLegendType = GraphLegendType.TOP_LEVEL_CHART;
        Integer numValueOf = Integer.valueOf(R.id.graph);
        boolean z = false;
        ACTIGRAPH = new GraphLegend("ACTIGRAPH", 0, graphLegendType, null, numValueOf, numValueOf, R.drawable.ic_action_actigraph, R.string.actigraph, false, z, 192, null);
        Integer numValueOf2 = Integer.valueOf(R.id.hypnogram);
        int i = 192;
        DefaultConstructorMarker defaultConstructorMarker = null;
        EventLabel eventLabel = null;
        boolean z2 = false;
        HYPNOGRAM = new GraphLegend("HYPNOGRAM", 1, graphLegendType, eventLabel, numValueOf2, numValueOf2, R.drawable.ic_action_graph, R.string.hypnogram, z, z2, i, defaultConstructorMarker);
        Integer numValueOf3 = Integer.valueOf(R.id.sensor_graph);
        SENSOR_GRAPH = new GraphLegend("SENSOR_GRAPH", 2, graphLegendType, eventLabel, numValueOf3, numValueOf3, R.drawable.ic_action_chart, R.string.sensor_graph, z, z2, i, defaultConstructorMarker);
        Integer numValueOf4 = Integer.valueOf(R.id.noise_graph);
        NOISE_GRAPH = new GraphLegend("NOISE_GRAPH", 3, graphLegendType, eventLabel, numValueOf4, numValueOf4, R.drawable.ic_action_noise_graph, R.string.noise_chart, z, z2, i, defaultConstructorMarker);
        GraphLegendType graphLegendType2 = GraphLegendType.HYPNOGRAM;
        Integer num = null;
        boolean z3 = false;
        AWAKE = new GraphLegend("AWAKE", 4, graphLegendType2, EventLabel.AWAKE_START, null, num, R.color.awake, R.string.awake, z2, z3, 128, null);
        EventLabel eventLabel2 = EventLabel.REM_START;
        int i2 = 128;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        Integer num2 = null;
        int i3 = R.color.light_sleep;
        boolean z4 = false;
        REM = new GraphLegend("REM", 5, graphLegendType2, eventLabel2, num, num2, i3, R.string.rem, z3, z4, i2, defaultConstructorMarker2);
        LIGHT_SLEEP = new GraphLegend("LIGHT_SLEEP", 6, graphLegendType2, EventLabel.LIGHT_START, num, num2, i3, R.string.label_light_sleep, z3, z4, i2, defaultConstructorMarker2);
        DEEP_SLEEP = new GraphLegend("DEEP_SLEEP", 7, graphLegendType2, EventLabel.DEEP_START, num, num2, R.color.deep_sleep, R.string.label_deep_sleep, z3, z4, i2, defaultConstructorMarker2);
        NO_SLEEP_DATA = new GraphLegend("NO_SLEEP_DATA", 8, graphLegendType2, EventLabel.BROKEN_START, num, num2, R.color.no_sleep_data, R.string.no_data, z3, z4, i2, defaultConstructorMarker2);
        GraphLegendType graphLegendType3 = GraphLegendType.SENSOR_GRAPH;
        Integer num3 = null;
        boolean z5 = false;
        HR = new GraphLegend("HR", 9, graphLegendType3, EventLabel.HR, num2, num3, R.color.red, R.string.hr_short, z4, z5, 192, null);
        int i4 = 192;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        Integer num4 = null;
        boolean z6 = false;
        HRV = new GraphLegend("HRV", 10, graphLegendType3, EventLabel.SDNN, num3, num4, R.color.hrv, R.string.hrv_short, z5, z6, i4, defaultConstructorMarker3);
        SPO2 = new GraphLegend("SPO2", 11, graphLegendType3, EventLabel.SPO2, num3, num4, R.color.spo2, R.string.spo2, z5, z6, i4, defaultConstructorMarker3);
        RESPIRATORY_RATE = new GraphLegend("RESPIRATORY_RATE", 12, graphLegendType3, EventLabel.RR, num3, num4, R.color.normal, R.string.rr, z5, z6, i4, defaultConstructorMarker3);
        SMART_WAKE_UP = new GraphLegend("SMART_WAKE_UP", 13, graphLegendType3, EventLabel.ALARM_EARLIEST, num3, num4, R.color.smart_wake_up, R.string.settings_category_smart, z5, true, 64, defaultConstructorMarker3);
        GraphLegendType graphLegendType4 = GraphLegendType.ACTIGRAPH;
        Integer num5 = null;
        boolean z7 = false;
        LIGHT = new GraphLegend("LIGHT", 14, graphLegendType4, EventLabel.LUX, num4, num5, R.color.t3a, R.string.light, false, z7, 192, null);
        int i5 = 192;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        Integer num6 = null;
        boolean z8 = false;
        PAUSED = new GraphLegend("PAUSED", 15, graphLegendType4, EventLabel.TRACKING_PAUSED, num5, num6, R.drawable.ic_action_pause_small, R.string.pause, z7, z8, i5, defaultConstructorMarker4);
        ALARM = new GraphLegend("ALARM", 16, graphLegendType4, EventLabel.ALARM_STARTED, num5, num6, R.drawable.ic_alarm, R.string.default_label, z7, z8, i5, defaultConstructorMarker4);
        EventLabel eventLabel3 = EventLabel.DHA;
        SUNRISE = new GraphLegend("SUNRISE", 17, graphLegendType4, eventLabel3, num5, num6, R.drawable.ic_action_sunrise, R.string.sunrise, z7, z8, i5, defaultConstructorMarker4);
        WALK = new GraphLegend("WALK", 18, graphLegendType4, EventLabel.WALKING_START, num5, num6, R.drawable.ic_walk, R.string.walk, z7, z8, i5, defaultConstructorMarker4);
        LUCID_DREAMING = new GraphLegend("LUCID_DREAMING", 19, graphLegendType4, EventLabel.LUCID_CUE, num5, num6, R.drawable.ic_action_dream, R.string.settings_category_lucid_title, z7, z8, i5, defaultConstructorMarker4);
        STANDBY = new GraphLegend("STANDBY", 20, graphLegendType4, EventLabel.LOW_BATTERY, num5, num6, R.drawable.ic_battery_60, R.string.low_battery, z7, z8, i5, defaultConstructorMarker4);
        GraphLegendType graphLegendType5 = GraphLegendType.NOISE_GRAPH;
        Integer num7 = null;
        boolean z9 = false;
        SNORING = new GraphLegend("SNORING", 21, graphLegendType5, EventLabel.SNORING, num6, num7, R.drawable.ic_action_noise, R.string.stats_caption_snore, z8, z9, 192, null);
        int i6 = 192;
        DefaultConstructorMarker defaultConstructorMarker5 = null;
        Integer num8 = null;
        boolean z10 = false;
        SLEEP_TALK = new GraphLegend("SLEEP_TALK", 22, graphLegendType5, EventLabel.TALK, num7, num8, R.drawable.ic_action_talk, R.string.sleep_talk, z9, z10, i6, defaultConstructorMarker5);
        COUGH = new GraphLegend("COUGH", 23, graphLegendType5, EventLabel.SICK, num7, num8, R.drawable.ic_action_sick, R.string.sound_sick, z9, z10, i6, defaultConstructorMarker5);
        BABY_CRY = new GraphLegend("BABY_CRY", 24, graphLegendType5, EventLabel.BABY, num7, num8, R.drawable.ic_action_baby, R.string.sound_baby_cry, z9, z10, i6, defaultConstructorMarker5);
        LAUGHTER = new GraphLegend("LAUGHTER", 25, graphLegendType5, EventLabel.LAUGH, num7, num8, R.drawable.ic_action_laugh, R.string.sound_laughter, z9, z10, i6, defaultConstructorMarker5);
        NOISE_RECORDING = new GraphLegend("NOISE_RECORDING", 26, graphLegendType5, eventLabel3, null, null, R.drawable.ic_action_mic, R.string.sleep_noise_recording_category, false, false, 192, null);
        int i7 = 192;
        DefaultConstructorMarker defaultConstructorMarker6 = null;
        Integer num9 = null;
        Integer num10 = null;
        boolean z11 = false;
        boolean z12 = false;
        RESPIRATORY_DISTURBANCE = new GraphLegend("RESPIRATORY_DISTURBANCE", 27, graphLegendType5, EventLabel.RDI, num9, num10, R.drawable.ic_action_cpap, R.string.rr_disturbace, z11, z12, i7, defaultConstructorMarker6);
        ANTI_SNORING = new GraphLegend("ANTI_SNORING", 28, graphLegendType5, EventLabel.ANTISNORE, num9, num10, R.drawable.ic_anti_snoring, R.string.anti_snoring_title, z11, z12, i7, defaultConstructorMarker6);
        GraphLegend[] graphLegendArr$values = $values();
        $VALUES = graphLegendArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(graphLegendArr$values);
        INSTANCE = new Companion(null);
    }

    public /* synthetic */ GraphLegend(String str, int i, GraphLegendType graphLegendType, EventLabel eventLabel, Integer num, Integer num2, int i2, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, graphLegendType, eventLabel, num, num2, i2, i3, (i4 & 64) != 0 ? true : z, (i4 & 128) != 0 ? false : z2);
    }

    private final boolean isResourceColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(this.iconDrawableOrColorResource, typedValue, true);
        int i = typedValue.type;
        return i >= 28 && i <= 31;
    }

    public static GraphLegend valueOf(String str) {
        return (GraphLegend) Enum.valueOf(GraphLegend.class, str);
    }

    public static GraphLegend[] values() {
        return (GraphLegend[]) $VALUES.clone();
    }

    public final String eventLabelName() {
        String strName;
        EventLabel eventLabel = this.correspondingEventLabel;
        return (eventLabel == null || (strName = eventLabel.name()) == null) ? name() : strName;
    }

    public final EventLabel getCorrespondingEventLabel() {
        return this.correspondingEventLabel;
    }

    public final Integer getCorrespondingGraphViewResource() {
        return this.correspondingGraphViewResource;
    }

    public final Integer getEncapsulatingGraphViewResource() {
        return this.encapsulatingGraphViewResource;
    }

    public final int getIconDrawableOrColorResource() {
        return this.iconDrawableOrColorResource;
    }

    public final int getTitleResource() {
        return this.titleResource;
    }

    public final boolean getToggleable() {
        return this.toggleable;
    }

    public final GraphLegendType getType() {
        return this.type;
    }

    public final Chip toMaterialChip(Context context) {
        context.getClass();
        View viewInflate = InflatorUtil.INSTANCE.get(context).inflate(R.layout.button_graph_legend, (ViewGroup) null);
        viewInflate.getClass();
        Chip chip = (Chip) viewInflate;
        chip.setTag(name());
        chip.setText(context.getText(this.titleResource));
        if (!isResourceColor(context)) {
            chip.setCheckedIcon(context.getDrawable(this.iconDrawableOrColorResource));
            return chip;
        }
        Drawable drawable = context.getDrawable(R.drawable.line_for_legend_chip);
        drawable.getClass();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.legend_chip_stroke_width);
        float dimension = context.getResources().getDimension(R.dimen.legend_chip_dash_width);
        float dimension2 = context.getResources().getDimension(R.dimen.legend_chip_dash_gap);
        int color = context.getColor(this.iconDrawableOrColorResource);
        if (this.isDashedLine) {
            gradientDrawable.setStroke(dimensionPixelSize, color, dimension, dimension2);
        } else {
            gradientDrawable.setStroke(dimensionPixelSize, color);
        }
        chip.setCheckedIcon(gradientDrawable);
        return chip;
    }

    private GraphLegend(String str, int i, GraphLegendType graphLegendType, EventLabel eventLabel, Integer num, Integer num2, int i2, int i3, boolean z, boolean z2) {
        this.type = graphLegendType;
        this.correspondingEventLabel = eventLabel;
        this.encapsulatingGraphViewResource = num;
        this.correspondingGraphViewResource = num2;
        this.iconDrawableOrColorResource = i2;
        this.titleResource = i3;
        this.toggleable = z;
        this.isDashedLine = z2;
    }
}
