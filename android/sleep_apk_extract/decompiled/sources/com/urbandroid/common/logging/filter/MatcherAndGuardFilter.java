package com.urbandroid.common.logging.filter;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010\u001cR\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#¨\u0006'"}, d2 = {"Lcom/urbandroid/common/logging/filter/MatcherAndGuardFilter;", "Lcom/urbandroid/common/logging/filter/Filter;", "Lcom/urbandroid/common/logging/filter/Matcher;", "matcher", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "guard", "", "tillLevel", "<init>", "(Lcom/urbandroid/common/logging/filter/Matcher;Lcom/urbandroid/common/logging/filter/FrequencyGuard;I)V", "", "timestamp", "logLevel", "", "tag", "message", "", "throwable", "", "accepts", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcom/urbandroid/common/logging/filter/Matcher;", "getMatcher", "()Lcom/urbandroid/common/logging/filter/Matcher;", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "getGuard", "()Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "I", "getTillLevel", "matchedMsgCount", "rejectedMsgCount", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final /* data */ class MatcherAndGuardFilter implements Filter {
    private final FrequencyGuard guard;
    private int matchedMsgCount;
    private final Matcher matcher;
    private int rejectedMsgCount;
    private final int tillLevel;

    public MatcherAndGuardFilter(Matcher matcher, FrequencyGuard frequencyGuard, int i) {
        matcher.getClass();
        frequencyGuard.getClass();
        this.matcher = matcher;
        this.guard = frequencyGuard;
        this.tillLevel = i;
    }

    @Override // com.urbandroid.common.logging.filter.Filter
    public synchronized boolean accepts(long timestamp, int logLevel, String tag, String message, Throwable throwable) {
        if (logLevel > this.tillLevel) {
            return true;
        }
        if (!this.matcher.matches(message)) {
            return true;
        }
        this.matchedMsgCount++;
        if (this.guard.allows(timestamp)) {
            return true;
        }
        this.rejectedMsgCount++;
        return false;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatcherAndGuardFilter)) {
            return false;
        }
        MatcherAndGuardFilter matcherAndGuardFilter = (MatcherAndGuardFilter) other;
        return Intrinsics.areEqual(this.matcher, matcherAndGuardFilter.matcher) && Intrinsics.areEqual(this.guard, matcherAndGuardFilter.guard) && this.tillLevel == matcherAndGuardFilter.tillLevel;
    }

    public int hashCode() {
        return ((this.guard.hashCode() + (this.matcher.hashCode() * 31)) * 31) + this.tillLevel;
    }

    public synchronized String toString() {
        return "Filter(matcher:" + this.matcher + ", guard:" + this.guard + ", tillLevel:" + this.tillLevel + ", matched:" + this.matchedMsgCount + ", rejected:" + this.rejectedMsgCount + ')';
    }
}
