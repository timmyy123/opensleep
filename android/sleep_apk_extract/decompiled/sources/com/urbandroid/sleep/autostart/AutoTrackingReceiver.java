package com.urbandroid.sleep.autostart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivitityrecognitionKt;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.WakefulForegroundBroadcastReceiver;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingReceiver;", "Lcom/urbandroid/sleep/service/WakefulForegroundBroadcastReceiver;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoTrackingReceiver extends WakefulForegroundBroadcastReceiver implements FeatureLogger {
    private final String tag = "AutoTracking:Receiver";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onReceive$lambda$0(Context context, ExpectedTrackingRange expectedTrackingRange) {
        if (ContextExtKt.getSettings(context).getAutoStartMode() == 1) {
            ActivityRecognitionInitializer.INSTANCE.updates(context).initialize(30);
            WakefulForegroundBroadcastReceiver.Companion companion = WakefulForegroundBroadcastReceiver.INSTANCE;
            Intent intent = new Intent(context, (Class<?>) AutoTrackingService.class);
            expectedTrackingRange.putInto(intent);
            Unit unit = Unit.INSTANCE;
            companion.startWakefulService(context, intent);
        }
        return Unit.INSTANCE;
    }

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
        String strM = FileInsert$$ExternalSyntheticOutline0.m("intent=", intent != null ? ContextExtKt.stringify$default(intent, null, 1, null) : null);
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        if (intent == null) {
            return;
        }
        ExpectedTrackingRange expectedTrackingRangeFrom = ExpectedTrackingRange.INSTANCE.from(intent);
        if (expectedTrackingRangeFrom != null) {
            ActivitityrecognitionKt.whenActivityRecognitionNeeded(context, new Url$$ExternalSyntheticLambda1(context, expectedTrackingRangeFrom, 5));
            return;
        }
        String strM2 = FileInsert$$ExternalSyntheticOutline0.m("Can not extract range from intent=", ContextExtKt.stringify$default(intent, null, 1, null));
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM2, null);
    }
}
