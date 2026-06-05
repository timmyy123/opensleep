package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzfqc implements zzhbt {
    final /* synthetic */ zzfqg zza;
    final /* synthetic */ zzfpw zzb;
    final /* synthetic */ boolean zzc;

    public zzfqc(zzfqg zzfqgVar, zzfpw zzfpwVar, boolean z) {
        this.zza = zzfqgVar;
        this.zzb = zzfpwVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfpw zzfpwVar = this.zzb;
        if (zzfpwVar.zzb()) {
            zzfqg zzfqgVar = this.zza;
            zzfpwVar.zzj(th);
            zzfpwVar.zzd(false);
            zzfqgVar.zza(zzfpwVar);
            if (this.zzc) {
                zzfqgVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        zzfpw zzfpwVar = this.zzb;
        zzfpwVar.zzd(true);
        zzfqg zzfqgVar = this.zza;
        zzfqgVar.zza(zzfpwVar);
        if (this.zzc) {
            zzfqgVar.zzh();
        }
    }
}
