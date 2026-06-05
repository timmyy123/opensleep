package com.google.common.hash;

/* JADX INFO: loaded from: classes3.dex */
public interface Hasher {
    HashCode hash();

    Hasher putByte(byte b);

    Hasher putBytes(byte[] bArr);
}
