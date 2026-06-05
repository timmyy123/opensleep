package com.urbandroid.common.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RandUtil {
    public static int range(int i, int i2) {
        return ((int) (Math.random() * ((double) ((i2 - i) + 1)))) + i;
    }
}
