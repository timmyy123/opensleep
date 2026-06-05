package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzfi$zza;
import com.google.android.gms.internal.vision.zzfi$zzf;
import com.google.android.gms.internal.vision.zzfi$zzi;
import com.google.android.gms.internal.vision.zzfi$zzj;
import com.google.android.gms.internal.vision.zzfi$zzn;
import com.google.android.gms.internal.vision.zzfi$zzo;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.L;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LogUtils {
    public static zzfi$zzo zza(long j, int i, String str, String str2, List<zzfi$zzn> list, zzs zzsVar) {
        zzfi$zzi.zza zzaVarZza = zzfi$zzi.zza();
        zzfi$zzf.zzb zzbVarZzb = zzfi$zzf.zza().zza(str2).zza(j).zzb(i);
        zzbVarZzb.zza(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((zzfi$zzf) ((zzjb) zzbVarZzb.zzf()));
        return (zzfi$zzo) ((zzjb) zzfi$zzo.zza().zza((zzfi$zzi) ((zzjb) zzaVarZza.zza(arrayList).zza((zzfi$zzj) ((zzjb) zzfi$zzj.zza().zzb(zzsVar.zzb).zza(zzsVar.zza).zzc(zzsVar.zzc).zzd(zzsVar.zzd).zzf())).zzf())).zzf());
    }

    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }

    public static zzfi$zza zza(Context context) {
        zzfi$zza.zza zzaVarZza = zzfi$zza.zza().zza(context.getPackageName());
        String strZzb = zzb(context);
        if (strZzb != null) {
            zzaVarZza.zzb(strZzb);
        }
        return (zzfi$zza) ((zzjb) zzaVarZza.zzf());
    }
}
