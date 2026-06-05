package com.urbandroid.sleep.appwidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline0;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.StartShortcutActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class SleepWidget extends AppWidgetProvider {
    public static String ACTION_REFRESH = "com.urbandroid.sleep.appwidget.SleepWidget.ACTION_REFRESH";
    public static int UPDATE_FREQUENCY_SEC = 300;
    private static Paint p;
    private Settings settings;

    static {
        Paint paint = new Paint();
        p = paint;
        paint.setAntiAlias(true);
        p.setDither(true);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10.0f);
    }

    private PendingIntentBuilder alarmIntent(Context context) {
        return PendingIntentBuilder.get(context, 0, new Intent(ACTION_REFRESH), 134217728);
    }

    public static Bitmap drawBg(Context context, int i, long j) {
        ActivityUtils.getDip(context, 36);
        int dip = ActivityUtils.getDip(context, 12);
        int dip2 = ActivityUtils.getDip(context, 8);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(360, 360, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        p.setStrokeWidth(dip2);
        if (j > 0) {
            p.setColor(ContextCompat.getColor(context, R.color.tint));
            if (j > 360) {
                p.setColor(ContextCompat.getColor(context, R.color.negative));
            }
            p.setStyle(Paint.Style.STROKE);
            float f = dip;
            float f2 = 360 - dip;
            canvas.drawArc(new RectF(f, f, f2, f2), 0.0f, j, false, p);
        }
        return bitmapCreateBitmap;
    }

    private void refreshWidget(Context context) {
        ComponentName componentName = new ComponentName(context.getApplicationContext(), (Class<?>) SleepWidget.class);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context.getApplicationContext());
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_sleep);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.widget_sleep_big);
        updateViews(context, remoteViews);
        updateViews(context, remoteViews2);
        HashMap map = new HashMap();
        map.put(new SizeF(80.0f, 40.0f), remoteViews2);
        map.put(new SizeF(40.0f, 40.0f), remoteViews);
        if (Build.VERSION.SDK_INT >= 31) {
            remoteViews = TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(map);
        }
        appWidgetManager.updateAppWidget(componentName, remoteViews);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        long jElapsedRealtime = SystemClock.elapsedRealtime() + ((long) (UPDATE_FREQUENCY_SEC * 1000));
        PendingIntent explicitBroadcast = alarmIntent(context).getExplicitBroadcast();
        alarmManager.cancel(explicitBroadcast);
        alarmManager.setRepeating(3, jElapsedRealtime, UPDATE_FREQUENCY_SEC * 1000, explicitBroadcast);
    }

    private void updateViews(Context context, RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT > 24) {
            remoteViews.setOnClickPendingIntent(R.id.main, PendingIntentBuilder.get(context.getApplicationContext(), -4892, new Intent("com.urbandroid.sleep.ACTION_START_SLEEP_TRACK_FROM_ACTIVITY", null, context, StartShortcutActivity.class), 134217728).getActivity());
        } else {
            Intent intent = new Intent();
            intent.setAction("com.urbandroid.sleep.alarmclock.START_SLEEP_WIDGET_TRACK");
            remoteViews.setOnClickPendingIntent(R.id.main, PendingIntentBuilder.get(context.getApplicationContext(), -4892, intent, 134217728).getExplicitBroadcast());
        }
        if (this.settings == null) {
            this.settings = new Settings(context);
        }
        Date nextTimeToBed = this.settings.getNextTimeToBed();
        Date nextAlarm = this.settings.getNextAlarm();
        if (nextTimeToBed == null || nextAlarm == null || SleepService.isRunning()) {
            remoteViews.setImageViewResource(R.id.zombie, R.drawable.empty_ab);
        } else {
            if ((1.0f - ((nextTimeToBed.getTime() - System.currentTimeMillis()) / 1.44E7f)) * 360.0f < 720.0f) {
                remoteViews.setImageViewBitmap(R.id.zombie, drawBg(context, context.getResources().getColor(R.color.tint_dark), Math.round(r0)));
            } else {
                remoteViews.setImageViewResource(R.id.zombie, R.drawable.empty_ab);
            }
        }
        if (SleepService.isRunning()) {
            remoteViews.setImageViewResource(R.id.image, R.drawable.ic_action_graph_1);
        } else {
            remoteViews.setImageViewResource(R.id.image, R.drawable.ic_action_track);
        }
    }

    public void cancel(Context context) {
        alarmIntent(context).cancelAlarmBroadcast();
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
        if (DroidWidget.widgetsInstalled(context, getClass()) != 0) {
            if (intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_STATE_CHANGE") || intent.getAction().equals(ACTION_REFRESH) || intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE") || intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED")) {
                refreshWidget(context);
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        if (context == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context, true);
        refreshWidget(context);
    }
}
