package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcaa;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccu;
import com.google.android.gms.internal.ads.zzcem;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaw {
    private final zzk zza;
    private final zzi zzb;
    private final zzfc zzc;
    private final zzbnx zzd;
    private final zzbyy zze;
    private zzcaa zzf;
    private final zzl zzg;

    public zzaw(zzk zzkVar, zzi zziVar, zzfc zzfcVar, zzbnx zzbnxVar, zzccu zzccuVar, zzbyy zzbyyVar, zzbny zzbnyVar, zzl zzlVar) {
        this.zza = zzkVar;
        this.zzb = zziVar;
        this.zzc = zzfcVar;
        this.zzd = zzbnxVar;
        this.zze = zzbyyVar;
        this.zzg = zzlVar;
    }

    public static /* synthetic */ void zzl(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zza().zzi(context, zzay.zzg().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbu zza(Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        return (zzbu) new zzam(this, context, zzrVar, str, zzbvcVar).zzd(context, false);
    }

    public final zzbu zzb(Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        return (zzbu) new zzan(this, context, zzrVar, str, zzbvcVar).zzd(context, false);
    }

    public final zzbq zzc(Context context, String str, zzbvc zzbvcVar) {
        return (zzbq) new zzap(this, context, str, zzbvcVar).zzd(context, false);
    }

    public final zzch zzd(Context context, zzbvc zzbvcVar) {
        return (zzch) new zzar(this, context, zzbvcVar).zzd(context, false);
    }

    public final zzbmi zze(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbmi) new zzav(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzcci zzf(Context context, String str, zzbvc zzbvcVar) {
        return (zzcci) new zzaa(this, context, str, zzbvcVar).zzd(context, false);
    }

    public final zzbzb zzg(Activity activity) {
        zzac zzacVar = new zzac(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.zzf("useClientJar flag not found in activity intent extras.");
        }
        return (zzbzb) zzacVar.zzd(activity, booleanExtra);
    }

    public final zzdt zzh(Context context, zzbvc zzbvcVar) {
        return (zzdt) new zzae(this, context, zzbvcVar).zzd(context, false);
    }

    public final zzcem zzi(Context context, zzbvc zzbvcVar) {
        return (zzcem) new zzag(this, context, zzbvcVar).zzd(context, false);
    }

    public final zzbyu zzj(Context context, zzbvc zzbvcVar) {
        return (zzbyu) new zzai(this, context, zzbvcVar).zzd(context, false);
    }

    public final /* synthetic */ zzk zzm() {
        return this.zza;
    }

    public final /* synthetic */ zzi zzn() {
        return this.zzb;
    }

    public final /* synthetic */ zzfc zzo() {
        return this.zzc;
    }

    public final /* synthetic */ zzbnx zzp() {
        return this.zzd;
    }

    public final /* synthetic */ zzbyy zzq() {
        return this.zze;
    }

    public final /* synthetic */ zzcaa zzr() {
        return this.zzf;
    }

    public final /* synthetic */ void zzs(zzcaa zzcaaVar) {
        this.zzf = zzcaaVar;
    }

    public final /* synthetic */ zzl zzt() {
        return this.zzg;
    }
}
