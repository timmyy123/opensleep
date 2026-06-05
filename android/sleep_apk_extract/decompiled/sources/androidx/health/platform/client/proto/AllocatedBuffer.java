package androidx.health.platform.client.proto;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return wrapNoCheck(bArr, i, i2);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() { // from class: androidx.health.platform.client.proto.AllocatedBuffer.2
            private int position;

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int arrayOffset() {
                return i;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int limit() {
                return i2;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public AllocatedBuffer position(int i3) {
                if (i3 < 0 || i3 > i2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i3, "Invalid position: "));
                    return null;
                }
                this.position = i3;
                return this;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int remaining() {
                return i2 - this.position;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int position() {
                return this.position;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: androidx.health.platform.client.proto.AllocatedBuffer.1
            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public byte[] array() {
                return byteBuffer.array();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int limit() {
                return byteBuffer.limit();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }

            @Override // androidx.health.platform.client.proto.AllocatedBuffer
            public AllocatedBuffer position(int i) {
                Java8Compatibility.position(byteBuffer, i);
                return this;
            }
        };
    }
}
