package com.urbandroid.common.logging;

import android.content.Context;
import android.util.Log;
import androidx.appfunctions.AppFunctionException;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.filter.Filter;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Logger {
    private static LogConfig DEFAULT_LOG = null;
    private static int appVersion = 0;
    public static String defaultTag = "UNSPECIFIED";
    private static Map<LogConfig, LogBuffer> logBuffers;
    private static LogFlusher logFlusher;
    private static Map<LogConfig, LogBuffer> logWriteBuffers;
    private static Set<LogConfig> logConfigs = new HashSet();
    private static final String[] LEVEL_NAMES = {"VERBOSE", "DEBUG", "INFO", "WARN", "SEVERE"};
    private static int loglevel = 2;
    private static int logInMemorylevel = 2;
    private static Map<LogConfig, BufferedWriter> currentLogWriters = new HashMap();
    private static Map<LogConfig, Integer> currentLogWriterLinesWritten = new HashMap();
    private static Map<LogConfig, Long> currentLogWriterBytesWritten = new HashMap();
    private static Set<Filter> filters = new HashSet();
    private static boolean filtersEnabled = true;
    private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() { // from class: com.urbandroid.common.logging.Logger.1
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new SimpleDateFormat("ddMMM HH:mm:ss.SSS", Locale.ENGLISH);
        }
    };
    private static ThreadLocal<DateFormat> dateFormatWithDate = new ThreadLocal<DateFormat>() { // from class: com.urbandroid.common.logging.Logger.2
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        }
    };

    public static class LogBuffer {
        private final LinkedList<LogRecord> buffer;
        private final AtomicInteger discardedRecordsCount;

        private LogBuffer() {
            this.buffer = new LinkedList<>();
            this.discardedRecordsCount = new AtomicInteger();
        }
    }

    public static class LogConfig {
        final String logFileName;
        public final String logName;
        final int maxInMemoryLines;
        final int maxLinesPerLogFile;
        final int maxLogFiles;
        final int minLengthToRotate;
        final boolean writeHeader;

        public LogConfig(String str, String str2, boolean z, int i, int i2, int i3, int i4) {
            this.logName = str;
            this.logFileName = str2;
            this.writeHeader = z;
            this.minLengthToRotate = i;
            this.maxLogFiles = i2;
            this.maxLinesPerLogFile = i3;
            this.maxInMemoryLines = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.logFileName.equals(((LogConfig) obj).logFileName);
        }

        public int hashCode() {
            return this.logFileName.hashCode();
        }
    }

    public static class LogFlusher implements Runnable {
        private final Object FLUSH_COND;
        private final Context context;
        private final int flushFrequencySeconds;
        private final Set<Object> waiters;

        private LogFlusher(Context context, int i) {
            this.FLUSH_COND = new Object();
            this.waiters = new HashSet();
            this.context = context;
            this.flushFrequencySeconds = i;
        }

        private long rotateLogFilesIfRequired(Context context, LogConfig logConfig) {
            File file = new File(Logger.getCurrentLogFileName(context, logConfig));
            long length = file.exists() ? file.length() : 0L;
            if (!file.exists() || length < logConfig.minLengthToRotate) {
                Logger.logDebug("No need to rotate log (" + logConfig.logFileName + "), too small: " + length);
                return length;
            }
            Logger.logDebug("Rotating log files: " + logConfig.logFileName);
            File file2 = new File(Logger.getOldLogFileName(context, logConfig, logConfig.maxLogFiles));
            if (file2.exists()) {
                file2.delete();
            }
            for (int i = logConfig.maxLogFiles - 1; i > 0; i--) {
                File file3 = new File(Logger.getOldLogFileName(context, logConfig, i));
                if (file3.exists()) {
                    file3.renameTo(new File(Logger.getOldLogFileName(context, logConfig, i + 1)));
                }
            }
            return 0L;
        }

        public void forceFlush(boolean z) {
            Object obj = new Object();
            synchronized (this.FLUSH_COND) {
                try {
                    this.FLUSH_COND.notifyAll();
                    if (z) {
                        this.waiters.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    synchronized (obj) {
                        obj.wait(5000L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    synchronized (this.FLUSH_COND) {
                        this.FLUSH_COND.wait(this.flushFrequencySeconds * 1000);
                    }
                    synchronized (Logger.class) {
                        Map unused = Logger.logWriteBuffers = Logger.logBuffers;
                        Logger.initLogBuffer();
                    }
                    if (Logger.logWriteBuffers != null) {
                        for (Map.Entry entry : Logger.logWriteBuffers.entrySet()) {
                            LogConfig logConfig = (LogConfig) entry.getKey();
                            LogBuffer logBuffer = (LogBuffer) entry.getValue();
                            BufferedWriter bufferedWriter = (BufferedWriter) Logger.currentLogWriters.get(logConfig);
                            if (!logBuffer.buffer.isEmpty()) {
                                if (bufferedWriter == null) {
                                    try {
                                        Logger.currentLogWriterBytesWritten.put(logConfig, Long.valueOf(rotateLogFilesIfRequired(this.context, logConfig)));
                                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Logger.getCurrentLogFileName(this.context, logConfig), true)));
                                        Logger.currentLogWriters.put(logConfig, bufferedWriter);
                                        if (logConfig.writeHeader) {
                                            bufferedWriter.write("************ Log file started [" + new Date() + "] Version: " + new ApplicationVersionExtractor().getCurrentVersion(this.context) + " **************");
                                        }
                                        bufferedWriter.newLine();
                                    } catch (IOException e) {
                                        Logger.logSevere(e);
                                    }
                                }
                                int i = logBuffer.discardedRecordsCount.get();
                                if (i > 0) {
                                    bufferedWriter.write("*** Discarded initial records: " + i);
                                    bufferedWriter.newLine();
                                }
                                int iIntValue = Logger.currentLogWriterLinesWritten.get(logConfig) != null ? ((Integer) Logger.currentLogWriterLinesWritten.get(logConfig)).intValue() : 0;
                                long jLongValue = Logger.currentLogWriterBytesWritten.get(logConfig) != null ? ((Long) Logger.currentLogWriterBytesWritten.get(logConfig)).longValue() : 0L;
                                Iterator it = logBuffer.buffer.iterator();
                                while (it.hasNext()) {
                                    String formattedRecord = ((LogRecord) it.next()).getFormattedRecord();
                                    bufferedWriter.write(formattedRecord);
                                    bufferedWriter.newLine();
                                    iIntValue++;
                                    jLongValue += (long) (formattedRecord.length() + 1);
                                }
                                Logger.currentLogWriterLinesWritten.put(logConfig, Integer.valueOf(iIntValue));
                                Logger.currentLogWriterBytesWritten.put(logConfig, Long.valueOf(jLongValue));
                                bufferedWriter.flush();
                                synchronized (Logger.class) {
                                    logBuffer.buffer.clear();
                                }
                                synchronized (this.FLUSH_COND) {
                                    try {
                                        for (Object obj : this.waiters) {
                                            synchronized (obj) {
                                                obj.notifyAll();
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                if (Logger.currentLogWriterLinesWritten.get(logConfig) != null) {
                                    ((Integer) Logger.currentLogWriterLinesWritten.get(logConfig)).getClass();
                                }
                                long jLongValue2 = Logger.currentLogWriterBytesWritten.get(logConfig) != null ? ((Long) Logger.currentLogWriterBytesWritten.get(logConfig)).longValue() : 0L;
                                if (jLongValue2 > logConfig.minLengthToRotate) {
                                    bufferedWriter.write("Written bytes: " + jLongValue2 + " -> rotating");
                                    Logger.currentLogWriterBytesWritten.put(logConfig, 0L);
                                    bufferedWriter.close();
                                    Logger.currentLogWriters.remove(logConfig);
                                }
                            }
                        }
                    }
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public static class LogRecord {
        final LogConfig config;
        final int level;
        final String message;
        final String tag;
        final String threadName;
        final Throwable throwable;
        final long timestamp;

        public LogRecord(LogConfig logConfig, int i, long j, String str, String str2, String str3, Throwable th) {
            this.config = logConfig;
            this.level = i;
            this.timestamp = j;
            this.tag = str;
            this.message = str2;
            this.threadName = str3;
            this.throwable = th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogRecord)) {
                return false;
            }
            LogRecord logRecord = (LogRecord) obj;
            if (this.level == logRecord.level && this.timestamp == logRecord.timestamp) {
                String str = this.message;
                String str2 = logRecord.message;
                if (str == null ? str2 == null : str.equals(str2)) {
                    String str3 = this.tag;
                    String str4 = logRecord.tag;
                    if (str3 == null ? str4 == null : str3.equals(str4)) {
                        String str5 = this.threadName;
                        String str6 = logRecord.threadName;
                        if (str5 == null ? str6 == null : str5.equals(str6)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public String getFormattedRecord() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append((getLevelName() == null || getLevelName().length() <= 1) ? getLevelName() : getLevelName().substring(0, 1));
            sb.append(Logger.formatMessage(this.config, this.timestamp, this.message, this.threadName));
            if (this.throwable == null) {
                str = "";
            } else {
                str = " " + this.throwable.getClass().getName() + " " + this.throwable.getMessage();
            }
            sb.append(str);
            if (this.throwable != null) {
                sb.append("\n");
                sb.append(Logger.appendStackTrace(this.throwable.getStackTrace()));
            }
            return sb.toString();
        }

        public String getLevelName() {
            return Logger.LEVEL_NAMES[this.level];
        }

        public int hashCode() {
            int i = this.level * 31;
            long j = this.timestamp;
            int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
            String str = this.tag;
            int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.message;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.threadName;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
    }

    private static boolean accept(long j, int i, String str, String str2, Throwable th) {
        synchronized (Logger.class) {
            try {
                if (!filtersEnabled) {
                    return true;
                }
                Iterator<Filter> it = filters.iterator();
                while (it.hasNext()) {
                    if (!it.next().accepts(j, i, str, str2, th)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void addFilter(Filter filter) {
        synchronized (Logger.class) {
            filters.add(filter);
        }
    }

    public static String appendStackTrace(StackTraceElement[] stackTraceElementArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                sb.append("\t");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            return "Failed to serialize report. Error: " + e.getClass() + " ->" + e.getMessage();
        }
    }

    private static void appendToBuffer(LogConfig logConfig, int i, long j, String str, String str2, Throwable th) {
        LogBuffer logBuffer;
        if (logConfig.maxInMemoryLines > 0) {
            LogRecord logRecord = new LogRecord(logConfig, i, j, str, str2, Thread.currentThread().getName(), th);
            synchronized (Logger.class) {
                try {
                    Map<LogConfig, LogBuffer> map = logBuffers;
                    if (map != null && (logBuffer = map.get(logConfig)) != null) {
                        logBuffer.buffer.addLast(logRecord);
                        if (logBuffer.buffer.size() > logConfig.maxInMemoryLines) {
                            logBuffer.buffer.removeFirst();
                            logBuffer.discardedRecordsCount.incrementAndGet();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatMessage(LogConfig logConfig, long j, String str, String str2) {
        String str3;
        boolean z = logConfig != null ? logConfig.writeHeader : true;
        DateFormat dateFormat2 = (z ? dateFormat : dateFormatWithDate).get();
        if (z) {
            str3 = "";
        } else {
            str3 = ", " + appVersion;
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(dateFormat2.format(new Date(j)));
        sb.append(", ");
        return Fragment$$ExternalSyntheticOutline1.m(sb, str2, str3, "]: ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCurrentLogFileName(Context context, LogConfig logConfig) {
        return context.getCacheDir().getAbsolutePath() + File.separator + logConfig.logFileName;
    }

    public static DateFormat getDateFormat() {
        return dateFormat.get();
    }

    public static Set<Filter> getFilters() {
        HashSet hashSet;
        synchronized (Logger.class) {
            hashSet = new HashSet(filters);
        }
        return hashSet;
    }

    public static List<LogRecord> getLogBufferIncluingWriteBuffer(LogConfig logConfig) {
        LinkedList linkedList;
        synchronized (Logger.class) {
            try {
                linkedList = new LinkedList();
                Map<LogConfig, LogBuffer> map = logWriteBuffers;
                if (map != null && map.get(logConfig) != null) {
                    linkedList.addAll(logWriteBuffers.get(logConfig).buffer);
                }
                Map<LogConfig, LogBuffer> map2 = logBuffers;
                if (map2 != null && map2.get(logConfig) != null) {
                    linkedList.addAll(logBuffers.get(logConfig).buffer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getOldLogFileName(Context context, LogConfig logConfig, int i) {
        if (i == 1) {
            return getCurrentLogFileName(context, logConfig);
        }
        return getCurrentLogFileName(context, logConfig) + "." + i;
    }

    public static File[] getPersistentBufferFiles(Context context, LogConfig logConfig) {
        LinkedList linkedList = new LinkedList();
        if (!new File(getCurrentLogFileName(context, logConfig)).exists()) {
            return (File[]) linkedList.toArray(new File[0]);
        }
        for (int i = logConfig.maxLogFiles; i > 0; i--) {
            File file = new File(getOldLogFileName(context, logConfig, i));
            if (file.exists()) {
                linkedList.add(file);
            }
        }
        return (File[]) linkedList.toArray(new File[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initLogBuffer() {
        logBuffers = new HashMap();
        Iterator<LogConfig> it = logConfigs.iterator();
        while (it.hasNext()) {
            logBuffers.put(it.next(), new LogBuffer());
        }
    }

    public static void initialize(Context context, String str, int i, int i2, LogConfig... logConfigArr) {
        String strConcat;
        boolean z;
        String currentProcessName = Environment.getCurrentProcessName(context);
        if (currentProcessName == null || context.getPackageName().equals(currentProcessName)) {
            strConcat = "logbuffer";
            z = true;
        } else {
            strConcat = "logbuffer_".concat(currentProcessName);
            z = false;
        }
        DEFAULT_LOG = new LogConfig("DEFAULT", strConcat, true, 200000, 8, 30000, AppFunctionException.ERROR_RESOURCE_NOT_FOUND);
        appVersion = new ApplicationVersionExtractor().getCurrentVersion(context).getVersionCode();
        loglevel = i;
        logInMemorylevel = i2;
        logConfigs.add(DEFAULT_LOG);
        if (logConfigArr != null) {
            Collections.addAll(logConfigs, logConfigArr);
        }
        initLogBuffer();
        defaultTag = str;
        if (context == null || context.getCacheDir() == null || context.getCacheDir().getAbsoluteFile() == null) {
            return;
        }
        logFlusher = new LogFlusher(context.getApplicationContext(), z ? 60 : 1);
        new Thread(logFlusher, "Log-Flusher").start();
    }

    public static boolean isInitialized() {
        return !defaultTag.equals("UNSPECIFIED");
    }

    public static void logDebug(String str, String str2, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (accept(jCurrentTimeMillis, 1, str, str2, th)) {
            logInMemory(DEFAULT_LOG, 1, jCurrentTimeMillis, str, str2, th);
            if (loglevel > 1) {
                return;
            }
            if (th != null) {
                Log.d(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2), th);
            } else {
                Log.d(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2));
            }
        }
    }

    private static void logInMemory(LogConfig logConfig, int i, long j, String str, String str2, Throwable th) {
        if (!isInitialized()) {
            Log.e(defaultTag, "Calling log before initializing logger.", new Exception("MARKER"));
        } else {
            if (logInMemorylevel > i) {
                return;
            }
            appendToBuffer(logConfig, i, j, str, str2, th);
        }
    }

    public static void logInfo(LogConfig logConfig, String str, String str2, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (accept(jCurrentTimeMillis, 2, str, str2, th)) {
            logInMemory(logConfig, 2, jCurrentTimeMillis, str, str2, th);
            if (loglevel > 2) {
                return;
            }
            if (th != null) {
                Log.i(str, formatMessage(logConfig, jCurrentTimeMillis, str2), th);
            } else {
                Log.i(str, formatMessage(logConfig, jCurrentTimeMillis, str2));
            }
        }
    }

    public static void logSevere(String str, String str2, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (accept(jCurrentTimeMillis, 4, str, str2, th)) {
            logInMemory(DEFAULT_LOG, 4, jCurrentTimeMillis, str, str2, th);
            if (loglevel > 4) {
                return;
            }
            if (th != null) {
                Log.e(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2), th);
            } else {
                Log.e(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2));
            }
        }
    }

    public static void logWarning(String str, String str2, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (accept(jCurrentTimeMillis, 3, str, str2, th)) {
            logInMemory(DEFAULT_LOG, 3, jCurrentTimeMillis, str, str2, th);
            if (loglevel > 3) {
                return;
            }
            if (th != null) {
                Log.w(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2), th);
            } else {
                Log.w(str, formatMessage(DEFAULT_LOG, jCurrentTimeMillis, str2));
            }
        }
    }

    public static void persistBuffer() {
        LogFlusher logFlusher2 = logFlusher;
        if (logFlusher2 != null) {
            logFlusher2.forceFlush(false);
        }
    }

    public static void setFiltersEnabled(boolean z) {
        synchronized (Logger.class) {
            filtersEnabled = z;
        }
    }

    public static void syncPersistBuffer() {
        LogFlusher logFlusher2 = logFlusher;
        if (logFlusher2 != null) {
            logFlusher2.forceFlush(true);
        }
    }

    public static void logInfo(String str, String str2, Throwable th) {
        logInfo(DEFAULT_LOG, str, str2, th);
    }

    public static void logInfo(String str, Throwable th) {
        logInfo(defaultTag, str, th);
    }

    public static void logInfo(String str) {
        logInfo(defaultTag, str, null);
    }

    public static void logDebug(String str, Throwable th) {
        logDebug(defaultTag, str, th);
    }

    public static void logSevere(String str, Throwable th) {
        logSevere(defaultTag, str, th);
    }

    public static void logWarning(String str, Throwable th) {
        logWarning(defaultTag, str, th);
    }

    public static void logDebug(String str) {
        logDebug(defaultTag, str, null);
    }

    public static void logSevere(Throwable th) {
        logSevere(defaultTag, "Exception occurred, no description given", th);
    }

    public static void logWarning(String str) {
        logWarning(defaultTag, str, null);
    }

    public static void logSevere(String str) {
        logSevere(defaultTag, str, null);
    }

    public static File[] getPersistentBufferFiles(Context context) {
        return getPersistentBufferFiles(context, DEFAULT_LOG);
    }

    public static List<LogRecord> getLogBufferIncluingWriteBuffer() {
        return getLogBufferIncluingWriteBuffer(DEFAULT_LOG);
    }

    private static String formatMessage(LogConfig logConfig, long j, String str) {
        return formatMessage(logConfig, j, str, Thread.currentThread().getName());
    }
}
