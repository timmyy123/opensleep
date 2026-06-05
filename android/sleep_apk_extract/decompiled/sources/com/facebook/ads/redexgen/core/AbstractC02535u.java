package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC02535u {
    public int A00;

    public final void A00(int i) {
        this.A00 |= i;
    }

    public final void A01(int i) {
        this.A00 &= ~i;
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final boolean A03() {
        return A09(ClientDefaults.MAX_MSG_SIZE);
    }

    public final boolean A04() {
        return A09(Integer.MIN_VALUE);
    }

    public final boolean A05() {
        return A09(4);
    }

    public final boolean A06() {
        return A09(134217728);
    }

    public final boolean A07() {
        return A09(1);
    }

    @MetaExoPlayerCustomization("Add method to determine if we are at the last sample")
    public final boolean A08() {
        return A09(536870912);
    }

    public final boolean A09(int i) {
        return (this.A00 & i) == i;
    }

    public void A0A() {
        this.A00 = 0;
    }
}
