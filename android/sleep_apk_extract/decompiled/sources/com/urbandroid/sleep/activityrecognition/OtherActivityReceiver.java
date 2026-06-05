package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/OtherActivityReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OtherActivityReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context);
        SleepTimeSuggestionManager.Mode sleepTimeSuggestionMode = ContextExtKt.getSettings(context).getSleepTimeSuggestionMode();
        sleepTimeSuggestionMode.getClass();
        final String str = "activity";
        final boolean z = false;
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.activityrecognition.OtherActivityReceiver$onReceive$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str2 = str;
                boolean z2 = z;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                String strConcat = "";
                if (z2) {
                    String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                    if (strM == null) {
                        strConcat = null;
                    } else if (!StringsKt.isBlank(strM)) {
                        strConcat = ":".concat(strM);
                    }
                }
                sbM.append(strConcat);
                return sbM.toString();
            }
        };
        Logger.logDebug("UnsafeProtectedBroadcastReceiver: mode=" + sleepTimeSuggestionMode);
        if (sleepTimeSuggestionMode == SleepTimeSuggestionManager.Mode.DISABLED) {
            return;
        }
        String strM = FileInsert$$ExternalSyntheticOutline0.m("OtherActivityReceiver: intent ", intent.getAction());
        Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
        Intent intent2 = new Intent("com.urbandroid.sleep.activityrecognition.ACTION_OTHER_ACTIVITY_DETECTED");
        intent2.putExtra("timestamp", SystemClock.elapsedRealtime());
        intent2.putExtra("if_still_only", true);
        DetectedTransitionIntentService.INSTANCE.start(context, intent2);
    }
}
