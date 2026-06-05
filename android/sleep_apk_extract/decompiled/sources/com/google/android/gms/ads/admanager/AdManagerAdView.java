package com.google.android.gms.ads.admanager;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context, 0);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdSize[] getAdSizes() {
        return this.zza.zzd();
    }

    public AppEventListener getAppEventListener() {
        return this.zza.zzf();
    }

    public VideoController getVideoController() {
        return this.zza.zzy();
    }

    public VideoOptions getVideoOptions() {
        return this.zza.zzB();
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The supported ad sizes must contain at least one valid ad size.");
        } else {
            this.zza.zzn(adSizeArr);
        }
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zza.zzp(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zza.zzq(z);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zza.zzA(videoOptions);
    }
}
