package com.facebook.ads.redexgen.core;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0577Jb {
    public static String[] A0D = {"XeH1UKKuz1EDpBeQKhAXaKjrjZgsodJU", "Qh9sfVWsiKdbMkoZ0Fly5mM08PFSskfX", "g5Vgu", "IbV76iHRvjKg6MHaSQGzPOhr6f1ApNQX", "p6vckuBwU2Q2AllMmzSrbAD", "CWShENYx4MqsFhdcA74Ut20lXSF9FxoW", "efy3JamC8vBQUYLSbDR2yGzuJR", "AxMKck"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public HA A06;
    public InterfaceC0528Hd A07;
    public JY A08;
    public boolean A0A;
    public boolean A0B;
    public final JW A0C = new JW();
    public C0576Ja A09 = new C0576Ja();

    public abstract long A09(C02284v c02284v);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean A0C(C02284v c02284v, long j, C0576Ja c0576Ja) throws IOException;

    @RequiresNonNull({"trackOutput"})
    private int A00(InterfaceC1772ms interfaceC1772ms) throws IOException {
        if (A03(interfaceC1772ms)) {
            this.A00 = this.A09.A00.A0G;
            if (!this.A0A) {
                this.A07.A6e(this.A09.A00);
                this.A0A = true;
            }
            JY jy = this.A09.A01;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                throw new RuntimeException();
            }
            A0D[7] = "ikA5IIIrIRBN8L1z";
            if (jy != null) {
                this.A08 = this.A09.A01;
            } else if (interfaceC1772ms.A8O() == -1) {
                this.A08 = new C1724lu();
            } else {
                JX jxA02 = this.A0C.A02();
                this.A08 = new C1730m0(this, this.A04, interfaceC1772ms.A8O(), jxA02.A01 + jxA02.A00, jxA02.A05, (jxA02.A04 & 4) != 0);
            }
            this.A01 = 2;
            this.A0C.A04();
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A01(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        long jAHN = this.A08.AHN(interfaceC1772ms);
        if (jAHN >= 0) {
            hv.A00 = jAHN;
            return 1;
        }
        if (jAHN < -1) {
            if (A0D[1].charAt(30) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[2] = "VTxPX";
            strArr[6] = "vg288hyM3d7P0eFgaD3UTrluSy";
            long position = -(2 + jAHN);
            A0A(position);
        }
        if (!this.A0B) {
            this.A06.AJ7((HY) AbstractC02053y.A02(this.A08.A5Z()));
            this.A0B = true;
        }
        if (this.A03 <= 0 && !this.A0C.A05(interfaceC1772ms)) {
            this.A01 = 3;
            return -1;
        }
        this.A03 = 0L;
        C02284v c02284vA01 = this.A0C.A01();
        long jA09 = A09(c02284vA01);
        if (jA09 >= 0) {
            long j = this.A02 + jA09;
            String[] strArr2 = A0D;
            if (strArr2[2].length() != strArr2[6].length()) {
                A0D[0] = "EPgFULMjpXPDE9er32WaoAxqXEcFdYah";
                if (j >= this.A05) {
                    long position2 = this.A02;
                    long jA05 = A05(position2);
                    this.A07.AIr(c02284vA01, c02284vA01.A0A());
                    this.A07.AIu(jA05, 1, c02284vA01.A0A(), 0, null);
                    this.A05 = -1L;
                }
            } else if (j >= this.A05) {
            }
        }
        this.A02 += jA09;
        return 0;
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void A02() {
        AbstractC02053y.A02(this.A07);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
    private boolean A03(InterfaceC1772ms interfaceC1772ms) throws IOException {
        while (true) {
            JW jw = this.A0C;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                break;
            }
            A0D[7] = "RUb6h5R55PuDixsZqq";
            if (!jw.A05(interfaceC1772ms)) {
                this.A01 = 3;
                return false;
            }
            this.A03 = interfaceC1772ms.A8n() - this.A04;
            if (A0C(this.A0C.A01(), this.A04, this.A09)) {
                long jA8n = interfaceC1772ms.A8n();
                if (A0D[7].length() == 17) {
                    break;
                }
                A0D[0] = "MjaWWlFxdP245keDLyVkXHL1D0C1Hazn";
                this.A04 = jA8n;
            } else {
                return true;
            }
        }
        throw new RuntimeException();
    }

    public final int A04(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                return A00(interfaceC1772ms);
            case 1:
                interfaceC1772ms.AK3((int) this.A04);
                this.A01 = 2;
                return 0;
            case 2:
                return A01(interfaceC1772ms, hv);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A05(long j) {
        return (1000000 * j) / ((long) this.A00);
    }

    public final long A06(long j) {
        return (((long) this.A00) * j) / 1000000;
    }

    public final void A07(long j, long j2) {
        this.A0C.A03();
        if (j == 0) {
            A0B(!this.A0B);
        } else {
            if (this.A01 == 0) {
                return;
            }
            this.A05 = A06(j2);
            ((JY) C5C.A0f(this.A08)).AKC(this.A05);
            this.A01 = 2;
        }
    }

    public final void A08(HA ha, InterfaceC0528Hd interfaceC0528Hd) {
        this.A06 = ha;
        this.A07 = interfaceC0528Hd;
        A0B(true);
    }

    public void A0A(long j) {
        this.A02 = j;
    }

    public void A0B(boolean z) {
        if (z) {
            this.A09 = new C0576Ja();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
