package com.google.android.gms.internal.serialization;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaaj<K, V> {
    private final zzaai zza;

    private zzaaj(zzace zzaceVar, Object obj, zzace zzaceVar2, Object obj2) {
        this.zza = new zzaai(zzaceVar, "", zzaceVar2, obj2);
    }

    public static zzaaj zza(zzace zzaceVar, Object obj, zzace zzaceVar2, Object obj2) {
        return new zzaaj(zzaceVar, "", zzaceVar2, obj2);
    }

    public static void zzb(zzxb zzxbVar, zzaai zzaaiVar, Object obj, Object obj2) {
        zzyu.zzm(zzxbVar, zzaaiVar.zza, 1, obj);
        zzyu.zzm(zzxbVar, zzaaiVar.zzc, 2, obj2);
    }

    public static int zzc(zzaai zzaaiVar, Object obj, Object obj2) {
        return zzyu.zzp(zzaaiVar.zza, 1, obj) + zzyu.zzp(zzaaiVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzaai zzaaiVar = this.zza;
        int iZzD = zzxb.zzD(i << 3);
        int iZzc = zzc(zzaaiVar, obj, obj2);
        return zza$$ExternalSyntheticOutline0.m$1(iZzc, iZzc, iZzD);
    }

    public final zzaai zze() {
        return this.zza;
    }
}
