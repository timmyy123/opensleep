package com.google.android.gms.internal.measurement;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzada extends zzacj {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final boolean zzc = zzagg.zza();
    Object zza;

    public /* synthetic */ zzada(byte[] bArr) {
    }

    public static int zzE(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzF(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzG(zzafc zzafcVar) {
        int iZzcq = zzafcVar.zzcq();
        return zzE(iZzcq) + iZzcq;
    }

    public final void zzH() {
        if (zzy() > 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Did not write as much data as expected.");
        } else {
            if (zzy() >= 0) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Wrote more data than expected.");
        }
    }

    public abstract void zzb(int i, int i2);

    public abstract void zzc(int i, int i2);

    public abstract void zzd(int i, int i2);

    public abstract void zze(int i, int i2);

    public abstract void zzf(int i, long j);

    public abstract void zzg(int i, long j);

    public abstract void zzh(int i, boolean z);

    public abstract void zzi(int i, String str);

    public abstract void zzj(int i, zzacr zzacrVar);

    public abstract void zzk(zzacr zzacrVar);

    public abstract void zzl(byte[] bArr, int i, int i2);

    public abstract void zzo(zzafc zzafcVar);

    public abstract void zzp(byte b);

    public abstract void zzq(int i);

    public abstract void zzr(int i);

    public abstract void zzs(int i);

    public abstract void zzt(long j);

    public abstract void zzu(long j);

    public abstract void zzw(String str);

    public abstract int zzy();
}
