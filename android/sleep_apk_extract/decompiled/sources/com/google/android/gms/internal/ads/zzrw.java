package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrw {
    private final zzv zza;
    private zzhaf zzb = null;

    public zzrw(zzv zzvVar) {
        this.zza = zzvVar;
    }

    public final zzrw zza(zzhaf zzhafVar) {
        this.zzb = zzhafVar;
        return this;
    }

    public final zzrx zzb() {
        return new zzrx(this.zza, 0, this.zzb, null);
    }
}
