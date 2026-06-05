package com.facebook.ads.redexgen.core;

import android.text.Layout;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Km, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0614Km {
    public static byte[] A0B;
    public static String[] A0C = {"ESJRmhDLc7NikCaEyh1Vifm1kcZyUfVZ", "aTTKw54KgCsdTiacoM6Uao", "AQffeXGY9UF2RO1KJqJs07qSuLvLibNX", "JzQF5qJPeleZtBxAVP8FFhosbzcygG6f", "tbObE2uaMy", "gF7iYmzQc0u", "ooQgCGRV3OuZUQB0e4AvfnYfn3EwO6qP", "bBgaV4vqzz2b3sIikkn4irzAIlEySbAE"};
    public CharSequence A0A;
    public long A09 = 0;
    public long A08 = 0;
    public int A06 = 2;
    public float A00 = -3.4028235E38f;
    public int A04 = 1;
    public int A03 = 0;
    public float A01 = -3.4028235E38f;
    public int A05 = Integer.MIN_VALUE;
    public float A02 = 1.0f;
    public int A07 = Integer.MIN_VALUE;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0B = new byte[]{35, 24, 29, 24, 25, 1, 24, 86, 2, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 2, 55, 26, 31, 17, 24, 27, 19, 24, 2, 76, 86, 20, 38, 33, 53, 55, 55, 0, 54, 38, 19, 34, 49, 48, 38, 49};
    }

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r6 > 1.0f) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float A00(float f, int i) {
        if (f != -3.4028235E38f && i == 0) {
            if (f >= 0.0f) {
                if (A0C[2].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[3] = "J0IfntZMkxbbx68hLNly1u3Pfrgy9oGS";
                strArr[0] = "jp12lwau8SNu8MLcYdTF5jN7geoyKRFi";
            }
            return 1.0f;
        }
        if (f != -3.4028235E38f) {
            return f;
        }
        return i == 0 ? 1.0f : -3.4028235E38f;
    }

    public static float A01(int i) {
        switch (i) {
            case 4:
                String[] strArr = A0C;
                if (strArr[7].charAt(26) != strArr[6].charAt(26)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[7] = "U5kipMMfYsvpFebUOrNnvm9fZvEH8TF4";
                strArr2[6] = "e8XmGXiYxdTIRsHNKLkkAuRQRzEuxsB2";
                return 0.0f;
            case 5:
                return 1.0f;
            default:
                return 0.5f;
        }
    }

    public static float A02(int i, float f) {
        switch (i) {
            case 0:
                return 1.0f - f;
            case 1:
                if (f <= 0.5f) {
                    return 2.0f * f;
                }
                return (1.0f - f) * 2.0f;
            case 2:
                return f;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
    }

    public static int A03(int i) {
        switch (i) {
            case 1:
            case 4:
                return 0;
            case 2:
            default:
                return 1;
            case 3:
            case 5:
                return 2;
        }
    }

    public static Layout.Alignment A04(int i) {
        switch (i) {
            case 1:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 5:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                AbstractC02134g.A07(A05(23, 15, 34), A05(0, 23, 23) + i);
                return null;
        }
    }

    public final C01953o A07() {
        int iA03;
        float fA01 = this.A01 != -3.4028235E38f ? this.A01 : A01(this.A06);
        if (this.A05 != Integer.MIN_VALUE) {
            iA03 = this.A05;
        } else {
            iA03 = A03(this.A06);
        }
        C01953o c01953oA0A = new C01953o().A0F(A04(this.A06)).A07(A00(this.A00, this.A04), this.A04).A09(this.A03).A04(fA01).A0A(iA03);
        float f = this.A02;
        float position = A02(iA03, fA01);
        C01953o c01953oA0B = c01953oA0A.A06(Math.min(f, position)).A0B(this.A07);
        if (this.A0A != null) {
            c01953oA0B.A0G(this.A0A);
        }
        return c01953oA0B;
    }

    public final C0607Kf A08() {
        return new C0607Kf(A07().A0H(), this.A09, this.A08);
    }
}
