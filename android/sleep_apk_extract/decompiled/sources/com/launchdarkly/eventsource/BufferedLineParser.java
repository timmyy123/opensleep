package com.launchdarkly.eventsource;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
final class BufferedLineParser {
    private final byte[] readBuffer;
    private final InputStream stream;
    private int readBufferCount = 0;
    private int scanPos = 0;
    private int chunkStart = 0;
    private int chunkEnd = 0;
    private boolean lastCharWasCr = false;
    private boolean eof = false;

    public BufferedLineParser(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.readBuffer = new byte[i];
    }

    private boolean readMoreIntoBuffer() throws IOException {
        int i = this.readBufferCount;
        byte[] bArr = this.readBuffer;
        if (i == bArr.length) {
            return false;
        }
        int i2 = this.stream.read(bArr, i, bArr.length - i);
        if (i2 < 0) {
            this.eof = true;
            return false;
        }
        this.readBufferCount += i2;
        return true;
    }

    private boolean scanForTerminator() {
        int i;
        int i2;
        byte b;
        if (this.lastCharWasCr) {
            this.lastCharWasCr = false;
            byte[] bArr = this.readBuffer;
            int i3 = this.scanPos;
            if (bArr[i3] == 10) {
                this.scanPos = i3 + 1;
                this.chunkStart++;
            }
        }
        while (true) {
            i = this.scanPos;
            i2 = this.readBufferCount;
            if (i >= i2 || (b = this.readBuffer[i]) == 10 || b == 13) {
                break;
            }
            this.scanPos = i + 1;
        }
        this.chunkEnd = i;
        if (i == i2) {
            return false;
        }
        int i4 = i + 1;
        this.scanPos = i4;
        byte[] bArr2 = this.readBuffer;
        if (bArr2[i] == 13) {
            if (i4 == i2) {
                this.lastCharWasCr = true;
            } else if (bArr2[i4] == 10) {
                this.scanPos = i + 2;
            }
        }
        return true;
    }

    public byte[] getBuffer() {
        return this.readBuffer;
    }

    public int getChunkOffset() {
        return this.chunkStart;
    }

    public int getChunkSize() {
        return this.chunkEnd - this.chunkStart;
    }

    public boolean isEof() {
        return this.eof;
    }

    public boolean read() {
        int i;
        int i2 = this.scanPos;
        if (i2 > 0 && (i = this.readBufferCount) > i2) {
            byte[] bArr = this.readBuffer;
            System.arraycopy(bArr, i2, bArr, 0, i - i2);
        }
        this.readBufferCount -= this.scanPos;
        this.chunkEnd = 0;
        this.chunkStart = 0;
        this.scanPos = 0;
        do {
            if (this.scanPos < this.readBufferCount && scanForTerminator()) {
                return true;
            }
        } while (readMoreIntoBuffer());
        return false;
    }
}
