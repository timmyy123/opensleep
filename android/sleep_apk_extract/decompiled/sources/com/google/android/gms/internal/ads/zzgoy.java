package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgoy implements zzgox {
    private final zzimo zza;
    private final zzgqh zzb;
    private final long zzc;

    public zzgoy(zzimo zzimoVar, zzgqh zzgqhVar, zzgcn zzgcnVar, long j) {
        this.zza = zzimoVar;
        this.zzb = zzgqhVar;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgox
    public final boolean zza(zzgfq zzgfqVar) {
        if (zzgfqVar == null || zzgfqVar.equals(zzgfq.zzh())) {
            this.zzb.zzb(15104);
            return true;
        }
        if (zzgfqVar.zzc() != this.zza.zzb()) {
            this.zzb.zzb(15105);
            return true;
        }
        boolean z = (zzgfqVar.zza().zzc() * 1000) - System.currentTimeMillis() <= this.zzc;
        if (z) {
            this.zzb.zzb(15106);
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzgox
    public final boolean zzb(zzgfq zzgfqVar) {
        if (zzgfqVar == null || zzgfqVar.equals(zzgfq.zzh())) {
            this.zzb.zzb(15102);
            return false;
        }
        if (zzgfqVar.zzc() == this.zza.zzb()) {
            return true;
        }
        this.zzb.zzb(15103);
        return false;
    }
}
