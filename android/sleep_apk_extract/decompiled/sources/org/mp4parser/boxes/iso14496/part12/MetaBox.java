package org.mp4parser.boxes.iso14496.part12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.BoxParser;
import org.mp4parser.RewindableReadableByteChannel;
import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class MetaBox extends AbstractContainerBox {
    public static final String TYPE = "meta";
    private int flags;
    private boolean quickTimeFormat;
    private int version;

    public MetaBox() {
        super(TYPE);
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        if (!this.quickTimeFormat) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            writeVersionAndFlags(byteBufferAllocate);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        }
        writeContainer(writableByteChannel);
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public long getSize() {
        long containerSize = getContainerSize() + ((long) (this.quickTimeFormat ? 0 : 4));
        return containerSize + ((long) ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8));
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        RewindableReadableByteChannel rewindableReadableByteChannel = new RewindableReadableByteChannel(readableByteChannel, 20);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        if (rewindableReadableByteChannel.read(byteBufferAllocate) == 20) {
            byteBufferAllocate.position(4);
            String str = IsoTypeReader.read4cc(byteBufferAllocate);
            byteBufferAllocate.position(16);
            String str2 = IsoTypeReader.read4cc(byteBufferAllocate);
            if (HandlerBox.TYPE.equals(str) && "mdta".equals(str2)) {
                this.quickTimeFormat = true;
            }
        }
        rewindableReadableByteChannel.rewind();
        if (!this.quickTimeFormat) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            rewindableReadableByteChannel.read(byteBufferAllocate2);
            parseVersionAndFlags((ByteBuffer) byteBufferAllocate2.rewind());
        }
        initContainer(rewindableReadableByteChannel, j - ((long) (this.quickTimeFormat ? 0 : 4)), boxParser);
    }

    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = IsoTypeReader.readUInt8(byteBuffer);
        this.flags = IsoTypeReader.readUInt24(byteBuffer);
        return 4L;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.version);
        IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
    }
}
