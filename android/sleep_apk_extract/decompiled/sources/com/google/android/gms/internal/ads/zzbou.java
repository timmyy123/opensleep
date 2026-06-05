package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzbou implements zzhbt {
    final /* synthetic */ zzcku zza;

    public zzbou(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcku zzckuVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbt(zzckuVar.getContext(), zzckuVar.zzs().afmaVersion, str, null, zzckuVar.zzC() != null ? zzckuVar.zzC().zzax : null).zzb();
    }
}
