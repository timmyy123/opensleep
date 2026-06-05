package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9v, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9v implements InterfaceC1830np, InterfaceC1831nq {
    public static String[] A06 = {"JXRw8dEnvO1Lr4g7cFUS0dvQrSj2gCrD", "hvHNuBxl", "xmWilmV3z2eIIj1", "UUtHfwhImwRJiupXWlBcpFq10hKf2hZ3", "Gjwbiw3zcCnfnivX0C6Z4KLegMayRhyW", "PFLAFIzQgEofbdrT2htWxpP7W2gVOOgi", "405rypbMY6P", "HWuA8Rz9jBHRgd5bymvhijPSyV36G6mN"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC1831nq A03;
    public C1834nt[] A04 = new C1834nt[0];
    public final InterfaceC1830np A05;

    public C9v(InterfaceC1830np interfaceC1830np, boolean z, long j, long j2) {
        this.A05 = interfaceC1830np;
        this.A02 = z ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j2;
    }

    private C03057u A00(long j, C03057u c03057u) {
        long toleranceBeforeUs = C5C.A0T(c03057u.A01, 0L, j - this.A01);
        long jA0T = C5C.A0T(c03057u.A00, 0L, this.A00 == Long.MIN_VALUE ? Long.MAX_VALUE : this.A00 - j);
        if (toleranceBeforeUs == c03057u.A01) {
            long j2 = c03057u.A00;
            if (A06[6].length() != 11) {
                throw new RuntimeException();
            }
            A06[0] = "SySHx2FlEzism2SEaRZKk1Ki9OIwKCgL";
            if (jA0T == j2) {
                return c03057u;
            }
        }
        return new C03057u(toleranceBeforeUs, jA0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.DW
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void ADV(InterfaceC1830np interfaceC1830np) {
        ((InterfaceC1831nq) AbstractC02053y.A01(this.A03)).ADV(this);
    }

    public static boolean A02(long j, InterfaceC1793nE[] interfaceC1793nEArr) {
        if (j != 0) {
            for (InterfaceC1793nE interfaceC1793nE : interfaceC1793nEArr) {
                if (interfaceC1793nE != null) {
                    C1981qI c1981qIA92 = interfaceC1793nE.A92();
                    if (!C3J.A0G(c1981qIA92.A0W, c1981qIA92.A0R)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4s(long j) {
        this.A05.A4s(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final boolean A5C(long j) {
        return this.A05.A5C(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final void A60(long j, boolean z) {
        this.A05.A60(j, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final long A6r(long j, C03057u c03057u) {
        if (j == this.A01) {
            return this.A01;
        }
        return this.A05.A6r(j, A00(j, c03057u));
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D9949576 for unstall buffer")
    public final long A76(long j) {
        return this.A05.A76(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final long A78() {
        long jA78 = this.A05.A78();
        if (jA78 == Long.MIN_VALUE || (this.A00 != Long.MIN_VALUE && jA78 >= this.A00)) {
            return Long.MIN_VALUE;
        }
        return jA78;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final long A8b() {
        long jA8b = this.A05.A8b();
        if (jA8b != Long.MIN_VALUE) {
            long nextLoadPositionUs = this.A00;
            if (A06[0].charAt(29) != 'C') {
                throw new RuntimeException();
            }
            A06[0] = "QBPPyRyowan8CCGBQiXIHMf03VOUOCSC";
            if (nextLoadPositionUs == Long.MIN_VALUE || jA8b < this.A00) {
                return jA8b;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final C1811nW A9M() {
        return this.A05.A9M();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final void ACS() throws IOException {
        if (0 == 0) {
            this.A05.ACS();
            return;
        }
        throw null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1831nq
    public final void AFS(InterfaceC1830np interfaceC1830np) {
        if (0 != 0) {
            return;
        }
        ((InterfaceC1831nq) AbstractC02053y.A01(this.A03)).AFS(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final void AH5(InterfaceC1831nq interfaceC1831nq, long j) {
        this.A03 = interfaceC1831nq;
        this.A05.AH5(this, j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final long AHQ() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            this.A02 = -9223372036854775807L;
            long jAHQ = AHQ();
            return jAHQ != -9223372036854775807L ? jAHQ : childDiscontinuityUs;
        }
        InterfaceC1830np interfaceC1830np = this.A05;
        if (A06[2].length() == 0) {
            throw new RuntimeException();
        }
        A06[6] = "ABWUoGiNBoa";
        long jAHQ2 = interfaceC1830np.AHQ();
        if (jAHQ2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long discontinuityUs = this.A01;
        boolean z = true;
        AbstractC02053y.A08(jAHQ2 >= discontinuityUs);
        if (this.A00 != Long.MIN_VALUE) {
            long discontinuityUs2 = this.A00;
            if (jAHQ2 > discontinuityUs2) {
                z = false;
            }
        }
        AbstractC02053y.A08(z);
        return jAHQ2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final void AHW(long j) {
        this.A05.AHW(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    public final long AJ8(@MetaExoPlayerCustomization long j, boolean z) {
        this.A02 = -9223372036854775807L;
        boolean z2 = false;
        for (C1834nt c1834nt : this.A04) {
            if (c1834nt != null) {
                c1834nt.A00();
            }
        }
        long jAJ8 = this.A05.AJ8(j, z);
        if (jAJ8 == j || (jAJ8 >= this.A01 && (this.A00 == Long.MIN_VALUE || jAJ8 <= this.A00))) {
            z2 = true;
        }
        AbstractC02053y.A08(z2);
        return jAJ8;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1830np
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AJ9(InterfaceC1793nE[] interfaceC1793nEArr, boolean[] zArr, DT[] dtArr, boolean[] zArr2, long j) {
        long j2;
        int i;
        this.A04 = new C1834nt[dtArr.length];
        DT[] dtArr2 = new DT[dtArr.length];
        int i2 = 0;
        while (true) {
            DT dt = null;
            if (i2 >= dtArr.length) {
                break;
            }
            this.A04[i2] = (C1834nt) dtArr[i2];
            DT[] childStreams = this.A04;
            if (childStreams[i2] != null) {
                dt = this.A04[i2].A01;
            }
            dtArr2[i2] = dt;
            i2++;
        }
        long jAJ9 = this.A05.AJ9(interfaceC1793nEArr, zArr, dtArr2, zArr2, j);
        if (!A03() || j != this.A01) {
            j2 = -9223372036854775807L;
            this.A02 = j2;
            AbstractC02053y.A08(jAJ9 != j || (jAJ9 >= this.A01 && (this.A00 == Long.MIN_VALUE || jAJ9 <= this.A00)));
            i = 0;
            while (true) {
                int length = dtArr.length;
                if (A06[1].length() == 30) {
                    String[] strArr = A06;
                    strArr[7] = "DNi9UWzwfCWyYPkB4uGGg0YkPCShAQe6";
                    strArr[5] = "fAixbEz1F3G47KA6JLUGcT01MO1ZofiJ";
                    if (i >= length) {
                        break;
                    }
                    if (dtArr2[i] != null) {
                        C1834nt[] c1834ntArr = this.A04;
                        String[] strArr2 = A06;
                        if (strArr2[4].charAt(5) != strArr2[3].charAt(5)) {
                            break;
                        }
                        A06[6] = "ocXNdzhjsFv";
                        c1834ntArr[i] = null;
                    } else {
                        DT[] childStreams2 = this.A04;
                        if (childStreams2[i] != null) {
                            DT dt2 = this.A04[i].A01;
                            DT dt3 = dtArr2[i];
                            if (A06[1].length() != 30) {
                                String[] strArr3 = A06;
                                strArr3[4] = "cYzDBwspbZ8a8DM9Dz10VjvDatAoG4Oi";
                                strArr3[3] = "WIkG6wjldaaFwlHYCP34A8xHiCA5NCte";
                                if (dt2 != dt3) {
                                    this.A04[i] = new C1834nt(this, dtArr2[i]);
                                }
                            } else if (dt2 != dt3) {
                            }
                        }
                    }
                    DT[] childStreams3 = this.A04;
                    dtArr[i] = childStreams3[i];
                    i++;
                } else {
                    if (i >= length) {
                        break;
                    }
                    if (dtArr2[i] != null) {
                    }
                    DT[] childStreams32 = this.A04;
                    dtArr[i] = childStreams32[i];
                    i++;
                }
            }
            return jAJ9;
        }
        long j3 = this.A01;
        String[] strArr4 = A06;
        if (strArr4[4].charAt(5) == strArr4[3].charAt(5)) {
            String[] strArr5 = A06;
            strArr5[7] = "en1LL2zHQFU7eKPWWtw7tqDicZnmZ9l5";
            strArr5[5] = "t66o2OzEfyctLQHjRBlZ897u0IFgDWGZ";
            if (A02(j3, interfaceC1793nEArr)) {
                j2 = jAJ9;
            }
            this.A02 = j2;
            if (jAJ9 != j) {
                AbstractC02053y.A08(jAJ9 != j || (jAJ9 >= this.A01 && (this.A00 == Long.MIN_VALUE || jAJ9 <= this.A00)));
                i = 0;
                while (true) {
                    int length2 = dtArr.length;
                    if (A06[1].length() == 30) {
                    }
                    DT[] childStreams322 = this.A04;
                    dtArr[i] = childStreams322[i];
                    i++;
                }
                return jAJ9;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AJc(boolean z) {
        this.A05.AJc(z);
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AKb(byte b) {
        this.A05.AKb(b);
    }
}
