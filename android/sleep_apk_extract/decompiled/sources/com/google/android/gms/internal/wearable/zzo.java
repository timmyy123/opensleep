package com.google.android.gms.internal.wearable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
final class zzo implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();

    public /* synthetic */ zzo(byte[] bArr) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zza.newThread(runnable);
        if (threadNewThread != null) {
            threadNewThread.setName("punch".concat(String.valueOf(threadNewThread.getName())));
            return threadNewThread;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Default ThreadFactory returned null thread");
        return null;
    }
}
