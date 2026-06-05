package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0913Wh {
    public static String[] A01 = {"0TBfSTrFZZIPTbjcv3YvZ5KQe5wh6M4Z", "Y", "skEIHJjGP8F0E9LHs3c03M6jOmkdnZrb", "lNiM6G1VkMzjPhI0VWbHd", "xoZoqEy9j11lJxTnOEXOmkmQN9dBXrj3", "0lNV7cA9G3CxYQK", "ZSiJ5Be21P36sCEypxWEkyax05PjjigP", "3dFveWP5h629GmfNhsyVO5v38YfKmNKK"};
    public static final ThreadLocal<C0913Wh> A02 = new ThreadLocal<>();
    public final WQ A00 = new WQ();

    public static WQ A00() {
        return A02().A00;
    }

    public static WQ A01(C0912Wg c0912Wg) {
        WQ currentStackTraces = new WQ(A00());
        currentStackTraces.add(c0912Wg);
        return currentStackTraces;
    }

    public static C0913Wh A02() {
        C0913Wh c0913Wh = A02.get();
        if (c0913Wh == null) {
            C0913Wh c0913Wh2 = new C0913Wh();
            A02.set(c0913Wh2);
            return c0913Wh2;
        }
        return c0913Wh;
    }

    public static void A03(AbstractRunnableC0908Wc abstractRunnableC0908Wc) {
        WQ wqA06 = abstractRunnableC0908Wc.A06();
        if (wqA06 != null) {
            WQ createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(wqA06);
        }
    }

    public static void A04(AbstractRunnableC0908Wc abstractRunnableC0908Wc) {
        WQ wqA06 = abstractRunnableC0908Wc.A06();
        if (wqA06 != null) {
            WQ wq = A02().A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[0] = "6tfOksRsBjIBNQljvPHCCYkD1Hr87lb7";
            wq.removeAll(wqA06);
        }
    }
}
