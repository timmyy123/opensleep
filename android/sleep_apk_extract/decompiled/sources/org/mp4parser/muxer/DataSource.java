package org.mp4parser.muxer;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes5.dex */
public interface DataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long position();

    void position(long j);

    int read(ByteBuffer byteBuffer);

    long transferTo(long j, long j2, WritableByteChannel writableByteChannel);
}
