package com.google.common.primitives;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsignedBytes {
    public static int toInt(byte b) {
        return b & 255;
    }
}
