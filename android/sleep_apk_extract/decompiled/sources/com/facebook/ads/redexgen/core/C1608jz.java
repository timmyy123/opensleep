package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1608jz implements N1, InterfaceC0698Nt {
    public static byte[] A0B;
    public static String[] A0C = {"Tri2", "1D6RXHNY", "CY2J", "FG3HLf7FRck3Q4", "aTw9XxKg19aD2PWH35UjlgQd", "aN0Sboz7ddtAAnQUWG6qQ4oJRDDzSUBt", "pWs", "z"};
    public long A00;
    public RewardData A01;
    public NC A02;
    public ND A03;
    public C0699Nu A04;
    public C1421gi A05;
    public String A06;
    public String A07;
    public String A08;
    public boolean A09;
    public final String A0A = UUID.randomUUID().toString();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0B = new byte[]{-37, -7, 6, -65, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -72, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -7, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -72, -39, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -4, 1, -3, 6, -5, -3, -26, -3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 15, 7, 10, 3, -39, -5, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, -58, -72, -27, -7, 3, -3, -72, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, -3, -72, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, -7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -72, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -65, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -72, 1, 6, -72, 17, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, -72, -39, 6, -4, 10, 7, 1, -4, -27, -7, 6, 1, -2, -3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -58, 16, 5, 4, -72, -2, 1, 4, -3, -58, -16, -20, -21, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 15, 24, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, -8, 15, 30, 33, 25, 28, 21, -55, -48, -35, -50, -48, -46, -29, -40, -27, -40, -29, -24, -1, -9, -10, -5, -13, 6, -5, 1, 0, -42, -13, 6, -13, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 3, 5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 20, -23, 4, -55, -53, -66, -67, -66, -65, -62, -57, -66, -67, -88, -53, -62, -66, -57, -51, -70, -51, -62, -56, -57, -92, -66, -46, -7, -20, -8, -4, -20, -6, -5, -37, -16, -12, -20, -6, -13, -18, -10, -6, -22, -50, -23, 34, 21, 17, 35, 0, 37, 28, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -2, 3, -7, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ};
    }

    static {
        A05();
    }

    private int A00() {
        WindowManager windowManager = (WindowManager) this.A05.getSystemService(A03(194, 6, 65));
        int rotation = windowManager.getDefaultDisplay().getRotation();
        EnumC1082bD enumC1082bDA02 = A02();
        if (enumC1082bDA02 == EnumC1082bD.A05) {
            String[] strArr = A0C;
            String str = strArr[4];
            String str2 = strArr[7];
            int rotation2 = str.length();
            if (rotation2 != str2.length()) {
                String[] strArr2 = A0C;
                strArr2[6] = "b7o";
                strArr2[3] = "Q7inAkPu5HYVeU";
                return -1;
            }
        } else if (enumC1082bDA02 == EnumC1082bD.A03) {
            switch (rotation) {
                case 2:
                case 3:
                    int rotation3 = A0C[1].length();
                    if (rotation3 != 29) {
                        String[] strArr3 = A0C;
                        strArr3[6] = "bcp";
                        strArr3[3] = "BEZRNTMscmchpM";
                        return 8;
                    }
                    break;
                default:
                    return 0;
            }
        } else {
            switch (rotation) {
                case 2:
                    return 9;
                default:
                    String[] strArr4 = A0C;
                    String str3 = strArr4[4];
                    String str4 = strArr4[7];
                    int rotation4 = str3.length();
                    if (rotation4 == str4.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr5 = A0C;
                    strArr5[0] = "VdY7";
                    strArr5[2] = "KFhl";
                    return 1;
            }
        }
        throw new RuntimeException();
    }

    private final WK A01() {
        return this.A04.A0E();
    }

    private EnumC1082bD A02() {
        return this.A04.A0F();
    }

    private void A04() {
        this.A09 = true;
    }

    private void A06(Intent intent) {
        this.A04.A0I(intent, this.A01, C1289ea.A04(this.A01, this.A0A, this.A06));
    }

    private final void A07(C1421gi c1421gi, NC nc, O8 o8, EnumSet<CacheFlag> cacheFlags, String str) {
        C0699Nu c0699Nu = new C0699Nu(c1421gi, o8, this, str);
        NQ nqA0D = c0699Nu.A0D();
        if (C0871Up.A0v(c1421gi) && (nqA0D instanceof AbstractC1586jd) && AbstractC0677Mx.A06(this.A05, AbstractC0677Mx.A01(c1421gi, o8.A03(), ((AbstractC1586jd) nqA0D).A2E()), c1421gi.A0A())) {
            this.A05.A0F().A52();
            this.A02.AEG(this, AdError.NO_FILL);
        } else {
            this.A04 = c0699Nu;
            A08(c0699Nu.A0E());
            c0699Nu.A0J(c1421gi, cacheFlags);
        }
    }

    private void A08(WK wk) {
        if (wk.equals(WK.A04)) {
            this.A05.A0F().AJt(M5.A05);
            return;
        }
        if (wk.equals(WK.A0A)) {
            this.A05.A0F().AJt(M5.A04);
            return;
        }
        if (wk.equals(WK.A0B)) {
            this.A05.A0F().AJt(M5.A0B);
            return;
        }
        if (wk.equals(WK.A0D)) {
            this.A05.A0F().AJt(M5.A0D);
            return;
        }
        if (wk.equals(WK.A0C)) {
            this.A05.A0F().AJt(M5.A0C);
            return;
        }
        if (!wk.equals(WK.A06)) {
            return;
        }
        if (this.A04.A0K()) {
            this.A05.A0F().AJt(M5.A08);
            return;
        }
        if ((A09() instanceof AbstractC1586jd) && this.A04.A0L((AbstractC1586jd) A09())) {
            InterfaceC0647Lt interfaceC0647LtA0F = this.A05.A0F();
            if (A0C[1].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[6] = "5zP";
            strArr[3] = "kcwn0HZtMTZNOx";
            interfaceC0647LtA0F.AJt(M5.A0A);
            return;
        }
        this.A05.A0F().AJt(M5.A09);
    }

    public final NQ A09() {
        return this.A04.A0D();
    }

    public final void A0A(C1421gi c1421gi, NC nc, O8 o8, EnumSet<CacheFlag> enumSet, String str, String str2, RewardData rewardData) {
        this.A05 = c1421gi;
        this.A02 = nc;
        this.A08 = o8.A02();
        this.A06 = this.A08 != null ? this.A08.split(A03(107, 1, 22))[0] : A03(0, 0, 85);
        this.A00 = o8.A00();
        this.A07 = str2;
        this.A01 = rewardData;
        A07(c1421gi, nc, o8, enumSet, str);
    }

    public final boolean A0B() {
        if (!this.A09) {
            if (this.A02 != null) {
                this.A02.AEG(this, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            }
            return false;
        }
        AdActivityIntent adActivityIntentA05 = C0925Wu.A05(this.A05);
        adActivityIntentA05.putExtra(A03(143, 24, 5), A00());
        adActivityIntentA05.putExtra(A03(178, 8, 49), this.A0A);
        adActivityIntentA05.putExtra(A03(132, 11, 76), this.A08);
        adActivityIntentA05.putExtra(A03(167, 11, 51), this.A00);
        WK wkA01 = A01();
        A08(wkA01);
        adActivityIntentA05.putExtra(A03(186, 8, 88), wkA01);
        if (this.A07 != null) {
            adActivityIntentA05.putExtra(A03(119, 13, 62), this.A07);
        }
        A06(adActivityIntentA05);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            String[] strArr = A0C;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "Sc68";
            strArr2[2] = "wieN";
            adActivityIntentA05.addFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        try {
            ActivityUtils.A03(this.A05);
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!C0925Wu.A0I(this.A05, adActivityIntentA05)) {
                    this.A05.A0F().AIC();
                    if (this.A02 != null) {
                        this.A02.AEG(this, AdError.AD_PRESENTATION_ERROR);
                    }
                    return false;
                }
                return true;
            }
            C0925Wu.A0B(this.A05, adActivityIntentA05);
            return true;
        } catch (C0923Ws e) {
            Throwable cause = e.getCause();
            C0923Ws cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            this.A05.A08().ABC(A03(108, 11, 27), AbstractC0833Td.A0D, new C0834Te(cause2));
            Log.e(A03(90, 17, 86), A03(0, 90, 68), cause2);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final String A7O() {
        return this.A04.A0G();
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final AdPlacementType A8k() {
        return AdPlacementType.INTERSTITIAL;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0698Nt
    public final void ACo(AdError adError) {
        if (this.A02 != null) {
            this.A02.AEG(this, adError);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0698Nt
    public final void ACp() {
        A04();
        this.A02.AEF(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0698Nt
    public final void AHY() {
        this.A03 = new ND(this.A05, this.A0A, this, this.A02);
        this.A03.A02();
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final boolean AKL() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0698Nt
    public final void AKX() {
        if (this.A03 != null) {
            ND nd = this.A03;
            String[] strArr = A0C;
            if (strArr[0].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "DiF0";
            strArr2[2] = "lQT3";
            nd.A03();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final void onDestroy() {
        if (this.A04 != null) {
            this.A04.A0H();
        }
    }
}
