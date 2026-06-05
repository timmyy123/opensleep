package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjn {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature[] zzj;

    static {
        Feature feature = new Feature("commit_to_configuration_v2_api", 1L, true);
        zza = feature;
        Feature feature2 = new Feature("get_serving_version_api", 1L, true);
        zzb = feature2;
        Feature feature3 = new Feature("get_experiment_tokens_api", 1L, true);
        zzc = feature3;
        Feature feature4 = new Feature("register_flag_update_listener_api", 2L, true);
        zzd = feature4;
        Feature feature5 = new Feature("sync_after_api", 1L, true);
        zze = feature5;
        Feature feature6 = new Feature("sync_after_for_application_api", 1L, true);
        zzf = feature6;
        Feature feature7 = new Feature("set_app_wide_properties_api", 1L, true);
        zzg = feature7;
        Feature feature8 = new Feature("set_runtime_properties_api", 1L, true);
        zzh = feature8;
        Feature feature9 = new Feature("get_storage_info_api", 1L, true);
        zzi = feature9;
        zzj = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9};
    }
}
