package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.SourcesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/Buffer;", "", "count", "", "readBytes", "(Lkotlinx/io/Buffer;I)[B", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BuffersKt {
    public static final byte[] readBytes(Buffer buffer, int i) {
        buffer.getClass();
        return SourcesKt.readByteArray(buffer, i);
    }

    public static /* synthetic */ byte[] readBytes$default(Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = (int) buffer.getSizeMut();
        }
        return readBytes(buffer, i);
    }
}
