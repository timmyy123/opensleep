package com.facebook.ads.redexgen.core;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class U9 implements Callable<Boolean> {
    public final /* synthetic */ C0918Wn A00;
    public final /* synthetic */ String A01;

    public U9(C0918Wn c0918Wn, String str) {
        this.A00 = c0918Wn;
        this.A01 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        this.A00.A05();
        synchronized (UB.A04) {
            UB.A04.put(this.A01, 2);
        }
        return true;
    }
}
