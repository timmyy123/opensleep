package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class A1 {
    public final int A00;
    public final C1829no A01;
    public final CopyOnWriteArrayList<DrmSessionEventListener.EventDispatcher.ListenerAndHandler> A02;

    public A1() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    public A1(CopyOnWriteArrayList<DrmSessionEventListener.EventDispatcher.ListenerAndHandler> listenerAndHandlers, int i, C1829no c1829no) {
        this.A02 = listenerAndHandlers;
        this.A00 = i;
        this.A01 = c1829no;
    }

    public final A1 A00(int i, C1829no c1829no) {
        return new A1(this.A02, i, c1829no);
    }
}
