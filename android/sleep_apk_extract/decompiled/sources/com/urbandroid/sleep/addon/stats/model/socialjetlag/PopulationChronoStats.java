package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PopulationChronoStats {
    private static final TreeMap<Float, Float> MID_SLEEP_ON_FREE_DAYS_DISTRIBUTION;
    private static final TreeMap<Float, Float> MID_SLEEP_ON_FREE_DAYS_HIST;

    static {
        TreeMap<Float, Float> treeMap = new TreeMap<>();
        MID_SLEEP_ON_FREE_DAYS_DISTRIBUTION = treeMap;
        TreeMap<Float, Float> treeMap2 = new TreeMap<>();
        MID_SLEEP_ON_FREE_DAYS_HIST = treeMap2;
        Float fValueOf = Float.valueOf(Float.NEGATIVE_INFINITY);
        Float fValueOf2 = Float.valueOf(0.0f);
        treeMap.put(fValueOf, fValueOf2);
        Float fM = zza$$ExternalSyntheticOutline0.m(0.4f, treeMap, zza$$ExternalSyntheticOutline0.m(0.3f, treeMap, zza$$ExternalSyntheticOutline0.m(0.2f, treeMap, zza$$ExternalSyntheticOutline0.m(0.1f, treeMap, Float.valueOf(2.76f), 3.43f), 3.92f), 4.37f), 4.79f);
        Float fValueOf3 = Float.valueOf(0.5f);
        treeMap.put(fM, fValueOf3);
        Float fM2 = zza$$ExternalSyntheticOutline0.m(0.7f, treeMap, zza$$ExternalSyntheticOutline0.m(0.6f, treeMap, Float.valueOf(5.26f), 5.8f), 6.5f);
        Float fM3 = zza$$ExternalSyntheticOutline0.m(0.9f, treeMap, zza$$ExternalSyntheticOutline0.m(0.8f, treeMap, fM2, 7.65f), -0.5f);
        Float fValueOf4 = Float.valueOf(1.0f);
        treeMap2.put(fM3, fValueOf4);
        treeMap2.put(fValueOf2, fValueOf4);
        treeMap2.put(Float.valueOf(0.25f), fValueOf4);
        Float fValueOf5 = Float.valueOf(3.0f);
        treeMap2.put(fValueOf3, fValueOf5);
        Float fValueOf6 = Float.valueOf(6.0f);
        treeMap2.put(fValueOf4, fValueOf6);
        Float fValueOf7 = Float.valueOf(1.25f);
        Float fValueOf8 = Float.valueOf(5.0f);
        treeMap2.put(fValueOf7, fValueOf8);
        Float fValueOf9 = Float.valueOf(1.5f);
        Float fValueOf10 = Float.valueOf(7.0f);
        treeMap2.put(fValueOf9, fValueOf10);
        Float fValueOf11 = Float.valueOf(1.75f);
        Float fValueOf12 = Float.valueOf(8.0f);
        treeMap2.put(fValueOf11, fValueOf12);
        Float fValueOf13 = Float.valueOf(2.0f);
        treeMap2.put(zza$$ExternalSyntheticOutline0.m(58.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(38.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(18.0f, treeMap2, fValueOf13, 2.25f), 2.5f), 2.75f), Float.valueOf(78.0f));
        treeMap2.put(fValueOf5, Float.valueOf(127.0f));
        Float fM4 = zza$$ExternalSyntheticOutline0.m(286.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(205.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(187.0f, treeMap2, Float.valueOf(3.25f), 3.5f), 3.75f), 4.0f);
        Float fM5 = zza$$ExternalSyntheticOutline0.m(312.0f, treeMap2, fM4, 4.25f);
        Float fValueOf14 = Float.valueOf(360.0f);
        treeMap2.put(fM5, fValueOf14);
        treeMap2.put(Float.valueOf(4.5f), Float.valueOf(351.0f));
        treeMap2.put(Float.valueOf(4.75f), fValueOf14);
        treeMap2.put(zza$$ExternalSyntheticOutline0.m(299.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(323.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(357.0f, treeMap2, fValueOf8, 5.25f), 5.5f), 5.75f), Float.valueOf(261.0f));
        treeMap2.put(fValueOf6, Float.valueOf(230.0f));
        treeMap2.put(Float.valueOf(6.25f), Float.valueOf(183.0f));
        treeMap2.put(fM2, Float.valueOf(166.0f));
        treeMap2.put(Float.valueOf(6.75f), Float.valueOf(142.0f));
        treeMap2.put(fValueOf10, Float.valueOf(99.0f));
        treeMap2.put(zza$$ExternalSyntheticOutline0.m(57.0f, treeMap2, zza$$ExternalSyntheticOutline0.m(76.0f, treeMap2, Float.valueOf(7.25f), 7.5f), 7.75f), Float.valueOf(55.0f));
        Float fValueOf15 = Float.valueOf(25.0f);
        treeMap2.put(fValueOf12, fValueOf15);
        treeMap2.put(Float.valueOf(8.25f), Float.valueOf(29.0f));
        treeMap2.put(Float.valueOf(8.5f), fValueOf15);
        Float fValueOf16 = Float.valueOf(8.75f);
        Float fValueOf17 = Float.valueOf(9.0f);
        treeMap2.put(fValueOf16, fValueOf17);
        Float fValueOf18 = Float.valueOf(14.0f);
        treeMap2.put(fValueOf17, fValueOf18);
        treeMap2.put(Float.valueOf(9.25f), fM4);
        treeMap2.put(Float.valueOf(9.5f), fValueOf6);
        treeMap2.put(Float.valueOf(9.75f), fValueOf5);
        treeMap2.put(Float.valueOf(10.0f), fValueOf13);
        treeMap2.put(Float.valueOf(10.5f), fValueOf13);
        treeMap2.put(Float.valueOf(10.75f), fValueOf4);
        treeMap2.put(Float.valueOf(11.0f), fValueOf13);
        treeMap2.put(Float.valueOf(11.75f), fValueOf4);
        treeMap2.put(fValueOf18, fValueOf4);
    }

    public static float getChronotypeQuantile(float f) {
        return MID_SLEEP_ON_FREE_DAYS_DISTRIBUTION.floorEntry(Float.valueOf(f)).getValue().floatValue();
    }

    public static int getChronotypeRank(float f) {
        if (f > 0.0f && f < 1.0f) {
            return f < 0.5f ? Math.round((0.5f - f) * 10.0f) : Math.round((f - 0.5f) * 10.0f) + 1;
        }
        return 5;
    }

    public static SortedMap<Float, Float> getMidSleepOnFreeDaysHistogram() {
        return Collections.unmodifiableSortedMap(MID_SLEEP_ON_FREE_DAYS_HIST);
    }
}
