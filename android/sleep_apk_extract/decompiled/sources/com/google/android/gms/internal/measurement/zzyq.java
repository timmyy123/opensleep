package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzyq {
    public static final zzyq zzc = new zzym();
    public static final zzyq zzd = new zzym();

    public static zzyq zzc(zzyq zzyqVar, zzyq zzyqVar2) {
        zzyq zzyqVar3;
        zzyq zzyqVar4;
        return zzyqVar == null ? zzyqVar2 : (zzyqVar2 == null || zzyqVar == (zzyqVar3 = zzc) || zzyqVar2 == (zzyqVar4 = zzd)) ? zzyqVar : (zzyqVar2 == zzyqVar3 || zzyqVar == zzyqVar4) ? zzyqVar2 : new zzyn(zzyqVar, zzyqVar2);
    }

    public abstract void zzb();
}
