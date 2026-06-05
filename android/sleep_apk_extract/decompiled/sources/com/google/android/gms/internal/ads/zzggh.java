package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzggh implements zzgfr {
    private final ExecutorService zza;
    private final zzimo zzb;
    private final zzimo zzc;
    private final zzgpc zzd;
    private final zzimo zze;
    private final zzinj zzf;
    private final zzgdf zzg;

    public zzggh(ExecutorService executorService, zzimo zzimoVar, zzimo zzimoVar2, zzgpc zzgpcVar, zzimo zzimoVar3, zzinj zzinjVar, zzgdf zzgdfVar) {
        this.zza = executorService;
        this.zzb = zzimoVar;
        this.zzc = zzimoVar2;
        this.zzd = zzgpcVar;
        this.zze = zzimoVar3;
        this.zzf = zzinjVar;
        this.zzg = zzgdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final String zza() {
        return "1.878096153";
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzb() {
        return zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzggg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zzh();
                return null;
            }
        }, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzc(Context context) {
        zzggx zzggxVarZzh = ((zzggx) this.zzf.zzb()).zzh(context);
        zzggxVarZzh.zzd(this.zzd.zzb());
        zzggxVarZzh.zzc(zzaym.zzj());
        zzggxVarZzh.zzb(zzgec.QUERY);
        return zzggxVarZzh.zza().zza().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzd(Context context, String str, View view, Activity activity) {
        zzggx zzggxVarZzh = ((zzggx) this.zzf.zzb()).zzh(context);
        zzggxVarZzh.zzg(view);
        zzggxVarZzh.zzf(activity);
        zzggxVarZzh.zze(true != this.zzg.zzh() ? "" : null);
        zzggxVarZzh.zzd(this.zzd.zzc(context, view));
        zzggxVarZzh.zzc(zzaym.zzj());
        zzggxVarZzh.zzb(zzgec.VIEW);
        return zzggxVarZzh.zza().zza().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zze(Context context, String str, View view, Activity activity) {
        zzimo zzimoVar = this.zze;
        Map mapZzd = this.zzd.zzd();
        ((zzggp) zzimoVar.zzb()).zzb(mapZzd);
        zzggx zzggxVarZzh = ((zzggx) this.zzf.zzb()).zzh(context);
        zzggxVarZzh.zzg(view);
        zzggxVarZzh.zzf(null);
        zzggxVarZzh.zze(str);
        zzggxVarZzh.zzd(mapZzd);
        zzggxVarZzh.zzb(zzgec.CLICK);
        zzggxVarZzh.zzc(zzaym.zzj());
        return zzggxVarZzh.zza().zza().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final void zzf(InputEvent inputEvent) {
        if (inputEvent instanceof MotionEvent) {
            ((zzggp) this.zze.zzb()).zza((MotionEvent) inputEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final int zzg() {
        return 2;
    }

    public final /* synthetic */ Void zzh() {
        ((zzgha) this.zzc.zzb()).zza();
        ((zzght) this.zzb.zzb()).zza();
        return null;
    }
}
