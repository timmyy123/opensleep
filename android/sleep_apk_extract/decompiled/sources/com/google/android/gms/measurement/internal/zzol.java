package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzol extends zzje implements zzjg {
    protected final zzpg zzg;

    public zzol(zzpg zzpgVar) {
        super(zzpgVar.zzah());
        Preconditions.checkNotNull(zzpgVar);
        this.zzg = zzpgVar;
    }
}
