package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzifi {
    private final zzifh zza;

    private zzifi(zzihg zzihgVar, Object obj, zzihg zzihgVar2, Object obj2) {
        this.zza = new zzifh(zzihgVar, "", zzihgVar2, obj2);
    }

    public static zzifi zza(zzihg zzihgVar, Object obj, zzihg zzihgVar2, Object obj2) {
        return new zzifi(zzihgVar, "", zzihgVar2, obj2);
    }

    public static void zzb(zzidj zzidjVar, zzifh zzifhVar, Object obj, Object obj2) {
        zzidt.zzf(zzidjVar, zzifhVar.zza, 1, obj);
        zzidt.zzf(zzidjVar, zzifhVar.zzc, 2, obj2);
    }

    public static int zzc(zzifh zzifhVar, Object obj, Object obj2) {
        return zzidt.zzh(zzifhVar.zza, 1, obj) + zzidt.zzh(zzifhVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzifh zzifhVar = this.zza;
        int iZzF = zzidj.zzF(i << 3);
        int iZzc = zzc(zzifhVar, obj, obj2);
        return zzba$$ExternalSyntheticOutline0.m(iZzc, iZzc, iZzF);
    }

    public final zzifh zze() {
        return this.zza;
    }
}
