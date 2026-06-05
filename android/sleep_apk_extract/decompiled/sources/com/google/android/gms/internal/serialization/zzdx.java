package com.google.android.gms.internal.serialization;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdx extends zzdn {
    static final zzdn zza = new zzdx(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzdx(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdf.zzd(i, this.zzc, "index");
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzdj
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.serialization.zzdn, com.google.android.gms.internal.serialization.zzdj
    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
