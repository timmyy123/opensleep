package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
