package com.google.android.gms.internal.measurement;

import android.os.Trace;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzwr {
    public static void zza(zzws zzwsVar, zzws zzwsVar2) {
        if (zzwsVar != null) {
            if (zzwsVar2 != null) {
                if (zzwsVar.zzb() == zzwsVar2 && !zzd(zzwsVar)) {
                    Trace.endSection();
                    return;
                } else if (zzwsVar == zzwsVar2.zzb() && !zzd(zzwsVar2)) {
                    zze(zzwsVar2);
                    return;
                }
            }
            zzc(zzwsVar);
        }
        if (zzwsVar2 != null) {
            zzb(zzwsVar2);
        }
    }

    public static void zzb(zzws zzwsVar) {
        if (zzd(zzwsVar) || zzwsVar.zzb() == null) {
            Trace.beginSection(zzwsVar.zzd());
            zze(zzwsVar);
        } else {
            zzb(zzwsVar.zzb());
            zze(zzwsVar);
        }
    }

    public static void zzc(zzws zzwsVar) {
        if (zzd(zzwsVar) || zzwsVar.zzb() == null) {
            Trace.endSection();
            Trace.endSection();
        } else {
            Trace.endSection();
            zzc(zzwsVar.zzb());
        }
    }

    private static boolean zzd(zzws zzwsVar) {
        return zzwsVar.zza() != Thread.currentThread();
    }

    private static void zze(zzws zzwsVar) {
        String strZze = zzwsVar.zze();
        zzrg zzrgVar = zzvy.zza;
        if (strZze.length() > 127) {
            strZze = strZze.substring(0, 127);
        }
        Trace.beginSection(strZze);
    }
}
