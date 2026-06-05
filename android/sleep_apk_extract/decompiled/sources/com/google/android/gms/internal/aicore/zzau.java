package com.google.android.gms.internal.aicore;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzau {
    public static zzas zze(Context context) {
        zzax zzaxVar = new zzax();
        zzaxVar.zze(context);
        zzaxVar.zzb(zzat.zza);
        zzaxVar.zza(Executors.newCachedThreadPool());
        zzaxVar.zzc(true);
        return zzaxVar;
    }

    public abstract Context zza();

    public abstract ExecutorService zzb();

    public abstract Executor zzc();

    public abstract boolean zzd();
}
