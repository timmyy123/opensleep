package com.google.common.collect;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import javax.annotation.CheckForNull;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ObjectArrays {
    public static Object checkElementNotNull(@CheckForNull Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(FileInsert$$ExternalSyntheticOutline0.m(i, "at index "));
        return null;
    }

    public static Object[] checkElementsNotNull(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            checkElementNotNull(objArr[i2], i2);
        }
        return objArr;
    }

    public static <T> T[] newArray(T[] tArr, int i) {
        return (T[]) Platform.newArray(tArr, i);
    }

    public static Object[] checkElementsNotNull(Object... objArr) {
        checkElementsNotNull(objArr, objArr.length);
        return objArr;
    }
}
