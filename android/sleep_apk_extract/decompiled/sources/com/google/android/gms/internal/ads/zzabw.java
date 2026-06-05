package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzabw implements zzdt {
    static final /* synthetic */ zzabw zza = new zzabw();

    private /* synthetic */ zzabw() {
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final /* synthetic */ void zza(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
