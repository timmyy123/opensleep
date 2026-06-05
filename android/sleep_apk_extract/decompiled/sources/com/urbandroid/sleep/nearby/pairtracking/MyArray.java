package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "T", "", "", "size", "()I", "i", "get", "(I)Ljava/lang/Object;", "getLastOrNull", "()Ljava/lang/Object;", "", "toArray", "()[Ljava/lang/Object;", "toPrimitiveArray", "from", "tail", "(I)Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface MyArray<T> {
    T get(int i);

    T getLastOrNull();

    int size();

    MyArray<T> tail(int from);

    T[] toArray();

    Object toPrimitiveArray();
}
