package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkScheduler {
    void schedule(TransportContext transportContext, int i);

    void schedule(TransportContext transportContext, int i, boolean z);
}
