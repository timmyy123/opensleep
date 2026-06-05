package com.squareup.picasso;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
final class MarkableInputStream extends InputStream {
    private long defaultMark;
    private final InputStream in;
    private long limit;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream inputStream, int i) {
        this.defaultMark = -1L;
        this.in = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    private void setLimit(long j) {
        try {
            long j2 = this.reset;
            long j3 = this.offset;
            if (j2 >= j3 || j3 > this.limit) {
                this.reset = j3;
                this.in.mark((int) (j - j3));
            } else {
                this.in.reset();
                this.in.mark((int) (j - this.reset));
                skip(this.reset, this.offset);
            }
            this.limit = j;
        } catch (IOException e) {
            Home$$ExternalSyntheticBUOutline0.m$2("Unable to mark: ", e);
        }
    }

    private void skip(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.in.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.defaultMark = savePosition(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            this.offset++;
        }
        return i;
    }

    public void reset(long j) throws IOException {
        if (this.offset > this.limit || j < this.reset) {
            OggIO$$ExternalSyntheticBUOutline0.m("Cannot reset");
            return;
        }
        this.in.reset();
        skip(this.reset, j);
        this.offset = j;
    }

    public long savePosition(int i) {
        long j = this.offset + ((long) i);
        if (this.limit < j) {
            setLimit(j);
        }
        return this.offset;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.in.read(bArr);
        if (i != -1) {
            this.offset += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            this.offset += (long) i3;
        }
        return i3;
    }

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.in.skip(j);
        this.offset += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        reset(this.defaultMark);
    }
}
