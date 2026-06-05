package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdh implements Serializable {
    public static zzdh zzc() {
        return zzdf.zza;
    }

    public static zzdh zzd(Object obj) {
        return new zzdi(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
