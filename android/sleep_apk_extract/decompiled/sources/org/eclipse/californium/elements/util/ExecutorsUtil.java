package org.eclipse.californium.elements.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExecutorsUtil {
    private static final Boolean REMOVE_ON_CANCEL;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ExecutorsUtil.class);
    private static final Runnable WARMUP = new Runnable() { // from class: org.eclipse.californium.elements.util.ExecutorsUtil.1
        @Override // java.lang.Runnable
        public void run() {
            ExecutorsUtil.LOGGER.trace("warmup ...");
        }
    };
    public static final ThreadGroup TIMER_THREAD_GROUP = new ThreadGroup("Timer");

    static {
        boolean configurationBoolean = StringUtil.getConfigurationBoolean("EXECUTER_REMOVE_ON_CANCEL");
        if (configurationBoolean) {
            try {
                ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                configurationBoolean = false;
            }
        }
        REMOVE_ON_CANCEL = Boolean.valueOf(configurationBoolean);
    }

    public static ExecutorService newFixedThreadPool(int i, ThreadFactory threadFactory) {
        LOGGER.trace("create thread pool of {} threads", Integer.valueOf(i));
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i, threadFactory);
        executorServiceNewFixedThreadPool.execute(WARMUP);
        return executorServiceNewFixedThreadPool;
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        LOGGER.trace("create scheduled single thread pool");
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);
        setRemoveOnCancelPolicy(scheduledExecutorServiceNewSingleThreadScheduledExecutor);
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.execute(WARMUP);
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private static void setRemoveOnCancelPolicy(ScheduledExecutorService scheduledExecutorService) {
        Boolean bool = REMOVE_ON_CANCEL;
        if (bool == null || !(scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            return;
        }
        ((ScheduledThreadPoolExecutor) scheduledExecutorService).setRemoveOnCancelPolicy(bool.booleanValue());
    }
}
