package org.eclipse.californium.elements.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class DatagramReader {
    private final ByteArrayInputStream byteStream;
    private int currentBitIndex;
    private byte currentByte;
    private int markBitIndex;
    private byte markByte;

    public DatagramReader(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("byte stream must not be null!");
            throw null;
        }
        this.byteStream = byteArrayInputStream;
        this.currentByte = (byte) 0;
        this.currentBitIndex = -1;
        this.markByte = (byte) 0;
        this.markBitIndex = -1;
    }

    private int readByte() {
        int i = this.byteStream.read();
        if (i >= 0) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("requested byte exceeds available bytes!");
        return 0;
    }

    private void readCurrentByte() {
        int i = this.byteStream.read();
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("requested byte exceeds available bytes!");
        } else {
            this.currentByte = (byte) i;
            this.currentBitIndex = 7;
        }
    }

    public int bitsLeft() {
        return this.currentBitIndex + 1 + (this.byteStream.available() * 8);
    }

    public boolean bytesAvailable() {
        return this.byteStream.available() > 0;
    }

    public void close() {
        this.byteStream.skip(r0.available());
        this.currentByte = (byte) 0;
        this.currentBitIndex = -1;
    }

    public ByteArrayInputStream createRangeInputStream(int i) {
        if (this.currentBitIndex > 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m(this.currentBitIndex, " bits unread!", new StringBuilder()));
            return null;
        }
        int iAvailable = this.byteStream.available();
        if (iAvailable < i) {
            Events$$ExternalSyntheticBUOutline0.m("requested ", i, " bytes exceeds available ", iAvailable, " bytes.");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = this.byteStream;
        if (byteArrayInputStream instanceof RangeInputStream) {
            return ((RangeInputStream) byteArrayInputStream).range(i);
        }
        byte[] bArr = new byte[i];
        byteArrayInputStream.read(bArr, 0, i);
        return new RangeInputStream(bArr);
    }

    public DatagramReader createRangeReader(int i) {
        return new DatagramReader(createRangeInputStream(i));
    }

    public void mark() {
        this.markByte = this.currentByte;
        this.markBitIndex = this.currentBitIndex;
        this.byteStream.mark(0);
    }

    public int read(int i) {
        if (i < 0 || i > 32) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("bits must be in range 0 ... 32!");
            return 0;
        }
        int i2 = 0;
        if (this.currentBitIndex < 0 && (i & 7) == 0) {
            int i3 = 0;
            while (i2 < i) {
                i3 = (i3 << 8) | readByte();
                i2 += 8;
            }
            return i3;
        }
        for (int i4 = i - 1; i4 >= 0; i4--) {
            if (this.currentBitIndex < 0) {
                readCurrentByte();
            }
            byte b = this.currentByte;
            int i5 = this.currentBitIndex;
            if (((b >> i5) & 1) != 0) {
                i2 |= 1 << i4;
            }
            this.currentBitIndex = i5 - 1;
        }
        return i2;
    }

    public byte[] readBytes(int i) {
        int iAvailable = this.byteStream.available();
        if (i < 0) {
            i = iAvailable;
        } else if (i > iAvailable) {
            Events$$ExternalSyntheticBUOutline0.m("requested ", i, " bytes exceeds available ", iAvailable, " bytes.");
            return null;
        }
        byte[] bArr = new byte[i];
        if (this.currentBitIndex < 0) {
            this.byteStream.read(bArr, 0, i);
            return bArr;
        }
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) read(8);
        }
        return bArr;
    }

    public byte[] readBytesLeft() {
        return readBytes(-1);
    }

    public long readLong(int i) {
        if (i < 0 || i > 64) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("bits must be in range 0 ... 64!");
            return 0L;
        }
        long j = 0;
        if (this.currentBitIndex < 0 && (i & 7) == 0) {
            for (int i2 = 0; i2 < i; i2 += 8) {
                j = (j << 8) | ((long) readByte());
            }
            return j;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (this.currentBitIndex < 0) {
                readCurrentByte();
            }
            byte b = this.currentByte;
            int i4 = this.currentBitIndex;
            if (((b >> i4) & 1) != 0) {
                j |= 1 << i3;
            }
            this.currentBitIndex = i4 - 1;
        }
        return j;
    }

    public byte readNextByte() {
        return readBytes(1)[0];
    }

    public void reset() {
        this.byteStream.reset();
        this.currentByte = this.markByte;
        this.currentBitIndex = this.markBitIndex;
    }

    public static class RangeInputStream extends ByteArrayInputStream {
        /* JADX INFO: Access modifiers changed from: private */
        public RangeInputStream range(int i) throws IOException {
            int i2 = ((ByteArrayInputStream) this).pos;
            long j = i;
            long jSkip = skip(j);
            if (jSkip >= j) {
                return new RangeInputStream(((ByteArrayInputStream) this).buf, i2, i);
            }
            throw new IllegalArgumentException("requested " + i + " bytes exceeds available " + jSkip + " bytes.");
        }

        private RangeInputStream(byte[] bArr) {
            super(bArr);
        }

        private RangeInputStream(byte[] bArr, int i, int i2) {
            super(bArr, i, i2);
        }
    }

    public boolean bytesAvailable(int i) {
        return this.byteStream.available() >= i;
    }

    public DatagramReader(byte[] bArr, boolean z) {
        this(z ? Arrays.copyOf(bArr, bArr.length) : bArr, 0, bArr.length);
    }

    public DatagramReader(byte[] bArr, int i, int i2) {
        this.byteStream = new RangeInputStream(bArr, i, i2);
        this.currentByte = (byte) 0;
        this.currentBitIndex = -1;
        this.markByte = (byte) 0;
        this.markBitIndex = -1;
    }

    public DatagramReader(byte[] bArr) {
        this(bArr, true);
    }
}
