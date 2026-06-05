package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class CallableC0822Ss implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C0827Sx A01;

    public CallableC0822Ss(C0827Sx c0827Sx, C0823St c0823St) {
        this.A01 = c0827Sx;
        new Handler(Looper.getMainLooper()).post(new C1424gl(this, c0827Sx, c0823St));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C0823St c0823St) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1352fb c1352fbA06 = C1352fb.A06(this.A01.A04.A02());
        Uri uriA00 = XB.A00(c0823St.A08);
        long jA0S = c0823St.A00;
        if (jA0S == -1) {
            jA0S = C0871Up.A0S(this.A01.A04);
        }
        c1352fbA06.A0I(uriA00, new C1423gk(this, c0823St, jA0S, jCurrentTimeMillis), jA0S);
    }
}
