package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzide {
    private static volatile int zzf = 100;
    int zza;
    int zzb;
    final int zzc = zzf;
    Object zzd;

    public /* synthetic */ zzide(byte[] bArr) {
    }

    public static zzide zzH(InputStream inputStream, int i) {
        return inputStream == null ? zzI(zzier.zza, 0, 0, false) : new zzidd(inputStream, 4096, null);
    }

    public static zzide zzI(byte[] bArr, int i, int i2, boolean z) {
        zzidc zzidcVar = new zzidc(bArr, i, i2, z, null);
        try {
            zzidcVar.zzB(i2);
            return zzidcVar;
        } catch (zziet e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static int zzM(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzN(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public abstract int zzB(int i);

    public abstract void zzC(int i);

    public abstract boolean zzD();

    public abstract int zzE();

    public final void zzJ() throws zziet {
        if (this.zza + this.zzb < this.zzc) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void zzK() {
        if (this.zzb == 0) {
            zzb(0);
        }
    }

    public final void zzL() throws zziet {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzJ();
            this.zzb++;
            this.zzb--;
        } while (zzc(iZza));
    }

    public abstract int zza();

    public abstract void zzb(int i);

    public abstract boolean zzc(int i);

    public abstract double zzd();

    public abstract float zze();

    public abstract long zzf();

    public abstract long zzg();

    public abstract int zzh();

    public abstract long zzi();

    public abstract int zzj();

    public abstract boolean zzk();

    public abstract String zzl();

    public abstract String zzm();

    public abstract zzida zzn();

    public abstract int zzo();

    public abstract int zzp();

    public abstract int zzq();

    public abstract long zzr();

    public abstract int zzs();

    public abstract long zzt();
}
