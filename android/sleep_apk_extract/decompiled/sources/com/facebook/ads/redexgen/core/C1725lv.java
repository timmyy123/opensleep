package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1725lv extends AbstractC0577Jb {
    public static byte[] A01;
    public static String[] A02 = {"llfHvvp5w7AsdcfCf5e", "amqCmPcUyTwYr5NdTloeCtiw", "0NAIhycYLxj75", "dj34azdkZPKXRKaV6TbpL4Sg", "ijcAEj6S85lKiCQyoflHjypUMqTEGqRn", "eY0hdp8", "jqGnWXF3Z8AkxtecEpgwxV1mUEmkJWKs", "4zwbE0EN4gXO5y3Vp0p"};
    public static final byte[] A03;
    public static final byte[] A04;
    public boolean A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-1, 19, 2, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -51, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 17};
    }

    static {
        A01();
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
        A03 = new byte[]{79, 112, 117, 115, 84, 97, 103, 115};
    }

    public static boolean A02(C02284v c02284v) {
        return A03(c02284v, A04);
    }

    public static boolean A03(C02284v c02284v, byte[] bArr) {
        if (c02284v.A07() < bArr.length) {
            return false;
        }
        int iA09 = c02284v.A09();
        int startPosition = bArr.length;
        byte[] header = new byte[startPosition];
        int startPosition2 = bArr.length;
        c02284v.A0k(header, 0, startPosition2);
        c02284v.A0f(iA09);
        return Arrays.equals(header, bArr);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    public final long A09(C02284v c02284v) {
        return A06(HT.A05(c02284v.A0l()));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    public final void A0B(boolean z) {
        super.A0B(z);
        if (z) {
            this.A00 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public final boolean A0C(C02284v c02284v, long j, C0576Ja c0576Ja) throws C3K {
        if (A03(c02284v, A04)) {
            byte[] headerBytes = Arrays.copyOf(c02284v.A0l(), c02284v.A0A());
            int iA01 = HT.A01(headerBytes);
            List<byte[]> listA06 = HT.A06(headerBytes);
            if (c0576Ja.A00 != null) {
                return true;
            }
            c0576Ja.A00 = new C01722p().A11(A00(0, 10, 33)).A0b(iA01).A0m(48000).A12(listA06).A14();
            return true;
        }
        if (A03(c02284v, A03)) {
            AbstractC02053y.A02(c0576Ja.A00);
            if (this.A00) {
                return true;
            }
            this.A00 = true;
            c02284v.A0g(A03.length);
            C0532Hh commentHeader = AbstractC0535Hk.A05(c02284v, false, false);
            Metadata metadataA02 = AbstractC0535Hk.A02(MetaExoPlayerCustomizedCollections.A02(commentHeader.A02));
            if (metadataA02 == null) {
                return true;
            }
            C01722p c01722pA07 = c0576Ja.A00.A07();
            String[] strArr = A02;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "80vtnZ0VGuLh5BtNytGnkcmL";
            strArr2[1] = "kfnMkjsOg47yHVBMKsSTRfGb";
            c0576Ja.A00 = c01722pA07.A0v(metadataA02.A04(c0576Ja.A00.A0P)).A14();
            return true;
        }
        AbstractC02053y.A02(c0576Ja.A00);
        return false;
    }
}
