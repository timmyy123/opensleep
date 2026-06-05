package com.urbandroid.util.vorbis;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AudioInputStream extends InputStream implements Closeable {
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // java.io.InputStream
    public int read() {
        short[] sArr = new short[1];
        if (read(sArr, 0, 1) == -1) {
            return -1;
        }
        return sArr[0];
    }

    public abstract int read(short[] sArr, int i, int i2);

    public int read(short[] sArr) {
        return read(sArr, 0, sArr.length);
    }
}
