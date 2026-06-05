package org.mp4parser.boxes.iso14496.part12;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.BoxParser;
import org.mp4parser.ParsableBox;

/* JADX INFO: loaded from: classes5.dex */
public final class MediaDataBox implements ParsableBox, Closeable {
    public static final String TYPE = "mdat";
    File dataFile;
    ByteBuffer header;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        File file = this.dataFile;
        if (file != null) {
            file.delete();
        }
    }

    @Override // org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write((ByteBuffer) this.header.rewind());
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.dataFile);
            try {
                FileChannel channel = fileInputStream.getChannel();
                try {
                    channel.transferTo(0L, this.dataFile.lastModified(), writableByteChannel);
                    channel.close();
                    fileInputStream.close();
                } finally {
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    th = th2;
                } else if (null != th2) {
                    th.addSuppressed(th2);
                }
                fileInputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    @Override // org.mp4parser.Box
    public long getSize() {
        return this.dataFile.length() + ((long) this.header.limit());
    }

    @Override // org.mp4parser.Box
    public String getType() {
        return TYPE;
    }

    @Override // org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        File fileCreateTempFile = File.createTempFile("MediaDataBox", toString());
        this.dataFile = fileCreateTempFile;
        fileCreateTempFile.deleteOnExit();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
        this.header = byteBufferAllocate;
        byteBufferAllocate.put(byteBuffer);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.dataFile, "rw");
            try {
                randomAccessFile.getChannel().transferFrom(readableByteChannel, 0L, j);
            } finally {
                randomAccessFile.close();
            }
        } finally {
        }
    }
}
