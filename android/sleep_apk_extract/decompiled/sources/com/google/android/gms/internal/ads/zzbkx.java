package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkx {
    public static final zzbka zza = zzbka.zza("gads:separate_url_generation:enabled", true);
    public static final zzbka zzb = zzbka.zzb("gads:url_cache:max_size", 200);

    static {
        zzbka.zza("gads:use_request_id_as_url_cache_key:enabled", true);
    }
}
