package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class zar extends Handler {
    private final Looper zaa;

    public zar(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zar(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
