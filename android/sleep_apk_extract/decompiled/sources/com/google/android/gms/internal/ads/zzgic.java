package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
final class zzgic implements zzgiw {
    private final Map zza;
    private final zzaxm zzb;
    private final zzgqf zzc;
    private final long zzd;

    public zzgic(zzaxm zzaxmVar, Map map, zzgdf zzgdfVar, zzgqh zzgqhVar) {
        this.zza = map;
        this.zzb = zzaxmVar;
        this.zzc = zzgqhVar.zza(112);
        this.zzd = zzgdfVar.zzl();
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zza();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Void zza() {
        zzaym zzaymVar;
        try {
            try {
                this.zzc.zza();
                ListenableFuture listenableFuture = (ListenableFuture) this.zza.get("gs");
                if (listenableFuture != null && (zzaymVar = (zzaym) listenableFuture.get(this.zzd, TimeUnit.MILLISECONDS)) != null) {
                    zzaxm zzaxmVar = this.zzb;
                    synchronized (zzaxmVar) {
                        zzaxmVar.zzad(zzaymVar.zzh());
                        zzaxmVar.zzN(zzaymVar.zzd());
                    }
                }
            } catch (Throwable th) {
                this.zzc.zzc();
                throw th;
            }
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException e) {
            this.zzc.zzb(e);
        }
        this.zzc.zzc();
        return null;
    }
}
