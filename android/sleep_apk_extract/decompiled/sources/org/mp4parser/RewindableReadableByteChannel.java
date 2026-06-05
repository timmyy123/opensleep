package org.mp4parser;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class RewindableReadableByteChannel implements ReadableByteChannel {
    private final ByteBuffer buffer;
    private int nextBufferReadPosition;
    private int nextBufferWritePosition;
    private boolean passedRewindPoint;
    private final ReadableByteChannel readableByteChannel;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel, int i) {
        this.buffer = ByteBuffer.allocate(i);
        this.readableByteChannel = readableByteChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.readableByteChannel.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.readableByteChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        int iPosition = byteBuffer.position();
        ByteBuffer byteBuffer2 = this.buffer;
        byteBuffer2.limit(byteBuffer2.capacity());
        this.buffer.position(this.nextBufferWritePosition);
        if (this.buffer.capacity() > 0) {
            this.readableByteChannel.read(this.buffer);
            this.nextBufferWritePosition = this.buffer.position();
        }
        this.buffer.position(this.nextBufferReadPosition);
        this.buffer.limit(this.nextBufferWritePosition);
        if (this.buffer.remaining() > byteBuffer.remaining()) {
            ByteBuffer byteBuffer3 = this.buffer;
            byteBuffer3.limit(byteBuffer.remaining() + byteBuffer3.position());
        }
        byteBuffer.put(this.buffer);
        this.nextBufferReadPosition = this.buffer.position();
        int i = this.readableByteChannel.read(byteBuffer);
        if (i > 0) {
            this.passedRewindPoint = true;
        } else if (i == -1 && byteBuffer.position() - iPosition == 0) {
            return -1;
        }
        return byteBuffer.position() - iPosition;
    }

    public void rewind() {
        if (this.passedRewindPoint) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Passed the rewind point. Increase the buffer capacity.");
        } else {
            this.nextBufferReadPosition = 0;
        }
    }
}
