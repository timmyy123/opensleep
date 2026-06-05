package com.hecz.android;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidSerialOutputStream extends OutputStream {
    private byte[] buffer = null;
    private int iBuffer = 0;
    private J2xx j2xx;

    public AndroidSerialOutputStream(J2xx j2xx) {
        this.j2xx = j2xx;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        byte[] bArr;
        int i = this.iBuffer;
        if (i <= 0 || (bArr = this.buffer) == null) {
            return;
        }
        this.j2xx.sendData(i, bArr);
        this.iBuffer = 0;
        this.buffer = null;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        if (this.buffer == null) {
            this.buffer = new byte[20];
            this.iBuffer = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.iBuffer;
        int i3 = i2 + 1;
        this.iBuffer = i3;
        bArr[i2] = (byte) i;
        if (i3 == 20) {
            this.j2xx.sendData(i3, bArr);
            this.iBuffer = 0;
            this.buffer = null;
        }
    }
}
