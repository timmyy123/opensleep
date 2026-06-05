package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzhcv extends zzhbn implements RunnableFuture {
    private volatile zzhcd zza;

    public zzhcv(zzhbd zzhbdVar) {
        this.zza = new zzhct(this, zzhbdVar);
    }

    public static zzhcv zze(Runnable runnable, Object obj) {
        return new zzhcv(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzhcd zzhcdVar = this.zza;
        if (zzhcdVar != null) {
            zzhcdVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final void zzc() {
        zzhcd zzhcdVar;
        if (zzj() && (zzhcdVar = this.zza) != null) {
            zzhcdVar.zzh();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final String zzd() {
        zzhcd zzhcdVar = this.zza;
        if (zzhcdVar == null) {
            return super.zzd();
        }
        String string = zzhcdVar.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 7), "task=[", string, "]");
    }

    public zzhcv(Callable callable) {
        this.zza = new zzhcu(this, callable);
    }
}
