package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzavf implements zzave {
    @Override // com.google.android.gms.internal.ads.zzave
    public final byte zza(zzavq zzavqVar, int i) {
        return zzavqVar.zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final zzavq zzb(zzavq zzavqVar, int i, int i2) {
        byte[] bArr;
        int length;
        if (i < 0 || i > i2 || i2 > (length = (bArr = zzavqVar.zza).length) || i > i2 || i2 > length) {
            throw new IndexOutOfBoundsException();
        }
        return new zzavq(zzavq.zzh(bArr, i, i2 - i));
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final zzave zzc() {
        return new zzavf();
    }
}
