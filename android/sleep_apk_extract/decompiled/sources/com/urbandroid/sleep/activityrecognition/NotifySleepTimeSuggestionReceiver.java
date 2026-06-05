package com.urbandroid.sleep.activityrecognition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/NotifySleepTimeSuggestionReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NotifySleepTimeSuggestionReceiver extends BroadcastReceiver implements FeatureLogger {
    private final String tag = "activity:estimate";

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context);
        SleepTimeSuggestionManager.Mode sleepTimeSuggestionMode = ContextExtKt.getSettings(context).getSleepTimeSuggestionMode();
        sleepTimeSuggestionMode.getClass();
        String str = Logger.defaultTag;
        Logger.logDebug(str, getTag() + ": " + ("NotifySleepTimeSuggestionReceiver: mode=" + sleepTimeSuggestionMode), null);
        if (sleepTimeSuggestionMode == SleepTimeSuggestionManager.Mode.DISABLED) {
            return;
        }
        SleepTimeSuggestionNotificationService.INSTANCE.start(context, new Intent());
        Logger.logDebug(Logger.defaultTag, getTag() + ": estimate notification called", null);
    }
}
