package com.google.android.gms.common.util;

/* JADX INFO: loaded from: classes3.dex */
public interface Clock {
    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
