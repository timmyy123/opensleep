package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgqv extends zzgrx {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgrx zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgrx zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgrx
    public final zzgry zzc() {
        return new zzgqw(this.zza, this.zzb, null);
    }
}
