package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxd implements zzbeq {
    private final zzcku zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    public zzcxd(zzcku zzckuVar, Executor executor) {
        this.zza = zzckuVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final synchronized void zzdj(zzbep zzbepVar) {
        final zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoc)).booleanValue()) {
                boolean z = zzbepVar.zzj;
                AtomicReference atomicReference = this.zzc;
                if (z) {
                    Boolean bool = Boolean.TRUE;
                    if (!bool.equals(atomicReference.getAndSet(bool))) {
                        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcxc
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzckuVar.onResume();
                            }
                        });
                    }
                } else {
                    Boolean bool2 = Boolean.FALSE;
                    if (!bool2.equals(atomicReference.getAndSet(bool2))) {
                        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcxb
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzckuVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
