package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.RelativeLayout;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0782Rd implements AdViewApi {
    public static byte[] A0D;
    public static String[] A0E = {"8ZsaPqFHBksSubEDxj161z8v83o0PIqL", "1NWTdVv6N7aOqefGpQ3nVAkwh7f4QYaR", "Q4l1tys1ZSMgMj214694goNihNba6PJ2", "j8ts1um9VlgNYzePKTTbdrZm7P7LEYQS", "t56Pwr0qdwmiw03ThNEKvYWwkytCRLDg", "RREINDdqXCKFIVRasebbhTe", "edGRVZA6FwzGspMgtzkdHpprfoIdLjRD", "fNcadsm2hMDvYVzuw1qW3xw"};
    public long A00;
    public View A01;
    public AdListener A02;
    public C02957k A03;
    public C1075b6 A04;
    public String A05;
    public String A06;
    public final DisplayMetrics A07;
    public final AdView A08;
    public final AdViewParentApi A09;
    public final AnonymousClass76 A0A;
    public final EnumC0895Vp A0B;
    public final String A0C;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0D = new byte[]{-111, -66, -113, -112, -107, -110, -114, -109, -105, -57, -110, -56, -108, -101, -60, -58, 100, 96, 100, 93, 99, 101, 94, 99, -83, -52, -39, -39, -48, -35, -117, -52, -49, -117, -49, -48, -34, -33, -35, -38, -28, -48, -49, -35, -4, 9, 9, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -69, -4, -1, -69, 7, 10, -4, -1, -69, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 16, 0, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 0, -1, -35, -5, 8, 8, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -70, 0, 3, 8, -2, -70, -5, -70, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -1, 7, 10, 6, -5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -1, -70, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 2, -5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -70, 6, 9, -5, -2, -70, -4, 3, -2, -70, -63, -65, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -63, -83, -80, -97, -75, -58, -79, -72, -71, -57, -56, -58, -61, -51, -62, -59, -73, -70, -105, -70};
    }

    static {
        A02();
    }

    public C0782Rd(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        this.A00 = -1L;
        if (adSize != null && adSize != AdSize.INTERSTITIAL) {
            this.A07 = adView.getContext().getResources().getDisplayMetrics();
            this.A0B = XG.A04(adSize);
            this.A0C = str;
            this.A09 = adViewParentApi;
            this.A08 = adView;
            this.A0A = C0794Rp.A08(context);
            this.A0A.A0F().A3T(AdPlacementType.BANNER.toString(), str);
            O7 o7 = new O7(str, XG.A05(this.A0B), AdPlacementType.BANNER, XG.A04(adSize), 1, new C1540ij());
            o7.A06(this.A05);
            o7.A07(this.A06);
            this.A03 = new C02957k(this.A0A, o7);
            this.A03.A0S(new C1461hM(this));
            return;
        }
        throw new IllegalArgumentException(A01(108, 6, 37));
    }

    public C0782Rd(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws C0894Vn {
        this(context, str, A00(str2), adViewParentApi, adView);
        this.A0A.A0F().A4T();
    }

    public static AdSize A00(String str) throws C0894Vn {
        EnumC0896Vq template = C0900Vu.A00(str);
        if (template != null) {
            C0900Vu.A03(template);
            return XG.A01(template);
        }
        throw new C0894Vn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A01(67, 41, 115), str));
    }

    private void A03(String str) {
        this.A00 = System.currentTimeMillis();
        if (str == null) {
            this.A0A.A0F().A3Q();
        } else {
            AnonymousClass76 anonymousClass76 = this.A0A;
            if (A0E[1].charAt(22) == 'v') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[5] = "M5Y3D3mNGdfLR2WDul4k9MR";
            strArr[7] = "fol70tWokzFUGtpcuxJkkr6";
            anonymousClass76.A0F().A3P();
        }
        C02957k c02957k = this.A03;
        String[] strArr2 = A0E;
        if (strArr2[2].charAt(21) == strArr2[3].charAt(21)) {
            throw new RuntimeException();
        }
        A0E[1] = "pe4oZgDQ3sTDNo8k5JxuPcj1mqE4f2TD";
        if (c02957k != null) {
            this.A03.A0W(str);
        }
        this.A0A.A0F().A3O();
        if (A0E[1].charAt(22) != 'v') {
            A0E[1] = "D8Oc2vjooMbkdhwRsJFg2j6kNTTlIbDv";
        }
    }

    public final long A04() {
        return this.A00;
    }

    public final DisplayMetrics A05() {
        return this.A07;
    }

    public final AdListener A06() {
        return this.A02;
    }

    public final AdView A07() {
        return this.A08;
    }

    public final C02957k A08() {
        return this.A03;
    }

    public final AnonymousClass76 A09() {
        return this.A0A;
    }

    public final EnumC0895Vp A0A() {
        return this.A0B;
    }

    public final void A0B(RelativeLayout relativeLayout, View view) {
        C1269eF c1269eFA01;
        this.A0A.A0F().A4g(this.A06 != null);
        if (this.A06 != null && (c1269eFA01 = AbstractC1268eE.A01(this.A0A, this.A06)) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            relativeLayout.addView(c1269eFA01, new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        }
    }

    public final void A0C(AdListener adListener) {
        this.A0A.A0F().A3M(adListener != null);
        this.A02 = adListener;
    }

    public final void A0D(C1075b6 c1075b6) {
        this.A04 = c1075b6;
    }

    @Override // com.facebook.ads.internal.api.AdViewApi
    public final AdView.AdViewLoadConfigBuilder buildLoadAdConfig() {
        return new VO(this);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        AbstractC0904Vy.A05(A01(114, 7, 45), A01(24, 19, 68), A01(16, 8, 6));
        this.A0A.A0F().A3U();
        if (this.A03 != null) {
            this.A03.A0Y(true);
            this.A03.A0K();
            this.A03 = null;
        }
        if (this.A04 != null) {
            AdView adView = this.A08;
            String[] strArr = A0E;
            if (strArr[2].charAt(21) == strArr[3].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[0] = "SHsAoZcgZfma8JU5HMv6EkUhgjUJ0aGa";
            strArr2[4] = "YiN0xr4bPRWWNOnd45hBajl5vHs2Fp2h";
            if (C0871Up.A1C(adView.getContext())) {
                this.A04.A07();
                if (this.A01 != null) {
                    ViewOverlay overlay = this.A01.getOverlay();
                    String[] strArr3 = A0E;
                    if (strArr3[0].charAt(29) != strArr3[4].charAt(29)) {
                        String[] strArr4 = A0E;
                        strArr4[2] = "J1HUKKESb8xh9TFSe40ffgC38LRgNVZ2";
                        strArr4[3] = "o5XwXeFkKzkcKZo9S4DQ1FFyX8pzWZSK";
                        overlay.remove(this.A04);
                    } else {
                        String[] strArr5 = A0E;
                        strArr5[0] = "s1kiAbubcu5fNfkZcH7haOM3HmV2C0HH";
                        strArr5[4] = "uWy9U3opZwSsfb0VGZsAFVhup97A7xCm";
                        overlay.remove(this.A04);
                    }
                }
            }
        }
        this.A08.removeAllViews();
        this.A01 = null;
        this.A02 = null;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0C;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean z = this.A03 == null || this.A03.A0Z();
        this.A0A.A0F().A5f(z);
        return z;
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC0904Vy.A05(A01(121, 6, 47), A01(43, 24, 116), A01(8, 8, 59));
        A03(null);
    }

    @Override // com.facebook.ads.internal.api.AdViewApi
    public final void loadAd(AdView.AdViewLoadConfig adViewLoadConfig) {
        AbstractC0904Vy.A05(A01(121, 6, 47), A01(43, 24, 116), A01(0, 8, 54));
        A03(((VO) adViewLoadConfig).A00());
    }

    @Override // com.facebook.ads.internal.api.AdViewApi, com.facebook.ads.internal.api.AdViewParentApi
    public final void onConfigurationChanged(Configuration configuration) {
        this.A09.onConfigurationChanged(configuration);
        if (this.A01 != null) {
            AbstractC0898Vs.A01(this.A07, this.A01, this.A0B);
        }
    }

    @Override // com.facebook.ads.internal.api.AdViewApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A05 = extraHints.getHints();
        this.A06 = extraHints.getMediationData();
        if (C0871Up.A0l(this.A0A) && this.A03 != null) {
            this.A03.A08.A06(this.A05);
            this.A03.A08.A07(this.A06);
        }
    }
}
