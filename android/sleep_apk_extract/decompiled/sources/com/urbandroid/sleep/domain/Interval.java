package com.urbandroid.sleep.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/domain/Interval;", "", "", "from", "to", "<init>", "(JJ)V", "newTo", "", "extend", "(J)V", "other", "intersection", "(Lcom/urbandroid/sleep/domain/Interval;)Lcom/urbandroid/sleep/domain/Interval;", "length", "()J", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFrom", "getTo", "setTo", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Interval {
    private final long from;
    private long to;

    public Interval(long j, long j2) {
        this.from = j;
        this.to = j2;
        if (j <= j2) {
            return;
        }
        throw new IllegalArgumentException(j + " > " + j2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) other;
        return this.from == interval.from && this.to == interval.to;
    }

    public final void extend(long newTo) {
        long j = this.to;
        if (newTo >= j) {
            this.to = newTo;
            return;
        }
        throw new IllegalArgumentException(newTo + " < " + j);
    }

    public final long getFrom() {
        return this.from;
    }

    public final long getTo() {
        return this.to;
    }

    public int hashCode() {
        return Long.hashCode(this.to) + (Long.hashCode(this.from) * 31);
    }

    public final Interval intersection(Interval other) {
        other.getClass();
        long j = other.to;
        long j2 = this.from;
        if (j < j2) {
            return null;
        }
        long j3 = this.to;
        long j4 = other.from;
        if (j3 < j4) {
            return null;
        }
        return new Interval(Math.max(j2, j4), Math.min(this.to, other.to));
    }

    public final long length() {
        return (this.to - this.from) + 1;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.to, ">", FileInsert$$ExternalSyntheticOutline0.m("<", ",", this.from));
    }
}
