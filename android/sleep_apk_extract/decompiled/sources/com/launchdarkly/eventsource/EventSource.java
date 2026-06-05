package com.launchdarkly.eventsource;

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.ErrorStrategy;
import com.launchdarkly.eventsource.RetryDelayStrategy;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class EventSource implements Closeable {
    final ErrorStrategy baseErrorStrategy;
    volatile long baseRetryDelayMillis;
    final RetryDelayStrategy baseRetryDelayStrategy;
    private volatile boolean calledStop;
    private final ConnectStrategy.Client client;
    private long connectedTime;
    ErrorStrategy currentErrorStrategy;
    RetryDelayStrategy currentRetryDelayStrategy;
    private volatile boolean deliberatelyClosedConnection;
    private long disconnectedTime;
    private EventParser eventParser;
    final Set<String> expectFields;
    private volatile String lastEventId;
    private final LDLogger logger;
    private volatile long nextReconnectDelayMillis;
    private volatile URI origin;
    final int readBufferSize;
    private final AtomicReference<ReadyState> readyState;
    final long retryDelayResetThresholdMillis;
    final boolean streamEventData;
    private final Object sleepNotifier = new Object();
    private final AtomicReference<Closeable> connectionCloser = new AtomicReference<>();
    private final AtomicReference<Thread> readingThread = new AtomicReference<>();

    public static final class Builder {
        private final ConnectStrategy connectStrategy;
        private ErrorStrategy errorStrategy;
        private String lastEventId;
        private RetryDelayStrategy retryDelayStrategy;
        private boolean streamEventData;
        private long retryDelayMillis = 1000;
        private long retryDelayResetThresholdMillis = 60000;
        private int readBufferSize = 1000;
        private LDLogger logger = null;
        private Set<String> expectFields = null;

        public Builder(ConnectStrategy connectStrategy) {
            if (connectStrategy != null) {
                this.connectStrategy = connectStrategy;
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2("connectStrategy must not be null");
                throw null;
            }
        }

        public EventSource build() {
            return new EventSource(this);
        }

        public Builder retryDelay(long j, TimeUnit timeUnit) {
            this.retryDelayMillis = Helpers.millisFromTimeUnit(j, timeUnit);
            return this;
        }
    }

    public EventSource(Builder builder) {
        LDLogger lDLoggerNone = builder.logger == null ? LDLogger.none() : builder.logger;
        this.logger = lDLoggerNone;
        ConnectStrategy.Client clientCreateClient = builder.connectStrategy.createClient(lDLoggerNone);
        this.client = clientCreateClient;
        this.origin = clientCreateClient.getOrigin();
        this.lastEventId = builder.lastEventId;
        ErrorStrategy errorStrategyAlwaysThrow = builder.errorStrategy == null ? ErrorStrategy.alwaysThrow() : builder.errorStrategy;
        this.currentErrorStrategy = errorStrategyAlwaysThrow;
        this.baseErrorStrategy = errorStrategyAlwaysThrow;
        RetryDelayStrategy retryDelayStrategyDefaultStrategy = builder.retryDelayStrategy == null ? RetryDelayStrategy.defaultStrategy() : builder.retryDelayStrategy;
        this.currentRetryDelayStrategy = retryDelayStrategyDefaultStrategy;
        this.baseRetryDelayStrategy = retryDelayStrategyDefaultStrategy;
        this.baseRetryDelayMillis = builder.retryDelayMillis;
        this.retryDelayResetThresholdMillis = builder.retryDelayResetThresholdMillis;
        this.streamEventData = builder.streamEventData;
        this.expectFields = builder.expectFields;
        this.readBufferSize = builder.readBufferSize;
        this.readyState = new AtomicReference<>(ReadyState.RAW);
    }

    private ErrorStrategy.Action applyErrorStrategy(StreamException streamException) {
        ErrorStrategy.Result resultApply = this.currentErrorStrategy.apply(streamException);
        if (resultApply.getNext() != null) {
            this.currentErrorStrategy = resultApply.getNext();
        }
        return resultApply.getAction();
    }

    private boolean closeCurrentStream(boolean z, boolean z2) {
        Closeable andSet = this.connectionCloser.getAndSet(null);
        Thread andSet2 = this.readingThread.getAndSet(null);
        if (andSet == null && andSet2 == null) {
            return false;
        }
        synchronized (this.sleepNotifier) {
            if (z) {
                try {
                    this.deliberatelyClosedConnection = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                this.calledStop = true;
            }
            if (andSet != null) {
                try {
                    andSet.close();
                    this.logger.debug("Closed request");
                } catch (IOException e) {
                    this.logger.warn("Unexpected error when closing connection: {}", LogValues.exceptionSummary(e));
                }
            }
            if (andSet2 == Thread.currentThread()) {
                this.eventParser = null;
                AtomicReference<ReadyState> atomicReference = this.readyState;
                ReadyState readyState = ReadyState.OPEN;
                ReadyState readyState2 = ReadyState.CLOSED;
                while (!atomicReference.compareAndSet(readyState, readyState2) && atomicReference.get() == readyState) {
                }
                AtomicReference<ReadyState> atomicReference2 = this.readyState;
                ReadyState readyState3 = ReadyState.CONNECTING;
                ReadyState readyState4 = ReadyState.CLOSED;
                while (!atomicReference2.compareAndSet(readyState3, readyState4) && atomicReference2.get() == readyState3) {
                }
            }
            this.sleepNotifier.notify();
        }
        return true;
    }

    private void computeReconnectDelay() {
        if (this.retryDelayResetThresholdMillis > 0 && this.connectedTime != 0 && System.currentTimeMillis() - this.connectedTime >= this.retryDelayResetThresholdMillis) {
            resetRetryDelayStrategy();
        }
        RetryDelayStrategy.Result resultApply = this.currentRetryDelayStrategy.apply(this.baseRetryDelayMillis);
        this.nextReconnectDelayMillis = resultApply.getDelayMillis();
        if (resultApply.getNext() != null) {
            this.currentRetryDelayStrategy = resultApply.getNext();
        }
    }

    private StreamEvent requireEvent() throws StreamException {
        this.readingThread.set(Thread.currentThread());
        while (true) {
            try {
                EventParser eventParser = this.eventParser;
                if (eventParser == null) {
                    FaultEvent faultEventTryStart = tryStart(true);
                    return faultEventTryStart == null ? new StartedEvent() : faultEventTryStart;
                }
                StreamEvent streamEventNextEvent = eventParser.nextEvent();
                if (!(streamEventNextEvent instanceof SetRetryDelayEvent)) {
                    if (streamEventNextEvent instanceof MessageEvent) {
                        MessageEvent messageEvent = (MessageEvent) streamEventNextEvent;
                        if (messageEvent.getLastEventId() != null) {
                            this.lastEventId = messageEvent.getLastEventId();
                        }
                    }
                    return streamEventNextEvent;
                }
                this.baseRetryDelayMillis = ((SetRetryDelayEvent) streamEventNextEvent).getRetryMillis();
                resetRetryDelayStrategy();
            } catch (StreamException e) {
                e = e;
                this.readyState.set(ReadyState.CLOSED);
                if (this.deliberatelyClosedConnection) {
                    e = new StreamClosedByCallerException();
                    this.deliberatelyClosedConnection = false;
                }
                this.disconnectedTime = System.currentTimeMillis();
                closeCurrentStream(false, false);
                this.eventParser = null;
                computeReconnectDelay();
                if (applyErrorStrategy(e) == ErrorStrategy.Action.CONTINUE) {
                    return new FaultEvent(e, null);
                }
                throw e;
            }
        }
    }

    private void resetRetryDelayStrategy() {
        this.logger.debug("Resetting retry delay strategy to initial state");
        this.currentRetryDelayStrategy = this.baseRetryDelayStrategy;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FaultEvent tryStart(boolean z) throws StreamException {
        StreamException e;
        ConnectStrategy.Client.Result resultConnect;
        if (this.eventParser != null) {
            return null;
        }
        this.readingThread.set(Thread.currentThread());
        do {
            if (this.nextReconnectDelayMillis > 0) {
                long j = this.disconnectedTime;
                long jCurrentTimeMillis = this.nextReconnectDelayMillis;
                if (j != 0) {
                    jCurrentTimeMillis -= System.currentTimeMillis() - this.disconnectedTime;
                }
                if (jCurrentTimeMillis > 0) {
                    this.logger.info("Waiting {} milliseconds before reconnecting", Long.valueOf(jCurrentTimeMillis));
                    try {
                        synchronized (this.sleepNotifier) {
                            try {
                                if (!this.deliberatelyClosedConnection) {
                                    this.sleepNotifier.wait(jCurrentTimeMillis);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (InterruptedException unused) {
                        this.logger.debug("EventSource thread was interrupted during start()");
                        this.deliberatelyClosedConnection = true;
                        Thread.interrupted();
                    }
                    e = this.deliberatelyClosedConnection ? new StreamClosedByCallerException() : null;
                }
            }
            if (e == null) {
                this.readyState.set(ReadyState.CONNECTING);
                this.connectedTime = 0L;
                this.calledStop = false;
                this.deliberatelyClosedConnection = false;
                try {
                    resultConnect = this.client.connect(this.lastEventId);
                } catch (StreamException e2) {
                    e = e2;
                    resultConnect = null;
                }
            } else {
                resultConnect = null;
            }
            if (e == null) {
                this.connectionCloser.set(resultConnect.getCloser());
                this.origin = resultConnect.getOrigin() == null ? this.client.getOrigin() : resultConnect.getOrigin();
                this.connectedTime = System.currentTimeMillis();
                this.logger.debug("Connected to SSE stream");
                this.eventParser = new EventParser(resultConnect.getInputStream(), resultConnect.getOrigin(), this.readBufferSize, this.streamEventData, this.expectFields, this.logger, resultConnect.getHeaders());
                this.readyState.set(ReadyState.OPEN);
                this.currentErrorStrategy = this.baseErrorStrategy;
                return null;
            }
            this.disconnectedTime = System.currentTimeMillis();
            computeReconnectDelay();
            if (applyErrorStrategy(e) != ErrorStrategy.Action.CONTINUE) {
                throw e;
            }
        } while (!z);
        return new FaultEvent(e, e instanceof StreamHttpErrorException ? ((StreamHttpErrorException) e).getHeaders() : null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AtomicReference<ReadyState> atomicReference = this.readyState;
        ReadyState readyState = ReadyState.SHUTDOWN;
        if (atomicReference.getAndSet(readyState) == readyState) {
            return;
        }
        closeCurrentStream(true, true);
        try {
            this.client.close();
        } catch (IOException unused) {
        }
    }

    public LDLogger getLogger() {
        return this.logger;
    }

    public ReadyState getState() {
        return this.readyState.get();
    }

    public StreamEvent readAnyEvent() {
        return requireEvent();
    }
}
