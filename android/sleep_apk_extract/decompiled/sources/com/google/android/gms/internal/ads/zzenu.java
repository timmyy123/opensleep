package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzenu extends zzbwr {
    private final zzelv zza;

    public /* synthetic */ zzenu(zzenv zzenvVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzenvVar);
        this.zza = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zze() {
        ((zzenh) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzf(String str) {
        ((zzenh) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        ((zzenh) this.zza.zzc).zzx(zzeVar);
    }
}
