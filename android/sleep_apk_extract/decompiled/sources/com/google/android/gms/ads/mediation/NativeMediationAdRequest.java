package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface NativeMediationAdRequest extends MediationAdRequest {
    @Deprecated
    NativeAdOptions getNativeAdOptions();

    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isUnifiedNativeAdRequested();

    boolean zza();

    Map zzb();
}
