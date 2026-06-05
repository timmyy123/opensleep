package com.facebook.ads.redexgen.core;

import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ye, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0959Ye extends LinearLayout {
    public static byte[] A09;
    public static String[] A0A = {"c7FfjQ6y3HaOHMc3qahze5tazZKFUWq1", "dcjzuF3AqOMcB85rWB1c89WERUNuq1B5", "XaDq3zOpduRXpYeV6weqhdOc6hHMeHaG", "Q9qxFF5jdCSss8nmQrnDrKCnC4cH87bf", "mFimVIfUvc9UC82U0ppl8tgspTjbkT4E", "57zseqNU9OKtNdE63wjpGd4u4uyNaDsl", "MUX7fVpzJp514oXL2qVdvbHezKVj77rn", "k1MvgkHtcy8fDpGprRj2aO2t64o5A9wC"};
    public int A00;
    public ImageView A01;
    public final TextView A02;
    public final AbstractC1586jd A03;
    public final C0827Sx A04;
    public final C1421gi A05;
    public final EnumC0961Yg A06;
    public final C1104bZ A07;
    public final String A08;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0A;
            if (strArr[3].charAt(13) != strArr[1].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[3] = "OzxZ8QvRVggYR8fS16eYEPx7e3FaNVjG";
            strArr2[1] = "hJPaGMutZvNvi8XFOWZAJRaNW6kshKbn";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 90);
            i4++;
        }
    }

    public static void A06() {
        A09 = new byte[]{102, 102, 102, 15, 53, 36, 36, 9, 96, 72, 94, 88, 72, 102, 16, 1, 1, 46, 30, 1, 20, 31, 46, 16, 21, 2};
    }

    static {
        A06();
    }

    public C0959Ye(C1421gi c1421gi, AbstractC1586jd abstractC1586jd, EnumC0961Yg enumC0961Yg, int i) {
        super(c1421gi);
        this.A05 = c1421gi;
        this.A04 = new C0827Sx(this.A05);
        this.A03 = abstractC1586jd;
        this.A06 = enumC0961Yg;
        this.A00 = i;
        this.A08 = A05(A03());
        Drawable drawableA00 = A00();
        setOrientation(0);
        YB.A0T(this, enumC0961Yg.A00, new float[]{C0735Pe.A0B, C0735Pe.A0B, 0.0f, 0.0f, 0.0f, 0.0f, C0735Pe.A0B, C0735Pe.A0B});
        setPadding(XV.A05, XV.A0S, XV.A05, XV.A0S);
        LinearLayout.LayoutParams iconLayout = new LinearLayout.LayoutParams(C0735Pe.A0A, C0735Pe.A0A);
        iconLayout.gravity = 17;
        iconLayout.rightMargin = XV.A0t;
        if (drawableA00 != null) {
            this.A01 = new C1115bk(c1421gi);
            this.A01.setImageDrawable(drawableA00);
            this.A01.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            addView(this.A01, iconLayout);
        }
        LinearLayout.LayoutParams iconLayout2 = new LinearLayout.LayoutParams(-2, -2);
        iconLayout2.gravity = 17;
        this.A02 = new TextView(c1421gi);
        this.A02.setSingleLine(true);
        this.A02.setTextColor(enumC0961Yg.A01);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        YB.A0a(this.A02, true, 14);
        addView(this.A02, iconLayout2);
        this.A07 = new C1104bZ(c1421gi, 0, enumC0961Yg.A01, YM.RIGHT_ARROW_ICON);
        LinearLayout.LayoutParams arrowLayout = new LinearLayout.LayoutParams(XV.A05, XV.A05);
        arrowLayout.gravity = 17;
        addView(this.A07, arrowLayout);
    }

    private Drawable A00() {
        Drawable drawableA02 = A02();
        Drawable clientIcon = A01();
        if ((!this.A03.A20() || drawableA02 == null) && clientIcon != null) {
            return clientIcon;
        }
        return drawableA02;
    }

    private Drawable A01() {
        try {
            PackageManager packageManager = this.A05.getPackageManager();
            if (packageManager != null) {
                return this.A05.getApplicationInfo().loadIcon(packageManager);
            }
        } catch (Exception e) {
            this.A05.A08().ABC(A04(14, 12, 43), 3802, new C0834Te(e));
        }
        String[] strArr = A0A;
        if (strArr[2].charAt(3) == strArr[7].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[3] = "jUfyBK5zlH0tl8V7sWmOgq7X259zWj2J";
        strArr2[1] = "SGIYZLeU9975u8UEdBoCCWNy5l7CdrBr";
        return null;
    }

    private Drawable A02() {
        String strA11 = this.A03.A11();
        if (!TextUtils.isEmpty(strA11)) {
            try {
                return new BitmapDrawable(this.A05.getResources(), this.A04.A0O(strA11, C0735Pe.A0A, C0735Pe.A0A));
            } catch (Exception ex) {
                this.A05.A08().ABC(A04(14, 12, 43), 3801, new C0834Te(ex));
            }
        }
        String[] strArr = A0A;
        if (strArr[6].charAt(24) != strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[4] = "ZW7Ma5Rt6RF6OtA2ZfTqzGK0I4YaPrZB";
        strArr2[5] = "zx4dLaY49jPP5LwtUTckaWLPrAPuKDRF";
        return null;
    }

    private String A03() {
        String strA12 = this.A03.A12();
        if (this.A03.A21()) {
            boolean zIsEmpty = TextUtils.isEmpty(strA12);
            String[] strArr = A0A;
            if (strArr[2].charAt(3) == strArr[7].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[6] = "bWh5ZJLUuxhwdzQeFGE5pJ27zwRBZYtK";
            strArr2[0] = "k8oYCR3AxWxSTXJGQikG90YPzIUE2fAr";
            if (!zIsEmpty) {
                return strA12;
            }
        }
        try {
            PackageManager packageManager = this.A05.getPackageManager();
            if (packageManager != null) {
                String string = this.A05.getApplicationInfo().loadLabel(packageManager).toString();
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
        } catch (Exception ex) {
            this.A05.A08().ABC(A04(14, 12, 43), 3803, new C0834Te(ex));
        }
        return strA12;
    }

    public static String A05(String str) {
        if (str.length() > 10) {
            return str.substring(0, 10) + A04(0, 3, 18);
        }
        return str;
    }

    private void A07(float f) {
        if (f > 0.0f) {
            this.A07.setVisibility(8);
        } else {
            this.A07.setVisibility(0);
        }
    }

    private void A08(float f) {
        String text;
        String strA04 = A04(3, 5, 14);
        if (f > 0.0f) {
            int iCeil = (int) Math.ceil(f / 1000.0f);
            boolean zIsEmpty = TextUtils.isEmpty(this.A08);
            String strA042 = A04(8, 6, 97);
            if (zIsEmpty) {
                text = this.A03.A2D().A07().replace(strA042, String.valueOf(iCeil));
            } else {
                text = this.A03.A2D().A03().replace(strA04, this.A08).replace(strA042, String.valueOf(iCeil));
            }
        } else if (TextUtils.isEmpty(this.A08)) {
            text = this.A03.A2D().A08();
        } else {
            text = this.A03.A2D().A04().replace(strA04, this.A08);
        }
        this.A02.setText(text);
    }

    public final int A09() {
        return this.A00;
    }

    public final void A0A(float f) {
        A07(f);
        A08(f);
    }

    public final void A0B(float f) {
        A08(f);
        A07(f);
    }

    public final void A0C(int i) {
        this.A05.A0F().AGB(i);
        this.A00 = i;
    }
}
