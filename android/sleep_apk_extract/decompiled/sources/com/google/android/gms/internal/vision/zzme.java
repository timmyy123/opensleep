package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzme {
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    public abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    public final boolean zza(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }

    public abstract String zzb(byte[] bArr, int i, int i2);
}
