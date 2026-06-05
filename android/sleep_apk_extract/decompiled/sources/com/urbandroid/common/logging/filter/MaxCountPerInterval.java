package com.urbandroid.common.logging.filter;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/common/logging/filter/MaxCountPerInterval;", "Lcom/urbandroid/common/logging/filter/FrequencyGuard;", "", "intervalMinutes", "maxCount", "<init>", "(II)V", "", "timestamp", "", "allows", "(J)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getIntervalMinutes", "getMaxCount", "count", "lastReset", "J", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final /* data */ class MaxCountPerInterval implements FrequencyGuard {
    private int count;
    private final int intervalMinutes;
    private long lastReset;
    private final int maxCount;

    public MaxCountPerInterval(int i, int i2) {
        this.intervalMinutes = i;
        this.maxCount = i2;
    }

    @Override // com.urbandroid.common.logging.filter.FrequencyGuard
    public synchronized boolean allows(long timestamp) {
        int i;
        try {
            if (timestamp - this.lastReset > this.intervalMinutes * 60000) {
                this.count = 0;
                this.lastReset = timestamp;
            }
            i = this.count;
            this.count = i + 1;
        } catch (Throwable th) {
            throw th;
        }
        return i < this.maxCount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaxCountPerInterval)) {
            return false;
        }
        MaxCountPerInterval maxCountPerInterval = (MaxCountPerInterval) other;
        return this.intervalMinutes == maxCountPerInterval.intervalMinutes && this.maxCount == maxCountPerInterval.maxCount;
    }

    public int hashCode() {
        return (this.intervalMinutes * 31) + this.maxCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MaxCountPerInterval(intervalMinutes=");
        sb.append(this.intervalMinutes);
        sb.append(", maxCount=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.maxCount, ')');
    }
}
