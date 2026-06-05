package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.AdSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ij, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1540ij implements U3 {
    @Override // com.facebook.ads.redexgen.core.U3
    public final String A79() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A7N() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final TM A7m(T8 t8) {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A8W() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A9G() {
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            return AdSettings.getTestAdType().getAdTypeString();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean AAa() {
        return AdSettings.isMixedAudience();
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean AAg() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final Boolean AAk() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean isTestMode(Context context) {
        return AdSettings.isTestMode(context);
    }
}
