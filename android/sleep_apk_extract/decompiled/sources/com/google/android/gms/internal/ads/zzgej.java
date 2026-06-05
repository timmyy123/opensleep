package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgej implements zzged {
    private final int zza;
    private final byte[] zzb;

    public zzgej(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final String zzb() {
        return new String(this.zzb);
    }
}
