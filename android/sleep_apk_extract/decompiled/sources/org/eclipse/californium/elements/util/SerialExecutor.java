package org.eclipse.californium.elements.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class SerialExecutor extends AbstractExecutorService implements AutoCloseable {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) SerialExecutor.class);
    private Runnable currentlyExecutedJob;
    private final Executor executor;
    private final ReentrantLock lock;
    private boolean shutdown;
    private final Condition terminated;
    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private final AtomicReference<ExecutionListener> listener = new AtomicReference<>();
    private final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue();

    public interface ExecutionListener {
        void afterExecution();

        void beforeExecution();
    }

    public SerialExecutor(Executor executor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.terminated = reentrantLock.newCondition();
        if (executor == null) {
            this.shutdown = true;
        }
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOwner() {
        AtomicReference<Thread> atomicReference = this.owner;
        Thread threadCurrentThread = Thread.currentThread();
        while (!atomicReference.compareAndSet(threadCurrentThread, null)) {
            if (atomicReference.get() != threadCurrentThread) {
                Thread thread = this.owner.get();
                if (thread == null) {
                    throw new ConcurrentModificationException(this + " is not owned, clear failed!");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                String name = thread.getName();
                sb.append(" owned by ");
                sb.append(name);
                sb.append(", clear failed!");
                throw new ConcurrentModificationException(sb.toString());
            }
        }
    }

    public static SerialExecutor create(Executor executor) {
        if (executor != null) {
            return new SerialExecutor(executor);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleNextJob() {
        this.lock.lock();
        try {
            final Runnable runnablePoll = this.tasks.poll();
            this.currentlyExecutedJob = runnablePoll;
            if (runnablePoll != null) {
                this.executor.execute(new Runnable() { // from class: org.eclipse.californium.elements.util.SerialExecutor.1
                    /* JADX WARN: Finally extract failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SerialExecutor.this.setOwner();
                            ExecutionListener executionListener = (ExecutionListener) SerialExecutor.this.listener.get();
                            if (executionListener != null) {
                                try {
                                    executionListener.beforeExecution();
                                } catch (Throwable th) {
                                    try {
                                        SerialExecutor.LOGGER.error("unexpected error occurred:", th);
                                        if (executionListener != null) {
                                            try {
                                                executionListener.afterExecution();
                                            } catch (Throwable th2) {
                                                SerialExecutor.LOGGER.error("unexpected error occurred:", th2);
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        if (executionListener != null) {
                                            try {
                                                executionListener.afterExecution();
                                            } catch (Throwable th4) {
                                                SerialExecutor.LOGGER.error("unexpected error occurred:", th4);
                                            }
                                        }
                                        SerialExecutor.this.clearOwner();
                                        throw th3;
                                    }
                                }
                            }
                            runnablePoll.run();
                            if (executionListener != null) {
                                try {
                                    executionListener.afterExecution();
                                } catch (Throwable th5) {
                                    SerialExecutor.LOGGER.error("unexpected error occurred:", th5);
                                }
                            }
                            SerialExecutor.this.clearOwner();
                            SerialExecutor.this.scheduleNextJob();
                        } catch (Throwable th6) {
                            SerialExecutor.this.scheduleNextJob();
                            throw th6;
                        }
                    }
                });
            } else if (this.shutdown) {
                this.terminated.signalAll();
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOwner() {
        Thread thread = this.owner.get();
        AtomicReference<Thread> atomicReference = this.owner;
        Thread threadCurrentThread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, threadCurrentThread)) {
            if (atomicReference.get() != null) {
                if (thread == null) {
                    throw new ConcurrentModificationException(this + " was already owned!");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                String name = thread.getName();
                sb.append(" already owned by ");
                sb.append(name);
                sb.append("!");
                throw new ConcurrentModificationException(sb.toString());
            }
        }
    }

    public void assertOwner() {
        if (this.owner.get() != Thread.currentThread()) {
            Thread thread = this.owner.get();
            if (thread == null) {
                throw new ConcurrentModificationException(this + " is not owned!");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            String name = thread.getName();
            sb.append(" owned by ");
            sb.append(name);
            sb.append("!");
            throw new ConcurrentModificationException(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    @Override // java.util.concurrent.ExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        boolean z;
        this.lock.lock();
        try {
            long nanos = timeUnit.toNanos(j);
            do {
                if (this.shutdown && this.currentlyExecutedJob == null) {
                    break;
                }
                nanos = this.terminated.awaitNanos(nanos);
            } while (nanos > 0);
            if (this.shutdown) {
                z = this.currentlyExecutedJob == null;
            }
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean checkOwner() {
        return this.owner.get() == Thread.currentThread();
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.lock.lock();
        try {
            if (this.shutdown) {
                throw new RejectedExecutionException("SerialExecutor already shutdown!");
            }
            this.tasks.offer(runnable);
            if (this.currentlyExecutedJob == null) {
                scheduleNextJob();
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        this.lock.lock();
        try {
            return this.shutdown;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    @Override // java.util.concurrent.ExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isTerminated() {
        boolean z;
        this.lock.lock();
        try {
            if (this.shutdown) {
                z = this.currentlyExecutedJob == null;
            }
            return z;
        } finally {
            this.lock.unlock();
        }
    }

    public ExecutionListener setExecutionListener(ExecutionListener executionListener) {
        return this.listener.getAndSet(executionListener);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.lock.lock();
        try {
            this.shutdown = true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        this.lock.lock();
        try {
            ArrayList arrayList = new ArrayList(this.tasks.size());
            shutdownNow(arrayList);
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    public int shutdownNow(Collection<Runnable> collection) {
        this.lock.lock();
        try {
            shutdown();
            return this.tasks.drainTo(collection);
        } finally {
            this.lock.unlock();
        }
    }
}
