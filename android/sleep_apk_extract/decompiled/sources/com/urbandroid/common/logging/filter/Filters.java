package com.urbandroid.common.logging.filter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"filter", "Lcom/urbandroid/common/logging/filter/Filter;", "messageMatcher", "Lcom/urbandroid/common/logging/filter/Matcher;", "frequencyGuard", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "maxFilteredLogLevel", "", "messagePrefix", "", "resetFreqMinutes", "maxPrune", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class Filters {
    public static final Filter filter(String str, int i, int i2, int i3) {
        str.getClass();
        return filter(Matchers.startsWith(str), FrequencyGuards.timedExponentialDecimate(i, i2), i3);
    }

    public static /* synthetic */ Filter filter$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 60;
        }
        if ((i4 & 4) != 0) {
            i2 = 1024;
        }
        if ((i4 & 8) != 0) {
            i3 = 4;
        }
        return filter(str, i, i2, i3);
    }

    public static final Filter filter(String str, int i) {
        str.getClass();
        return filter$default(str, i, 0, 0, 12, null);
    }

    public static final Filter filter(Matcher matcher, FrequencyGuard frequencyGuard, int i) {
        matcher.getClass();
        frequencyGuard.getClass();
        return new MatcherAndGuardFilter(matcher, frequencyGuard, i);
    }

    public static final Filter filter(Matcher matcher, FrequencyGuard frequencyGuard) {
        matcher.getClass();
        frequencyGuard.getClass();
        return filter$default(matcher, frequencyGuard, 0, 4, null);
    }

    public static /* synthetic */ Filter filter$default(Matcher matcher, FrequencyGuard frequencyGuard, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 4;
        }
        return filter(matcher, frequencyGuard, i);
    }
}
