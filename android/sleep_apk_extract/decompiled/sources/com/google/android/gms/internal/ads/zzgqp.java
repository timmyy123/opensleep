package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgqp extends zzgqx {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqx zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqx zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final zzgqy zzc() {
        return new zzgqq(this.zza, this.zzb, null);
    }
}
