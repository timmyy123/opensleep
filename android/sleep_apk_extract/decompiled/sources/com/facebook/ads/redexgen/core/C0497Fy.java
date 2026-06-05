package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0497Fy extends R7 {
    public static byte[] A0H;
    public static String[] A0I = {"oHxG", "", "w7XeyG7wcXlBDThCLG4YobF5JePdGcu8", "IQ8LgqWvoXOpUTXgnww89j6rU6uuZ1nj", "", "WKMwHhIum9", "0nm7H4VWCUBWNiJwCQAonSVvBZFyt", "hLsDwSpuFLAE"};
    public InterfaceC1182cp A02;
    public C1366fp A04;
    public List<C1259e5> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C1491hr A0C;
    public final RF A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final InterfaceC1186ct A0F = new G1(this);
    public InterfaceC1184cr A03 = new G0(this);
    public final InterfaceC1185cs A0E = new C0498Fz(this);

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        String[] strArr = A0I;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[7] = "Cbp585p0FHy9";
        strArr2[6] = "QC7w158vCCR5KGktiGCBodiqPhNZq";
        A0H = new byte[]{-122, -102, -103, -108, -92, -107, -111, -122, -98, -92, -118, -109, -122, -121, -111, -118, -119, -92, -107, -122, -105, -122, -110, 81, 91, 103, 78, 81, 90, 91, 92, 103, 94, 81, 76, 77, 87, 103, 88, 73, 90, 73, 85, -51, -58, -61, -52, -60, -68, -42, -61, -68, -51, -68, -61, -42, -57, -72, -55, -72, -60};
    }

    static {
        A08();
    }

    public C0497Fy(C1J c1j, int i, List<C1259e5> list, C1366fp c1366fp, Bundle bundle) {
        this.A0C = c1j.getLayoutManager();
        this.A0A = i;
        this.A05 = list;
        this.A04 = c1366fp;
        this.A0D = new C1490hq(c1j.getContext());
        this.A0B = c1j.getContext();
        c1j.A1h(this);
        A0D(bundle);
    }

    private AbstractC0582Jg A03(int i, int i2) {
        return A04(i, i2, true);
    }

    private AbstractC0582Jg A04(int i, int i2, boolean z) {
        AbstractC0582Jg abstractC0582Jg = null;
        while (i <= i2) {
            AbstractC0582Jg abstractC0582Jg2 = (AbstractC0582Jg) this.A0C.A1o(i);
            if (abstractC0582Jg2 == null || abstractC0582Jg2.A1U()) {
                return null;
            }
            boolean zA0a = A0a(abstractC0582Jg2);
            if (abstractC0582Jg == null && abstractC0582Jg2.A1V() && zA0a && !this.A0G.contains(Integer.valueOf(i)) && (!z || A0I(abstractC0582Jg2, this.A0A))) {
                abstractC0582Jg = abstractC0582Jg2;
            }
            if (abstractC0582Jg2.A1V() && !zA0a) {
                A0C(i, false);
            }
            i++;
        }
        return abstractC0582Jg;
    }

    private void A06() {
        if (!this.A07) {
            return;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        AbstractC0582Jg abstractC0582JgA03 = A03(lastVisibleItem, firstVisibleItem);
        if (abstractC0582JgA03 != null) {
            abstractC0582JgA03.A1S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA25 = this.A0C.A25();
        if (iA25 != -1) {
            int curPos = this.A05.size();
            if (iA25 < curPos - 1) {
                int curPos2 = iA25 + 1;
                A0U(curPos2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i) {
        AbstractC0582Jg abstractC0582JgA04 = A04(i + 1, this.A0C.A27(), false);
        if (abstractC0582JgA04 != null) {
            abstractC0582JgA04.A1S();
            A0U(((Integer) abstractC0582JgA04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i, int i2) {
        while (i <= i2) {
            A0T(i);
            i++;
        }
    }

    private final void A0B(int i, int i2) {
        A0S(i);
        A0S(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i, boolean z) {
        if (z) {
            this.A0G.add(Integer.valueOf(i));
        } else {
            this.A0G.remove(Integer.valueOf(i));
        }
    }

    private void A0D(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 112), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 62), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 1), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return this.A0A == 1;
    }

    public static boolean A0I(AbstractC1134c3 abstractC1134c3, int i) {
        int allowedAreaMaxX;
        int furthestX;
        if (i == 2) {
            allowedAreaMaxX = XX.A04.widthPixels - 1;
        } else {
            int width = abstractC1134c3.getWidth();
            int allowedAreaMinX = XX.A04.widthPixels;
            allowedAreaMaxX = (int) (((width + allowedAreaMinX) * 1.3f) / 2.0f);
        }
        if (i == 2) {
            furthestX = 1;
        } else {
            int i2 = XX.A04.widthPixels;
            int allowedAreaMinX2 = abstractC1134c3.getWidth();
            furthestX = (int) (((i2 - allowedAreaMinX2) * 0.7f) / 2.0f);
        }
        float x = abstractC1134c3.getX();
        int allowedAreaMinX3 = abstractC1134c3.getWidth();
        return ((int) (x + ((float) allowedAreaMinX3))) <= allowedAreaMaxX && abstractC1134c3.getX() >= ((float) furthestX);
    }

    private boolean A0J(AbstractC0582Jg abstractC0582Jg) {
        if (!this.A08 || !abstractC0582Jg.A1V()) {
            return false;
        }
        this.A08 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public void A0L(C7M c7m, int i) {
        super.A0L(c7m, i);
        if (i == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public void A0M(C7M c7m, int i, int i2) {
        super.A0M(c7m, i, i2);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        A0B(lastVisibleItem, firstVisibleItem);
        A0A(lastVisibleItem, firstVisibleItem);
        A0V(lastVisibleItem, firstVisibleItem, i);
    }

    public final InterfaceC1184cr A0N() {
        return this.A03;
    }

    public final InterfaceC1185cs A0O() {
        return this.A0E;
    }

    public final InterfaceC1186ct A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int iA27 = this.A0C.A27();
        for (int iA26 = this.A0C.A26(); iA26 <= iA27 && iA26 >= 0; iA26++) {
            AbstractC0582Jg card = (AbstractC0582Jg) this.A0C.A1o(iA26);
            String[] strArr = A0I;
            String str = strArr[1];
            String str2 = strArr[4];
            int lastPos = str.length();
            int firstPos = str2.length();
            if (lastPos != firstPos) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[0] = "4n0r";
            strArr2[5] = "UAml839wpr";
            if (card != null && card.A1U()) {
                this.A01 = iA26;
                card.A1R();
                return;
            }
        }
    }

    public final void A0R() {
        AbstractC0582Jg abstractC0582Jg = (AbstractC0582Jg) this.A0C.A1o(this.A01);
        if (abstractC0582Jg != null && this.A01 >= 0) {
            abstractC0582Jg.A1S();
        }
    }

    public final void A0S(int i) {
        AbstractC0582Jg abstractC0582Jg = (AbstractC0582Jg) this.A0C.A1o(i);
        if (abstractC0582Jg != null && !A0a(abstractC0582Jg)) {
            A0Z(abstractC0582Jg, false);
        }
    }

    public final void A0T(int i) {
        AbstractC0582Jg abstractC0582Jg = (AbstractC0582Jg) this.A0C.A1o(i);
        if (abstractC0582Jg == null) {
            return;
        }
        if (A0a(abstractC0582Jg)) {
            A0Z(abstractC0582Jg, true);
        }
        if (A0J(abstractC0582Jg) && this.A05 != null) {
            this.A0F.setVolume(this.A05.get(((Integer) abstractC0582Jg.getTag(-1593835536)).intValue()).A03().A0H().A0A() ? 0.0f : 1.0f);
        }
    }

    public final void A0U(int i) {
        this.A0D.A0A(i);
        this.A0C.A1N(this.A0D);
    }

    public final void A0V(int i, int i2, int i3) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int recomputeFrom = this.A0C.A25();
        if (recomputeFrom == -1) {
            recomputeFrom = i3 < 0 ? i : i2;
        }
        this.A02.AKa(recomputeFrom);
    }

    public final void A0W(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 112), this.A00);
        bundle.putBoolean(A05(0, 23, 62), this.A07);
        bundle.putBoolean(A05(23, 20, 1), this.A08);
    }

    public void A0X(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    public final void A0Y(InterfaceC1182cp interfaceC1182cp) {
        this.A02 = interfaceC1182cp;
    }

    public void A0Z(AbstractC0582Jg abstractC0582Jg, boolean z) {
        if (A0H()) {
            A0X(abstractC0582Jg, z);
        }
        if (!z && abstractC0582Jg.A1U()) {
            abstractC0582Jg.A1R();
        }
    }

    public boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}
