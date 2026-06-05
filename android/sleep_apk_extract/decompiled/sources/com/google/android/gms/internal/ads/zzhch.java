package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface zzhch extends ScheduledExecutorService, zzhcg, AutoCloseable {
    zzhcf zze(Callable callable, long j, TimeUnit timeUnit);
}
