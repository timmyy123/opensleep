package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
final class zzaao extends zzaag {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzzf zze;

    static {
        String str = Build.FINGERPRINT;
        zza = str == null || "robolectric".equals(str);
        String str2 = Build.HARDWARE;
        zzb = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        zzc = "eng".equals(str3) || "userdebug".equals(str3);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzaao(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzaah().zza(zza());
        } else if (zzc) {
            this.zze = zzaas.zze().zzb(false).zza(zza());
        } else {
            this.zze = null;
        }
    }

    public static zzzf zze(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzaai) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace('$', '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzaao zzaaoVar = new zzaao(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzaam.zza;
        concurrentLinkedQueue.offer(zzaaoVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzaao zzaaoVar2 = (zzaao) concurrentLinkedQueue.poll();
                if (zzaaoVar2 == null) {
                    break;
                }
                zzaaoVar2.zze = ((zzaai) atomicReference.get()).zza(zzaaoVar2.zza());
            }
            zzf();
        }
        return zzaaoVar;
    }

    private static void zzf() {
        while (true) {
            zzaan zzaanVar = (zzaan) zzg.poll();
            if (zzaanVar == null) {
                return;
            }
            zzf.getAndDecrement();
            zzzf zzzfVarZza = zzaanVar.zza();
            zzzd zzzdVarZzb = zzaanVar.zzb();
            if (zzzdVarZzb.zzk() || zzzfVarZza.zzb(zzzdVarZzb.zze())) {
                zzzfVarZza.zzc(zzzdVarZzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        return this.zze == null || this.zze.zzb(level);
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        if (this.zze != null) {
            this.zze.zzc(zzzdVar);
            return;
        }
        if (zzf.incrementAndGet() > 20) {
            zzg.poll();
            Log.w("ProxyAndroidLoggerBackend", "Too many Flogger logs received before configuration. Dropping old logs.");
        }
        zzg.offer(new zzaan(this, zzzdVar));
        if (this.zze != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaag, com.google.android.gms.internal.measurement.zzzf
    public final void zzd(RuntimeException runtimeException, zzzd zzzdVar) {
        if (this.zze != null) {
            this.zze.zzd(runtimeException, zzzdVar);
        } else {
            Log.e("ProxyAndroidLoggerBackend", "Internal logging error before configuration", runtimeException);
        }
    }
}
