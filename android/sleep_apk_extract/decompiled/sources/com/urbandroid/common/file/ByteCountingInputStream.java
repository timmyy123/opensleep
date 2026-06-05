package com.urbandroid.common.file;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ByteCountingInputStream extends InputStream {
    private final InputStream nextStream;
    private long readBytes = 0;

    public ByteCountingInputStream(InputStream inputStream) {
        this.nextStream = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nextStream.close();
    }

    public long getBytesRead() {
        return this.readBytes;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.nextStream.read();
        if (i > 0) {
            this.readBytes += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.nextStream.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.nextStream.read(bArr);
        if (i > 0) {
            this.readBytes += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.nextStream.read(bArr, i, i2);
        if (i3 > 0) {
            this.readBytes += (long) i3;
        }
        return i3;
    }
}
