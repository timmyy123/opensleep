package com.facebook.ads.redexgen.core;

import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1690lM implements InterfaceC0623Kv {
    public static byte[] A0G;
    public static String[] A0H = {"cAtU07tvAHmpQwteCa8pEQH5gF5iUcfh", "Hjeg7grS71Jm6r5NKbmR8o7Al25NvLrB", "8TbkpeEOwiN436cBQhp4NSePMq1Z0ZNp", "wFA3Sleqv", "yws6lvEdJf3TdH9okNAymdfPd8aH69ii", "xvx7jE251jeLUpmQ5JTTtAODp7RTPAZj", "flKrm8KbmQNj7vJDUwRTOfFPMCPuTaKn", "2PQM5lIFNms8BVmrvHkuPmbcHqu7a2gR"};
    public static final double[] A0I;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public InterfaceC0528Hd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final C02284v A0B;
    public final C0624Kw A0C;
    public final L4 A0D;
    public final LJ A0E;
    public final boolean[] A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<C1981qI, Long> A00(C0624Kw c0624Kw, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(c0624Kw.A02, c0624Kw.A00);
        int i = bArrCopyOf[4] & 255;
        int i2 = bArrCopyOf[5] & 255;
        int i3 = (i << 4) | (i2 >> 4);
        int i4 = ((i2 & 15) << 8) | (bArrCopyOf[6] & 255);
        float f = 1.0f;
        switch ((bArrCopyOf[7] & 240) >> 4) {
            case 2:
                float f2 = i4 * 4;
                float f3 = i3 * 3;
                if (A0H[2].charAt(3) == 'k') {
                    A0H[1] = "IKG5315UEoYuWi8w79ZvxkF28jax6fmF";
                    f = f2 / f3;
                    break;
                }
                throw new RuntimeException();
            case 3:
                f = (i4 * 16) / (i3 * 9);
                break;
            case 4:
                f = (i4 * 121) / (i3 * 100);
                break;
        }
        C1981qI c1981qIA14 = new C01722p().A0y(str).A11(A01(0, 11, 62)).A0r(i3).A0f(i4).A0Y(f).A12(Collections.singletonList(bArrCopyOf)).A14();
        long j = 0;
        int i5 = (bArrCopyOf[7] & 15) - 1;
        if (i5 >= 0 && i5 < A0I.length) {
            double d = A0I[i5];
            int i6 = c0624Kw.A01;
            int i7 = (bArrCopyOf[i6 + 9] & 96) >> 5;
            int i8 = bArrCopyOf[i6 + 9] & 31;
            if (i7 != i8) {
                double d2 = i7;
                if (A0H[2].charAt(3) == 'k') {
                    String[] strArr = A0H;
                    strArr[5] = "rAMAKKtXIRKmVhmwxuLKv06bcSnWRDth";
                    strArr[7] = "TlBzrdA8FTcPVEmXq7DzDEHR3QnpW5Am";
                    d *= (d2 + 1.0d) / ((double) (i8 + 1));
                }
                throw new RuntimeException();
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(c1981qIA14, Long.valueOf(j));
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {50, 45, 32, 33, 43, 107, 41, 52, 33, 35, 118};
        if (A0H[4].charAt(19) != 'y') {
            throw new RuntimeException();
        }
        A0H[2] = "5b4kHrs0qMccPUXJRINIqLrMs4aEtqXr";
        A0G = bArr;
    }

    static {
        A02();
        A0I = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public C1690lM() {
        this(null);
    }

    public C1690lM(LJ lj) {
        this.A0E = lj;
        this.A0F = new boolean[4];
        this.A0C = new C0624Kw(128);
        if (lj != null) {
            this.A0D = new L4(178, 128);
            this.A0B = new C02284v();
        } else {
            this.A0D = null;
            this.A0B = null;
        }
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0117  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5A(C02284v c02284v) {
        long j;
        AbstractC02053y.A02(this.A05);
        int iA09 = c02284v.A09();
        int iA0A = c02284v.A0A();
        byte[] bArrA0l = c02284v.A0l();
        this.A04 += (long) c02284v.A07();
        this.A05.AIr(c02284v, c02284v.A07());
        while (true) {
            int iA04 = HS.A04(bArrA0l, iA09, iA0A, this.A0F);
            if (iA04 == iA0A) {
                boolean z = this.A07;
                String[] strArr = A0H;
                if (strArr[6].length() != strArr[3].length()) {
                    A0H[1] = "ooUhAAd1UFU3ZsdgbXiiZIdc17zvx9JT";
                    if (!z) {
                        this.A0C.A01(bArrA0l, iA09, iA0A);
                    }
                    if (this.A0D != null) {
                        this.A0D.A02(bArrA0l, iA09, iA0A);
                        return;
                    }
                    return;
                }
            } else {
                int i = c02284v.A0l()[iA04 + 3] & 255;
                int i2 = iA04 - iA09;
                if (!this.A07) {
                    if (i2 > 0) {
                        this.A0C.A01(bArrA0l, iA09, iA04);
                    }
                    if (this.A0C.A02(i, i2 < 0 ? -i2 : 0)) {
                        Pair<C1981qI, Long> pairA00 = A00(this.A0C, (String) AbstractC02053y.A01(this.A06));
                        this.A05.A6e((C1981qI) pairA00.first);
                        this.A00 = ((Long) pairA00.second).longValue();
                        this.A07 = true;
                    }
                }
                if (this.A0D != null) {
                    int i3 = 0;
                    if (i2 > 0) {
                        this.A0D.A02(bArrA0l, iA09, iA04);
                    } else {
                        i3 = -i2;
                    }
                    if (this.A0D.A04(i3)) {
                        ((C02284v) C5C.A0f(this.A0B)).A0j(this.A0D.A01, HS.A02(this.A0D.A01, this.A0D.A00));
                        ((LJ) C5C.A0f(this.A0E)).A02(this.A03, this.A0B);
                    }
                    if (i == 178 && c02284v.A0l()[iA04 + 2] == 1) {
                        this.A0D.A01(i);
                    }
                }
                if (i == 0 || i == 179) {
                    int i4 = iA0A - iA04;
                    long j2 = -9223372036854775807L;
                    if (this.A08) {
                        boolean z2 = this.A07;
                        if (A0H[2].charAt(3) == 'k') {
                            A0H[4] = "I3q7BGa2d1yxMNRbgKUy1FZhwbtqEBv0";
                            if (z2) {
                            }
                        } else if (z2) {
                            if (this.A03 != -9223372036854775807L) {
                                j2 = -9223372036854775807L;
                                this.A05.AIu(this.A03, this.A09 ? 1 : 0, ((int) (this.A04 - this.A02)) - i4, i4, null);
                            }
                        }
                    }
                    boolean z3 = this.A0A;
                    String[] strArr2 = A0H;
                    if (strArr2[6].length() == strArr2[3].length()) {
                        break;
                    }
                    A0H[1] = "M1cTpkEI0lqbwMedLRZ4APYv7Db9TSYf";
                    if (!z3 || this.A08) {
                        this.A02 = this.A04 - ((long) i4);
                        if (this.A01 != j2) {
                            j = this.A01;
                        } else if (this.A03 != j2) {
                            long j3 = this.A03;
                            if (A0H[0].charAt(10) != 'm') {
                                j = this.A00 + j3;
                            } else {
                                A0H[0] = "FNyxia2DuWmH1fHrZAJ70vL24BcjBrNj";
                                j = this.A00 + j3;
                            }
                        } else {
                            j = j2;
                        }
                        this.A03 = j;
                        this.A09 = false;
                        this.A01 = j2;
                        this.A0A = true;
                    }
                    this.A08 = i == 0;
                } else if (i == 184) {
                    this.A09 = true;
                }
                iA09 = iA04 + 3;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A06 = lg.A04();
        this.A05 = ha.AKS(lg.A03(), 2);
        if (this.A0E != null) {
            this.A0E.A03(ha, lg);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGq(long j, int i) {
        this.A01 = j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AJ5() {
        HS.A0H(this.A0F);
        this.A0C.A00();
        if (this.A0D != null) {
            L4 l4 = this.A0D;
            if (A0H[1].length() != 32) {
                throw new RuntimeException();
            }
            A0H[0] = "joVCJevLOtmtIagsqVBvfxemqq2mA7LA";
            l4.A00();
        }
        this.A04 = 0L;
        this.A0A = false;
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }
}
