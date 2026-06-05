package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Build;
import android.widget.RelativeLayout;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0788Rj {
    public static byte[] A04;
    public static String[] A05 = {"MJXAzUwyiLvMzZCrP1QJf8uMs9b", "sHuNTXgsBnW3HGqskl7KH5QkikNWpABj", "q8u9vKEVkpk3dMxroB1EFzM5kwDKfJOq", "eyGwnlQBA4bCraIcft5FxvFgN7f8TC5N", "FmmRYKiwjJl3dX1FB2pV6kIWJpsNLC6h", "flBitaWG3wpDSjkerYNuTkR3r5UhRox3", "xkUQOvOGGj42jMnQjSDdoLzQvdQiYUba", "XqZ9VL6XKZ5Y"};
    public final Intent A00;
    public final C0783Re A01;
    public final C1421gi A02;
    public final VA A03;

    public static String A0K(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0L() {
        A04 = new byte[]{99, 127, 4, 1, 58, 1, 4, 17, 4, 58, 7, 16, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1, 9, 0, 43, 41, 36, 36, 45, 58, 28, 49, 56, 45, 119, 124, 117, 125, 122, 113, 112, 85, 112, 80, 117, 96, 117, 86, 97, 122, 112, 120, 113, 35, 44, 41, 49, 32, 55, 32, 33, 26, 38, 41, 44, 38, 46, 26, 33, 32, 41, 36, 60, 26, 40, 54, 123, 97, 77, 100, 32, 77, 118, 119, 97, 123, 117, 124, 116, 123, 110, 115, 108, 127, 91, 126, 94, 123, 110, 123, 88, 111, 116, 126, 118, 127, 32, 55, 37, 51, 32, 54, 55, 54, 4, 59, 54, 55, 61, 19, 54, 22, 51, 38, 51, 16, 39, 60, 54, 62, 55, 22, 9, 4, 5, 15, 63, 20, 9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 5, 63, 16, 15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 63, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 20, 5, 18, 22, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ};
    }

    static {
        A0L();
    }

    public C0788Rj(C0783Re c0783Re, Intent intent, VA va, C1421gi c1421gi) {
        this.A01 = c0783Re;
        this.A00 = intent;
        this.A03 = va;
        this.A02 = c1421gi;
    }

    private AbstractC1586jd A00() {
        int i = Build.VERSION.SDK_INT;
        String strA0K = A0K(80, 18, 33);
        if (i >= 33) {
            return (AbstractC1586jd) this.A00.getSerializableExtra(strA0K, AbstractC1586jd.class);
        }
        Intent intent = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
            throw new RuntimeException();
        }
        A05[1] = "LmjecX6z1NXmevkMdudhCsYVgseeBlBL";
        return (AbstractC1586jd) intent.getSerializableExtra(strA0K);
    }

    private C1580jT A01() {
        int i = Build.VERSION.SDK_INT;
        String strA0K = A0K(26, 19, 47);
        if (i >= 33) {
            return (C1580jT) this.A00.getSerializableExtra(strA0K, C1580jT.class);
        }
        return (C1580jT) this.A00.getSerializableExtra(strA0K);
    }

    private C02987n A02() {
        int i = Build.VERSION.SDK_INT;
        String strA0K = A0K(2, 14, 94);
        if (i >= 33) {
            return (C02987n) this.A00.getSerializableExtra(strA0K, C02987n.class);
        }
        return (C02987n) this.A00.getSerializableExtra(strA0K);
    }

    private C02967l A03() {
        int i = Build.VERSION.SDK_INT;
        String strA0K = A0K(98, 25, 105);
        if (i >= 33) {
            return (C02967l) this.A00.getSerializableExtra(strA0K, C02967l.class);
        }
        return (C02967l) this.A00.getSerializableExtra(strA0K);
    }

    private InterfaceC0963Yi A05() {
        boolean booleanExtra = this.A00.getBooleanExtra(A0K(68, 12, 41), false);
        boolean isV2Design = C0871Up.A2w(this.A02);
        if (isV2Design) {
            String stringExtra = this.A00.getStringExtra(A0K(45, 23, 126));
            C0783Re c0783Re = this.A01;
            C1421gi c1421gi = this.A02;
            VA va = this.A03;
            C1467hS c1467hS = new C1467hS(this.A01);
            String stringExtra2 = this.A00.getStringExtra(A0K(16, 10, 115));
            if (stringExtra == null) {
                stringExtra = A0K(0, 2, 117);
            }
            int i = Integer.parseInt(stringExtra);
            String clickDelayMs = A05[5];
            if (clickDelayMs.charAt(3) != 'i') {
                throw new RuntimeException();
            }
            A05[4] = "YY09SF1W0j6b6KfCSgRusx8TJPca7HgC";
            return new ViewOnClickListenerC02826x(c0783Re, c1421gi, va, c1467hS, stringExtra2, i);
        }
        return new PZ(this.A01, this.A02, this.A03, new C1467hS(this.A01), booleanExtra);
    }

    private InterfaceC0963Yi A06() {
        C02987n c02987nA02 = A02();
        if (c02987nA02 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), c02987nA02, c02987nA02.A1G(), new MH());
    }

    private InterfaceC0963Yi A07() {
        C02967l c02967lA03 = A03();
        if (c02967lA03 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), c02967lA03, c02967lA03.A1G(), new MG());
    }

    private InterfaceC0963Yi A08(InterfaceC0962Yh interfaceC0962Yh, AbstractC1586jd abstractC1586jd, String str, ZU zu) {
        if (abstractC1586jd.A29().A0H().A07() != null) {
            C0693No c0693NoA07 = abstractC1586jd.A29().A0H().A07();
            if (abstractC1586jd.A1n()) {
                return new MW(this.A02, this.A03, interfaceC0962Yh, abstractC1586jd, c0693NoA07, str, zu);
            }
            return new NO(this.A02, this.A03, interfaceC0962Yh, abstractC1586jd, str, zu);
        }
        interfaceC0962Yh.A4j(zu.A81());
        interfaceC0962Yh.A4j(zu.A7w());
        return null;
    }

    private PJ A09(WK wk) {
        AbstractC1586jd abstractC1586jdA02;
        if (wk == WK.A0G) {
            abstractC1586jdA02 = A03();
            String[] strArr = A05;
            if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "BHjTvXd0Vicw2MzqRZQvpavg35ntNS6w";
            strArr2[2] = "NWBwsXtlP0iXXM4o1NBUiSzzY7vvtUxs";
            if (abstractC1586jdA02 == null) {
                return null;
            }
        } else if (wk != WK.A0A || (abstractC1586jdA02 = A02()) == null) {
            return null;
        }
        abstractC1586jdA02.A1L(this.A01.A08());
        if (abstractC1586jdA02.A1a()) {
            return new C4U(this.A02, this.A03, new C0827Sx(this.A02), new C1467hS(this.A01), abstractC1586jdA02);
        }
        return new C4T(this.A02, this.A03, new C0827Sx(this.A02), new C1467hS(this.A01), abstractC1586jdA02);
    }

    private final MT A0A() {
        return new MT(this.A02, this.A01);
    }

    private MI A0B(RelativeLayout relativeLayout) {
        MI mi = new MI(this.A02, new C1466hR(this), this.A03, new C1467hS(this.A01));
        mi.A05(relativeLayout);
        mi.A04(this.A00.getIntExtra(A0K(123, 27, 91), 200));
        YB.A0N(relativeLayout, Color.BLACK);
        return mi;
    }

    private AnonymousClass66 A0C() {
        C02987n c02987nA02 = A02();
        if (c02987nA02 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1467hS(this.A01), c02987nA02, new MH(), 1);
    }

    private AnonymousClass66 A0D() {
        C02967l c02967lA03 = A03();
        if (c02967lA03 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1467hS(this.A01), c02967lA03, new MG(), 0);
    }

    private JD A0E() {
        C1205dC c1205dCA02;
        AbstractC1586jd abstractC1586jdA00 = A00();
        if (abstractC1586jdA00 == null || (c1205dCA02 = AbstractC1206dD.A02(abstractC1586jdA00.A1D())) == null) {
            return null;
        }
        return new JD(this.A02, new C1467hS(this.A01), c1205dCA02, abstractC1586jdA00.A2E());
    }

    private C0503Ge A0F(WK wk) {
        ZU mg;
        InterfaceC0962Yh anonymousClass77;
        C1580jT c1580jTA01 = A01();
        if (c1580jTA01 == null) {
            return null;
        }
        if (wk == WK.A04) {
            mg = new MH();
            anonymousClass77 = new C1467hS(this.A01);
        } else {
            mg = new MG();
            anonymousClass77 = new AnonymousClass77(this.A01);
        }
        return new C0503Ge(this.A02, mg, this.A03, c1580jTA01, new C0827Sx(this.A02), anonymousClass77);
    }

    private C02304x A0G() {
        C02987n c02987nA02 = A02();
        if (c02987nA02 != null) {
            return new C02304x(this.A02, new MH(), this.A03, c02987nA02, new C0827Sx(this.A02), new C1467hS(this.A01));
        }
        if (A05[1].charAt(5) != 'X') {
            throw new RuntimeException();
        }
        A05[3] = "TvLwsmu9uaa0faVP4fF8b7PGg31O8U7I";
        return null;
    }

    private C4V A0H() {
        C02987n c02987nA02 = A02();
        if (c02987nA02 == null) {
            return null;
        }
        return new C4V(this.A02, new MH(), this.A03, c02987nA02, new C0827Sx(this.A02), new C1467hS(this.A01));
    }

    private C4V A0I() {
        C02967l c02967lA03 = A03();
        if (c02967lA03 == null) {
            return null;
        }
        return new C4V(this.A02, new MG(), this.A03, c02967lA03, new C0827Sx(this.A02), new AnonymousClass77(this.A01));
    }

    private GB A0J(WK wk) {
        AbstractC1586jd abstractC1586jdA02;
        AbstractC1586jd abstractC1586jdA022;
        if (wk == WK.A0J) {
            abstractC1586jdA02 = A03();
            if (abstractC1586jdA02 == null || (abstractC1586jdA022 = A03()) == null) {
                return null;
            }
        } else if (wk != WK.A0E || (abstractC1586jdA02 = A02()) == null || (abstractC1586jdA022 = A02()) == null) {
            return null;
        }
        return new GB(this.A02, this.A03, abstractC1586jdA02, abstractC1586jdA022, new AnonymousClass77(this.A01), this.A01, wk);
    }

    public final InterfaceC0963Yi A0M(WK wk, RelativeLayout relativeLayout) {
        if (wk == null) {
            return null;
        }
        switch (C0787Ri.A00[wk.ordinal()]) {
            case 1:
                if (relativeLayout != null) {
                    return A0B(relativeLayout);
                }
                return null;
            case 2:
            case 3:
                return A09(wk);
            case 4:
                return A0I();
            case 5:
                return A07();
            case 6:
                InterfaceC0963Yi interfaceC0963YiA05 = A05();
                if (A05[4].charAt(13) != '3') {
                    A05[1] = "IIJ0HXviRARge0yizoGTY0JUA2Nzjczv";
                    return interfaceC0963YiA05;
                }
                String[] strArr = A05;
                strArr[6] = "UHMFNKnwuKHYyMbevaCPtufG1H9dhH1t";
                strArr[2] = "s6UgSHR7PtydXMVItCKPjBxPhDp7nABU";
                return interfaceC0963YiA05;
            case 7:
                return A0H();
            case 8:
                return A0G();
            case 9:
                return A06();
            case 10:
                return A0E();
            case 11:
                AnonymousClass66 anonymousClass66A0C = A0C();
                if (A05[5].charAt(3) != 'i') {
                    throw new RuntimeException();
                }
                A05[3] = "7AQwH6OZkLua7JLoKEhUfmskdEmJStMK";
                return anonymousClass66A0C;
            case 12:
                return A0D();
            case 13:
            case 14:
                return A0F(wk);
            case 15:
                return A0A();
            case 16:
            case 17:
                return A0J(wk);
            default:
                return null;
        }
    }
}
