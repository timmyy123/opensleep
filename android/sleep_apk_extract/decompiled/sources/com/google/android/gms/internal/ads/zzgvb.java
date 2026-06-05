package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class zzgvb extends zzguz implements List {
    final /* synthetic */ zzgvc zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgvb(zzgvc zzgvcVar, Object obj, List list, zzguz zzguzVar) {
        super(zzgvcVar, obj, list, zzguzVar);
        Objects.requireNonNull(zzgvcVar);
        this.zzf = zzgvcVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzgvc zzgvcVar = this.zzf;
        zzgvcVar.zzq(zzgvcVar.zzp() + 1);
        if (zIsEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i, collection);
        if (zAddAll) {
            int size2 = this.zzb.size();
            zzgvc zzgvcVar = this.zzf;
            zzgvcVar.zzq(zzgvcVar.zzp() + (size2 - size));
            if (size == 0) {
                zzc();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zza();
        return ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zza();
        return new zzgva(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        zza();
        Object objRemove = ((List) this.zzb).remove(i);
        this.zzf.zzq(r0.zzp() - 1);
        zzb();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        zza();
        return ((List) this.zzb).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        zza();
        List listSubList = ((List) this.zzb).subList(i, i2);
        zzguz zzguzVar = this.zzc;
        if (zzguzVar == null) {
            zzguzVar = this;
        }
        return this.zzf.zzg(this.zza, listSubList, zzguzVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        zza();
        return new zzgva(this, i);
    }
}
