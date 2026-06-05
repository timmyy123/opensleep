package com.fasterxml.jackson.core.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int i, int i2) {
        int i3 = i + i2;
        if (i3 < 0) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }
}
