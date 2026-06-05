package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzbio;

/* JADX INFO: loaded from: classes3.dex */
public final class zzba {
    private static final zzba zza = new zzba();
    private final zzbii zzb;
    private final zzbij zzc;
    private final zzbio zzd;
    private final zzbhz zze;

    public zzba() {
        zzbii zzbiiVar = new zzbii();
        zzbij zzbijVar = new zzbij();
        zzbio zzbioVar = new zzbio();
        zzbhz zzbhzVar = new zzbhz();
        this.zzb = zzbiiVar;
        this.zzc = zzbijVar;
        this.zzd = zzbioVar;
        this.zze = zzbhzVar;
    }

    public static zzbij zza() {
        return zza.zzc;
    }

    public static zzbii zzb() {
        return zza.zzb;
    }

    public static zzbio zzc() {
        return zza.zzd;
    }

    public static zzbhz zzd() {
        return zza.zze;
    }
}
