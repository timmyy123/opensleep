package com.google.api.client.util.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public interface DataStore<V extends Serializable> {
    DataStore<V> set(String str, V v);
}
