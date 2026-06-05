package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
final class zzqr {
    private final boolean zza;
    private final int zzb;
    private final int zzc;

    public zzqr(int i) {
        this.zzb = 2;
        this.zzc = i;
        this.zza = false;
    }

    public final zzmd zza() {
        if (this.zza) {
            return zzmd.zzb();
        }
        int i = this.zzb;
        zzmc zzmcVarZza = zzmd.zza();
        zzmcVarZza.zza(i);
        zzmcVarZza.zzb(this.zzc);
        return (zzmd) zzmcVarZza.zzbd();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final /* synthetic */ int zzc() {
        return this.zzb;
    }

    public zzqr(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zza = false;
    }
}
