package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzco {
    private final Application zza;
    private zzha zzb;
    private zzgw zzd;
    private zzgt zzc = null;
    private String zze = null;

    public zzco(Application application) {
        this.zza = application;
    }

    public final zzif zza(int i, String str, long j) {
        Bundle bundle;
        zzid zzidVarZza = zzif.zza();
        zzgu zzguVarZza = zzhc.zza();
        zzgx zzgxVarZza = zzgy.zza();
        zzgxVarZza.zzc(i);
        if (str != null) {
            zzgxVarZza.zza(str);
        }
        if (j > 0) {
            zzgxVarZza.zzb(j);
        }
        zzguVarZza.zze((zzgy) zzgxVarZza.zzi());
        String str2 = this.zze;
        PackageInfo packageInfo = null;
        if (str2 == null) {
            try {
                Application application = this.zza;
                bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                bundle = null;
            }
            if (bundle != null) {
                this.zze = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
            }
            if (TextUtils.isEmpty(this.zze)) {
                Log.w("UserMessagingPlatform", "The UMP SDK requires a valid application ID in your AndroidManifest.xml through a com.google.android.gms.ads.APPLICATION_ID meta-data tag.\nExample AndroidManifest:\n    <meta-data\n        android:name=\"com.google.android.gms.ads.APPLICATION_ID\"\n        android:value=\"ca-app-pub-0000000000000000~0000000000\">");
            }
            str2 = this.zze;
        }
        if (str2 != null) {
            zzguVarZza.zzb(str2);
        }
        zzha zzhaVar = this.zzb;
        if (zzhaVar == null) {
            zzgz zzgzVarZza = zzha.zza();
            zzgzVarZza.zza("4.0.0");
            zzhaVar = (zzha) zzgzVarZza.zzi();
            this.zzb = zzhaVar;
        }
        zzguVarZza.zzf(zzhaVar);
        zzgw zzgwVar = this.zzd;
        if (zzgwVar == null) {
            zzgv zzgvVarZza = zzgw.zza();
            zzgvVarZza.zza(Build.VERSION.SDK_INT);
            zzgvVarZza.zzb(Build.MODEL);
            zzgvVarZza.zzd(3);
            zzgvVarZza.zzc(Build.VERSION.RELEASE);
            zzgwVar = (zzgw) zzgvVarZza.zzi();
            this.zzd = zzgwVar;
        }
        zzguVarZza.zzd(zzgwVar);
        zzgt zzgtVar = this.zzc;
        if (zzgtVar == null) {
            Application application2 = this.zza;
            String packageName = application2.getPackageName();
            try {
                packageInfo = application2.getPackageManager().getPackageInfo(packageName, 0);
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (packageInfo != null) {
                zzgs zzgsVarZza = zzgt.zza();
                zzgsVarZza.zzb(Long.toString(Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode));
                zzgsVarZza.zza(packageName);
                this.zzc = (zzgt) zzgsVarZza.zzi();
            }
            zzgtVar = this.zzc;
        }
        if (zzgtVar != null) {
            zzguVarZza.zzc(zzgtVar);
        }
        String string = PreferenceManager.getDefaultSharedPreferences(this.zza).getString("UMP_eids", "");
        if (string != null && !string.isEmpty()) {
            Iterator it = zzdo.zza(',').zzb(string).iterator();
            while (it.hasNext()) {
                zzguVarZza.zza((String) it.next());
            }
        }
        zzidVarZza.zza((zzhc) zzguVarZza.zzi());
        zzidVarZza.zzb(System.currentTimeMillis());
        return (zzif) zzidVarZza.zzi();
    }
}
