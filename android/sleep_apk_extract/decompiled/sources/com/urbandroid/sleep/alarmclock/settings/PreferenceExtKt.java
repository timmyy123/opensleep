package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\")\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/preference/Preference;", "", "searchTerm", "", "matches", "(Landroid/preference/Preference;Ljava/lang/String;)Z", "", "", "keywordMap", "Ljava/util/Map;", "getKeywordMap", "()Ljava/util/Map;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class PreferenceExtKt {
    private static final Map<String, List<String>> keywordMap = MapsKt.mapOf(TuplesKt.to("sleep_time_suggestion_selected_mode", CollectionsKt.listOf((Object[]) new String[]{"notification", "estimate", "suggestion"})), TuplesKt.to("selected_wearable", CollectionsKt.listOf((Object[]) new String[]{"garmin", "mi band", "miband", "amazfit", "xiaomi", "pebble", "wear os", "fitbit", "samsung", "gear", "polar"})), TuplesKt.to("non_deep_sleep_method", CollectionsKt.listOf((Object[]) new String[]{"accelerometer", "sonar", "ultrasound"})), TuplesKt.to("theme", CollectionsKt.listOf((Object[]) new String[]{"dark", "night"})));

    public static final boolean matches(Preference preference, String str) {
        preference.getClass();
        str.getClass();
        if (str.length() == 0) {
            return false;
        }
        if (preference.getTitle() != null) {
            String lowerCase = preference.getTitle().toString().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (StringsKt.contains$default(lowerCase, str) && !Intrinsics.areEqual("Advance settings", preference.getTitle())) {
                return true;
            }
        }
        if (preference.getSummary() != null) {
            String lowerCase2 = preference.getSummary().toString().toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            if (StringsKt.contains$default(lowerCase2, str)) {
                return true;
            }
        }
        List<String> list = keywordMap.get(preference.getKey());
        if (list == null) {
            return false;
        }
        List<String> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            String lowerCase3 = ((String) it.next()).toLowerCase(Locale.ROOT);
            lowerCase3.getClass();
            if (StringsKt.contains$default(lowerCase3, str)) {
                return true;
            }
        }
        return false;
    }
}
