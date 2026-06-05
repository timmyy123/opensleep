package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzftu implements Runnable {
    final /* synthetic */ zzfub zza;

    public zzftu(zzfub zzfubVar) {
        Objects.requireNonNull(zzfubVar);
        this.zza = zzfubVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfub zzfubVar = this.zza;
        if (zzfubVar.zzN() != null) {
            long jCurrentTimeMillis = zzfubVar.zzO().currentTimeMillis();
            int iZzs = zzfubVar.zzs();
            String strZzM = zzfubVar.zzM();
            zzfubVar.zzN().zzj(jCurrentTimeMillis, zzfubVar.zzP(), iZzs, strZzM);
        }
    }
}
