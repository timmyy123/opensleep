package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzfcv implements zzfck {
    private final zzhcg zza;
    private final Context zzb;
    private final zzeeb zzc;
    private final String zzd;

    public zzfcv(zzhcg zzhcgVar, Context context, zzeeb zzeebVar, String str) {
        this.zza = zzhcgVar;
        this.zzb = context;
        this.zzc = zzeebVar;
        this.zzd = str;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfcu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 38;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0131 A[PHI: r1
      0x0131: PHI (r1v17 java.lang.String) = (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v8 java.lang.String) binds: [B:34:0x012f, B:37:0x014d, B:38:0x014f, B:77:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ zzfct zzc() {
        ActivityInfo activityInfo;
        boolean z;
        String string;
        PackageInfo packageInfo;
        String string2;
        String str;
        boolean zEquals;
        boolean z2;
        PackageInfo packageInfo2;
        Context context = this.zzb;
        PackageManager packageManager = context.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo resolveInfoZzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo resolveInfoZzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.zzt.zzc();
        com.google.android.gms.ads.internal.client.zzay.zza();
        boolean zZzy = com.google.android.gms.ads.internal.util.client.zzf.zzy();
        boolean zIsLatchsky = DeviceProperties.isLatchsky(context);
        boolean zIsSidewinder = DeviceProperties.isSidewinder(context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        LocaleList localeList = LocaleList.getDefault();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(localeList.get(i).getLanguage());
        }
        ResolveInfo resolveInfoZzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        if (resolveInfoZzd3 == null || (activityInfo = resolveInfoZzd3.activityInfo) == null) {
            string = null;
            z = true;
        } else {
            try {
                z = true;
                try {
                    packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                z = true;
            }
            if (packageInfo != null) {
                int i2 = packageInfo.versionCode;
                String str2 = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 1 + String.valueOf(str2).length());
                sb.append(i2);
                sb.append(".");
                sb.append(str2);
                string = sb.toString();
            } else {
                string = null;
            }
        }
        try {
            packageInfo2 = Wrappers.packageManager(this.zzb).getPackageInfo("com.android.vending", 128);
        } catch (Exception unused3) {
        }
        if (packageInfo2 != null) {
            int i3 = packageInfo2.versionCode;
            String str3 = packageInfo2.packageName;
            StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(str3).length());
            sb2.append(i3);
            sb2.append(".");
            sb2.append(str3);
            string2 = sb2.toString();
        } else {
            string2 = null;
        }
        String strZza = null;
        String str4 = Build.FINGERPRINT;
        String language2 = Locale.getDefault().getLanguage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoV)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzq zzqVarZzk = com.google.android.gms.ads.internal.util.zzs.zzk(this.zzb);
            language2 = zzqVarZzk.zzb();
            strZza = zzqVarZzk.zza();
        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoU)).booleanValue()) {
            language2 = com.google.android.gms.ads.internal.util.zzs.zzk(this.zzb).zzb();
        }
        String str5 = strZza;
        String str6 = language2;
        Context context2 = this.zzb;
        if (packageManager == null) {
            str = string2;
            zEquals = false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i4 = 0;
                while (i4 < listQueryIntentActivities.size()) {
                    str = string2;
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i4).activityInfo.name)) {
                        zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzink.zza(context2));
                        break;
                    }
                    i4++;
                    string2 = str;
                }
                str = string2;
                zEquals = false;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmM)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            z2 = com.google.android.gms.ads.internal.util.zzs.zzE(context2) ? z : false;
        }
        return new zzfct(resolveInfoZzd != null ? z : false, resolveInfoZzd2 != null ? z : false, country, zZzy, zIsLatchsky, zIsSidewinder, language, arrayList, string, str, str4, zEquals, Build.MODEL, availableBytes, z2, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmQ)).booleanValue() ? ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmS)).booleanValue() ? this.zzd : com.google.android.gms.ads.internal.util.client.zzf.zzf(context2) : "", Build.VERSION.SDK_INT, str6, str5, this.zzc.zza());
    }
}
