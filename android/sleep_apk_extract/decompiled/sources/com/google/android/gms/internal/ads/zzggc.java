package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzggc implements zzgfd {
    private final zzgdf zza;
    private final zzgfy zzb;
    private final zzgfs zzc;
    private final ExecutorService zzd;
    private final zzgqh zze;
    private final AtomicReference zzf = new AtomicReference();

    public zzggc(zzgdf zzgdfVar, zzgfy zzgfyVar, zzgfs zzgfsVar, ExecutorService executorService, zzgqh zzgqhVar) {
        this.zza = zzgdfVar;
        this.zzb = zzgfyVar;
        this.zzc = zzgfsVar;
        this.zzd = executorService;
        this.zze = zzgqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfd
    public final ListenableFuture zza() {
        zzgfy zzgfyVar = this.zzb;
        zzgdf zzgdfVar = this.zza;
        zzhbo zzhboVar = (zzhbo) zzhbw.zzk(zzhbo.zzw(zzgfyVar.zzb(zzgdfVar.zzG(), zzgdfVar.zza())), new zzgta() { // from class: com.google.android.gms.internal.ads.zzggb
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzgfr zzgfrVar = (zzgfr) obj;
                this.zza.zzf(zzgfrVar);
                return zzgfrVar;
            }
        }, zzhcn.zza());
        zzhbw.zzr(zzhboVar, new zzgga(this), this.zzd);
        return zzhboVar;
    }

    public final ListenableFuture zzb(Context context) {
        return ((zzgfr) this.zzf.get()).zzc(context);
    }

    public final ListenableFuture zzc(Context context, String str, View view, Activity activity) {
        return ((zzgfr) this.zzf.get()).zzd(context, null, view, activity);
    }

    public final ListenableFuture zzd(Context context, String str, View view, Activity activity) {
        return ((zzgfr) this.zzf.get()).zze(context, str, view, null);
    }

    public final void zze(InputEvent inputEvent) {
        zzgfr zzgfrVar = (zzgfr) this.zzf.get();
        if (zzgfrVar == null) {
            this.zze.zzb(54);
        } else {
            zzgfrVar.zzf(inputEvent);
        }
    }

    public final /* synthetic */ zzgfr zzf(zzgfr zzgfrVar) {
        this.zzf.set(zzgfrVar);
        return zzgfrVar;
    }

    public final /* synthetic */ zzgfs zzg() {
        return this.zzc;
    }

    public final int zzh() {
        zzgfr zzgfrVar = (zzgfr) this.zzf.get();
        if (zzgfrVar == null) {
            return 1;
        }
        return zzgfrVar.zzg();
    }
}
