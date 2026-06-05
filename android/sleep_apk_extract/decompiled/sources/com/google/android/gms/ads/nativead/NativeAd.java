package com.google.android.gms.ads.nativead;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAd {

    public static abstract class AdChoicesInfo {
    }

    public static abstract class Image {
        protected Map zza;

        public abstract Drawable getDrawable();
    }

    public interface OnNativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    public abstract String getBody();

    public abstract String getCallToAction();

    public abstract String getHeadline();

    public abstract Image getIcon();

    public abstract MediaContent getMediaContent();

    public abstract long getPlacementId();

    public abstract String getPrice();

    public abstract ResponseInfo getResponseInfo();

    public abstract Double getStarRating();

    public abstract String getStore();

    public abstract void recordEvent(Bundle bundle);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract Object zza();
}
