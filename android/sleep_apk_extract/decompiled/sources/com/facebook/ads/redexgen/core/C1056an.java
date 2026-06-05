package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1056an extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"Mfdbn5Fl8k5qESsaG0tegRjcib9VHyOt", "n0hxWP15hSbsHLgypwcG0GAEv81vEzmV", "Vpnz2oFEzE2IYGPVAE8ZMW29wyhZcEwz", "XXuq8LnmLUMAtFguuOE2ao", "65dSWN68FJcVNMzXlJchEDZxxrt4hqBN", "4lVNSswaDDObG8m1C4PrWCxrHhrY", "bBsj4v6TxeKFgxIfhKXDpm0rApYDu", "O9LsOEgR32mEkKEZI9qaQe7VINaI1GfC"};
    public static final int A06;

    @Nullable
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final C1421gi A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A05;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "BgS7v0vuK4FmmS5TgN4Oq9qrsj8N";
            strArr2[6] = "egQQbAPCKiEugSC3TXQQi3lfGkkhl";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
            i4++;
        }
    }

    public static void A02() {
        A04 = new byte[]{6, 26, 26, 30, 29};
    }

    static {
        A02();
        A06 = XV.A0O;
    }

    public C1056an(C1421gi c1421gi) {
        super(c1421gi);
        this.A03 = c1421gi;
        A01();
    }

    private void A01() {
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(Color.BLACK);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        this.A02.setGravity(17);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams subtitleTextViewParams = new LinearLayout.LayoutParams(-2, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(Color.BLACK);
        this.A01.setTextSize(2, 15.0f);
        this.A01.setCompoundDrawablePadding(A06);
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        this.A01.setGravity(17);
        addView(this.A01, subtitleTextViewParams);
        if (C0871Up.A2w(this.A03)) {
            TextView textView = this.A02;
            String[] strArr = A05;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A05[1] = "YCLa9ko3h9BxKjOoBFpqdrzQ8S4ZW0px";
            textView.setVisibility(4);
            this.A01.setVisibility(4);
        }
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = YN.A03(this.A03, YM.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            this.A01.setVisibility(4);
        } else {
            Uri uriA00 = XB.A00(str);
            this.A01.setText(uriA00.getHost());
            this.A01.setCompoundDrawablesRelativeWithIntrinsicBounds(A00(0, 5, 54).equals(uriA00.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.A01.setVisibility(0);
        }
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
