package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbbq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbbs zzb;

    public zzbbq(zzbbs zzbbsVar, int i, boolean z) {
        this.zza = i;
        Objects.requireNonNull(zzbbsVar);
        this.zzb = zzbbsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaym zzaymVarZza;
        int i = this.zza;
        zzbbs zzbbsVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzbbsVar.zza;
            zzaymVarZza = zzfxn.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzaymVarZza = null;
        }
        zzbbs zzbbsVar2 = this.zzb;
        zzbbsVar2.zzs(zzaymVarZza);
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzaymVarZza != null && zzaymVarZza.zza() && !zzaymVarZza.zzb().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzaymVarZza.zzg() && zzaymVarZza.zzh().zza() && zzaymVarZza.zzh().zzb() != -2) {
                return;
            }
            zzbbsVar2.zzp(i2 + 1, true);
        }
    }
}
