package com.google.common.primitives;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Ints extends IntsMethodsForWeb {
    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
