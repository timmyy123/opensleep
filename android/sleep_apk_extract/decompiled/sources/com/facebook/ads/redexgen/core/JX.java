package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JX {
    public static byte[] A0B;
    public static String[] A0C = {"k49nAlN8KevTPYFSOASLph6sBsYk4fa7", "ZHcqIGWhgUaBv559uPYodmfdla4z6YNf", "jyudHMVcZvePNcLp", "lBa1kLRes0ajIcq6EZkhg1VE2ZO4hxQe", "m2AqQobddrkuylEWDBAfxEjZEg6GjKoy", "b8nnr3L8PmBoSjec6BWbo41G2gNha3bi", "", ""};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public final int[] A09 = new int[PHIpAddressSearchManager.END_IP_SCAN];
    public final C02284v A0A = new C02284v(PHIpAddressSearchManager.END_IP_SCAN);

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0B = new byte[]{55, 44, 49, 55, 50, 50, 45, 48, 54, 39, 38, 98, 32, 43, 54, 98, 49, 54, 48, 39, 35, 47, 98, 48, 39, 52, 43, 49, 43, 45, 44};
    }

    static {
        A01();
    }

    public final void A02() {
        this.A03 = 0;
        this.A04 = 0;
        this.A05 = 0L;
        this.A08 = 0L;
        this.A07 = 0L;
        this.A06 = 0L;
        this.A02 = 0;
        this.A01 = 0;
        this.A00 = 0;
    }

    public final boolean A03(InterfaceC1772ms interfaceC1772ms) throws IOException {
        return A04(interfaceC1772ms, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r12 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if (r11.A8n() >= r12) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        r6 = r11.AK0(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
    
        if (com.facebook.ads.redexgen.core.JX.A0C[0].charAt(26) == 'Y') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
    
        r2 = com.facebook.ads.redexgen.core.JX.A0C;
        r2[3] = "68cxMfwSaXaldqHF3br6ENxggzqDHiHt";
        r2[1] = "gDTREffoH4ayxQFZG5Xi34FUHKUeipYB";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (r6 == (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A04(InterfaceC1772ms interfaceC1772ms, long j) throws IOException {
        AbstractC02053y.A07(interfaceC1772ms.A8n() == interfaceC1772ms.A8i());
        this.A0A.A0d(4);
        while (true) {
            if (j != -1 && interfaceC1772ms.A8n() + 4 >= j) {
                break;
            }
            boolean zA04 = HB.A04(interfaceC1772ms, this.A0A.A0l(), 0, 4, true);
            if (A0C[4].charAt(30) == '5') {
                throw new RuntimeException();
            }
            A0C[0] = "pwarRjQHbZVi4rcQZ7lOEWakVYY08Z6g";
            if (!zA04) {
                break;
            }
            this.A0A.A0f(0);
            if (this.A0A.A0Q() == 1332176723) {
                interfaceC1772ms.AIl();
                return true;
            }
            interfaceC1772ms.AK3(1);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x00ac */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A05(InterfaceC1772ms interfaceC1772ms, boolean z) throws IOException {
        A02();
        this.A0A.A0d(27);
        if (!HB.A04(interfaceC1772ms, this.A0A.A0l(), 0, 27, z) || this.A0A.A0Q() != 1332176723) {
            return false;
        }
        C02284v c02284v = this.A0A;
        if (A0C[0].charAt(26) != 'Y') {
            throw new RuntimeException();
        }
        A0C[2] = "M9XA72oAU7";
        this.A03 = c02284v.A0I();
        if (this.A03 != 0) {
            if (z) {
                return false;
            }
            throw C3K.A00(A00(0, 31, 87));
        }
        this.A04 = this.A0A.A0I();
        this.A05 = this.A0A.A0N();
        this.A08 = this.A0A.A0O();
        this.A07 = this.A0A.A0O();
        this.A06 = this.A0A.A0O();
        this.A02 = this.A0A.A0I();
        this.A01 = this.A02 + 27;
        this.A0A.A0d(this.A02);
        if (!HB.A04(interfaceC1772ms, this.A0A.A0l(), 0, this.A02, z)) {
            return false;
        }
        for (int i = 0; i < i; i++) {
            int[] iArr = this.A09;
            int i2 = this.A0A.A0I();
            iArr[i] = i2;
            int i3 = this.A00;
            int i4 = this.A09[i];
            this.A00 = i3 + i4;
        }
        return true;
    }
}
