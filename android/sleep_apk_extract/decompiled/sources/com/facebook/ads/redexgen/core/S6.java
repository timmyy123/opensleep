package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class S6 implements NativeAdsManagerApi {
    public static String[] A0B = {"gDYqLx0JK9708AoJnxJgyKqjnvDR", "XqufOA6aif4bGdY", "Su6jQEbJiG4f8aKvZwQ5GnKoGxisXaGJ", "amq5QC2giq7rrMPed26NLD1vQWHXorDG", "da4TAb4G8iALXV3W79mvavYrQ", "laLk", "uFxB7CH2AwGOjVY1RRN9", "Lrv7"};
    public static final String A0C = NativeAdsManager.class.getSimpleName();
    public NativeAd.NativeOptions A01;
    public NativeAdsManager.Listener A02;
    public C1550iu A03;
    public String A04;
    public final int A07;
    public final C1421gi A08;
    public final String A09;
    public final List<NativeAd> A0A;
    public int A00 = -1;
    public boolean A05 = false;
    public boolean A06 = false;

    public S6(Context context, String str, int i) {
        this.A08 = C0794Rp.A03(context);
        this.A09 = str;
        this.A07 = Math.max(i, 0);
        this.A0A = new ArrayList(i);
    }

    public final NativeAdsManager.Listener A00() {
        return this.A02;
    }

    public final C1550iu A01() {
        return this.A03;
    }

    public final void A02() {
        this.A0A.clear();
    }

    public final void A03(int i) {
        this.A00 = i;
    }

    public final void A04(NativeAd nativeAd) {
        this.A0A.add(nativeAd);
    }

    public final void A05(boolean z) {
        this.A05 = z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void disableAutoRefresh() {
        this.A06 = true;
        if (this.A03 != null) {
            this.A03.A06();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final int getUniqueNativeAdCount() {
        return this.A0A.size();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final boolean isLoaded() {
        return this.A05;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        EnumC0896Vq enumC0896Vq = EnumC0896Vq.A06;
        int i = this.A07;
        C1550iu c1550iu = this.A03;
        this.A03 = new C1550iu(this.A08, this.A09, enumC0896Vq, null, i);
        if (this.A06) {
            this.A03.A06();
        }
        this.A03.A09(this.A04);
        this.A03.A08(new C1444h5(this, this.A08, mediaCacheFlag, this.A01));
        this.A03.A07();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd() {
        return nextNativeAd(null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd(NativeAdListener nativeAdListener) {
        if (this.A0A.size() == 0) {
            if (A0B[0].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[6] = "mJMTRUXqz4crzwTyllZM";
            strArr[4] = "KHUxr2V0BkfXxoUOzUh0cEJhB";
            return null;
        }
        int i = this.A00;
        this.A00 = i + 1;
        List<NativeAd> list = this.A0A;
        int pos = this.A0A.size();
        NativeAd nativeAd = list.get(i % pos);
        if (nativeAdListener != null) {
            ((UK) nativeAd.getInternalNativeAd()).A1b(nativeAd, nativeAdListener);
        }
        int pos2 = this.A0A.size();
        if (i >= pos2) {
            return new NativeAd(this.A08, nativeAd, this.A01);
        }
        return nativeAd;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setExtraHints(String str) {
        this.A04 = str;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setListener(NativeAdsManager.Listener listener) {
        this.A02 = listener;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setNativeOption(NativeAd.NativeOptions nativeOptions) {
        this.A01 = nativeOptions;
    }
}
