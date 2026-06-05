package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcto implements zzhbt {
    final /* synthetic */ zzctv zza;

    public zzcto(zzctv zzctvVar) {
        Objects.requireNonNull(zzctvVar);
        this.zza = zzctvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctv zzctvVar = this.zza;
        zzctvVar.zzu().zzb(zzctvVar.zzt().zzb(zzctvVar.zzr(), zzctvVar.zzs(), false, "", (String) obj, zzctvVar.zzs().zzc, null, null), true == com.google.android.gms.ads.internal.zzt.zzh().zzs(zzctvVar.zzq()) ? 2 : 1);
    }
}
