package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes3.dex */
final class zzeh extends zzej {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public /* synthetic */ zzeh(byte[] bArr, int i, int i2, boolean z, zzeg zzegVar) {
        super(null);
        this.zze = Integer.MAX_VALUE;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) {
        int i2 = this.zze;
        this.zze = 0;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        if (i3 <= 0) {
            this.zzd = 0;
            return i2;
        }
        this.zzd = i3;
        this.zzc = 0;
        return i2;
    }
}
