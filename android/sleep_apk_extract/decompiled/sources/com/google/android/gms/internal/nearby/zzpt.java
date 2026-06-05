package com.google.android.gms.internal.nearby;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzpt extends zzpq implements List, RandomAccess {
    private static final zzpx zza = new zzpr(zzpv.zza, 0);

    public static zzpt zzi(Object[] objArr, int i) {
        return i == 0 ? zzpv.zza : new zzpv(objArr, i);
    }

    public static zzpt zzj(Collection collection) {
        if (!(collection instanceof zzpq)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzpu.zza(array, length);
            return zzi(array, length);
        }
        zzpt zzptVarZzd = ((zzpq) collection).zzd();
        if (!zzptVarZzd.zzf()) {
            return zzptVarZzd;
        }
        Object[] array2 = zzptVarZzd.toArray();
        return zzi(array2, array2.length);
    }

    public static zzpt zzk() {
        return zzpv.zza;
    }

    public static zzpt zzl(Object obj) {
        Object[] objArr = {obj};
        zzpu.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzpt zzm(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzpu.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    public static zzpt zzn(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {MqttTopic.TOPIC_LEVEL_SEPARATOR, "\\", "../"};
        zzpu.zza(objArr, 3);
        return zzi(objArr, 3);
    }

    public static zzpt zzo(Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] objArr = {obj, obj2, obj3, obj4};
        zzpu.zza(objArr, 4);
        return zzi(objArr, 4);
    }

    @SafeVarargs
    public static zzpt zzq(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i = length + 12;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzpu.zza(objArr2, i);
        return zzi(objArr2, i);
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
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
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
                if (!zzpk.zza(get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzpk.zza(it.next(), it2.next())) {
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
    public final int indexOf(@CheckForNull Object obj) {
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
    public final int lastIndexOf(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.nearby.zzpq
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.nearby.zzpq
    @Deprecated
    public final zzpt zzd() {
        return this;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh */
    public zzpt subList(int i, int i2) {
        zzpm.zzh(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zzpv.zza : new zzps(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public final zzpx listIterator(int i) {
        zzpm.zzb(i, size(), "index");
        return isEmpty() ? zza : new zzpr(this, i);
    }
}
