package org.apache.commons.math3.util;

/* JADX INFO: loaded from: classes4.dex */
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public static <K, V> Pair<K, V> create(K k, V v) {
        return new Pair<>(k, v);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        K k = this.key;
        K k2 = pair.key;
        if (k != null ? k.equals(k2) : k2 == null) {
            V v = this.value;
            V v2 = pair.value;
            if (v != null ? v.equals(v2) : v2 == null) {
                return true;
            }
        }
        return false;
    }

    public K getFirst() {
        return this.key;
    }

    public K getKey() {
        return this.key;
    }

    public V getSecond() {
        return this.value;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        K k = this.key;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        int iHashCode2 = v != null ? v.hashCode() : 0;
        return (iHashCode2 >>> 16) ^ ((iHashCode * 37) + iHashCode2);
    }

    public String toString() {
        return "[" + getKey() + ", " + getValue() + "]";
    }
}
