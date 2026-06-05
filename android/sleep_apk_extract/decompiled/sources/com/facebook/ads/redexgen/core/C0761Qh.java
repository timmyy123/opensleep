package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0761Qh {
    public static String[] A0C = {"zYBO", "VrDNMGAmElYb4SYFj9Lpkrq1UWScNn1g", "4mNmwJxO6cgQvBVSRxGC", "9gqvUwqHV9nyPc72vXSv6mEX866dBdM", "nltTkdARyojUYdv3T0NiqQmXwvESfaB", "A7Q8ygVI07x7oKl7LsiAf8", "TfmPmCKdg", "Y"};
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public boolean A09;
    public boolean A0B = true;
    public int A02 = 0;
    public boolean A0A = false;
    public List<RK> A08 = null;

    private View A00() {
        int size = this.A08.size();
        for (int i = 0; i < size; i++) {
            View view = this.A08.get(i).A0H;
            R3 r3 = (R3) view.getLayoutParams();
            if (!r3.A02()) {
                int i2 = this.A01;
                int size2 = r3.A00();
                if (i2 == size2) {
                    A02(view);
                    return view;
                }
            }
        }
        String[] strArr = A0C;
        String str = strArr[3];
        String str2 = strArr[4];
        int length = str.length();
        int size3 = str2.length();
        if (length != size3) {
            throw new RuntimeException();
        }
        A0C[0] = "XAMH";
        return null;
    }

    private final View A01(View view) {
        int size = this.A08.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = this.A08.get(i2).A0H;
            R3 r3 = (R3) view3.getLayoutParams();
            if (view3 != view) {
                boolean zA02 = r3.A02();
                if (A0C[1].charAt(18) != 'L') {
                    throw new RuntimeException();
                }
                A0C[2] = "5fjKcvOJD7";
                if (zA02) {
                    continue;
                } else {
                    int iA00 = r3.A00();
                    int size2 = this.A01;
                    int i3 = iA00 - size2;
                    int size3 = this.A03;
                    int i4 = i3 * size3;
                    if (i4 >= 0 && i4 < i) {
                        view2 = view3;
                        i = i4;
                        if (i4 == 0) {
                            break;
                        }
                    }
                }
            }
        }
        return view2;
    }

    private final void A02(View view) {
        View closest = A01(view);
        if (closest == null) {
            this.A01 = -1;
        } else {
            this.A01 = ((R3) closest.getLayoutParams()).A00();
        }
    }

    public final View A03(RA ra) {
        if (this.A08 != null) {
            return A00();
        }
        View viewA0G = ra.A0G(this.A01);
        this.A01 += this.A03;
        return viewA0G;
    }

    public final void A04() {
        A02(null);
    }

    public final boolean A05(RH rh) {
        return this.A01 >= 0 && this.A01 < rh.A03();
    }
}
