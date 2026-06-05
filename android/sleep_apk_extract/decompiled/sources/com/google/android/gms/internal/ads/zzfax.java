package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfax implements zzfck {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;

    public zzfax(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    @Override // com.google.android.gms.internal.ads.zzfck
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zza() {
        String strValueOf;
        String installingPackageName;
        String str;
        InstallSourceInfo installSourceInfo;
        String initiatingPackageName;
        String str2 = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        String str3 = null;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        String str4 = packageInfo == null ? null : packageInfo.versionName;
        try {
            Context context = this.zzc;
            zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.zza;
            strValueOf = String.valueOf(Wrappers.packageManager(context).getApplicationLabel(str2));
        } catch (PackageManager.NameNotFoundException unused) {
            strValueOf = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzol)).booleanValue()) {
                try {
                    installSourceInfo = this.zzc.getPackageManager().getInstallSourceInfo(str2);
                } catch (PackageManager.NameNotFoundException e) {
                    e = e;
                    installingPackageName = null;
                }
                if (installSourceInfo != null) {
                    installingPackageName = installSourceInfo.getInstallingPackageName();
                    try {
                        if (TextUtils.isEmpty(installingPackageName)) {
                            com.google.android.gms.ads.internal.util.zze.zza("No installing package name found");
                            installingPackageName = null;
                        }
                        try {
                            initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                        } catch (PackageManager.NameNotFoundException e2) {
                            e = e2;
                        }
                        try {
                            if (TextUtils.isEmpty(initiatingPackageName)) {
                                com.google.android.gms.ads.internal.util.zze.zza("No initiating package name found");
                            } else {
                                str = initiatingPackageName;
                            }
                        } catch (PackageManager.NameNotFoundException e3) {
                            e = e3;
                            str3 = initiatingPackageName;
                            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PackageInfoSignalSource.getInstallSourceInfo");
                        }
                    } catch (PackageManager.NameNotFoundException e4) {
                        e = e4;
                    }
                    str = str3;
                } else {
                    installingPackageName = null;
                    str = null;
                }
            }
        }
        return zzhbw.zza(new zzfay(str2, numValueOf, str4, strValueOf, installingPackageName, str));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 29;
    }
}
