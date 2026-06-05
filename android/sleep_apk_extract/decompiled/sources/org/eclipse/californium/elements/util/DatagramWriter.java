package org.eclipse.californium.elements.util;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class DatagramWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DatagramWriter.class);
    private final ByteArrayOutputStream byteStream;
    private int currentBitIndex;
    private byte currentByte;

    public DatagramWriter(boolean z) {
        this.byteStream = z ? new ByteArrayOutputStream() { // from class: org.eclipse.californium.elements.util.DatagramWriter.1
            @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Bytes.clear(((ByteArrayOutputStream) this).buf);
                super.close();
            }
        } : new ByteArrayOutputStream();
        resetCurrentByte();
    }

    private final void resetCurrentByte() {
        this.currentByte = (byte) 0;
        this.currentBitIndex = 7;
    }

    public void close() {
        try {
            this.byteStream.close();
        } catch (IOException e) {
            LOGGER.warn("{}.close() failed!", this.byteStream.getClass(), e);
        }
    }

    public final boolean isBytePending() {
        return this.currentBitIndex < 7;
    }

    public int size() {
        return this.byteStream.size();
    }

    public byte[] toByteArray() {
        writeCurrentByte();
        byte[] byteArray = this.byteStream.toByteArray();
        this.byteStream.reset();
        return byteArray;
    }

    public String toString() {
        byte[] byteArray = this.byteStream.toByteArray();
        if (byteArray == null || byteArray.length == 0) {
            return "--";
        }
        StringBuilder sb = new StringBuilder(byteArray.length * 3);
        for (int i = 0; i < byteArray.length; i++) {
            sb.append(String.format("%02X", Integer.valueOf(byteArray[i] & 255)));
            if (i < byteArray.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public void write(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            Home$$ExternalSyntheticBUOutline0.m("Number of bits must be 1 to 32, not %d", new Object[]{Integer.valueOf(i2)});
            return;
        }
        if (i2 < 32 && (i >> i2) != 0) {
            Home$$ExternalSyntheticBUOutline0.m("Truncating value %d to %d-bit integer", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if ((i2 & 7) == 0 && !isBytePending()) {
            for (int i3 = i2 - 8; i3 >= 0; i3 -= 8) {
                this.byteStream.write((byte) (i >> i3));
            }
            return;
        }
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (((i >> i4) & 1) != 0) {
                this.currentByte = (byte) (this.currentByte | (1 << this.currentBitIndex));
            }
            int i5 = this.currentBitIndex - 1;
            this.currentBitIndex = i5;
            if (i5 < 0) {
                writeCurrentByte();
            }
        }
    }

    public void writeByte(byte b) {
        if (isBytePending()) {
            write(b & 255, 8);
        } else {
            this.byteStream.write(b);
        }
    }

    public void writeBytes(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (!isBytePending()) {
            this.byteStream.write(bArr, 0, bArr.length);
            return;
        }
        for (byte b : bArr) {
            write(b & 255, 8);
        }
    }

    public void writeCurrentByte() {
        if (isBytePending()) {
            this.byteStream.write(this.currentByte);
            resetCurrentByte();
        }
    }

    public void writeLong(long j, int i) {
        if (i < 0 || i > 64) {
            Home$$ExternalSyntheticBUOutline0.m("Number of bits must be 1 to 64, not %d", new Object[]{Integer.valueOf(i)});
            return;
        }
        if (i < 64 && (j >> i) != 0) {
            Home$$ExternalSyntheticBUOutline0.m("Truncating value %d to %d-bit integer", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
            return;
        }
        if ((i & 7) == 0 && !isBytePending()) {
            for (int i2 = i - 8; i2 >= 0; i2 -= 8) {
                this.byteStream.write((byte) (j >> i2));
            }
            return;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (((j >> i3) & 1) != 0) {
                this.currentByte = (byte) (this.currentByte | (1 << this.currentBitIndex));
            }
            int i4 = this.currentBitIndex - 1;
            this.currentBitIndex = i4;
            if (i4 < 0) {
                writeCurrentByte();
            }
        }
    }

    public DatagramWriter() {
        this(false);
    }

    public DatagramWriter(int i) {
        this.byteStream = new ByteArrayOutputStream(i);
        resetCurrentByte();
    }

    public void write(DatagramWriter datagramWriter) {
        try {
            datagramWriter.writeCurrentByte();
            datagramWriter.byteStream.writeTo(this.byteStream);
        } catch (IOException unused) {
        }
    }
}
