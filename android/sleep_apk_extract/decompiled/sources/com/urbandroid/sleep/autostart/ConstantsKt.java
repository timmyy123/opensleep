package com.urbandroid.sleep.autostart;

import com.urbandroid.common.Utils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0007\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"", "DEFAULT_MARGIN_IN_MS", "J", "getDEFAULT_MARGIN_IN_MS", "()J", "SUFFICIENT_TRACKING_DURATION", "getSUFFICIENT_TRACKING_DURATION", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ConstantsKt {
    private static final long DEFAULT_MARGIN_IN_MS = Utils.getHoursInMillis(2);
    private static final long SUFFICIENT_TRACKING_DURATION = Utils.getHoursInMinutes(4);

    public static final long getDEFAULT_MARGIN_IN_MS() {
        return DEFAULT_MARGIN_IN_MS;
    }

    public static final long getSUFFICIENT_TRACKING_DURATION() {
        return SUFFICIENT_TRACKING_DURATION;
    }
}
