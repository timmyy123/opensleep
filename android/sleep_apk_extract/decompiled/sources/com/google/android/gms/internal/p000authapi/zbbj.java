package com.google.android.gms.internal.p000authapi;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zbbj extends zbbg implements List, RandomAccess {
    private static final zbbm zba = new zbbh(zbbk.zba, 0);

    public static zbbj zbi(Collection collection) {
        if (collection instanceof zbbg) {
            zbbj zbbjVarZbe = ((zbbg) collection).zbe();
            if (!zbbjVarZbe.zbf()) {
                return zbbjVarZbe;
            }
            Object[] array = zbbjVarZbe.toArray();
            return zbj(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                Types$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(i, "at index ", new StringBuilder(String.valueOf(i).length() + 9)));
                return null;
            }
        }
        return zbj(array2, array2.length);
    }

    public static zbbj zbj(Object[] objArr, int i) {
        return i == 0 ? zbbk.zba : new zbbk(objArr, i);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                if (!Objects.equals(get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    @Deprecated
    public final zbbj zbe() {
        return this;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    public int zbg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zbh */
    public zbbj subList(int i, int i2) {
        zbbd.zbc(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zbbk.zba : new zbbi(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zbk, reason: merged with bridge method [inline-methods] */
    public final zbbm listIterator(int i) {
        zbbd.zbb(i, size(), "index");
        return isEmpty() ? zba : new zbbh(this, i);
    }
}
