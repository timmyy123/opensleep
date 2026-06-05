package com.google.android.gms.measurement.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzgr implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzgu zzf;

    public zzgr(zzgu zzguVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        Objects.requireNonNull(zzguVar);
        this.zzf = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgu zzguVar = this.zzf;
        zzhh zzhhVarZzd = zzguVar.zzu.zzd();
        if (!zzhhVarZzd.zzv()) {
            Log.println(6, zzguVar.zzn(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (zzguVar.zzr() == 0) {
            zzic zzicVar = zzguVar.zzu;
            if (zzicVar.zzc().zzj()) {
                zzicVar.zzaV();
                zzguVar.zzs('C');
            } else {
                zzicVar.zzaV();
                zzguVar.zzs('c');
            }
        }
        if (zzguVar.zzt() < 0) {
            zzguVar.zzu.zzc().zzi();
            zzguVar.zzu(161000L);
        }
        int i = this.zza;
        char cZzr = zzguVar.zzr();
        long jZzt = zzguVar.zzt();
        String str = this.zzb;
        Object obj = this.zzc;
        Object obj2 = this.zzd;
        Object obj3 = this.zze;
        char cCharAt = "01VDIWEA?".charAt(i);
        String strZzo = zzgu.zzo(true, str, obj, obj2, obj3);
        StringBuilder sb = new StringBuilder(FileInsert$$ExternalSyntheticOutline0.m(String.valueOf(cCharAt).length() + 1, String.valueOf(cZzr).length(), String.valueOf(jZzt).length(), 1) + strZzo.length());
        sb.append("2");
        sb.append(cCharAt);
        sb.append(cZzr);
        sb.append(jZzt);
        sb.append(":");
        sb.append(strZzo);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = str.substring(0, 1024);
        }
        zzhf zzhfVar = zzhhVarZzd.zzb;
        if (zzhfVar != null) {
            zzhfVar.zza(string, 1L);
        }
    }
}
