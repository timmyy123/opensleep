package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbnz extends zzbne {
    final /* synthetic */ zzbob zza;

    public /* synthetic */ zzbnz(zzbob zzbobVar, byte[] bArr) {
        Objects.requireNonNull(zzbobVar);
        this.zza = zzbobVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zze(zzbmv zzbmvVar, String str) {
        zzbob zzbobVar = this.zza;
        if (zzbobVar.zzd() == null) {
            return;
        }
        zzbobVar.zzd().zzc(zzbobVar.zze(zzbmvVar), str);
    }
}
