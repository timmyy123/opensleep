package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1206dD {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1205dC>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1205dC>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1205dC A01(C1421gi c1421gi, AbstractC1586jd abstractC1586jd, int i, InterfaceC1203dA interfaceC1203dA) {
        C1205dC c1205dC = new C1205dC(c1421gi, abstractC1586jd, c1421gi.A02().A0A(), i);
        c1205dC.A0b(interfaceC1203dA);
        c1205dC.A0X();
        A01.put(abstractC1586jd.A1D(), new WeakReference<>(c1205dC));
        return c1205dC;
    }

    public static C1205dC A02(String str) {
        WeakReference<C1205dC> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1586jd abstractC1586jd, C1205dC c1205dC) {
        A01.put(abstractC1586jd.A1D(), new WeakReference<>(c1205dC));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
