package com.urbandroid.sleep.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline0;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmWidget extends AppWidgetProvider {
    private Settings settings;

    public static Bitmap drawBg(int i, int i2, int i3) {
        Paint paint = new Paint();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(240, 30, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        paint.setStyle(Paint.Style.FILL);
        for (int i4 = 0; i4 < 7; i4++) {
            if (i3 == i4) {
                paint.setColor(i);
                canvas.drawCircle((i4 * 34.285713f) + 17.142857f, 15.0f, 15.0f, paint);
            } else {
                paint.setColor(i2);
                canvas.drawCircle((i4 * 34.285713f) + 17.142857f, 15.0f, 7.5f, paint);
            }
        }
        return bitmapCreateBitmap;
    }

    private int getDayColor(Calendar calendar) {
        switch (calendar.get(7)) {
            case 1:
                return Color.parseColor("#009688");
            case 2:
                return Color.parseColor("#F44336");
            case 3:
                return Color.parseColor("#FF5722");
            case 4:
                return Color.parseColor("#FB8C00");
            case 5:
                return Color.parseColor("#FFA000");
            case 6:
                return Color.parseColor("#8BC34A");
            case 7:
                return Color.parseColor("#4CAF50");
            default:
                return -1;
        }
    }

    private int getDayIndex(Context context, Calendar calendar) {
        int[] weekDayPositionIndex = Alarm.DaysOfWeek.getWeekDayPositionIndex(context);
        int[] iArr = {2, 3, 4, 5, 6, 7, 1};
        int i = calendar.get(7);
        for (int i2 = 0; i2 < weekDayPositionIndex.length; i2++) {
            if (iArr[weekDayPositionIndex[i2]] == i) {
                return i2;
            }
        }
        return 0;
    }

    private void refreshWidget(Context context) {
        ComponentName componentName = new ComponentName(context.getApplicationContext(), (Class<?>) AlarmWidget.class);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context.getApplicationContext());
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_alarm);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.widget_alarm_med);
        RemoteViews remoteViews3 = new RemoteViews(context.getPackageName(), R.layout.widget_alarm_big);
        updateViews(context, remoteViews3);
        updateViews(context, remoteViews2);
        updateViews(context, remoteViews);
        HashMap map = new HashMap();
        map.put(new SizeF(120.0f, 40.0f), remoteViews2);
        map.put(new SizeF(80.0f, 40.0f), remoteViews2);
        map.put(new SizeF(40.0f, 40.0f), remoteViews);
        map.put(new SizeF(40.0f, 80.0f), remoteViews3);
        map.put(new SizeF(40.0f, 120.0f), remoteViews3);
        map.put(new SizeF(80.0f, 80.0f), remoteViews3);
        map.put(new SizeF(80.0f, 120.0f), remoteViews3);
        if (Build.VERSION.SDK_INT >= 31) {
            remoteViews = TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(map);
        }
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    private void updateViews(Context context, RemoteViews remoteViews) {
        if (this.settings == null) {
            this.settings = new Settings(context);
        }
        Date nextAlarm = this.settings.getNextAlarm();
        remoteViews.setViewVisibility(R.id.icon, 8);
        Intent intent = new Intent(context, (Class<?>) AlarmActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.addFlags(67108864);
        intent.putExtra("back_to_dashboard", true);
        if (nextAlarm != null) {
            if (nextAlarm.getTime() - System.currentTimeMillis() > TimeChart.DAY) {
                remoteViews.setTextViewText(R.id.alarm, DateUtil.formatTimeShort(context, nextAlarm.getTime()));
                remoteViews.setTextViewText(R.id.day, DateUtil.formatDay(nextAlarm.getTime()).toUpperCase());
            } else {
                remoteViews.setTextViewText(R.id.alarm, DateUtil.formatTimeShort(context, nextAlarm.getTime()));
                remoteViews.setTextViewText(R.id.day, "");
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_alarm);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(nextAlarm.getTime());
            remoteViews.setImageViewBitmap(R.id.zombie, drawBg(getDayColor(calendar), ColorUtil.i(context, R.color.shadow_invert), getDayIndex(context, calendar)));
        } else {
            remoteViews.setTextViewText(R.id.alarm, "...");
            remoteViews.setTextViewText(R.id.day, "");
            remoteViews.setImageViewResource(R.id.zombie, R.drawable.empty_ab);
            remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_alarm_x);
            remoteViews.setViewVisibility(R.id.icon, 0);
            intent = new Intent(context, (Class<?>) AlarmActivity.class);
        }
        remoteViews.setOnClickPendingIntent(R.id.main, PendingIntentBuilder.get(context, 0, intent, 0).getActivity());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
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
            if (intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_STATE_CHANGE") || intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED") || intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE")) {
                refreshWidget(context);
            }
        }
    }
}
