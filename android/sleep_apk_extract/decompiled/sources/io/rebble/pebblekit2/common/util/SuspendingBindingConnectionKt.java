package io.rebble.pebblekit2.common.util;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"BINDING_TIMEOUT", "Lkotlin/time/Duration;", "J", "common_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SuspendingBindingConnectionKt {
    private static final long BINDING_TIMEOUT;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        BINDING_TIMEOUT = DurationKt.toDuration(10, DurationUnit.SECONDS);
    }
}
