package com.fasterxml.jackson.core.io;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class JsonStringEncoder {
    private static final char[] HC = CharTypes.copyHexChars(true);
    private static final byte[] HB = CharTypes.copyHexBytes(true);
    private static final JsonStringEncoder instance = new JsonStringEncoder();

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                byte[] bArr = HB;
                byteArrayBuilder.append(bArr[i >> 12]);
                byteArrayBuilder.append(bArr[(i >> 8) & 15]);
                i &= PHIpAddressSearchManager.END_IP_SCAN;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HB;
            byteArrayBuilder.append(bArr2[i >> 4]);
            byteArrayBuilder.append(bArr2[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HC;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i << 10) + i2) - 56613888;
        }
        OggIO$$ExternalSyntheticBUOutline0.m(Integer.toHexString(i), ", second 0x", Integer.toHexString(i2), "; illegal combination", "Broken surrogate pair: first char 0x");
        return 0;
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }

    public static int _initialByteBufSize(int i) {
        return Math.min(Math.max(24, i + 6 + (i >> 1)), 32000);
    }

    public static int _initialCharBufSize(int i) {
        return Math.min(Math.max(16, Math.min((i >> 3) + 6, 1000) + i), 32000);
    }

    private char[] _qbuf() {
        return new char[]{'\\', 0, '0', '0', 0, 0};
    }

    public static JsonStringEncoder getInstance() {
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] encodeAsUTF8(String str) {
        int i;
        int i2;
        int length = str.length();
        int i_initialByteBufSize = _initialByteBufSize(length);
        byte[] bArrFinishCurrentSegment = new byte[i_initialByteBufSize];
        ByteArrayBuilder byteArrayBuilderFromInitial = null;
        int i3 = 0;
        int i4 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                break;
            }
            int i5 = i3 + 1;
            char cCharAt = str.charAt(i3);
            while (cCharAt <= 127) {
                if (i4 >= i_initialByteBufSize) {
                    if (byteArrayBuilderFromInitial == null) {
                        byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i4);
                    }
                    byte[] bArrFinishCurrentSegment2 = byteArrayBuilderFromInitial.finishCurrentSegment();
                    bArrFinishCurrentSegment = bArrFinishCurrentSegment2;
                    i_initialByteBufSize = bArrFinishCurrentSegment2.length;
                    i4 = 0;
                }
                int i6 = i4 + 1;
                bArrFinishCurrentSegment[i4] = (byte) cCharAt;
                if (i5 >= length) {
                    i4 = i6;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i5);
                i5++;
                cCharAt = cCharAt2;
                i4 = i6;
            }
            if (byteArrayBuilderFromInitial == null) {
                byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i4);
            }
            if (i4 >= i_initialByteBufSize) {
                bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                i_initialByteBufSize = bArrFinishCurrentSegment.length;
                i4 = 0;
            }
            if (cCharAt < 2048) {
                i = i4 + 1;
                bArrFinishCurrentSegment[i4] = (byte) ((cCharAt >> 6) | 192);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i7 = i4 + 1;
                bArrFinishCurrentSegment[i4] = (byte) ((cCharAt >> '\f') | 224);
                if (i7 >= i_initialByteBufSize) {
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i_initialByteBufSize = bArrFinishCurrentSegment.length;
                    i7 = 0;
                }
                bArrFinishCurrentSegment[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                i = i7 + 1;
            } else {
                if (cCharAt > 56319) {
                    _illegal(cCharAt);
                }
                if (i5 >= length) {
                    _illegal(cCharAt);
                }
                int i8 = i5 + 1;
                int i_convert = _convert(cCharAt, str.charAt(i5));
                if (i_convert > 1114111) {
                    _illegal(i_convert);
                }
                int i9 = i4 + 1;
                bArrFinishCurrentSegment[i4] = (byte) ((i_convert >> 18) | 240);
                if (i9 >= i_initialByteBufSize) {
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i_initialByteBufSize = bArrFinishCurrentSegment.length;
                    i9 = 0;
                }
                int i10 = i9 + 1;
                bArrFinishCurrentSegment[i9] = (byte) (((i_convert >> 12) & 63) | 128);
                if (i10 >= i_initialByteBufSize) {
                    byte[] bArrFinishCurrentSegment3 = byteArrayBuilderFromInitial.finishCurrentSegment();
                    bArrFinishCurrentSegment = bArrFinishCurrentSegment3;
                    i_initialByteBufSize = bArrFinishCurrentSegment3.length;
                    i10 = 0;
                }
                int i11 = i10 + 1;
                bArrFinishCurrentSegment[i10] = (byte) (((i_convert >> 6) & 63) | 128);
                i2 = i_convert;
                i3 = i8;
                i = i11;
                if (i < i_initialByteBufSize) {
                    byte[] bArrFinishCurrentSegment4 = byteArrayBuilderFromInitial.finishCurrentSegment();
                    bArrFinishCurrentSegment = bArrFinishCurrentSegment4;
                    i_initialByteBufSize = bArrFinishCurrentSegment4.length;
                    i = 0;
                }
                bArrFinishCurrentSegment[i] = (byte) ((i2 & 63) | 128);
                i4 = i + 1;
            }
            i2 = cCharAt;
            i3 = i5;
            if (i < i_initialByteBufSize) {
            }
            bArrFinishCurrentSegment[i] = (byte) ((i2 & 63) | 128);
            i4 = i + 1;
        }
        return byteArrayBuilderFromInitial == null ? Arrays.copyOfRange(bArrFinishCurrentSegment, 0, i4) : byteArrayBuilderFromInitial.completeAndCoalesce(i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        r10 = r6 + 1;
        r6 = r14.charAt(r6);
        r11 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r11 >= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        r6 = _appendNumeric(r6, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        r6 = _appendNamed(r11, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        r11 = r8 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r11 <= r1.length) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        r11 = r1.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r11 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        java.lang.System.arraycopy(r9, 0, r1, r8, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r7 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r7 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        r1 = r7.finishCurrentSegment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        r6 = r6 - r11;
        java.lang.System.arraycopy(r9, r11, r1, 0, r6);
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        io.ktor.events.Events$$ExternalSyntheticBUOutline0.m(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        java.lang.System.arraycopy(r9, 0, r1, r8, r6);
        r8 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (r9 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        r9 = _qbuf();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char[] quoteAsString(String str) {
        int i;
        int length = str.length();
        char[] cArrFinishCurrentSegment = new char[_initialCharBufSize(length)];
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        TextBuffer textBufferFromInitial = null;
        char[] cArr_qbuf = null;
        loop0: while (true) {
            if (i2 >= length) {
                break;
            }
            while (true) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < length2 && iArr[cCharAt] != 0) {
                    break;
                }
                if (i3 >= cArrFinishCurrentSegment.length) {
                    if (textBufferFromInitial == null) {
                        textBufferFromInitial = TextBuffer.fromInitial(cArrFinishCurrentSegment);
                    }
                    try {
                        cArrFinishCurrentSegment = textBufferFromInitial.finishCurrentSegment();
                        i3 = 0;
                    } catch (IOException e) {
                        Events$$ExternalSyntheticBUOutline0.m(e);
                        return null;
                    }
                }
                int i4 = i3 + 1;
                cArrFinishCurrentSegment[i3] = cCharAt;
                i2++;
                if (i2 >= length) {
                    i3 = i4;
                    break loop0;
                }
                i3 = i4;
            }
            i2 = i;
        }
        if (textBufferFromInitial == null) {
            return Arrays.copyOfRange(cArrFinishCurrentSegment, 0, i3);
        }
        textBufferFromInitial.setCurrentLength(i3);
        try {
            return textBufferFromInitial.contentsAsArray();
        } catch (IOException e2) {
            Events$$ExternalSyntheticBUOutline0.m(e2);
            return null;
        }
    }

    public byte[] quoteAsUTF8(String str) {
        int i;
        int i2;
        int i3;
        int length = str.length();
        byte[] bArrFinishCurrentSegment = new byte[_initialByteBufSize(length)];
        ByteArrayBuilder byteArrayBuilderFromInitial = null;
        int i4 = 0;
        int i_appendByte = 0;
        loop0: while (true) {
            if (i4 >= length) {
                break;
            }
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt > 127 || iArr[cCharAt] != 0) {
                    break;
                }
                if (i_appendByte >= bArrFinishCurrentSegment.length) {
                    if (byteArrayBuilderFromInitial == null) {
                        byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i_appendByte);
                    }
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i_appendByte = 0;
                }
                int i5 = i_appendByte + 1;
                bArrFinishCurrentSegment[i_appendByte] = (byte) cCharAt;
                i4++;
                if (i4 >= length) {
                    i_appendByte = i5;
                    break loop0;
                }
                i_appendByte = i5;
            }
            if (byteArrayBuilderFromInitial == null) {
                byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i_appendByte);
            }
            if (i_appendByte >= bArrFinishCurrentSegment.length) {
                bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                i_appendByte = 0;
            }
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 <= 127) {
                i_appendByte = _appendByte(cCharAt2, iArr[cCharAt2], byteArrayBuilderFromInitial, i_appendByte);
                bArrFinishCurrentSegment = byteArrayBuilderFromInitial.getCurrentSegment();
            } else {
                if (cCharAt2 <= 2047) {
                    i3 = i_appendByte + 1;
                    bArrFinishCurrentSegment[i_appendByte] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                        int i7 = i_appendByte + 1;
                        bArrFinishCurrentSegment[i_appendByte] = (byte) ((cCharAt2 >> '\f') | 224);
                        if (i7 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i7 = 0;
                        }
                        bArrFinishCurrentSegment[i7] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i = i7 + 1;
                        i2 = (cCharAt2 & '?') | 128;
                    } else {
                        if (cCharAt2 > 56319) {
                            _illegal(cCharAt2);
                        }
                        if (i6 >= length) {
                            _illegal(cCharAt2);
                        }
                        int i8 = i4 + 2;
                        int i_convert = _convert(cCharAt2, str.charAt(i6));
                        if (i_convert > 1114111) {
                            _illegal(i_convert);
                        }
                        int i9 = i_appendByte + 1;
                        bArrFinishCurrentSegment[i_appendByte] = (byte) ((i_convert >> 18) | 240);
                        if (i9 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i9 = 0;
                        }
                        int i10 = i9 + 1;
                        bArrFinishCurrentSegment[i9] = (byte) (((i_convert >> 12) & 63) | 128);
                        if (i10 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrFinishCurrentSegment[i10] = (byte) (((i_convert >> 6) & 63) | 128);
                        i2 = (i_convert & 63) | 128;
                        i = i11;
                        i6 = i8;
                    }
                    i3 = i;
                }
                if (i3 >= bArrFinishCurrentSegment.length) {
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i3 = 0;
                }
                bArrFinishCurrentSegment[i3] = (byte) i2;
                i_appendByte = i3 + 1;
            }
            i4 = i6;
        }
        return byteArrayBuilderFromInitial == null ? Arrays.copyOfRange(bArrFinishCurrentSegment, 0, i_appendByte) : byteArrayBuilderFromInitial.completeAndCoalesce(i_appendByte);
    }
}
