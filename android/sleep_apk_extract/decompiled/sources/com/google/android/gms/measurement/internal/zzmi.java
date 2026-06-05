package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class zzmi implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zznl zzc;

    public zzmi(zznl zznlVar, AtomicReference atomicReference, zzr zzrVar) {
        this.zza = atomicReference;
        this.zzb = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.zzc = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznl zznlVar;
        zzic zzicVar;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                try {
                    zznlVar = this.zzc;
                    zzicVar = zznlVar.zzu;
                } catch (RemoteException e) {
                    this.zzc.zzu.zzaW().zzb().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                }
                if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzgb zzgbVarZzZ = zznlVar.zzZ();
                    if (zzgbVarZzZ != null) {
                        zzr zzrVar = this.zzb;
                        Preconditions.checkNotNull(zzrVar);
                        atomicReference2.set(zzgbVarZzZ.zzm(zzrVar));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            zznlVar.zzu.zzj().zzQ(str);
                            zzicVar.zzd().zze.zzb(str);
                        }
                        zznlVar.zzV();
                        atomicReference = this.zza;
                        atomicReference.notify();
                        return;
                    }
                    zzicVar.zzaW().zzb().zza("Failed to get app instance id");
                } else {
                    zzicVar.zzaW().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznlVar.zzu.zzj().zzQ(null);
                    zzicVar.zzd().zze.zzb(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
