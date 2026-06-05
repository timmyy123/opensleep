package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1834nt implements DT {
    public static String[] A03 = {"SXf2ikyU7x67I20o8i24dVpGUFSBqQTw", "mkUiuiIj8yhWc2", "ZVpzrzkkS3TCIC8ssuB1q665Cly", "AyVvw5Y1t2x", "iglXNLTRJoy", "iTKB7JlXxZgW", "zcduVvETVwMCfQslxyZfhoZ", "8SZ4gfyzqyWZuyWUMuDO3PJ5JnvEF7yK"};
    public boolean A00;
    public final DT A01;
    public final /* synthetic */ C9v A02;

    public C1834nt(C9v c9v, DT dt) {
        this.A02 = c9v;
        this.A01 = dt;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final boolean AAe() {
        if (!this.A02.A03()) {
            boolean zAAe = this.A01.AAe();
            String[] strArr = A03;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "tfusTrbeCFgw";
            strArr2[6] = "N1qkw3c8e5Hqf14VA9IMw1Y";
            if (zAAe) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final void ACR() throws IOException {
        this.A01.ACR();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        if (r3 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f7, code lost:
    
        if (r3 == false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    @Override // com.facebook.ads.redexgen.core.DT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int AHP(C02846z c02846z, C1902p0 c1902p0, int i) {
        int encoderPadding;
        if (this.A02.A03()) {
            return -3;
        }
        if (this.A00) {
            c1902p0.A02(4);
            return -4;
        }
        int iAHP = this.A01.AHP(c02846z, c1902p0, i);
        if (iAHP == -5) {
            Object objA01 = AbstractC02053y.A01(c02846z.A00);
            if (A03[1].length() == 3) {
                throw new RuntimeException();
            }
            A03[1] = "CgcnacS";
            C1981qI c1981qI = (C1981qI) objA01;
            int result = c1981qI.A08;
            if (result == 0) {
                int result2 = c1981qI.A09;
                if (result2 != 0) {
                    long j = this.A02.A01;
                    String[] strArr = A03;
                    String str = strArr[3];
                    String str2 = strArr[4];
                    int length = str.length();
                    int result3 = str2.length();
                    if (length != result3) {
                        String[] strArr2 = A03;
                        strArr2[3] = "GNrNzPSs5rG";
                        strArr2[4] = "BRLad8Ppi7x";
                        encoderPadding = j != 0 ? 0 : c1981qI.A08;
                    } else {
                        String[] strArr3 = A03;
                        strArr3[7] = "EEmKLcyNYLT06pocayZ2GsCLcCuyLxXc";
                        strArr3[0] = "iurrvyyHueo7iqPuT2paMo28xJltVQ5w";
                        if (j != 0) {
                        }
                    }
                    c02846z.A00 = c1981qI.A07().A0d(encoderPadding).A0e(this.A02.A00 == Long.MIN_VALUE ? c1981qI.A09 : 0).A14();
                }
            }
            return -5;
        }
        if (this.A02.A00 != Long.MIN_VALUE) {
            if (iAHP != -4 || c1902p0.A01 < this.A02.A00) {
                if (iAHP == -3 && this.A02.A78() == Long.MIN_VALUE) {
                    boolean z = c1902p0.A04;
                    if (A03[2].length() != 27) {
                        String[] strArr4 = A03;
                        strArr4[7] = "1nwlHryK5EDeU2ZU0H4BcQJbxB1i4Ihb";
                        strArr4[0] = "uJ2uSAytr2SiAHwLxUdt9xnwmqCI2wHf";
                    } else {
                        String[] strArr5 = A03;
                        strArr5[5] = "inKi0NPX9S85";
                        strArr5[6] = "FN6Cq4NmwdrKNoi6ofH3HqR";
                    }
                }
            }
            c1902p0.A0A();
            c1902p0.A02(4);
            this.A00 = true;
            return -4;
        }
        return iAHP;
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final int AK2(long j) {
        if (this.A02.A03()) {
            return -3;
        }
        return this.A01.AK2(j);
    }
}
