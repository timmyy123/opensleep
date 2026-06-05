package org.eclipse.californium.core.network.stack;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class MulticastCleanupMessageObserver extends CleanupMessageObserver {
    static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) MulticastCleanupMessageObserver.class);
    private volatile ScheduledFuture<?> cleanup;
    private final long multicastLifetime;
    private final ScheduledExecutorService scheduledExecutor;

    public MulticastCleanupMessageObserver(Exchange exchange, ScheduledExecutorService scheduledExecutorService, long j) {
        super(exchange);
        this.scheduledExecutor = scheduledExecutorService;
        this.multicastLifetime = j;
    }

    @Override // org.eclipse.californium.core.network.stack.CleanupMessageObserver
    public void complete(String str) {
        ScheduledFuture<?> scheduledFuture = this.cleanup;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        super.complete(str);
    }

    @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
    public void onSent(boolean z) {
        this.cleanup = this.scheduledExecutor.schedule(new Runnable() { // from class: org.eclipse.californium.core.network.stack.MulticastCleanupMessageObserver.1
            @Override // java.lang.Runnable
            public void run() {
                MulticastCleanupMessageObserver.this.exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.MulticastCleanupMessageObserver.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Response response = MulticastCleanupMessageObserver.this.exchange.getResponse();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (response == null) {
                            MulticastCleanupMessageObserver.this.exchange.getRequest().setCanceled(true);
                        } else {
                            MulticastCleanupMessageObserver.this.exchange.setComplete();
                            MulticastCleanupMessageObserver.this.exchange.getRequest().onComplete();
                        }
                    }
                });
            }
        }, this.multicastLifetime, TimeUnit.MILLISECONDS);
    }
}
