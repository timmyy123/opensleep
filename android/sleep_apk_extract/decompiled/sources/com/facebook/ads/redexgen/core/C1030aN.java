package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1030aN extends LinearLayout {
    public static byte[] A05;
    public static String[] A06 = {"4iYy1NiEXPr50pSHLe", "HBHFKoag", "wA4Ui03I", "2gIO3BT", "OrT35hYFj4GxiCS6J9xeeeUbe1P", "nGPsLdYcSrB888UHIbwtZyr3qehde", "KYwyCcQkvGwH5Y", "JT6Ig6jVa1kb71ozaZw7zaiPm8CFCh"};
    public Bitmap A00;
    public ImageView A01;
    public final Bitmap A02;
    public final AbstractC1586jd A03;
    public final C1421gi A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-34, -19, -32, -33, -28, -17, -38, -25, -28, -23, -32};
    }

    static {
        A03();
    }

    public C1030aN(C1421gi c1421gi, EnumC1029aM enumC1029aM, AbstractC1586jd abstractC1586jd) {
        super(c1421gi);
        this.A02 = YN.A01(YM.CREDIT_LINE_DETAIL_ICON);
        this.A04 = c1421gi;
        this.A03 = abstractC1586jd;
        AbstractC1028aL.A03(c1421gi, enumC1029aM);
        A02();
    }

    private void A01() {
        this.A01 = new ImageView(getContext());
        YB.A0K(this.A01);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setAdjustViewBounds(true);
        int i = XV.A02;
        int i2 = -2;
        if (this.A00 != null) {
            AbstractC1586jd abstractC1586jd = this.A03;
            String[] strArr = A06;
            String str = strArr[4];
            String str2 = strArr[7];
            int width = str.length();
            int height = str2.length();
            if (width == height) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[4] = "x8xY3MB01JBdxcqqDL0wMDWxAwS";
            strArr2[7] = "xOuUcUrUHCCBixtYHxFt84BQtGsdzP";
            if (abstractC1586jd != null && this.A03.A0t() != null) {
                int height2 = this.A03.A0t().A04();
                if (height2 > 0) {
                    int height3 = this.A03.A0t().A04();
                    i2 = (int) (height3 * XX.A02);
                    i = -2;
                }
            }
        }
        LinearLayout.LayoutParams creditLineLayoutParams = new LinearLayout.LayoutParams(i2, i);
        if (this.A00 != null) {
            this.A01.setImageBitmap(this.A00);
        } else {
            this.A01.setImageBitmap(this.A02);
        }
        addView(this.A01, creditLineLayoutParams);
        String[] strArr3 = A06;
        String str3 = strArr3[1];
        String str4 = strArr3[2];
        int width2 = str3.length();
        int height4 = str4.length();
        if (width2 != height4) {
            A06[3] = "pXE18ZtALSro7";
            return;
        }
        String[] strArr4 = A06;
        strArr4[6] = "iRqRQPIdY5QAhD";
        strArr4[5] = "IqpqjnSjtnqm1TdvzBeDXrY2K4YMi";
    }

    private void A02() {
        setOrientation(0);
        setPadding(XV.A0S, XV.A0I, XV.A0S, XV.A0I);
        setClipToPadding(false);
        setGravity(17);
        YB.A0N(this, 452984831);
        YB.A0E(XV.A0C, this);
        getDownloadedBitmap();
        A01();
    }

    public final void A04() {
        getDownloadedBitmap();
        if (this.A01 == null || this.A00 == null) {
            return;
        }
        AbstractC1586jd abstractC1586jd = this.A03;
        if (A06[3].length() == 27) {
            throw new RuntimeException();
        }
        A06[3] = "jEdvzIR";
        if (abstractC1586jd != null && this.A03.A0t() != null && this.A03.A0t().A04() > 0) {
            LinearLayout.LayoutParams creditLineLayoutParams = new LinearLayout.LayoutParams((int) (this.A03.A0t().A04() * XX.A02), -2);
            this.A01.setLayoutParams(creditLineLayoutParams);
            this.A01.setImageBitmap(null);
            this.A01.setImageBitmap(this.A00);
        }
    }

    private void getDownloadedBitmap() {
        if (this.A03 != null && this.A03.A0t() != null && this.A03.A0t().A05() != null && this.A03.A0t().A04() > 0 && this.A03.A0t().A03() > 0) {
            try {
                this.A00 = new C0827Sx(this.A04).A0O(this.A03.A0t().A05(), (int) (this.A03.A0t().A03() * XX.A02), (int) (this.A03.A0t().A04() * XX.A02));
            } catch (Exception e) {
                this.A04.A08().ABC(A00(0, 11, 27), 3900, new C0834Te(e));
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        YB.A0N(this, i);
    }
}
