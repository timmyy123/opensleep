package com.facebook.ads.redexgen.core;

import android.os.SystemClock;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class CF implements InterfaceC1477hc {
    public static final CF A00 = new CF();

    public static CF A00() {
        return A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1477hc
    public final long ACf() {
        return SystemClock.elapsedRealtime();
    }
}
