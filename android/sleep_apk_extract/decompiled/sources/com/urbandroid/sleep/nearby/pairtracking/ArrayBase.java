package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/ArrayBase;", "T", "Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "<init>", "()V", "isEmpty", "", "getLastOrNull", "()Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ArrayBase<T> implements MyArray<T> {
    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    public T getLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
