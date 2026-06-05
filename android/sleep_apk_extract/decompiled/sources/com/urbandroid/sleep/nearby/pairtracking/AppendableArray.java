package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "T", "Lcom/urbandroid/sleep/nearby/pairtracking/MyArray;", "x", "", "add", "(Ljava/lang/Object;)V", "copyOf", "()Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AppendableArray<T> extends MyArray<T> {
    void add(T x);

    AppendableArray<T> copyOf();
}
