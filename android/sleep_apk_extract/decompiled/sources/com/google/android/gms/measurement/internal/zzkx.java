package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzkx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzky zze;

    public zzkx(zzky zzkyVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        Objects.requireNonNull(zzkyVar);
        this.zze = zzkyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleZzi;
        zzic zzicVar;
        Bundle bundleZzi2;
        zzky zzkyVar = this.zze;
        zzlj zzljVar = zzkyVar.zza;
        zzljVar.zzg();
        String str = this.zzd;
        Uri uri = this.zzb;
        try {
            zzic zzicVar2 = zzljVar.zzu;
            zzpp zzppVarZzk = zzicVar2.zzk();
            if (TextUtils.isEmpty(str)) {
                bundleZzi = null;
            } else if (str.contains("gclid") || str.contains("gbraid") || str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_id") || str.contains("dclid") || str.contains("srsltid") || str.contains("sfmc_id")) {
                bundleZzi = zzppVarZzk.zzi(Uri.parse("https://google.com/search?".concat(str)));
                if (bundleZzi != null) {
                    bundleZzi.putString("_cis", "referrer");
                }
            } else {
                zzppVarZzk.zzu.zzaW().zzj().zza("Activity created with data 'referrer' without required params");
                bundleZzi = null;
            }
            String str2 = this.zzc;
            if (!this.zza || (bundleZzi2 = zzicVar2.zzk().zzi(uri)) == null) {
                zzicVar = zzicVar2;
            } else {
                bundleZzi2.putString("_cis", SDKConstants.PARAM_INTENT);
                if (bundleZzi2.containsKey("gclid") || bundleZzi == null || !bundleZzi.containsKey("gclid")) {
                    zzicVar = zzicVar2;
                } else {
                    zzicVar = zzicVar2;
                    bundleZzi2.putString("_cer", "gclid=" + bundleZzi.getString("gclid"));
                }
                zzljVar.zzE(str2, "_cmp", bundleZzi2);
                zzljVar.zzb.zzb(str2, bundleZzi2);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            zzicVar.zzaW().zzj().zzb("Activity created with referrer", str);
            if (zzicVar.zzc().zzp(null, zzfy.zzaG)) {
                if (bundleZzi != null) {
                    zzljVar.zzE(str2, "_cmp", bundleZzi);
                    zzljVar.zzb.zzb(str2, bundleZzi);
                } else {
                    zzicVar.zzaW().zzj().zzb("Referrer does not contain valid parameters", str);
                }
                zzljVar.zzJ("auto", "_ldl", null, true);
                return;
            }
            if (!str.contains("gclid") || (!str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_term") && !str.contains("utm_content"))) {
                zzicVar.zzaW().zzj().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                zzljVar.zzJ("auto", "_ldl", str, true);
            }
        } catch (RuntimeException e) {
            zzkyVar.zza.zzu.zzaW().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
