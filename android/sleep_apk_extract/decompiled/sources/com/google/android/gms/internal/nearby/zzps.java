package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
final class zzps extends zzpt {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzpt zzc;

    public zzps(zzpt zzptVar, int i, int i2) {
        this.zzc = zzptVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzpm.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzpq
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzpq
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzpq
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzpq
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.nearby.zzpt, java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzpt subList(int i, int i2) {
        zzpm.zzh(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
