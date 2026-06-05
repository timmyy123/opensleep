package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;", "T", "Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "x", "", "findLE", "(Ljava/lang/Object;)I", "findGE", "from", "tail", "(I)Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedArray;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AscSortedArray<T> extends MyArray<T> {
    int findGE(T x);

    int findLE(T x);

    @Override // com.urbandroid.sleep.nearby.pairtracking.MyArray
    AscSortedArray<T> tail(int from);
}
