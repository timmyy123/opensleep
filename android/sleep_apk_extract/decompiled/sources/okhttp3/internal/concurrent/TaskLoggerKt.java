package okhttp3.internal.concurrent;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "", "message", "", "log", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Ljava/lang/String;)V", "", "ns", "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class TaskLoggerKt {
    public static final String formatDuration(long j) {
        String strM;
        if (j <= -999500000) {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j - 500000000) / 1000000000, " s ", new StringBuilder());
        } else if (j <= -999500) {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j - 500000) / 1000000, " ms", new StringBuilder());
        } else if (j <= 0) {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j - 500) / 1000, " µs", new StringBuilder());
        } else if (j < 999500) {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j + 500) / 1000, " µs", new StringBuilder());
        } else if (j < 999500000) {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j + 500000) / 1000000, " ms", new StringBuilder());
        } else {
            strM = FileInsert$$ExternalSyntheticOutline0.m((j + 500000000) / 1000000000, " s ", new StringBuilder());
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return String.format("%6s", Arrays.copyOf(new Object[]{strM}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.INSTANCE.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        sb.append(String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)));
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }
}
