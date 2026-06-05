package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1511iD {
    public static byte[] A06;
    public static String[] A07 = {"1rXfVnNZRCMKSBmKvXBkqyIampQHuBTT", "2bLZXAk3pl72OxsXhKzzangZVfhmAhBr", "LE0trkh5BaXy0JUPm", "MtA6uT6DKVcUBVmop0u", "GFOlAA7vgdvYkzDNo5MadPPE0QeXaZAF", "iEcBvH9q7CiihZ6SUT8L1eAmSvCZtCKk", "3wBrZQLKvBQ6cLhc0qq", "ySHp1IuW6hVExgFmQZh21v0rDd75pKs8"};
    public boolean A00;
    public boolean A01;
    public boolean A02;
    public final AbstractC0708Od A03;
    public final C0710Of A04;
    public final C0710Of A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A06 = new byte[]{-42, -30, -32, -29, -33, -40, -25, -40, -38, -29, -39, -38, -39, -72, -87, -69, -69, -83, -84, -66, -81, -67, -66, -99, -66, -85, -66, -67, -78, -91, -95, -77, -99, -98, -88, -95, -113, -80, -99, -80, -81};
    }

    static {
        A04();
    }

    public C1511iD(AbstractC0708Od abstractC0708Od) {
        this.A01 = false;
        this.A02 = false;
        this.A00 = false;
        this.A03 = abstractC0708Od;
        this.A04 = new C0710Of(abstractC0708Od.A01);
        this.A05 = new C0710Of(abstractC0708Od.A01);
    }

    public C1511iD(AbstractC0708Od abstractC0708Od, Bundle bundle) {
        this.A01 = false;
        this.A02 = false;
        this.A00 = false;
        this.A03 = abstractC0708Od;
        this.A04 = (C0710Of) AbstractC0943Xo.A00(bundle.getByteArray(A00(19, 9, 23)));
        this.A05 = (C0710Of) AbstractC0943Xo.A00(bundle.getByteArray(A00(28, 13, 9)));
        this.A01 = bundle.getBoolean(A00(8, 5, 66));
        this.A02 = bundle.getBoolean(A00(13, 6, 21));
        this.A00 = bundle.getBoolean(A00(0, 8, 64));
    }

    private void A01() {
        this.A00 = true;
        A02();
    }

    private void A02() {
        this.A01 = true;
        this.A03.A00(this.A00, this.A02, this.A02 ? this.A05 : this.A04);
    }

    private void A03() {
        this.A02 = true;
        A01();
    }

    public final Bundle A05() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(28, 13, 9), AbstractC0943Xo.A01(this.A05));
        bundle.putByteArray(A00(19, 9, 23), AbstractC0943Xo.A01(this.A04));
        bundle.putBoolean(A00(8, 5, 66), this.A01);
        bundle.putBoolean(A00(13, 6, 21), this.A02);
        bundle.putBoolean(A00(0, 8, 64), this.A00);
        return bundle;
    }

    public final void A06() {
        if (!this.A01) {
            this.A05.A03();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
    
        if (r8 == 0.0d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        A01();
        r2 = com.facebook.ads.redexgen.core.C1511iD.A07;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008d, code lost:
    
        if (r2[3].length() == r2[6].length()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
    
        com.facebook.ads.redexgen.core.C1511iD.A07[2] = "tDZlaAUjytzZ2vtOC";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0096, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
    
        if (r8 == 0.0d) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
    
        r2 = com.facebook.ads.redexgen.core.C1511iD.A07;
        r2[5] = "PWt3UCdLmacUDAaKa7qG1WjHdRUwYQML";
        r2[7] = "nsPDOGo5haoHqx4MxUvN1JuyDQrM6Fdb";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b2, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A07(double d, double d2) {
        double dA02;
        if (this.A01) {
            return;
        }
        this.A04.A04(d, d2);
        this.A05.A04(d, d2);
        if (this.A03.A03) {
            dA02 = this.A05.A00().A04();
        } else {
            dA02 = this.A05.A00().A02();
        }
        if (this.A03.A00 >= 0.0d) {
            double dA05 = this.A04.A00().A05();
            AbstractC0708Od abstractC0708Od = this.A03;
            String[] strArr = A07;
            if (strArr[4].charAt(8) == strArr[1].charAt(8)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "T6gjK2QSsLcLO7czUZGr1vXDcxJirDTU";
            strArr2[7] = "hs34X0zFUnqhorBqOe1x1e05IcUuJ424";
            if (dA05 > abstractC0708Od.A00) {
                String[] strArr3 = A07;
                if (strArr3[4].charAt(8) != strArr3[1].charAt(8)) {
                    A07[0] = "F30RTtpMpumHuhVQJj2Sxrc5BnRJWEU6";
                }
            }
        }
        AbstractC0708Od abstractC0708Od2 = this.A03;
        if (A07[0].charAt(15) != 'j') {
            A07[0] = "fX9sFZGj0U97M4kLDXLqIJ6maPl5udls";
            if (dA02 < abstractC0708Od2.A02) {
                return;
            }
        } else if (dA02 < abstractC0708Od2.A02) {
            return;
        }
        A03();
    }
}
