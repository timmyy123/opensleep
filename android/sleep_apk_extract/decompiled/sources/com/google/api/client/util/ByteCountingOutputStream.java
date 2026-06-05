package com.google.api.client.util;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
final class ByteCountingOutputStream extends OutputStream {
    long count;

    @Override // java.io.OutputStream
    public void write(int i) {
        this.count++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.count += (long) i2;
    }
}
