package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkq {
    public static final zzbka zza = zzbka.zza("gads:flags_check_if_updating_v3:enabled", false);
    public static final zzbka zzb = zzbka.zza("gads:disable_adapter_flag_shared_pref_listener_v3:enabled", false);
    public static final zzbka zzc = zzbka.zza("gads:disable_flag_shared_pref_listener_v3:enabled", false);
    public static final zzbka zzd = zzbka.zza("gads:disable_sdkcore_refresh_client:enabled", false);
    public static final zzbka zze = zzbka.zza("gads:enable_adapter_flags:enabled", false);
    public static final zzbka zzf = zzbka.zza("gads:include_package_name_v3:enabled", false);
    public static final zzbka zzg = zzbka.zza("gads:js_flags:mf", false);
    public static final zzbka zzh = zzbka.zzb("gads:js_flags:update_interval", 14400000);
    public static final zzbka zzi = zzbka.zza("gads:persist_js_flag:ars", true);
    public static final zzbka zzj;
    public static final zzbka zzk;
    public static final zzbka zzl;
    public static final zzbka zzm;
    public static final zzbka zzn;
    public static final zzbka zzo;
    public static final zzbka zzp;

    static {
        zzbka.zza("gads:persist_js_flag:as", true);
        zzj = zzbka.zza("gads:persist_js_flag:scar", true);
        zzk = zzbka.zza("gads:read_local_flags_v3:enabled", false);
        zzl = zzbka.zza("gads:read_local_flags_cld_v3:enabled", false);
        zzm = zzbka.zza("gads:save_flags_on_background_thread:enabled", false);
        zzn = zzbka.zza("gads:write_local_flags_cld_v3:enabled", false);
        zzo = zzbka.zza("gads:write_local_flags_client_v3:enabled", false);
        zzp = zzbka.zza("gads:write_local_flags_service_v3:enabled", false);
    }
}
