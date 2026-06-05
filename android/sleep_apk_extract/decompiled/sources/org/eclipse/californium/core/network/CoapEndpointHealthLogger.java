package org.eclipse.californium.core.network;

import org.eclipse.californium.elements.util.SimpleCounterStatistic;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class CoapEndpointHealthLogger implements CoapEndpointHealth {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoapEndpoint.class.getCanonicalName() + ".health");
    private final SimpleCounterStatistic.AlignGroup align;
    private final SimpleCounterStatistic duplicateRequests;
    private final SimpleCounterStatistic duplicateResponses;
    private final SimpleCounterStatistic receivedRejects;
    private final SimpleCounterStatistic receivedRequests;
    private final SimpleCounterStatistic receivedResponses;
    private final SimpleCounterStatistic resentRequests;
    private final SimpleCounterStatistic resentResponses;
    private final SimpleCounterStatistic sendErrors;
    private final SimpleCounterStatistic sentRejects;
    private final SimpleCounterStatistic sentRequests;
    private final SimpleCounterStatistic sentResponses;

    public CoapEndpointHealthLogger() {
        SimpleCounterStatistic.AlignGroup alignGroup = new SimpleCounterStatistic.AlignGroup();
        this.align = alignGroup;
        this.sentRequests = new SimpleCounterStatistic("requests", alignGroup);
        this.sentResponses = new SimpleCounterStatistic("responses", alignGroup);
        this.sentRejects = new SimpleCounterStatistic("rejects", alignGroup);
        this.resentRequests = new SimpleCounterStatistic("request retransmissions", alignGroup);
        this.resentResponses = new SimpleCounterStatistic("response retransmissions", alignGroup);
        this.sendErrors = new SimpleCounterStatistic("errors", alignGroup);
        this.receivedRequests = new SimpleCounterStatistic("requests", alignGroup);
        this.receivedResponses = new SimpleCounterStatistic("responses", alignGroup);
        this.receivedRejects = new SimpleCounterStatistic("rejects", alignGroup);
        this.duplicateRequests = new SimpleCounterStatistic("duplicate requests", alignGroup);
        this.duplicateResponses = new SimpleCounterStatistic("duplicate responses", alignGroup);
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void dump(String str) {
        try {
            if (!this.receivedRequests.isUsed() && !this.receivedResponses.isUsed()) {
                return;
            }
            str = StringUtil.normalizeLoggingTag(str);
            String strLineSeparator = StringUtil.lineSeparator();
            String str2 = "   " + str;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("endpoint statistic:");
            sb.append(strLineSeparator);
            sb.append(str);
            sb.append("send statistic:");
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.sentRequests);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.sentResponses);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.sentRejects);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.resentRequests);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.resentResponses);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.sendErrors);
            sb.append(strLineSeparator);
            sb.append(str);
            sb.append("receive statistic:");
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.receivedRequests);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.receivedResponses);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.receivedRejects);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.duplicateRequests);
            sb.append(strLineSeparator);
            sb.append(str2);
            sb.append(this.duplicateResponses);
            LOGGER.debug("{}", sb);
        } catch (Throwable th) {
            LOGGER.error("{}", str, th);
        }
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public boolean isEnabled() {
        return LOGGER.isDebugEnabled();
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void receivedReject() {
        this.receivedRejects.increment();
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void receivedRequest(boolean z) {
        if (z) {
            this.duplicateRequests.increment();
        } else {
            this.receivedRequests.increment();
        }
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void receivedResponse(boolean z) {
        if (z) {
            this.duplicateResponses.increment();
        } else {
            this.receivedResponses.increment();
        }
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void sendError() {
        this.sendErrors.increment();
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void sentReject() {
        this.sentRejects.increment();
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void sentRequest(boolean z) {
        if (z) {
            this.resentRequests.increment();
        } else {
            this.sentRequests.increment();
        }
    }

    @Override // org.eclipse.californium.core.network.CoapEndpointHealth
    public void sentResponse(boolean z) {
        if (z) {
            this.resentResponses.increment();
        } else {
            this.sentResponses.increment();
        }
    }
}
