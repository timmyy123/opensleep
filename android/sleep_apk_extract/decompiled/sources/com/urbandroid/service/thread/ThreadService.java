package com.urbandroid.service.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadService {
    private static final Condition condition;
    private static ThreadService instance;
    private static final Lock lock;
    private boolean isSuspended = false;
    private ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.urbandroid.service.thread.ThreadService.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(1);
            return thread;
        }
    });

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        condition = reentrantLock.newCondition();
    }

    public static ThreadService getInstance() {
        Lock lock2 = lock;
        lock2.lock();
        try {
            if (instance == null) {
                instance = new ThreadService();
            }
            ThreadService threadService = instance;
            lock2.unlock();
            return threadService;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public void scheduleForExecution(Runnable runnable) {
        this.executorService.execute(runnable);
    }
}
