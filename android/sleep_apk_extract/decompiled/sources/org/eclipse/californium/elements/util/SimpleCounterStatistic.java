package org.eclipse.californium.elements.util;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleCounterStatistic {
    private final AlignGroup group;
    private final String name;
    private final AtomicLong currentCounter = new AtomicLong();
    private final AtomicLong overallCounter = new AtomicLong();
    private final int align = 0;

    public SimpleCounterStatistic(String str, AlignGroup alignGroup) {
        this.name = str;
        this.group = alignGroup.add(this);
    }

    public static String format(int i, String str, long j) {
        return i == 0 ? String.format("%s: %8d", str, Long.valueOf(j)) : String.format(Fragment$$ExternalSyntheticOutline1.m(i, "%", "s: %8d"), str, Long.valueOf(j));
    }

    public String dump(int i) {
        long andSet;
        long jAddAndGet;
        synchronized (this.overallCounter) {
            andSet = this.currentCounter.getAndSet(0L);
            jAddAndGet = this.overallCounter.addAndGet(andSet);
        }
        return format(i, this.name, andSet) + String.format(" (%8d overall).", Long.valueOf(jAddAndGet));
    }

    public String getName() {
        return this.name;
    }

    public long increment() {
        return this.currentCounter.incrementAndGet();
    }

    public boolean isUsed() {
        boolean z;
        synchronized (this.overallCounter) {
            try {
                z = this.currentCounter.get() > 0 || this.overallCounter.get() > 0;
            } finally {
            }
        }
        return z;
    }

    public String toString() {
        AlignGroup alignGroup = this.group;
        return dump(alignGroup == null ? this.align : alignGroup.getAlign());
    }

    public static class AlignGroup {
        int align;

        public AlignGroup add(String str) {
            int length = str.length();
            if (length > this.align) {
                this.align = length;
            }
            return this;
        }

        public int getAlign() {
            return -(this.align + 1);
        }

        public AlignGroup add(SimpleCounterStatistic simpleCounterStatistic) {
            return add(simpleCounterStatistic.getName());
        }
    }
}
