package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "K", "V", "Lcom/urbandroid/sleep/nearby/pairtracking/Series;", "defaultValue", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;", "keys", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "values", "<init>", "(Ljava/lang/Object;Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;)V", "k", "v", "", "add", "(Ljava/lang/Object;Ljava/lang/Object;)V", "copyOfValues", "()Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "from", "tail", "(Ljava/lang/Object;)Lcom/urbandroid/sleep/nearby/pairtracking/AppendableSeries;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AppendableSeries<K, V> extends Series<K, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppendableSeries(V v, AscSortedAppendableArray<K> ascSortedAppendableArray, AppendableArray<V> appendableArray) {
        super(v, ascSortedAppendableArray, appendableArray);
        ascSortedAppendableArray.getClass();
        appendableArray.getClass();
    }

    public final void add(K k, V v) {
        AscSortedArray<K> keys = getKeys();
        keys.getClass();
        ((AscSortedAppendableArray) keys).add(k);
        MyArray<V> values = getValues();
        values.getClass();
        ((AppendableArray) values).add(v);
    }

    public AppendableArray<V> copyOfValues() {
        MyArray<V> values = getValues();
        values.getClass();
        return ((AppendableArray) values).copyOf();
    }

    public AppendableSeries<K, V> tail(K from) {
        int iFindGE = getKeys().findGE(from);
        V defaultValue = getDefaultValue();
        AscSortedArray<K> ascSortedArrayTail = getKeys().tail(iFindGE);
        ascSortedArrayTail.getClass();
        MyArray<V> myArrayTail = getValues().tail(iFindGE);
        myArrayTail.getClass();
        return new AppendableSeries<>(defaultValue, (AscSortedAppendableArray) ascSortedArrayTail, (AppendableArray) myArrayTail);
    }
}
