package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzgjw implements zzgfr {
    private final zzimo zza;
    private final zzimo zzb;
    private final zzimo zzc;
    private final boolean zzd;
    private final long zze;

    public zzgjw(zzimo zzimoVar, zzimo zzimoVar2, zzimo zzimoVar3, boolean z, long j) {
        this.zza = zzimoVar;
        this.zzb = zzimoVar2;
        this.zzc = zzimoVar3;
        this.zzd = z;
        this.zze = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final String zza() {
        return ((zzglb) this.zzb.zzb()).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzb() {
        if (this.zzd) {
            return (zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzg(zzhbo.zzw(((zzgko) this.zza.zzb()).zzb()), Throwable.class, zzgjs.zza, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgjt
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzj((zzgkn) obj);
                }
            }, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgju
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzk((Boolean) obj);
                }
            }, zzhcn.zza());
        }
        zzhbo zzhboVar = (zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzg(zzhbo.zzw(((zzgmv) this.zzc.zzb()).zza()), Throwable.class, zzgjv.zza, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgjq
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzh((Boolean) obj);
            }
        }, zzhcn.zza());
        zzhboVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgjr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzi();
            }
        }, zzhcn.zza());
        return zzhboVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzc(Context context) {
        return ((zzglb) this.zzb.zzb()).zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zzd(Context context, String str, View view, Activity activity) {
        return ((zzglb) this.zzb.zzb()).zzd(context, null, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final ListenableFuture zze(Context context, String str, View view, Activity activity) {
        return ((zzglb) this.zzb.zzb()).zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final void zzf(InputEvent inputEvent) {
        ((zzglb) this.zzb.zzb()).zzf(inputEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzgfr
    public final int zzg() {
        return ((zzglb) this.zzb.zzb()).zzg();
    }

    public final /* synthetic */ ListenableFuture zzh(Boolean bool) {
        return ((zzglb) this.zzb.zzb()).zzb();
    }

    public final /* synthetic */ void zzi() {
        ((zzgko) this.zza.zzb()).zza(this.zze);
    }

    public final /* synthetic */ ListenableFuture zzj(zzgkn zzgknVar) {
        return ((zzgmv) this.zzc.zzb()).zza();
    }

    public final /* synthetic */ ListenableFuture zzk(Boolean bool) {
        return ((zzglb) this.zzb.zzb()).zzb();
    }
}
