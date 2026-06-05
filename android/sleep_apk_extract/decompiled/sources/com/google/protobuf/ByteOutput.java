package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ByteOutput {
    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i, int i2);
}
