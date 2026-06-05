package com.urbandroid.sleep.domain;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/domain/Intervals;", "", "<init>", "()V", "", "newTo", "", "extendLast", "(J)V", "from", "to", "add", "(JJ)V", "", "isEmpty", "()Z", "Lcom/urbandroid/sleep/domain/Interval;", "last", "()Lcom/urbandroid/sleep/domain/Interval;", "intersectionLength", "(JJ)J", "interval", "(Lcom/urbandroid/sleep/domain/Interval;)J", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "intervals", "Ljava/util/List;", "getIntervals", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Intervals {
    private final List<Interval> intervals = new ArrayList();

    public final void add(long from, long to) {
        if (this.intervals.isEmpty() || ((Interval) CollectionsKt.last((List) this.intervals)).getTo() <= from) {
            this.intervals.add(new Interval(from, to));
            return;
        }
        throw new IllegalArgumentException(((Interval) CollectionsKt.last((List) this.intervals)).getTo() + " > " + from);
    }

    public final void extendLast(long newTo) {
        ((Interval) CollectionsKt.last((List) this.intervals)).extend(newTo);
    }

    public final long intersectionLength(Interval interval) {
        interval.getClass();
        List<Interval> list = this.intervals;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Interval intervalIntersection = ((Interval) it.next()).intersection(interval);
            arrayList.add(Long.valueOf(intervalIntersection != null ? intervalIntersection.length() : 0L));
        }
        return CollectionsKt___CollectionsKt.sumOfLong(arrayList);
    }

    public final boolean isEmpty() {
        return this.intervals.isEmpty();
    }

    public final Interval last() {
        return (Interval) CollectionsKt.last((List) this.intervals);
    }

    public String toString() {
        return this.intervals.toString();
    }

    public final long intersectionLength(long from, long to) {
        return intersectionLength(new Interval(from, to));
    }
}
