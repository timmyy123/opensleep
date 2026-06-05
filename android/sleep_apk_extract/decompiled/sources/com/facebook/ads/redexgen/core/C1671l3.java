package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1671l3 implements H9 {
    public static byte[] A0J;
    public static String[] A0K = {"3dZ2NVLPQqqn6A0EUODs8QMiUtGNdx7Z", "xuFjaEC88iswWSp8XVRYQuG7fGDdMX6m", "rjdehGUhBmpCCREwTfVtgF2pvaVk7Y4r", "d6Khp0uOfqWTO1N40QwEt8A6fbOPCRXM", "7DUxEGbk65Je624GBbCgY3TRasgIHugx", "67QtD18zbra6Hv1RLsjBMCgdjZH6dqot", "3juCdNiTPJNnKT5EWnyWnOXcFndGfbid", "ecCIYKwUzA4Q5tjuLJWmpRk8GBJuqhXU"};
    public static final HD A0L;
    public int A00;
    public int A01;
    public int A02;
    public HA A03;
    public C1675l7 A04;
    public LH A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final SparseArray<LH> A0B;
    public final SparseBooleanArray A0C;
    public final SparseBooleanArray A0D;
    public final SparseIntArray A0E;
    public final C02284v A0F;
    public final LA A0G;
    public final LE A0H;
    public final List<AnonymousClass53> A0I;

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0K[5].charAt(9) == '6') {
                throw new RuntimeException();
            }
            A0K[5] = "URhJNiPfEIrBtOuckipDqR7YK4paNHr3";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
            i4++;
        }
    }

    public static void A0G() {
        A0J = new byte[]{64, 98, 109, 109, 108, 119, 35, 101, 106, 109, 103, 35, 112, 122, 109, 96, 35, 97, 122, 119, 102, 45, 35, 78, 108, 112, 119, 35, 111, 106, 104, 102, 111, 122, 35, 109, 108, 119, 35, 98, 35, 87, 113, 98, 109, 112, 115, 108, 113, 119, 35, 80, 119, 113, 102, 98, 110, 45};
    }

    static {
        A0G();
        A0L = new HD() { // from class: com.facebook.ads.redexgen.X.l6
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1671l3.A0M();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public C1671l3() {
        this(0);
    }

    public C1671l3(int i) {
        this(1, i, 112800);
    }

    public C1671l3(int i, int i2, int i3) {
        this(i, new AnonymousClass53(0L), new C1693lP(i2), i3);
    }

    public C1671l3(int i, AnonymousClass53 anonymousClass53, LE le, int i2) {
        this.A0H = (LE) AbstractC02053y.A01(le);
        this.A0A = i2;
        this.A09 = i;
        if (i == 1 || i == 2) {
            this.A0I = Collections.singletonList(anonymousClass53);
        } else {
            this.A0I = new ArrayList();
            this.A0I.add(anonymousClass53);
        }
        this.A0F = new C02284v(new byte[9400], 0);
        this.A0C = new SparseBooleanArray();
        this.A0D = new SparseBooleanArray();
        this.A0B = new SparseArray<>();
        this.A0E = new SparseIntArray();
        this.A0G = new LA(i2);
        this.A03 = HA.A00;
        this.A01 = -1;
        A0F();
    }

    private int A00() throws C3K {
        int iA09 = this.A0F.A09();
        int limit = this.A0F.A0A();
        int iA00 = LI.A00(this.A0F.A0l(), iA09, limit);
        this.A0F.A0f(iA00);
        int endOfPacket = iA00 + 188;
        if (endOfPacket > limit) {
            int i = this.A00;
            String[] strArr = A0K;
            String str = strArr[0];
            String str2 = strArr[6];
            int limit2 = str.charAt(22);
            int searchStart = str2.charAt(22);
            if (limit2 == searchStart) {
                throw new RuntimeException();
            }
            A0K[3] = "oFbhmyTyFkRbH7nwLSukkKpVMF9MBiPP";
            this.A00 = i + (iA00 - iA09);
            if (this.A09 == 2 && this.A00 > 376) {
                throw C3K.A01(A0D(0, 58, 29), null);
            }
        } else {
            this.A00 = 0;
        }
        return endOfPacket;
    }

    public static /* synthetic */ int A02(C1671l3 c1671l3) {
        int i = c1671l3.A02;
        c1671l3.A02 = i + 1;
        return i;
    }

    private void A0F() {
        this.A0C.clear();
        this.A0B.clear();
        SparseArray<LH> sparseArrayA5Q = this.A0H.A5Q();
        int size = sparseArrayA5Q.size();
        for (int i = 0; i < size; i++) {
            SparseArray<LH> sparseArray = this.A0B;
            int initialPayloadReadersSize = A0K[7].charAt(31);
            if (initialPayloadReadersSize != 85) {
                throw new RuntimeException();
            }
            A0K[5] = "Ni66o4kKOCTyHVW4880FmErKiABvWzx3";
            int initialPayloadReadersSize2 = sparseArrayA5Q.keyAt(i);
            sparseArray.put(initialPayloadReadersSize2, sparseArrayA5Q.valueAt(i));
        }
        this.A0B.put(0, new C1677l9(new C1673l5(this)));
        this.A05 = null;
    }

    private void A0H(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0G.A08() != -9223372036854775807L) {
                this.A04 = new C1675l7(this.A0G.A09(), this.A0G.A08(), j, this.A01, this.A0A);
                this.A03.AJ7(this.A04.A07());
            } else {
                this.A03.AJ7(new C1767mn(this.A0G.A08()));
            }
        }
    }

    private boolean A0I(int i) {
        return this.A09 == 2 || this.A08 || !this.A0D.get(i, false);
    }

    private boolean A0J(InterfaceC1772ms interfaceC1772ms) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        if (9400 - this.A0F.A09() < 188) {
            int bytesLeft = this.A0F.A07();
            if (bytesLeft > 0) {
                System.arraycopy(bArrA0l, this.A0F.A09(), bArrA0l, 0, bytesLeft);
            }
            this.A0F.A0j(bArrA0l, bytesLeft);
        }
        while (this.A0F.A07() < 188) {
            int iA0A = this.A0F.A0A();
            int limit = interfaceC1772ms.read(bArrA0l, iA0A, 9400 - iA0A);
            if (limit == -1) {
                return false;
            }
            this.A0F.A0e(iA0A + limit);
        }
        return true;
    }

    public static /* synthetic */ H9[] A0M() {
        return new H9[]{new C1671l3()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A03 = ha;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        LH payloadReader;
        int i;
        long jA8O = interfaceC1772ms.A8O();
        if (this.A08) {
            if (((jA8O == -1 || this.A09 == 2) ? false : true) && !this.A0G.A0A()) {
                return this.A0G.A07(interfaceC1772ms, hv, this.A01);
            }
            A0H(jA8O);
            if (this.A07) {
                this.A07 = false;
                AJ6(0L, 0L);
                if (interfaceC1772ms.A8n() != 0) {
                    hv.A00 = 0L;
                    return 1;
                }
            }
            C1675l7 c1675l7 = this.A04;
            if (A0K[3].charAt(3) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[0] = "sDiEMLnvjhOTPJNI7EdeGtcVnMMFmFVg";
            strArr[6] = "irXGtuFGajwAGmxrojJd4OjCXPAtU7cs";
            if (c1675l7 != null && this.A04.A09()) {
                return this.A04.A06(interfaceC1772ms, hv);
            }
        }
        boolean zA0J = A0J(interfaceC1772ms);
        if (A0K[5].charAt(9) == '6') {
            throw new RuntimeException();
        }
        A0K[3] = "pbqhdVjd4r56PJWJm8ke7L1TPhAXhQlh";
        if (!zA0J) {
            return -1;
        }
        int iA00 = A00();
        int iA0A = this.A0F.A0A();
        if (iA00 > iA0A) {
            return 0;
        }
        int iA0C = this.A0F.A0C();
        if ((8388608 & iA0C) == 0) {
            int limit = 0 | ((4194304 & iA0C) != 0 ? 1 : 0);
            int packetHeaderFlags = (2096896 & iA0C) >> 8;
            int tsPacketHeader = (iA0C & 32) != 0 ? 1 : 0;
            if ((iA0C & 16) != 0) {
                payloadReader = this.A0B.get(packetHeaderFlags);
            } else {
                payloadReader = null;
            }
            if (payloadReader == null) {
                this.A0F.A0f(iA00);
                return 0;
            }
            if (this.A09 != 2) {
                int i2 = iA0C & 15;
                int i3 = this.A0E.get(packetHeaderFlags, i2 - 1);
                this.A0E.put(packetHeaderFlags, i2);
                if (i3 == i2) {
                    this.A0F.A0f(iA00);
                    return 0;
                }
                if (i2 != ((i3 + 1) & 15)) {
                    payloadReader.AJ5();
                }
            }
            if (tsPacketHeader != 0) {
                int iA0I = this.A0F.A0I();
                if ((this.A0F.A0I() & 64) != 0) {
                    i = 2;
                } else {
                    i = 0;
                }
                limit |= i;
                this.A0F.A0g(iA0I - 1);
            }
            boolean z = this.A08;
            if (A0I(packetHeaderFlags)) {
                this.A0F.A0e(iA00);
                payloadReader.A5B(this.A0F, limit);
                this.A0F.A0e(iA0A);
            }
            if (this.A09 != 2 && !z && this.A08 && jA8O != -1) {
                this.A07 = true;
            }
            this.A0F.A0f(iA00);
            return 0;
        }
        this.A0F.A0f(iA00);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void AJ6(long j, long j2) {
        AbstractC02053y.A08(this.A09 != 2);
        int size = this.A0I.size();
        int i = 0;
        while (true) {
            if (i < size) {
                AnonymousClass53 anonymousClass53 = this.A0I.get(i);
                boolean z = anonymousClass53.A04() == -9223372036854775807L;
                if (!z) {
                    long jA02 = anonymousClass53.A02();
                    if (jA02 != -9223372036854775807L) {
                        String[] strArr = A0K;
                        if (strArr[0].charAt(22) == strArr[6].charAt(22)) {
                            break;
                        }
                        A0K[1] = "xsireMETvYUgN4sfQ27n1BF88Hpbgatm";
                        z = (jA02 == 0 || jA02 == j2) ? false : true;
                    }
                }
                if (z) {
                    anonymousClass53.A07(j2);
                }
                i++;
            } else if (A0K[3].charAt(3) == 'h') {
                A0K[5] = "QQ4ASPHg1MFvfTvzRH6TwvvGrvMhPJon";
                if (j2 != 0 && this.A04 != null) {
                    this.A04.A08(j2);
                }
                this.A0F.A0d(0);
                this.A0E.clear();
                for (int i2 = 0; i2 < this.A0B.size(); i2++) {
                    this.A0B.valueAt(i2).AJ5();
                }
                this.A00 = 0;
                if (A0K[5].charAt(9) != '6') {
                    String[] strArr2 = A0K;
                    strArr2[0] = "GowRIOwCagyGa1SkNIlwyA0nrp7kipic";
                    strArr2[6] = "k5JpOZ1RkOAyzQMCpU3mmbngvjfdQ1X3";
                    return;
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1772ms interfaceC1772ms) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        interfaceC1772ms.AGt(bArrA0l, 0, 940);
        for (int i = 0; i < 188; i++) {
            boolean isSyncBytePatternCorrect = true;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    break;
                }
                int startPosCandidate = bArrA0l[(i2 * 188) + i];
                if (startPosCandidate != 71) {
                    isSyncBytePatternCorrect = false;
                    break;
                }
                i2++;
            }
            if (isSyncBytePatternCorrect) {
                interfaceC1772ms.AK3(i);
                return true;
            }
        }
        return false;
    }
}
