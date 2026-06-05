package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzabr {
    private static volatile int zza = 100;

    public abstract void zza(Object obj, int i, long j);

    public abstract void zzb(Object obj, int i, int i2);

    public abstract void zzc(Object obj, int i, long j);

    public abstract void zzd(Object obj, int i, zzwr zzwrVar);

    public abstract void zze(Object obj, int i, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract Object zzh(Object obj);

    public abstract void zzi(Object obj, Object obj2);

    public abstract void zzj(Object obj);

    public final boolean zzk(Object obj, zzabd zzabdVar, int i) throws zzzv {
        int iZzc = zzabdVar.zzc();
        int i2 = iZzc >>> 3;
        int i3 = iZzc & 7;
        if (i3 == 0) {
            zza(obj, i2, zzabdVar.zzh());
            return true;
        }
        if (i3 == 1) {
            zzc(obj, i2, zzabdVar.zzj());
            return true;
        }
        if (i3 == 2) {
            zzd(obj, i2, zzabdVar.zzs());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                Gson$$ExternalSyntheticBUOutline0.m("Protocol message end-group tag did not match expected tag.");
                return false;
            }
            if (i3 == 5) {
                zzb(obj, i2, zzabdVar.zzk());
                return true;
            }
            Gson$$ExternalSyntheticBUOutline0.m();
            return false;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return false;
        }
        while (zzabdVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzabdVar, i5)) {
        }
        if ((i4 | 4) == zzabdVar.zzc()) {
            zze(obj, i2, zzg(objZzf));
            return true;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message end-group tag did not match expected tag.");
        return false;
    }
}
