package com.launchdarkly.eventsource.background;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.launchdarkly.eventsource.CommentEvent;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.FaultEvent;
import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.StartedEvent;
import com.launchdarkly.eventsource.StreamClosedByCallerException;
import com.launchdarkly.eventsource.StreamEvent;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class BackgroundEventSource implements Closeable {
    private final EventSource eventSource;
    private final Semaphore eventThreadSemaphore;
    private final Executor eventsExecutor;
    private final BackgroundEventHandler handler;
    private final LDLogger logger;
    private final boolean shouldCloseEventsExecutor;
    private final boolean shouldCloseStreamExecutor;
    private final Executor streamExecutor;
    private final AtomicBoolean started = new AtomicBoolean();
    private final AtomicBoolean closed = new AtomicBoolean();

    public static class Builder {
        private final EventSource.Builder eventSourceBuilder;
        private Executor eventsExecutor;
        private final BackgroundEventHandler handler;
        private int maxEventTasksInFlight;
        private Executor streamExecutor;
        private String threadBaseName;
        private int threadPriority;

        public Builder(BackgroundEventHandler backgroundEventHandler, EventSource.Builder builder) {
            if (backgroundEventHandler == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("handler cannot be null");
                throw null;
            }
            if (builder == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("eventSourceBuilder cannot be null");
                throw null;
            }
            this.eventSourceBuilder = builder;
            this.handler = backgroundEventHandler;
        }

        public static /* synthetic */ ConnectionErrorHandler access$200(Builder builder) {
            builder.getClass();
            return null;
        }

        public BackgroundEventSource build() {
            return new BackgroundEventSource(this);
        }
    }

    public BackgroundEventSource(Builder builder) {
        EventSource eventSourceBuild = builder.eventSourceBuilder.build();
        this.eventSource = eventSourceBuild;
        this.handler = builder.handler;
        Builder.access$200(builder);
        if (builder.eventsExecutor == null) {
            this.eventsExecutor = Executors.newSingleThreadExecutor(makeSimpleDaemonThreadFactory("okhttp-eventsource-events", builder.threadBaseName, builder.threadPriority));
            this.shouldCloseEventsExecutor = true;
        } else {
            this.eventsExecutor = builder.eventsExecutor;
            this.shouldCloseEventsExecutor = false;
        }
        if (builder.streamExecutor == null) {
            this.streamExecutor = Executors.newSingleThreadExecutor(makeSimpleDaemonThreadFactory("okhttp-eventsource-stream", builder.threadBaseName, builder.threadPriority));
            this.shouldCloseStreamExecutor = true;
        } else {
            this.streamExecutor = builder.streamExecutor;
            this.shouldCloseStreamExecutor = false;
        }
        if (builder.maxEventTasksInFlight > 0) {
            this.eventThreadSemaphore = new Semaphore(builder.maxEventTasksInFlight);
        } else {
            this.eventThreadSemaphore = null;
        }
        this.logger = eventSourceBuild.getLogger();
    }

    private void dispatchEvent(final StreamEvent streamEvent) {
        if (this.closed.get()) {
            return;
        }
        Semaphore semaphore = this.eventThreadSemaphore;
        if (semaphore != null) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RejectedExecutionException("Thread interrupted while waiting for event thread semaphore", e);
            }
        }
        this.eventsExecutor.execute(new Runnable() { // from class: com.launchdarkly.eventsource.background.BackgroundEventSource.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        StreamEvent streamEvent2 = streamEvent;
                        if (streamEvent2 instanceof MessageEvent) {
                            MessageEvent messageEvent = (MessageEvent) streamEvent2;
                            try {
                                BackgroundEventSource.this.handler.onMessage(messageEvent.getEventName(), messageEvent);
                                messageEvent.close();
                            } catch (Throwable th) {
                                messageEvent.close();
                                throw th;
                            }
                        } else if (streamEvent2 instanceof CommentEvent) {
                            BackgroundEventSource.this.handler.onComment(((CommentEvent) streamEvent2).getText());
                        } else if (streamEvent2 instanceof StartedEvent) {
                            BackgroundEventSource.this.handler.onOpen();
                        } else if (streamEvent2 instanceof FaultEvent) {
                            FaultEvent faultEvent = (FaultEvent) streamEvent2;
                            if (!(faultEvent.getCause() instanceof StreamClosedByCallerException)) {
                                BackgroundEventSource.this.handler.onError(faultEvent.getCause());
                            }
                            BackgroundEventSource.this.handler.onClosed();
                        }
                        if (BackgroundEventSource.this.eventThreadSemaphore != null) {
                            BackgroundEventSource.this.eventThreadSemaphore.release();
                        }
                    } catch (Exception e2) {
                        BackgroundEventSource.this.logger.warn("Caught unexpected error from EventHandler: {}", LogValues.exceptionSummary(e2));
                        BackgroundEventSource.this.logger.debug(LogValues.exceptionTrace(e2));
                        try {
                            BackgroundEventSource.this.handler.onError(e2);
                        } catch (Exception e3) {
                            BackgroundEventSource.this.logger.warn("Caught unexpected error from EventHandler.onError(): {}", LogValues.exceptionSummary(e3));
                            BackgroundEventSource.this.logger.debug(LogValues.exceptionTrace(e3));
                        }
                        if (BackgroundEventSource.this.eventThreadSemaphore != null) {
                            BackgroundEventSource.this.eventThreadSemaphore.release();
                        }
                    }
                } catch (Throwable th2) {
                    if (BackgroundEventSource.this.eventThreadSemaphore != null) {
                        BackgroundEventSource.this.eventThreadSemaphore.release();
                    }
                    throw th2;
                }
            }
        });
    }

    private ThreadFactory makeSimpleDaemonThreadFactory(String str, String str2, final int i) {
        final String strM = FileInsert$$ExternalSyntheticOutline0.m(str, "[", str2, "]");
        final ThreadGroup threadGroup = new ThreadGroup(strM);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        threadGroup.setDaemon(true);
        return new ThreadFactory() { // from class: com.launchdarkly.eventsource.background.BackgroundEventSource.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(threadGroup, runnable, strM + "-" + atomicInteger.incrementAndGet());
                thread.setDaemon(true);
                int i2 = i;
                if (i2 > 0) {
                    thread.setPriority(i2);
                }
                return thread;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pollAndDispatchEvent() {
        StreamEvent faultEvent;
        try {
            faultEvent = this.eventSource.readAnyEvent();
        } catch (StreamException e) {
            faultEvent = new FaultEvent(e);
        }
        if (!(faultEvent instanceof FaultEvent)) {
            dispatchEvent(faultEvent);
            return true;
        }
        if (((FaultEvent) faultEvent).getCause() instanceof StreamClosedByCallerException) {
            return false;
        }
        dispatchEvent(faultEvent);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (this.closed.getAndSet(true)) {
                    return;
                }
                this.logger.debug("BackgroundEventSource stopping");
                this.eventSource.close();
                if (this.shouldCloseStreamExecutor) {
                    Executor executor = this.streamExecutor;
                    if (executor instanceof ExecutorService) {
                        ((ExecutorService) executor).shutdown();
                        try {
                            ((ExecutorService) this.streamExecutor).awaitTermination(1L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                if (this.shouldCloseEventsExecutor) {
                    Executor executor2 = this.eventsExecutor;
                    if (executor2 instanceof ExecutorService) {
                        ((ExecutorService) executor2).shutdown();
                        try {
                            ((ExecutorService) this.eventsExecutor).awaitTermination(1L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public EventSource getEventSource() {
        return this.eventSource;
    }

    public void start() {
        synchronized (this) {
            try {
                if (!this.closed.get() && !this.started.get()) {
                    this.started.set(true);
                    this.streamExecutor.execute(new Runnable() { // from class: com.launchdarkly.eventsource.background.BackgroundEventSource.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BackgroundEventSource.this.logger.debug("BackgroundEventSource started");
                            while (BackgroundEventSource.this.pollAndDispatchEvent()) {
                            }
                            new Thread(new Runnable() { // from class: com.launchdarkly.eventsource.background.BackgroundEventSource.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BackgroundEventSource.this.close();
                                }
                            }).start();
                        }
                    });
                }
            } finally {
            }
        }
    }
}
