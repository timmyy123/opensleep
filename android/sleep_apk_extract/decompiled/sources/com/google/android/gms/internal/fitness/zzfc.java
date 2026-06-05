package com.google.android.gms.internal.fitness;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzfc extends zzet {
    static final zzfc zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzfc(objArr, 0, objArr, 0, 0);
    }

    public zzfc(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.fitness.zzem, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzel.zza(obj.hashCode());
                while (true) {
                    int i = iZza & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fitness.zzet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzi().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzem
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fitness.zzem
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fitness.zzem
    public final int zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzem
    public final int zze(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.fitness.zzet
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.fitness.zzet
    public final zzep zzj() {
        return zzep.zzh(this.zzb, this.zzg);
    }
}
