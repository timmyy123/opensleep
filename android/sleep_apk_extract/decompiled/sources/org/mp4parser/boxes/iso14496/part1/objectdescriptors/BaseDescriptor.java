package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import org.mp4parser.tools.IsoTypeReader;

/* JADX INFO: loaded from: classes5.dex */
@Descriptor(tags = {0})
public abstract class BaseDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int sizeBytes;
    int sizeOfInstance;
    int tag;

    public abstract int getContentSize();

    public int getSize() {
        return getSizeSize() + getContentSize() + 1;
    }

    public int getSizeSize() {
        int contentSize = getContentSize();
        int i = 0;
        while (true) {
            if (contentSize <= 0 && i >= this.sizeBytes) {
                return i;
            }
            contentSize >>>= 7;
            i++;
        }
    }

    public int getTag() {
        return this.tag;
    }

    public final void parse(int i, ByteBuffer byteBuffer) {
        this.tag = i;
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.sizeOfInstance = uInt8 & 127;
        int i2 = 1;
        while ((uInt8 >>> 7) == 1) {
            uInt8 = IsoTypeReader.readUInt8(byteBuffer);
            i2++;
            this.sizeOfInstance = (this.sizeOfInstance << 7) | (uInt8 & 127);
        }
        this.sizeBytes = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.sizeOfInstance);
        parseDetail(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
    }

    public abstract void parseDetail(ByteBuffer byteBuffer);

    public abstract ByteBuffer serialize();

    public String toString() {
        StringBuilder sb = new StringBuilder("BaseDescriptor{tag=");
        sb.append(this.tag);
        sb.append(", sizeOfInstance=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.sizeOfInstance, '}');
    }

    public void writeSize(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        while (true) {
            if (i <= 0 && i2 >= this.sizeBytes) {
                byteBuffer.position(getSizeSize() + iPosition);
                return;
            }
            i2++;
            if (i > 0) {
                byteBuffer.put((getSizeSize() + iPosition) - i2, (byte) (i & 127));
            } else {
                byteBuffer.put((getSizeSize() + iPosition) - i2, (byte) -128);
            }
            i >>>= 7;
        }
    }
}
