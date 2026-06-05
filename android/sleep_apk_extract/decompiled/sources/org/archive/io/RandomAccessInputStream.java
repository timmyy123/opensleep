package org.archive.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class RandomAccessInputStream extends InputStream {
    private long markpos;
    private RandomAccessFile raf;
    private boolean sympathyClose;

    public RandomAccessInputStream(RandomAccessFile randomAccessFile, boolean z, long j) throws IOException {
        this.markpos = -1L;
        this.sympathyClose = z;
        this.raf = randomAccessFile;
        if (j > 0) {
            randomAccessFile.seek(j);
        }
    }

    @Override // java.io.InputStream
    public int available() {
        long length = this.raf.length() - position();
        if (length >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.sympathyClose) {
                this.raf.close();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        try {
            this.markpos = position();
        } catch (IOException unused) {
            this.markpos = -1L;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public long position() {
        return this.raf.getFilePointer();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.raf.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        long j = this.markpos;
        if (j == -1) {
            throw new IOException("Mark has not been set.");
        }
        position(j);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        randomAccessFile.seek(randomAccessFile.getFilePointer() + j);
        return j;
    }

    public RandomAccessInputStream(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, false, 0L);
    }

    public void position(long j) throws IOException {
        this.raf.seek(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.raf.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.raf.read(bArr, i, i2);
    }
}
