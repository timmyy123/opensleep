package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1055am extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"Jr0WeKM", "aLyr78qnX3", "WDzI2yCoQnaG5WlFPMLzJUV1", "NMdl8UzP9SICP", "nTr6FgA", "dLt28u1n76", "a9DRmwxXZv9mu", "zh83YRMbL55XtKeOm"};
    public static final int A06;

    @Nullable
    public Bitmap A00;
    public TextView A01;
    public TextView A02;
    public final C1421gi A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            String[] strArr = A05;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[3] = "ZRUGDW6hHHeRJ";
            strArr2[6] = "Carw9iBjdVQlg";
            bArrCopyOfRange[i4] = (byte) ((b ^ i3) ^ 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{30, 2, 2, 6, 5};
    }

    static {
        A02();
        A06 = XV.A05;
    }

    public C1055am(C1421gi c1421gi) {
        super(c1421gi);
        this.A03 = c1421gi;
        A01();
    }

    private void A01() {
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(-16250871);
        this.A02.setTextSize(2, 15.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        this.A02.setGravity(17);
        this.A02.setTypeface(Typeface.DEFAULT_BOLD);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams subtitleTextViewParams = new LinearLayout.LayoutParams(-2, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(-9211021);
        this.A01.setTextSize(2, 12.0f);
        this.A01.setCompoundDrawablePadding(XV.A0A);
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        this.A01.setGravity(17);
        addView(this.A01, subtitleTextViewParams);
        if (C0871Up.A2w(this.A03)) {
            this.A02.setVisibility(4);
            this.A01.setVisibility(4);
        }
    }

    private Bitmap getPadlockBitmap() {
        if (this.A00 == null) {
            this.A00 = YN.A01(YM.BROWSER_PADLOCK_V2);
            this.A00 = Bitmap.createScaledBitmap(this.A00, A06, A06, true);
        }
        return this.A00;
    }

    public void setSubtitle(@Nullable String str) {
        BitmapDrawable bitmapDrawable;
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            TextView textView = this.A01;
            if (A05[2].length() == 20) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "pcOg4Bl";
            strArr[4] = "wYgGrPO";
            textView.setVisibility(4);
            return;
        }
        Uri uriA00 = XB.A00(str);
        this.A01.setText(uriA00.getHost());
        TextView textView2 = this.A01;
        if (A00(0, 5, 125).equals(uriA00.getScheme())) {
            bitmapDrawable = new BitmapDrawable(getResources(), getPadlockBitmap());
        } else {
            bitmapDrawable = null;
        }
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A01.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A02.setText((CharSequence) null);
            this.A02.setVisibility(4);
        } else {
            this.A02.setText(str);
            this.A02.setVisibility(0);
        }
    }
}
