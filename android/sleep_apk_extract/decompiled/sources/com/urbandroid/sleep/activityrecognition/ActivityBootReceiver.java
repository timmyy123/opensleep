package com.urbandroid.sleep.activityrecognition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import io.rebble.pebblekit2.client.DefaultPebbleAndroidAppPicker$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityBootReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActivityBootReceiver extends BroadcastReceiver implements FeatureLogger {
    private final String tag;

    public ActivityBootReceiver() {
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
    public static final Unit onReceive$lambda$0(Context context) {
        ActivityRecognitionInitializer.INSTANCE.transitions(context).initialize();
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
        Logger.logInfo(Logger.defaultTag, getTag() + ": initialize ...", null);
        ActivitityrecognitionKt.whenActivityRecognitionNeeded(context, new DefaultPebbleAndroidAppPicker$$ExternalSyntheticLambda0(context, 1));
    }
}
