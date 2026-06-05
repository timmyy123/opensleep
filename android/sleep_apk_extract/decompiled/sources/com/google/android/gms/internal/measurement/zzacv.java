package com.google.android.gms.internal.measurement;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.io.InputStream;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzacv {
    private static volatile int zze = 100;
    int zza;
    int zzb;
    final int zzc = zze;
    Object zzd;

    public /* synthetic */ zzacv(byte[] bArr) {
    }

    public static zzacv zzM(InputStream inputStream, int i) {
        byte[] bArr = null;
        if (i > 0) {
            return inputStream == null ? zzN(zzaed.zza, 0, 0, false) : new zzacu(inputStream, i, bArr);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("bufferSize must be > 0");
        return null;
    }

    public static zzacv zzN(byte[] bArr, int i, int i2, boolean z) {
        zzact zzactVar = new zzact(bArr, 0, 0, false, null);
        try {
            zzactVar.zzD(0);
            return zzactVar;
        } catch (zzaeh e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static int zzR(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzS(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static /* synthetic */ void zzT(byte[] bArr, int i, int i2) {
        if ((bArr.length - i) - i2 < 0 || (i | i2) < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract int zzD(int i);

    public abstract void zzE(int i);

    public abstract int zzF();

    public abstract boolean zzG();

    public abstract int zzH();

    public abstract int zzK(byte[] bArr, int i, int i2);

    public abstract void zzL(int i);

    public final void zzO() throws zzaeh {
        if (this.zza + this.zzb < this.zzc) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void zzP() {
        if (this.zzb == 0) {
            zzb(0);
        }
    }

    public final void zzQ() throws zzaeh {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzO();
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

    public abstract zzacr zzn();

    public abstract byte[] zzo();

    public abstract int zzp();

    public abstract int zzq();

    public abstract int zzr();

    public abstract long zzs();

    public abstract int zzt();

    public abstract long zzu();

    public abstract int zzx();

    public abstract long zzz();
}
