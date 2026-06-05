package com.google.android.gms.internal.measurement;

import android.os.Process;
import android.util.Log;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqi implements zzqm {
    private static boolean zza;
    private final Supplier zzb;
    private final int zzc;
    private final Supplier zzd;

    public zzqi(Supplier supplier, int i) {
        zzqh zzqhVar = zzqh.zza;
        this.zzb = supplier;
        this.zzc = Math.max(5, 10);
        this.zzd = zzqhVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final void zza() {
        synchronized (zzqi.class) {
            try {
                if (!zza) {
                    Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.measurement.zzqg
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzb();
                        }
                    };
                    long j = this.zzc;
                    TimeUnit timeUnit = TimeUnit.MINUTES;
                    ListeningScheduledExecutorService listeningScheduledExecutorService = (ListeningScheduledExecutorService) this.zzb.get();
                    zzpx.zza(listeningScheduledExecutorService.schedule((Runnable) new zzqf(this, runnable, listeningScheduledExecutorService, j, timeUnit), j, timeUnit));
                    zza = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzb() {
        if (((Boolean) this.zzd.get()).booleanValue()) {
            Log.i("PhenotypeProcessReaper", "Killing process to refresh experiment configuration");
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
