package org.eclipse.californium.core.observe;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ObservationStore {
    Observation get(Token token);

    Observation put(Token token, Observation observation);

    Observation putIfAbsent(Token token, Observation observation);

    void remove(Token token);

    void setContext(Token token, EndpointContext endpointContext);

    void setExecutor(ScheduledExecutorService scheduledExecutorService);

    void start();

    void stop();
}
