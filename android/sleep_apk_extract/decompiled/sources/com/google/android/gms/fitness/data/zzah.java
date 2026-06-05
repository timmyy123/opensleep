package com.google.android.gms.fitness.data;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzah {
    public static final double zza = 1.0E-8d;
    public static final double zzb = 5.555555555555555E-10d;
    public static final double zzc = 1.0E-7d;
    public static final Set zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList("altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type")));
    private static final zzah zzg = new zzah();
    private final Map zze;
    private final Map zzf;

    private zzah() {
        HashMap map = new HashMap();
        map.put("latitude", new zzag(-90.0d, 90.0d, null));
        map.put("longitude", new zzag(-180.0d, 180.0d, null));
        map.put("accuracy", new zzag(0.0d, 10000.0d, null));
        map.put("bpm", new zzag(0.0d, 1000.0d, null));
        map.put("altitude", new zzag(-100000.0d, 100000.0d, null));
        map.put("percentage", new zzag(0.0d, 100.0d, null));
        map.put("confidence", new zzag(0.0d, 100.0d, null));
        map.put("duration", new zzag(0.0d, 9.223372036854776E18d, null));
        map.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, new zzag(0.0d, 3.0d, null));
        map.put("weight", new zzag(0.0d, 1000.0d, null));
        map.put("speed", new zzag(0.0d, 11000.0d, null));
        this.zzf = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("com.google.step_count.delta", zzd("steps", new zzag(0.0d, zza, null)));
        map2.put("com.google.calories.expended", zzd("calories", new zzag(0.0d, zzb, null)));
        map2.put("com.google.distance.delta", zzd("distance", new zzag(0.0d, zzc, null)));
        this.zze = Collections.unmodifiableMap(map2);
    }

    public static zzah zzc() {
        return zzg;
    }

    private static Map zzd(Object obj, Object obj2) {
        HashMap map = new HashMap();
        map.put(obj, obj2);
        return map;
    }

    public final zzag zza(String str) {
        return (zzag) this.zzf.get(str);
    }

    public final zzag zzb(String str, String str2) {
        Map map = (Map) this.zze.get(str);
        if (map != null) {
            return (zzag) map.get(str2);
        }
        return null;
    }
}
