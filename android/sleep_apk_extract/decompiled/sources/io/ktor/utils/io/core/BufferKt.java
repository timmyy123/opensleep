package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlinx.io.Buffer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003*\f\b\u0007\u0010\u0004\"\u00020\u00002\u00020\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/io/Buffer;", "", "canRead", "(Lkotlinx/io/Buffer;)Z", "Buffer", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BufferKt {
    public static final boolean canRead(Buffer buffer) {
        buffer.getClass();
        return !buffer.exhausted();
    }
}
