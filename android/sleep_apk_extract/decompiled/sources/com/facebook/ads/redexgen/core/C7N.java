package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7N extends AbstractC1469hU {
    public static String[] A02 = {"ZvwGPtqIyq", "yiAZi4T0ry", "MW2e2TOPDP9pjEe4rTD", "HlrRgmhjIEURNOsi3rdB558cP", "dU7euze3hj2U1ev62XjIRTQ2vrQriAnf", "8gl08jl5gi3EpiFcU", "SXjkVQ4wGxN0zpwvt09Xfw5qzXSeRw0d", "Y5nQdyuIxyo1Orqk0oN6DnQ8XCev4LBn"};
    public AbstractC0765Qm A00;
    public AbstractC0765Qm A01;

    private int A00(R2 r2, View view, AbstractC0765Qm abstractC0765Qm) {
        int containerCenter;
        int iA0F = abstractC0765Qm.A0F(view) + (abstractC0765Qm.A0D(view) / 2);
        if (r2.A1V()) {
            int iA0A = abstractC0765Qm.A0A();
            int childCenter = abstractC0765Qm.A0B();
            containerCenter = iA0A + (childCenter / 2);
        } else {
            int childCenter2 = abstractC0765Qm.A06();
            containerCenter = childCenter2 / 2;
        }
        return iA0F - containerCenter;
    }

    private View A01(R2 r2, AbstractC0765Qm abstractC0765Qm) {
        int i;
        int iA0Y = r2.A0Y();
        if (iA0Y == 0) {
            return null;
        }
        View view = null;
        if (r2.A1V()) {
            int iA0A = abstractC0765Qm.A0A();
            int childCount = abstractC0765Qm.A0B();
            i = iA0A + (childCount / 2);
        } else {
            int childCount2 = abstractC0765Qm.A06();
            i = childCount2 / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < iA0Y; i3++) {
            View viewA0v = r2.A0v(i3);
            int iA0F = abstractC0765Qm.A0F(viewA0v);
            int childCount3 = abstractC0765Qm.A0D(viewA0v);
            int childCount4 = Math.abs((iA0F + (childCount3 / 2)) - i);
            if (childCount4 < i2) {
                i2 = childCount4;
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[1];
                int length = str.length();
                int childCount5 = str2.length();
                if (length != childCount5) {
                    throw new RuntimeException();
                }
                A02[5] = "j4bRVUHHACnikA";
                view = viewA0v;
            }
        }
        return view;
    }

    private View A02(R2 r2, AbstractC0765Qm abstractC0765Qm) {
        int iA0Y = r2.A0Y();
        if (iA0Y == 0) {
            return null;
        }
        View view = null;
        int i = Integer.MAX_VALUE;
        if (A02[7].charAt(21) == '9') {
            throw new RuntimeException();
        }
        A02[7] = "DwjJFjjR1ioErHTPj2QZ0AbXqU5bWHnc";
        for (int childCount = 0; childCount < iA0Y; childCount++) {
            View viewA0v = r2.A0v(childCount);
            int iA0F = abstractC0765Qm.A0F(viewA0v);
            if (iA0F < i) {
                i = iA0F;
                view = viewA0v;
            }
        }
        return view;
    }

    private AbstractC0765Qm A03(R2 r2) {
        if (this.A00 == null || this.A00.A02 != r2) {
            this.A00 = AbstractC0765Qm.A00(r2);
        }
        return this.A00;
    }

    private AbstractC0765Qm A04(R2 r2) {
        if (this.A01 == null || this.A01.A02 != r2) {
            this.A01 = AbstractC0765Qm.A01(r2);
        }
        return this.A01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.core.AbstractC1469hU
    public final int A0C(R2 r2, int i, int i2) {
        int iA0r;
        int centerPosition;
        int iA0b = r2.A0b();
        if (iA0b == 0) {
            return -1;
        }
        View viewA02 = null;
        if (r2.A23()) {
            viewA02 = A02(r2, A04(r2));
        } else if (r2.A22()) {
            viewA02 = A02(r2, A03(r2));
        }
        if (viewA02 == null || (iA0r = r2.A0r(viewA02)) == -1) {
            return -1;
        }
        if (r2.A22()) {
            centerPosition = i > 0 ? 1 : 0;
        } else {
            centerPosition = i2 > 0 ? 1 : 0;
        }
        boolean z = false;
        if (r2 instanceof RE) {
            int itemCount = iA0b - 1;
            PointF pointFA56 = ((RE) r2).A56(itemCount);
            if (pointFA56 != null) {
                z = pointFA56.x < 0.0f || pointFA56.y < 0.0f;
            }
        }
        return z ? centerPosition != 0 ? iA0r - 1 : iA0r : centerPosition != 0 ? iA0r + 1 : iA0r;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1469hU
    public final View A0D(R2 r2) {
        if (r2.A23()) {
            return A01(r2, A04(r2));
        }
        if (r2.A22()) {
            View viewA01 = A01(r2, A03(r2));
            if (A02[4].charAt(24) != 'v') {
                throw new RuntimeException();
            }
            A02[5] = "ku3zp";
            return viewA01;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1469hU
    public final C1490hq A0E(R2 r2) {
        if (!(r2 instanceof RE)) {
            return null;
        }
        final Context context = super.A00.getContext();
        return new C1490hq(context) { // from class: com.facebook.ads.redexgen.X.7O
            @Override // com.facebook.ads.redexgen.core.C1490hq, com.facebook.ads.redexgen.core.RF
            public final void A0I(View view, RH rh, RD rd) {
                int[] iArrA0H = this.A00.A0H(((AbstractC1469hU) this.A00).A00.getLayoutManager(), view);
                int time = iArrA0H[0];
                int dy = iArrA0H[1];
                int dx = A0M(Math.max(Math.abs(time), Math.abs(dy)));
                if (dx > 0) {
                    rd.A04(time, dy, dx, ((C1490hq) this).A04);
                }
            }

            @Override // com.facebook.ads.redexgen.core.C1490hq
            public final float A0J(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // com.facebook.ads.redexgen.core.C1490hq
            public final int A0L(int i) {
                return Math.min(100, super.A0L(i));
            }
        };
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1469hU
    public final int[] A0H(R2 r2, View view) {
        int[] iArr = new int[2];
        if (r2.A22()) {
            iArr[0] = A00(r2, view, A03(r2));
        } else {
            iArr[0] = 0;
        }
        if (r2.A23()) {
            iArr[1] = A00(r2, view, A04(r2));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
