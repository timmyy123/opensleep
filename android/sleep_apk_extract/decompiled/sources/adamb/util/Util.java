package adamb.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes.dex */
public abstract class Util {
    public static int asIntLE(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return i3;
            }
            i3 = (bArr[i4 + i] & 255) + (i3 << 8);
            i2 = i4;
        }
    }

    public static long asLongLE(byte[] bArr, int i, int i2) {
        long j = 0;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j;
            }
            j = (j << 8) + ((long) (bArr[i3 + i] & 255));
            i2 = i3;
        }
    }

    public static String asUTF8(byte[] bArr, int i, int i2) {
        try {
            return Charset.forName(OAuth.ENCODING).newDecoder().decode(ByteBuffer.wrap(bArr, i, i2)).toString();
        } catch (MalformedInputException | UnmappableCharacterException | CharacterCodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int highNibble(byte b) {
        return ubyte(b) >>> 4;
    }

    public static byte[] intLE(int i) {
        byte[] bArr = new byte[4];
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
        return bArr;
    }

    public static boolean intervalEquals(byte[] bArr, int i, byte[] bArr2) {
        if (bArr.length - i < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int lowNibble(byte b) {
        return b & 15;
    }

    public static int readCompletely(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        do {
            int i2 = inputStream.read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                return i;
            }
            i += i2;
        } while (i < bArr.length);
        return i;
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        return intervalEquals(bArr, 0, bArr2);
    }

    public static int streamFind(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        if (readCompletely(inputStream, bArr2) == length) {
            int i = 0;
            if (bArr.length > 0) {
                CircularByteQueue circularByteQueue = new CircularByteQueue(bArr2, true);
                while (!circularByteQueue.equals(bArr)) {
                    int i2 = inputStream.read();
                    i++;
                    if (i2 != -1) {
                        circularByteQueue.put((byte) i2);
                    }
                }
            }
            return i;
        }
        return -1;
    }

    public static int ubyte(byte b) {
        return b & 255;
    }

    public static byte ubyte(int i) {
        return (byte) i;
    }
}
