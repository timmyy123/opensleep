package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbuk implements zzcfy {
    final /* synthetic */ zzcfw zza;
    final /* synthetic */ zzbto zzb;

    public zzbuk(zzbum zzbumVar, zzcfw zzcfwVar, zzbto zzbtoVar) {
        this.zza = zzcfwVar;
        this.zzb = zzbtoVar;
        Objects.requireNonNull(zzbumVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfy
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbtx("Unable to obtain a JavascriptEngine."));
        this.zzb.zza();
    }
}
