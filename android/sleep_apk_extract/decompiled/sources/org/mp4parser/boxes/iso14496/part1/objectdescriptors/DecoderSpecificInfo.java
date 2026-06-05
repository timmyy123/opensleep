package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.mp4parser.tools.Hex;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
@Descriptor(tags = {5})
public class DecoderSpecificInfo extends BaseDescriptor {
    byte[] bytes;

    public DecoderSpecificInfo() {
        this.tag = 5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.bytes, ((DecoderSpecificInfo) obj).bytes);
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public int getContentSize() {
        return this.bytes.length;
    }

    public int hashCode() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.bytes = bArr;
        byteBuffer.get(bArr);
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public ByteBuffer serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getSize());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tag);
        writeSize(byteBufferAllocate, getContentSize());
        byteBufferAllocate.put(this.bytes);
        return (ByteBuffer) byteBufferAllocate.rewind();
    }

    public void setData(byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder("DecoderSpecificInfo{bytes=");
        byte[] bArr = this.bytes;
        return FileInsert$$ExternalSyntheticOutline0.m(sb, bArr == null ? "null" : Hex.encodeHex(bArr), '}');
    }
}
