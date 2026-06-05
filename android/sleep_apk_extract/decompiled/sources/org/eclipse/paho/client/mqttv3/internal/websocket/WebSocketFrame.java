package org.eclipse.paho.client.mqttv3.internal.websocket;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Random;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class WebSocketFrame {
    public static final int frameLengthOverhead = 6;
    private boolean closeFlag;
    private boolean fin;
    private byte opcode;
    private byte[] payload;

    public WebSocketFrame(InputStream inputStream) throws IOException {
        byte[] bArr;
        int i = 0;
        this.closeFlag = false;
        setFinAndOpCode((byte) inputStream.read());
        byte b = this.opcode;
        if (b != 2) {
            if (b == 8) {
                this.closeFlag = true;
                return;
            } else {
                StringBuffer stringBuffer = new StringBuffer("Invalid Frame: Opcode: ");
                stringBuffer.append((int) this.opcode);
                throw new IOException(stringBuffer.toString());
            }
        }
        byte b2 = (byte) inputStream.read();
        boolean z = (b2 & 128) != 0;
        int i2 = (byte) (b2 & 127);
        int i3 = i2 != 127 ? i2 == 126 ? 2 : 0 : 8;
        i2 = i3 > 0 ? 0 : i2;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            } else {
                i2 |= (((byte) inputStream.read()) & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
        } else {
            bArr = null;
        }
        this.payload = new byte[i2];
        int i4 = 0;
        int i5 = i2;
        while (i4 != i2) {
            int i6 = inputStream.read(this.payload, i4, i5);
            i4 += i6;
            i5 -= i6;
        }
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr2 = this.payload;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i % 4]);
            i++;
        }
    }

    public static void appendFinAndOpCode(ByteBuffer byteBuffer, byte b, boolean z) {
        byteBuffer.put((byte) ((b & 15) | (z ? -128 : 0)));
    }

    private static void appendLength(ByteBuffer byteBuffer, int i, boolean z) {
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Length cannot be negative");
            return;
        }
        int i2 = z ? -128 : 0;
        if (i <= 65535) {
            if (i < 126) {
                byteBuffer.put((byte) (i | i2));
                return;
            }
            byteBuffer.put((byte) (i2 | 126));
            byteBuffer.put((byte) (i >> 8));
            byteBuffer.put((byte) (i & PHIpAddressSearchManager.END_IP_SCAN));
            return;
        }
        byteBuffer.put((byte) (i2 | 127));
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN));
        byteBuffer.put((byte) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN));
        byteBuffer.put((byte) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN));
        byteBuffer.put((byte) (i & PHIpAddressSearchManager.END_IP_SCAN));
    }

    public static void appendLengthAndMask(ByteBuffer byteBuffer, int i, byte[] bArr) {
        if (bArr == null) {
            appendLength(byteBuffer, i, false);
        } else {
            appendLength(byteBuffer, i, true);
            byteBuffer.put(bArr);
        }
    }

    public static byte[] generateMaskingKey() {
        Random random = new Random();
        return new byte[]{(byte) random.nextInt(PHIpAddressSearchManager.END_IP_SCAN), (byte) random.nextInt(PHIpAddressSearchManager.END_IP_SCAN), (byte) random.nextInt(PHIpAddressSearchManager.END_IP_SCAN), (byte) random.nextInt(PHIpAddressSearchManager.END_IP_SCAN)};
    }

    private void setFinAndOpCode(byte b) {
        this.fin = (b & 128) != 0;
        this.opcode = (byte) (b & 15);
    }

    public byte[] encodeFrame() {
        byte[] bArr = this.payload;
        int length = bArr.length;
        int i = length + 6;
        if (bArr.length > 65535) {
            i = length + 14;
        } else if (bArr.length >= 126) {
            i = length + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        appendFinAndOpCode(byteBufferAllocate, this.opcode, this.fin);
        byte[] bArrGenerateMaskingKey = generateMaskingKey();
        appendLengthAndMask(byteBufferAllocate, this.payload.length, bArrGenerateMaskingKey);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.payload;
            if (i2 >= bArr2.length) {
                byteBufferAllocate.flip();
                return byteBufferAllocate.array();
            }
            byte b = (byte) (bArr2[i2] ^ bArrGenerateMaskingKey[i2 % 4]);
            bArr2[i2] = b;
            byteBufferAllocate.put(b);
            i2++;
        }
    }

    public byte getOpcode() {
        return this.opcode;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public boolean isCloseFlag() {
        return this.closeFlag;
    }

    public boolean isFin() {
        return this.fin;
    }

    public WebSocketFrame(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        this.closeFlag = false;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        setFinAndOpCode(byteBufferWrap.get());
        byte b = byteBufferWrap.get();
        boolean z = (b & 128) != 0;
        int i2 = (byte) (b & 127);
        int i3 = i2 == 127 ? 8 : i2 == 126 ? 2 : 0;
        while (true) {
            i3--;
            if (i3 <= 0) {
                break;
            } else {
                i2 |= (byteBufferWrap.get() & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr2 = new byte[4];
            byteBufferWrap.get(bArr2, 0, 4);
        } else {
            bArr2 = null;
        }
        byte[] bArr3 = new byte[i2];
        this.payload = bArr3;
        byteBufferWrap.get(bArr3, 0, i2);
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr4 = this.payload;
            if (i >= bArr4.length) {
                return;
            }
            bArr4[i] = (byte) (bArr4[i] ^ bArr2[i % 4]);
            i++;
        }
    }

    public WebSocketFrame(byte b, boolean z, byte[] bArr) {
        this.closeFlag = false;
        this.opcode = b;
        this.fin = z;
        this.payload = bArr;
    }
}
