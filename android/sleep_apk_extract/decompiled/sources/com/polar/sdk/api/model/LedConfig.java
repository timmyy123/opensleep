package com.polar.sdk.api.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/polar/sdk/api/model/LedConfig;", "", "", "sdkModeLedEnabled", "ppiModeLedEnabled", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSdkModeLedEnabled", "()Z", "getPpiModeLedEnabled", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class LedConfig {
    private final boolean ppiModeLedEnabled;
    private final boolean sdkModeLedEnabled;

    public LedConfig(boolean z, boolean z2) {
        this.sdkModeLedEnabled = z;
        this.ppiModeLedEnabled = z2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LedConfig)) {
            return false;
        }
        LedConfig ledConfig = (LedConfig) other;
        return this.sdkModeLedEnabled == ledConfig.sdkModeLedEnabled && this.ppiModeLedEnabled == ledConfig.ppiModeLedEnabled;
    }

    public final boolean getPpiModeLedEnabled() {
        return this.ppiModeLedEnabled;
    }

    public final boolean getSdkModeLedEnabled() {
        return this.sdkModeLedEnabled;
    }

    public int hashCode() {
        return Boolean.hashCode(this.ppiModeLedEnabled) + (Boolean.hashCode(this.sdkModeLedEnabled) * 31);
    }

    public String toString() {
        return "LedConfig(sdkModeLedEnabled=" + this.sdkModeLedEnabled + ", ppiModeLedEnabled=" + this.ppiModeLedEnabled + ")";
    }
}
