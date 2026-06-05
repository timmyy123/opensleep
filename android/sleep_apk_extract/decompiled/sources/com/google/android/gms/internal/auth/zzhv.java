package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhv implements zzhu {
    public static final zzdc zza;
    public static final zzdc zzb;
    public static final zzdc zzc;
    public static final zzdc zzd;
    public static final zzdc zze;

    static {
        zzcz zzczVarZza = new zzcz(zzcr.zza("com.google.android.gms.auth_account")).zzb().zza();
        zza = zzczVarZza.zze("Aang__create_auth_exception_with_pending_intent", false);
        zzb = zzczVarZza.zze("Aang__enable_add_account_restrictions", false);
        zzc = zzczVarZza.zze("Aang__log_missing_gaia_id_event", true);
        zzd = zzczVarZza.zze("Aang__log_obfuscated_gaiaid_status", true);
        zze = zzczVarZza.zze("Aang__switch_clear_token_to_aang", false);
    }

    @Override // com.google.android.gms.internal.auth.zzhu
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
