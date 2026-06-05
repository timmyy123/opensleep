package org.mp4parser.boxes.iso14496.part12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.BoxParser;
import org.mp4parser.Container;
import org.mp4parser.ParsableBox;
import org.mp4parser.tools.CastUtils;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class FreeBox implements ParsableBox {
    public static final String TYPE = "free";

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    ByteBuffer f129data;
    private long offset;
    private Container parent;
    List<ParsableBox> replacers;

    public FreeBox() {
        this.replacers = new LinkedList();
        this.f129data = ByteBuffer.wrap(new byte[0]);
    }

    public void addAndReplace(ParsableBox parsableBox) {
        this.f129data.position(CastUtils.l2i(parsableBox.getSize()));
        this.f129data = this.f129data.slice();
        this.replacers.add(parsableBox);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FreeBox freeBox = (FreeBox) obj;
        return getData() == null ? freeBox.getData() == null : getData().equals(freeBox.getData());
    }

    @Override // org.mp4parser.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<ParsableBox> it = this.replacers.iterator();
        while (it.hasNext()) {
            it.next().getBox(writableByteChannel);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.f129data.limit() + 8);
        byteBufferAllocate.put(TYPE.getBytes());
        byteBufferAllocate.rewind();
        writableByteChannel.write(byteBufferAllocate);
        byteBufferAllocate.rewind();
        this.f129data.rewind();
        writableByteChannel.write(this.f129data);
        this.f129data.rewind();
    }

    public ByteBuffer getData() {
        ByteBuffer byteBuffer = this.f129data;
        if (byteBuffer != null) {
            return (ByteBuffer) byteBuffer.duplicate().rewind();
        }
        return null;
    }

    @Override // org.mp4parser.Box
    public long getSize() {
        Iterator<ParsableBox> it = this.replacers.iterator();
        long size = 8;
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size + ((long) this.f129data.limit());
    }

    @Override // org.mp4parser.Box
    public String getType() {
        return TYPE;
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.f129data;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }

    @Override // org.mp4parser.ParsableBox
    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, BoxParser boxParser) {
        this.f129data = ByteBuffer.allocate(CastUtils.l2i(j));
        int i = 0;
        do {
            i += readableByteChannel.read(this.f129data);
        } while (i < j);
    }

    public void setData(ByteBuffer byteBuffer) {
        this.f129data = byteBuffer;
    }

    public FreeBox(int i) {
        this.replacers = new LinkedList();
        this.f129data = ByteBuffer.allocate(i);
    }
}
