package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.Trace;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayDeque;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzvy {
    private static final ImmutableSet zzc = ImmutableSet.of("androidx.fragment.app.FragmentViewLifecycleOwner.handleLifecycleEvent", "com.google.android.libraries.logging.logger.transmitters.clearcut", "com.google.android.libraries.performance.primes.transmitter.clearcut", "com.google.android.libraries.performance.primes.metrics.crash.CrashMetricServiceImpl", "com.google.android.libraries.performance.primes.metrics.crash.applicationexit.ApplicationExitMetricServiceImpl");
    private static final AtomicReference zzd = new AtomicReference(ImmutableSet.of());
    static final zzrg zza = new zzrg("tiktok_systrace");
    private static final WeakHashMap zze = new WeakHashMap();
    private static final zzvx zzf = new zzvx();

    static {
        new ArrayDeque();
        new ArrayDeque();
    }

    public static ImmutableSet zza() {
        return (ImmutableSet) zzd.get();
    }

    public static zzws zzb(boolean z) {
        zzwq zzwqVarZzd = zzd();
        zzws zzwsVar = zzwqVarZzd.zzb;
        return (zzwsVar == null || zzwsVar == zzwg.zza) ? zzwd.zzi(zzwqVarZzd) : zzwsVar;
    }

    public static zzws zzc(zzwq zzwqVar, zzws zzwsVar) {
        zzwqVar.getClass();
        zzws zzwsVar2 = zzwqVar.zzb;
        if (zzwsVar2 != zzwsVar) {
            if (zzwsVar2 == null) {
                zzwqVar.zza = Build.VERSION.SDK_INT >= 29 ? Trace.isEnabled() : zzrk.zza(zza);
            }
            if (zzwqVar.zza) {
                zzwr.zza(zzwsVar2, zzwsVar);
            }
            if (zzwsVar2 != zzwsVar) {
                zzwqVar.zzb = zzwsVar;
                return zzwsVar2;
            }
        }
        return zzwsVar;
    }

    public static zzwq zzd() {
        return (zzwq) zzf.get();
    }
}
