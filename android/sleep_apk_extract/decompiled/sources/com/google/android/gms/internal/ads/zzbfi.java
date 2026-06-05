package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbfi implements Runnable {
    final /* synthetic */ zzbfj zza;

    public zzbfi(zzbfj zzbfjVar) {
        Objects.requireNonNull(zzbfjVar);
        this.zza = zzbfjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfj zzbfjVar = this.zza;
        synchronized (zzbfjVar.zzf()) {
            if (zzbfjVar.zzg().get() && zzbfjVar.zzh()) {
                zzbfjVar.zzg().set(false);
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App went background");
                Iterator it = zzbfjVar.zzi().iterator();
                while (it.hasNext()) {
                    try {
                        ((zzbfk) it.next()).zza(false);
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                    }
                }
            } else {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App is still foreground");
            }
        }
    }
}
