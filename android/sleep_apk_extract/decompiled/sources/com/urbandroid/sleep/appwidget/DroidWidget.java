package com.urbandroid.sleep.appwidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.Bedtime;
import com.urbandroid.sleep.service.Settings;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DroidWidget extends AppWidgetProvider {
    public static String ACTION_REFRESH = "com.urbandroid.sleep.appwidget.DroidWidget.ACTION_REFRESH";
    public static int UPDATE_FREQUENCY_SEC = 120;
    private Settings settings;

    private PendingIntentBuilder alarmIntent(Context context) {
        Intent intent = new Intent(ACTION_REFRESH);
        intent.setPackage(context.getPackageName());
        return PendingIntentBuilder.get(context, 0, intent, 134217728);
    }

    private void initViews(Context context, RemoteViews remoteViews) {
        if (this.settings == null) {
            this.settings = new Settings(context);
        }
        new Bedtime(this.settings.getNextTimeToBed(), this.settings.getNextAlarm()).updateTime(context, null, remoteViews);
        remoteViews.setOnClickPendingIntent(R.id.droid_icon, PendingIntentBuilder.get(context, getRequestCode(), new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setComponent(new ComponentName(context.getPackageName(), AlarmClock.class.getName())), 0).getActivity());
    }

    public static void refresh(Context context) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    private void refreshWidget(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_droid);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.widget_droid_landscape);
        RemoteViews remoteViews3 = new RemoteViews(context.getPackageName(), R.layout.widget_droid_portrait);
        RemoteViews remoteViews4 = new RemoteViews(context.getPackageName(), R.layout.widget_droid_legacy);
        HashMap map = new HashMap();
        map.put(new SizeF(120.0f, 40.0f), remoteViews2);
        map.put(new SizeF(80.0f, 40.0f), remoteViews2);
        map.put(new SizeF(40.0f, 40.0f), remoteViews);
        map.put(new SizeF(40.0f, 80.0f), remoteViews);
        map.put(new SizeF(40.0f, 120.0f), remoteViews3);
        map.put(new SizeF(80.0f, 80.0f), remoteViews3);
        map.put(new SizeF(80.0f, 120.0f), remoteViews3);
        if (Build.VERSION.SDK_INT >= 31) {
            remoteViews4 = TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(map);
            initViews(context, remoteViews);
            initViews(context, remoteViews2);
            initViews(context, remoteViews3);
        } else {
            initViews(context, remoteViews4);
        }
        AppWidgetManager.getInstance(context.getApplicationContext()).updateAppWidget(new ComponentName(context.getApplicationContext(), getClass()), remoteViews4);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent explicitBroadcast = alarmIntent(context).getExplicitBroadcast();
        if (explicitBroadcast != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() + ((long) (UPDATE_FREQUENCY_SEC * 1000));
            alarmManager.cancel(explicitBroadcast);
            alarmManager.setRepeating(3, jElapsedRealtime, UPDATE_FREQUENCY_SEC * 1000, explicitBroadcast);
        }
    }

    public static int widgetsInstalled(Context context, Class cls) {
        if (context != null && context.getResources() != null) {
            try {
                return AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) cls)).length;
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return 0;
    }

    public void cancel(Context context) {
        alarmIntent(context).cancelAlarmBroadcast();
    }

    public int getRequestCode() {
        return -312413242;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        if (context == null) {
            return;
        }
        cancel(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        if (context == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context, true);
        refreshWidget(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (context == null || intent == null || intent.getAction() == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context, true);
        if (widgetsInstalled(context, getClass()) != 0) {
            if (intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_STATE_CHANGE") || intent.getAction().equals(ACTION_REFRESH) || intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE") || intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED")) {
                refreshWidget(context);
            }
        }
    }
}
