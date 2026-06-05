package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.12, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass12 extends AbstractC01391g implements AnonymousClass78 {
    public static byte[] A0J;
    public static String[] A0K = {"77C8vP87Fd7b4BP9SQRJBzWPVk4TewQg", "oQ2qsKrmaNuyaLFB2ph9zkmGtpzAonXt", "MDqZPLCoXCzEQwxPxYtAKuxbh2tAcx1k", "aWPkhw6gWy0BTxYknUchyjQmABWF", "ais5GYfL5LR1KEYd6HRi1BBd2kmjCeGs", "pdewp8MC9mt7vaqV0Zkeu3U5mw150Zm9", "qv2CVs2gAdpJ8ZKBYAbfHfBiBdoePlCI", "lcPZgHPLbCISPmjsMn5qIGSBsvlpomMq"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public MediaFormat A06;
    public C1981qI A07;
    public InterfaceC02927h A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public final Context A0E;
    public final C03248o A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final InterfaceC03328z A0I;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A0K[3].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[4] = "GcWDzLLiTAl0tD46XyRRBcNodd92JrSP";
            strArr[0] = "GhxldHXMoVDog6OAV5RKTarDpyl0kviC";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0J = new byte[]{-103, -79, -80, -75, -83, -113, -69, -80, -79, -81, -115, -63, -80, -75, -69, -98, -79, -70, -80, -79, -66, -79, -66, -77, -79, -68, -110, -73, -87, -89, -110, -59, -59, -57, -110, -56, -55, -57, -36, -38, -27, -69, -12, -4, -4, -12, -7, -14, -69, -1, -18, 4, -69, -15, -14, -16, -4, -15, -14, -1, -17, -17, -15, -69, -14, 0, -15, -69, -13, -12, -12, -13, -15, 2, -69, 2, 7, -2, -13, -51, -51, -49, -103, -32, -51, -34, -45, -47, -32, -103, -34, -47, -46, -103, -40, -47, -30, -47, -40, 7, 27, 10, 15, 21, -43, 24, 7, 29, 20, 25, 18, 31, 31, 22, 29, -34, 20, 32, 38, 31, 37, -85, -88, -75, -78, -81, -73, -88, -31, -34, -21, -24, -22, -27, -19, -34, -54, -66, -43, -118, -58, -53, -51, -46, -47, -118, -48, -58, -41, -62, -39, -43, -39, -47, -68, -65, -125, -80, 125, -125, 127, 125, -125, -127, -64, -62, -71, -65, -62, -71, -60, -55, -65, -83, -71, -68, -72, -79, 121, -66, -83, -64, -79, -27, -45, -33, -27, -25, -32, -39, -47, -68, -55, -58, -67, -61, -53, -68};
    }

    static {
        A09();
    }

    public AnonymousClass12(Context context, C1577jQ c1577jQ, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, BT bt, A6 a6, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC03258p interfaceC03258p, C8R c8r, InterfaceC01913k... interfaceC01913kArr) {
        this(context, c1577jQ, mediaCodecRendererMetaParameters, bt, a6, z, z2, z3, handler, interfaceC03258p, new C1862oM(c8r, interfaceC01913kArr));
    }

    public AnonymousClass12(Context context, C1577jQ c1577jQ, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, BT bt, A6 a6, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC03258p interfaceC03258p, InterfaceC03328z interfaceC03328z) {
        super(1, c1577jQ, mediaCodecRendererMetaParameters, bt, a6, z, false, 0, 0);
        this.A01 = 0;
        this.A02 = 0;
        this.A05 = 0L;
        this.A0E = context.getApplicationContext();
        this.A0I = interfaceC03328z;
        this.A0G = z2;
        this.A0H = z3;
        this.A0F = new C03248o(handler, interfaceC03258p);
        interfaceC03328z.AJV(new C1860oK(this));
        interfaceC03328z.AJQ(c1577jQ.A0D);
    }

    @MetaExoPlayerCustomization("Added in D36293647 for DRC")
    private int A00() {
        int i = this.A0z.A09;
        if (this.A0z.A0F) {
            int i2 = this.A0z.A03;
            int i3 = this.A0z.A04;
            int xHEAACEffectType = this.A0z.A05;
            return ContextAwareXHEAACDRCTypeUtil.A00(i2, i3, xHEAACEffectType);
        }
        return i;
    }

    public static int A01(C1981qI c1981qI) {
        if (A07(99, 9, 101).equals(c1981qI.A0W)) {
            return c1981qI.A0C;
        }
        return 2;
    }

    private int A02(B3 b3, C1981qI c1981qI) {
        if (A07(38, 22, 76).equals(b3.A03) && C5C.A02 < 24) {
            int i = C5C.A02;
            String[] strArr = A0K;
            if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[2] = "s8yZpZp8nIrL7EQY3mPJ1kqCekDwsY6i";
            strArr2[7] = "yd2Z0BEEocl53iuZqAxtcOKT0DXRknsH";
            if (i != 23 || !C5C.A18(this.A0E)) {
                String[] strArr3 = A0K;
                if (strArr3[4].charAt(18) != strArr3[0].charAt(18)) {
                    throw new RuntimeException();
                }
                A0K[3] = "9QHOUbokymVnxuZO6z7rLJCC2XoG";
                return -1;
            }
        }
        int i2 = c1981qI.A0B;
        String[] strArr4 = A0K;
        if (strArr4[2].charAt(3) != strArr4[7].charAt(3)) {
            return i2;
        }
        String[] strArr5 = A0K;
        strArr5[2] = "bWiZaXhFQHkoAXZnJ4ncaGOlncM6vz1V";
        strArr5[7] = "kg6ZwO8ePPrkJPsuoAADu0ZS0U6OWo96";
        return i2;
    }

    private final int A03(B3 b3, C1981qI c1981qI, C1981qI[] c1981qIArr) {
        int maxInputSize = A02(b3, c1981qI);
        return maxInputSize;
    }

    private final MediaFormat A04(C1981qI c1981qI, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A07(150, 4, 43), str);
        mediaFormat.setInteger(A07(108, 13, 112), c1981qI.A06);
        mediaFormat.setInteger(A07(172, 11, 11), c1981qI.A0G);
        AbstractC02154i.A06(mediaFormat, c1981qI.A0X);
        AbstractC02154i.A04(mediaFormat, A07(136, 14, 28), i);
        if (C5C.A02 >= 23) {
            String strA07 = A07(164, 8, 15);
            String[] strArr = A0K;
            if (strArr[4].charAt(18) != strArr[0].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[1] = "w8gjBPJzE632nZpBrlzwe1tLIvq8CsOY";
            strArr2[6] = "ag3DPBWcd6fSOrmBwunkDpt77Nl4HY4l";
            mediaFormat.setInteger(strA07, 0);
        }
        if (c1981qI.A0R != null && c1981qI.A0R.equals(A07(154, 10, 14)) && this.A0z.A0G) {
            mediaFormat.setInteger(A07(60, 19, 77), A00());
            mediaFormat.setInteger(A07(79, 20, 43), this.A0z.A0A);
        }
        return mediaFormat;
    }

    public static /* synthetic */ InterfaceC02927h A05(AnonymousClass12 anonymousClass12) {
        return null;
    }

    private void A08() {
        long jA7f = this.A0I.A7f(AAP());
        if (jA7f != Long.MIN_VALUE) {
            if (!this.A0A) {
                long j = this.A04;
                String[] strArr = A0K;
                if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0K;
                strArr2[4] = "nIJcPeFAtvuDBzBlXMRw0HpU2OMpTIMr";
                strArr2[0] = "dapTBdH8hqStbvnLCARUyCc0T0ChI3T8";
                jA7f = Math.max(j, jA7f);
            }
            this.A04 = jA7f;
            this.A0A = false;
        }
    }

    private boolean A0A(C1981qI c1981qI) {
        String str = c1981qI.A0W;
        String mimeType = A07(99, 9, 101);
        if (!mimeType.equals(str)) {
            return this.A0I.AKN(c1981qI);
        }
        String[] strArr = A0K;
        if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0K;
        strArr2[4] = "mDVewdn3RvQYeqn2qaR7zJPFTyK9zqzw";
        strArr2[0] = "a0e3mP5dmYOn07QMhHRhkP7lbfukdIg9";
        return false;
    }

    public static boolean A0B(String str) {
        if (C5C.A02 < 24 && A07(23, 15, 35).equals(str)) {
            if (A07(183, 7, 49).equals(C5C.A05) && (C5C.A03.startsWith(A07(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 8, 22)) || C5C.A03.startsWith(A07(121, 7, 2)) || C5C.A03.startsWith(A07(128, 8, 56)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.AE
    public final void A1X() {
        super.A1X();
        this.A0I.AH0();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.AE
    public final void A1Y() {
        A08();
        this.A0I.pause();
        super.A1Y();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.AE
    public final void A1Z() {
        try {
            this.A0I.flush();
            try {
                super.A1Z();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.A1Z();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.AE
    public final void A1a(long j, boolean z) throws AD {
        super.A1a(j, z);
        if (this.A0C) {
            this.A0I.A6T();
        } else {
            this.A0I.flush();
        }
        this.A04 = j;
        this.A09 = true;
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.AE
    public final void A1b(boolean z, boolean z2) throws AD {
        super.A1b(z, z2);
        this.A0F.A08(this.A0h);
        if (A1V().A00) {
            this.A0I.A6M();
        } else {
            this.A0I.A5z();
        }
        this.A0I.AJg(A1W());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final int A1g(B0 b0, B3 b3, C1981qI c1981qI, C1981qI c1981qI2) {
        if (this.A0z.A0O && A02(b3, c1981qI2) <= this.A00 && b3.A0U(c1981qI, c1981qI2, true) && c1981qI.A08 == 0 && c1981qI.A09 == 0 && c1981qI2.A08 == 0 && c1981qI2.A09 == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A1h(BT bt, A6 a6, C1981qI c1981qI) throws BX {
        int i;
        String str = c1981qI.A0W;
        int adaptiveSupport = 0;
        if (!C3J.A0C(str)) {
            return 0;
        }
        int i2 = C5C.A02 >= 21 ? 32 : 0;
        boolean zA1G = AbstractC01391g.A1G(c1981qI);
        int i3 = 4;
        if (zA1G && A0A(c1981qI) && C0373Ba.A0I() != null) {
            return i2 | 8 | 4;
        }
        String mimeType = A07(99, 9, 101);
        if (mimeType.equals(str)) {
            InterfaceC03328z interfaceC03328z = this.A0I;
            int tunnelingSupport = c1981qI.A06;
            if (interfaceC03328z.AKP(tunnelingSupport, c1981qI.A0C)) {
                if (this.A0I.AKP(c1981qI.A06, 2)) {
                    List<B3> listA1l = A1l(bt, c1981qI, false);
                    if (listA1l.isEmpty()) {
                        return AbstractC02937i.A00(1);
                    }
                    if (!zA1G) {
                        return AbstractC02937i.A00(2);
                    }
                    B3 b3 = listA1l.get(0);
                    int tunnelingSupport2 = A0K[5].charAt(0);
                    if (tunnelingSupport2 != 112) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0K;
                    strArr[4] = "n12bmxDOOVBzqYYOQBRjqp0moJyAYtSu";
                    strArr[0] = "BaglFChNOdaklTSyUQRitIBwXJJTR14H";
                    B3 b32 = b3;
                    if (C5C.A02 < 21 || ((c1981qI.A0G == -1 || b32.A0Q(c1981qI.A0G)) && (c1981qI.A06 == -1 || b32.A0P(c1981qI.A06)))) {
                        adaptiveSupport = 1;
                    }
                    if (adaptiveSupport != 0 && b32.A0T(c1981qI)) {
                        i = 16;
                    } else {
                        i = 8;
                    }
                    if (adaptiveSupport == 0) {
                        i3 = 3;
                    }
                    return i | i2 | i3;
                }
            }
        }
        return 1;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final List<B3> A1l(BT bt, C1981qI c1981qI, boolean z) throws BX {
        B3 b3A0I;
        String mimeType = c1981qI.A0W;
        if (mimeType == null) {
            return Collections.emptyList();
        }
        if (A0A(c1981qI) && (b3A0I = C0373Ba.A0I()) != null) {
            List<B3> listSingletonList = Collections.singletonList(b3A0I);
            String[] strArr = A0K;
            if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[4] = "VH1rG9jH3WXhHTxnLXRxhYBKNNIMNlpD";
            strArr2[0] = "4dJInhYjvnfEcXSyIbRNEiIfORerumv3";
            return listSingletonList;
        }
        return Collections.unmodifiableList(bt.A7o(c1981qI.A0W, z, false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final void A1o() throws AD {
        try {
            this.A0I.AH2();
        } catch (C03318y e) {
            throw A1T(e, e.A01, e.A02, 5002);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final void A1s(C1981qI c1981qI) throws AD {
        super.A1s(c1981qI);
        this.A07 = c1981qI;
        this.A0F.A05(this.A07, null);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final void A1u(C1902p0 c1902p0) {
        if (this.A09 && !c1902p0.A04()) {
            if (Math.abs(c1902p0.A01 - this.A04) > 500000) {
                this.A04 = c1902p0.A01;
            }
            this.A09 = false;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x0099 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A1v(B0 b0, MediaFormat mediaFormat) throws AD {
        int sampleRate;
        MediaFormat mediaFormat2;
        int[] channelMap;
        if (this.A06 != null) {
            sampleRate = C3J.A00(this.A06.getString(A07(150, 4, 43)));
            mediaFormat2 = this.A06;
        } else {
            sampleRate = A01(this.A07);
            mediaFormat2 = mediaFormat;
        }
        String strA07 = A07(108, 13, 112);
        int integer = mediaFormat2.getInteger(strA07);
        String strA072 = A07(172, 11, 11);
        if (A0K[5].charAt(0) != 'p') {
            throw new RuntimeException();
        }
        String[] strArr = A0K;
        strArr[1] = "oVYorWwiJ9QuTT6BmhgOhsdn4ih9katO";
        strArr[6] = "s4BjQ2RFQmOrQGZBZgzfkwBc6WQlVCBr";
        int encoding = mediaFormat2.getInteger(strA072);
        this.A03 = encoding * integer;
        if (this.A0B) {
            String[] strArr2 = A0K;
            String str = strArr2[1];
            String str2 = strArr2[6];
            int iCharAt = str.charAt(15);
            int encoding2 = str2.charAt(15);
            if (iCharAt != encoding2) {
                throw new RuntimeException();
            }
            A0K[5] = "pG08ZDLF1Nwa7YWNReZn10nEeTPXXDD5";
            if (integer == 6) {
                int encoding3 = this.A07.A06;
                if (encoding3 < 6) {
                    int encoding4 = this.A07.A06;
                    channelMap = new int[encoding4];
                    for (int i = 0; i < encoding; i++) {
                        channelMap[i] = i;
                    }
                } else {
                    channelMap = null;
                }
            }
        }
        C01722p c01722pA0i = new C01722p().A11(A07(99, 9, 101)).A0i(sampleRate);
        int encoding5 = mediaFormat.getInteger(strA07);
        C01722p c01722pA0b = c01722pA0i.A0b(encoding5);
        int encoding6 = mediaFormat.getInteger(strA072);
        C1981qI audioSinkInputFormat = c01722pA0b.A0m(encoding6).A14();
        try {
            this.A0I.A59(audioSinkInputFormat, 0, channelMap);
        } catch (C03278s e) {
            throw A1S(e, e.A00, 5001);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final void A1w(B3 b3, B0 b0, C1981qI c1981qI, MediaCrypto mediaCrypto) {
        this.A00 = A03(b3, c1981qI, A1e());
        this.A0B = A0B(b3.A03);
        String str = b3.A02;
        String strA07 = A07(99, 9, 101);
        this.A0D = strA07.equals(str) && !strA07.equals(c1981qI.A0W);
        MediaFormat mediaFormatA04 = A04(c1981qI, b3.A01, this.A00);
        b0.A58(mediaFormatA04, null, mediaCrypto, 0, null);
        if (this.A0D) {
            this.A06 = mediaFormatA04;
            this.A06.setString(A07(150, 4, 43), c1981qI.A0W);
        } else {
            this.A06 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public final void A1x(String str) {
        this.A0F.A0F(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final void A1y(String str, long j, long j2) {
        this.A0F.A0G(str, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    @MetaExoPlayerCustomization("Added in D6142814")
    public final boolean A22() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g
    public final boolean A23(long j, long j2, B0 b0, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2) throws AD {
        if (this.A0D) {
            int i3 = i2 & 2;
            if (A0K[3].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[2] = "qFTZlqBsfbROWjHKIBaS9ttrRfnfHc6a";
            strArr[7] = "sZoZRvagNjZKK9rko7XS8oWwcuS8hqha";
            if (i3 != 0) {
                b0.AHi(i, false);
                return true;
            }
        }
        if (z) {
            b0.AHi(i, false);
            if (A0K[5].charAt(0) != 'p') {
                String[] strArr2 = A0K;
                strArr2[4] = "i4U0xdeb2kJYTtTzacReJ5RV5axgIdhD";
                strArr2[0] = "rrPeATHc6C5SnSGUS9RZuIpTT0sGFjMh";
                this.A0h.A0B++;
                this.A0I.A9h();
                return true;
            }
            String[] strArr3 = A0K;
            strArr3[1] = "GzmR5b8Z6T6If0UBPoEMKvf6QjFSlvzk";
            strArr3[6] = "qLQdQ1juS6S8x5RB3mUlKTK412OZk0qd";
            this.A0h.A0B++;
            this.A0I.A9h();
            return true;
        }
        if (this.A0H && A01(this.A07) == 2 && i2 == 0 && this.A03 > 0 && byteBuffer.limit() - byteBuffer.position() >= 12) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            byteBuffer.position(10);
            short s = byteBuffer.getShort();
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            int i4 = this.A01;
            int iLimit2 = byteBuffer.limit();
            int originalPosition = byteBuffer.position();
            this.A01 = i4 + (iLimit2 - originalPosition);
            int i5 = this.A02;
            String[] strArr4 = A0K;
            String str = strArr4[4];
            String str2 = strArr4[0];
            int iCharAt = str.charAt(18);
            int originalPosition2 = str2.charAt(18);
            if (iCharAt != originalPosition2) {
                throw new RuntimeException();
            }
            String[] strArr5 = A0K;
            strArr5[1] = "MwudhWWmLfAHxFUBWVuNAQ0R1ppnonhu";
            strArr5[6] = "h4oByFchRKdWl7IBcc7CSq20vr2fgRzF";
            this.A02 = i5 + 1;
            long j4 = this.A05;
            int originalPosition3 = Math.abs((int) s);
            this.A05 = j4 + ((long) originalPosition3);
            int i6 = this.A01;
            int originalPosition4 = this.A03;
            if (i6 >= originalPosition4 * 2) {
                this.A0F.A00((int) (this.A05 / ((long) this.A02)));
                this.A01 = 0;
                this.A02 = 0;
                this.A05 = 0L;
            }
        }
        if (this.A0G) {
            int iLimit3 = byteBuffer.limit();
            int originalPosition5 = byteBuffer.position();
            if (iLimit3 > originalPosition5) {
                int iPosition2 = byteBuffer.position();
                int iLimit4 = byteBuffer.limit();
                int originalPosition6 = iLimit4 - iPosition2;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(originalPosition6);
                byteBufferAllocate.put(byteBuffer);
                byteBufferAllocate.flip();
                byteBuffer.position(iPosition2);
                byteBuffer.limit(iLimit4);
                this.A0F.A0K(byteBufferAllocate.array(), j3 / 1000);
            }
        }
        try {
            if (!this.A0I.A9e(byteBuffer, j3, 1)) {
                return false;
            }
            b0.AHi(i, false);
            this.A0h.A09++;
            return true;
        } catch (C03288t e) {
            throw A1T(e, this.A07, e.A02, 5001);
        } catch (C03318y e2) {
            throw A1T(e2, this.A0g, e2.A02, 5002);
        }
    }

    public final void A26() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.core.AE, com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final AnonymousClass78 A8T() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass78
    public final C1960px A8m() {
        return this.A0I.A8m();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass78
    public final long A8p() {
        if (A9A() == 2) {
            A08();
        }
        long j = this.A04;
        String[] strArr = A0K;
        if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
            throw new RuntimeException();
        }
        A0K[5] = "p6YKYNxicnjzLIFANgsfPKErY7h8fvSp";
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.AE, com.facebook.ads.redexgen.core.InterfaceC02877c
    public final void A9i(int i, Object obj) throws AD {
        switch (i) {
            case 2:
                this.A0I.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.A0I.AJG((C1987qQ) obj);
                return;
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                super.A9i(i, obj);
                return;
            case 6:
                this.A0I.AJI((AnonymousClass21) obj);
                return;
            case 9:
                this.A0I.AJo(((Boolean) obj).booleanValue());
                return;
            case 10:
                this.A0I.AJH(((Integer) obj).intValue());
                return;
            case 11:
                this.A08 = null;
                return;
            case 12:
                if (C5C.A02 < 23) {
                    return;
                }
                InterfaceC03328z interfaceC03328z = this.A0I;
                if (A0K[3].length() != 28) {
                    throw new RuntimeException();
                }
                A0K[3] = "XCf3J2AEJJ1Zd2j3qAi6tezJ2mG7";
                C9S.A00(interfaceC03328z, obj);
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final boolean AAP() {
        return super.AAP() && this.A0I.AAP();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC01391g, com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final boolean AAe() {
        if (!this.A0I.A9o()) {
            boolean zAAe = super.AAe();
            if (A0K[5].charAt(0) != 'p') {
                throw new RuntimeException();
            }
            A0K[3] = "YZui0KIXZR8KzjI1EkPC1GaIUT4y";
            if (!zAAe) {
                return false;
            }
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass78
    public final void AJd(C1960px c1960px) {
        this.A0I.AJd(c1960px);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo, com.facebook.ads.redexgen.core.InterfaceC03007p
    public final String getName() {
        return A07(0, 23, 11);
    }
}
