package com.urbandroid.common.logging.filter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"", "resetFreqMinutes", "maxFactor", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "timedExponentialDecimate", "(II)Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "intervalMinutes", "maxCount", "maxCountPerInterval", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class FrequencyGuards {
    public static final FrequencyGuard maxCountPerInterval(int i, int i2) {
        return new MaxCountPerInterval(i, i2);
    }

    public static final FrequencyGuard timedExponentialDecimate(int i, int i2) {
        return new TimedExponentialDecimate(i, i2);
    }
}
