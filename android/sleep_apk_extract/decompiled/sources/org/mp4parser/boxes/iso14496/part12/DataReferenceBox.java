package org.mp4parser.boxes.iso14496.part12;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.BoxParser;
import org.mp4parser.ParsableBox;
import org.mp4parser.support.AbstractContainerBox;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class DataReferenceBox extends AbstractContainerBox implements ParsableBox {
    public static final String TYPE = "dref";
    private int flags;
    private int version;

    public DataReferenceBox() {
        super(TYPE);
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.version);
        IsoTypeWriter.writeUInt24(byteBufferAllocate, this.flags);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, getBoxes().size());
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        writeContainer(writableByteChannel);
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.Box
    public long getSize() {
        long containerSize = getContainerSize();
        return 8 + containerSize + ((long) ((this.largeBox || containerSize + 16 >= 4294967296L) ? 16 : 8));
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws EOFException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        int iLimit = byteBufferAllocate.limit();
        while (iLimit > 0) {
            iLimit -= readableByteChannel.read(byteBufferAllocate);
        }
        byteBufferAllocate.rewind();
        this.version = IsoTypeReader.readUInt8(byteBufferAllocate);
        this.flags = IsoTypeReader.readUInt24(byteBufferAllocate);
        initContainer(readableByteChannel, j - 8, boxParser);
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
