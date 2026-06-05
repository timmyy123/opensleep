package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L7 {
    public static String[] A08 = {"C4diU0jF5HFDKOo", "VIjpOvF", "79HwagMXBprlpWu", "XtcHcpqmD0hF0uYglpDGiCUjQ", "b5FzuRibdN76veNUTRkVPezKuChwyeRa", "N5rSQt9O61BKPKT7czdchdAeeSshGZI7", "4j3xcnZH", "5T71Z7kL4B4E0IfY6yh9iA0vCqeGrORl"};
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final C02274u A05 = new C02274u(new byte[64]);
    public final AnonymousClass53 A06;
    public final InterfaceC0623Kv A07;

    public L7(InterfaceC0623Kv interfaceC0623Kv, AnonymousClass53 anonymousClass53) {
        this.A07 = interfaceC0623Kv;
        this.A06 = anonymousClass53;
    }

    private void A00() {
        this.A05.A09(8);
        this.A03 = this.A05.A0H();
        this.A02 = this.A05.A0H();
        this.A05.A09(6);
        this.A00 = this.A05.A04(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A05.A09(4);
            long pts = ((long) this.A05.A04(3)) << 30;
            this.A05.A09(1);
            long pts2 = pts | ((long) (this.A05.A04(15) << 15));
            this.A05.A09(1);
            long pts3 = pts2 | ((long) this.A05.A04(15));
            this.A05.A09(1);
            if (!this.A04) {
                boolean z = this.A02;
                String[] strArr = A08;
                if (strArr[2].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[2] = "5JhR9Zg0WmWGqTK";
                strArr2[0] = "Xh2Ow42d4ocIa9L";
                if (z) {
                    this.A05.A09(4);
                    long jA04 = ((long) this.A05.A04(3)) << 30;
                    this.A05.A09(1);
                    long jA042 = jA04 | ((long) (this.A05.A04(15) << 15));
                    this.A05.A09(1);
                    long jA043 = jA042 | ((long) this.A05.A04(15));
                    this.A05.A09(1);
                    if (A08[3].length() != 3) {
                        String[] strArr3 = A08;
                        strArr3[2] = "UDMLuQZN0eWx6zw";
                        strArr3[0] = "a17qMMuziGA5O0G";
                        this.A06.A06(jA043);
                        this.A04 = true;
                    } else {
                        String[] strArr4 = A08;
                        strArr4[2] = "zPtJRCJUDuumy6c";
                        strArr4[0] = "cIaKenGO0crEC3t";
                        this.A06.A06(jA043);
                        this.A04 = true;
                    }
                }
            }
            this.A01 = this.A06.A06(pts3);
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A07.AJ5();
    }

    public final void A03(C02284v c02284v) throws C3K {
        c02284v.A0k(this.A05.A00, 0, 3);
        this.A05.A08(0);
        A00();
        c02284v.A0k(this.A05.A00, 0, this.A00);
        this.A05.A08(0);
        A01();
        this.A07.AGq(this.A01, 4);
        this.A07.A5A(c02284v);
        this.A07.AGp();
    }
}
