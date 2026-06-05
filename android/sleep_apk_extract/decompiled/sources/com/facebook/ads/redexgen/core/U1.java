package com.facebook.ads.redexgen.core;

import com.facebook.ads.AudienceNetworkAds;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class U1 implements AudienceNetworkAds.InitResult {
    public final String A00;
    public final boolean A01;

    public U1(boolean z, String str) {
        this.A01 = z;
        this.A00 = str;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitResult
    public final String getMessage() {
        return this.A00;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitResult
    public final boolean isSuccess() {
        return this.A01;
    }
}
