package com.facebook.ads.redexgen.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.Button;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1333fI extends Button {
    public static byte[] A07;
    public static String[] A08 = {"xcAgjuPXjiWMB1ssCuSZa5J", "MDq9KSsWLWIXMrqq85Bb", "5uEVnqsabDRdJRQ85jW9NMB9i", "gm0LtQz6WhkHdj5wX4JbuGG7BvRjVm91", "l1YawQMaGwDZUwnW", "7ZUqugjvimlTMP6MGoSM1hJ8SS3JK7y", "GCEj76jN8N56F9CXfv91ddVngBp", "DhtSUABtfeQAzaNHynIAsSOoxymmsGBP"};
    public String A00;
    public String A01;
    public boolean A02;
    public final Paint A03;
    public final Path A04;
    public final Path A05;
    public final Path A06;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A08[1].length() == 30) {
                throw new RuntimeException();
            }
            A08[1] = "l8iwcelfQsHaFWcAi";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
            i4++;
        }
    }

    public static void A02() {
        A07 = new byte[]{19, 34, 54, 48, 38, 18, 46, 35, 59};
    }

    static {
        A02();
    }

    public C1333fI(C1421gi c1421gi) {
        this(c1421gi, false);
    }

    public C1333fI(C1421gi c1421gi, boolean z) {
        super(c1421gi);
        this.A02 = false;
        this.A01 = A00(5, 4, 110);
        this.A00 = A00(0, 5, 111);
        this.A04 = new Path();
        this.A05 = new Path();
        this.A06 = new Path();
        this.A03 = new C1332fH(this, z);
        A01();
        setClickable(true);
        YB.A0N(this, 0);
    }

    private void A01() {
        setContentDescription(this.A02 ? this.A01 : this.A00);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.isHardwareAccelerated();
        float fMax = Math.max(canvas.getWidth(), canvas.getHeight()) / 100.0f;
        if (this.A02) {
            this.A06.rewind();
            float scaleFactor = fMax * 26.5f;
            float designedSize = fMax * 15.5f;
            this.A06.moveTo(scaleFactor, designedSize);
            float scaleFactor2 = fMax * 26.5f;
            float designedSize2 = 84.5f * fMax;
            this.A06.lineTo(scaleFactor2, designedSize2);
            float scaleFactor3 = 90.0f * fMax;
            float designedSize3 = 50.0f * fMax;
            this.A06.lineTo(scaleFactor3, designedSize3);
            this.A06.lineTo(26.5f * fMax, 15.5f * fMax);
            this.A06.close();
            canvas.drawPath(this.A06, this.A03);
        } else {
            this.A04.rewind();
            float scaleFactor4 = fMax * 29.0f;
            float designedSize4 = fMax * 21.0f;
            this.A04.moveTo(scaleFactor4, designedSize4);
            float scaleFactor5 = fMax * 29.0f;
            float designedSize5 = fMax * 79.0f;
            this.A04.lineTo(scaleFactor5, designedSize5);
            float scaleFactor6 = fMax * 45.0f;
            float designedSize6 = fMax * 79.0f;
            this.A04.lineTo(scaleFactor6, designedSize6);
            float designedSize7 = fMax * 21.0f;
            this.A04.lineTo(45.0f * fMax, designedSize7);
            float designedSize8 = fMax * 21.0f;
            this.A04.lineTo(29.0f * fMax, designedSize8);
            this.A04.close();
            this.A05.rewind();
            float scaleFactor7 = fMax * 55.0f;
            float designedSize9 = fMax * 21.0f;
            this.A05.moveTo(scaleFactor7, designedSize9);
            float scaleFactor8 = fMax * 55.0f;
            float designedSize10 = fMax * 79.0f;
            this.A05.lineTo(scaleFactor8, designedSize10);
            float designedSize11 = fMax * 71.0f;
            this.A05.lineTo(designedSize11, 79.0f * fMax);
            float designedSize12 = fMax * 21.0f;
            this.A05.lineTo(71.0f * fMax, designedSize12);
            this.A05.lineTo(55.0f * fMax, 21.0f * fMax);
            this.A05.close();
            canvas.drawPath(this.A04, this.A03);
            canvas.drawPath(this.A05, this.A03);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.A02 = z;
        A01();
        refreshDrawableState();
        invalidate();
    }

    public void setPauseAccessibilityLabel(String str) {
        if (str != null) {
            this.A00 = str;
            A01();
        }
    }

    public void setPlayAccessibilityLabel(String str) {
        if (str != null) {
            this.A01 = str;
            A01();
        }
    }
}
