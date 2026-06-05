package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: loaded from: classes3.dex */
final class zzec implements zzdm {
    private final String info;
    private final zzdo zzmn;
    private final zzed zzng;

    public zzec(zzdo zzdoVar, String str, Object[] objArr) {
        this.zzmn = zzdoVar;
        this.info = str;
        this.zzng = new zzed(zzdoVar.getClass(), str, objArr);
    }

    public final int getFieldCount() {
        return this.zzng.zznj;
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final int zzcf() {
        return (this.zzng.flags & 1) == 1 ? zzcg.zzg.zzkl : zzcg.zzg.zzkm;
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final boolean zzcg() {
        return (this.zzng.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final zzdo zzch() {
        return this.zzmn;
    }

    public final zzed zzco() {
        return this.zzng;
    }

    public final int zzcp() {
        return this.zzng.zzmk;
    }

    public final int zzcq() {
        return this.zzng.zzml;
    }

    public final int zzcr() {
        return this.zzng.zznm;
    }

    public final int zzcs() {
        return this.zzng.zzno;
    }

    public final int[] zzct() {
        return this.zzng.zzms;
    }

    public final int zzcu() {
        return this.zzng.zznn;
    }

    public final int zzcv() {
        return this.zzng.zzmm;
    }
}
