package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1923pL implements AnonymousClass45 {
    @Override // com.facebook.ads.redexgen.core.AnonymousClass45
    public final C1921pJ A5P(Looper looper, Handler.Callback callback) {
        return new C1921pJ(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass45
    public final long A6J() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass45
    public final long AKe() {
        return SystemClock.uptimeMillis();
    }
}
