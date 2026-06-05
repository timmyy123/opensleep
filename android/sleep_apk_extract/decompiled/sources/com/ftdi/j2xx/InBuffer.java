package com.ftdi.j2xx;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class InBuffer {
    private boolean mAcquired;
    private int mBufId;
    private ByteBuffer mBuffer;
    private int mLength;

    public InBuffer(int i) {
        this.mBuffer = ByteBuffer.allocate(i);
        setLength(0);
    }

    public synchronized ByteBuffer acquire(int i) {
        ByteBuffer byteBuffer;
        if (this.mAcquired) {
            byteBuffer = null;
        } else {
            this.mAcquired = true;
            this.mBufId = i;
            byteBuffer = this.mBuffer;
        }
        return byteBuffer;
    }

    public synchronized boolean acquired() {
        return this.mAcquired;
    }

    public ByteBuffer getInputBuffer() {
        return this.mBuffer;
    }

    public int getLength() {
        return this.mLength;
    }

    public synchronized void purge() {
        this.mBuffer.clear();
        setLength(0);
    }

    public synchronized boolean release(int i) {
        boolean z;
        z = false;
        if (this.mAcquired && i == this.mBufId) {
            this.mAcquired = false;
            z = true;
        }
        return z;
    }

    public void setBufferId(int i) {
        this.mBufId = i;
    }

    public void setLength(int i) {
        this.mLength = i;
    }
}
