package com.fasterxml.jackson.databind.util;

import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes3.dex */
public interface LookupCache<K, V> {
    void contents(BiConsumer<K, V> biConsumer);

    V get(Object obj);

    V put(K k, V v);

    V putIfAbsent(K k, V v);

    int size();
}
