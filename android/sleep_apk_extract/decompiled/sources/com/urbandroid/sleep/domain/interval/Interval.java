package com.urbandroid.sleep.domain.interval;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Interval {
    private long from;
    private long to;

    public Interval(long j, long j2) {
        if (j > j2) {
            this.from = j2;
            this.to = j;
        } else {
            this.from = j;
            this.to = j2;
        }
    }

    public static long getSum(List<Interval> list) {
        long length = 0;
        if (list == null) {
            return 0L;
        }
        for (Interval interval : list) {
            length += interval.getLength();
            Logger.logInfo("SUM: " + length + " i=" + interval + " l=" + (interval.getLength() / 60000) + "min");
        }
        return length;
    }

    public boolean contains(Interval interval) {
        return this.from <= interval.from && this.to >= interval.to;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) obj;
        return this.from == interval.from && this.to == interval.to;
    }

    public long getFrom() {
        return this.from;
    }

    public Interval getIntersection(Interval interval) {
        long j = this.from;
        long j2 = interval.from;
        if (j >= j2 && this.to <= interval.to) {
            return this;
        }
        if (j2 >= j && interval.to <= this.to) {
            return interval;
        }
        if (j >= j2) {
            long j3 = interval.to;
            if (j <= j3) {
                return new Interval(j, j3);
            }
        }
        if (j2 < j) {
            return null;
        }
        long j4 = this.to;
        if (j2 <= j4) {
            return new Interval(j2, j4);
        }
        return null;
    }

    public long getIntersectionLength(Interval interval) {
        Interval intersection = getIntersection(interval);
        if (intersection != null) {
            return intersection.getLength();
        }
        return 0L;
    }

    public long getLength() {
        return this.to - this.from;
    }

    public long getTo() {
        return this.to;
    }

    public Interval getUnion(Interval interval) {
        if (getIntersection(interval) == null) {
            return null;
        }
        return new Interval(Math.min(interval.getFrom(), getFrom()), Math.max(interval.getTo(), this.to));
    }

    public boolean hasIntersection(Interval interval) {
        return getIntersection(interval) != null;
    }

    public int hashCode() {
        long j = this.from;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.to;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public boolean isIn(long j) {
        return j >= this.from && j <= this.to;
    }

    public Collection<Interval> subtract(Interval interval) {
        Interval intersection = getIntersection(interval);
        if (intersection == null) {
            return Collections.singleton(this);
        }
        LinkedList linkedList = new LinkedList();
        if (intersection.getTo() != getTo()) {
            linkedList.add(new Interval(intersection.getTo(), getTo()));
        }
        if (intersection.getFrom() != getFrom()) {
            linkedList.add(new Interval(getFrom(), intersection.getFrom()));
        }
        return linkedList;
    }

    public String toString() {
        return "[" + DateUtil.formatTimeShortSec(this.from) + "-" + DateUtil.formatTimeShortSec(this.to) + "](" + DateUtil.formatDay(this.to) + ")";
    }

    public Interval(Date date, Date date2) {
        this(date.getTime(), date2.getTime());
    }
}
