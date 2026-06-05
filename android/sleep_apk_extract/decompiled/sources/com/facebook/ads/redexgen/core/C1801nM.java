package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1801nM extends AbstractC0455Eh<C1801nM> implements Comparable<C1801nM> {
    public static String[] A0I = {"kuPF6Ds61I7lkNvdz9bcVPsTInik8V3M", "Qk0zKRkYsaxRz9XBLHG1rmY7ne3qL", "U5xl3sY91uvZaW", "4oEkNGaUX02G9U6MTdWApFSB5pjWlUNx", "CFtCC3eFdvC", "EnNVjubCw6rdwWEp5vRTdV2Ipxq1ST06", "834ujo2VifTXBI2K", "5tr2zEJniV6LNy5ijK5ku"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final C03399i A0A;
    public final String A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final boolean A0G;
    public final boolean A0H;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C1801nM(int i, C1944pg c1944pg, int i2, C03399i c03399i, int i3, boolean z, InterfaceC1652kj<C1981qI> interfaceC1652kj) {
        super(i, c1944pg, i2);
        this.A0A = c03399i;
        this.A0B = C03389h.A0K(super.A02.A0V);
        this.A0F = C03389h.A0S(i3, false);
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            if (i6 >= c03399i.A0I.size()) {
                break;
            }
            int iA02 = C03389h.A02(super.A02, c03399i.A0I.get(i6), false);
            if (iA02 > 0) {
                i5 = i6;
                i4 = iA02;
                break;
            }
            i6++;
        }
        this.A04 = i5;
        this.A05 = i4;
        this.A07 = C03389h.A00(super.A02.A0E, ((C1940pc) c03399i).A0B);
        this.A0C = super.A02.A0E == 0 || (super.A02.A0E & 1) != 0;
        this.A0D = (super.A02.A0H & 1) != 0;
        this.A01 = super.A02.A06;
        this.A08 = super.A02.A0G;
        this.A00 = super.A02.A05;
        this.A0E = (super.A02.A05 == -1 || super.A02.A05 <= ((C1940pc) c03399i).A01) && (super.A02.A06 == -1 || super.A02.A06 <= ((C1940pc) c03399i).A02) && interfaceC1652kj.A4C(super.A02);
        String[] strArrA1L = C5C.A1L();
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= strArrA1L.length) {
                break;
            }
            int iA022 = C03389h.A02(super.A02, strArrA1L[i9], false);
            if (iA022 > 0) {
                i7 = i9;
                i8 = iA022;
                break;
            }
            i9++;
        }
        this.A02 = i7;
        this.A03 = i8;
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        while (true) {
            if (i11 < c03399i.A0J.size()) {
                if (super.A02.A0W != null && super.A02.A0W.equals(c03399i.A0J.get(i11))) {
                    i10 = i11;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        this.A06 = i10;
        this.A0H = AbstractC02937i.A02(i3) == 128;
        this.A0G = AbstractC02937i.A04(i3) == 64;
        this.A09 = A00(i3, z);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A02(List<C1801nM> list, List<C1801nM> list2) {
        return ((C1801nM) Collections.max(list)).compareTo((C1801nM) Collections.max(list2));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static BP<C1801nM> A03(int i, C1944pg c1944pg, C03399i c03399i, int[] iArr, boolean z, InterfaceC1652kj<C1981qI> interfaceC1652kj) {
        C2K c2kA01 = BP.A01();
        for (int i2 = 0; i2 < c1944pg.A01; i2++) {
            c2kA01.A04(new C1801nM(i, c1944pg, i2, c03399i, iArr[i2], z, interfaceC1652kj));
        }
        return c2kA01.A05();
    }

    private int A00(int i, boolean z) {
        if (!C03389h.A0S(i, this.A0A.A0B)) {
            return 0;
        }
        if (!this.A0E && !this.A0A.A09) {
            return 0;
        }
        if (C03389h.A0S(i, false) && this.A0E && super.A02.A05 != -1 && !this.A0A.A0N && !this.A0A.A0O && (this.A0A.A04 || !z)) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<java.lang.Integer> */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1801nM c1801nM) {
        AbstractC1983qK abstractC1983qKA06;
        AbstractC1983qK abstractC1983qKA062 = (this.A0E && this.A0F) ? C03389h.A09 : C03389h.A09.A06();
        AbstractC1833ns abstractC1833nsA08 = AbstractC1833ns.A01().A09(this.A0F, c1801nM.A0F).A08(Integer.valueOf(this.A04), Integer.valueOf(c1801nM.A04), AbstractC1983qK.A03().A06()).A06(this.A05, c1801nM.A05).A06(this.A07, c1801nM.A07).A09(this.A0D, c1801nM.A0D).A09(this.A0C, c1801nM.A0C).A08(Integer.valueOf(this.A02), Integer.valueOf(c1801nM.A02), AbstractC1983qK.A03().A06()).A06(this.A03, c1801nM.A03).A09(this.A0E, c1801nM.A0E).A08(Integer.valueOf(this.A06), Integer.valueOf(c1801nM.A06), AbstractC1983qK.A03().A06());
        Integer numValueOf = Integer.valueOf(this.A00);
        Integer numValueOf2 = Integer.valueOf(c1801nM.A00);
        if (this.A0A.A0O) {
            abstractC1983qKA06 = C03389h.A09.A06();
        } else {
            abstractC1983qKA06 = C03389h.A0A;
        }
        AbstractC1833ns abstractC1833nsA082 = abstractC1833nsA08.A08(numValueOf, numValueOf2, abstractC1983qKA06).A09(this.A0H, c1801nM.A0H).A09(this.A0G, c1801nM.A0G).A08(Integer.valueOf(this.A01), Integer.valueOf(c1801nM.A01), abstractC1983qKA062).A08(Integer.valueOf(this.A08), Integer.valueOf(c1801nM.A08), abstractC1983qKA062);
        Integer numValueOf3 = Integer.valueOf(this.A00);
        Integer numValueOf4 = Integer.valueOf(c1801nM.A00);
        if (!C5C.A1E(this.A0B, c1801nM.A0B)) {
            abstractC1983qKA062 = C03389h.A0A;
        }
        return abstractC1833nsA082.A08(numValueOf3, numValueOf4, abstractC1983qKA062).A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    @Override // com.facebook.ads.redexgen.core.AbstractC0455Eh
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A09(C1801nM c1801nM) {
        if (this.A0A.A00) {
            if ((this.A0A.A02 || (super.A02.A0W != null && TextUtils.equals(super.A02.A0W, ((AbstractC0455Eh) c1801nM).A02.A0W))) && ((this.A0A.A03 || (super.A02.A0G != -1 && super.A02.A0G == ((AbstractC0455Eh) c1801nM).A02.A0G)) && (this.A0A.A01 || (this.A0H == c1801nM.A0H && this.A0G == c1801nM.A0G)))) {
                return true;
            }
        } else if (super.A02.A06 != -1) {
            int i = super.A02.A06;
            String[] strArr = A0I;
            if (strArr[5].charAt(5) == strArr[0].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[5] = "4j0Ebeo7wJOJZxGoc5hIgJQJaA3nIP6d";
            strArr2[0] = "7JU6hRyIHJ6Xx4Pnq3EsCWmSiYve8JpD";
            if (i == ((AbstractC0455Eh) c1801nM).A02.A06) {
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0455Eh
    public final int A08() {
        return this.A09;
    }
}
