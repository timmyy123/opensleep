package com.facebook.ads.redexgen.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.kotlin.compilerplugins.dataclassgenerate.annotation.DataClassGenerate;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Am, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/instagram/common/viewpoint/core/ViewpointQeConfig;", "", "enableMultipleUsersPerManager", "", "enableParentViewpointVisibilityPct", "<init>", "(ZZ)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "fbandroid.java.com.instagram.common.viewpoint.core.core_an"}, k = 1, mv = {2, 1, 0}, xi = 48)
@DataClassGenerate
public final /* data */ class ViewpointQeConfig extends AbstractC1518iL {
    public static String[] A02 = {"EEiZ5gwMJpudC46gmytKirA8", "NSKRdvtre4PRehKVMd3Q45JlYfRDrG", "CoRjB0oCb37S", "DbfERFTzLjajwVv8sNh5sUlUy2oFrKFb", "LqelwWv8kaDt3gFeGdVSs3BI163sHhDb", "u6CiNkzcWrumUo8SG6zNnx5HeV2X6NdJ", "1uy0riBBBCBFhXZsG4W77pBgNTmxUCRF", "5rdIAllOhqLEYXGfwPJ9dysQ"};
    public final boolean A00;
    public final boolean A01;

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewpointQeConfig() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewpointQeConfig)) {
            return false;
        }
        ViewpointQeConfig viewpointQeConfig = (ViewpointQeConfig) other;
        if (this.A00 != viewpointQeConfig.A00) {
            return false;
        }
        boolean z = this.A01;
        String[] strArr = A02;
        if (strArr[1].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A02[3] = "cwZ0ks8a4InKRgWpKf4KlC3uRBKypiM0";
        return z == viewpointQeConfig.A01;
    }

    public final int hashCode() {
        return (AbstractC1529iW.A00(this.A00) * 31) + AbstractC1529iW.A00(this.A01);
    }

    public final String toString() {
        return super.toString();
    }

    public ViewpointQeConfig(boolean z, boolean z2) {
        this.A00 = z;
        this.A01 = z2;
    }

    public /* synthetic */ ViewpointQeConfig(boolean z, boolean z2, int i, AbstractC1996qZ abstractC1996qZ) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
