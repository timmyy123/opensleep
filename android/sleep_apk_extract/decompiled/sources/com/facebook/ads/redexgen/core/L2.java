package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L2 {
    public static String[] A0I = {"PiFB59Vxde45j8XGh3VNLS0bXquL", "eCGnEp7n3q", "QH0EN4bfbiXOmvaYxmEgWcgYRTVGFgtW", "ynU2FJVvbbIz4lLWIxM7HwzaaEzIs2yM", "B", "nKAZbJPu58l8", "2xLWRKjlXe7o2y", "tMbtJGMRwKJD523"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final InterfaceC0528Hd A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<HR> A0D = new SparseArray<>();
    public final SparseArray<HQ> A0C = new SparseArray<>();
    public L1 A06 = new L1();
    public L1 A07 = new L1();
    public byte[] A0B = new byte[128];
    public final HU A0E = new HU(this.A0B, 0, 0);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 26 out of bounds for length 26
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021e A[PHI: r18 r20
      0x021e: PHI (r18v1 int) = (r18v0 int), (r18v0 int), (r18v0 int), (r18v0 int), (r18v3 int), (r18v3 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]
      0x021e: PHI (r20v2 int) = (r20v0 int), (r20v0 int), (r20v1 int), (r20v1 int), (r20v0 int), (r20v0 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A05(byte[] bArr, int i, int i2) {
        if (this.A08) {
            int i3 = i2 - i;
            if (this.A0B.length < this.A00 + i3) {
                byte[] bArr2 = this.A0B;
                int i4 = this.A00;
                if (A0I[2].charAt(10) != 'z') {
                    A0I[3] = "fF62whIImPZuUxQ3wOrH7qahZ1W3GZDe";
                    this.A0B = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                    System.arraycopy(bArr, i, this.A0B, this.A00, i3);
                    this.A00 += i3;
                    this.A0E.A08(this.A0B, 0, this.A00);
                    if (this.A0E.A0B(8)) {
                        return;
                    }
                    this.A0E.A06();
                    int iA05 = this.A0E.A05(2);
                    this.A0E.A07(5);
                    if (!this.A0E.A09()) {
                        return;
                    }
                    this.A0E.A04();
                    if (!this.A0E.A09()) {
                        return;
                    }
                    int iA04 = this.A0E.A04();
                    if (this.A0H) {
                        if (this.A0E.A09()) {
                            int iA042 = this.A0E.A04();
                            if (this.A0C.indexOfKey(iA042) < 0) {
                                this.A08 = false;
                                return;
                            }
                            HQ hq = this.A0C.get(iA042);
                            HR hr = this.A0D.get(hq.A01);
                            if (hr.A0D) {
                                if (!this.A0E.A0B(2)) {
                                    return;
                                } else {
                                    this.A0E.A07(2);
                                }
                            }
                            HU hu = this.A0E;
                            int i5 = hr.A02;
                            if (A0I[3].charAt(31) != 'R') {
                                String[] strArr = A0I;
                                strArr[4] = "Y";
                                strArr[0] = "LBdvSwh0xb7fkSyUzFJrubBBNhQW";
                                if (!hu.A0B(i5)) {
                                    return;
                                }
                            } else if (!hu.A0B(i5)) {
                                return;
                            }
                            boolean zA0A = false;
                            boolean z = false;
                            boolean zA0A2 = false;
                            int iA052 = this.A0E.A05(hr.A02);
                            if (hr.A0C) {
                                if (A0I[1].length() != 10) {
                                    A0I[6] = "9PoEa2ZU2Rc4Mb";
                                } else {
                                    A0I[6] = "45zkVvkeN2w0fF";
                                }
                            } else {
                                if (!this.A0E.A0B(1)) {
                                    return;
                                }
                                zA0A = this.A0E.A0A();
                                if (zA0A) {
                                    if (!this.A0E.A0B(1)) {
                                        return;
                                    }
                                    zA0A2 = this.A0E.A0A();
                                    z = true;
                                } else if (A0I[3].charAt(31) != 'R') {
                                    String[] strArr2 = A0I;
                                    strArr2[4] = "3";
                                    strArr2[0] = "19iwLQZiC4kcbLDxX6EkwfmmLREP";
                                }
                            }
                            boolean z2 = this.A01 == 5;
                            int iA043 = 0;
                            if (z2) {
                                if (!this.A0E.A09()) {
                                    return;
                                } else {
                                    iA043 = this.A0E.A04();
                                }
                            }
                            int iA053 = 0;
                            int iA03 = 0;
                            int iA032 = 0;
                            int iA033 = 0;
                            if (hr.A07 == 0) {
                                if (!this.A0E.A0B(hr.A06)) {
                                    return;
                                }
                                iA053 = this.A0E.A05(hr.A06);
                                if (!hq.A02 || zA0A) {
                                    String[] strArr3 = A0I;
                                    if (strArr3[5].length() != strArr3[7].length()) {
                                        A0I[1] = "lSna5RLd1h";
                                    } else {
                                        A0I[6] = "3KoChTLYrqIZNd";
                                    }
                                } else {
                                    if (!this.A0E.A09()) {
                                        return;
                                    }
                                    iA03 = this.A0E.A03();
                                    if (A0I[3].charAt(31) != 'R') {
                                        A0I[2] = "kr3yeibAy42hiyE0dA9TA4Dy6aRxjun2";
                                    } else {
                                        A0I[1] = "MkKVWDrQaD";
                                    }
                                }
                            } else if (hr.A07 == 1 && !hr.A0B) {
                                if (!this.A0E.A09()) {
                                    return;
                                }
                                iA032 = this.A0E.A03();
                                if (hq.A02 && !zA0A) {
                                    if (!this.A0E.A09()) {
                                        return;
                                    } else {
                                        iA033 = this.A0E.A03();
                                    }
                                }
                            }
                            this.A07.A04(hr, iA05, iA04, iA052, iA042, zA0A, z, zA0A2, z2, iA043, iA053, iA03, iA032, iA033);
                            this.A08 = false;
                            return;
                        }
                        return;
                    }
                    this.A08 = false;
                    this.A07.A03(iA04);
                    if (A0I[1].length() == 10) {
                        String[] strArr4 = A0I;
                        strArr4[4] = "L";
                        strArr4[0] = "t7NRPrzJk7qeXS0lN2m3lGyrxGU0";
                        return;
                    }
                }
            } else {
                System.arraycopy(bArr, i, this.A0B, this.A00, i3);
                this.A00 += i3;
                this.A0E.A08(this.A0B, 0, this.A00);
                if (this.A0E.A0B(8)) {
                }
            }
            throw new RuntimeException();
        }
    }

    public L2(InterfaceC0528Hd interfaceC0528Hd, boolean z, boolean z2) {
        this.A0F = interfaceC0528Hd;
        this.A0G = z;
        this.A0H = z2;
        A01();
    }

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
    private void A00(int i) {
        if (this.A05 == -9223372036854775807L) {
            return;
        }
        boolean z = this.A0A;
        this.A0F.AIu(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    public final void A02(long j, int i, long j2) {
        this.A01 = i;
        this.A03 = j2;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            if (this.A01 != 5 && this.A01 != 1 && this.A01 != 2) {
                return;
            }
        }
        L1 l1 = this.A06;
        L1 l12 = this.A07;
        if (A0I[1].length() != 10) {
            throw new RuntimeException();
        }
        A0I[6] = "uj74NyijhUvg4q";
        this.A06 = l12;
        this.A07 = l1;
        L1 newSliceHeader = this.A07;
        newSliceHeader.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A03(HQ hq) {
        this.A0C.append(hq.A00, hq);
    }

    public final void A04(HR hr) {
        this.A0D.append(hr.A09, hr);
    }

    public final boolean A06() {
        return this.A0H;
    }

    public final boolean A07(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A00(this.A06))) {
            if (z && this.A09) {
                A00(i + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        if (this.A0G) {
            z2 = this.A07.A05();
        }
        boolean z4 = this.A0A;
        if (this.A01 == 5 || (z2 && this.A01 == 1)) {
            z3 = true;
        }
        this.A0A = z4 | z3;
        boolean treatIFrameAsKeyframe = this.A0A;
        return treatIFrameAsKeyframe;
    }
}
