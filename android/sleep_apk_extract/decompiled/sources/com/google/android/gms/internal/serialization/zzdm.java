package com.google.android.gms.internal.serialization;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
final class zzdm extends zzdn {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzdn zzc;

    public zzdm(zzdn zzdnVar, int i, int i2) {
        this.zzc = zzdnVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdf.zzd(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    @CheckForNull
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.serialization.zzdn, java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzdn subList(int i, int i2) {
        zzdf.zzf(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
