package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private Object[] f47data;
    int size;

    public final class Entry implements Map.Entry<K, V> {
        private int index;

        public Entry(int i) {
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ArrayMap.this.getKey(this.index);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) ArrayMap.this.getValue(this.index);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            Object value = getValue();
            return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            return (V) ArrayMap.this.set(this.index, v);
        }
    }

    public final class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private int nextIndex;
        private boolean removed;

        public EntryIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < ArrayMap.this.size;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            int i = this.nextIndex;
            ArrayMap arrayMap = ArrayMap.this;
            if (i == arrayMap.size) {
                Types$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            this.nextIndex = i + 1;
            this.removed = false;
            return new Entry(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.nextIndex - 1;
            if (this.removed || i < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
            ArrayMap.this.remove(i);
            this.nextIndex--;
            this.removed = true;
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayMap.this.size;
        }
    }

    public static <K, V> ArrayMap<K, V> create() {
        return new ArrayMap<>();
    }

    private int getDataIndexOfKey(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.f47data;
        for (int i2 = 0; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return i2;
                }
            } else {
                if (obj.equals(obj2)) {
                    return i2;
                }
            }
        }
        return -2;
    }

    private V removeFromDataIndexOfKey(int i) {
        int i2 = this.size << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V vValueAtDataIndex = valueAtDataIndex(i + 1);
        Object[] objArr = this.f47data;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.size--;
        setData(i2 - 2, null, null);
        return vValueAtDataIndex;
    }

    private void setData(int i, K k, V v) {
        Object[] objArr = this.f47data;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private void setDataCapacity(int i) {
        if (i == 0) {
            this.f47data = null;
            return;
        }
        int i2 = this.size;
        Object[] objArr = this.f47data;
        if (i2 == 0 || i != objArr.length) {
            Object[] objArr2 = new Object[i];
            this.f47data = objArr2;
            if (i2 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i2 << 1);
            }
        }
    }

    private V valueAtDataIndex(int i) {
        if (i < 0) {
            return null;
        }
        return (V) this.f47data[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        this.f47data = null;
    }

    @Override // java.util.AbstractMap
    public ArrayMap<K, V> clone() {
        try {
            ArrayMap<K, V> arrayMap = (ArrayMap) super.clone();
            Object[] objArr = this.f47data;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                arrayMap.f47data = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return arrayMap;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != getDataIndexOfKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.f47data;
        for (int i2 = 1; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else {
                if (obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void ensureCapacity(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] objArr = this.f47data;
        int i2 = i << 1;
        int length = objArr == null ? 0 : objArr.length;
        if (i2 > length) {
            int i3 = (length / 2) * 3;
            int i4 = i3 + 1;
            if (i4 % 2 != 0) {
                i4 = i3 + 2;
            }
            if (i4 >= i2) {
                i2 = i4;
            }
            setDataCapacity(i2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return valueAtDataIndex(getDataIndexOfKey(obj) + 1);
    }

    public final int getIndexOfKey(K k) {
        return getDataIndexOfKey(k) >> 1;
    }

    public final K getKey(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return (K) this.f47data[i << 1];
    }

    public final V getValue(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return valueAtDataIndex((i << 1) + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int indexOfKey = getIndexOfKey(k);
        if (indexOfKey == -1) {
            indexOfKey = this.size;
        }
        return set(indexOfKey, k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return removeFromDataIndexOfKey(getDataIndexOfKey(obj));
    }

    public final V set(int i, K k, V v) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i + 1;
        ensureCapacity(i2);
        int i3 = i << 1;
        V vValueAtDataIndex = valueAtDataIndex(i3 + 1);
        setData(i3, k, v);
        if (i2 > this.size) {
            this.size = i2;
        }
        return vValueAtDataIndex;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    public final V remove(int i) {
        return removeFromDataIndexOfKey(i << 1);
    }

    public final V set(int i, V v) {
        int i2 = this.size;
        if (i >= 0 && i < i2) {
            int i3 = (i << 1) + 1;
            V vValueAtDataIndex = valueAtDataIndex(i3);
            this.f47data[i3] = v;
            return vValueAtDataIndex;
        }
        throw new IndexOutOfBoundsException();
    }
}
