package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcl implements Callable {
    private final zzbbs zza;
    private final zzaxm zzb;

    public zzbcl(zzbbs zzbbsVar, zzaxm zzaxmVar) {
        this.zza = zzbbsVar;
        this.zzb = zzaxmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws ExecutionException, InterruptedException {
        zzbbs zzbbsVar = this.zza;
        if (zzbbsVar.zzm() != null) {
            zzbbsVar.zzm().get();
        }
        zzaym zzaymVarZzl = zzbbsVar.zzl();
        if (zzaymVarZzl == null) {
            return null;
        }
        try {
            zzaxm zzaxmVar = this.zzb;
            synchronized (zzaxmVar) {
                zzaxmVar.zzaJ(zzaymVarZzl.zzaN(), zzido.zza());
            }
            return null;
        } catch (zziet | NullPointerException unused) {
            return null;
        }
    }
}
