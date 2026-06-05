package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbhw implements Callable {
    static final /* synthetic */ zzbhw zza = new zzbhw();

    private /* synthetic */ zzbhw() {
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
