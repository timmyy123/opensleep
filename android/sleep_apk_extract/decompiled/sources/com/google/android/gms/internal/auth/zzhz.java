package com.google.android.gms.internal.auth;

import android.util.Base64;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhz implements zzhx {
    public static final zzdc zza;
    public static final zzdc zzb;
    public static final zzdc zzc;
    public static final zzdc zzd;
    public static final zzdc zze;
    public static final zzdc zzf;
    public static final zzdc zzg;
    public static final zzdc zzh;
    public static final zzdc zzi;
    public static final zzdc zzj;
    public static final zzdc zzk;
    public static final zzdc zzl;
    public static final zzdc zzm;

    static {
        zzcz zzczVarZza = new zzcz(zzcr.zza("com.google.android.gms.auth_account")).zzb().zza();
        zza = zzczVarZza.zzc("getTokenRefactor__account_data_service_sample_percentage", 0.0d);
        zzb = zzczVarZza.zze("getTokenRefactor__account_data_service_tokenAPI_usable", true);
        zzc = zzczVarZza.zzd("getTokenRefactor__account_manager_timeout_seconds", 20L);
        zzd = zzczVarZza.zzd("getTokenRefactor__android_id_shift", 0L);
        try {
            zze = zzczVarZza.zzf("getTokenRefactor__blocked_packages", zzhs.zzp(Base64.decode("ChNjb20uYW5kcm9pZC52ZW5kaW5nCiBjb20uZ29vZ2xlLmFuZHJvaWQuYXBwcy5tZWV0aW5ncwohY29tLmdvb2dsZS5hbmRyb2lkLmFwcHMubWVzc2FnaW5n", 3)), zzhy.zza);
            zzf = zzczVarZza.zze("getTokenRefactor__chimera_get_token_evolved", true);
            zzg = zzczVarZza.zzd("getTokenRefactor__clear_token_timeout_seconds", 20L);
            zzh = zzczVarZza.zzd("getTokenRefactor__default_task_timeout_seconds", 20L);
            zzi = zzczVarZza.zze("getTokenRefactor__gaul_accounts_api_evolved", false);
            zzj = zzczVarZza.zze("getTokenRefactor__gaul_token_api_evolved", false);
            zzk = zzczVarZza.zzd("getTokenRefactor__get_token_timeout_seconds", 120L);
            zzl = zzczVarZza.zze("getTokenRefactor__gms_account_authenticator_evolved", true);
            zzm = zzczVarZza.zzc("getTokenRefactor__gms_account_authenticator_sample_percentage", 0.0d);
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzhx
    public final zzhs zza() {
        return (zzhs) zze.zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzhx
    public final boolean zzc() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }
}
