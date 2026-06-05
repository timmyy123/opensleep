package com.google.api.client.util;

/* JADX INFO: loaded from: classes4.dex */
public interface BackOff {
    long nextBackOffMillis();

    void reset();
}
