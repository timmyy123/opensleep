package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzcey;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcfu;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzl;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfqj;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzhcg;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzf {
    private Context zza;
    private long zzb = 0;

    public static final /* synthetic */ ListenableFuture zzd(Long l, zzdzl zzdzlVar, zzfpw zzfpwVar, zzfqj zzfqjVar, JSONObject jSONObject) throws JSONException {
        boolean zOptBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (zOptBoolean) {
            zzt.zzh().zzo().zzh(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdzlVar, "cld_s", zzt.zzk().elapsedRealtime() - l.longValue());
            }
        }
        String strOptString = jSONObject.optString("errorReason", "");
        if (!TextUtils.isEmpty(strOptString)) {
            zzfpwVar.zzk(strOptString);
        }
        zzfpwVar.zzd(zOptBoolean);
        zzfqjVar.zzb(zzfpwVar.zzm());
        return zzhbw.zza(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(zzdzl zzdzlVar, String str, long j) {
        if (zzdzlVar != null) {
            if (((Boolean) zzba.zzc().zzd(zzbiq.zzof)).booleanValue()) {
                zzdzk zzdzkVarZza = zzdzlVar.zza();
                zzdzkVarZza.zzc("action", "lat_init");
                zzdzkVarZza.zzc(str, Long.toString(j));
                zzdzkVarZza.zzd();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfqj zzfqjVar, zzdzl zzdzlVar, Long l, boolean z) {
        zzc(context, versionInfoParcel, true, null, str, null, runnable, zzfqjVar, zzdzlVar, l, z);
    }

    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, String str, zzcey zzceyVar, zzfqj zzfqjVar, boolean z) {
        zzc(context, versionInfoParcel, false, zzceyVar, zzceyVar != null ? zzceyVar.zze() : null, str, null, zzfqjVar, null, null, z);
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzcey zzceyVar, String str, String str2, Runnable runnable, zzfqj zzfqjVar, final zzdzl zzdzlVar, final Long l, boolean z2) {
        zzfpw zzfpwVar;
        Exception exc;
        JSONObject jSONObject;
        ListenableFuture listenableFutureZzb;
        zzhbe zzhbeVar;
        PackageInfo packageInfo;
        final zzfqj zzfqjVar2 = zzfqjVar;
        if (zzt.zzk().elapsedRealtime() - this.zzb < 5000) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzk().elapsedRealtime();
        if (zzceyVar != null && !TextUtils.isEmpty(zzceyVar.zzd())) {
            if (zzt.zzk().currentTimeMillis() - zzceyVar.zzb() <= ((Long) zzba.zzc().zzd(zzbiq.zzfb)).longValue() && zzceyVar.zzc()) {
                return;
            }
        }
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfpw zzfpwVarZzn = zzfpw.zzn(context, 4);
        zzfpwVarZzn.zza();
        zzbui zzbuiVarZzb = zzt.zzr().zzb(this.zza, versionInfoParcel, zzfqjVar2);
        zzbuc zzbucVar = zzbuf.zza;
        zzbty zzbtyVarZza = zzbuiVarZzb.zza("google.afma.config.fetchAppSettings", zzbucVar, zzbucVar);
        try {
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
            zzfpwVar = zzfpwVarZzn;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbih zzbihVar = zzbiq.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zzb().zze()));
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            if (((Boolean) zzba.zzc().zzd(zzbiq.zzkU)).booleanValue()) {
                jSONObject.put("inspector_enabled", z2);
            }
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            listenableFutureZzb = zzbtyVarZza.zzb(jSONObject);
            try {
                zzhbeVar = new zzhbe(this) { // from class: com.google.android.gms.ads.internal.zzd
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return zzf.zzd(l, zzdzlVar, zzfpwVarZzn, zzfqjVar2, (JSONObject) obj);
                    }
                };
                zzfpwVar = zzfpwVarZzn;
                zzfqjVar2 = zzfqjVar2;
            } catch (Exception e2) {
                e = e2;
                zzfpwVar = zzfpwVarZzn;
                zzfqjVar2 = zzfqjVar2;
            }
        } catch (Exception e3) {
            exc = e3;
            zzfpwVar = zzfpwVarZzn;
            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error requesting application settings", exc);
            zzfpwVar.zzj(exc);
            zzfpwVar.zzd(false);
            zzfqjVar2.zzb(zzfpwVar.zzm());
        }
        try {
            zzhcg zzhcgVar = zzcfr.zzh;
            ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZzb, zzhbeVar, zzhcgVar);
            if (runnable != null) {
                listenableFutureZzb.addListener(runnable, zzhcgVar);
            }
            if (l != null) {
                listenableFutureZzb.addListener(new Runnable(this) { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzf.zzf(zzdzlVar, "cld_r", zzt.zzk().elapsedRealtime() - l.longValue());
                    }
                }, zzhcgVar);
            }
            if (((Boolean) zzba.zzc().zzd(zzbiq.zziG)).booleanValue()) {
                zzcfu.zzb(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzcfu.zza(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings", zzhcgVar);
            }
        } catch (Exception e4) {
            e = e4;
            exc = e;
            int i42 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error requesting application settings", exc);
            zzfpwVar.zzj(exc);
            zzfpwVar.zzd(false);
            zzfqjVar2.zzb(zzfpwVar.zzm());
        }
    }
}
