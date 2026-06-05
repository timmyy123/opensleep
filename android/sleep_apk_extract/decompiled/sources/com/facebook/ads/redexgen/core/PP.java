package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class PP {
    public static String[] A05 = {"HMLUAMeWTnTdrFyTRCB7w3ZhJ", "1Aun6", "yTavC3hBHsVyJRra79jdVUTW7IEAkuRz", "tJ693OcumSOXrVCtzwSe90nGcRRSjuPr", "DrEyERnZlKSQp8AkPycUbQNlm94xmy5e", "2BUIq1m7obUXC577xarT453dfNaADk5N", "yJUqjpNvvORIKjYa1o1Wy5wtSjtgR6zYd", "0hzYa3ofwknJpPrn6YTjRWoRNT8nV8gu"};
    public ViewParent A00;
    public ViewParent A01;
    public boolean A02;
    public int[] A03;
    public final View A04;

    public PP(View view) {
        this.A04 = view;
    }

    private ViewParent A00(int i) {
        switch (i) {
            case 0:
                return this.A01;
            case 1:
                return this.A00;
            default:
                return null;
        }
    }

    private void A01(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.A01 = viewParent;
                break;
            case 1:
                this.A00 = viewParent;
                break;
        }
    }

    public final void A02() {
        A03(0);
    }

    public final void A03(int i) {
        ViewParent viewParentA00 = A00(i);
        if (viewParentA00 != null) {
            AbstractC0751Px.A02(viewParentA00, this.A04, i);
            A01(i, null);
        }
    }

    public final void A04(boolean z) {
        if (this.A02) {
            View view = this.A04;
            if (A05[0].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[2] = "sPOLp35TsNHusY6V5G0bvTSrJPIVSPnr";
            strArr[7] = "EPAyi3E2WcCopkomgXFhWqOsQM7C57d6";
            Ph.A08(view);
        }
        this.A02 = z;
    }

    public final boolean A05() {
        return A09(0);
    }

    public final boolean A06() {
        return this.A02;
    }

    public final boolean A07(float f, float f2) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AbstractC0751Px.A06(viewParentA00, this.A04, f, f2);
    }

    public final boolean A08(float f, float f2, boolean z) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AbstractC0751Px.A07(viewParentA00, this.A04, f, f2, z);
    }

    public final boolean A09(int i) {
        return A00(i) != null;
    }

    public final boolean A0A(int i) {
        return A0B(i, 0);
    }

    public final boolean A0B(int i, int i2) {
        if (A09(i2)) {
            return true;
        }
        if (A06()) {
            View view = this.A04;
            for (ViewParent parent = this.A04.getParent(); parent != null; parent = parent.getParent()) {
                if (AbstractC0751Px.A08(parent, view, this.A04, i, i2)) {
                    A01(i2, parent);
                    AbstractC0751Px.A05(parent, view, this.A04, i, i2);
                    return true;
                }
                boolean z = parent instanceof View;
                if (A05[1].length() != 5) {
                    throw new RuntimeException();
                }
                A05[0] = "7BAbpT06x25B1B2yqAUEO7iBu";
                if (z) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean A0C(int i, int i2, int i3, int i4, int[] iArr) {
        return A0D(i, i2, i3, i4, iArr, 0);
    }

    public final boolean A0D(int i, int i2, int startX, int startY, int[] iArr, int i3) {
        ViewParent viewParentA00;
        if (!A06() || (viewParentA00 = A00(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || startX != 0 || startY != 0) {
            int i4 = 0;
            int startY2 = 0;
            if (iArr != null) {
                this.A04.getLocationInWindow(iArr);
                i4 = iArr[0];
                startY2 = iArr[1];
            }
            View view = this.A04;
            String[] strArr = A05;
            if (strArr[3].charAt(11) != strArr[5].charAt(11)) {
                throw new RuntimeException();
            }
            A05[0] = "CJefiU87NJ7XNqmbcPXjJdErx";
            AbstractC0751Px.A03(viewParentA00, view, i, i2, startX, startY, i3);
            if (iArr != null) {
                this.A04.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i4;
                iArr[1] = iArr[1] - startY2;
            }
            return true;
        }
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return false;
    }

    public final boolean A0E(int i, int i2, int[] iArr, int[] iArr2) {
        return A0F(i, i2, iArr, iArr2, 0);
    }

    public final boolean A0F(int startX, int startY, int[] iArr, int[] iArr2, int i) {
        ViewParent parent;
        int[] consumed = iArr;
        if (!A06() || (parent = A00(i)) == null) {
            return false;
        }
        if (startX != 0 || startY != 0) {
            int i2 = 0;
            int i3 = 0;
            if (iArr2 != null) {
                this.A04.getLocationInWindow(iArr2);
                i2 = iArr2[0];
                i3 = iArr2[1];
            }
            if (consumed == null) {
                int[] iArr3 = this.A03;
                String[] strArr = A05;
                if (strArr[4].length() == strArr[6].length()) {
                    throw new RuntimeException();
                }
                A05[0] = "EXwhuqfa8PSenPC96DfC6aE38";
                if (iArr3 == null) {
                    this.A03 = new int[2];
                }
                consumed = this.A03;
            }
            consumed[0] = 0;
            consumed[1] = 0;
            AbstractC0751Px.A04(parent, this.A04, startX, startY, consumed, i);
            if (iArr2 != null) {
                this.A04.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i2;
                iArr2[1] = iArr2[1] - i3;
            }
            return (consumed[0] == 0 && consumed[1] == 0) ? false : true;
        }
        if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }
}
