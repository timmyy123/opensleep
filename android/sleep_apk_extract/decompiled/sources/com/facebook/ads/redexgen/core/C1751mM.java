package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1751mM implements InterfaceC0562Il {
    public static byte[] A07;
    public static String[] A08 = {"eVwUBMvHO9uBMhknAGNfZP2yr814WJyE", "k5ILRUABeDXqCwWpN", "hJjZHs3Q8zIp76bYyURn3XwI", "BeESTKEHKjvJbhVudlSNXwxkHuAjvLDZ", "rbeMFWTNNauR3FTC2xnHN2ozIe2oUtV0", "bbPaxRhv7ZvGWrZH", "Yl9CHZRrzKaSrdtxcFsBA9EFbwcoGK5g", "dqSnihCeyqEvBM16"};
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC0561Ik A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<C0559Ii> A05 = new ArrayDeque<>();
    public final C0567Iq A04 = new C0567Iq();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{98, -121, -113, 122, -123, -126, 125, 57, 126, -123, 126, -122, 126, -121, -115, 57, -115, -110, -119, 126, 57, 91, -128, -120, 115, 126, 123, 118, 50, 120, 126, -127, 115, -122, 50, -123, 123, -116, 119, 76, 50, -78, -41, -33, -54, -43, -46, -51, -119, -46, -41, -35, -50, -48, -50, -37, -119, -36, -46, -29, -50, -93, -119, -61, -28, -30, -39, -34, -41, -112, -43, -36, -43, -35, -43, -34, -28, -112, -29, -39, -22, -43, -86, -112};
        if (A08[6].charAt(2) != '9') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "OJtOaz7eyeuGy8JHYC7MsYj9KI0teM8x";
        strArr[4] = "Pthq8qREsbuOKTWUYG3bxj4Nb5ptFAt8";
    }

    static {
        A05();
    }

    private double A00(InterfaceC1772ms interfaceC1772ms, int i) throws IOException {
        long jA02 = A02(interfaceC1772ms, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) jA02);
        }
        return Double.longBitsToDouble(jA02);
    }

    @RequiresNonNull({"processor"})
    private long A01(InterfaceC1772ms interfaceC1772ms) throws IOException {
        interfaceC1772ms.AIl();
        while (true) {
            interfaceC1772ms.AGt(this.A06, 0, 4);
            int iA00 = C0567Iq.A00(this.A06[0]);
            if (iA00 != -1 && iA00 <= 4) {
                int iA01 = (int) C0567Iq.A01(this.A06, iA00, false);
                if (this.A03.AAW(iA01)) {
                    interfaceC1772ms.AK3(iA00);
                    return iA01;
                }
            }
            interfaceC1772ms.AK3(1);
        }
    }

    private long A02(InterfaceC1772ms interfaceC1772ms, int i) throws IOException {
        interfaceC1772ms.readFully(this.A06, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long value = this.A06[i2] & 255;
            j = (j << 8) | value;
        }
        return j;
    }

    public static String A04(InterfaceC1772ms interfaceC1772ms, int i) throws IOException {
        if (i == 0) {
            return A03(0, 0, 32);
        }
        byte[] bArr = new byte[i];
        interfaceC1772ms.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0562Il
    public final void AAD(InterfaceC0561Ik interfaceC0561Ik) {
        this.A03 = interfaceC0561Ik;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011d, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011f, code lost:
    
        r12.A03.AKK(r12.A00, A04(r13, (int) r12.A02));
        r12.A01 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015b, code lost:
    
        throw com.facebook.ads.redexgen.core.C3K.A01(A03(63, 21, 97) + r12.A02, null);
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0562Il
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean AHO(InterfaceC1772ms interfaceC1772ms) throws IOException {
        AbstractC02053y.A02(this.A03);
        while (true) {
            C0559Ii head = this.A05.peek();
            if (head != null && interfaceC1772ms.A8n() >= head.A01) {
                this.A03.A6N(this.A05.pop().A00);
                return true;
            }
            if (this.A01 == 0) {
                long jA05 = this.A04.A05(interfaceC1772ms, true, false, 4);
                if (jA05 == -2) {
                    jA05 = A01(interfaceC1772ms);
                }
                if (jA05 == -1) {
                    return false;
                }
                this.A00 = (int) jA05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(interfaceC1772ms, false, true, 8);
                this.A01 = 2;
            }
            int iA7u = this.A03.A7u(this.A00);
            switch (iA7u) {
                case 0:
                    interfaceC1772ms.AK3((int) this.A02);
                    this.A01 = 0;
                    break;
                case 1:
                    long jA8n = interfaceC1772ms.A8n();
                    this.A05.push(new C0559Ii(this.A00, jA8n + this.A02));
                    InterfaceC0561Ik interfaceC0561Ik = this.A03;
                    int i = this.A00;
                    long elementContentPosition = this.A02;
                    interfaceC0561Ik.AK9(i, jA8n, elementContentPosition);
                    this.A01 = 0;
                    return true;
                case 2:
                    if (this.A02 <= 8) {
                        this.A03.AAH(this.A00, A02(interfaceC1772ms, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw C3K.A01(A03(41, 22, 90) + this.A02, null);
                case 3:
                    long j = this.A02;
                    if (A08[3].charAt(30) == 'v') {
                        A08[3] = "KnGHYIorNoG22Tvn2zIFMGSlF3FZ2Zej";
                    } else {
                        A08[2] = "fCyqjQ49ueazrn4tXgyzoG1n";
                    }
                    break;
                case 4:
                    this.A03.A4i(this.A00, (int) this.A02, interfaceC1772ms);
                    this.A01 = 0;
                    return true;
                case 5:
                    long j2 = this.A02;
                    if (A08[6].charAt(2) != '9') {
                        throw new RuntimeException();
                    }
                    A08[2] = "D1RmFcc9PuCELhM1k2KVAJs3";
                    if (j2 == 4 || this.A02 == 8) {
                        this.A03.A6a(this.A00, A00(interfaceC1772ms, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw C3K.A01(A03(21, 20, 3) + this.A02, null);
                default:
                    throw C3K.A01(A03(0, 21, 10) + iA7u, null);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0562Il
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
