package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcea {
    static zzcea zzi;

    public static synchronized zzcea zzb(Context context) {
        try {
            zzcea zzceaVar = zzi;
            if (zzceaVar != null) {
                return zzceaVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbiq.zza(applicationContext);
            com.google.android.gms.ads.internal.util.zzg zzgVarZzo = com.google.android.gms.ads.internal.zzt.zzh().zzo();
            zzgVarZzo.zza(applicationContext);
            zzcdu zzcduVar = new zzcdu(null);
            zzcduVar.zza(applicationContext);
            zzcduVar.zzb(com.google.android.gms.ads.internal.zzt.zzk());
            zzcduVar.zzc(zzgVarZzo);
            zzcduVar.zzd(com.google.android.gms.ads.internal.zzt.zzD());
            zzcea zzceaVarZze = zzcduVar.zze();
            zzi = zzceaVarZze;
            ((zzcdo) ((zzcdv) zzceaVarZze).zzc.zzb()).zza();
            final zzcef zzcefVar = (zzcef) ((zzcdv) zzi).zzh.zzb();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbf)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                final Map mapZzx = com.google.android.gms.ads.internal.util.zzs.zzx((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbg));
                Iterator it = mapZzx.keySet().iterator();
                while (it.hasNext()) {
                    zzcefVar.zzb((String) it.next());
                }
                zzcefVar.zza(new zzced() { // from class: com.google.android.gms.internal.ads.zzcee
                    @Override // com.google.android.gms.internal.ads.zzced
                    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str, String str2) {
                        zzcefVar.zzc(mapZzx, sharedPreferences, str, str2);
                    }
                });
            }
            return zzi;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract zzcds zza();
}
