package com.urbandroid.sleep.graph;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.sleep.domain.interval.Interval;
import java.util.ArrayList;
import java.util.Collection;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0004\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0004\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0012¢\u0006\u0004\b!\u0010\u0017J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0012¢\u0006\u0004\b#\u0010\u0017J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0012¢\u0006\u0004\b$\u0010\u0017J\u0017\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R$\u0010\u0015\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u00101R$\u0010)\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010/\u001a\u0004\b2\u00101R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b3\u00101R\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010/R$\u0010 \u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b4\u00101R$\u0010\"\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b5\u00101R$\u00106\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b7\u00101R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010.\u001a\u0004\u0018\u00010%8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b9\u0010:R$\u0010;\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=R$\u0010>\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b>\u0010<\u001a\u0004\b>\u0010=R$\u0010?\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b?\u0010=R\"\u0010@\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010<\u001a\u0004\bA\u0010=\"\u0004\bB\u0010CR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010D¨\u0006F"}, d2 = {"Lcom/urbandroid/sleep/graph/IntervalStyle;", "Lcom/urbandroid/sleep/graph/ToggleableGraphElement;", "", "id", "<init>", "(Ljava/lang/String;)V", "", "Lcom/urbandroid/sleep/domain/interval/Interval;", "intervals", "(Ljava/util/Collection;)V", "(Ljava/lang/String;Ljava/util/Collection;)V", "interval", "(Ljava/lang/String;Lcom/urbandroid/sleep/domain/interval/Interval;)V", "", "getIntervals", "()Ljava/util/Collection;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "getColor", "(Landroid/content/Context;)I", "drawable", "setDrawable", "(I)Lcom/urbandroid/sleep/graph/IntervalStyle;", SpotifyService.OFFSET, "setOffset", "", "onlyInZoom", "setOnlyInZoom", "(Z)Lcom/urbandroid/sleep/graph/IntervalStyle;", "color", "setColor", "stroke", "setStroke", "size", "setSize", "setFromSize", "Lcom/urbandroid/sleep/graph/IntervalStyle$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setStyle", "(Lcom/urbandroid/sleep/graph/IntervalStyle$Style;)Lcom/urbandroid/sleep/graph/IntervalStyle;", "patternDrawable", "setPatternDrawable", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", SDKConstants.PARAM_VALUE, "I", "getDrawable", "()I", "getPatternDrawable", "getOffset", "getStroke", "getSize", "fromSize", "getFromSize", "Lcom/urbandroid/sleep/graph/IntervalStyle$Style;", "getStyle", "()Lcom/urbandroid/sleep/graph/IntervalStyle$Style;", "isFilterColor", "Z", "()Z", "isOnTop", "isOnlyInZoom", "visible", "getVisible", "setVisible", "(Z)V", "Ljava/util/Collection;", "Style", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntervalStyle implements ToggleableGraphElement {
    private int color;
    private int drawable;
    private int fromSize;
    private final String id;
    private Collection<Interval> intervals;
    private boolean isFilterColor;
    private boolean isOnTop;
    private boolean isOnlyInZoom;
    private int offset;
    private int patternDrawable;
    private int size;
    private int stroke;
    private Style style;
    private boolean visible;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/graph/IntervalStyle$Style;", "", "<init>", "(Ljava/lang/String;I)V", "LINE", "RECT", "POINT", "MARKER", "BAR", "BAR_ROUND", "RANGE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Style {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Style[] $VALUES;
        public static final Style LINE = new Style("LINE", 0);
        public static final Style RECT = new Style("RECT", 1);
        public static final Style POINT = new Style("POINT", 2);
        public static final Style MARKER = new Style("MARKER", 3);
        public static final Style BAR = new Style("BAR", 4);
        public static final Style BAR_ROUND = new Style("BAR_ROUND", 5);
        public static final Style RANGE = new Style("RANGE", 6);

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{LINE, RECT, POINT, MARKER, BAR, BAR_ROUND, RANGE};
        }

        static {
            Style[] styleArr$values = $values();
            $VALUES = styleArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(styleArr$values);
        }

        private Style(String str, int i) {
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    public IntervalStyle(String str) {
        str.getClass();
        this.id = str;
        this.color = -1;
        this.size = -1;
        this.isOnTop = true;
        this.visible = true;
        this.intervals = new ArrayList();
    }

    public final int getColor(Context context) {
        return this.color;
    }

    public final int getDrawable() {
        return this.drawable;
    }

    public final int getFromSize() {
        return this.fromSize;
    }

    @Override // com.urbandroid.sleep.graph.ToggleableGraphElement
    public String getId() {
        return this.id;
    }

    public final Collection<Interval> getIntervals() {
        return this.intervals;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPatternDrawable() {
        return this.patternDrawable;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getStroke() {
        return this.stroke;
    }

    public final Style getStyle() {
        return this.style;
    }

    public boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: isFilterColor, reason: from getter */
    public final boolean getIsFilterColor() {
        return this.isFilterColor;
    }

    /* JADX INFO: renamed from: isOnlyInZoom, reason: from getter */
    public final boolean getIsOnlyInZoom() {
        return this.isOnlyInZoom;
    }

    public final IntervalStyle setColor(int color) {
        this.color = color;
        return this;
    }

    public final IntervalStyle setDrawable(int drawable) {
        this.drawable = drawable;
        return this;
    }

    public final IntervalStyle setFromSize(int size) {
        this.fromSize = size;
        return this;
    }

    public final IntervalStyle setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public final IntervalStyle setOnlyInZoom(boolean onlyInZoom) {
        this.isOnlyInZoom = onlyInZoom;
        return this;
    }

    public final IntervalStyle setPatternDrawable(int patternDrawable) {
        this.patternDrawable = patternDrawable;
        return this;
    }

    public final IntervalStyle setSize(int size) {
        this.size = size;
        return this;
    }

    public final IntervalStyle setStroke(int stroke) {
        this.stroke = stroke;
        if (this.size == -1) {
            this.size = stroke * 3;
        }
        return this;
    }

    public final IntervalStyle setStyle(Style style) {
        this.style = style;
        return this;
    }

    @Override // com.urbandroid.sleep.graph.ToggleableGraphElement
    public void setVisible(boolean z) {
        this.visible = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntervalStyle(Collection<Interval> collection) {
        this("");
        collection.getClass();
        this.intervals = collection;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntervalStyle(String str, Collection<Interval> collection) {
        this(str);
        str.getClass();
        collection.getClass();
        this.intervals = collection;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntervalStyle(String str, Interval interval) {
        this(str);
        str.getClass();
        interval.getClass();
        ArrayList arrayList = new ArrayList();
        this.intervals = arrayList;
        arrayList.add(interval);
    }
}
