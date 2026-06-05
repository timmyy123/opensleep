package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzej;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class zzby implements zzej {
    final /* synthetic */ Consumer zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzcc zzc;
    final /* synthetic */ int zzd;

    public zzby(zzcc zzccVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        this.zzc = zzccVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final void zza(Throwable th) {
        boolean z = th instanceof TimeoutException;
        zzcc zzccVar = this.zzc;
        if (z) {
            zzccVar.zzaS(114, 28, zzcj.zzG);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            zzccVar.zzaS(107, 28, zzcj.zzG);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.zzb.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        zzcc zzccVar = this.zzc;
        if (!zzcc.zzaP(iIntValue)) {
            this.zzb.run();
        } else {
            this.zza.accept(zzccVar.zzaQ(this.zzd, num.intValue()));
        }
    }
}
