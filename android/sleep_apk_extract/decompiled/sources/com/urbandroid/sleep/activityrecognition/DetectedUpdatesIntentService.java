package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/DetectedUpdatesIntentService;", "Landroidx/core/app/FixedJobIntentService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$1", "onHandleWork", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DetectedUpdatesIntentService extends FixedJobIntentService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final String tag;

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/DetectedUpdatesIntentService$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return DetectedUpdatesIntentService.tag;
        }

        public final void start(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            JobIntentService.enqueueWork(context, (Class<?>) DetectedUpdatesIntentService.class, 669, intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        StringBuilder sb = new StringBuilder("activity");
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        sb.append(strM != null ? StringsKt.isBlank(strM) ? "" : ":".concat(strM) : null);
        tag = sb.toString();
    }

    public DetectedUpdatesIntentService() {
        StringBuilder sb = new StringBuilder("activity");
        String strConcat = null;
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        if (strM != null) {
            strConcat = StringsKt.isBlank(strM) ? "" : ":".concat(strM);
        }
        sb.append(strConcat);
        this.tag = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onHandleWork$lambda$0(Intent intent, DetectedUpdatesIntentService detectedUpdatesIntentService) {
        int intExtra = intent.getIntExtra("confidence", 0);
        String strM = FileInsert$$ExternalSyntheticOutline0.m(intExtra, "confidence=");
        Logger.logDebug(Logger.defaultTag, detectedUpdatesIntentService.getTag() + ": " + strM, null);
        if (intExtra > 0) {
            try {
                Context applicationContext = detectedUpdatesIntentService.getApplicationContext();
                applicationContext.getClass();
                ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
                ReentrantLock lock = companion.getLOCK();
                lock.lock();
                try {
                    File storageFile = companion.getStorageFile(applicationContext);
                    ActivityIntervals activityIntervalsFrom = companion.from(storageFile);
                    activityIntervalsFrom.add(new ActivityTransitionEvent(3, 1, (SystemClock.elapsedRealtime() - Utils.getSecondsInMillis(30)) * 1000000));
                    activityIntervalsFrom.add(new ActivityTransitionEvent(3, 0, SystemClock.elapsedRealtime() * 1000000));
                    activityIntervalsFrom.export(storageFile);
                    lock.unlock();
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, detectedUpdatesIntentService.getTag() + ": adding interval failed", e);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        ActivitityrecognitionKt.whenActivityRecognitionNeeded(applicationContext, new Url$$ExternalSyntheticLambda1(intent, this, 4));
    }
}
