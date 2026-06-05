package com.urbandroid.sleep.audio;

import com.facebook.AuthenticationTokenClaims;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioRecorder;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class AudioThreadManager {
    private final ThreadPoolExecutor threadPool;
    public static AudioThreadManager instance = new AudioThreadManager();
    private static final AtomicLong lastLogTimestamp = new AtomicLong(0);
    private static final AtomicLong lastLatchTimestamp = new AtomicLong(0);
    private static long lastDumpTs = -1;

    private AudioThreadManager() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.threadPool = new ThreadPoolExecutor(iAvailableProcessors > 0 ? iAvailableProcessors : 1, iAvailableProcessors > 0 ? iAvailableProcessors : 1, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static void dumpThreads() {
        if (lastDumpTs == -1 || System.currentTimeMillis() - lastDumpTs > 360000) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            for (Thread thread : allStackTraces.keySet()) {
                StackTraceElement[] stackTraceElementArr = allStackTraces.get(thread);
                if (thread.getName().startsWith("cons")) {
                    Logger.logDebug("ThreadDump: " + thread.getName() + " " + thread.getState());
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        Logger.logDebug("\t\t\t" + stackTraceElement.toString());
                    }
                }
            }
            lastDumpTs = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLoggingAllowed() {
        return System.currentTimeMillis() - lastLogTimestamp.get() > AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED;
    }

    public static String print() {
        return "queue: " + instance.threadPool.getQueue().size() + " active: " + instance.threadPool.getActiveCount();
    }

    public static void processConsumer(final AudioRecorder.Consumer consumer, final AudioReadBuffer audioReadBuffer, final CountDownLatch countDownLatch) {
        instance.threadPool.execute(new Runnable() { // from class: com.urbandroid.sleep.audio.AudioThreadManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        Thread.currentThread().setName("cons".concat(consumer.getClass().getSimpleName().substring(0, 13)));
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        consumer.process(audioReadBuffer);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (AudioThreadManager.isLoggingAllowed() || jCurrentTimeMillis2 > 1000) {
                            AudioThreadManager.lastLogTimestamp.set(System.currentTimeMillis());
                            Logger.logDebug("\t--- " + jCurrentTimeMillis2 + " ms " + AudioThreadManager.print());
                        }
                        CountDownLatch countDownLatch2 = countDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                    } catch (Exception e) {
                        Logger.logWarning(consumer.getClass().getSimpleName().concat(" failure"), e);
                        CountDownLatch countDownLatch3 = countDownLatch;
                        if (countDownLatch3 != null) {
                            countDownLatch3.countDown();
                        }
                    }
                } catch (Throwable th) {
                    CountDownLatch countDownLatch4 = countDownLatch;
                    if (countDownLatch4 != null) {
                        countDownLatch4.countDown();
                    }
                    throw th;
                }
            }
        });
    }
}
