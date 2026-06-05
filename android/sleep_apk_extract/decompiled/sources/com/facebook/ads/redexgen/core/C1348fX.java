package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.Surface;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1348fX {
    public static byte[] A02;
    public final AA A00;
    public final C1789nA A01 = new C1789nA();

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-64, -54, -66, -64, 1, -1, 19, 17, 3, -64, -66, -40, -66, -64, -74, -64, -76, -74, 6, -7, 2, -8, -7, 6, -7, 6, -35, 2, -8, -7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -74, -76, -50, -76, -74, -54, 37, -9, -6, 9, 16, -73, 2, -6, 8, 8, -10, -4, -6, -73, -75, -49, -75, -73, -75, 92, -82, -77, -86, -97, 92, 90, 116, 90, 92};
    }

    public C1348fX(C1421gi c1421gi) {
        InterfaceC0460Em trackSelectionFactory = new C1806nR(this.A01);
        C03389h c03389h = new C03389h(trackSelectionFactory);
        AnonymousClass74 loadControl = new C1899ox();
        this.A00 = AbstractC02606b.A00(new C1896ou(c1421gi), c03389h, loadControl, this.A01);
    }

    public static String A01(C1962pz c1962pz) {
        boolean z = c1962pz instanceof AD;
        String strA00 = A00(36, 2, 118);
        String strA002 = A00(0, 14, 108);
        if (z) {
            AD ad = (AD) c1962pz;
            return A00(55, 11, 8) + ad.A03 + A00(14, 22, 98) + ad.A02 + strA002 + ad.getCause() + strA00;
        }
        return A00(41, 14, 99) + c1962pz.getMessage() + strA002 + c1962pz.getCause() + strA00;
    }

    public static boolean A03() {
        return true;
    }

    public final int A04() {
        return this.A00.A0I();
    }

    public final int A05() {
        return this.A00.A00();
    }

    public final long A06() {
        return this.A00.A7e();
    }

    public final long A07() {
        return this.A00.A7s();
    }

    public final C1346fV A08() {
        C1981qI vf = this.A00.A0K();
        if (vf == null) {
            return null;
        }
        return new C1346fV(vf.A0L, vf.A0A);
    }

    public final void A09() {
        this.A00.A0L();
    }

    public final void A0A() {
        this.A00.A02();
    }

    public final void A0B() {
        this.A00.A01();
    }

    public final void A0C(float f) {
        this.A00.A0M(f);
    }

    public final void A0D(long j) {
        this.A00.A04(j);
    }

    public final void A0E(Surface surface) {
        this.A00.A0N(surface);
    }

    public final void A0F(C1417ge c1417ge, Uri uri) {
        if (C0871Up.A2z(c1417ge, A03())) {
            C1352fb cacheManager = C1352fb.A06(c1417ge);
            C5Y cachedDataSourceFactory = cacheManager.A0H(c1417ge);
            this.A00.A0Q(new C03439o(cachedDataSourceFactory).A04(uri));
            return;
        }
        InterfaceC0419Cx mediaSource = new C03439o(new C1916pE(c1417ge, C5C.A0j(c1417ge, A00(38, 3, 100)), this.A01)).A04(uri);
        this.A00.A0Q(mediaSource);
    }

    public final void A0G(InterfaceC1345fU interfaceC1345fU) {
        this.A00.A0O(new D6(this, interfaceC1345fU));
    }

    public final void A0H(final InterfaceC1347fW interfaceC1347fW) {
        this.A00.A0P(new InterfaceC1887ol() { // from class: com.facebook.ads.redexgen.X.2s
            @Override // com.facebook.ads.redexgen.core.C5L
            public final void AGa(int i, int i2, int i3, float f) {
                interfaceC1347fW.AGa(i, i2, i3, f);
            }
        });
    }

    public final void A0I(boolean z) {
        this.A00.A0S(z);
    }

    public final boolean A0J() {
        return this.A00.A0T();
    }

    public final boolean A0K() {
        return this.A00.A0J() != null;
    }
}
