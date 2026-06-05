package pl.edu.icm.jlargearrays;

import java.lang.Thread;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ConcurrencyUtils {
    private static final ExecutorService DEFAULT_THREAD_POOL;
    private static long concurrentThreshold;
    private static int nthreads;
    private static ExecutorService threadPool;

    public static class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {
        private CustomExceptionHandler() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class CustomThreadFactory implements ThreadFactory {
        private static final ThreadFactory DEFAULT_FACTORY = Executors.defaultThreadFactory();
        private final Thread.UncaughtExceptionHandler handler;

        public CustomThreadFactory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.handler = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = DEFAULT_FACTORY.newThread(runnable);
            threadNewThread.setUncaughtExceptionHandler(this.handler);
            return threadNewThread;
        }
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new CustomThreadFactory(new CustomExceptionHandler()));
        DEFAULT_THREAD_POOL = executorServiceNewCachedThreadPool;
        threadPool = executorServiceNewCachedThreadPool;
        nthreads = getNumberOfProcessors();
        concurrentThreshold = 100000L;
    }

    public static long getConcurrentThreshold() {
        return concurrentThreshold;
    }

    public static int getNumberOfProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static int getNumberOfThreads() {
        return nthreads;
    }

    public static Future<?> submit(Runnable runnable) {
        if (threadPool.isShutdown() || threadPool.isTerminated()) {
            threadPool = DEFAULT_THREAD_POOL;
        }
        return threadPool.submit(runnable);
    }

    public static void waitForCompletion(Future<?>[] futureArr) throws ExecutionException, InterruptedException {
        for (Future<?> future : futureArr) {
            future.get();
        }
    }
}
