package org.eclipse.californium.scandium.dtls;

import java.util.Arrays;
import java.util.Date;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.cipher.RandomManager;

/* JADX INFO: loaded from: classes5.dex */
public class Random extends Bytes {
    public Random(byte[] bArr) {
        super(bArr);
        if (bArr.length == 32) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Random bytes array's length must be 32");
        throw null;
    }

    public static byte[] createBytes() {
        byte[] bArrCreateBytes = Bytes.createBytes(RandomManager.currentSecureRandom(), 32);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArrCreateBytes[0] = (byte) (iCurrentTimeMillis >> 24);
        bArrCreateBytes[1] = (byte) (iCurrentTimeMillis >> 16);
        bArrCreateBytes[2] = (byte) (iCurrentTimeMillis >> 8);
        bArrCreateBytes[3] = (byte) iCurrentTimeMillis;
        return bArrCreateBytes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\t\t\tGMT Unix Time: ");
        byte[] bytes = getBytes();
        sb.append(new Date(((long) (((bytes[0] & 255) << 24) | ((bytes[1] & 255) << 16) | ((bytes[2] & 255) << 8) | (bytes[3] & 255))) * 1000));
        sb.append(StringUtil.lineSeparator());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bytes, 4, 32);
        sb.append("\t\t\tRandom Bytes: ");
        sb.append(StringUtil.byteArray2Hex(bArrCopyOfRange));
        sb.append(StringUtil.lineSeparator());
        return sb.toString();
    }

    public Random() {
        this(createBytes());
    }
}
