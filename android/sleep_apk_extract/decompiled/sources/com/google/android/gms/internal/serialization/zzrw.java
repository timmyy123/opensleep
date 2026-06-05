package com.google.android.gms.internal.serialization;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/google/nest/platform/mesh/api/time/DefaultTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "read", "", "java.com.google.nest.platform.mesh.api.time_time_source-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrw extends AbstractLongTimeSource {
    public static final zzrw zza = new zzrw();

    private zzrw() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public final long read() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
