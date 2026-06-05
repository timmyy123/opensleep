package com.google.common.primitives;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Longs {
    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }
}
