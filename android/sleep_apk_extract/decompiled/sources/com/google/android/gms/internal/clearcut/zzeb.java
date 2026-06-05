package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzeb<E> extends zzav<E> {
    private static final zzeb<Object> zznf;
    private final List<E> zzls;

    static {
        zzeb<Object> zzebVar = new zzeb<>();
        zznf = zzebVar;
        zzebVar.zzv();
    }

    public zzeb() {
        this(new ArrayList(10));
    }

    public static <E> zzeb<E> zzcn() {
        return (zzeb<E>) zznf;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        zzw();
        this.zzls.add(i, e);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.zzls.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzw();
        E eRemove = this.zzls.remove(i);
        ((AbstractList) this).modCount++;
        return eRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzw();
        E e2 = this.zzls.set(i, e);
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzls.size();
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i < size()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzls);
        return new zzeb(arrayList);
    }

    private zzeb(List<E> list) {
        this.zzls = list;
    }
}
