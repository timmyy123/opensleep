package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface zzacj extends Executor {
    static zzacj zzb(Executor executor, zzdt zzdtVar) {
        return new zzaci(executor, zzdtVar);
    }

    void zza();
}
