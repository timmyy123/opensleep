package com.urbandroid.util.vorbis;

import java.io.Closeable;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AudioOutputStream extends OutputStream implements Closeable {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract int getSampleRate();

    public abstract int write(short[] sArr, int i, int i2);

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new short[]{(short) i}, 0, 1);
    }

    public int write(short[] sArr) {
        return write(sArr, 0, sArr.length);
    }
}
