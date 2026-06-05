package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgvr extends zzgvd {
    final /* synthetic */ zzgvt zza;
    private final Object zzb;
    private int zzc;

    public zzgvr(zzgvt zzgvtVar, int i) {
        Objects.requireNonNull(zzgvtVar);
        this.zza = zzgvtVar;
        this.zzb = zzgvtVar.zzo(i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i != -1) {
            zzgvt zzgvtVar = this.zza;
            if (i < zzgvtVar.size() && Objects.equals(this.zzb, zzgvtVar.zzo(this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzi(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgvd, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgvd, java.util.Map.Entry
    public final Object getValue() {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzgvtVar.zzp(i);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzgvtVar.put(this.zzb, obj);
            return null;
        }
        Object objZzp = zzgvtVar.zzp(i);
        zzgvtVar.zzq(this.zzc, obj);
        return objZzp;
    }
}
