package com.facebook.ads.androidx.media3.extractor.mkv;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import com.facebook.ads.redexgen.core.AbstractC02053y;
import com.facebook.ads.redexgen.core.AbstractC02134g;
import com.facebook.ads.redexgen.core.C02144h;
import com.facebook.ads.redexgen.core.C02284v;
import com.facebook.ads.redexgen.core.C0526Hb;
import com.facebook.ads.redexgen.core.C0565Io;
import com.facebook.ads.redexgen.core.C0566Ip;
import com.facebook.ads.redexgen.core.C0567Iq;
import com.facebook.ads.redexgen.core.C1749mK;
import com.facebook.ads.redexgen.core.C1751mM;
import com.facebook.ads.redexgen.core.C1767mn;
import com.facebook.ads.redexgen.core.C1777my;
import com.facebook.ads.redexgen.core.C2Y;
import com.facebook.ads.redexgen.core.C3K;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.H9;
import com.facebook.ads.redexgen.core.HA;
import com.facebook.ads.redexgen.core.HD;
import com.facebook.ads.redexgen.core.HS;
import com.facebook.ads.redexgen.core.HV;
import com.facebook.ads.redexgen.core.HY;
import com.facebook.ads.redexgen.core.InterfaceC0528Hd;
import com.facebook.ads.redexgen.core.InterfaceC0562Il;
import com.facebook.ads.redexgen.core.InterfaceC1772ms;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MatroskaExtractor implements H9 {
    public static byte[] A0t;
    public static String[] A0u = {"tBqjpPNwSsfRjGbhoSofYeEQJAfxpzeJ", "SQ32k5yHiSqu0tF5bV2mYZI8q27OK2Wk", "Ew8EcvFtYPYsbuW", "MeCkyRYcfoGShRSoQHq7qyLBTkTGcoSQ", "UyV8GtaWyEclMV8OhG", "yLkQb0Xo1O", "PFhexnCJ0GZtqtRWjlJ7uY4w9", "UodjFtXG6f6h7NmMQ857"};
    public static final HD A0v;
    public static final Map<String, Integer> A0w;
    public static final UUID A0x;
    public static final byte[] A0y;
    public static final byte[] A0z;
    public static final byte[] A10;
    public static final byte[] A11;
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public long A0N;
    public long A0O;

    @MetaExoPlayerCustomization("Removed the final from the member variable")
    public SparseArray<C0565Io> A0P;
    public C02144h A0Q;
    public C02144h A0R;
    public HA A0S;
    public C0565Io A0T;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "AR/VC customizations")
    public String A0U;
    public ByteBuffer A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public int[] A0f;
    public final C02284v A0g;
    public final C02284v A0h;
    public final C02284v A0i;
    public final C02284v A0j;
    public final C02284v A0k;
    public final C02284v A0l;
    public final C02284v A0m;
    public final C02284v A0n;
    public final C02284v A0o;
    public final C02284v A0p;
    public final InterfaceC0562Il A0q;
    public final C0567Iq A0r;
    public final boolean A0s;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020d A[PHI: r0
      0x020d: PHI (r0v193 byte[]) = (r0v192 byte[]), (r0v208 byte[]) binds: [B:63:0x0209, B:37:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0320  */
    @RequiresNonNull({"#2.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A02(InterfaceC1772ms interfaceC1772ms, C0565Io c0565Io, int i, boolean z) throws IOException {
        String[] strArr;
        byte[] bArrA0l;
        if (A06(1012, 11, 56).equals(c0565Io.A0d)) {
            A0F(interfaceC1772ms, A10, i);
            return A00();
        }
        String[] strArr2 = A0u;
        if (strArr2[5].length() != strArr2[6].length()) {
            A0u[3] = "Q42iXR6evmRi7JQ7PxfR7toxYIITwFkY";
            if (A06(1002, 10, 101).equals(c0565Io.A0d)) {
                A0F(interfaceC1772ms, A0z, i);
                return A00();
            }
            if (A06(1023, 13, 32).equals(c0565Io.A0d)) {
                A0F(interfaceC1772ms, A11, i);
                return A00();
            }
            InterfaceC0528Hd interfaceC0528Hd = c0565Io.A0b;
            if (this.A0Y) {
                int iA0A = i + this.A0k.A0A();
                if (A06(1207, 15, 14).equals(c0565Io.A0d)) {
                    String[] strArr3 = A0u;
                    if (strArr3[2].length() != strArr3[4].length()) {
                        A0u[3] = "azLjDRwnDORtAkbJr5UmBWWcvu9WrjdT";
                        if (A06(1236, 16, 47).equals(c0565Io.A0d)) {
                            byte[] bArrA0l2 = this.A0i.A0l();
                            bArrA0l2[0] = 0;
                            bArrA0l2[1] = 0;
                            bArrA0l2[2] = 0;
                            int i2 = c0565Io.A0Q;
                            int i3 = 4 - c0565Io.A0Q;
                            while (this.A08 < iA0A) {
                                if (this.A0A == 0) {
                                    A0G(interfaceC1772ms, bArrA0l2, i3, i2);
                                    this.A08 += i2;
                                    this.A0i.A0f(0);
                                    this.A0A = this.A0i.A0L();
                                    this.A0j.A0f(0);
                                    interfaceC0528Hd.AIr(this.A0j, 4);
                                    String[] strArr4 = A0u;
                                    if (strArr4[1].charAt(1) != strArr4[0].charAt(1)) {
                                        String[] strArr5 = A0u;
                                        strArr5[5] = "fro1mi6zSK";
                                        strArr5[6] = "qDDF1oBUoQgRey5lTLsLsLE8f";
                                        this.A09 += 4;
                                    } else {
                                        A0u[7] = "9yo0tJuahVLQaubMcBBhp2wjVELgngje";
                                        this.A09 += 4;
                                    }
                                } else {
                                    int iA01 = A01(interfaceC1772ms, interfaceC0528Hd, this.A0A);
                                    this.A08 += iA01;
                                    this.A09 += iA01;
                                    this.A0A -= iA01;
                                }
                            }
                        } else {
                            if (c0565Io.A0c != null) {
                                AbstractC02053y.A08(this.A0k.A0A() == 0);
                                c0565Io.A0c.A03(interfaceC1772ms);
                            }
                            while (this.A08 < iA0A) {
                                int iA012 = A01(interfaceC1772ms, interfaceC0528Hd, iA0A - this.A08);
                                this.A08 += iA012;
                                this.A09 += iA012;
                            }
                        }
                    }
                }
                String strA06 = A06(271, 8, 117);
                String str = c0565Io.A0d;
                strArr = A0u;
                if (strArr[1].charAt(1) == strArr[0].charAt(1)) {
                    A0u[3] = "L5Y1ZRMfFWOxp58RZlemSr0Ie3cKRoNn";
                    if (strA06.equals(str)) {
                        this.A0p.A0f(0);
                        interfaceC0528Hd.AIr(this.A0p, 4);
                        this.A09 += 4;
                    }
                } else {
                    String[] strArr6 = A0u;
                    strArr6[2] = "6h0vzYYIjFmBqGs";
                    strArr6[4] = "2CBNjdNTCI84kXMqqr";
                    if (strA06.equals(str)) {
                    }
                }
                return A00();
            }
            if (c0565Io.A0i) {
                this.A02 &= -1073741825;
                int i4 = 128;
                if (!this.A0b) {
                    interfaceC1772ms.readFully(this.A0l.A0l(), 0, 1);
                    this.A08++;
                    if ((this.A0l.A0l()[0] & 128) == 128) {
                        throw C3K.A01(A06(694, 35, 14), null);
                    }
                    this.A00 = this.A0l.A0l()[0];
                    this.A0b = true;
                }
                if ((this.A00 & 1) == 1) {
                    boolean z2 = (this.A00 & 2) == 2;
                    this.A02 |= 1073741824;
                    if (!this.A0Z) {
                        byte[] bArrA0l3 = this.A0g.A0l();
                        String[] strArr7 = A0u;
                        if (strArr7[1].charAt(1) != strArr7[0].charAt(1)) {
                            String[] strArr8 = A0u;
                            strArr8[5] = "0YZVfaON5K";
                            strArr8[6] = "Vpm73VVBoM5AMHA6BL8GPMDLM";
                            interfaceC1772ms.readFully(bArrA0l3, 0, 8);
                            this.A08 += 8;
                            this.A0Z = true;
                            bArrA0l = this.A0l.A0l();
                            if (!z2) {
                                i4 = 0;
                            }
                            bArrA0l[0] = (byte) (i4 | 8);
                            this.A0l.A0f(0);
                            interfaceC0528Hd.AIs(this.A0l, 1, 1);
                            this.A09++;
                            this.A0g.A0f(0);
                            interfaceC0528Hd.AIs(this.A0g, 8, 1);
                            this.A09 += 8;
                        } else {
                            interfaceC1772ms.readFully(bArrA0l3, 0, 8);
                            this.A08 += 8;
                            this.A0Z = true;
                            bArrA0l = this.A0l.A0l();
                            if (!z2) {
                            }
                            bArrA0l[0] = (byte) (i4 | 8);
                            this.A0l.A0f(0);
                            interfaceC0528Hd.AIs(this.A0l, 1, 1);
                            this.A09++;
                            this.A0g.A0f(0);
                            interfaceC0528Hd.AIs(this.A0g, 8, 1);
                            this.A09 += 8;
                        }
                    }
                    if (z2) {
                        boolean z3 = this.A0a;
                        String[] strArr9 = A0u;
                        if (strArr9[5].length() == strArr9[6].length()) {
                            throw new RuntimeException();
                        }
                        A0u[3] = "IbloDRbaqkSTIb2EEG1BJ7I1x09YBoFC";
                        if (!z3) {
                            interfaceC1772ms.readFully(this.A0l.A0l(), 0, 1);
                            this.A08++;
                            this.A0l.A0f(0);
                            this.A0B = this.A0l.A0I();
                            this.A0a = true;
                        }
                        int i5 = this.A0B * 4;
                        this.A0l.A0d(i5);
                        interfaceC1772ms.readFully(this.A0l.A0l(), 0, i5);
                        this.A08 += i5;
                        short s = (short) ((this.A0B / 2) + 1);
                        int i6 = (s * 6) + 2;
                        if (this.A0V == null || this.A0V.capacity() < i6) {
                            this.A0V = ByteBuffer.allocate(i6);
                        }
                        this.A0V.position(0);
                        this.A0V.putShort(s);
                        int iA0L = 0;
                        for (int i7 = 0; i7 < this.A0B; i7++) {
                            int i8 = iA0L;
                            iA0L = this.A0l.A0L();
                            if (i7 % 2 != 0) {
                                ByteBuffer byteBuffer = this.A0V;
                                String[] strArr10 = A0u;
                                if (strArr10[2].length() == strArr10[4].length()) {
                                    break;
                                }
                                String[] strArr11 = A0u;
                                strArr11[2] = "aiG4mSAFtmR28a0";
                                strArr11[4] = "af0fkPAZLGHpLmON09";
                                byteBuffer.putInt(iA0L - i8);
                            } else {
                                ByteBuffer byteBuffer2 = this.A0V;
                                short s2 = (short) (iA0L - i8);
                                String[] strArr12 = A0u;
                                if (strArr12[5].length() == strArr12[6].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr13 = A0u;
                                strArr13[5] = "ft008TAv7G";
                                strArr13[6] = "haHnc3qulCtaE6iMk670OeuEn";
                                byteBuffer2.putShort(s2);
                            }
                        }
                        int i9 = (i - this.A08) - iA0L;
                        if (this.A0B % 2 == 1) {
                            this.A0V.putInt(i9);
                        } else {
                            this.A0V.putShort((short) i9);
                            this.A0V.putInt(0);
                        }
                        this.A0h.A0j(this.A0V.array(), i6);
                        interfaceC0528Hd.AIs(this.A0h, i6, 1);
                        this.A09 += i6;
                    }
                }
            } else if (c0565Io.A0m != null) {
                this.A0k.A0j(c0565Io.A0m, c0565Io.A0m.length);
            }
            if (c0565Io.A0B(z)) {
                this.A02 |= ClientDefaults.MAX_MSG_SIZE;
                this.A0o.A0d(0);
                int iA0A2 = (this.A0k.A0A() + i) - this.A08;
                this.A0l.A0d(4);
                this.A0l.A0l()[0] = (byte) ((iA0A2 >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
                this.A0l.A0l()[1] = (byte) ((iA0A2 >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
                this.A0l.A0l()[2] = (byte) ((iA0A2 >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
                this.A0l.A0l()[3] = (byte) (iA0A2 & PHIpAddressSearchManager.END_IP_SCAN);
                interfaceC0528Hd.AIs(this.A0l, 4, 2);
                this.A09 += 4;
            }
            this.A0Y = true;
            int iA0A3 = i + this.A0k.A0A();
            if (A06(1207, 15, 14).equals(c0565Io.A0d)) {
            }
            String strA062 = A06(271, 8, 117);
            String str2 = c0565Io.A0d;
            strArr = A0u;
            if (strArr[1].charAt(1) == strArr[0].charAt(1)) {
            }
            return A00();
        }
        throw new RuntimeException();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0t, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0t = new byte[]{90, 23, 15, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 90, 24, 31, 90, 19, 20, 90, 27, 90, 57, 15, 31, 9, 96, 45, 53, 51, 52, 96, 34, 37, 96, 41, 46, 96, 33, 96, 20, 50, 33, 35, 43, 5, 46, 52, 50, 57, 19, 93, 92, 71, 19, 64, 70, 67, 67, 92, 65, 71, 86, 87, 111, 122, 123, 46, 112, 111, 122, 120, 46, 112, 111, 122, 120, 46, 112, 111, 122, 120, 46, 22, 3, 1, 87, 9, 22, 3, 1, 87, 9, 22, 3, 1, 87, 31, 22, 3, 0, 87, 19, 6, 4, 82, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 19, 6, 4, 82, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 19, 6, 4, 82, 24, 19, 6, 5, 82, 0, 4, 18, 18, 36, 53, 53, 40, 47, 38, 50, 2, 40, 49, 41, 36, 51, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 46, 37, 36, 97, 94, 64, 94, 94, 92, 23, 9, 23, 21, 101, 58, 36, 63, 47, 40, 58, 36, 63, 47, 40, 84, 62, 35, 43, 41, 62, 40, 40, 80, 78, 85, 69, 66, 62, 93, 94, 66, 66, 93, 84, 66, 66, 120, 102, 124, 120, 122, 10, 110, 112, 105, 99, 110, 108, 33, 63, 45, 48, 37, 39, 79, 44, 82, 2, 28, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 6, 4, 108, 15, 112, 33, 63, 45, 51, 79, 33, 35, 45, 31, 1, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 82, 76, 67, 80, 94, 60, 85, 95, 92, 82, 71, 60, 90, 86, 86, 86, 82, 76, 67, 80, 94, 60, 90, 93, 71, 60, 81, 90, 84, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 29, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 0, 98, 4, 3, 25, 98, 1, 4, 25, 116, 106, 97, 103, 96, 112, 125, 113, 56, 38, 47, 54, 43, 59, 48, 42, 105, 75, 68, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 94, 10, 89, 73, 75, 70, 79, 10, 94, 67, 71, 79, 73, 69, 78, 79, 10, 90, 88, 67, 69, 88, 10, 94, 69, 10, 94, 67, 71, 79, 73, 69, 78, 79, 121, 73, 75, 70, 79, 10, 72, 79, 67, 68, 77, 10, 89, 79, 94, 4, 5, 41, 34, 35, 37, 15, 34, 102, 47, 53, 102, 43, 47, 53, 53, 47, 40, 33, 102, 47, 40, 102, 18, 52, 39, 37, 45, 3, 40, 50, 52, 63, 102, 35, 42, 35, 43, 35, 40, 50, 117, 89, 91, 84, 95, 88, 95, 88, 81, 22, 83, 88, 85, 68, 79, 70, 66, 95, 89, 88, 22, 87, 88, 82, 22, 85, 89, 91, 70, 68, 83, 69, 69, 95, 89, 88, 22, 95, 69, 22, 88, 89, 66, 22, 69, 67, 70, 70, 89, 68, 66, 83, 82, 86, 122, 123, 97, 112, 123, 97, 86, 122, 120, 101, 84, 121, 114, 122, 53, 107, 71, 70, 92, 77, 70, 92, 109, 70, 75, 105, 68, 79, 71, 8, 82, 126, 127, 101, 116, 127, 101, 84, 127, 114, 126, 117, 120, 127, 118, 94, 99, 117, 116, 99, 49, 95, 115, 114, 104, 121, 114, 104, 89, 114, 127, 115, 120, 117, 114, 123, 79, 127, 115, 108, 121, 60, 110, 67, 89, 73, 75, 88, 78, 67, 68, 77, 10, 70, 75, 89, 94, 10, 73, 95, 79, 10, 90, 69, 67, 68, 94, 10, 93, 67, 94, 66, 10, 95, 68, 79, 82, 90, 79, 73, 94, 79, 78, 10, 78, 95, 88, 75, 94, 67, 69, 68, 16, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 38, 42, 29, 48, 57, 44, 105, 83, 120, 116, 67, 110, 103, 114, 69, 114, 118, 115, 65, 114, 101, 100, 126, 120, 121, 55, 71, 64, 79, 78, 34, 110, 99, 97, 107, 108, 101, 34, 113, 99, 111, 114, 110, 103, 34, 113, 107, 120, 103, 34, 109, 119, 118, 34, 109, 100, 34, 112, 99, 108, 101, 103, 44, 51, 52, 59, 58, 36, 19, 23, 18, 32, 19, 4, 5, 31, 25, 24, 86, 1, 40, 33, 41, 33, 42, 48, 100, 119, 92, 81, 64, 75, 66, 70, 87, 86, 18, 102, 64, 83, 81, 89, 18, 84, 93, 71, 92, 86, 18, 80, 71, 70, 18, 113, 93, 92, 70, 87, 92, 70, 119, 92, 81, 121, 87, 75, 123, 118, 18, 69, 83, 65, 18, 92, 93, 70, 18, 84, 93, 71, 92, 86, 71, 122, 118, 103, 108, 113, 107, 109, 108, 34, 96, 107, 118, 34, 107, 113, 34, 113, 103, 118, 34, 107, 108, 34, 113, 107, 101, 108, 99, 110, 34, 96, 123, 118, 103, 108, 69, 88, 71, 75, 94, 16, 10, 121, 94, 75, 88, 94, 6, 10, 111, 68, 78, 6, 10, 120, 79, 75, 78, 101, 88, 78, 79, 88, 6, 10, 102, 75, 83, 79, 88, 6, 10, 121, 94, 83, 70, 79, 6, 10, 100, 75, 71, 79, 6, 10, 103, 75, 88, 77, 67, 68, 102, 6, 10, 103, 75, 88, 77, 67, 68, 120, 6, 10, 103, 75, 88, 77, 67, 68, 124, 6, 10, 111, 76, 76, 79, 73, 94, 6, 10, 126, 79, 82, 94, 56, 20, 27, 17, 20, 1, 26, 7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 85, 16, 25, 16, 24, 16, 27, 1, 85, 38, 16, 16, 30, 60, 49, 85, 26, 7, 85, 38, 16, 16, 30, 37, 26, 6, 28, 1, 28, 26, 27, 85, 27, 26, 1, 85, 19, 26, 0, 27, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 55, 49, 44, 48, 40, 34, 6, 59, 55, 49, 34, 32, 55, 44, 49, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 23, 15, 18, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 23, 30, 91, 40, 30, 28, 22, 30, 21, 15, 91, 30, 23, 30, 22, 30, 21, 15, 8, 91, 21, 20, 15, 91, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20, 9, 15, 30, 31, 32, 1, 78, 24, 15, 2, 7, 10, 78, 26, 28, 15, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 5, 29, 78, 25, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 78, 8, 1, 27, 0, 10, 91, 122, 53, 99, 116, 121, 124, 113, 53, 99, 116, 103, 124, 123, 97, 53, 121, 112, 123, 114, 97, 125, 53, 120, 116, 102, 126, 53, 115, 122, 96, 123, 113, 61, 49, 42, 56, 44, 61, 59, 44, 105, 101, 114, 126, 119, 108, 21, 106, 
        125, 105, 58, 54, 61, 44, 49, 61, 70, 40, 58, 58, 103, 107, 96, 113, 108, 96, 27, 97, 96, 114, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 127, 115, 120, 105, 116, 120, 3, 123, 105, 110, 122, 120, 120, 65, 77, 68, 93, 80, 65, 71, 80, 35, 27, 25, 0, 0, 25, 30, 23, 80, 3, 5, 18, 4, 25, 4, 28, 21, 80, 3, 17, 29, 0, 28, 21, 80, 25, 30, 80, 28, 17, 19, 21, 20, 80, 18, 28, 31, 19, 27, 94, 64, 120, 122, 99, 99, 122, 125, 116, 51, 96, 102, 113, 103, 122, 103, 127, 118, 51, 96, 114, 126, 99, 127, 118, 51, 100, 122, 103, 123, 51, 125, 124, 51, 119, 102, 97, 114, 103, 122, 124, 125, 61, 81, 106, 97, 124, 116, 97, 103, 112, 97, 96, 36, 109, 96, 62, 36, 9, 50, 57, 36, 44, 57, 63, 40, 57, 56, 124, 48, 61, 63, 53, 50, 59, 124, 42, 61, 48, 41, 57, 102, 124, 45, 36, 58, 45, 74, 62, 55, 37, 56, 45, 47, 90, 122, 115, 97, 124, 105, 107, 24, 3, 101, 127, 99, 3, 109, 124, 102, 111, 125, 96, 117, 119, 4, 31, 121, 99, 127, 31, 113, 99, 96, 84, 93, 79, 82, 71, 69, 54, 45, 75, 81, 77, 45, 67, 84, 65, 60, 53, 39, 58, 47, 45, 94, 69, 35, 57, 37, 69, 57, 58, 117, 124, 110, 115, 102, 100, 107, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 106, 112, 108, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 107, 102, 117, 96, 76, 69, 87, 73, 53, 76, 92, 77, 53, 92, 85, 79, 72, 89, 89, 69, 76, 71, 91, 86, 92, 65, 82, 18, 27, 18, 20, 124, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2, 4, 109, 79, 83, 68, 120, 81, 78, 67, 66, 72, 120, 85, 72, 83, 102, 10, 23, 23, 23, 52, 40, 63, 3, 42, 53, 56, 57, 51, 3, 46, 51, 40, 29, 113, 108, 101, 108, 56, 36, 51, 15, 38, 57, 52, 53, 63, 15, 34, 63, 36, 17, 125, 97, 104, 96, 93, 65, 86, 106, 67, 92, 81, 80, 90, 106, 71, 90, 65, 116, 24, 7, 2, 5, 34, 46, 59, 61, 32, 60, 36, 46, 56, 39, 42, 43, 33, 97, 57, 43, 44, 35, 21, 7, 0, 15};
    }

    static {
        A0B();
        A0v = new HD() { // from class: com.facebook.ads.redexgen.X.mL
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return MatroskaExtractor.A0Q();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A10 = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        A0y = C5C.A1G(A06(729, 90, 38));
        A0z = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        A11 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        A0x = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put(A06(1285, 18, 43), 0);
        map.put(A06(1303, 18, 80), 90);
        map.put(A06(1321, 18, 92), 180);
        map.put(A06(1339, 18, 57), 270);
        Map<String, Integer> trackNameToRotationDegrees = Collections.unmodifiableMap(map);
        A0w = trackNameToRotationDegrees;
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i) {
        this(new C1751mM(), i);
    }

    public MatroskaExtractor(InterfaceC0562Il interfaceC0562Il, int i) {
        this.A0M = -1L;
        this.A0O = -9223372036854775807L;
        this.A0I = -9223372036854775807L;
        this.A0J = -9223372036854775807L;
        this.A0H = -1L;
        this.A0L = -1L;
        this.A0G = -9223372036854775807L;
        this.A0q = interfaceC0562Il;
        this.A0q.AAD(new C1749mK(this));
        this.A0s = (i & 1) == 0;
        this.A0r = new C0567Iq();
        this.A0P = new SparseArray<>();
        this.A0l = new C02284v(4);
        this.A0p = new C02284v(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0m = new C02284v(4);
        this.A0j = new C02284v(HS.A03);
        this.A0i = new C02284v(4);
        this.A0k = new C02284v();
        this.A0n = new C02284v();
        this.A0g = new C02284v(8);
        this.A0h = new C02284v();
        this.A0o = new C02284v();
        this.A0f = new int[1];
    }

    private int A00() {
        int sampleSize = this.A09;
        A0A();
        return sampleSize;
    }

    private int A01(InterfaceC1772ms interfaceC1772ms, InterfaceC0528Hd interfaceC0528Hd, int i) throws IOException {
        int strippedBytesLeft = this.A0k.A07();
        if (strippedBytesLeft > 0) {
            int bytesWritten = Math.min(i, strippedBytesLeft);
            interfaceC0528Hd.AIr(this.A0k, bytesWritten);
            return bytesWritten;
        }
        return interfaceC0528Hd.AIp(interfaceC1772ms, i, false);
    }

    private long A03(long j) throws C3K {
        if (this.A0O != -9223372036854775807L) {
            return C5C.A0U(j, this.A0O, 1000L);
        }
        throw C3K.A01(A06(279, 54, 38), null);
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0053 */
    @MetaExoPlayerCustomization("Adding support AR/VR eventListener")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HY A04(C02144h c02144h, C02144h c02144h2) {
        if (this.A0M == -1 || this.A0J == -9223372036854775807L || c02144h == null || c02144h.A02() == 0 || c02144h2 == null || c02144h2.A02() != c02144h.A02()) {
            return new C1767mn(this.A0J);
        }
        int iA02 = c02144h.A02();
        int[] iArrCopyOf = new int[iA02];
        long[] timesUs = new long[iA02];
        long[] durationsUs = new long[iA02];
        long[] offsets = new long[iA02];
        for (int i = 0; i < iA02; i++) {
            offsets[i] = c02144h.A03(i);
            timesUs[i] = this.A0M + c02144h2.A03(i);
        }
        for (int i2 = 0; i2 < cuePointsSize; i2++) {
            int cuePointsSize = i2 + 1;
            iArrCopyOf[i2] = (int) (timesUs[cuePointsSize] - timesUs[i2]);
            int i3 = i2 + 1;
            if (A0u[7].length() == 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0u;
            strArr[1] = "EcqUdVdOszDxTX1GLg4Sg6FEnSFxXYEO";
            strArr[0] = "f3IXvdxpqPdXnJQYi44axyFnZVKpD9LT";
            durationsUs[i2] = offsets[i3] - offsets[i2];
        }
        iArrCopyOf[iA02 - 1] = (int) ((this.A0M + this.A0N) - timesUs[iA02 - 1]);
        durationsUs[iA02 - 1] = this.A0J - offsets[iA02 - 1];
        int cuePointsSize2 = iA02 - 1;
        long j = durationsUs[cuePointsSize2];
        if (j <= 0) {
            AbstractC02134g.A07(A06(869, 17, 79), A06(499, 52, 38) + j);
            int cuePointsSize3 = iArrCopyOf.length;
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, cuePointsSize3 - 1);
            int cuePointsSize4 = timesUs.length;
            timesUs = Arrays.copyOf(timesUs, cuePointsSize4 - 1);
            int cuePointsSize5 = durationsUs.length;
            durationsUs = Arrays.copyOf(durationsUs, cuePointsSize5 - 1);
            int cuePointsSize6 = offsets.length;
            offsets = Arrays.copyOf(offsets, cuePointsSize6 - 1);
        }
        return new C1777my(iArrCopyOf, timesUs, durationsUs, offsets);
    }

    private final C0565Io A05(int i) throws C3K {
        A0D(i);
        return this.A0T;
    }

    @EnsuresNonNull({"extractorOutput"})
    private void A09() {
        AbstractC02053y.A02(this.A0S);
    }

    private void A0A() {
        this.A08 = 0;
        this.A09 = 0;
        this.A0A = 0;
        this.A0Y = false;
        this.A0b = false;
        this.A0a = false;
        this.A0B = 0;
        this.A00 = (byte) 0;
        this.A0Z = false;
        this.A0k.A0d(0);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void A0C(int i) throws C3K {
        if (this.A0R != null && this.A0Q != null) {
        } else {
            throw C3K.A01(A06(631, 8, 72) + i + A06(0, 18, 118), null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void A0D(int i) throws C3K {
        if (this.A0T != null) {
        } else {
            throw C3K.A01(A06(631, 8, 72) + i + A06(18, 24, 76), null);
        }
    }

    private void A0E(InterfaceC1772ms interfaceC1772ms, int i) throws IOException {
        if (this.A0l.A0A() >= i) {
            return;
        }
        if (this.A0l.A08() < i) {
            this.A0l.A0c(Math.max(this.A0l.A08() * 2, i));
        }
        interfaceC1772ms.readFully(this.A0l.A0l(), this.A0l.A0A(), i - this.A0l.A0A());
        this.A0l.A0e(i);
    }

    private void A0F(InterfaceC1772ms interfaceC1772ms, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        int sizeWithPrefix = this.A0n.A08();
        if (sizeWithPrefix < length) {
            int sizeWithPrefix2 = length + i;
            this.A0n.A0i(Arrays.copyOf(bArr, sizeWithPrefix2));
        } else {
            byte[] bArrA0l = this.A0n.A0l();
            int sizeWithPrefix3 = bArr.length;
            System.arraycopy(bArr, 0, bArrA0l, 0, sizeWithPrefix3);
        }
        byte[] bArrA0l2 = this.A0n.A0l();
        int sizeWithPrefix4 = bArr.length;
        interfaceC1772ms.readFully(bArrA0l2, sizeWithPrefix4, i);
        this.A0n.A0f(0);
        this.A0n.A0e(length);
    }

    private void A0G(InterfaceC1772ms interfaceC1772ms, byte[] bArr, int i, int i2) throws IOException {
        int iMin = Math.min(i2, this.A0k.A07());
        int pendingStrippedBytes = i + iMin;
        interfaceC1772ms.readFully(bArr, pendingStrippedBytes, i2 - iMin);
        if (iMin > 0) {
            this.A0k.A0k(bArr, i, iMin);
        }
    }

    private final void A0H(C0565Io c0565Io, int i, InterfaceC1772ms interfaceC1772ms, int i2) throws IOException {
        if (i == 4) {
            if (A06(1280, 5, 88).equals(c0565Io.A0d)) {
                this.A0o.A0d(i2);
                interfaceC1772ms.readFully(this.A0o.A0l(), 0, i2);
                return;
            }
        }
        interfaceC1772ms.AK3(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    @RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0I(C0565Io c0565Io, long j, int i, int i2, int i3) {
        int iA0A = i2;
        if (c0565Io.A0c != null) {
            c0565Io.A0c.A04(c0565Io.A0b, j, i, iA0A, i3, c0565Io.A0a);
        } else if (!A06(1012, 11, 56).equals(c0565Io.A0d)) {
            boolean zEquals = A06(1002, 10, 101).equals(c0565Io.A0d);
            if (A0u[7].length() == 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0u;
            strArr[2] = "WUIRLQPYspP06jV";
            strArr[4] = "IKED97K2catgdGs9C7";
            if (!zEquals) {
                if (A06(1023, 13, 32).equals(c0565Io.A0d)) {
                    int i4 = this.A03;
                    String strA06 = A06(869, 17, 79);
                    if (i4 > 1) {
                        AbstractC02134g.A07(strA06, A06(1044, 40, 124));
                    } else if (this.A0D == -9223372036854775807L) {
                        AbstractC02134g.A07(strA06, A06(1084, 42, 31));
                    } else {
                        A0K(c0565Io.A0d, this.A0D, this.A0n.A0l());
                        int iA09 = this.A0n.A09();
                        while (true) {
                            if (iA09 >= this.A0n.A0A()) {
                                break;
                            }
                            if (this.A0n.A0l()[iA09] == 0) {
                                this.A0n.A0e(iA09);
                                break;
                            }
                            iA09++;
                        }
                        c0565Io.A0b.AIr(this.A0n, this.A0n.A0A());
                        iA0A += this.A0n.A0A();
                    }
                }
                if ((268435456 & i) != 0) {
                    if (this.A03 > 1) {
                        C02284v c02284v = this.A0o;
                        String[] strArr2 = A0u;
                        if (strArr2[5].length() != strArr2[6].length()) {
                            String[] strArr3 = A0u;
                            strArr3[1] = "YYsRZc3YFjjR6whUDZFnD2lR7qwR3xQu";
                            strArr3[0] = "iPCTe70V3RVZDGWrxpNWfBz9u5oW1N1r";
                            c02284v.A0d(0);
                        } else {
                            A0u[3] = "dzMIMRhm8kdQoNm85GuPxt1OFbbjzRAM";
                            c02284v.A0d(0);
                        }
                    } else {
                        int iA0A2 = this.A0o.A0A();
                        c0565Io.A0b.AIs(this.A0o, iA0A2, 2);
                        iA0A += iA0A2;
                    }
                }
                InterfaceC0528Hd interfaceC0528Hd = c0565Io.A0b;
                C0526Hb c0526Hb = c0565Io.A0a;
                String[] strArr4 = A0u;
                if (strArr4[5].length() != strArr4[6].length()) {
                    String[] strArr5 = A0u;
                    strArr5[1] = "aEC8Q2NERZhQKbY6SRlQy9B7oXJI5nDv";
                    strArr5[0] = "M5BYDTb0V4PW6b5ziiSZklpOYuXfea8a";
                    interfaceC0528Hd.AIu(j, i, iA0A, i3, c0526Hb);
                } else {
                    interfaceC0528Hd.AIu(j, i, iA0A, i3, c0526Hb);
                }
            }
        }
        this.A0X = true;
    }

    private final void A0J(C0565Io c0565Io, InterfaceC1772ms interfaceC1772ms, int i) throws IOException {
        if (c0565Io.A0n != 1685485123) {
            int i2 = c0565Io.A0n;
            String[] strArr = A0u;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0u;
            strArr2[2] = "z7J25JPdzWy80Kd";
            strArr2[4] = "xEqpvZ1X3IvVWW9v69";
            if (i2 != 1685480259) {
                interfaceC1772ms.AK3(i);
                return;
            }
        }
        c0565Io.A0k = new byte[i];
        interfaceC1772ms.readFully(c0565Io.A0k, 0, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0K(String str, long j, byte[] bArr) {
        byte b;
        String[] strArr;
        byte[] bArrA0O;
        int i;
        switch (str.hashCode()) {
            case 738597099:
                b = str.equals(A06(1002, 10, 101)) ? (byte) 1 : (byte) -1;
                strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    String[] strArr2 = A0u;
                    strArr2[1] = "3I7Szd6Jo4OcbWqNbOfUGxKnAqqsYD1t";
                    strArr2[0] = "pL7tYzN7WsijDsV9dRV4eebVOXyQpiyb";
                    switch (b) {
                        case 0:
                            bArrA0O = A0O(j, A06(75, 19, 63), 1000L);
                            i = 19;
                            break;
                        case 1:
                            bArrA0O = A0O(j, A06(56, 19, 70), 10000L);
                            i = 21;
                            break;
                        case 2:
                            bArrA0O = A0O(j, A06(94, 19, 58), 1000L);
                            i = 25;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    System.arraycopy(bArrA0O, 0, bArr, i, bArrA0O.length);
                    return;
                }
                throw new RuntimeException();
            case 1045209816:
                String[] strArr3 = A0u;
                if (strArr3[1].charAt(1) != strArr3[0].charAt(1)) {
                    String[] strArr4 = A0u;
                    strArr4[5] = "hOu1CB2frr";
                    strArr4[6] = "vZrPTqET3LPV3435yPIFppSrF";
                    if (str.equals(A06(1023, 13, 32))) {
                        b = 2;
                    }
                    strArr = A0u;
                    if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    }
                }
                throw new RuntimeException();
            case 1422270023:
                if (str.equals(A06(1012, 11, 56))) {
                    b = 0;
                }
                strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                }
                throw new RuntimeException();
        }
    }

    private boolean A0L(HV hv, long j) {
        if (this.A0c) {
            this.A0L = j;
            hv.A00 = this.A0H;
            this.A0c = false;
            return true;
        }
        if (!this.A0e || this.A0L == -1) {
            return false;
        }
        hv.A00 = this.A0L;
        this.A0L = -1L;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x032d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[RETURN] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0M(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0M(java.lang.String):boolean");
    }

    public static byte[] A0O(long j, String str, long j2) {
        AbstractC02053y.A07(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((((long) i) * 3600) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((((long) i2) * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        int minutes = (int) ((j4 - (((long) i3) * 1000000)) / j2);
        return C5C.A1G(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minutes)));
    }

    public static int[] A0P(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    public static /* synthetic */ H9[] A0Q() {
        return new H9[]{new MatroskaExtractor()};
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "Adding support for AR/VR TAGs")
    public final int A0R(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 26568:
            case 28032:
            case 29555:
            case 30113:
            case 30320:
            case 290298740:
            case 307544935:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                String[] strArr = A0u;
                if (strArr[2].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0u;
                strArr2[1] = "HyhNlEIHHjvGo8KvAMWihGCcOuKz7U7o";
                strArr2[0] = "rV4cPIzb4RrvL4U1RF1zVSCUyrwoic3K";
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            case 17543:
            case 17827:
                return 6;
            default:
                return 0;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:62:0x017e */
    /* JADX WARN: Incorrect condition in loop: B:66:0x018b */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0S(int i) throws C3K {
        A09();
        switch (i) {
            case 160:
                if (this.A05 == 2) {
                    C0565Io c0565Io = this.A0P.get(this.A06);
                    c0565Io.A06();
                    if (this.A0E > 0 && A06(215, 6, 82).equals(c0565Io.A0d)) {
                        this.A0o.A0i(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.A0E).array());
                    }
                    int sampleFlags = 0;
                    if (A0u[7].length() != 16) {
                        String[] strArr = A0u;
                        strArr[5] = "BDPY36VwNm";
                        strArr[6] = "7hC1KMOm7DpnqonjeX0jtoaYt";
                        for (int sampleOffset = 0; sampleOffset < i; sampleOffset++) {
                            int i2 = this.A0f[sampleOffset];
                            sampleFlags += i2;
                            break;
                        }
                        for (int i3 = 0; i3 < sampleOffset; i3++) {
                            long j = this.A0F;
                            int sampleOffset2 = c0565Io.A0I;
                            long j2 = j + ((long) ((sampleOffset2 * i3) / 1000));
                            int i4 = this.A02;
                            if (i3 == 0 && !this.A0W) {
                                i4 |= 1;
                            }
                            int i5 = this.A0f[i3];
                            sampleFlags -= i5;
                            A0I(c0565Io, j2, i4, i5, sampleFlags);
                            break;
                        }
                        this.A05 = 0;
                        return;
                    }
                    throw new RuntimeException();
                }
                return;
            case 174:
                C0565Io c0565Io2 = (C0565Io) AbstractC02053y.A02(this.A0T);
                if (c0565Io2.A0d != null) {
                    if (A0M(c0565Io2.A0d)) {
                        c0565Io2.A0G(this.A0S, c0565Io2.A0R);
                        this.A0P.put(c0565Io2.A0R, c0565Io2);
                    }
                    this.A0T = null;
                    return;
                }
                throw C3K.A01(A06(333, 40, 74), null);
            case 19899:
                int i6 = this.A0C;
                String[] strArr2 = A0u;
                if (strArr2[1].charAt(1) != strArr2[0].charAt(1)) {
                    A0u[7] = "tg6sq0stTi0cIlF7Upi0qsQ5QklGxJF";
                    if (i6 != -1) {
                        if (this.A0K != -1) {
                            if (this.A0C == 475249515) {
                                this.A0H = this.A0K;
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    String[] strArr3 = A0u;
                    strArr3[2] = "yLIpCO5kJmqKflO";
                    strArr3[4] = "mFIbnXIm9TTTynra4E";
                    if (i6 != -1) {
                    }
                }
                throw C3K.A01(A06(819, 50, 121), null);
            case 25152:
                A0D(i);
                if (!this.A0T.A0i) {
                    return;
                }
                if (this.A0T.A0a != null) {
                    this.A0T.A0Z = new DrmInitData(new DrmInitData.SchemeData(C2Y.A03, A06(1365, 10, 66), this.A0T.A0a.A03));
                    return;
                }
                throw C3K.A01(A06(639, 55, 62), null);
            case 28032:
                A0D(i);
                if (!this.A0T.A0i || this.A0T.A0m == null) {
                    return;
                } else {
                    throw C3K.A01(A06(373, 53, 58), null);
                }
            case 357149030:
                long j3 = this.A0O;
                if (A0u[3].charAt(5) != 'R') {
                    throw new RuntimeException();
                }
                A0u[7] = "WZACEI803UG8FVl";
                if (j3 == -9223372036854775807L) {
                    this.A0O = 1000000L;
                }
                if (this.A0I != -9223372036854775807L) {
                    this.A0J = A03(this.A0I);
                    return;
                }
                return;
            case 374648427:
                if (this.A0P.size() != 0) {
                    this.A0S.A6O();
                    return;
                }
                throw C3K.A01(A06(925, 26, 98), null);
            case 475249515:
                if (!this.A0e) {
                    this.A0S.AJ7(A04(this.A0R, this.A0Q));
                    this.A0e = true;
                }
                this.A0R = null;
                this.A0Q = null;
                return;
            default:
                return;
        }
    }

    public final void A0T(int i, double d) throws C3K {
        switch (i) {
            case 181:
                C0565Io c0565IoA05 = A05(i);
                int i2 = (int) d;
                if (A0u[3].charAt(5) != 'R') {
                    throw new RuntimeException();
                }
                A0u[7] = "mnSBpt4UIloiGRhCy1GZQUK3TYQANP";
                c0565IoA05.A0T = i2;
                return;
            case 17545:
                this.A0I = (long) d;
                return;
            case 21969:
                A05(i).A06 = (float) d;
                return;
            case 21970:
                C0565Io c0565IoA052 = A05(i);
                if (A0u[7].length() != 16) {
                    A0u[7] = "bgRhYiIqKVlSmtLlUnVbMuj";
                    c0565IoA052.A07 = (float) d;
                    return;
                } else {
                    c0565IoA052.A07 = (float) d;
                    return;
                }
            case 21971:
                A05(i).A04 = (float) d;
                return;
            case 21972:
                A05(i).A05 = (float) d;
                return;
            case 21973:
                A05(i).A02 = (float) d;
                return;
            case 21974:
                A05(i).A03 = (float) d;
                return;
            case 21975:
                A05(i).A0B = (float) d;
                return;
            case 21976:
                C0565Io c0565IoA053 = A05(i);
                float f = (float) d;
                String[] strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    A0u[7] = "0K";
                    c0565IoA053.A0C = f;
                    return;
                }
                throw new RuntimeException();
            case 21977:
                A05(i).A00 = (float) d;
                return;
            case 21978:
                A05(i).A01 = (float) d;
                return;
            case 30323:
                A05(i).A0A = (float) d;
                return;
            case 30324:
                A05(i).A08 = (float) d;
                return;
            case 30325:
                A05(i).A09 = (float) d;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:48:0x01d2 */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x033a A[LOOP:4: B:89:0x0338->B:90:0x033a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0U(int i, int i2, InterfaceC1772ms interfaceC1772ms) throws IOException {
        int i3;
        int iCharAt;
        int totalSamplesSize;
        int timecode;
        int totalSamplesSize2 = 0;
        int i4 = 1;
        switch (i) {
            case 161:
            case 163:
                if (this.A05 == 0) {
                    this.A06 = (int) this.A0r.A05(interfaceC1772ms, false, true, 8);
                    this.A07 = this.A0r.A04();
                    String[] strArr = A0u;
                    if (strArr[5].length() == strArr[6].length()) {
                        this.A0D = -9223372036854775807L;
                        this.A05 = 1;
                        this.A0l.A0d(0);
                    } else {
                        String[] strArr2 = A0u;
                        strArr2[1] = "LCHoyUIFh4JbWXc3a57uog3rKRFOb5wV";
                        strArr2[0] = "47gJribS0awN4nsHBZkjm7XOEmPrRfLr";
                        this.A0D = -9223372036854775807L;
                        this.A05 = 1;
                        this.A0l.A0d(0);
                    }
                }
                C0565Io c0565Io = this.A0P.get(this.A06);
                if (c0565Io != null) {
                    c0565Io.A06();
                    if (this.A05 == 1) {
                        A0E(interfaceC1772ms, 3);
                        int byteValue = (this.A0l.A0l()[2] & 6) >> 1;
                        int i5 = PHIpAddressSearchManager.END_IP_SCAN;
                        if (byteValue != 0) {
                            A0E(interfaceC1772ms, 4);
                            int timecode2 = this.A0l.A0l()[3];
                            this.A03 = (timecode2 & PHIpAddressSearchManager.END_IP_SCAN) + 1;
                            int[] iArr = this.A0f;
                            int timecode3 = this.A03;
                            this.A0f = A0P(iArr, timecode3);
                            if (byteValue == 2) {
                                int timecode4 = this.A07;
                                int i6 = (i2 - timecode4) - 4;
                                int timecode5 = this.A03;
                                int i7 = i6 / timecode5;
                                int[] iArr2 = this.A0f;
                                int blockLacingSampleSize = this.A03;
                                Arrays.fill(iArr2, 0, blockLacingSampleSize, i7);
                            } else if (byteValue != 1) {
                                if (byteValue == 3) {
                                    int i8 = 0;
                                    int sampleIndex = 4;
                                    int i9 = 0;
                                    while (i9 < this.A03 - i4) {
                                        this.A0f[i9] = totalSamplesSize2;
                                        sampleIndex++;
                                        A0E(interfaceC1772ms, sampleIndex);
                                        C02284v c02284v = this.A0l;
                                        if (A0u[7].length() != 16) {
                                            A0u[7] = "lQQ4f1MYxOwR1g4uON0whOI";
                                            if (c02284v.A0l()[sampleIndex - 1] != 0) {
                                                long j = 0;
                                                int i10 = 0;
                                                while (i10 < 8) {
                                                    int i11 = i4 << (7 - i10);
                                                    C02284v c02284v2 = this.A0l;
                                                    String[] strArr3 = A0u;
                                                    String str = strArr3[1];
                                                    String str2 = strArr3[0];
                                                    int iCharAt2 = str.charAt(1);
                                                    int lengthMask = str2.charAt(1);
                                                    if (iCharAt2 != lengthMask) {
                                                        A0u[3] = "6gmtIRdzQjg9uolj5CgbNQmEFE2eXosQ";
                                                        if ((c02284v2.A0l()[sampleIndex - 1] & i11) != 0) {
                                                            int totalSamplesSize3 = sampleIndex - 1;
                                                            sampleIndex += i10;
                                                            A0E(interfaceC1772ms, sampleIndex);
                                                            i3 = totalSamplesSize3 + 1;
                                                            int totalSamplesSize4 = this.A0l.A0l()[totalSamplesSize3] & i5;
                                                            int lengthMask2 = ~i11;
                                                            j = totalSamplesSize4 & lengthMask2;
                                                            while (i3 < sampleIndex) {
                                                                int readPosition = i3 + 1;
                                                                j = (j << 8) | ((long) (this.A0l.A0l()[i3] & i5));
                                                                i3 = readPosition;
                                                            }
                                                            if (i9 > 0) {
                                                                j -= (1 << ((i10 * 7) + 6)) - 1;
                                                            }
                                                        } else {
                                                            i10++;
                                                            i4 = 1;
                                                        }
                                                    } else if ((c02284v2.A0l()[sampleIndex - 1] & i11) != 0) {
                                                        int totalSamplesSize32 = sampleIndex - 1;
                                                        sampleIndex += i10;
                                                        A0E(interfaceC1772ms, sampleIndex);
                                                        i3 = totalSamplesSize32 + 1;
                                                        int totalSamplesSize42 = this.A0l.A0l()[totalSamplesSize32] & i5;
                                                        int lengthMask22 = ~i11;
                                                        j = totalSamplesSize42 & lengthMask22;
                                                        while (i3 < sampleIndex) {
                                                        }
                                                        if (i9 > 0) {
                                                        }
                                                    } else {
                                                        i10++;
                                                        i4 = 1;
                                                    }
                                                    if (j < -2147483648L && j <= 2147483647L) {
                                                        int i12 = (int) j;
                                                        int[] iArr3 = this.A0f;
                                                        if (i9 != 0) {
                                                            i12 += this.A0f[i9 - 1];
                                                        }
                                                        iArr3[i9] = i12;
                                                        i8 += this.A0f[i9];
                                                        i9++;
                                                        i5 = PHIpAddressSearchManager.END_IP_SCAN;
                                                        totalSamplesSize2 = 0;
                                                        i4 = 1;
                                                    } else {
                                                        throw C3K.A01(A06(578, 37, 14), null);
                                                    }
                                                }
                                                if (j < -2147483648L) {
                                                }
                                                throw C3K.A01(A06(578, 37, 14), null);
                                            }
                                            throw C3K.A01(A06(951, 33, 25), null);
                                        }
                                        break;
                                    }
                                    this.A0f[this.A03 - 1] = ((i2 - this.A07) - sampleIndex) - i8;
                                } else {
                                    throw C3K.A01(A06(1141, 25, 80) + byteValue, null);
                                }
                            } else {
                                int i13 = 0;
                                int i14 = 4;
                                int i15 = 0;
                                while (true) {
                                    int i16 = this.A03;
                                    if (A0u[3].charAt(5) != 'R') {
                                        if (i15 >= i16 - 1) {
                                        }
                                        this.A0f[i15] = 0;
                                        while (true) {
                                            i14++;
                                            A0E(interfaceC1772ms, i14);
                                            byte[] bArrA0l = this.A0l.A0l();
                                            String[] strArr4 = A0u;
                                            String str3 = strArr4[1];
                                            String str4 = strArr4[0];
                                            iCharAt = str3.charAt(1);
                                            totalSamplesSize = str4.charAt(1);
                                            if (iCharAt == totalSamplesSize) {
                                                String[] strArr5 = A0u;
                                                strArr5[1] = "QqySTVYSyUdR3w6zpaSbgPrcegDpRTeR";
                                                strArr5[0] = "gT3bwZtYi7wT97ycLVgitbKLuY9aoVNS";
                                                int totalSamplesSize5 = i14 - 1;
                                                int i17 = bArrA0l[totalSamplesSize5] & 255;
                                                int[] iArr4 = this.A0f;
                                                int totalSamplesSize6 = iArr4[i15];
                                                iArr4[i15] = totalSamplesSize6 + i17;
                                                if (i17 != 255) {
                                                }
                                            } else {
                                                A0u[7] = "opIzPavLvAV6dvwDrp1";
                                                int totalSamplesSize7 = i14 - 1;
                                                int i18 = bArrA0l[totalSamplesSize7] & 255;
                                                int[] iArr5 = this.A0f;
                                                int totalSamplesSize8 = iArr5[i15];
                                                iArr5[i15] = totalSamplesSize8 + i18;
                                                if (i18 != 255) {
                                                }
                                            }
                                            break;
                                        }
                                        int totalSamplesSize9 = this.A0f[i15];
                                        i13 += totalSamplesSize9;
                                        i15++;
                                    } else {
                                        String[] strArr6 = A0u;
                                        strArr6[1] = "uG7prxZBXLM0QG5e8GSw94nYMCP7upCE";
                                        strArr6[0] = "tV31aGArCsXy4K1N5Jjs7nQ9FZDzw28J";
                                        if (i15 >= i16 - 1) {
                                        }
                                        this.A0f[i15] = 0;
                                        while (true) {
                                            i14++;
                                            A0E(interfaceC1772ms, i14);
                                            byte[] bArrA0l2 = this.A0l.A0l();
                                            String[] strArr42 = A0u;
                                            String str32 = strArr42[1];
                                            String str42 = strArr42[0];
                                            iCharAt = str32.charAt(1);
                                            totalSamplesSize = str42.charAt(1);
                                            if (iCharAt == totalSamplesSize) {
                                            }
                                        }
                                        int totalSamplesSize92 = this.A0f[i15];
                                        i13 += totalSamplesSize92;
                                        i15++;
                                    }
                                }
                                int[] iArr6 = this.A0f;
                                int i19 = this.A03 - 1;
                                int totalSamplesSize10 = this.A07;
                                iArr6[i19] = ((i2 - totalSamplesSize10) - i14) - i13;
                            }
                        } else {
                            this.A03 = 1;
                            this.A0f = A0P(this.A0f, 1);
                            this.A0f[0] = (i2 - this.A07) - 3;
                        }
                        int lacing = this.A0l.A0l()[0];
                        this.A0F = this.A0G + A03((lacing << 8) | (this.A0l.A0l()[1] & 255));
                        int timecode6 = c0565Io.A0V;
                        if (timecode6 == 2) {
                            timecode = 1;
                            int timecode7 = timecode != 0 ? 1 : 0;
                            this.A02 = timecode7;
                            this.A05 = 2;
                            this.A04 = 0;
                        } else {
                            if (i == 163) {
                                byte[] bArrA0l3 = this.A0l.A0l();
                                String[] strArr7 = A0u;
                                String str5 = strArr7[1];
                                String str6 = strArr7[0];
                                int iCharAt3 = str5.charAt(1);
                                int timecode8 = str6.charAt(1);
                                if (iCharAt3 != timecode8) {
                                    String[] strArr8 = A0u;
                                    strArr8[1] = "Vc6YaXBr4sE6Z9Kledba3u83scjXoejR";
                                    strArr8[0] = "GPxnjQ5uiYxzVhoi9JJVxDxAifN9s8px";
                                    if ((bArrA0l3[2] & 128) == 128) {
                                    }
                                    if (timecode != 0) {
                                    }
                                    this.A02 = timecode7;
                                    this.A05 = 2;
                                    this.A04 = 0;
                                } else {
                                    throw new RuntimeException();
                                }
                            }
                            timecode = 0;
                            if (timecode != 0) {
                            }
                            this.A02 = timecode7;
                            this.A05 = 2;
                            this.A04 = 0;
                        }
                    }
                    if (i == 163) {
                        while (i < timecode) {
                            int[] iArr7 = this.A0f;
                            int timecode9 = this.A04;
                            int iA02 = A02(interfaceC1772ms, c0565Io, iArr7[timecode9], false);
                            c0565Io = c0565Io;
                            A0I(c0565Io, this.A0F + ((long) ((this.A04 * c0565Io.A0I) / 1000)), this.A02, iA02, 0);
                            this.A04++;
                            break;
                        }
                        this.A05 = 0;
                        return;
                    }
                    while (this.A04 < this.A03) {
                        this.A0f[this.A04] = A02(interfaceC1772ms, c0565Io, this.A0f[this.A04], true);
                        this.A04++;
                    }
                    return;
                }
                interfaceC1772ms.AK3(i2 - this.A07);
                this.A05 = 0;
                return;
            case 165:
                if (this.A05 != 2) {
                    return;
                }
                A0H(this.A0P.get(this.A06), this.A01, interfaceC1772ms, i2);
                return;
            case 16877:
                A0J(A05(i), interfaceC1772ms, i2);
                return;
            case 16981:
                A0D(i);
                this.A0T.A0m = new byte[i2];
                interfaceC1772ms.readFully(this.A0T.A0m, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                interfaceC1772ms.readFully(bArr, 0, i2);
                A05(i).A0a = new C0526Hb(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.A0m.A0l(), (byte) 0);
                interfaceC1772ms.readFully(this.A0m.A0l(), 4 - i2, i2);
                this.A0m.A0f(0);
                this.A0C = (int) this.A0m.A0Q();
                return;
            case 25506:
                A0D(i);
                String[] strArr9 = A0u;
                if (strArr9[1].charAt(1) != strArr9[0].charAt(1)) {
                    A0u[3] = "vSk1rRCvXwYs114cFInjW7yvt4gWKzzv";
                    this.A0T.A0j = new byte[i2];
                    interfaceC1772ms.readFully(this.A0T.A0j, 0, i2);
                    return;
                }
                break;
            case 30322:
                A0D(i);
                this.A0T.A0l = new byte[i2];
                interfaceC1772ms.readFully(this.A0T.A0l, 0, i2);
                return;
            default:
                throw C3K.A01(A06(1126, 15, 8) + i, null);
        }
        throw new RuntimeException();
    }

    public final void A0V(int i, long j) throws C3K {
        String strA06 = A06(42, 14, 63);
        switch (i) {
            case 131:
                A05(i).A0V = (int) j;
                return;
            case 136:
                A05(i).A0f = j == 1;
                return;
            case 155:
                this.A0D = A03(j);
                return;
            case 159:
                A05(i).A0E = (int) j;
                return;
            case 176:
                A05(i).A0W = (int) j;
                return;
            case 179:
                A0C(i);
                this.A0R.A04(A03(j));
                return;
            case 186:
                A05(i).A0M = (int) j;
                return;
            case 215:
                A05(i).A0R = (int) j;
                return;
            case 231:
                this.A0G = A03(j);
                return;
            case 238:
                this.A01 = (int) j;
                return;
            case 241:
                if (this.A0d) {
                    return;
                }
                A0C(i);
                this.A0Q.A04(j);
                this.A0d = true;
                return;
            case 251:
                this.A0W = true;
                return;
            case 16871:
                A05(i).A0n = (int) j;
                return;
            case 16980:
                String[] strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    String[] strArr2 = A0u;
                    strArr2[1] = "siSTSWWHFDsKrirn3iU8fidRJrb4DuSX";
                    strArr2[0] = "o7Su23MSMUKyfq0AiKXYGeUTl03UpruG";
                    if (j == 3) {
                        return;
                    }
                } else {
                    String[] strArr3 = A0u;
                    strArr3[5] = "wDyyIq2mnN";
                    strArr3[6] = "u9jmr3hENDVfo4ybwkpsevoxR";
                    if (j == 3) {
                        return;
                    }
                }
                throw C3K.A01(A06(426, 16, 25) + j + strA06, null);
            case 17029:
                if (j >= 1 && j <= 2) {
                    return;
                } else {
                    throw C3K.A01(A06(559, 19, 27) + j + strA06, null);
                }
            case 17143:
                if (j == 1) {
                    return;
                } else {
                    throw C3K.A01(A06(615, 16, 122) + j + strA06, null);
                }
            case 18401:
                if (j == 5) {
                    return;
                } else {
                    throw C3K.A01(A06(442, 15, 36) + j + strA06, null);
                }
            case 18408:
                if (j == 1) {
                    return;
                } else {
                    throw C3K.A01(A06(113, 22, 77) + j + strA06, null);
                }
            case 20529:
                if (j == 0) {
                    return;
                } else {
                    throw C3K.A01(A06(457, 21, 29) + j + strA06, null);
                }
            case 20530:
                if (j == 1) {
                    return;
                } else {
                    throw C3K.A01(A06(478, 21, 16) + j + strA06, null);
                }
            case 21420:
                this.A0K = this.A0M + j;
                return;
            case 21432:
                int i2 = (int) j;
                A0D(i);
                switch (i2) {
                    case 0:
                        this.A0T.A0U = 0;
                        return;
                    case 1:
                        this.A0T.A0U = 2;
                        return;
                    case 3:
                        this.A0T.A0U = 1;
                        return;
                    case 15:
                        this.A0T.A0U = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                A05(i).A0L = (int) j;
                return;
            case 21682:
                A05(i).A0K = (int) j;
                return;
            case 21690:
                A05(i).A0J = (int) j;
                return;
            case 21930:
                A05(i).A0g = j == 1;
                return;
            case 21945:
                A0D(i);
                switch ((int) j) {
                    case 1:
                        C0565Io c0565Io = this.A0T;
                        if (A0u[7].length() != 16) {
                            String[] strArr4 = A0u;
                            strArr4[1] = "46IydxS7gy6otlVQjCqCZWblmnAwVrZG";
                            strArr4[0] = "ABdhU4etfaEDzGqzhVxfZNO7CdkZTY0J";
                            c0565Io.A0F = 2;
                            return;
                        }
                        c0565Io.A0F = 2;
                        return;
                    case 2:
                        this.A0T.A0F = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                A0D(i);
                int iA01 = ColorInfo.A01((int) j);
                if (iA01 == -1) {
                    return;
                }
                this.A0T.A0H = iA01;
                return;
            case 21947:
                A0D(i);
                this.A0T.A0h = true;
                int iA00 = ColorInfo.A00((int) j);
                if (iA00 == -1) {
                    return;
                }
                this.A0T.A0G = iA00;
                return;
            case 21948:
                A05(i).A0O = (int) j;
                return;
            case 21949:
                A05(i).A0P = (int) j;
                return;
            case 21998:
                A05(i).A0N = (int) j;
                return;
            case 22186:
                A05(i).A0X = j;
                return;
            case 22203:
                A05(i).A0Y = j;
                return;
            case 25188:
                A05(i).A0D = (int) j;
                return;
            case 30114:
                this.A0E = j;
                return;
            case 30321:
                A0D(i);
                switch ((int) j) {
                    case 0:
                        this.A0T.A0S = 0;
                        return;
                    case 1:
                        this.A0T.A0S = 1;
                        return;
                    case 2:
                        this.A0T.A0S = 2;
                        return;
                    case 3:
                        this.A0T.A0S = 3;
                        return;
                    default:
                        return;
                }
            case 2352003:
                C0565Io c0565IoA05 = A05(i);
                if (A0u[3].charAt(5) != 'R') {
                    throw new RuntimeException();
                }
                A0u[3] = "17DkRR24xbcR08jR5ve3iaIolPHvV07P";
                c0565IoA05.A0I = (int) j;
                return;
            case 2807729:
                this.A0O = j;
                return;
            default:
                return;
        }
    }

    public final void A0W(int i, long j, long j2) throws C3K {
        A09();
        switch (i) {
            case 160:
                this.A0W = false;
                this.A0E = 0L;
                return;
            case 174:
                this.A0T = new C0565Io();
                return;
            case 187:
                this.A0d = false;
                return;
            case 19899:
                this.A0C = -1;
                this.A0K = -1L;
                return;
            case 20533:
                A05(i).A0i = true;
                return;
            case 21968:
                A05(i).A0h = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.A0M == -1 || this.A0M == j) {
                    this.A0M = j;
                    this.A0N = j2;
                    return;
                }
                throw C3K.A01(A06(886, 39, 119), null);
            case 475249515:
                this.A0R = new C02144h();
                this.A0Q = new C02144h();
                return;
            case 524531317:
                if (this.A0e) {
                    return;
                }
                if (this.A0s && this.A0H != -1) {
                    this.A0c = true;
                    return;
                } else {
                    this.A0S.AJ7(new C1767mn(this.A0J));
                    this.A0e = true;
                    return;
                }
        }
    }

    @MetaExoPlayerCustomization("Adding support for AR/VR TAGs")
    public final void A0X(int i, String str) throws C3K {
        switch (i) {
            case 134:
                A05(i).A0d = str;
                return;
            case 17026:
                if (!A06(1375, 4, 110).equals(str) && !A06(1357, 8, 67).equals(str)) {
                    throw C3K.A01(A06(551, 8, 69) + str + A06(42, 14, 63), null);
                }
                return;
            case 17827:
                this.A0U = str;
                return;
            case 21358:
                C0565Io c0565IoA05 = A05(i);
                if (A0u[7].length() != 16) {
                    String[] strArr = A0u;
                    strArr[1] = "fMu5gmFUMMjyE5zZcj2yfEtnORci9Tka";
                    strArr[0] = "H9jO6y53WPcXDhmRgvdqczqosoX1IojD";
                    c0565IoA05.A0e = str;
                    return;
                }
                throw new RuntimeException();
            case 2274716:
                A05(i).A0o = str;
                return;
            default:
                return;
        }
    }

    public final boolean A0Y(int i) {
        if (i != 357149030 && i != 524531317) {
            String[] strArr = A0u;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0u;
            strArr2[5] = "AFdTkHzIX2";
            strArr2[6] = "QjCHXWDM6RodCI1HM4Zn3pBBf";
            if (i != 475249515 && i != 374648427) {
                return false;
            }
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0S = ha;
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0027 */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int AHL(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        this.A0X = false;
        boolean zAHO = true;
        while (zAHO && !this.A0X) {
            zAHO = this.A0q.AHO(interfaceC1772ms);
            if (zAHO && A0L(hv, interfaceC1772ms.A8n())) {
                return 1;
            }
        }
        if (zAHO) {
            return 0;
        }
        for (int i = 0; i < i; i++) {
            C0565Io c0565IoValueAt = this.A0P.valueAt(i);
            c0565IoValueAt.A06();
            c0565IoValueAt.A0E();
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x001e */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void AJ6(long j, long j2) {
        this.A0G = -9223372036854775807L;
        this.A05 = 0;
        this.A0q.reset();
        this.A0r.A06();
        A0A();
        for (int i = 0; i < i; i++) {
            this.A0P.valueAt(i).A0F();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1772ms interfaceC1772ms) throws IOException {
        return new C0566Ip().A01(interfaceC1772ms);
    }
}
