package com.google.android.gms.internal.measurement;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaev {
    private final zzaeu zza;

    private zzaev(zzagm zzagmVar, Object obj, zzagm zzagmVar2, Object obj2) {
        this.zza = new zzaeu(zzagmVar, "", zzagmVar2, obj2);
    }

    public static zzaev zza(zzagm zzagmVar, Object obj, zzagm zzagmVar2, Object obj2) {
        return new zzaev(zzagmVar, "", zzagmVar2, obj2);
    }

    public static void zzb(zzada zzadaVar, zzaeu zzaeuVar, Object obj, Object obj2) {
        zzadk.zzf(zzadaVar, zzaeuVar.zza, 1, obj);
        zzadk.zzf(zzadaVar, zzaeuVar.zzc, 2, obj2);
    }

    public static int zzc(zzaeu zzaeuVar, Object obj, Object obj2) {
        return zzadk.zzh(zzaeuVar.zza, 1, obj) + zzadk.zzh(zzaeuVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzaeu zzaeuVar = this.zza;
        int iZzE = zzada.zzE(i << 3);
        int iZzc = zzc(zzaeuVar, obj, obj2);
        return zza$$ExternalSyntheticOutline0.m$2(iZzc, iZzc, iZzE);
    }

    public final zzaeu zze() {
        return this.zza;
    }
}
