package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01581z {
    public final AudioAttributes A00;

    public C01581z(C1987qQ c1987qQ) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c1987qQ.A02).setFlags(c1987qQ.A03).setUsage(c1987qQ.A05);
        if (C5C.A02 >= 29) {
            C01561x.A00(usage, c1987qQ.A01);
        }
        if (C5C.A02 >= 32) {
            C01571y.A00(usage, c1987qQ.A04);
        }
        this.A00 = usage.build();
    }
}
