package com.google.android.gms.internal.wearable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
final class zzn implements zzm {
    public /* synthetic */ zzn(byte[] bArr) {
    }

    @Override // com.google.android.gms.internal.wearable.zzm
    public final ExecutorService zza(int i) {
        return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzo(null)));
    }
}
