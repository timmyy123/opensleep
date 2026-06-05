package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzguf {
    public static zzgub zza(zzgub zzgubVar) {
        return ((zzgubVar instanceof zzgue) || (zzgubVar instanceof zzguc)) ? zzgubVar : zzgubVar instanceof Serializable ? new zzguc(zzgubVar) : new zzgue(zzgubVar);
    }
}
