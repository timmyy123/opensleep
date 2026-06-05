package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.AbstractC0455Eh;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0455Eh<T extends AbstractC0455Eh<T>> {
    public final int A00;
    public final int A01;
    public final C1981qI A02;
    public final C1944pg A03;

    public abstract int A08();

    public abstract boolean A09(T t);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eh != com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TrackInfo<T extends com.facebook.ads.redexgen.X.Eh<T>> */
    public AbstractC0455Eh(int i, C1944pg c1944pg, int i2) {
        this.A00 = i;
        this.A03 = c1944pg;
        this.A01 = i2;
        this.A02 = c1944pg.A08(i2);
    }
}
