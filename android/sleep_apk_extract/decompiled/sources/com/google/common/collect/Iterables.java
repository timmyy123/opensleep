package com.google.common.collect;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.List;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Iterables {
    public static <T> T getLast(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.getLast(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return (T) getLastInNonemptyList(list);
        }
        Types$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return (T) FileInsert$$ExternalSyntheticOutline0.m(list, 1);
    }
}
