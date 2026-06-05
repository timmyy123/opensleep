package org.tensorflow.lite;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface Delegate extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long getNativeHandle();
}
