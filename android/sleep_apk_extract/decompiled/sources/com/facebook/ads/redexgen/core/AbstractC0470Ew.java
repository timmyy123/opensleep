package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0470Ew {
    public InterfaceC0469Ev A00;
    public F6 A01;

    public abstract boolean A0Y();

    public abstract C0471Ex A0b(InterfaceC03007p[] interfaceC03007pArr, C1811nW c1811nW, C1829no c1829no, Timeline timeline) throws AD;

    public abstract void A0c(Object obj);

    public final F6 A00() {
        return (F6) AbstractC02053y.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AGD();
        }
    }

    public final void A02(InterfaceC0469Ev interfaceC0469Ev, F6 f6) {
        this.A00 = interfaceC0469Ev;
        this.A01 = f6;
    }
}
