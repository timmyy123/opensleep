package com.google.android.gms.internal.serialization;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzwv {
    private static volatile int zza = 100;
    int zzb;
    final int zzc = zza;
    zzww zzd;

    public /* synthetic */ zzwv(byte[] bArr) {
    }

    public static zzwv zzL(byte[] bArr, int i, int i2) {
        return zzM(bArr, 0, i2, false);
    }

    public static zzwv zzM(byte[] bArr, int i, int i2, boolean z) {
        zzws zzwsVar = new zzws(bArr, i, i2, z, null);
        try {
            zzwsVar.zzC(i2);
            return zzwsVar;
        } catch (zzzv e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static int zzP(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzQ(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public abstract int zzC(int i);

    public abstract void zzD(int i);

    public abstract int zzE();

    public abstract boolean zzF();

    public abstract int zzG();

    public final void zzN() throws zzzv {
        if (this.zzb < this.zzc) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void zzO() throws zzzv {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzN();
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

    public abstract zzwr zzp();

    public abstract byte[] zzq();

    public abstract int zzr();

    public abstract int zzs();

    public abstract int zzt();

    public abstract long zzu();

    public abstract int zzv();

    public abstract long zzw();

    public abstract int zzx();
}
