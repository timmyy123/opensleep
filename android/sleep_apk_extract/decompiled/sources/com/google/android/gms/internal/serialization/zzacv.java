package com.google.android.gms.internal.serialization;

import java.lang.reflect.Method;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzacv {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Nullable
    private static final Method zzb;

    @Nullable
    private static final Method zzc;

    @Nullable
    private static final Method zzd;

    static {
        zzabo zzaboVarZzc = zzabp.zzc();
        zzaboVarZzc.zza(-62135596800L);
        zzaboVarZzc.zzb(0);
        zzabo zzaboVarZzc2 = zzabp.zzc();
        zzaboVarZzc2.zza(253402300799L);
        zzaboVarZzc2.zzb(999999999);
        zzabo zzaboVarZzc3 = zzabp.zzc();
        zzaboVarZzc3.zza(0L);
        zzaboVarZzc3.zzb(0);
        new zzacu();
        zzb = zze("now");
        zzc = zze("getEpochSecond");
        zzd = zze("getNano");
    }

    public static zzabp zza(zzabp zzabpVar) {
        long jZza = zzabpVar.zza();
        boolean zZzd = zzd(jZza);
        int iZzb = zzabpVar.zzb();
        if (zZzd && iZzb >= 0 && iZzb < 1000000000) {
            return zzabpVar;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(zzdg.zza("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(jZza), Integer.valueOf(iZzb)));
        return null;
    }

    public static zzabp zzb() {
        Method method = zzb;
        if (method == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            return zzc(jCurrentTimeMillis / 1000, (int) ((jCurrentTimeMillis % 1000) * 1000000));
        }
        try {
            Object objInvoke = method.invoke(null, null);
            return zzc(((Long) zzc.invoke(objInvoke, null)).longValue(), ((Integer) zzd.invoke(objInvoke, null)).intValue());
        } catch (Throwable th) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(th);
            return null;
        }
    }

    public static zzabp zzc(long j, int i) {
        if (!zzd(j)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzdg.zza("Timestamp is not valid. Input seconds is too large. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. ", Long.valueOf(j)));
            return null;
        }
        if (i <= -1000000000 || i >= 1000000000) {
            j = zzid.zza(j, i / 1000000000);
            i %= 1000000000;
        }
        if (i < 0) {
            i += 1000000000;
            j = zzid.zzb(j, 1L);
        }
        zzabo zzaboVarZzc = zzabp.zzc();
        zzaboVarZzc.zza(j);
        zzaboVarZzc.zzb(i);
        zzabp zzabpVar = (zzabp) zzaboVarZzc.build();
        zza(zzabpVar);
        return zzabpVar;
    }

    private static boolean zzd(long j) {
        return j >= -62135596800L && j <= 253402300799L;
    }

    @Nullable
    private static Method zze(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
