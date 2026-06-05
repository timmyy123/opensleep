package com.google.android.datatransport.runtime.scheduling;

import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultScheduler implements Scheduler {
    private static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    private final BackendRegistry backendRegistry;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = backendRegistry;
        this.workScheduler = workScheduler;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$schedule$0(TransportContext transportContext, EventInternal eventInternal) {
        this.eventStore.persist(transportContext, eventInternal);
        this.workScheduler.schedule(transportContext, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$schedule$1(TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
            if (transportBackend != null) {
                this.guard.runCriticalSection(new ListenableFutureKt$$ExternalSyntheticLambda0(this, transportContext, transportBackend.decorate(eventInternal), 3));
                ((TransportImpl$$ExternalSyntheticLambda0) transportScheduleCallback).onSchedule(null);
                return;
            }
            String str = "Transport backend '" + transportContext.getBackendName() + "' is not registered";
            LOGGER.warning(str);
            ((TransportImpl$$ExternalSyntheticLambda0) transportScheduleCallback).onSchedule(new IllegalArgumentException(str));
        } catch (Exception e) {
            LOGGER.warning("Error scheduling event " + e.getMessage());
            ((TransportImpl$$ExternalSyntheticLambda0) transportScheduleCallback).onSchedule(e);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.executor.execute(new Schedulers$$ExternalSyntheticLambda1(this, transportContext, transportScheduleCallback, eventInternal, 4));
    }
}
