package org.eclipse.californium.core.observe;

import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.elements.util.ClockUtil;

/* JADX INFO: loaded from: classes5.dex */
public class NotificationOrder {
    protected final long nanoTimestamp;
    protected final Integer number;

    public NotificationOrder(Integer num) {
        this(num, ClockUtil.nanoRealtime());
    }

    public Integer getObserve() {
        return this.number;
    }

    public synchronized boolean isNew(Response response) {
        Integer observe = response.getOptions().getObserve();
        if (observe == null) {
            return true;
        }
        return isNew(this.nanoTimestamp, this.number.intValue(), ClockUtil.nanoRealtime(), observe.intValue());
    }

    public NotificationOrder(Integer num, long j) {
        this.number = num;
        this.nanoTimestamp = j;
    }

    public static boolean isNew(long j, int i, long j2, int i2) {
        if (i >= i2 || i2 - i >= 8388608) {
            return (i > i2 && ((long) (i - i2)) > 8388608) || j2 > j + 128000000000L;
        }
        return true;
    }
}
