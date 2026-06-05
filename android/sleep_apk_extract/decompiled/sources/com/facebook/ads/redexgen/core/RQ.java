package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RQ {
    public int A00;
    public C0776Qx A01;
    public C0776Qx A02;
    public static String[] A04 = {"3L5xTrYaZHGbjsCndSxeOQfzJoqaksAO", "yNuit7zcaXLgcR4Esus3jmJQTJqqE", "DjfkS9z5OPUyV9QdiCBZ1KUSwMFmGRPN", "lc54RdKLiwdhlc59ssIRjbGGERTX6o9W", "6o2d", "DSh0O66K0UoAsbtG5khJTMnGYv0IzoNn", "Wt9X6yajIBXU34hiGluB33HbNXSszdRF", "6wPar1yvZmOBSMEilq5oC74eJWuAafP4"};
    public static PD<RQ> A03 = new C1504i6(20);

    public static RQ A00() {
        RQ rqA3B = A03.A3B();
        if (A04[5].charAt(2) == 'q') {
            throw new RuntimeException();
        }
        A04[5] = "RnCaU2E938mENSzRzPrAuXo67ZnkzA8g";
        RQ record = rqA3B;
        return record == null ? new RQ() : record;
    }

    public static void A01() {
        while (A03.A3B() != null) {
        }
    }

    public static void A02(RQ rq) {
        rq.A00 = 0;
        rq.A02 = null;
        rq.A01 = null;
        A03.AHf(rq);
    }
}
