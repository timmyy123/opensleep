package org.eclipse.californium.elements.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.elements.util.SimpleCounterStatistic;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CounterStatisticManager {
    protected final String tag;
    protected final SimpleCounterStatistic.AlignGroup align = new SimpleCounterStatistic.AlignGroup();
    private final Map<String, SimpleCounterStatistic> statistics = new HashMap();
    private final int interval = 0;
    private final ScheduledExecutorService executor = null;

    public CounterStatisticManager(String str) {
        this.tag = StringUtil.normalizeLoggingTag(str);
    }

    public void add(SimpleCounterStatistic simpleCounterStatistic) {
        this.statistics.put(simpleCounterStatistic.getName(), simpleCounterStatistic);
    }
}
