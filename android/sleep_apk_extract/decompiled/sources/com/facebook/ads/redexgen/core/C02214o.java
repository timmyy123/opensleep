package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02214o extends BroadcastReceiver {
    public final /* synthetic */ C02224p A00;

    public C02214o(C02224p c02224p) {
        this.A00 = c02224p;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int iA00 = C02224p.A00(context);
        if (C5C.A02 >= 31 && iA00 == 5) {
            C02194m.A02(context, this.A00);
        } else {
            this.A00.A07(iA00);
        }
    }
}
