package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1723lt extends AbstractC0577Jb {
    public static byte[] A05;
    public static String[] A06 = {"uV3egKqPt", "vbtXlOI", "gip2ILD7nBGTUOP5yb7zSULibNYEk", "ypzju5tbq0Qdtgd67o3qNaulkzBfCJSX", "gCa1Tkio4U0hXnRqOcWVPONwWAtrpMS5", "m", "OXoEHzgO5FTzqO33f", "i"};
    public int A00;
    public C0532Hh A01;
    public C0534Hj A02;
    public C0578Jc A03;
    public boolean A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C0578Jc A02(C02284v c02284v) throws IOException {
        if (this.A02 == null) {
            this.A02 = AbstractC0535Hk.A06(c02284v);
            return null;
        }
        if (this.A01 == null) {
            this.A01 = AbstractC0535Hk.A04(c02284v);
            return null;
        }
        C0534Hj c0534Hj = this.A02;
        C0532Hh c0532Hh = this.A01;
        byte[] bArr = new byte[c02284v.A0A()];
        System.arraycopy(c02284v.A0l(), 0, bArr, 0, c02284v.A0A());
        return new C0578Jc(c0534Hj, c0532Hh, bArr, AbstractC0535Hk.A0D(c02284v, c0534Hj.A05), AbstractC0535Hk.A00(r6.length - 1));
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{-108, -88, -105, -100, -94, 98, -87, -94, -91, -107, -100, -90};
    }

    static {
        A04();
    }

    public static int A00(byte b, int i, int i2) {
        return (b >> i2) & (PHIpAddressSearchManager.END_IP_SCAN >>> (8 - i));
    }

    public static int A01(byte b, C0578Jc c0578Jc) {
        if (!c0578Jc.A04[A00(b, c0578Jc.A00, 1)].A03) {
            int modeNumber = c0578Jc.A02.A03;
            return modeNumber;
        }
        int modeNumber2 = c0578Jc.A02.A04;
        return modeNumber2;
    }

    public static void A05(C02284v c02284v, long j) {
        if (c02284v.A08() < c02284v.A0A() + 4) {
            c02284v.A0i(Arrays.copyOf(c02284v.A0l(), c02284v.A0A() + 4));
        } else {
            c02284v.A0e(c02284v.A0A() + 4);
        }
        byte[] bArrA0l = c02284v.A0l();
        bArrA0l[c02284v.A0A() - 4] = (byte) (j & 255);
        bArrA0l[c02284v.A0A() - 3] = (byte) ((j >>> 8) & 255);
        bArrA0l[c02284v.A0A() - 2] = (byte) ((j >>> 16) & 255);
        bArrA0l[c02284v.A0A() - 1] = (byte) (255 & (j >>> 24));
    }

    public static boolean A06(C02284v c02284v) {
        try {
            return AbstractC0535Hk.A0C(1, c02284v, true);
        } catch (C3K unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    public final long A09(C02284v c02284v) {
        int i = 0;
        if ((c02284v.A0l()[0] & 1) == 1) {
            return -1L;
        }
        byte b = c02284v.A0l()[0];
        if (A06[4].charAt(1) != 'C') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[0] = "17tCp0Qcd";
        strArr[6] = "uqZ30DdcDRhFwj0kQ";
        int samplesInPacket = A01(b, (C0578Jc) AbstractC02053y.A02(this.A03));
        if (this.A04) {
            int packetBlockSize = this.A00;
            i = (packetBlockSize + samplesInPacket) / 4;
        }
        A05(c02284v, i);
        this.A04 = true;
        this.A00 = samplesInPacket;
        return i;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    public final void A0A(long j) {
        super.A0A(j);
        this.A04 = j != 0;
        this.A00 = this.A02 != null ? this.A02.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    public final void A0B(boolean z) {
        super.A0B(z);
        if (z) {
            this.A03 = null;
            this.A02 = null;
            this.A01 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0577Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C02284v c02284v, long j, C0576Ja c0576Ja) throws IOException {
        if (this.A03 != null) {
            AbstractC02053y.A01(c0576Ja.A00);
            return false;
        }
        this.A03 = A02(c02284v);
        if (this.A03 == null) {
            return true;
        }
        C0578Jc c0578Jc = this.A03;
        C0534Hj c0534Hj = c0578Jc.A02;
        ArrayList<byte[]> codecInitializationData = new ArrayList<>();
        codecInitializationData.add(c0534Hj.A09);
        codecInitializationData.add(c0578Jc.A03);
        c0576Ja.A00 = new C01722p().A11(A03(0, 12, 22)).A0a(c0534Hj.A02).A0j(c0534Hj.A00).A0b(c0534Hj.A05).A0m(c0534Hj.A06).A12(codecInitializationData).A0v(AbstractC0535Hk.A02(MetaExoPlayerCustomizedCollections.A02(c0578Jc.A01.A02))).A14();
        return true;
    }
}
