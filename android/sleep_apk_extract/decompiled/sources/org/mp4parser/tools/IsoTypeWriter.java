package org.mp4parser.tools;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IsoTypeWriter {
    public static void writeFixedPoint0230(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & PHIpAddressSearchManager.END_IP_SCAN));
    }

    public static void writeFixedPoint1616(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & PHIpAddressSearchManager.END_IP_SCAN));
    }

    public static void writeFixedPoint88(ByteBuffer byteBuffer, double d) {
        short s = (short) (d * 256.0d);
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    public static void writeIso639(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length != 3) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("\"", str, "\" language string isn't exactly 3 characters long!"));
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
        }
        writeUInt16(byteBuffer, i);
    }

    public static void writeUInt16(ByteBuffer byteBuffer, int i) {
        writeUInt8(byteBuffer, (65535 & i) >> 8);
        writeUInt8(byteBuffer, i & PHIpAddressSearchManager.END_IP_SCAN);
    }

    public static void writeUInt16BE(ByteBuffer byteBuffer, int i) {
        writeUInt8(byteBuffer, i & PHIpAddressSearchManager.END_IP_SCAN);
        writeUInt8(byteBuffer, (65535 & i) >> 8);
    }

    public static void writeUInt24(ByteBuffer byteBuffer, int i) {
        int i2 = i & 16777215;
        writeUInt16(byteBuffer, i2 >> 8);
        writeUInt8(byteBuffer, i2);
    }

    public static void writeUInt32(ByteBuffer byteBuffer, long j) {
        byteBuffer.putInt((int) j);
    }

    public static void writeUInt32BE(ByteBuffer byteBuffer, long j) {
        writeUInt16BE(byteBuffer, ((int) j) & 65535);
        writeUInt16BE(byteBuffer, (int) ((j >> 16) & 65535));
    }

    public static void writeUInt48(ByteBuffer byteBuffer, long j) {
        writeUInt16(byteBuffer, (int) ((281474976710655L & j) >> 32));
        writeUInt32(byteBuffer, j & 4294967295L);
    }

    public static void writeUInt64(ByteBuffer byteBuffer, long j) {
        byteBuffer.putLong(j);
    }

    public static void writeUInt8(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & PHIpAddressSearchManager.END_IP_SCAN));
    }

    public static void writeUtf8String(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.convert(str));
        writeUInt8(byteBuffer, 0);
    }

    public static void writeZeroTermUtf8String(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.convert(str));
        writeUInt8(byteBuffer, 0);
    }
}
