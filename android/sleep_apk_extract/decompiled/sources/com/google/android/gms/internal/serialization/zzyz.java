package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyz extends zzwa {
    private final zzzg zza;

    public zzyz(zzzg zzzgVar) {
        this.zza = zzzgVar;
    }

    @Override // com.google.android.gms.internal.serialization.zzwa
    public final /* bridge */ /* synthetic */ zzaaq zza(byte[] bArr, int i, int i2, zzyp zzypVar) {
        return zzzg.parsePartialFrom(this.zza, bArr, 0, i2, zzypVar);
    }
}
