package com.urbandroid.sleep.service.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ComponentUtil;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.addon.taskerplugin.TaskerPlugin;
import com.urbandroid.sleep.addon.taskerplugin.ui.EditEventActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationReceiver;", "Lcom/urbandroid/common/LoggingReceiver;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "tag", "", "getTag", "()Ljava/lang/String;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutomationReceiver extends LoggingReceiver implements FeatureLogger, CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final String tag;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationReceiver$Companion;", "", "<init>", "()V", "setEnabled", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "enable", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setEnabled(Context context, boolean enable) {
            context.getClass();
            ComponentUtil.setEnabled(context, AutomationReceiver.class, enable);
        }

        private Companion() {
        }
    }

    public AutomationReceiver() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getIO().plus(completableJobSupervisorJob$default).plus(new AutomationReceiver$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        this.tag = "automation";
    }

    public static final void setEnabled(Context context, boolean z) {
        INSTANCE.setEnabled(context, z);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (context == null || intent == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 27 && ContextExtKt.getSettings(context).isGoogleHomeAutomation()) {
            if (Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT")) {
                String googleHomeAutomationId = ContextExtKt.getSettings(context).getGoogleHomeAutomationId("settings_google_home_automation_bedtime");
                Logger.logInfo("Home: automation " + intent.getAction() + " " + googleHomeAutomationId);
                if (googleHomeAutomationId != null) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new AutomationReceiver$onReceive$1$1(context, googleHomeAutomationId, null), 3, null);
                }
            } else if (Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.alarmclock.ALARM_ALERT_START")) {
                String googleHomeAutomationId2 = ContextExtKt.getSettings(context).getGoogleHomeAutomationId("settings_google_home_automation_alarm");
                Logger.logInfo("Home: automation " + intent.getAction() + " " + googleHomeAutomationId2);
                if (googleHomeAutomationId2 != null) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new AutomationReceiver$onReceive$2$1(context, googleHomeAutomationId2, null), 3, null);
                }
            } else if (Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED")) {
                String googleHomeAutomationId3 = ContextExtKt.getSettings(context).getGoogleHomeAutomationId("settings_google_home_automation_wake_up");
                Logger.logInfo("Home: automation " + intent.getAction() + " " + googleHomeAutomationId3);
                if (googleHomeAutomationId3 != null) {
                    BuildersKt__Builders_commonKt.launch$default(this, null, null, new AutomationReceiver$onReceive$3$1(context, googleHomeAutomationId3, null), 3, null);
                }
            }
        }
        if (!ContextExtKt.getSettings(context).getAutomationEvents().contains(intent.getAction())) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("event not enabled ", intent.getAction());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            return;
        }
        if (Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT") && SleepService.isRunning()) {
            String strM2 = FileInsert$$ExternalSyntheticOutline0.m("ignoring bedtime automation event because tracking running ", intent.getAction());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
            return;
        }
        if (ContextExtKt.getSettings(context).isIntentApi() && (action = intent.getAction()) != null && !StringsKt__StringsJVMKt.endsWith$default(action, "_AUTO", false, 2, null)) {
            String strM3 = FileInsert$$ExternalSyntheticOutline0.m("broadcast ", action, "_AUTO");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM3, null);
            context.sendBroadcast(new Intent(action.concat("_AUTO")));
        }
        if (ContextExtKt.getSettings(context).isTasker()) {
            Intent intentPutExtra = new Intent("com.twofortyfouram.locale.intent.action.REQUEST_QUERY").putExtra("com.twofortyfouram.locale.intent.extra.ACTIVITY", EditEventActivity.class.getName());
            intentPutExtra.getClass();
            TaskerPlugin.Event.addPassThroughMessageID(intentPutExtra);
            TaskerPlugin.Event.retrievePassThroughData(intentPutExtra).putString("sleep_action", intent.getAction());
            String[] strArr = ContextExtKt.PACKAGES_TASKER;
            ContextExtKt.sendExplicitBroadcast(context, intentPutExtra, (String[]) Arrays.copyOf(strArr, strArr.length));
            String strM4 = FileInsert$$ExternalSyntheticOutline0.m("Send broadcast to Tasker for action: ", intent.getAction());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM4, null);
        }
        if (AutomationTrigger.INSTANCE.getEnabledTriggersOrNull(context) != null) {
            Intent intent2 = new Intent(context, (Class<?>) AutomationService.class);
            intent2.setAction(intent.getAction());
            intent2.putExtras(intent);
            ContextExtKt.startForegroundServiceWithLog(context, intent2);
        }
    }
}
