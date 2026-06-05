package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0565Io {
    public static byte[] A0p;
    public static String[] A0q = {"OEIbbTfz9Gy2QPZJ4z5Vw", "FnBQgCqHaiwiLpzppV61TScSRwvWWbyQ", "lhw151GRabUj4MWW", "UfmG6su3PUQ09WKpaYJZnWqY2jTnsIjF", "3xkcsKvZQCBLKFsErtBjnZACEf0cQH4k", "sFlP3vQMUMetLm2UJmahj", "kHqDQLP2yFWUZolGjug5L", "bkJ1oyWHbNg3F4t8gWvtnFc1AhojVjRe"};
    public int A0I;
    public int A0N;
    public int A0Q;
    public int A0R;
    public int A0V;
    public DrmInitData A0Z;
    public C0526Hb A0a;
    public InterfaceC0528Hd A0b;
    public C0529He A0c;
    public String A0d;
    public String A0e;
    public boolean A0g;
    public boolean A0i;
    public byte[] A0j;
    public byte[] A0k;
    public byte[] A0m;
    public int A0n;
    public int A0W = -1;
    public int A0M = -1;
    public int A0L = -1;
    public int A0J = -1;
    public int A0K = 0;
    public int A0S = -1;
    public float A0A = 0.0f;
    public float A08 = 0.0f;
    public float A09 = 0.0f;
    public byte[] A0l = null;
    public int A0U = -1;
    public boolean A0h = false;
    public int A0G = -1;
    public int A0H = -1;
    public int A0F = -1;
    public int A0O = 1000;
    public int A0P = 200;
    public float A06 = -1.0f;
    public float A07 = -1.0f;
    public float A04 = -1.0f;
    public float A05 = -1.0f;
    public float A02 = -1.0f;
    public float A03 = -1.0f;
    public float A0B = -1.0f;
    public float A0C = -1.0f;
    public float A00 = -1.0f;
    public float A01 = -1.0f;
    public int A0E = 1;
    public int A0D = -1;
    public int A0T = 8000;
    public long A0X = 0;
    public long A0Y = 0;
    public boolean A0f = true;
    public String A0o = A03(1067, 3, 26);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<String, List<byte[]>> A02(C02284v c02284v) throws C3K {
        try {
            c02284v.A0g(16);
            long jA0O = c02284v.A0O();
            if (jA0O == 1482049860) {
                return new Pair<>(A03(1117, 10, 32), null);
            }
            if (jA0O == 859189832) {
                return new Pair<>(A03(1088, 10, 2), null);
            }
            if (A0q[1].charAt(11) != 'i') {
                throw new RuntimeException();
            }
            A0q[2] = "JoNevXQ";
            if (jA0O != 826496599) {
                AbstractC02134g.A07(A03(312, 17, 46), A03(492, 51, 65));
                return new Pair<>(A03(1189, 15, 45), null);
            }
            byte[] bArrA0l = c02284v.A0l();
            for (int iA09 = c02284v.A09() + 20; iA09 < bArrA0l.length - 4; iA09++) {
                if (bArrA0l[iA09] == 0 && bArrA0l[iA09 + 1] == 0 && bArrA0l[iA09 + 2] == 1 && bArrA0l[iA09 + 3] == 15) {
                    return new Pair<>(A03(1179, 10, 80), Collections.singletonList(Arrays.copyOfRange(bArrA0l, iA09, bArrA0l.length)));
                }
            }
            throw C3K.A01(A03(267, 45, 108), null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C3K.A01(A03(166, 33, 80), null);
        }
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0p = new byte[]{MqttWireMessage.MESSAGE_TYPE_PINGRESP, -1, 50, 68, 83, 83, 72, 77, 70, -1, 76, 72, 76, 68, 51, 88, 79, 68, -1, 83, 78, -1, -47, -17, -47, -47, -45, -43, -13, -43, -41, -57, -2, 28, 1, 17, 16, 47, 77, 50, 66, 65, 29, 51, 70, 62, 64, 51, 65, 65, -6, 24, -3, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -24, 5, 8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 5, -2, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 30, 4, 0, 2, -14, 22, 52, 27, 33, 22, 24, 9, 39, 21, 24, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, -9, 20, -6, -59, -29, -47, -44, -55, -53, -77, -48, -73, 3, 33, 15, 21, -15, 3, 5, 15, -13, 17, 1, 2, 7, 5, -18, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, -16, -6, -36, -13, -7, -4, -18, 1, -36, -10, -14, -14, -14, 19, 49, 34, 21, 31, 1, 27, 32, 38, 1, 20, 27, 25, -34, -4, -19, -32, -22, -52, -26, -21, -15, -52, -23, -26, -15, 59, 89, 78, 76, 79, 63, 66, 62, 23, 53, 44, 37, 40, 24, 31, 41, 18, 63, 63, 60, 63, -19, 61, 46, 63, 64, 54, 59, 52, -19, 19, 60, 66, 63, 16, 16, -19, 61, 63, 54, 67, 46, 65, 50, -19, 49, 46, 65, 46, -4, 41, 41, 38, 41, -41, 39, 24, 41, 42, 32, 37, 30, -41, 4, 10, -26, -8, -6, 4, -41, 26, 38, 27, 28, 26, -41, 39, 41, 32, 45, 24, 43, 28, -19, 26, 26, 23, 26, -56, 24, 9, 26, 27, 17, 22, 15, -56, 30, 23, 26, 10, 17, 27, -56, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -56, 24, 26, 17, 30, 9, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 47, 74, 82, 85, 78, 77, 9, 93, 88, 9, 79, 82, 87, 77, 9, 47, 88, 94, 91, 44, 44, 9, 63, 44, 26, 9, 82, 87, 82, 93, 82, 74, 85, 82, 99, 74, 93, 82, 88, 87, 9, 77, 74, 93, 74, -8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 29, 26, 30, 22, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -16, 35, 31, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 26, 29, 39, 67, 77, 77, 67, 72, 65, -6, 29, 73, 62, 63, 61, 42, 76, 67, 80, 59, 78, 63, -6, 64, 73, 76, -6, 61, 73, 62, 63, 61, -6, -35, -2, -3, -68, -33, -46, -36, -81, -36, -30, -66, -48, -46, -36, -81, -8, 2, -81, 4, -3, 2, 4, -1, -1, -2, 1, 3, -12, -13, -67, -81, -30, -12, 3, 3, -8, -3, -10, -81, -4, -8, -4, -12, -29, 8, -1, -12, -81, 3, -2, -81, 3, 15, -12, 6, -14, 3, 5, -14, 78, 90, 67, 63, 72, 81, 42, 75, 66, 78, 36, 48, 37, 22, 41, 37, 0, 18, 36, 36, 1, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, -13, 6, 2, -35, 3, 2, -12, -26, 53, 65, 54, 39, 58, 54, 17, 57, 39, 36, 56, 54, 54, 62, 74, 65, 58, 45, 62, 64, 45, 37, 62, 53, 72, 64, 53, 51, 68, 53, 52, -16, 29, 25, 29, 21, -16, 68, 73, 64, 53, -2, 19, 44, 41, 44, 45, 53, 44, -34, 4, 45, 51, 48, 1, 1, -20, -34, 17, 35, 50, 50, 39, 44, 37, -34, 43, 39, 43, 35, 18, 55, 46, 35, -34, 50, 45, -34, 52, 39, 34, 35, 45, -19, 54, -21, 51, 44, 41, 44, 45, 53, 44, 4, 29, 33, 20, 18, 30, 22, 29, 24, 41, 20, 19, -49, 18, 30, 19, 20, 18, -49, 24, 19, 20, 29, 35, 24, 21, 24, 20, 33, -35, 78, 103, 108, 110, 105, 105, 104, 107, 109, 94, 93, 25, 73, 60, 70, 25, 91, 98, 109, 25, 93, 94, 105, 109, 97, 51, 25, 50, 75, 80, 82, 77, 77, 76, 79, 81, 66, 65, -3, 63, 70, 68, -3, 66, 75, 65, 70, 62, 75, -3, 45, 32, 42, -3, 63, 70, 81, -3, 65, 66, 77, 81, 69, 23, -3, -8, 17, 22, 24, 19, 19, 18, 21, 23, 8, 7, -61, 9, 15, 18, 4, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 10, -61, 19, 18, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 23, -61, -13, -26, -16, -61, 5, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, -61, 7, 8, 19, 23, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -35, -61, 55, 80, 85, 87, 82, 82, 81, 84, 86, 71, 70, 2, 78, 75, 86, 86, 78, 71, 2, 71, 80, 70, 75, 67, 80, 2, 50, 37, 47, 2, 68, 75, 86, 2, 70, 71, 82, 86, 74, 28, 2, -22, -13, -43, -22, -59, -3, 6, -12, -9, -20, -18, -39, 22, 31, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 5, 7, -12, -17, 9, 19, 15, -17, 1, 16, 34, 43, 25, 28, 17, 19, 0, -5, 21, 31, 27, -5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 31, 28, -41, -32, -50, -47, -58, -56, -75, -80, -54, -44, -48, -80, -62, -41, -60, 10, 19, 1, 4, -7, -5, -24, -29, -3, 7, 3, -29, 7, 4, 27, 36, 18, 21, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -12, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 24, 20, -12, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 27, 8, 61, 70, 52, 58, 22, 61, 45, 62, 22, 45, 54, 60, 57, 42, 42, 51, 60, 49, 37, 34, 44, 47, 30, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, -18, 10, 19, 10, 4, -19, 15, 30, 30, 26, 23, 17, 15, 34, 23, 29, 28, -35, 18, 36, 16, 33, 35, 16, 33, 45, 60, 60, 56, 53, 47, 45, 64, 53, 59, 58, -5, 60, 51, 63, 4, 19, 19, 15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, 4, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 17, -46, 25, 18, 5, 22, 24, 5, 31, 46, 46, 42, 39, 33, 31, 50, 39, 45, 44, -19, 54, -21, 49, 51, 32, 48, 39, 46, 40, 60, 43, 48, 54, -10, 40, 42, -6, 9, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 23, -41, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -37, 16, 36, 19, 24, 30, -34, 21, 27, 16, 18, 75, 95, 78, 83, 89, 25, 87, 90, 30, 75, 23, 86, 75, 94, 87, -3, 17, 0, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -53, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 25, -39, 23, 26, 15, 17, -41, -10, -36, -7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -4, 1, 7, -57, 7, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 70, 90, 73, 78, 84, 20, 87, 70, 92, -17, 3, 
        -14, -9, -3, -67, 2, 0, 3, -13, -69, -10, -14, 76, 96, 79, 84, 90, 26, 97, 89, 79, 25, 79, 95, 94, 47, 67, 50, 55, 61, -3, 68, 60, 50, -4, 50, 66, 65, -4, 54, 50, 18, 38, 21, 26, 32, -32, 39, 32, 35, 19, 26, 36, 43, 63, 46, 51, 57, -7, 66, -9, 63, 56, 53, 56, 57, 65, 56, -4, 5, -2, 6, -9, 10, 6, -63, 8, 6, 6, 74, 59, 78, 74, 5, 78, 3, 73, 73, 55, -11, -24, -29, -28, -18, -82, -78, -26, -17, -17, 47, 34, 29, 30, 40, -24, 26, 47, -23, -22, 66, 53, 48, 49, 59, -5, 45, 66, 47, 19, 6, 1, 2, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -52, 1, 6, 19, 21, 17, 4, -1, 0, 10, -54, -1, 10, 7, -3, 20, -56, 17, 4, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 4, 10, 9, 22, 9, 4, 5, 15, -49, 8, 5, 22, 3, 37, 24, 19, 20, 30, -34, 28, 31, -29, 37, -36, 20, 34, 98, 85, 80, 81, 91, 27, 89, 92, 81, 83, 30, 67, 54, 49, 50, 60, -4, 68, 67, 48, -2, 32, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 25, -39, 34, -41, 31, 24, 21, 24, 25, 33, 24, 43, 30, 25, 26, 36, -28, 45, -30, 43, 35, 25, -29, 36, 35, -25, -29, 43, 37, -19, 93, 80, 75, 76, 86, 22, 95, 20, 93, 85, 75, 21, 86, 85, 25, 21, 93, 87, 32};
    }

    static {
        A07();
    }

    public static List<byte[]> A05(byte[] bArr) throws C3K {
        String strA03 = A03(233, 34, 43);
        try {
            if (bArr[0] == 2) {
                int vorbisInfoLength = 1;
                int i = 0;
                while ((bArr[vorbisInfoLength] & 255) == 255) {
                    i += PHIpAddressSearchManager.END_IP_SCAN;
                    vorbisInfoLength++;
                }
                int i2 = vorbisInfoLength + 1;
                int i3 = i + (bArr[vorbisInfoLength] & PHIpAddressSearchManager.END_IP_SCAN);
                int offset = 0;
                while ((bArr[i2] & 255) == 255) {
                    offset += PHIpAddressSearchManager.END_IP_SCAN;
                    i2++;
                }
                int vorbisInfoLength2 = i2 + 1;
                int offset2 = offset + (bArr[i2] & PHIpAddressSearchManager.END_IP_SCAN);
                if (bArr[vorbisInfoLength2] == 1) {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, vorbisInfoLength2, bArr2, 0, i3);
                    int vorbisInfoLength3 = vorbisInfoLength2 + i3;
                    if (bArr[vorbisInfoLength3] == 3) {
                        int vorbisInfoLength4 = vorbisInfoLength3 + offset2;
                        if (bArr[vorbisInfoLength4] == 5) {
                            byte[] bArr3 = new byte[bArr.length - vorbisInfoLength4];
                            System.arraycopy(bArr, vorbisInfoLength4, bArr3, 0, bArr.length - vorbisInfoLength4);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw C3K.A01(strA03, null);
                    }
                    throw C3K.A01(strA03, null);
                }
                throw C3K.A01(strA03, null);
            }
            throw C3K.A01(strA03, null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C3K.A01(strA03, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNull({"output"})
    public void A06() {
        AbstractC02053y.A01(this.A0b);
    }

    public static boolean A09(C02284v c02284v) throws C3K {
        try {
            int iA0G = c02284v.A0G();
            if (iA0G == 1) {
                return true;
            }
            if (iA0G != 65534) {
                return false;
            }
            c02284v.A0f(24);
            if (c02284v.A0P() == MatroskaExtractor.A0x.getMostSignificantBits()) {
                if (c02284v.A0P() == MatroskaExtractor.A0x.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C3K.A01(A03(199, 34, 58), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MetaExoPlayerCustomization("Removed opus check as it breaks some 360 files")
    public boolean A0B(boolean z) {
        return this.A0N > 0;
    }

    private byte[] A0C() {
        if (this.A06 == -1.0f) {
            return null;
        }
        float f = this.A07;
        if (A0q[2].length() == 25) {
            throw new RuntimeException();
        }
        String[] strArr = A0q;
        strArr[6] = "HGnETyIhtjZXJxyU1T6j8";
        strArr[0] = "bCjehM63cEytRPEEQFxd2";
        if (f == -1.0f || this.A04 == -1.0f || this.A05 == -1.0f || this.A02 == -1.0f || this.A03 == -1.0f) {
            return null;
        }
        float f2 = this.A0B;
        if (A0q[7].charAt(7) != '5') {
            String[] strArr2 = A0q;
            strArr2[6] = "JEOA6svQlcm533p1kymyr";
            strArr2[0] = "xcQgG7qgeuJwHZcHlhioj";
            if (f2 == -1.0f) {
                return null;
            }
        } else {
            A0q[2] = "jAXoTae2Kk";
            if (f2 == -1.0f) {
                return null;
            }
        }
        if (this.A0C == -1.0f || this.A00 == -1.0f || this.A01 == -1.0f) {
            return null;
        }
        byte[] bArr = new byte[25];
        ByteBuffer hdrStaticInfo = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        hdrStaticInfo.put((byte) 0);
        hdrStaticInfo.putShort((short) ((this.A06 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A07 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A04 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A05 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A02 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A03 * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A0B * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) ((this.A0C * 50000.0f) + 0.5f));
        hdrStaticInfo.putShort((short) (this.A00 + 0.5f));
        hdrStaticInfo.putShort((short) (this.A01 + 0.5f));
        hdrStaticInfo.putShort((short) this.A0O);
        hdrStaticInfo.putShort((short) this.A0P);
        return bArr;
    }

    @EnsuresNonNull({"codecPrivate"})
    private byte[] A0D(String str) throws C3K {
        if (this.A0j != null) {
            byte[] bArr = this.A0j;
            if (A0q[1].charAt(11) != 'i') {
                throw new RuntimeException();
            }
            A0q[2] = "piNmNCdUWkr";
            return bArr;
        }
        throw C3K.A01(A03(329, 31, 93) + str, null);
    }

    @RequiresNonNull({"output"})
    public final void A0E() {
        if (this.A0c != null) {
            C0529He c0529He = this.A0c;
            InterfaceC0528Hd interfaceC0528Hd = this.A0b;
            String[] strArr = A0q;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0q;
            strArr2[3] = "E7jv121Xgp0U6ziYD0QsnQRL0Byqc4aj";
            strArr2[4] = "tGwzWQC5dBvo0sMjKwRXnFk53sqcL924";
            c0529He.A05(interfaceC0528Hd, this.A0a);
        }
    }

    public final void A0F() {
        if (this.A0c != null) {
            this.A0c.A02();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0G(com.facebook.ads.redexgen.core.HA r20, int r21) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 2498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0565Io.A0G(com.facebook.ads.redexgen.X.HA, int):void");
    }
}
