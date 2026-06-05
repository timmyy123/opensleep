package com.google.android.gms.internal.fitness;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzfe extends zzet {
    final transient Object zza;

    public zzfe(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.fitness.zzem, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.fitness.zzet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new zzeu(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(string).length() + 2), "[", string, "]");
    }

    @Override // com.google.android.gms.internal.fitness.zzem
    public final int zze(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }
}
