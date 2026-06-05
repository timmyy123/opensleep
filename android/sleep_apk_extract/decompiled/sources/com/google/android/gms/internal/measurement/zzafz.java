package com.google.android.gms.internal.measurement;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzafz {
    private static volatile int zza = 100;

    public abstract void zza(Object obj, int i, long j);

    public abstract void zzb(Object obj, int i, int i2);

    public abstract void zzc(Object obj, int i, long j);

    public abstract void zzd(Object obj, int i, zzacr zzacrVar);

    public abstract void zze(Object obj, int i, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract Object zzh(Object obj);

    public abstract void zzi(Object obj, Object obj2);

    public abstract void zzj(Object obj);

    public final boolean zzk(Object obj, zzafo zzafoVar, int i) throws zzaeh {
        int iZzc = zzafoVar.zzc();
        int i2 = iZzc >>> 3;
        int i3 = iZzc & 7;
        if (i3 == 0) {
            zza(obj, i2, zzafoVar.zzh());
            return true;
        }
        if (i3 == 1) {
            zzc(obj, i2, zzafoVar.zzj());
            return true;
        }
        if (i3 == 2) {
            zzd(obj, i2, zzafoVar.zzq());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message end-group tag did not match expected tag.");
                return false;
            }
            if (i3 == 5) {
                zzb(obj, i2, zzafoVar.zzk());
                return true;
            }
            Gson$$ExternalSyntheticBUOutline0.m$1();
            return false;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return false;
        }
        while (zzafoVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzafoVar, i5)) {
        }
        if ((i4 | 4) == zzafoVar.zzc()) {
            zze(obj, i2, zzg(objZzf));
            return true;
        }
        Gson$$ExternalSyntheticBUOutline0.m$1("Protocol message end-group tag did not match expected tag.");
        return false;
    }
}
