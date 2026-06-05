package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class zzahv implements zzahq {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzahv(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
    }

    public static zzahv zzb(zzet zzetVar) {
        int iZzC = zzetVar.zzC();
        zzetVar.zzk(12);
        int iZzC2 = zzetVar.zzC();
        int iZzC3 = zzetVar.zzC();
        int iZzC4 = zzetVar.zzC();
        zzetVar.zzk(4);
        int iZzC5 = zzetVar.zzC();
        int iZzC6 = zzetVar.zzC();
        zzetVar.zzk(4);
        return new zzahv(iZzC, iZzC2, iZzC3, iZzC4, iZzC5, iZzC6, zzetVar.zzC());
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return 1752331379;
    }

    public final int zzc() {
        int i = this.zza;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        zzeg.zzc("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i))));
        return -1;
    }

    public final long zzd() {
        long j = this.zzb;
        return zzfl.zzv(this.zzd, j * 1000000, this.zzc, RoundingMode.DOWN);
    }
}
