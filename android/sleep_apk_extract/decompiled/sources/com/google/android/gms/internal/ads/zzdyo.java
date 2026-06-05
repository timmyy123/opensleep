package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdyo implements zzfpl {
    private final Map zza;
    private final zzbhp zzb;

    public zzdyo(zzbhp zzbhpVar, Map map) {
        this.zza = map;
        this.zzb = zzbhpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zzb);
        }
    }
}
