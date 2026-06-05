package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1681lD implements H1 {
    public static String[] A02 = {"icMuAGNUwG3qooMsLkIelsXOgqR", "wZwGdqwzUfLFhHeDnVqZXfrekI2t19Nm", "6NjHclQwJEhKen4shQzzT38fKShvFJl3", "cwvHChui6ScrilPVLNLxDwwq1RZibmTM", "KGSyfhH5I6lVnEy0NkdKQy5Ija", "JgLMaajFBM7mBqcCk", "W9ygPHkeZ", ""};
    public final C02284v A00;
    public final AnonymousClass53 A01;

    public C1681lD(AnonymousClass53 anonymousClass53) {
        this.A01 = anonymousClass53;
        this.A00 = new C02284v();
    }

    private C0524Gz A00(C02284v c02284v, long scrValue, long scrTimeUs) {
        int iA09 = -1;
        int iA092 = -1;
        long j = -9223372036854775807L;
        while (c02284v.A07() >= 4) {
            if (C1680lC.A00(c02284v.A0l(), c02284v.A09()) != 442) {
                c02284v.A0g(1);
            } else {
                c02284v.A0g(4);
                long jA06 = L6.A06(c02284v);
                if (jA06 != -9223372036854775807L) {
                    long jA062 = this.A01.A06(jA06);
                    if (jA062 > scrValue) {
                        if (j == -9223372036854775807L) {
                            return C0524Gz.A04(jA062, scrTimeUs);
                        }
                        return C0524Gz.A03(((long) iA09) + scrTimeUs);
                    }
                    int startOfLastPacketPosition = A02[1].charAt(26);
                    if (startOfLastPacketPosition == 113) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[3] = "JRu5yfiOOmZm3e1j9KGmxzziCqUEhgmX";
                    strArr[2] = "rPvZuTIICj36zhJU166yjphfEhohU7nm";
                    long lastScrTimeUsInRange = 100000 + jA062;
                    if (lastScrTimeUsInRange > scrValue) {
                        return C0524Gz.A03(((long) c02284v.A09()) + scrTimeUs);
                    }
                    j = jA062;
                    iA09 = c02284v.A09();
                }
                A01(c02284v);
                iA092 = c02284v.A09();
            }
        }
        if (j != -9223372036854775807L) {
            return C0524Gz.A05(j, ((long) iA092) + scrTimeUs);
        }
        return C0524Gz.A03;
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x005b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A01(C02284v c02284v) {
        int systemHeaderLength = c02284v.A0A();
        if (c02284v.A07() < 10) {
            c02284v.A0f(systemHeaderLength);
            return;
        }
        c02284v.A0g(9);
        int limit = c02284v.A0I();
        int packStuffingLength = limit & 7;
        int limit2 = c02284v.A07();
        if (limit2 < packStuffingLength) {
            c02284v.A0f(systemHeaderLength);
            return;
        }
        c02284v.A0g(packStuffingLength);
        int limit3 = c02284v.A07();
        if (limit3 < 4) {
            c02284v.A0f(systemHeaderLength);
            return;
        }
        byte[] bArrA0l = c02284v.A0l();
        int limit4 = c02284v.A09();
        if (C1680lC.A00(bArrA0l, limit4) == 443) {
            c02284v.A0g(4);
            int packStuffingLength2 = c02284v.A0M();
            int limit5 = c02284v.A07();
            if (limit5 < packStuffingLength2) {
                c02284v.A0f(systemHeaderLength);
                return;
            }
            c02284v.A0g(packStuffingLength2);
        }
        while (limit >= 4) {
            byte[] bArrA0l2 = c02284v.A0l();
            int limit6 = c02284v.A09();
            int packStuffingLength3 = C1680lC.A00(bArrA0l2, limit6);
            if (packStuffingLength3 == 442 || packStuffingLength3 == 441 || (packStuffingLength3 >>> 8) != 1) {
                return;
            }
            c02284v.A0g(4);
            if (c02284v.A07() < 2) {
                c02284v.A0f(systemHeaderLength);
                return;
            }
            int nextStartCode = c02284v.A0M();
            int packStuffingLength4 = c02284v.A0A();
            int limit7 = c02284v.A09();
            c02284v.A0f(Math.min(packStuffingLength4, limit7 + nextStartCode));
        }
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final void AFs() {
        this.A00.A0i(C5C.A07);
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final C0524Gz AIw(InterfaceC1772ms interfaceC1772ms, long j) throws IOException {
        long jA8n = interfaceC1772ms.A8n();
        int iMin = (int) Math.min(20000L, interfaceC1772ms.A8O() - jA8n);
        this.A00.A0d(iMin);
        interfaceC1772ms.AGt(this.A00.A0l(), 0, iMin);
        return A00(this.A00, j, jA8n);
    }
}
