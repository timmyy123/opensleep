package com.urbandroid.sleep.functions;

import android.content.Intent;
import androidx.appfunctions.AppFunctionContext;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.alarmclock.AddAlarmActivity;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/functions/AppFunctions;", "", "<init>", "()V", "createAlarm", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroidx/appfunctions/AppFunctionContext;", "hour", "", "minute", "startSleepTracking", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppFunctions {
    public final String createAlarm(AppFunctionContext context, int hour, int minute) {
        context.getClass();
        Intent intent = new Intent(context.getContext(), (Class<?>) AddAlarmActivity.class);
        intent.putExtra("android.intent.extra.alarm.HOUR", hour);
        intent.putExtra("android.intent.extra.alarm.MINUTES", minute);
        intent.putExtra("android.intent.extra.alarm.MESSAGE", "Agent");
        intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        context.getContext().startActivity(intent);
        return "Alarm set for " + hour + ":" + minute;
    }

    public final String startSleepTracking(AppFunctionContext context) {
        context.getClass();
        new SleepStarter().startSleep(context.getContext());
        return "Good night";
    }
}
