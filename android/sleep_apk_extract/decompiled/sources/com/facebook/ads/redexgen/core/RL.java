package com.facebook.ads.redexgen.core;

import android.view.View;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class RL {
    public static String[] A00 = {"X094Ff6hX91n4UOeNZ5q6xBODyRF", "3SZuvdCuB3BE6lfK5qku2XxobaMEdUie", "GC5CoEiK4nrbG2wHW0FtwppW4DiO", "wga3z1tjiA3hov6SpIvZwMukezgQNZlv", "3xUgR2JHsSdawQ9thG1dfHrpvR", "GYcoMrIBN4ZdBxcuGgG7c5lcAAiSjlKe", "4bECUaOSHZBdJ", ""};

    public static int A00(@Nullable RH rh, @Nullable AbstractC0765Qm abstractC0765Qm, View view, View view2, R2 r2, boolean z) {
        if (r2.A0Y() != 0) {
            int iA03 = rh.A03();
            if (A00[0].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[1] = "A1oAKfZoAPhZUsftVBl6ZIJw4txQWtbe";
            strArr[5] = "SaLVqq6GZrXjANh28rEV2dsKSTV0teZe";
            if (iA03 == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(r2.A0r(view) - r2.A0r(view2)) + 1;
            }
            int iA0C = abstractC0765Qm.A0C(view2) - abstractC0765Qm.A0F(view);
            int extend = abstractC0765Qm.A0B();
            return Math.min(extend, iA0C);
        }
        return 0;
    }

    public static int A01(@Nullable RH rh, @Nullable AbstractC0765Qm abstractC0765Qm, View view, View view2, R2 r2, boolean z) {
        if (r2.A0Y() == 0 || rh.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return rh.A03();
        }
        int iA0C = abstractC0765Qm.A0C(view2) - abstractC0765Qm.A0F(view);
        int iA0r = r2.A0r(view);
        int laidOutArea = r2.A0r(view2);
        float fAbs = iA0C / (Math.abs(iA0r - laidOutArea) + 1);
        int laidOutArea2 = rh.A03();
        return (int) (fAbs * laidOutArea2);
    }

    public static int A02(@Nullable RH rh, @Nullable AbstractC0765Qm abstractC0765Qm, View view, View view2, R2 r2, boolean z, boolean z2) {
        int laidOutArea;
        if (r2.A0Y() == 0 || rh.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        int maxPosition = Math.min(r2.A0r(view), r2.A0r(view2));
        int iA0r = r2.A0r(view);
        int minPosition = r2.A0r(view2);
        int iMax = Math.max(iA0r, minPosition);
        if (z2) {
            int minPosition2 = rh.A03();
            laidOutArea = Math.max(0, (minPosition2 - iMax) - 1);
        } else {
            laidOutArea = Math.max(0, maxPosition);
        }
        if (!z) {
            return laidOutArea;
        }
        int itemsBefore = abstractC0765Qm.A0C(view2);
        int minPosition3 = abstractC0765Qm.A0F(view);
        int maxPosition2 = Math.abs(itemsBefore - minPosition3);
        int itemsBefore2 = r2.A0r(view);
        int minPosition4 = r2.A0r(view2);
        float fAbs = laidOutArea * (maxPosition2 / (Math.abs(itemsBefore2 - minPosition4) + 1));
        int itemsBefore3 = abstractC0765Qm.A0A();
        int minPosition5 = abstractC0765Qm.A0F(view);
        return Math.round(fAbs + (itemsBefore3 - minPosition5));
    }
}
