package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1693lP implements LE {
    public static byte[] A02;
    public static String[] A03 = {"H5L2tIFZt", "7T8ctTOgfri2uFWYkrl4fLjFw3zYZmyw", "rpSuNqLmPSNrp8BaktpsZc4frut4njZi", "OS1ujTmztQNXT6hqD6nsoX0kfRSYmmsY", "PkY6KfFeVbpCvwlFdEj", "TmaVkoyYGnCbszGh0vcMc", "p0AihzwiszaEN", "o1l4pHohEGjnpBhSGl6NtukXiQnI0CCo"};
    public final int A00;
    public final List<C1981qI> A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private List<C1981qI> A03(LD ld) {
        String strA02;
        int i;
        if (A05(32)) {
            return this.A01;
        }
        C02284v c02284v = new C02284v(ld.A03);
        List<C1981qI> arrayList = this.A01;
        while (c02284v.A07() > 0) {
            int iA0I = c02284v.A0I();
            int iA09 = c02284v.A09() + c02284v.A0I();
            if (iA0I == 134) {
                arrayList = new ArrayList<>();
                int iA0I2 = c02284v.A0I() & 31;
                for (int i2 = 0; i2 < iA0I2; i2++) {
                    String strA0W = c02284v.A0W(3);
                    int iA0I3 = c02284v.A0I();
                    boolean z = (iA0I3 & 128) != 0;
                    if (z) {
                        strA02 = A02(19, 19, 47);
                        i = iA0I3 & 63;
                    } else {
                        strA02 = A02(0, 19, 57);
                        i = 1;
                    }
                    byte bA0I = (byte) c02284v.A0I();
                    c02284v.A0g(1);
                    List<byte[]> listA04 = null;
                    if (z) {
                        boolean z2 = (bA0I & 64) != 0;
                        if (A03[5].length() != 21) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[6] = "Fx9tcNCtSciYr";
                        strArr[4] = "fWuzF8xs7o61BMX22RC";
                        listA04 = AnonymousClass46.A04(z2);
                    }
                    arrayList.add(new C01722p().A11(strA02).A10(strA0W).A0Z(i).A12(listA04).A14());
                }
            }
            c02284v.A0f(iA09);
        }
        return arrayList;
    }

    public static void A04() {
        A02 = new byte[]{-30, -15, -15, -19, -22, -28, -30, -11, -22, -16, -17, -80, -28, -26, -30, -82, -73, -79, -71, -40, -25, -25, -29, -32, -38, -40, -21, -32, -26, -27, -90, -38, -36, -40, -92, -82, -89, -81, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, 27, 23, 20, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 20, 26, 25, -38, 33, 25, 15, -39, 15, 33, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -39, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, 31, -61, -46, -46, -50, -53, -59, -61, -42, -53, -47, -48, -111, -38, -113, -43, -59, -42, -57, -107, -105};
    }

    static {
        A04();
    }

    public C1693lP() {
        this(0);
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public C1693lP(int i) {
        this(i, MetaExoPlayerCustomizedCollections.A03(new C1981qI[0]));
    }

    public C1693lP(int i, List<C1981qI> list) {
        this.A00 = i;
        this.A01 = list;
    }

    private L9 A00(LD ld) {
        return new L9(A03(ld));
    }

    private LJ A01(LD ld) {
        return new LJ(A03(ld));
    }

    private boolean A05(int i) {
        return (this.A00 & i) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final SparseArray<LH> A5Q() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final LH A5V(int i, LD ld) {
        switch (i) {
            case 2:
            case 128:
                return new C1682lE(new C1690lM(A01(ld)));
            case 3:
            case 4:
                return new C1682lE(new C1684lG(ld.A01));
            case 15:
                if (A05(2)) {
                    return null;
                }
                return new C1682lE(new C1694lQ(false, ld.A01));
            case 16:
                return new C1682lE(new C1689lL(A01(ld)));
            case 17:
                if (A05(2)) {
                    return null;
                }
                return new C1682lE(new C1685lH(ld.A01));
            case 21:
                return new C1682lE(new C1686lI());
            case 27:
                if (A05(4)) {
                    return null;
                }
                return new C1682lE(new C1688lK(A00(ld), A05(1), A05(8)));
            case 36:
                return new C1682lE(new C1687lJ(A00(ld)));
            case 89:
                return new C1682lE(new C1691lN(ld.A02));
            case 129:
            case 135:
                return new C1682lE(new C1700lW(ld.A01));
            case 130:
                if (!A05(64)) {
                    return null;
                }
                break;
            case 134:
                if (A05(16)) {
                    return null;
                }
                return new C1677l9(new C1683lF(A02(61, 20, 26)));
            case 138:
                break;
            case 172:
                return new C1682lE(new C1697lT(ld.A01));
            case 257:
                return new C1677l9(new C1683lF(A02(38, 23, 99)));
            default:
                return null;
        }
        return new C1682lE(new C1692lO(ld.A01));
    }
}
