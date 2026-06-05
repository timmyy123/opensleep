package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzahu implements zzahq {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzahu(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzahu zzb(zzet zzetVar) {
        int iZzC = zzetVar.zzC();
        zzetVar.zzk(8);
        int iZzC2 = zzetVar.zzC();
        int iZzC3 = zzetVar.zzC();
        zzetVar.zzk(4);
        int iZzC4 = zzetVar.zzC();
        zzetVar.zzk(12);
        return new zzahu(iZzC, iZzC2, iZzC3, iZzC4);
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return 1751742049;
    }
}
