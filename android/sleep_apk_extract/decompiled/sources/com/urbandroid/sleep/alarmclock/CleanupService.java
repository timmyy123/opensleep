package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/CleanupService;", "Landroidx/core/app/FixedJobIntentService;", "<init>", "()V", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "onHandleWork", "(Landroid/content/Intent;)V", "Companion", "CleanupTask", "OneTimeSettingsBasedTask", "DeleteWebviewBrowserMetrics", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CleanupService extends FixedJobIntentService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean startRequested = new AtomicBoolean(false);
    private static List<? extends CleanupTask> tasks;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/CleanupService$CleanupTask;", "", "shouldRun", "", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface CleanupTask {
        void run();

        boolean shouldRun();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/CleanupService$Companion;", "", "<init>", "()V", "ACTION_CLEANUP", "", "startRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tasks", "", "Lcom/urbandroid/sleep/alarmclock/CleanupService$CleanupTask;", "getTasks", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "shouldRun", "", "start", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<CleanupTask> getTasks(Context context) {
            context.getClass();
            return CollectionsKt.listOf(new DeleteWebviewBrowserMetrics(context));
        }

        public final boolean shouldRun(Context context) {
            context.getClass();
            List<CleanupTask> tasks = getTasks(context);
            if ((tasks instanceof Collection) && tasks.isEmpty()) {
                return false;
            }
            Iterator<T> it = tasks.iterator();
            while (it.hasNext()) {
                if (((CleanupTask) it.next()).shouldRun()) {
                    return true;
                }
            }
            return false;
        }

        public final void start(Context context) {
            context.getClass();
            Logger.logInfo("CleanupService.start");
            try {
                if (CleanupService.startRequested.getAndSet(true)) {
                    return;
                }
                CleanupService.tasks = getTasks(context);
                List list = CleanupService.tasks;
                Object obj = null;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tasks");
                    list = null;
                }
                Logger.logInfo("CleanupService.tasks " + list.size());
                List list2 = CleanupService.tasks;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tasks");
                    list2 = null;
                }
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((CleanupTask) next).shouldRun()) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    Logger.logInfo("CleanupService.start: no tasks");
                } else {
                    JobIntentService.enqueueWork(context, (Class<?>) CleanupService.class, 670, new Intent("com.urbandroid.sleep.alarmclock.ACTION_CLEANUP"));
                    Logger.logInfo("CleanupService.start: work scheduled");
                }
            } catch (RuntimeException e) {
                Logger.logSevere("CleanupService.start", e);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/CleanupService$DeleteWebviewBrowserMetrics;", "Lcom/urbandroid/sleep/alarmclock/CleanupService$OneTimeSettingsBasedTask;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "shouldRun", "", "doRun", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DeleteWebviewBrowserMetrics extends OneTimeSettingsBasedTask {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteWebviewBrowserMetrics(Context context) {
            super(context, "cleanup_webview");
            context.getClass();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean doRun$lambda$0(File file, String str) {
            str.getClass();
            return StringsKt.startsWith$default(str, "BrowserMetrics") && StringsKt__StringsJVMKt.endsWith$default(str, "pma", false, 2, null);
        }

        @Override // com.urbandroid.sleep.alarmclock.CleanupService.OneTimeSettingsBasedTask
        public void doRun() {
            File parentFile = getContext().getFilesDir().getParentFile();
            Logger.logInfo("CleanupService: webview parent " + parentFile);
            if (parentFile == null) {
                Types$$ExternalSyntheticBUOutline0.m$2("getExternalFilesDir returned null");
                return;
            }
            File file = new File(FileInsert$$ExternalSyntheticOutline0.m$1(parentFile.getAbsolutePath(), "/app_webview/BrowserMetrics/"));
            Logger.logInfo("CleanupService: webview dir " + file + " exists " + file.exists());
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new CleanupService$DeleteWebviewBrowserMetrics$$ExternalSyntheticLambda0());
                if (fileArrListFiles == null) {
                    Types$$ExternalSyntheticBUOutline0.m$2("listFiles returned null");
                    return;
                }
                zza$$ExternalSyntheticOutline0.m(fileArrListFiles.length, "CleanupService: webview size ");
                for (File file2 : fileArrListFiles) {
                    Logger.logInfo("CleanupService: webview deleting " + file2.getName());
                    file2.delete();
                }
            }
        }

        @Override // com.urbandroid.sleep.alarmclock.CleanupService.OneTimeSettingsBasedTask, com.urbandroid.sleep.alarmclock.CleanupService.CleanupTask
        public boolean shouldRun() {
            return super.shouldRun();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/CleanupService$OneTimeSettingsBasedTask;", "Lcom/urbandroid/sleep/alarmclock/CleanupService$CleanupTask;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "alreadyExecutedSettingsKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "shouldRun", "()Z", "", "run", "()V", "doRun", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getAlreadyExecutedSettingsKey", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/service/Settings;", "kotlin.jvm.PlatformType", "settings", "Lcom/urbandroid/sleep/service/Settings;", "getSettings", "()Lcom/urbandroid/sleep/service/Settings;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class OneTimeSettingsBasedTask implements CleanupTask {
        private final String alreadyExecutedSettingsKey;
        private final Context context;
        private final Settings settings;

        public OneTimeSettingsBasedTask(Context context, String str) {
            context.getClass();
            str.getClass();
            this.context = context;
            this.alreadyExecutedSettingsKey = str;
            this.settings = Settings.from(context);
        }

        public abstract void doRun();

        public final Context getContext() {
            return this.context;
        }

        @Override // com.urbandroid.sleep.alarmclock.CleanupService.CleanupTask
        public void run() {
            try {
                if (shouldRun()) {
                    Logger.logInfo("CleanupService: run task: " + this.alreadyExecutedSettingsKey);
                    doRun();
                    this.settings.save(this.alreadyExecutedSettingsKey, true);
                }
            } catch (RuntimeException e) {
                Logger.logSevere("CleanupService: run task: " + this.alreadyExecutedSettingsKey, e);
            }
        }

        @Override // com.urbandroid.sleep.alarmclock.CleanupService.CleanupTask
        public boolean shouldRun() {
            return !this.settings.getPrefBoolean(this.alreadyExecutedSettingsKey, false);
        }
    }

    public static final boolean shouldRun(Context context) {
        return INSTANCE.shouldRun(context);
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        Logger.logInfo("CleanupService.onHandleWork");
        try {
            List<? extends CleanupTask> list = tasks;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tasks");
                list = null;
            }
            for (CleanupTask cleanupTask : list) {
                if (cleanupTask.shouldRun()) {
                    cleanupTask.run();
                }
            }
        } catch (RuntimeException e) {
            Logger.logSevere("CleanupService.onHandleWork", e);
        }
    }
}
