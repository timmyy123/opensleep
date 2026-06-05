package org.mp4parser;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class SkipBox implements ParsableBox {
    private long size;
    private long sourcePosition = -1;
    private String type;

    public SkipBox(String str, byte[] bArr, String str2) {
        this.type = str;
    }

    @Override // org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) {
        throw new RuntimeException("Cannot retrieve a skipped box - type " + this.type);
    }

    @Override // org.mp4parser.Box
    public long getSize() {
        return this.size;
    }

    @Override // org.mp4parser.Box
    public String getType() {
        return this.type;
    }

    @Override // org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.size = 8 + j;
        if (!(readableByteChannel instanceof FileChannel)) {
            Types$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Cannot skip box "), this.type, " if data source is not seekable"));
            return;
        }
        FileChannel fileChannel = (FileChannel) readableByteChannel;
        long jPosition = fileChannel.position();
        this.sourcePosition = jPosition;
        fileChannel.position(jPosition + j);
    }
}
