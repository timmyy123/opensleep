package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class BitWriterBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBuffer buffer;
    int initialPos;
    int position = 0;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBits(int i, int i2) {
        int i3 = this.position;
        int i4 = 8 - (i3 % 8);
        if (i2 <= i4) {
            int i5 = this.buffer.get((i3 / 8) + this.initialPos);
            if (i5 < 0) {
                i5 += 256;
            }
            int i6 = i5 + (i << (i4 - i2));
            ByteBuffer byteBuffer = this.buffer;
            int i7 = (this.position / 8) + this.initialPos;
            if (i6 > 127) {
                i6 += Color.YELLOW;
            }
            byteBuffer.put(i7, (byte) i6);
            this.position += i2;
        } else {
            int i8 = i2 - i4;
            writeBits(i >> i8, i4);
            writeBits(i & ((1 << i8) - 1), i8);
        }
        ByteBuffer byteBuffer2 = this.buffer;
        int i9 = this.initialPos;
        int i10 = this.position;
        byteBuffer2.position((i10 / 8) + i9 + (i10 % 8 <= 0 ? 0 : 1));
    }

    public void writeBool(boolean z) {
        writeBits(z ? 1 : 0, 1);
    }
}
