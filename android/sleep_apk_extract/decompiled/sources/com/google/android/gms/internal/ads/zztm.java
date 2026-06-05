package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zztm {
    private final zzco[] zza;
    private final zztz zzb;
    private final zzcu zzc;

    public zztm(zzco... zzcoVarArr) {
        zztz zztzVar = new zztz();
        zzcu zzcuVar = new zzcu();
        zzco[] zzcoVarArr2 = {zztzVar, zzcuVar};
        this.zza = zzcoVarArr2;
        System.arraycopy(zzcoVarArr, 0, zzcoVarArr2, 0, 0);
        this.zzb = zztzVar;
        this.zzc = zzcuVar;
    }

    public final zzco[] zza() {
        return this.zza;
    }

    public final zzav zzb(zzav zzavVar) {
        zzcu zzcuVar = this.zzc;
        zzcuVar.zzk(zzavVar.zzb);
        zzcuVar.zzl(zzavVar.zzc);
        return zzavVar;
    }

    public final boolean zzc(boolean z) {
        this.zzb.zzq(z);
        return z;
    }

    public final long zzd(long j) {
        zzcu zzcuVar = this.zzc;
        return zzcuVar.zzc() ? zzcuVar.zzm(j) : j;
    }

    public final long zze() {
        return this.zzb.zzr();
    }
}
