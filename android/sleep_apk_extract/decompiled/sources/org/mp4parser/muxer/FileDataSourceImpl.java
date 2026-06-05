package org.mp4parser.muxer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class FileDataSourceImpl implements DataSource {
    private static Logger LOG = LoggerFactory.getLogger((Class<?>) FileDataSourceImpl.class);
    FileChannel fc;
    String filename;

    public FileDataSourceImpl(File file) {
        this.fc = new FileInputStream(file).getChannel();
        this.filename = file.getName();
    }

    @Override // org.mp4parser.muxer.DataSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fc.close();
    }

    @Override // org.mp4parser.muxer.DataSource
    public synchronized long position() {
        return this.fc.position();
    }

    @Override // org.mp4parser.muxer.DataSource
    public synchronized int read(ByteBuffer byteBuffer) {
        return this.fc.read(byteBuffer);
    }

    public String toString() {
        return this.filename;
    }

    @Override // org.mp4parser.muxer.DataSource
    public synchronized long transferTo(long j, long j2, WritableByteChannel writableByteChannel) {
        return this.fc.transferTo(j, j2, writableByteChannel);
    }

    @Override // org.mp4parser.muxer.DataSource
    public synchronized void position(long j) {
        this.fc.position(j);
    }
}
