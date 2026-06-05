package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class WT {
    public static void A00(WP wp) {
        new Handler(Looper.getMainLooper()).post(wp);
    }
}
