package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/LongAscSortedAppendableArray;", "Lcom/urbandroid/sleep/nearby/pairtracking/LongAppendableArray;", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;", "", "initValues", "", "initSize", "", "<init>", "([JI)V", "add", "", "x", "findLE", "findGE", "copyOf", "tail", "from", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LongAscSortedAppendableArray extends LongAppendableArray implements AscSortedAppendableArray<Long> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongAscSortedAppendableArray(long[] jArr, int i) {
        super(jArr, i);
        jArr.getClass();
        int size = size();
        for (int i2 = 1; i2 < size; i2++) {
            int i3 = i2 - 1;
            if (get(i3).longValue() >= get(i2).longValue()) {
                throw new IllegalArgumentException("Not in ascending order: " + i2 + " " + get(i3) + " " + get(i2));
            }
        }
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.LongAppendableArray
    public void add(long x) {
        if (getSize() <= 0 || x > get(getSize() - 1).longValue()) {
            super.add(x);
            return;
        }
        throw new IllegalArgumentException("Ordering violation: " + x + " < " + get(getSize() - 1));
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.LongAppendableArray, com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public AppendableArray<Long> copyOf() {
        return new LongAscSortedAppendableArray(toPrimitiveArray(), 0, 2, null);
    }

    public int findGE(long x) {
        int iBinarySearch = ArraysKt___ArraysJvmKt.binarySearch(getValues(), x, 0, getSize());
        return iBinarySearch < 0 ? (-iBinarySearch) - 1 : iBinarySearch;
    }

    public int findLE(long x) {
        int iBinarySearch = ArraysKt___ArraysJvmKt.binarySearch(getValues(), x, 0, getSize());
        return iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.nearby.pairtracking.LongAppendableArray, com.urbandroid.sleep.nearby.pairtracking.MyArray
    public LongAscSortedAppendableArray tail(int from) {
        int i = 0;
        return from >= getSize() ? new LongAscSortedAppendableArray(null, i, 3, 0 == true ? 1 : 0) : new LongAscSortedAppendableArray(ArraysKt.copyOfRange(getValues(), from, getSize()), i, 2, 0 == true ? 1 : 0);
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AscSortedArray
    public /* bridge */ /* synthetic */ int findGE(Object obj) {
        return findGE(((Number) obj).longValue());
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.AscSortedArray
    public /* bridge */ /* synthetic */ int findLE(Object obj) {
        return findLE(((Number) obj).longValue());
    }

    @Override // com.urbandroid.sleep.nearby.pairtracking.LongAppendableArray, com.urbandroid.sleep.nearby.pairtracking.AppendableArray
    public /* bridge */ /* synthetic */ void add(Long l) {
        add(l.longValue());
    }

    public /* synthetic */ LongAscSortedAppendableArray(long[] jArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new long[0] : jArr, (i2 & 2) != 0 ? 1024 : i);
    }
}
