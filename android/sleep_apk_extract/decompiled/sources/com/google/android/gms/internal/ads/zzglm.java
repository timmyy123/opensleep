package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzglm implements zzglb {
    private final zzfyz zza;
    private final zzgmw zzb;
    private final zzgox zzc;
    private final zzgqh zzd;
    private final ExecutorService zze;
    private final AtomicReference zzf = new AtomicReference("2.878096153.-1");

    public zzglm(zzfyz zzfyzVar, zzgmw zzgmwVar, zzgox zzgoxVar, zzgqh zzgqhVar, ExecutorService executorService) {
        this.zza = zzfyzVar;
        this.zzb = zzgmwVar;
        this.zzc = zzgoxVar;
        this.zzd = zzgqhVar;
        this.zze = executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final String zza() {
        return (String) this.zzf.get();
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzb() {
        return (zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzg(zzhbo.zzw(this.zzb.zzb()), Throwable.class, zzgll.zza, zzhcn.zza()), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgld
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzh((zzgfq) obj);
                return new Boolean(true);
            }
        }, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgle
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzi((Boolean) obj);
            }
        }, zzhcn.zza()), new zzgta() { // from class: com.google.android.gms.internal.ads.zzglf
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzj((zzfyp) obj);
                return new Boolean(true);
            }
        }, zzhcn.zza()), zzglg.zza, zzhcn.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzc(final Context context) {
        return zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzglh
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzk(context);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzd(final Context context, String str, final View view, final Activity activity) {
        final String str2 = null;
        return zzhbw.zzd(new Callable(context, str2, view, activity) { // from class: com.google.android.gms.internal.ads.zzgli
            private final /* synthetic */ Context zzb;
            private final /* synthetic */ View zzc;
            private final /* synthetic */ Activity zzd;

            {
                this.zzc = view;
                this.zzd = activity;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzl(this.zzb, null, this.zzc, this.zzd);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zze(final Context context, final String str, final View view, Activity activity) {
        final Activity activity2 = null;
        return zzhbw.zzd(new Callable(context, str, view, activity2) { // from class: com.google.android.gms.internal.ads.zzglj
            private final /* synthetic */ Context zzb;
            private final /* synthetic */ String zzc;
            private final /* synthetic */ View zzd;

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzm(this.zzb, this.zzc, this.zzd, null);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final void zzf(InputEvent inputEvent) {
        zzfxj zzfxjVarZzb = this.zza.zzb();
        if (zzfxjVarZzb == null) {
            this.zzd.zzb(15004);
        } else if (inputEvent instanceof MotionEvent) {
            try {
                zzfxjVarZzb.zzd(null, (MotionEvent) inputEvent);
            } catch (zzfyy e) {
                this.zzd.zzd(15005, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final int zzg() {
        return 3;
    }

    public final /* synthetic */ boolean zzh(zzgfq zzgfqVar) {
        if (this.zzc.zzb(zzgfqVar) && zzgfqVar != null) {
            return true;
        }
        this.zzd.zzb(15003);
        throw new zzglc(1);
    }

    public final /* synthetic */ ListenableFuture zzi(Boolean bool) {
        return this.zzb.zze();
    }

    public final /* synthetic */ boolean zzj(final zzfyp zzfypVar) {
        if (zzfypVar == null) {
            throw new zzglc(3);
        }
        File fileZzb = zzfypVar.zzb();
        if (Build.VERSION.SDK_INT >= 34) {
            fileZzb.setReadOnly();
        }
        this.zzd.zzf(15002, new Runnable() { // from class: com.google.android.gms.internal.ads.zzglk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzn(zzfypVar);
            }
        });
        return true;
    }

    public final /* synthetic */ String zzk(Context context) {
        zzfxj zzfxjVarZzb = this.zza.zzb();
        if (zzfxjVarZzb == null) {
            this.zzd.zzb(15004);
            return "";
        }
        String strZza = zzfxjVarZzb.zza(context, null);
        if (strZza != null) {
            return strZza;
        }
        this.zzd.zzb(15006);
        return "";
    }

    public final /* synthetic */ String zzl(Context context, String str, View view, Activity activity) {
        zzfxj zzfxjVarZzb = this.zza.zzb();
        if (zzfxjVarZzb == null) {
            this.zzd.zzb(15004);
            return "";
        }
        String strZzb = zzfxjVarZzb.zzb(context, null, view, activity);
        if (strZzb != null) {
            return strZzb;
        }
        this.zzd.zzb(15007);
        return "";
    }

    public final /* synthetic */ String zzm(Context context, String str, View view, Activity activity) {
        zzfxj zzfxjVarZzb = this.zza.zzb();
        if (zzfxjVarZzb == null) {
            this.zzd.zzb(15004);
            return "";
        }
        String strZzc = zzfxjVarZzb.zzc(context, null, str, view, null);
        if (strZzc != null) {
            return strZzc;
        }
        this.zzd.zzb(15008);
        return "";
    }

    public final /* synthetic */ void zzn(zzfyp zzfypVar) {
        if (!this.zza.zza(zzfypVar)) {
            throw new zzglc(2);
        }
        this.zzf.set("2.878096153.".concat(String.valueOf(zzfypVar.zza().zza())));
    }
}
