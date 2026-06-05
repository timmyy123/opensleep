package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1135c4 {
    public static String[] A00 = {"e7juOHCMVCS96MucXvvyM5upzpE0CxcL", "6Axk6XM18YFtFlcC0tEdKqjogVlmemrm", "CHYE97fUe", "94l1C", "pvrd7E3JtMrEOvPAC3lcGaqqDdvc2Rnk", "mswd2ljSuB4EOxjza27Iz7krcpdQKmDN", "x2gmwPWroRNX0socjzMaFBH0Y3mBhUE3", "1dJrelJWCcDuEHtNsp3IaM8Oqex3ZZ7a"};

    public static AbstractC1134c3 A00(C1138c7 c1138c7, Bundle bundle, boolean z) {
        AbstractC1134c3 ku;
        c1138c7.A06().A0H().A00(false);
        NR nrA29 = c1138c7.A05().A29();
        double dA00 = AbstractC1125bu.A00(nrA29);
        boolean isWatchAndBrowse = c1138c7.A05().A29().A0T();
        boolean zA06 = AbstractC1125bu.A06(c1138c7.A00(), c1138c7.A01(), dA00);
        AbstractC0673Mt abstractC0673MtA00 = C0674Mu.A00(c1138c7.A06(), c1138c7.A07(), "", XB.A00(c1138c7.A05().A29().A0J().A05()), new HashMap(), c1138c7.A05().A2A());
        boolean z2 = !TextUtils.isEmpty(nrA29.A0H().A09());
        if (C0871Up.A1z(c1138c7.A06())) {
            C1421gi c1421giA06 = c1138c7.A06();
            String[] strArr = A00;
            if (strArr[4].charAt(27) == strArr[6].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[5] = "oHCvC4ERmXYMU8sW9KKIPv7pnY2wXb01";
            strArr2[7] = "G3HUaMks2xBdg2z9mSbIts1gYwx1OgmU";
            c1421giA06.A0B().AKn(c1138c7.A02(), c1138c7.A05().A2E(), z2);
        }
        if (isWatchAndBrowse && (abstractC0673MtA00 instanceof AnonymousClass84)) {
            ku = A01(c1138c7) ? new C0584Ji(c1138c7) : new KE(c1138c7);
        } else if (z2) {
            ku = new C6H(c1138c7);
        } else {
            if (c1138c7.A05().A1c()) {
                return new C0604Kc(c1138c7);
            }
            if (c1138c7.A05().A1j()) {
                ku = new C6K(c1138c7);
            } else if (C0871Up.A2i(c1138c7.A06())) {
                ku = new C6J(c1138c7, zA06);
            } else if (zA06) {
                ku = new KZ(c1138c7, c1138c7.A00() == 2);
            } else {
                ku = new KU(c1138c7, AbstractC1125bu.A04(dA00));
            }
        }
        if (z) {
            ku.A1H(nrA29, c1138c7.A05().A2E(), dA00, bundle);
        }
        return ku;
    }

    public static boolean A01(C1138c7 c1138c7) {
        if (!c1138c7.A05().A1y()) {
            boolean zA1c = c1138c7.A05().A1c();
            String[] strArr = A00;
            if (strArr[4].charAt(27) == strArr[6].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[5] = "BfXu055milBajq8QiXDIPY7ZZDWb7rZy";
            strArr2[7] = "zfsTxDhfKJjHYbZVz1DIv6IoDbSXcVhK";
            if (!zA1c) {
                return false;
            }
        }
        return true;
    }
}
