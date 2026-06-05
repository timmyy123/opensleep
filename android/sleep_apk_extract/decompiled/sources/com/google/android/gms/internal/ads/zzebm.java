package com.google.android.gms.internal.ads;

import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class zzebm implements zzhbt {
    final /* synthetic */ zzebw zza;

    public zzebm(zzebw zzebwVar) {
        Objects.requireNonNull(zzebwVar);
        this.zza = zzebwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        synchronized (this) {
            zzebw zzebwVar = this.zza;
            zzebwVar.zzn(true);
            zzebwVar.zzm("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzebwVar.zzo()));
            zzebwVar.zzp().zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            zzebw zzebwVar = this.zza;
            zzebwVar.zzn(true);
            zzebwVar.zzm("com.google.android.gms.ads.MobileAds", true, "", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzebwVar.zzo()));
            zzebwVar.zzq().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza.zzl(str);
                }
            });
        }
    }
}
