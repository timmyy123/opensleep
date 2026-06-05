package com.urbandroid.sleep.activityrecognition;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeSuggestion;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionNotificationService;", "Landroidx/core/app/FixedJobIntentService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "onHandleWork", "(Landroid/content/Intent;)V", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeSuggestionNotificationService extends FixedJobIntentService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String tag = "activity:estimate";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionNotificationService$Companion;", "", "<init>", "()V", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            JobIntentService.enqueueWork(context, (Class<?>) SleepTimeSuggestionNotificationService.class, 31415, intent);
        }

        private Companion() {
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Function0 function0 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Logger.logInfo(Logger.defaultTag, getTag() + ": onHandleWork estimate service", null);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        if (ContextExtKt.getSettings(applicationContext).getSleepTimeSuggestionMode() == SleepTimeSuggestionManager.Mode.DISABLED) {
            return;
        }
        SleepTimeSuggestion sleepTimeSuggestion = new SleepTimeSuggestion();
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        SleepTimeCalculator.Estimate estimateCalculate$default = SleepTimeSuggestion.calculate$default(sleepTimeSuggestion, applicationContext2, SleepTimeCalculator.Companion.lastNightBasicEstimate$default(SleepTimeCalculator.INSTANCE, null, 1, null), null, 4, null);
        int i = 2;
        if (estimateCalculate$default == null) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": no estimate", null);
            Context applicationContext3 = getApplicationContext();
            applicationContext3.getClass();
            SleepTimeSuggestionManager.schedule$default(new SleepTimeSuggestionManager(applicationContext3, function0, i, objArr3 == true ? 1 : 0), null, 1, null);
            return;
        }
        Context applicationContext4 = getApplicationContext();
        applicationContext4.getClass();
        SleepTimeSuggestionManager sleepTimeSuggestionManager = new SleepTimeSuggestionManager(applicationContext4, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        SleepTimeSuggestionManager.Mode sleepTimeSuggestionMode = ContextExtKt.getSettings(this).getSleepTimeSuggestionMode();
        sleepTimeSuggestionMode.getClass();
        SleepTimeSuggestionManager.suggest$default(sleepTimeSuggestionManager, sleepTimeSuggestionMode, false, 2, null);
        Logger.logDebug(Logger.defaultTag, getTag() + ": estimate notification called", null);
    }
}
