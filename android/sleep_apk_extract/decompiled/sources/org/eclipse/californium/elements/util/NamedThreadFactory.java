package org.eclipse.californium.elements.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class NamedThreadFactory implements ThreadFactory {
    public static final ThreadGroup COAP_THREAD_GROUP;
    public static final ThreadGroup SCANDIUM_THREAD_GROUP;
    private final ThreadGroup group;
    private final AtomicInteger index;
    private final String prefix;

    static {
        ThreadGroup threadGroup = new ThreadGroup("Californium");
        COAP_THREAD_GROUP = threadGroup;
        ThreadGroup threadGroup2 = new ThreadGroup("Scandium");
        SCANDIUM_THREAD_GROUP = threadGroup2;
        threadGroup.setDaemon(false);
        threadGroup2.setDaemon(false);
    }

    public NamedThreadFactory(String str, ThreadGroup threadGroup) {
        this.index = new AtomicInteger(1);
        this.group = threadGroup == null ? COAP_THREAD_GROUP : threadGroup;
        this.prefix = str;
    }

    public boolean createDaemonThreads() {
        return false;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.prefix + this.index.getAndIncrement(), 0L);
        thread.setDaemon(createDaemonThreads());
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }

    public NamedThreadFactory(String str) {
        this(str, null);
    }
}
