package com.google.android.gms.fitness;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzf {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature[] zze;

    static {
        Feature feature = new Feature("temp_data_point_changelogs", 1L);
        zza = feature;
        Feature feature2 = new Feature("temp_session_changelogs", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("temp_data_source_changelogs", 1L);
        zzc = feature3;
        Feature feature4 = new Feature("local_no_account_mode", 1L);
        zzd = feature4;
        zze = new Feature[]{feature, feature2, feature3, feature4};
    }
}
