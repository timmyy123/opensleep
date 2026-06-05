package com.urbandroid.sleep.nearby.pairtracking;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\r\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B+\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u0016J\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0016R\u001a\u0010\u0004\u001a\u00028\u00018\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/Series;", "K", "V", "", "defaultValue", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;", "keys", "Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "values", "<init>", "(Ljava/lang/Object;Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;)V", "", "size", "()I", "", "isEmpty", "()Z", "i", SDKConstants.PARAM_KEY, "(I)Ljava/lang/Object;", SDKConstants.PARAM_VALUE, "lastKeyOrNull", "()Ljava/lang/Object;", "k", "getGE", "(Ljava/lang/Object;)Ljava/lang/Object;", "getLGE", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "keysAsPrimitiveArray", "valuesAsPrimitiveArray", "Ljava/lang/Object;", "getDefaultValue", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;", "getKeys", "()Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;", "Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "getValues", "()Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Series<K, V> {
    private final V defaultValue;
    private final AscSortedArray<K> keys;
    private final MyArray<V> values;

    public Series(V v, AscSortedArray<K> ascSortedArray, MyArray<V> myArray) {
        ascSortedArray.getClass();
        myArray.getClass();
        this.defaultValue = v;
        this.keys = ascSortedArray;
        this.values = myArray;
        if (ascSortedArray.size() == myArray.size()) {
            return;
        }
        Events$$ExternalSyntheticBUOutline0.m(ascSortedArray.size(), myArray.size(), " != ");
        throw null;
    }

    public final V getDefaultValue() {
        return this.defaultValue;
    }

    public final V getGE(K k) {
        int iFindGE = this.keys.findGE(k);
        return iFindGE < size() ? value(iFindGE) : this.defaultValue;
    }

    public final AscSortedArray<K> getKeys() {
        return this.keys;
    }

    public final V getLGE(K k) {
        int iFindLE = this.keys.findLE(k);
        return iFindLE >= 0 ? value(iFindLE) : getGE(k);
    }

    public final MyArray<V> getValues() {
        return this.values;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final K key(int i) {
        return this.keys.get(i);
    }

    public final Object keysAsPrimitiveArray() {
        return this.keys.toPrimitiveArray();
    }

    public final K lastKeyOrNull() {
        return this.keys.getLastOrNull();
    }

    public final int size() {
        return this.keys.size();
    }

    public String toString() {
        K[] array = this.keys.toArray();
        ArrayList arrayList = new ArrayList(array.length);
        int length = array.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            arrayList.add(array[i] + " -> " + value(i2));
            i++;
            i2 = i3;
        }
        return CollectionsKt.joinToString$default(arrayList, ", ", "[", "]", null, 56);
    }

    public final V value(int i) {
        return this.values.get(i);
    }

    public final Object valuesAsPrimitiveArray() {
        return this.values.toPrimitiveArray();
    }
}
