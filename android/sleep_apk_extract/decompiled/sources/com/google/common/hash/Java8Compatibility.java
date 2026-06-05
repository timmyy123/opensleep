package com.google.common.hash;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes4.dex */
abstract class Java8Compatibility {
    public static void flip(Buffer buffer) {
        buffer.flip();
    }

    public static void position(Buffer buffer, int i) {
        buffer.position(i);
    }
}
