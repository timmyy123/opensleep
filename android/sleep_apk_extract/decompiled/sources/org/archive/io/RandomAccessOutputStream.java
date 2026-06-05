package org.archive.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class RandomAccessOutputStream extends OutputStream {
    RandomAccessFile raf;

    public RandomAccessOutputStream(RandomAccessFile randomAccessFile) {
        this.raf = randomAccessFile;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.raf.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.raf.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.raf.write(bArr, i, i2);
    }
}
