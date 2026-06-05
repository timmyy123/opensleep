package com.urbandroid.common.util.math.sun;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MoreMath {
    public static final boolean even(int i) {
        return (i & 1) == 0;
    }

    public static final boolean odd(int i) {
        return !even(i);
    }
}
