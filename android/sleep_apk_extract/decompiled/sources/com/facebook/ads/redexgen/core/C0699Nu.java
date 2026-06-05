package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0699Nu {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public C0827Sx A00;
    public EnumC1082bD A01 = EnumC1082bD.A05;
    public ArrayList<C1205dC> A02 = new ArrayList<>();
    public final NQ A03;
    public final InterfaceC0698Nt A04;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, 23, 35, 28, 27, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, 21, 24, 19, 24, 21, 40, 21, 19, 22, 41, 34, 24, 32, 25, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, 18, 23, 16, 24, 29, 20, 19, -16, 19, -13, 16, 35, 16, -15, 36, 29, 19, 27, 20, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public C0699Nu(C1421gi c1421gi, O8 o8, InterfaceC0698Nt interfaceC0698Nt, String str) {
        JSONObject dataObject = o8.A03();
        this.A03 = A01(c1421gi, o8, str, dataObject);
        this.A04 = interfaceC0698Nt;
    }

    private AdError A00(C1421gi c1421gi, AbstractC1586jd abstractC1586jd) {
        if (abstractC1586jd == null || abstractC1586jd.A2G().isEmpty()) {
            c1421gi.A08().ABC(A04(62, 3, 33), AbstractC0833Td.A0Z, new C0834Te(A04(5, 43, 20)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static NQ A01(C1421gi c1421gi, O8 o8, String str, JSONObject jSONObject) {
        NQ nqA00 = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                nqA00 = C1580jT.A01(jSONObject, c1421gi, true);
                nqA00.A1Q(true);
                nqA00.A1N(A04(96, 12, 117));
            } catch (JSONException unused) {
            }
        }
        if (nqA00 == null) {
            nqA00 = C02987n.A00(jSONObject, c1421gi);
        }
        nqA00.A1M(str);
        C0853Tx c0853TxA01 = o8.A01();
        if (c0853TxA01 != null) {
            nqA00.A1I(c0853TxA01.A06());
        }
        return nqA00;
    }

    private C0827Sx A03(C1421gi c1421gi) {
        return this.A00 != null ? this.A00 : new C0827Sx(c1421gi);
    }

    private void A08(C1421gi c1421gi, C02987n c02987n) {
        C0693No playableData = c02987n.A29().A0H().A07();
        A0B(playableData != null ? playableData.A0H() : EnumC1082bD.A05);
        C1566jC c1566jC = new C1566jC(this);
        C0827Sx c0827Sx = new C0827Sx(c1421gi);
        boolean z = C0871Up.A2H(c1421gi) && SN.A0A(c02987n.A1H());
        if (z) {
            SN unifiedAssetsLoader = new SN(c0827Sx, c02987n.A1H(), c02987n.A10(), c02987n.A1D(), z, new C1565jB(this));
            c0827Sx.A0e(new VI(c02987n.A2E(), c1421gi.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        O5.A02(c1421gi, c02987n, true, c1566jC);
    }

    private void A09(C1421gi c1421gi, EnumSet<CacheFlag> enumSet, AbstractC1586jd abstractC1586jd, int i, InterfaceC0698Nt interfaceC0698Nt) {
        boolean isDSL = abstractC1586jd.A1g();
        C0827Sx c0827SxA03 = A03(c1421gi);
        c0827SxA03.A0e(new VI(abstractC1586jd.A2E(), c1421gi.A0A()));
        boolean z = C0871Up.A2H(c1421gi) && SN.A0A(abstractC1586jd.A1H());
        if (z) {
            new SN(c0827SxA03, abstractC1586jd.A1H(), abstractC1586jd.A10(), abstractC1586jd.A1D(), z, new C1569jF(this, c1421gi, isDSL, abstractC1586jd, interfaceC0698Nt)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 117);
        if (isDSL) {
            C0823St c0823St = new C0823St(abstractC1586jd.A0x(), abstractC1586jd.A1D(), strA04);
            c0823St.A04 = true;
            c0823St.A03 = A04(0, 5, 78);
            c0827SxA03.A0Y(c0823St);
        }
        c0827SxA03.A0d(new C0825Sv(abstractC1586jd.A2C().A01(), C1258e4.A04, C1258e4.A04, abstractC1586jd.A1D(), A04(96, 12, 117)));
        boolean isUnifiedAssetsLoaderEnabled = enumSet.contains(CacheFlag.VIDEO);
        int i2 = 0;
        boolean zA30 = C0871Up.A30(c1421gi, C1348fX.A03());
        for (NR nr : abstractC1586jd.A2G()) {
            C0825Sv c0825Sv = new C0825Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), abstractC1586jd.A1D(), A04(96, 12, 117));
            if (i2 == 0) {
                c0827SxA03.A0c(c0825Sv);
            } else {
                c0827SxA03.A0d(c0825Sv);
            }
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c0827SxA03.A0d(new C0825Sv(it.next(), -1, -1, abstractC1586jd.A1D(), A04(96, 12, 117)));
            }
            if (isUnifiedAssetsLoaderEnabled && !TextUtils.isEmpty(nr.A0H().A09())) {
                C0823St c0823St2 = new C0823St(nr.A0H().A09(), abstractC1586jd.A1D(), A04(96, 12, 117), nr.A0H().A06());
                c0823St2.A04 = false;
                if (i2 == 0) {
                    if (isDSL && !zA30) {
                        c0827SxA03.A0Y(c0823St2);
                    } else {
                        c0827SxA03.A0b(c0823St2);
                    }
                } else if (isDSL && !zA30) {
                    c0827SxA03.A0Z(c0823St2);
                } else {
                    c0827SxA03.A0a(c0823St2);
                }
            }
            i2++;
        }
        if (abstractC1586jd.A1W() && !TextUtils.isEmpty(abstractC1586jd.A11())) {
            c0827SxA03.A0d(new C0825Sv(abstractC1586jd.A11(), C0735Pe.A0A, C0735Pe.A0A, abstractC1586jd.A1D(), A04(96, 12, 117)));
        }
        O0.A00(abstractC1586jd, c0827SxA03, strA04);
        c0827SxA03.A0X(new C1567jD(this, c1421gi, isDSL, abstractC1586jd, interfaceC0698Nt), new C0820Sq(abstractC1586jd.A1D(), strA04, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1421gi c1421gi, EnumSet<CacheFlag> enumSet, C1580jT c1580jT, AbstractC1586jd abstractC1586jd, int i, InterfaceC0698Nt interfaceC0698Nt) {
        A09(c1421gi, enumSet, abstractC1586jd, i, new C1571jH(this, c1421gi, abstractC1586jd, c1580jT, i, interfaceC0698Nt, enumSet));
    }

    private void A0B(EnumC1082bD enumC1082bD) {
        this.A01 = enumC1082bD;
    }

    private boolean A0C(C1421gi c1421gi, AbstractC1586jd abstractC1586jd) {
        AdError adErrorA00 = A00(c1421gi, abstractC1586jd);
        if (adErrorA00 != null) {
            this.A04.ACo(adErrorA00);
            return true;
        }
        return false;
    }

    public final NQ A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        return com.facebook.ads.redexgen.core.WK.A0C;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WK A0E() {
        if (this.A03.A1b()) {
            return WK.A04;
        }
        AbstractC1586jd abstractC1586jd = (AbstractC1586jd) this.A03;
        if (abstractC1586jd.A1g()) {
            return WK.A06;
        }
        if (abstractC1586jd.A2G().size() > 1) {
            return WK.A0A;
        }
        C0693No c0693NoA07 = abstractC1586jd.A29().A0H().A07();
        if (A06[4].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM";
        strArr[3] = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx";
        if (c0693NoA07 != null) {
            if (!abstractC1586jd.A1n()) {
                boolean zA1u = abstractC1586jd.A1u();
                if (A06[0].length() != 2) {
                    String[] strArr2 = A06;
                    strArr2[1] = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ";
                    strArr2[3] = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0";
                }
            }
            return WK.A0E;
        }
        boolean zA0L = A0L(abstractC1586jd);
        if (A06[0].length() == 2) {
            throw new RuntimeException();
        }
        A06[0] = "iDu";
        if (zA0L) {
            return WK.A0D;
        }
        return WK.A0B;
    }

    public final EnumC1082bD A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1b()) {
            return ((C1580jT) this.A03).A2A();
        }
        return ((AbstractC1586jd) this.A03).A2E();
    }

    public final void A0H() {
        this.A04.AKX();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A1K(rewardData);
        this.A03.A1O(str);
        if (A0D().A1b()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C1421gi c1421gi, EnumSet<CacheFlag> enumSet) {
        if (A0E() == WK.A04) {
            C1580jT c1580jT = (C1580jT) this.A03;
            AbstractC1586jd abstractC1586jdA26 = c1580jT.A26();
            if (A0C(c1421gi, abstractC1586jdA26) || abstractC1586jdA26 == null) {
                return;
            }
            this.A04.AHY();
            A0A(c1421gi, enumSet, c1580jT, abstractC1586jdA26, 0, this.A04);
            return;
        }
        AbstractC1586jd abstractC1586jd = (AbstractC1586jd) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c1421gi, abstractC1586jd)) {
            return;
        }
        this.A04.AHY();
        if (A0E() == WK.A0C) {
            C02987n c02987n = (C02987n) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c1421gi, c02987n);
                return;
            } else {
                A08(c1421gi, c02987n);
                return;
            }
        }
        A09(c1421gi, enumSet, (C02987n) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A1U();
    }

    public final boolean A0L(AbstractC1586jd abstractC1586jd) {
        return !TextUtils.isEmpty(abstractC1586jd.A29().A0H().A09());
    }
}
