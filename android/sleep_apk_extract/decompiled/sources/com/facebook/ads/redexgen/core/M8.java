package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class M8 extends LinearLayout implements InterfaceC1064av {
    public static byte[] A0C;
    public static String[] A0D = {"gmSbsJUTV6ssYU6sPFdQApLIq3Ne91IM", "MfGeHL5PmkPbpLjQYYWOTSdzt", "", "SJThwTW85f7z2tdQDzwWLTm6w", "rQXooJE", "LhKJvtc1UCCcm5M0SWMNGP7YHUEfZfxE", "", "2Oh5HyK"};
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final Uri A0H;
    public static final View.OnTouchListener A0I;
    public ImageView A00;
    public ImageView A01;
    public ImageView A02;
    public ImageView A03;
    public C1055am A04;
    public InterfaceC1063au A05;
    public String A06;
    public final WebView A07;
    public final C1421gi A08;
    public final InterfaceC1060ar A09;
    public final boolean A0A;
    public final boolean A0B;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        byte[] bArr = {-43, -12, -10, -2, -68, -27, -24, -20, -34, 0, 41, 44, 49, 27, 44, 30, 23, 56, 45, 54, -24, 54, 41, 60, 49, 62, 45, -24, 42, 58, 55, 63, 59, 45, 58, 41, 42, 55, 61, 60, 2, 42, 52, 41, 54, 51, 55, 68, 58, 72, 69, 63, 58, 4, 63, 68, 74, 59, 68, 74, 4, 55, 57, 74, 63, 69, 68, 4, 44, 31, 27, 45, -29, -17, -19, -82, -31, -18, -28, -14, -17, -23, -28, -82, -29, -24, -14, -17, -19, -27, 59, 71, 71, 67, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, 2, 74, 74, 74, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 54, 66, 64};
        String[] strArr = A0D;
        if (strArr[2].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "Ujyw6mT";
        strArr2[4] = "Vqhraj8";
        A0C = bArr;
    }

    static {
        A0A();
        A0F = Color.rgb(224, 224, 224);
        A0G = Color.argb(34, 0, 0, 0);
        A0E = XV.A0k;
        A0H = XB.A00(A06(90, 23, 118));
        A0I = new ViewOnTouchListenerC1040aX();
    }

    public M8(C1421gi c1421gi, WebView webView, boolean z) {
        super(c1421gi);
        this.A09 = new M9(this);
        this.A07 = webView;
        this.A08 = c1421gi;
        this.A0A = AbstractC0872Uq.A06(c1421gi);
        this.A0B = z;
        A08();
        A0C(false);
    }

    private void A08() {
        float f;
        YB.A0N(this, -1);
        setGravity(16);
        this.A01 = new ImageView(this.A08);
        this.A01.setContentDescription(A06(4, 5, 28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A0E, A0E);
        layoutParams.setMargins(0, 0, XV.A0b, 0);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(YN.A01(YM.BROWSER_CLOSE));
        this.A01.setOnTouchListener(A0I);
        this.A01.setOnClickListener(new ViewOnClickListenerC1041aY(this));
        addView(this.A01, layoutParams);
        if (this.A0A && !C0871Up.A2w(this.A08)) {
            this.A00 = new ImageView(this.A08);
            this.A00.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A06(0, 4, 54));
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A0E, A0E);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(YN.A01(YM.BACK_ARROW_V2));
            this.A00.setOnTouchListener(A0I);
            this.A00.setOnClickListener(new ViewOnClickListenerC1042aZ(this));
            addView(this.A00, layoutParams2);
        }
        this.A04 = new C1055am(this.A08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        if (this.A0A || C0871Up.A2w(this.A08)) {
            f = 0.5f;
        } else {
            f = 1.0f;
        }
        layoutParams3.weight = f;
        this.A04.setGravity(17);
        if (C0871Up.A2w(this.A08) && !this.A0B) {
            LinearLayout linearLayout = new LinearLayout(this.A08);
            linearLayout.setOrientation(1);
            addView(linearLayout, layoutParams3);
            YB.A0K(linearLayout);
            ImageView imageView = new ImageView(this.A08);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageBitmap(YN.A01(YM.HANDLER));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout.LayoutParams closeButtonParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(this.A04, closeButtonParams);
        } else {
            addView(this.A04, layoutParams3);
        }
        if (this.A0A && !C0871Up.A2w(this.A08)) {
            this.A02 = new ImageView(this.A08);
            this.A02.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A06(9, 7, 93));
            ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(A0E, A0E);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(YN.A02(YM.BACK_ARROW_V2));
            this.A02.setOnTouchListener(A0I);
            this.A02.setOnClickListener(new ViewOnClickListenerC1043aa(this));
            addView(this.A02, layoutParams4);
        }
        this.A03 = new ImageView(this.A08);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(A0E, A0E);
        layoutParams5.setMargins(XV.A0b, 0, 0, 0);
        this.A03.setContentDescription(A06(16, 19, 107));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(A0I);
        this.A03.setOnClickListener(new ViewOnClickListenerC1044ab(this));
        addView(this.A03, layoutParams5);
        A09();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A09() {
        PackageManager packageManager;
        Bitmap externalBrowserBitmap = null;
        boolean zA0k = C0871Up.A0k(this.A08);
        if (!zA0k && (packageManager = this.A08.getPackageManager()) != null) {
            List<ResolveInfo> infos = packageManager.queryIntentActivities(new Intent(A06(46, 26, 121), A0H), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (infos.isEmpty()) {
                this.A03.setVisibility(8);
            } else {
                int size = infos.size();
                String[] strArr = A0D;
                if (strArr[7].length() == strArr[4].length()) {
                    A0D[0] = "OiPmrAn3GllLAwonlzrco6n6FhbN6530";
                    if (size == 1) {
                    }
                } else if (size == 1) {
                    if (infos.get(0).activityInfo != null) {
                        externalBrowserBitmap = A06(72, 18, 35).equals(infos.get(0).activityInfo.packageName) ? YN.A01(YM.BROWSER_LAUNCH_CHROME) : getExternalBrowserBitmap();
                    }
                }
            }
        }
        if (C0871Up.A2w(this.A08) || zA0k) {
            ImageView imageView = this.A03;
            String[] strArr2 = A0D;
            if (strArr2[2].length() != strArr2[6].length()) {
                throw new RuntimeException();
            }
            A0D[0] = "H3zrzdIXpl7cuf9737Dh0UcXPx3q90pI";
            imageView.setVisibility(0);
            externalBrowserBitmap = getExternalBrowserBitmap();
        }
        this.A03.setImageBitmap(externalBrowserBitmap);
        String[] strArr3 = A0D;
        if (strArr3[2].length() != strArr3[6].length()) {
            throw new RuntimeException();
        }
        A0D[5] = "C5b1pkMeIVGGxpo7XcAe9IGkuMZh8kn1";
    }

    private void A0C(boolean z) {
        int i = z ? 0 : 8;
        if (this.A00 != null) {
            this.A00.setVisibility(i);
        }
        if (this.A02 != null) {
            this.A02.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(boolean z) {
        if (z) {
            A0C(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1064av
    public InterfaceC1060ar getBrowserNavigationListener() {
        return this.A09;
    }

    public static Bitmap getExternalBrowserBitmap() {
        YM ym = YM.BROWSER_LAUNCH_NATIVE_V2;
        if (A0D[0].charAt(23) == 'K') {
            throw new RuntimeException();
        }
        A0D[0] = "lUY1mRDCMXM3WZHcFiHRXNaY27JpPEEp";
        return YN.A01(ym);
    }

    public void setCloseButtonVisibility(int i) {
        this.A01.setVisibility(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1064av
    public void setListener(InterfaceC1063au interfaceC1063au) {
        this.A05 = interfaceC1063au;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1064av
    public void setTitle(String str) {
        this.A04.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1064av
    public void setUrl(String str) {
        this.A06 = str;
        if (!TextUtils.isEmpty(this.A06)) {
            String strA06 = A06(35, 11, 107);
            if (A0D[0].charAt(23) == 'K') {
                throw new RuntimeException();
            }
            A0D[0] = "qQ1cUQL6zuFcmcs6RwakvLgHhcCBx0UL";
            if (!strA06.equals(this.A06)) {
                this.A04.setSubtitle(this.A06);
                this.A03.setEnabled(true);
                this.A03.setColorFilter((ColorFilter) null);
                return;
            }
        }
        this.A04.setSubtitle(null);
        this.A03.setEnabled(false);
        this.A03.setColorFilter(new PorterDuffColorFilter(A0F, PorterDuff.Mode.SRC_IN));
    }
}
