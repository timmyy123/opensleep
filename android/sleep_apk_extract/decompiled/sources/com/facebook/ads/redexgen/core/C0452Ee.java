package com.facebook.ads.redexgen.core;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0452Ee implements Spatializer$OnSpatializerStateChangedListener {
    public final /* synthetic */ C0453Ef A00;
    public final /* synthetic */ C03389h A01;

    public C0452Ee(C0453Ef c0453Ef, C03389h c03389h) {
        this.A00 = c0453Ef;
        this.A01 = c03389h;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }
}
