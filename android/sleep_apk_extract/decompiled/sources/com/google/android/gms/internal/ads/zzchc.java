package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class zzchc {
    private final Context zza;
    private final zzchn zzb;
    private final ViewGroup zzc;
    private final zzdzl zzd;
    private zzchb zze;

    public zzchc(Context context, ViewGroup viewGroup, zzcku zzckuVar, zzdzl zzdzlVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzckuVar;
        this.zze = null;
        this.zzd = zzdzlVar;
    }

    public final Integer zza() {
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            return zzchbVar.zzl();
        }
        return null;
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzn(i, i2, i3, i4);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4, int i5, boolean z, zzchm zzchmVar) {
        if (this.zze != null) {
            return;
        }
        zzchn zzchnVar = this.zzb;
        zzbix.zza(zzchnVar.zzq().zzc(), zzchnVar.zzi(), "vpr2");
        zzchb zzchbVar = new zzchb(this.zza, zzchnVar, i5, z, zzchnVar.zzq().zzc(), zzchmVar, this.zzd);
        this.zze = zzchbVar;
        this.zzc.addView(zzchbVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zze.zzn(i, i2, i3, i4);
        zzchnVar.zzdn(false);
    }

    public final zzchb zzd() {
        return this.zze;
    }

    public final void zze() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzr();
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzE();
            this.zzc.removeView(this.zze);
            this.zze = null;
        }
    }

    public final void zzg(int i) {
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzm(i);
        }
    }
}
