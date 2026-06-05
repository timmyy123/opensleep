package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ZR implements TA {
    public static ZR A07;
    public static byte[] A08;
    public InterfaceC0651Lx A00;
    public T1 A01;
    public T9 A02;
    public TP A03;
    public U7 A04;
    public VM A05;
    public CY A06;

    static {
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{44, 62, 76, 76, 66, 72, 71, -7, 61, 58, 77, 58, -7, 66, 71, 66, 77, 66, 58, 69, 66, 83, 62, 61, 28, -13, -19, 32, 27, -15, 28, 15, 26, 25, 28, 30, -3, 15, 29, 29, 19, 25, 24, -18, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 30, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -13, 24, 19, 30, 19, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 19, 36, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C1417ge c1417ge) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c1417ge);
        this.A06 = A05(c1417ge, this.A03, A03(c1417ge));
        A09(c1417ge, A00(c1417ge, this.A06));
        A0A(c1417ge, this.A06);
        A0B(c1417ge, this.A06);
        if (this.A06 != null) {
            this.A06.A6d();
        }
    }

    public static SR A00(C1417ge c1417ge, CY cy) {
        if (!C0871Up.A1r(c1417ge) || cy == null) {
            return null;
        }
        return SS.A00().A00(cy);
    }

    public static TP A01(C1417ge c1417ge) {
        return TQ.A00().A00(c1417ge, new C1120bp());
    }

    public static synchronized ZR A02() {
        if (A07 == null) {
            A07 = new ZR();
        }
        return A07;
    }

    public static InterfaceC1372fv A03(C1417ge c1417ge) {
        if (!C0871Up.A1n(c1417ge)) {
            return null;
        }
        return C1390gD.A01(c1417ge);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.TA
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized CY A9F() {
        return this.A06;
    }

    public static CY A05(C1417ge c1417ge, TP tp, InterfaceC1372fv interfaceC1372fv) {
        if (!C0871Up.A2m(c1417ge) || interfaceC1372fv == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return AbstractC1413ga.A00().A00(c1417ge, tp, interfaceC1372fv, WI.A04(c1417ge), new ZW(new WA(c1417ge, A06(0, 0, 9), null, EnumC0896Vq.A08, 0, new C0900Vu(), AbstractC0948Xt.A01(C0871Up.A0N(c1417ge)), null, null, new C1540ij()), c1417ge), C1411gY.A00().A00());
    }

    public static void A08() {
        AbstractC0904Vy.A05(A06(30, 28, 52), A06(0, 24, 99), A06(24, 6, 68));
    }

    public static void A09(C1417ge c1417ge, SR sr) {
        if (!C0871Up.A1r(c1417ge) || sr == null) {
            return;
        }
        SP.A00().A00(sr, c1417ge);
    }

    public static void A0A(C1417ge c1417ge, CY cy) {
        if (!C0871Up.A0m(c1417ge) || cy == null) {
            return;
        }
        new C0816Sm(c1417ge, cy, new C0817Sn(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C1417ge c1417ge, CY cy) {
        if (cy == null) {
            return;
        }
        AbstractC0875Ut.A00(c1417ge, cy);
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final VA A6n(C1417ge c1417ge) {
        return WW.A01(c1417ge);
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized T9 A74(T8 t8) {
        if (this.A02 == null) {
            this.A02 = new C0987Zg(this);
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized T1 A7G() {
        if (this.A01 == null) {
            this.A01 = new C1422gj();
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized TP A7l(T8 t8) {
        if (this.A03 == null) {
            this.A03 = A01(t8.A02());
        }
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized InterfaceC0832Tc A7n(T8 t8) {
        return new C1315f0(t8);
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized TB A7x(final T8 t8) {
        return new AbstractC1119bo(t8) { // from class: com.facebook.ads.redexgen.X.72
            @Override // com.facebook.ads.redexgen.core.TB
            public final boolean A9m() {
                return TextureViewSurfaceTextureListenerC0421Cz.A09();
            }

            @Override // com.facebook.ads.redexgen.core.TB
            public final void ACP() {
                U2.A06(C0794Rp.A09(super.A00));
            }

            @Override // com.facebook.ads.redexgen.core.TB
            public final void ACn() {
                U2.A07(C0794Rp.A09(super.A00));
            }

            @Override // com.facebook.ads.redexgen.core.TB
            public final void ADI(C1417ge c1417ge) {
                OP.A01(c1417ge);
            }
        };
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized InterfaceC0651Lx A8C(T8 t8) {
        if (!C0871Up.A13(t8)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = AbstractC0652Ly.A00().A00(new C1083bE(t8));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized TD A8y(T8 t8) {
        return new C1057ao(t8);
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final C1417ge A8z(Context context) {
        C1417ge sdkContext = T7.A00();
        if (sdkContext == null) {
            C1417ge sdkContext2 = new C1417ge(context, this);
            T7.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized VM A90(C1417ge c1417ge) {
        if (this.A05 == null) {
            this.A05 = new XP(c1417ge);
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.TA
    public final synchronized U7 A96() {
        if (this.A04 == null) {
            this.A04 = new U7();
            A08();
        }
        return this.A04;
    }
}
