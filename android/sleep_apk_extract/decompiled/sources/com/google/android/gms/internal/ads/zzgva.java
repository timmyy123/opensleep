package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgva extends zzguy implements ListIterator {
    final /* synthetic */ zzgvb zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgva(zzgvb zzgvbVar, int i) {
        super(zzgvbVar, ((List) zzgvbVar.zzb).listIterator(i));
        Objects.requireNonNull(zzgvbVar);
        this.zzd = zzgvbVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        zzgvb zzgvbVar = this.zzd;
        boolean zIsEmpty = zzgvbVar.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzgvc zzgvcVar = zzgvbVar.zzf;
        zzgvcVar.zzq(zzgvcVar.zzp() + 1);
        if (zIsEmpty) {
            zzgvbVar.zzc();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgva(zzgvb zzgvbVar) {
        super(zzgvbVar);
        Objects.requireNonNull(zzgvbVar);
        this.zzd = zzgvbVar;
    }
}
