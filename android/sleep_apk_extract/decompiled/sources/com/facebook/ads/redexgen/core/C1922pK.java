package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1922pK implements C4W {
    public Message A00;
    public C1921pJ A01;

    public C1922pK() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C1921pJ.A01(this);
    }

    public final C1922pK A01(Message message, C1921pJ c1921pJ) {
        this.A00 = message;
        this.A01 = c1921pJ;
        return this;
    }

    public final void A02() {
        ((Message) AbstractC02053y.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) AbstractC02053y.A01(this.A00));
        A00();
        return success;
    }
}
