package io.reactivex.rxjava3.internal.schedulers;

import com.facebook.internal.ServerProtocol;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED = getBooleanProperty(true, "rx3.purge-enabled", true, true, new SystemPropertyAccessor());

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(PURGE_ENABLED);
        return scheduledThreadPoolExecutor;
    }

    public static boolean getBooleanProperty(boolean z, String str, boolean z2, boolean z3, Function<String, String> function) {
        if (!z) {
            return z3;
        }
        try {
            String strApply = function.apply(str);
            return strApply == null ? z2 : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(strApply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return z2;
        }
    }

    public static final class SystemPropertyAccessor implements Function<String, String> {
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(String str) {
            return System.getProperty(str);
        }
    }
}
