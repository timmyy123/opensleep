package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/AuthenticationResult;", "", "preSharedKey", "", "gatewayVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPreSharedKey", "()Ljava/lang/String;", "getGatewayVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AuthenticationResult {

    @SerializedName("9029")
    private final String gatewayVersion;

    @SerializedName("9091")
    private final String preSharedKey;

    public AuthenticationResult(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.preSharedKey = str;
        this.gatewayVersion = str2;
    }

    public static /* synthetic */ AuthenticationResult copy$default(AuthenticationResult authenticationResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationResult.preSharedKey;
        }
        if ((i & 2) != 0) {
            str2 = authenticationResult.gatewayVersion;
        }
        return authenticationResult.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPreSharedKey() {
        return this.preSharedKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    public final AuthenticationResult copy(String preSharedKey, String gatewayVersion) {
        preSharedKey.getClass();
        gatewayVersion.getClass();
        return new AuthenticationResult(preSharedKey, gatewayVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationResult)) {
            return false;
        }
        AuthenticationResult authenticationResult = (AuthenticationResult) other;
        return Intrinsics.areEqual(this.preSharedKey, authenticationResult.preSharedKey) && Intrinsics.areEqual(this.gatewayVersion, authenticationResult.gatewayVersion);
    }

    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    public final String getPreSharedKey() {
        return this.preSharedKey;
    }

    public int hashCode() {
        return this.gatewayVersion.hashCode() + (this.preSharedKey.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthenticationResult(preSharedKey=");
        sb.append(this.preSharedKey);
        sb.append(", gatewayVersion=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.gatewayVersion, ')');
    }
}
