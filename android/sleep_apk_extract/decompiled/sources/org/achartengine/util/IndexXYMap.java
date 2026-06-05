package org.achartengine.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class IndexXYMap<K, V> extends TreeMap<K, V> {
    private final List<K> indexList = new ArrayList();
    private double maxXDifference = 0.0d;

    private void updateMaxXDifference() {
        if (this.indexList.size() < 2) {
            this.maxXDifference = 0.0d;
        } else if (Math.abs(((Double) FileInsert$$ExternalSyntheticOutline0.m(this.indexList, 1)).doubleValue() - ((Double) FileInsert$$ExternalSyntheticOutline0.m(this.indexList, 2)).doubleValue()) > this.maxXDifference) {
            this.maxXDifference = Math.abs(((Double) FileInsert$$ExternalSyntheticOutline0.m(this.indexList, 1)).doubleValue() - ((Double) FileInsert$$ExternalSyntheticOutline0.m(this.indexList, 2)).doubleValue());
        }
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        updateMaxXDifference();
        super.clear();
        this.indexList.clear();
    }

    public int getIndexForKey(K k) {
        return Collections.binarySearch(this.indexList, k, null);
    }

    public K getXByIndex(int i) {
        return this.indexList.get(i);
    }

    public V getYByIndex(int i) {
        return get(this.indexList.get(i));
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        this.indexList.add(k);
        updateMaxXDifference();
        return (V) super.put(k, v);
    }
}
