package com.urbandroid.common.logging.filter;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/common/logging/filter/TimedExponentialDecimate;", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "", "resetFreqMinutes", "maxFactor", "<init>", "(II)V", "", "timestamp", "", "allows", "(J)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getResetFreqMinutes", "getMaxFactor", "factor", "count", "lastReset", "J", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final /* data */ class TimedExponentialDecimate implements FrequencyGuard {
    private int count;
    private int factor = 1;
    private long lastReset;
    private final int maxFactor;
    private final int resetFreqMinutes;

    public TimedExponentialDecimate(int i, int i2) {
        this.resetFreqMinutes = i;
        this.maxFactor = i2;
    }

    @Override // com.urbandroid.common.logging.filter.FrequencyGuard
    public synchronized boolean allows(long timestamp) {
        boolean z;
        try {
            if (timestamp - this.lastReset > this.resetFreqMinutes * 60000) {
                this.factor = 1;
                this.count = 0;
                this.lastReset = timestamp;
            }
            int i = this.count + 1;
            this.count = i;
            int i2 = this.factor;
            z = i % i2 == 0;
            if (z && i2 < this.maxFactor) {
                this.factor = i2 * 2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimedExponentialDecimate)) {
            return false;
        }
        TimedExponentialDecimate timedExponentialDecimate = (TimedExponentialDecimate) other;
        return this.resetFreqMinutes == timedExponentialDecimate.resetFreqMinutes && this.maxFactor == timedExponentialDecimate.maxFactor;
    }

    public int hashCode() {
        return (this.resetFreqMinutes * 31) + this.maxFactor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TimedExponentialDecimate(resetFreqMinutes=");
        sb.append(this.resetFreqMinutes);
        sb.append(", maxFactor=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.maxFactor, ')');
    }
}
