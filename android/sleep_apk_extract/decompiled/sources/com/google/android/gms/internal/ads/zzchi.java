package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzchi implements Runnable {
    public zzchi(zzchk zzchkVar) {
        Objects.requireNonNull(zzchkVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
