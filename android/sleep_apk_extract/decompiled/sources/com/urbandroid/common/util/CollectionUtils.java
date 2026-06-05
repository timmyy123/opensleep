package com.urbandroid.common.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CollectionUtils {
    public static <E> String toString(Iterable<E> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (E e : iterable) {
            if (!z) {
                sb.append(str);
            }
            sb.append(e.toString());
            z = false;
        }
        return sb.toString();
    }
}
