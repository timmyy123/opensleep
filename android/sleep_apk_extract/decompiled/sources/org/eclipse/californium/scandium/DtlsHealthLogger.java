package org.eclipse.californium.scandium;

import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.californium.elements.util.CounterStatisticManager;
import org.eclipse.californium.elements.util.SimpleCounterStatistic;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsHealthLogger extends CounterStatisticManager implements DtlsHealth {
    private static final Logger LOGGER = LoggerFactory.getLogger(DTLSConnector.class.getCanonicalName() + ".health");
    protected final SimpleCounterStatistic.AlignGroup align;
    private final SimpleCounterStatistic droppedReceivedRecords;
    private final SimpleCounterStatistic droppedSentRecords;
    private final SimpleCounterStatistic failedHandshakes;
    private final AtomicInteger pendingHandshakes;
    private final SimpleCounterStatistic receivedRecords;
    private final SimpleCounterStatistic sentRecords;
    private final SimpleCounterStatistic succeededHandshakes;

    public DtlsHealthLogger(String str) {
        super(str);
        this.pendingHandshakes = new AtomicInteger();
        SimpleCounterStatistic.AlignGroup alignGroup = new SimpleCounterStatistic.AlignGroup();
        this.align = alignGroup;
        this.succeededHandshakes = new SimpleCounterStatistic("handshakes succeeded", alignGroup);
        this.failedHandshakes = new SimpleCounterStatistic("handshakes failed", alignGroup);
        this.receivedRecords = new SimpleCounterStatistic("received records", alignGroup);
        this.droppedReceivedRecords = new SimpleCounterStatistic("dropped received records", alignGroup);
        this.sentRecords = new SimpleCounterStatistic("sending records", alignGroup);
        this.droppedSentRecords = new SimpleCounterStatistic("dropped sending records", alignGroup);
        init();
    }

    private void init() {
        add(this.succeededHandshakes);
        add(this.failedHandshakes);
        add(this.receivedRecords);
        add(this.droppedReceivedRecords);
        add(this.sentRecords);
        add(this.droppedSentRecords);
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public void dump(String str, int i, int i2, int i3) {
        try {
            if (isUsed()) {
                String strLineSeparator = StringUtil.lineSeparator();
                String str2 = "   " + str;
                this.align.add("associations");
                this.align.add("handshakes pending");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("statistic:");
                sb.append(strLineSeparator);
                String str3 = SimpleCounterStatistic.format(this.align.getAlign(), "associations", i - i2);
                sb.append(str2);
                sb.append(str3);
                sb.append(" (");
                sb.append(i2);
                sb.append(" remaining capacity).");
                sb.append(strLineSeparator);
                String str4 = SimpleCounterStatistic.format(this.align.getAlign(), "handshakes pending", this.pendingHandshakes.get());
                sb.append(str2);
                sb.append(str4);
                sb.append(" (");
                sb.append(i3);
                sb.append(" without verify).");
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.succeededHandshakes);
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.failedHandshakes);
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.sentRecords);
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.droppedSentRecords);
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.receivedRecords);
                sb.append(strLineSeparator);
                sb.append(str2);
                sb.append(this.droppedReceivedRecords);
                dump(str2, sb);
                LOGGER.debug("{}", sb);
            }
        } catch (Throwable th) {
            LOGGER.error("{}", str, th);
        }
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public void endHandshake(boolean z) {
        this.pendingHandshakes.decrementAndGet();
        if (z) {
            this.succeededHandshakes.increment();
        } else {
            this.failedHandshakes.increment();
        }
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public boolean isEnabled() {
        return LOGGER.isDebugEnabled();
    }

    public boolean isUsed() {
        return this.receivedRecords.isUsed() || this.sentRecords.isUsed();
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public void receivingRecord(boolean z) {
        if (z) {
            this.droppedReceivedRecords.increment();
        } else {
            this.receivedRecords.increment();
        }
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public void sendingRecord(boolean z) {
        if (z) {
            this.droppedSentRecords.increment();
        } else {
            this.sentRecords.increment();
        }
    }

    @Override // org.eclipse.californium.scandium.DtlsHealth
    public void startHandshake() {
        this.pendingHandshakes.incrementAndGet();
    }

    public void dump(String str, StringBuilder sb) {
    }
}
