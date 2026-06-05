package org.eclipse.californium.core.observe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.EndpointContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class InMemoryObservationStore implements ObservationStore {
    private static final Logger HEALTH_LOGGER;
    private static final Logger LOGGER;
    private final NetworkConfig config;
    private volatile boolean enableStatus;
    private ScheduledExecutorService executor;
    private final ConcurrentMap<Token, Observation> map = new ConcurrentHashMap();
    private ScheduledFuture<?> statusLogger;

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) InMemoryObservationStore.class);
        LOGGER = logger;
        HEALTH_LOGGER = LoggerFactory.getLogger(logger.getName() + ".health");
    }

    public InMemoryObservationStore(NetworkConfig networkConfig) {
        this.config = networkConfig;
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public Observation get(Token token) {
        if (token == null) {
            return null;
        }
        Observation observation = this.map.get(token);
        LOGGER.debug("looking up observation for token {}: {}", token, observation);
        return ObservationUtil.shallowClone(observation);
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public Observation put(Token token, Observation observation) {
        if (token == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("token must not be null");
            return null;
        }
        if (observation == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("observation must not be null");
            return null;
        }
        this.enableStatus = true;
        Observation observationPut = this.map.put(token, observation);
        if (observationPut == null) {
            LOGGER.debug("added observation for {}", token);
            return observationPut;
        }
        LOGGER.debug("replaced observation {} for {}", observationPut, token);
        return observationPut;
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public Observation putIfAbsent(Token token, Observation observation) {
        if (token == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("token must not be null");
            return null;
        }
        if (observation == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("observation must not be null");
            return null;
        }
        this.enableStatus = true;
        Observation observationPutIfAbsent = this.map.putIfAbsent(token, observation);
        if (observationPutIfAbsent == null) {
            LOGGER.debug("added observation for {}", token);
            return observationPutIfAbsent;
        }
        LOGGER.debug("kept observation {} for {}", observationPutIfAbsent, token);
        return observationPutIfAbsent;
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public void remove(Token token) {
        if (token != null) {
            if (this.map.remove(token) != null) {
                LOGGER.debug("removed observation for token {}", token);
            } else {
                LOGGER.debug("Already removed observation for token {}", token);
            }
        }
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public void setContext(Token token, EndpointContext endpointContext) {
        Observation observation;
        if (token == null || endpointContext == null || (observation = this.map.get(token)) == null) {
            return;
        }
        this.map.replace(token, observation, new Observation(observation.getRequest(), endpointContext));
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public void setExecutor(ScheduledExecutorService scheduledExecutorService) {
        this.executor = scheduledExecutorService;
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public synchronized void start() {
        ScheduledExecutorService scheduledExecutorService;
        int i = this.config.getInt("HEALTH_STATUS_INTERVAL", 0);
        if (i > 0 && HEALTH_LOGGER.isDebugEnabled() && (scheduledExecutorService = this.executor) != null) {
            long j = i;
            this.statusLogger = scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: org.eclipse.californium.core.observe.InMemoryObservationStore.1
                @Override // java.lang.Runnable
                public void run() {
                    if (InMemoryObservationStore.this.enableStatus) {
                        InMemoryObservationStore.HEALTH_LOGGER.debug("{} observes", Integer.valueOf(InMemoryObservationStore.this.map.size()));
                        Iterator it = InMemoryObservationStore.this.map.keySet().iterator();
                        int i2 = 5;
                        while (it.hasNext()) {
                            InMemoryObservationStore.HEALTH_LOGGER.debug("   observe {}", it.next());
                            i2--;
                            if (i2 == 0) {
                                return;
                            }
                        }
                    }
                }
            }, j, j, TimeUnit.SECONDS);
        }
    }

    @Override // org.eclipse.californium.core.observe.ObservationStore
    public synchronized void stop() {
        ScheduledFuture<?> scheduledFuture = this.statusLogger;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.statusLogger = null;
        }
    }
}
