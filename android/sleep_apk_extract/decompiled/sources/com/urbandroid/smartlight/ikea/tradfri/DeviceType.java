package com.urbandroid.smartlight.ikea.tradfri;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/DeviceType;", "", "<init>", "()V", "isColor", "", "name", "", "isCt", "isDim", "has", "", "str", "isBulbGUCt", "isBulbGUDim", "isWsBulb", "isColorBulb", "m7827e", "isPanel", "isTransformer", "isOutlet", "isDoor", "isBlinder", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceType {
    public static final DeviceType INSTANCE = new DeviceType();

    private DeviceType() {
    }

    private final boolean has(List<String> list, String str) {
        List<String> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), str, true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isBlinder(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"FYRTUR block-out roller blind", "KADRILJ roller blind"}), str);
    }

    public final boolean isBulbGUCt(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI bulb GU10 WS 400lm", "TRADFRI bulb GU10 WS2 400lm"}), str);
    }

    public final boolean isBulbGUDim(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI bulb GU10 W 400lm", "TRADFRI bulb GU10 WW 400lm"}), str);
    }

    public final boolean isColor(String name) {
        name.getClass();
        return StringsKt.contains$default(name, " C/WS ") || StringsKt.contains$default(name, " CWS ");
    }

    public final boolean isColorBulb(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI bulb E27 C/WS opal 600lm", "TRADFRI bulb E14 C/WS opal 600lm", "TRADFRI bulb E27 C/WS opal 600", "TRADFRI bulb E27 CWS opal 600", "TRADFRI bulb E26 CWS opal 600", "TRADFRI bulb E14 CWS opal 600", "TRADFRI bulb E12 CWS opal 600", "TRADFRI bulb E27 CWS opal 600lm", "TRADFRI bulb E26 CWS opal 600lm", "TRADFRI bulb E14 CWS opal 600lm", "TRADFRI bulb E12 CWS opal 600lm", "TRADFRI bulb E17 CWS opal 600lm"}), str);
    }

    public final boolean isCt(String name) {
        name.getClass();
        return StringsKt.contains$default(name, " WS ") || StringsKt.contains$default(name, " WS2 ") || isPanel(name);
    }

    public final boolean isDim(String name) {
        name.getClass();
        return isBlinder(name) || isTransformer(name) || isDoor(name) || isBulbGUDim(name) || m7827e(name);
    }

    public final boolean isDoor(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"SURTE door WS 38x64", "JORMLIEN door WS 40x80"}), str);
    }

    public final boolean isOutlet(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI control outlet 16A", "TRADFRI control outlet"}), str);
    }

    public final boolean isPanel(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"FLOALT panel WS 30x30", "FLOALT panel WS 30x90", "GUNNARP panel 40*40", "GUNNARP panel round", "FLOALT panel WS 60x60"}), str);
    }

    public final boolean isTransformer(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI transformer 10W", "TRADFRI transformer 30W", "SKENSTA transformer 30W", "SKENSTA transformer 90W", "TRADFRI Driver 10W", "TRADFRI Driver 30W"}), str);
    }

    public final boolean isWsBulb(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI bulb E27 WS clear 950lm", "TRADFRI bulb E27 WS opal 950lm", "TRADFRI bulb E14 WS opal 400lm", "TRADFRI bulb E12 WS opal 400lm", "TRADFRI bulb E26 WS clear 950lm", "TRADFRI bulb E26 WS opal 980lm", "TRADFRI bulb E27 WS opal 980lm", "TRADFRI bulb E17 WS opal 400lm", "TRADFRI bulb E12 WS opal 600lm", "TRADFRI bulb E14 WS opal 600lm", "TRADFRI bulb E17 WS opal 600lm", "TRADFRI bulb E26 WS opal 1000lm", "TRADFRI bulb E27 WS opal 1000lm", "TRADFRI bulb E26 WS clear 806lm", "TRADFRI bulb E27 WS clear 806lm", "TRADFRI bulb E12 WS2 opal 600lm", "TRADFRI bulb E14 WS2 opal 600lm", "TRADFRI bulb E17 WS2 opal 600lm", "TRADFRI bulb E26 WS2 opal 1000lm", "TRADFRI bulb E27 WS2 opal 1000lm", "TRADFRI bulb E26 WS2 clear 806lm", "TRADFRI bulb E27 WS2 clear 806lm", "TRADFRI bulb E14 WS 470lm", "TRADFRI bulb E12 WS 470lm", "TRADFRI bulb E17 WS 470lm", "TRADFRI bulb E12 WS 450lm", "TRADFRI bulb E17 WS 440lm"}), str);
    }

    public final boolean m7827e(String str) {
        str.getClass();
        return has(CollectionsKt.listOf((Object[]) new String[]{"TRADFRI bulb E26 opal 1000lm", "TRADFRI bulb E27 opal 1000lm", "TRADFRI bulb E26 W opal 1000lm", "TRADFRI bulb E27 W opal 1000lm", "TRADFRI bulb E14 W op/ch 400lm", "TRADFRI bulb E12 W op/ch 400lm", "TRADFRI bulb E17 W op/ch 400lm", "TRADFRI bulb E27 WW 806lm", "TRADFRI bulb E26 WW 806lm", "TRADFRI bulb E27 WW clear 250lm", "TRADFRI bulb E26 WW clear 250lm"}), str);
    }
}
